/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.core.provisioning.java.data.c1;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.to.NotificationTO;
import org.apache.syncope.core.persistence.api.dao.AnyTypeDAO;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.MailTemplateDAO;
import org.apache.syncope.core.persistence.api.entity.EntityFactory;
import org.apache.syncope.core.persistence.api.entity.Notification;
import org.apache.syncope.core.provisioning.api.IntAttrNameParser;
import org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl;
import org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds;
import org.junit.jupiter.api.Test;

/**
 * Test curati dalla generazione automatica Randoop (Fase 3), variante C1,
 * scope corretto: update()/getNotificationTO() soltanto, create() escluso
 * tramite --omit-methods, coerentemente con lo scope dichiarato fin dalla
 * Category Partition (Fase 1).
 * Randoop 4.3.4, JDK 25, --time-limit=60, seed factory
 * NotificationDataBinderImplRandoopSeeds riutilizzata senza modifiche
 * (firme pubbliche invariate tra C0 e C1).
 */
public class NotificationDataBinderImplC1RandoopTest {

    // Randoop raw: RegressionTest0.test01
    @Test
    public void updateThrowsNPEWhenNotificationTOIsNull() {
        NotificationDataBinderImpl binder = NotificationDataBinderImplRandoopSeeds.build();
        Notification notification = NotificationDataBinderImplRandoopSeeds.notification();

        assertThrows(NullPointerException.class, () -> binder.update(notification, null));
    }

    // Randoop raw: RegressionTest0.test03
    @Test
    public void updateThrowsRequiredValuesMissingWhenTemplateAndEventsAreMissing() {
        NotificationDataBinderImpl binder = NotificationDataBinderImplRandoopSeeds.build();
        Notification notification = NotificationDataBinderImplRandoopSeeds.notification();
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTraceLevel(null);

        SyncopeClientException sce = assertThrows(
                SyncopeClientException.class, () -> binder.update(notification, notificationTO));
        assertNotNull(sce);
    }

    // Randoop raw: RegressionTest0.test05 — stesso ramo di test03 (duplicato
    // genuino, tenuto per la policy di curation già dichiarata nel progetto:
    // mai scartare per sola ridondanza).
    @Test
    public void updateThrowsRequiredValuesMissingWhenTemplateAndEventsAreMissing_duplicateOfTest03() {
        NotificationDataBinderImpl binder = NotificationDataBinderImplRandoopSeeds.build();
        Notification notification = NotificationDataBinderImplRandoopSeeds.notification();
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTraceLevel(null);
        notificationTO.setSelfAsRecipient(false);

        SyncopeClientException sce = assertThrows(
                SyncopeClientException.class, () -> binder.update(notification, notificationTO));
        assertNotNull(sce);
    }

    // Randoop raw: RegressionTest0.test07 — identico, nel messaggio e nel
    // meccanismo, al finding già documentato per C0 in
    @Test
    public void getNotificationTOThrowsNPEWhenNotificationTemplateIsNull() {
        MailTemplateDAO mailTemplateDAO = null;
        AnyTypeDAO anyTypeDAO = null;
        ImplementationDAO implementationDAO = null;
        EntityFactory entityFactory = null;
        IntAttrNameParser intAttrNameParser = null;
        NotificationDataBinderImpl binder = new NotificationDataBinderImpl(
                mailTemplateDAO, anyTypeDAO, implementationDAO, entityFactory, intAttrNameParser);
        Notification notification = NotificationDataBinderImplRandoopSeeds.notification();

        // notification.getTemplate() ritorna null sul mock "nudo" (mai stubbato):
        // stato irraggiungibile su un'entità realmente persistita, per via del
        // vincolo JPA @ManyToOne(optional = false) su JPANotification.template
        assertThrows(NullPointerException.class, () -> binder.getNotificationTO(notification));
    }
}