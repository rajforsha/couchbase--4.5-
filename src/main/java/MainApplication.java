import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;
import com.couchbase.client.java.view.ViewRow;

import couchbase.CouchbaseResource;

/**
 * @author shashi
 *
 */
public class MainApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Student student = new Student();
		// student.setGender("male");
		// student.setName("shashi");
		// student.setPlace("Bangalore");
		// JsonObject result = JsonObject.empty().put("name",
		// "shashi").put("gender", "male");
		// JsonDocument doc = JsonDocument.create("1", result);
		// defaultBucket.insert(doc);

		// String fun = "function (doc, meta) { if(doc.name){ emit(doc.name,
		// doc); }}";
		// DesignDocument docu = DesignDocument.create("search",
		// Arrays.asList(DefaultView.create("by_Name", fun)));
		// BucketManager manager = defaultBucket.bucketManager();
		// if (manager.insertDesignDocument(docu, false) != null) {
		// System.out.println("view created");
		// } else {
		// System.err.println("view cant be created.");
		// }

		ViewResult result = CouchbaseResource.getBucket().query(ViewQuery.from("search", "by_Name").endKey("shashi"));
		for (ViewRow row : result) {
			System.out.println(row.document());
		}

		// System.out.println("getQQuery()::" +
		// CouchbaseResource.getBucket().get("1"));
		CouchbaseResource.disconnect();
	}
}
