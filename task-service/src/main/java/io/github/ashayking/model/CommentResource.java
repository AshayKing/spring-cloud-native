package io.github.ashayking.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class CommentResource {

	public static final String JP_TASKID = "taskId";
	public static final String JP_COMMENT = "comment";
	public static final String JP_POSTED = "posted";

	private String taskId;
	private String comment;
	private Date posted;

	public CommentResource() {
		super();
	}

	public CommentResource(String taskId, String comment, Date posted) {
		super();
		this.taskId = taskId;
		this.comment = comment;
		this.posted = posted;
	}

	@JsonProperty(JP_TASKID)
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@JsonProperty(JP_COMMENT)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@JsonProperty(JP_POSTED)
	@JsonSerialize(using = CustomDateToStringSerializer.class)
	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((posted == null) ? 0 : posted.hashCode());
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentResource other = (CommentResource) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (posted == null) {
			if (other.posted != null)
				return false;
		} else if (!posted.equals(other.posted))
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentResource [taskId=" + taskId + ", comment=" + comment + ", posted=" + posted + "]";
	}

}

/**
 * 
 * @author Ashay S Patil
 *
 */
class CustomDateToStringSerializer extends JsonSerializer<Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String dateString = dateFormat.format(value);
		jgen.writeString(dateString);
	}
}