/*
 * Seed factory per Randoop — Fase 3 (Generazione Automatica).
 *
 * NON è una classe di test (nessun @Test). Il suo unico scopo è dare a
 * Randoop un modo per costruire CommandLogic senza usare il costruttore
 * reale a parametri null: CommandLogic(ImplementationDAO, Validator) ha
 * entrambi i parametri di tipo interfaccia, quindi lasciato a se stesso
 * Randoop li passerebbe a null e ogni test degenererebbe in un
 * NullPointerException al primo utilizzo del campo (verificato sul
 * codice del collega: RandoopBeforeFilterDefaultMappingManagerTest,
 * stesso pattern su una classe con costruttore altrettanto iniettato).
 *
 * Destinazione nel progetto:
 * core/idrepo/logic/src/test/java/org/apache/syncope/core/logic/randoop/
 */
package org.apache.syncope.core.logic.randoop;

import jakarta.validation.Validator;
import org.apache.syncope.core.logic.CommandLogic;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.mockito.Mockito;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public final class CommandLogicRandoopSeeds {

    private CommandLogicRandoopSeeds() {
    }

    /**
     * Producer per Randoop: costruisce un CommandLogic con dipendenze
     * mockate (non null), cosi' i metodi search()/run() vengono
     * effettivamente esercitati invece di fallire subito.
     */
    public static CommandLogic build() {
        ImplementationDAO implementationDAO = Mockito.mock(ImplementationDAO.class);
        Validator validator = Mockito.mock(Validator.class);
        return new CommandLogic(implementationDAO, validator);
    }

    /**
     * Producer per Randoop: Pageable è un'interfaccia, Randoop non la
     * costruisce da solo. PageRequest è l'implementazione concreta di
     * Spring Data, con un metodo factory statico riutilizzabile.
     */
    public static Pageable pageable() {
        return PageRequest.of(0, 10);
    }
}