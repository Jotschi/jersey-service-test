package de.jotschi.vertx.example;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import com.englishtown.vertx.jersey.JerseyVerticle;

public class Runner {

	private static final Vertx vertx = Vertx.vertx();

	public static void main(String[] args) {

		JsonObject config = new JsonObject();
		config.put("resources", new JsonArray().add("de.jotschi.vertx.example.resources"));
		config.put("port", 8000);

		DeploymentOptions options = new DeploymentOptions();
		// options.setIsolationGroup("A");
		options.setConfig(config);

		vertx.deployVerticle("java-hk2:" + JerseyVerticle.class.getCanonicalName(), options);

		deployArtifact();
		// System.in.read();
	}

	private static void deployArtifact() {
		JsonObject config = new JsonObject();
		config.put("resources", new JsonArray().add("de.jotschi.vertx.example.resources"));
		config.put("port", 8000);

		DeploymentOptions options = new DeploymentOptions();
		options.setConfig(config);

		vertx.deployVerticle("service:de.jotschi.vertx:jersey-service-test-rest-extra:0.0.1-SNAPSHOT", options);
	}
}
