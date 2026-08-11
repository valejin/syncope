/*
 * Fase 3 — Generazione Automatica (Randoop), suite curata.
 *
 * Selezione manuale da NotificationDataBinderImplRandoopRaw0.java (209
 * sequenze di regressione) + ErrorTest0.java (1 error-revealing test),
 * time-limit=60s, 5 agosto 2026, JDK 25 / Randoop 4.3.4.
 *
 * Output grezzo completo conservato come evidenza in:
 * docs/randoop-raw/NotificationDataBinderImplRandoopRaw0.java
 * docs/randoop-raw/ErrorTest0.java
 */
package org.apache.syncope.core.provisioning.java.data.randoop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.to.NotificationTO;
import org.apache.syncope.core.persistence.api.entity.Notification;
import org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl;
import org.junit.jupiter.api.Test;

class NotificationDataBinderImplRandoopTest {

    // RT1 — update(): NotificationTO vuoto (nessun campo impostato).
    // update() valida esplicitamente i campi obbligatori PRIMA di
    // toccare la persistenza — comportamento robusto e indipendente dal
    // mock, riproducibile con qualunque NotificationTO realmente
    // incompleto. (corrisponde a test001/test013 del grezzo)
    @Test
    void updateWithEmptyToThrowsRequiredValuesMissing() {
        NotificationDataBinderImpl binder = NotificationDataBinderImplRandoopSeeds.build();
        Notification notification = NotificationDataBinderImplRandoopSeeds.notification();
        NotificationTO notificationTO = new NotificationTO();

        SyncopeClientException ex = assertThrows(SyncopeClientException.class,
                () -> binder.update(notification, notificationTO));
        assertEquals("RequiredValuesMissing [template, events]", ex.getMessage());
    }

    // RT2 — update(): NotificationTO con template impostato a un valore
    // NON vuoto ("hi!"), ma "template" compare comunque tra i campi
    // mancanti. Verificato sul sorgente (NotificationDataBinderImpl.java,
    // update()): il controllo non è "stringa vuota" ma risoluzione via
    // mailTemplateDAO.findById(...).orElse(null) — "template" viene
    // aggiunto alla lista se e solo se la chiave non risolve a un
    // MailTemplate esistente. Comportamento genuino e riproducibile
    // identico con un DAO reale e una chiave inesistente: NON è un
    // artefatto del mock non stubbato. Nota anche che update() non
    // fallisce al primo controllo: accumula tutti i campi mancanti
    // (template, events, staticRecipients non validi) e lancia
    // un'unica eccezione con l'elenco completo alla fine.
    // (corrisponde a test012 del grezzo)
    @Test
    void updateWithNonExistentTemplateKeyReportsTemplateMissing() {
        NotificationDataBinderImpl binder = NotificationDataBinderImplRandoopSeeds.build();
        Notification notification = NotificationDataBinderImplRandoopSeeds.notification();
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("hi!");

        SyncopeClientException ex = assertThrows(SyncopeClientException.class,
                () -> binder.update(notification, notificationTO));
        assertEquals("RequiredValuesMissing [template, events]", ex.getMessage());
    }

    // RT3 — getNotificationTO(): con un Notification mockato "nudo"
    // (nessuno stub), getTemplate() ritorna null e il metodo fallisce
    // con NPE alla prima chiamata a catena (.getTemplate().getKey()),
    // NotificationDataBinderImpl.java:74.
    // NON è un difetto funzionale: JPANotification.template è annotato
    // @ManyToOne(fetch = FetchType.EAGER, optional = false) — su
    // un'istanza realmente persistita questo stato non è raggiungibile,
    // il vincolo è garantito da JPA/DB (confermato sul sorgente reale).
    // Test tenuto come documentazione dell'invariante implicita che il
    // metodo assume ma non verifica localmente — rilevante per la
    // sezione metodologica del report, ESCLUSO dal calcolo di
    // reliability (punto 4.c) perché non rientra nel profilo
    // operazionale di input realistici.
    @Test
    void getNotificationToWithBareMockThrowsNpeOnUnenforcedInvariant() {
        NotificationDataBinderImpl binder = NotificationDataBinderImplRandoopSeeds.build();
        Notification notification = NotificationDataBinderImplRandoopSeeds.notification();

        assertThrows(NullPointerException.class,
                () -> binder.getNotificationTO(notification));
    }
}