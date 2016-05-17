/**
 * 
 */
package couchbase;

import java.util.Arrays;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.view.DefaultView;
import com.couchbase.client.java.view.DesignDocument;
import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;

/**
 * @author shashi
 *
 */
public class CouchbaseWrapper {
	public static Bucket bucket = CouchbaseResource.getBucket();

	public static Boolean addDocument(JsonDocument document) {
		return (bucket.insert(document) != null);
	}

	public static JsonDocument getDocument(String id) {
		return (bucket.get(id));
	}

	public static Boolean replaceDocument(JsonDocument document) {
		return (bucket.upsert(document) != null);
	}

	public static Boolean deleteDocument(String id) {
		return (bucket.remove(id) != null);
	}

	public static Boolean createViews(String viewName, String function) {
		if (bucket.bucketManager().getDesignDocument("search") != null) {
			System.out.println("search design Document found!!");
			DesignDocument doc = bucket.bucketManager().getDesignDocument("search", false);
			doc.views().add(DefaultView.create(viewName, function, "_count"));
			return (bucket.bucketManager().upsertDesignDocument(doc) != null);
		} else {
			DesignDocument dDoc = DesignDocument.create("search",
					Arrays.asList(DefaultView.create(viewName, function, "_count")));
			return (bucket.bucketManager().insertDesignDocument(dDoc, false) != null);
		}
	}
	
	public static ViewResult searchWithKeys(String viewName, String key) {
		 return (bucket.query(ViewQuery.from("search",
		 viewName).key(key).limit(2)));
	}

	public static Integer count(String viewName, int key) {
		return (bucket.query(ViewQuery.from("search", viewName).key(key).reduce(true).development(false)).allRows()
				.size());
	}
}
