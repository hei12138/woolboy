/*
 * 微信公众平台(JAVA) SDK
 *
 * Copyright (c) 2014, Ansitech Network Technology Co.,Ltd All rights reserved.
 * 
 * http://www.weixin4j.org/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.weixin4j.loader;

import org.apache.commons.lang3.StringUtils;
import org.weixin4j.model.js.Ticket;
import org.weixin4j.model.js.TicketType;

import java.util.EnumMap;
import java.util.Map;

/**
 * 内存式Ticket存储器
 *
 * 单项目时使用（生产环境不推荐）
 *
 * @author yangqisheng
 * @since 0.1.0
 */
public class DefaultTicketLoader implements ITicketLoader {

    private final Map<TicketType, Ticket> tickets = new EnumMap<TicketType, Ticket>(TicketType.class);

    @Override
    public Ticket get(TicketType ticketType) {
        Ticket ticket = tickets.get(ticketType);
        return (ticket == null
                || StringUtils.isEmpty(ticket.getTicket())
                || ticket.isExprexpired()) ? null : ticket;
    }

    @Override
    public void refresh(Ticket ticket) {
        tickets.put(ticket.getTicketType(), ticket);
    }

}
