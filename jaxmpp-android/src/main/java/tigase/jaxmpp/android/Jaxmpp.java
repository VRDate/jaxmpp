/*
 * Tigase XMPP Client Library
 * Copyright (C) 2013-2014 "Tigase, Inc." <office@tigase.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://www.gnu.org/licenses/.
 */
package tigase.jaxmpp.android;

import tigase.jaxmpp.core.client.SessionObject;
import tigase.jaxmpp.core.client.factory.UniversalFactory;
import tigase.jaxmpp.core.client.factory.UniversalFactory.FactorySpi;
import tigase.jaxmpp.j2se.connectors.socket.SocketConnector.DnsResolver;

public class Jaxmpp extends tigase.jaxmpp.j2se.Jaxmpp {
	static {
		UniversalFactory.setSpi(DnsResolver.class.getName(), new FactorySpi<DnsResolver>() {

			@Override
			public DnsResolver create() {
				return new AndroidDNSResolver();
			}
		});
	}

	public Jaxmpp() {
		super();
	}

	public Jaxmpp(SessionObject sessionObject) {
		super(sessionObject);
	}

}
