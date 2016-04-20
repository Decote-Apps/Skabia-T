package com.decote.skabiat.dao;

import java.util.Map;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.decote.skabiat.exception.UserNotFoundException;
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
	public Bar getBarById(String id) throws UserNotFoundException {
		GetResponse response = client.prepareGet("bar", "bar", id).execute()
				.actionGet();
		Map <String, Object> barMap = response.getSource();
		if (barMap == null){
			throw new UserNotFoundException ();
		}
		Bar wantedBar = SkabiatUtils.getBarFromMap(barMap);
		return wantedBar;
	}

	@Override
	public void addBar(Bar bar) {
		IndexResponse response;
		IndexRequestBuilder requestBuilder = client.prepareIndex("bar", "bar", bar.getId());
		requestBuilder.setSource(SkabiatUtils.getMapFromBar(bar));
		response = requestBuilder.execute().actionGet();
		
	}

	@Override
	public void deleteBar(String id) {
		DeleteResponse response = client.prepareDelete("bar", "bar", id).execute().actionGet();
		
		
	}

}
