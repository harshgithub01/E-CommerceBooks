package br.com.talles.ecommercebooks.domain;

public abstract class AbstractCategory extends Entity {

	private String name;
	private String description;

	public AbstractCategory() {
	}

	public AbstractCategory(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public AbstractCategory(String name, String description, long id, boolean enabled) {
		super(id, enabled);
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
