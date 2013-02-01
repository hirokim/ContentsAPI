package hirokim.contents.api.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Content {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String id;
	
	@Persistent
	private String appid;
	
	@Persistent
	private String category;

	@Persistent
	private String group;

	@Persistent
	private String name;

	@Persistent
	private String url;
	
	public Content() {
		super();
		this.id = null;
		this.appid = null;
		this.category = null;
		this.group = null;
		this.name = null;
		this.url = null;
	}

	public Content(String id, String appid, String category, String group,
			String name, String url) {
		super();
		this.id = id;
		this.appid = appid;
		this.category = category;
		this.group = group;
		this.name = name;
		this.url = url;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
