/*
 * Fase 3 — Generazione Automatica (Randoop), suite curata.
 *
 * Selezione manuale da CommandLogicRandoopRaw0.java (199 sequenze
 * generate, time-limit=60s, 5 agosto 2026, JDK 25 / Randoop 4.3.4).
 * I test qui sotto riscrivono in stile JUnit5 comportamento REALE
 * osservato nell'output grezzo (non riscritti da zero): CommandLogic
 * costruita via CommandLogicRandoopSeeds, dipendenze mockate non-null.
 *
 * Sequenze escluse dalla cura: quelle in cui Randoop passa null a
 * Pageable/CommandTO nonostante esista un producer alternativo (test005-
 * 007 del grezzo) — mostrano solo l'assenza di un null-check esplicito
 * sui parametri, poco informativo, ridondante tra loro.
 *
 * Output grezzo completo conservato come evidenza in:
 * docs/randoop-raw/CommandLogicRandoopRaw0.java
 */
package org.apache.syncope.core.logic.randoop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.syncope.common.lib.command.CommandTO;
import org.apache.syncope.core.logic.CommandLogic;
import org.apache.syncope.core.persistence.api.dao.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

class CommandLogicRandoopTest {

    // RT1 — run(): CommandTO senza chiave (mai impostata, quindi null di
    // default). run() esegue il lookup reale via implementationDAO (mock,
    // Optional.empty() di default) e propaga NotFoundException con
    // messaggio parametrico sulla chiave — comportamento di dominio
    // reale osservato da Randoop, non un crash tecnico da dipendenza
    // mancante. (corrisponde a test008 del grezzo)
    @Test
    void runWithoutKeyThrowsNotFoundWithNullInMessage() {
        CommandLogic commandLogic = CommandLogicRandoopSeeds.build();
        CommandTO commandTO = new CommandTO();

        NotFoundException ex = assertThrows(NotFoundException.class,
                () -> commandLogic.run(commandTO));
        assertEquals("Implementation null", ex.getMessage());
    }

    // RT2 — run(): CommandTO con chiave esplicitamente vuota (""). Stesso
    // ramo di RT1, ma dimostra che il messaggio dell'eccezione incorpora
    // davvero il valore della chiave passata (non è una stringa fissa) —
    // Randoop lo ha scoperto esplorando valori di stringa diversi.
    // (corrisponde a test022 del grezzo)
    @Test
    void runWithEmptyKeyThrowsNotFoundWithEmptyKeyInMessage() {
        CommandLogic commandLogic = CommandLogicRandoopSeeds.build();
        CommandTO commandTO = new CommandTO();
        commandTO.setKey("");

        NotFoundException ex = assertThrows(NotFoundException.class,
                () -> commandLogic.run(commandTO));
        assertEquals("Implementation ", ex.getMessage());
    }

    // RT3 — search(): con keyword e Pageable reali, non degenera mai in
    // eccezione o null. Con implementationDAO mockato e non stubbato,
    // Mockito ritorna per default una lista vuota (comportamento
    // documentato di Mockito, non un'assunzione nostra), quindi la Page
    // risultante è sempre vuota — poco informativo sul contenuto, ma
    // conferma la robustezza del metodo rispetto a input arbitrari.
    @Test
    void searchWithArbitraryKeywordReturnsNonNullEmptyPage() {
        CommandLogic commandLogic = CommandLogicRandoopSeeds.build();
        Pageable pageable = PageRequest.of(0, 10);

        Page<CommandTO> page = commandLogic.search("hi!", pageable);

        assertNotNull(page);
        assertEquals(0, page.getTotalElements());
    }
}