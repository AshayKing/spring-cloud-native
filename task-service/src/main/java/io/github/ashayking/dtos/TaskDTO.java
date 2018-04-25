package io.github.ashayking.dtos;

import io.github.ashayking.model.CommentCollectionResource;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class TaskDTO {

	private String taskId;
	private String description;
	private boolean completed;
	private String userName;
	private CommentCollectionResource comments;

	public TaskDTO() {
		super();
	}

	public TaskDTO(String taskId, String description, String userName) {
		super();
		this.taskId = taskId;
		this.description = description;
		this.completed = false;
		this.userName = userName;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public CommentCollectionResource getComments() {
		return comments;
	}

	public void setComments(CommentCollectionResource comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + (completed ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		TaskDTO other = (TaskDTO) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (completed != other.completed)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaskDTO [taskId=" + taskId + ", description=" + description + ", completed=" + completed + ", userName="
				+ userName + ", comments=" + comments + "]";
	}

}
