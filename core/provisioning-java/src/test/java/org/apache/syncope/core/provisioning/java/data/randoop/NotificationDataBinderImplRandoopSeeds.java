/*
 * Seed factory per Randoop — Fase 3 (Generazione Automatica).
 *
 * NON è una classe di test. NotificationDataBinderImpl ha un costruttore
 * a 5 parametri, tutti tipi interfaccia tranne IntAttrNameParser (classe
 * concreta, ma anch'essa DI-dipendente: costruttore reale confermato —
 * IntAttrNameParser(PlainSchemaDAO, DerSchemaDAO, AnyUtilsFactory,
 * RealmUtils) — quindi va mockata anche lei, 4 dipendenze in più).
 *
 * update()/getNotificationTO() prendono anche un parametro Notification,
 * che e' anch'esso un'interfaccia: serve un secondo producer per quello.
 *
 * Destinazione nel progetto:
 * core/provisioning-java/src/test/java/org/apache/syncope/core/provisioning/java/data/randoop/
 */
package org.apache.syncope.core.provisioning.java.data.randoop;

import org.apache.syncope.core.persistence.api.dao.AnyTypeDAO;
import org.apache.syncope.core.persistence.api.dao.DerSchemaDAO;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.MailTemplateDAO;
import org.apache.syncope.core.persistence.api.dao.PlainSchemaDAO;
import org.apache.syncope.core.persistence.api.entity.AnyUtilsFactory;
import org.apache.syncope.core.persistence.api.entity.EntityFactory;
import org.apache.syncope.core.persistence.api.entity.Notification;
import org.apache.syncope.core.persistence.api.utils.RealmUtils;
import org.apache.syncope.core.provisioning.api.IntAttrNameParser;
import org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl;
import org.mockito.Mockito;

public final class NotificationDataBinderImplRandoopSeeds {

    private NotificationDataBinderImplRandoopSeeds() {
    }

    /**
     * Producer per Randoop: costruisce un NotificationDataBinderImpl con
     * dipendenze mockate (non null).
     */
    public static NotificationDataBinderImpl build() {
        MailTemplateDAO mailTemplateDAO = Mockito.mock(MailTemplateDAO.class);
        AnyTypeDAO anyTypeDAO = Mockito.mock(AnyTypeDAO.class);
        ImplementationDAO implementationDAO = Mockito.mock(ImplementationDAO.class);
        EntityFactory entityFactory = Mockito.mock(EntityFactory.class);

        PlainSchemaDAO plainSchemaDAO = Mockito.mock(PlainSchemaDAO.class);
        DerSchemaDAO derSchemaDAO = Mockito.mock(DerSchemaDAO.class);
        AnyUtilsFactory anyUtilsFactory = Mockito.mock(AnyUtilsFactory.class);
        RealmUtils realmUtils = Mockito.mock(RealmUtils.class);
        IntAttrNameParser intAttrNameParser =
                new IntAttrNameParser(plainSchemaDAO, derSchemaDAO, anyUtilsFactory, realmUtils);

        return new NotificationDataBinderImpl(
                mailTemplateDAO, anyTypeDAO, implementationDAO, entityFactory, intAttrNameParser);
    }

    /**
     * Producer per Randoop: Notification è un'interfaccia (entità di
     * persistenza), nessuna implementazione concreta è raggiungibile
     * dal classpath di questo modulo.
     */
    public static Notification notification() {
        return Mockito.mock(Notification.class);
    }
}