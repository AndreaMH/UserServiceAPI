package com.example.userserviceapi.web.api.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ApiError
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-25T10:13:35.563Z")

public class ApiError {
	@JsonProperty("type")
	private String type = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("status")
	private Integer status = null;

	@JsonProperty("detail")
	private String detail = null;

	@JsonProperty("message")
	private String message = null;

	public ApiError type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ApiError title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Get title
	 * 
	 * @return title
	 **/
	@ApiModelProperty(value = "")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ApiError status(Integer status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "")

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ApiError detail(String detail) {
		this.detail = detail;
		return this;
	}

	/**
	 * Get detail
	 * 
	 * @return detail
	 **/
	@ApiModelProperty(value = "")

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public ApiError message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return message
	 **/
	@ApiModelProperty(value = "")

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ApiError apiError = (ApiError) o;
		return Objects.equals(this.type, apiError.type) && Objects.equals(this.title, apiError.title)
				&& Objects.equals(this.status, apiError.status) && Objects.equals(this.detail, apiError.detail)
				&& Objects.equals(this.message, apiError.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, title, status, detail, message);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ApiError {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
