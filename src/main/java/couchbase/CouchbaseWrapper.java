/**
 * 
 */
package couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;

/**
 * @author shashi
 *
 */
public class CouchbaseWrapper {
	Bucket bucket = null;

	public Boolean addDocument(JsonDocument document) {
		bucket = CouchbaseResource.getBucket();
		return (bucket.insert(document) != null);
	}
}
