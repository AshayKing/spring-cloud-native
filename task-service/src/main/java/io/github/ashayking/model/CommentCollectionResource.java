package io.github.ashayking.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 
 * @author Ashay S Patil
 *
 */
@JsonDeserialize(using = CommentsCollectionDeserializer.class)
public class CommentCollectionResource {
	private List<CommentResource> taskComments;

	public void addComment(CommentResource comment) {
		if (this.taskComments == null) {
			this.taskComments = new ArrayList<>();
		}
		this.taskComments.add(comment);
	}

	public List<CommentResource> getTaskComments() {
		return taskComments;
	}

	public void setTaskComments(List<CommentResource> taskComments) {
		this.taskComments = taskComments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taskComments == null) ? 0 : taskComments.hashCode());
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
		CommentCollectionResource other = (CommentCollectionResource) obj;
		if (taskComments == null) {
			if (other.taskComments != null)
				return false;
		} else if (!taskComments.equals(other.taskComments))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentCollectionResource [taskComments=" + taskComments + "]";
	}
}

/**
 * 
 * @author Ashay S Patil
 *
 */
class CommentsCollectionDeserializer extends JsonDeserializer<CommentCollectionResource> {
	@Override
	public CommentCollectionResource deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		CommentCollectionResource commentArrayResource = new CommentCollectionResource();
		CommentResource commentResource = null;

		JsonNode jsonNode = jp.readValueAsTree();

		for (JsonNode childNode : jsonNode) {
			if (childNode.has(CommentResource.JP_TASKID)) {
				commentResource = new CommentResource();
				commentResource.setTaskId(childNode.get(CommentResource.JP_TASKID).asText());
				commentResource.setComment(childNode.get(CommentResource.JP_COMMENT).asText());
				commentResource.setPosted(new Date(childNode.get(CommentResource.JP_POSTED).asLong()));

				commentArrayResource.addComment(commentResource);
			}
		}
		return commentArrayResource;

	}
}