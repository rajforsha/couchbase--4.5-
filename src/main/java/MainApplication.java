import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;

import couchbase.CouchbaseResource;

/**
 * @author shashi
 *
 */
public class MainApplication {

	/**
	 * `
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// JsonObject content = JsonObject.empty().put("name",
		// "Randhir").put("gender", "male").put("age", 19);
		// JsonDocument document = JsonDocument.create("4", content);
		// CouchbaseWrapper.replaceDocument(document);
		// CouchbaseWrapper.addDocument(document);

		// System.out.println(CouchbaseWrapper.getDocument("2"));

		// String fun = "function (doc, meta) { if(doc.age){
		// emit(doc.age,doc);}}";
		//
		// Boolean isCreated = CouchbaseWrapper.createViews("by_age", fun);
		// System.out.println("view created:" + isCreated);

		// Boolean isDeleted = CouchbaseWrapper.deleteDocument("2");
		// System.out.println(isDeleted);

		// ViewResult result = CouchbaseWrapper.searchWithKeys("by_age", "19");
		// for (ViewRow row : result) {
		// System.out.println(row.document());
		// }
		// System.out.println("total count is:" +
		// CouchbaseWrapper.count("by_age", 19));
		// Index.createPrimaryIndex().on(CouchbaseResource.getBucket().name());
		// CouchbaseResource.getBucket()
		// .query(N1qlQuery.simple(Index.createPrimaryIndex().on(CouchbaseResource.getBucket().name())));
		N1qlQueryResult result = CouchbaseResource.getBucket()
				.query(N1qlQuery.simple("SELECT * FROM default WHERE  name='Randhir'AND age=19 "));
		for (N1qlQueryRow row : result) {
			System.out.println(row.value());
		}
		// System.out.println("getQQuery()::" +
		// CouchbaseResource.getBucket().get("1"));
		CouchbaseResource.disconnect();
	}
}
