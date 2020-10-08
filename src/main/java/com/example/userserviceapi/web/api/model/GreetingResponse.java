package com.example.userserviceapi.web.api.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GreetingResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-07T10:31:42.958Z")

public class GreetingResponse {
	@JsonProperty("result")
	private String result = null;

	public GreetingResponse result(String result) {
		this.result = result;
		return this;
	}

	/**
	 * Get result
	 * 
	 * @return result
	 **/
	@ApiModelProperty(value = "")

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GreetingResponse greetingResponse = (GreetingResponse) o;
		return Objects.equals(this.result, greetingResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GreetingResponse {\n");

		sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
