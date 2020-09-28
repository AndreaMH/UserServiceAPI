package com.example.userserviceapi.web.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * People
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-25T10:13:35.563Z")

public class People {
	@JsonProperty("resultCode")
	private String resultCode = null;

	@JsonProperty("peopleList")
	@Valid
	private List<Person> peopleList = null;

	public People resultCode(String resultCode) {
		this.resultCode = resultCode;
		return this;
	}

	/**
	 * Get resultCode
	 * 
	 * @return resultCode
	 **/
	@ApiModelProperty(value = "")

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public People peopleList(List<Person> peopleList) {
		this.peopleList = peopleList;
		return this;
	}

	public People addPeopleListItem(Person peopleListItem) {
		if (this.peopleList == null) {
			this.peopleList = new ArrayList<Person>();
		}
		this.peopleList.add(peopleListItem);
		return this;
	}

	/**
	 * Get peopleList
	 * 
	 * @return peopleList
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<Person> getPeopleList() {
		return peopleList;
	}

	public void setPeopleList(List<Person> peopleList) {
		this.peopleList = peopleList;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		People people = (People) o;
		return Objects.equals(this.resultCode, people.resultCode) && Objects.equals(this.peopleList, people.peopleList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(resultCode, peopleList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class People {\n");

		sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
		sb.append("    peopleList: ").append(toIndentedString(peopleList)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
