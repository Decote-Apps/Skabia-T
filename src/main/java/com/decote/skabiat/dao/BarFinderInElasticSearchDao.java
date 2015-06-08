package com.decote.skabiat.dao;

import java.util.ResourceBundle;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.decote.skabiat.model.Bar;
import com.decote.skabiat.util.SkabiatUtils;

public class BarFinderInElasticSearchDao implements IBarFinderDao {

	private Client client;

	public BarFinderInElasticSearchDao() {
		client = new TransportClient()
				.addTransportAddress(new InetSocketTransportAddress(
//						ResourceBundle.getBundle("application.properties")
//								.getString("elasticsearch.host.url"), Integer
//								.parseInt(ResourceBundle.getBundle(
//										"application.properties").getString(
//										"elasticsearch.host.port"))));
						"55v6pmjm:ywviwla5nbkpok83@yew-1188452.us-east-1.bonsai.io",443));
	}

	@Override
	public Bar getBarById(String id) {
		GetResponse response = client.prepareGet("bar", "bar", "1").execute()
				.actionGet();
		Bar wantedBar = SkabiatUtils.getBarFromMap(response.getSource());
		// SearchRequestBuilder builder = client.prepareGet();
		// builder.setSearchType(SearchType.QUERY_AND_FETCH);
		// builder.setQuery(QueryBuilders.matchQuery("id", id));
		// SearchResponse response = builder.execute().actionGet();
		// response.getHits().getAt(0).;
		// Bar wantedBar;
		client.close();
		return wantedBar;
	}

	@Override
	public void addBar(Bar bar) {
		IndexResponse response;

		IndexRequestBuilder requestBuilder = client.prepareIndex("bar", "bar");
		requestBuilder.setSource(SkabiatUtils.getMapFromBar(bar));
		requestBuilder.execute().actionGet();

	}

}
