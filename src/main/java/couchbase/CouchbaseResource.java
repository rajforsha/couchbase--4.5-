package couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

public class CouchbaseResource {

	public static Cluster cluster = null;

	public static Bucket getBucket() {
		cluster = CouchbaseCluster.create();
		Bucket defaultBucket = cluster.openBucket();
		if (defaultBucket != null) {
			System.out.println("conncetion established");
			return defaultBucket;
		} else {
			return null;
		}

	}

	public static void disconnect() {
		cluster.disconnect();
	}
}
