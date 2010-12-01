package tigase.jaxmpp.core.client.xmpp.modules.presence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import tigase.jaxmpp.core.client.BareJID;
import tigase.jaxmpp.core.client.JID;
import tigase.jaxmpp.core.client.xml.XMLException;
import tigase.jaxmpp.core.client.xmpp.stanzas.Presence;
import tigase.jaxmpp.core.client.xmpp.stanzas.Presence.Show;

public class PresenceStore {

	static interface Handler {

		public void setPresence(Show show, String status, Integer priority) throws XMLException;

	}

	private Handler handler;

	private Map<JID, Presence> presenceByJid = new HashMap<JID, Presence>();

	private Map<BareJID, Map<String, Presence>> presencesMapByBareJid = new HashMap<BareJID, Map<String, Presence>>();

	public boolean isAvailable(BareJID jid) throws XMLException {
		Map<String, Presence> resourcesPresence = this.presencesMapByBareJid.get(jid);
		boolean result = false;
		if (resourcesPresence != null) {
			Iterator<Presence> it = resourcesPresence.values().iterator();
			while (it.hasNext() && !result) {
				Presence x = it.next();
				result = result | x.getType() == null;
			}
		}
		return result;

	}

	void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setPresence(Show show, String status, Integer priority) throws XMLException {
		this.handler.setPresence(show, status, priority);
	}

	public void update(final Presence presence) throws XMLException {
		final JID from = presence.getFrom();
		if (from == null)
			return;
		final BareJID bareFrom = from.getBareJid();
		final String resource = from.getResource() == null ? "" : from.getResource();

		this.presenceByJid.put(from, presence);
		Map<String, Presence> m = this.presencesMapByBareJid.get(bareFrom);
		if (m == null) {
			m = new HashMap<String, Presence>();
			this.presencesMapByBareJid.put(bareFrom, m);
		}
		m.put(resource, presence);
	}
}
