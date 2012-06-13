package de.podfetcher.syndication.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import de.podfetcher.syndication.namespace.Namespace;
import de.podfetcher.syndication.namespace.SyndElement;
import de.podfetcher.feed.Feed;
import de.podfetcher.feed.FeedItem;

/** Contains all relevant information to describe the current state of a SyndHandler.*/
public class HandlerState {
	/** Feed that the Handler is currently processing. */
	protected Feed feed;
	protected FeedItem currentItem;
	protected Stack<SyndElement> tagstack;
	/** Namespaces that have been defined so far. */
	protected HashMap<String, Namespace> namespaces;
	protected Stack<Namespace> defaultNamespaces;
	
	public HandlerState(Feed feed) {
		this.feed = feed;
		tagstack = new Stack<SyndElement>();
		namespaces = new HashMap<String, Namespace>();
		defaultNamespaces = new Stack<Namespace>();
	}
	
	
	public Feed getFeed() {
		return feed;
	}
	public FeedItem getCurrentItem() {
		return currentItem;
	}
	public Stack<SyndElement> getTagstack() {
		return tagstack;
	}


	public void setFeed(Feed feed) {
		this.feed = feed;
	}


	public void setCurrentItem(FeedItem currentItem) {
		this.currentItem = currentItem;
	}

	/** Returns the SyndElement that comes after the top element of the tagstack. */
	public SyndElement getSecondTag() {
		SyndElement top = tagstack.pop();
		SyndElement second = tagstack.peek();
		tagstack.push(top);
		return second;
	}
	
	
	
	
}