package br.net.shima.nexus.caffeinate;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.events.Asynchronous;
import org.sonatype.nexus.events.EventSubscriber;
import org.sonatype.nexus.proxy.events.RepositoryEvent;

import br.net.shima.utils.caffeinate.CaffeinateThread;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

@Named
@Singleton
public class CaffeinateEventInspector implements EventSubscriber, Asynchronous
{
	private CaffeinateThread caffeinate;

	public CaffeinateEventInspector() {
		this.caffeinate = new CaffeinateThread();
	}

	@Subscribe
	@AllowConcurrentEvents
	public void on(final RepositoryEvent evt) {
		caffeinate.tinyCaffeinate();
	}

}
