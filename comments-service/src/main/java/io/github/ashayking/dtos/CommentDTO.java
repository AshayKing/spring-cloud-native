package io.github.ashayking.dtos;

import java.io.IOException;
import java.util.Date;

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
public class CommentDTO {

	private String taskId;
	private String comment;
	private Date posted;

	public CommentDTO() {
		super();
	}

	public CommentDTO(String taskId, String comment, Date posted) {
		super();
		this.taskId = taskId;
		this.comment = comment;
		this.posted = posted;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@JsonSerialize(using = CustomDateToLongSerializer.class)
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
		CommentDTO other = (CommentDTO) obj;
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
		return "CommentDTO [taskId=" + taskId + ", comment=" + comment + ", posted=" + posted + "]";
	}

}

/**
 * 
 * @author Ashay S Patil
 *
 */
class CustomDateToLongSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeNumber(value.getTime());
	}
}