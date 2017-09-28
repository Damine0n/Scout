package com.scout.project.dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="label")
public class Label {
	
	@Id
	@Column(name="label_id")
	private int label_ID;
	
	@Column(name="key")
	private String key;
	
	@Column(name="value")
	private String value;
	
	@Column(name="bundle_name")
	private String bundle_name;

	public int getLabel_ID() {
		return label_ID;
	}

	public void setLabel_ID(int label_ID) {
		this.label_ID = label_ID;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBundle_name() {
		return bundle_name;
	}

	public void setBundle_name(String bundle_name) {
		this.bundle_name = bundle_name;
	}

	@Override
	public String toString() {
		return "Label [label_ID=" + label_ID + ", key=" + key + ", value=" + value + ", bundle_name=" + bundle_name
				+ "]\n";
	}

	
}
