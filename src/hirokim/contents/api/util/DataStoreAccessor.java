package hirokim.contents.api.util;

import hirokim.contents.api.model.Content;
import java.util.*;
import javax.jdo.*;

public class DataStoreAccessor {
	
	@SuppressWarnings("unchecked")
	public List<Content> getContents() {
		
		List<Content> contents = null;
		
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		
		String query = "select from " + Content.class.getName();
		
		try {
			contents = (List<Content>)manager.newQuery(query).execute();
		}
		catch(JDOObjectNotFoundException e) {
			
		}
		
		return contents;
	}
}
