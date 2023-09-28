package com.hurecom.entity.common;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
	
	@MappedSuperclass
	public class BaseEntity {

		@Column(name = "created_user", updatable = false)
		public Long createdUser;

		@Column(name = "created_date", updatable = false)
		public LocalDateTime createdDate;

		@Column(name = "modified_user")
		public Long modifiedUser;

		@Column(name = "modified_date")
		public LocalDateTime modifiedDate;

		public Long getCreatedUser() {
			return createdUser;
		}

		public void setCreatedUser(Long createdUser) {
			this.createdUser = createdUser;
		}

		public LocalDateTime getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}

		public Long getModifiedUser() {
			return modifiedUser;
		}

		public void setModifiedUser(Long modifiedUser) {
			this.modifiedUser = modifiedUser;
		}

		public LocalDateTime getModifiedDate() {
			return modifiedDate;
		}

		public void setModifiedDate(LocalDateTime modifiedDate) {
			this.modifiedDate = modifiedDate;
		}

	}

	

