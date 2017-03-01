/*
 * ElementFactory.java
 *
 * Tigase XMPP Client Library
 * Copyright (C) 2006-2017 "Tigase, Inc." <office@tigase.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
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

package tigase.jaxmpp.core.client.xml;

public class ElementFactory {

	public static Element create(final Element src) throws XMLException {
		return DefaultElement.create(src, -1);
	}

	public static Element create(final String name) throws XMLException {
		return new DefaultElement(name);
	}

	public static Element create(String name, String value, String xmlns) throws XMLException {
		return new DefaultElement(name, value, xmlns);
	}

	private ElementFactory() {
	}

}
