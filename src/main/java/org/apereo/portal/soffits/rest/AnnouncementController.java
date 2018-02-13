/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
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

package org.apereo.portal.soffits.rest;

import java.util.List;

import org.apereo.portal.soffits.service.Announcmenet;
import org.apereo.portal.soffits.service.AnnouncmenetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@RestController
@RequestMapping("/api/announcement")
public class AnnouncementsController {

    @Autowired
    private AnnouncmenetService announcmenetService;

    @RequestMapping(value="/v1-0/announcement", method=RequestMethod.GET, produces = "application/json")
    public List<Announcmenet> getInstagramFeed() {
        final List<Announcmenet> rslt = announcmenetService.getAll();
        if (rslt == null) {
            throw new RuntimeException("Unable to access announcmenets");
        }
        return rslt;
    }

    @ControllerAdvice
    static class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
        public JsonpAdvice() {
            super("callback");
        }
    }

}
