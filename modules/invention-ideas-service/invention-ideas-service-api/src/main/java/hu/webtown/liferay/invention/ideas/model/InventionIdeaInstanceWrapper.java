/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hu.webtown.liferay.invention.ideas.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link InventionIdeaInstance}.
 * </p>
 *
 * @author lehel
 * @see InventionIdeaInstance
 * @generated
 */
@ProviderType
public class InventionIdeaInstanceWrapper implements InventionIdeaInstance,
	ModelWrapper<InventionIdeaInstance> {
	public InventionIdeaInstanceWrapper(
		InventionIdeaInstance inventionIdeaInstance) {
		_inventionIdeaInstance = inventionIdeaInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return InventionIdeaInstance.class;
	}

	@Override
	public String getModelClassName() {
		return InventionIdeaInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("inventorName", getInventorName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String inventorName = (String)attributes.get("inventorName");

		if (inventorName != null) {
			setInventorName(inventorName);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public Object clone() {
		return new InventionIdeaInstanceWrapper((InventionIdeaInstance)_inventionIdeaInstance.clone());
	}

	@Override
	public int compareTo(InventionIdeaInstance inventionIdeaInstance) {
		return _inventionIdeaInstance.compareTo(inventionIdeaInstance);
	}

	/**
	* Returns the company ID of this invention idea instance.
	*
	* @return the company ID of this invention idea instance
	*/
	@Override
	public long getCompanyId() {
		return _inventionIdeaInstance.getCompanyId();
	}

	/**
	* Returns the create date of this invention idea instance.
	*
	* @return the create date of this invention idea instance
	*/
	@Override
	public Date getCreateDate() {
		return _inventionIdeaInstance.getCreateDate();
	}

	/**
	* Returns the description of this invention idea instance.
	*
	* @return the description of this invention idea instance
	*/
	@Override
	public String getDescription() {
		return _inventionIdeaInstance.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _inventionIdeaInstance.getExpandoBridge();
	}

	/**
	* Returns the group ID of this invention idea instance.
	*
	* @return the group ID of this invention idea instance
	*/
	@Override
	public long getGroupId() {
		return _inventionIdeaInstance.getGroupId();
	}

	/**
	* Returns the ID of this invention idea instance.
	*
	* @return the ID of this invention idea instance
	*/
	@Override
	public long getId() {
		return _inventionIdeaInstance.getId();
	}

	/**
	* Returns the inventor name of this invention idea instance.
	*
	* @return the inventor name of this invention idea instance
	*/
	@Override
	public String getInventorName() {
		return _inventionIdeaInstance.getInventorName();
	}

	/**
	* Returns the modified date of this invention idea instance.
	*
	* @return the modified date of this invention idea instance
	*/
	@Override
	public Date getModifiedDate() {
		return _inventionIdeaInstance.getModifiedDate();
	}

	/**
	* Returns the name of this invention idea instance.
	*
	* @return the name of this invention idea instance
	*/
	@Override
	public String getName() {
		return _inventionIdeaInstance.getName();
	}

	/**
	* Returns the primary key of this invention idea instance.
	*
	* @return the primary key of this invention idea instance
	*/
	@Override
	public long getPrimaryKey() {
		return _inventionIdeaInstance.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _inventionIdeaInstance.getPrimaryKeyObj();
	}

	/**
	* Returns the short description of this invention idea instance.
	*
	* @return the short description of this invention idea instance
	*/
	@Override
	public String getShortDescription() {
		return _inventionIdeaInstance.getShortDescription();
	}

	/**
	* Returns the user ID of this invention idea instance.
	*
	* @return the user ID of this invention idea instance
	*/
	@Override
	public long getUserId() {
		return _inventionIdeaInstance.getUserId();
	}

	/**
	* Returns the user name of this invention idea instance.
	*
	* @return the user name of this invention idea instance
	*/
	@Override
	public String getUserName() {
		return _inventionIdeaInstance.getUserName();
	}

	/**
	* Returns the user uuid of this invention idea instance.
	*
	* @return the user uuid of this invention idea instance
	*/
	@Override
	public String getUserUuid() {
		return _inventionIdeaInstance.getUserUuid();
	}

	/**
	* Returns the uuid of this invention idea instance.
	*
	* @return the uuid of this invention idea instance
	*/
	@Override
	public String getUuid() {
		return _inventionIdeaInstance.getUuid();
	}

	@Override
	public int hashCode() {
		return _inventionIdeaInstance.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _inventionIdeaInstance.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _inventionIdeaInstance.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _inventionIdeaInstance.isNew();
	}

	@Override
	public void persist() {
		_inventionIdeaInstance.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_inventionIdeaInstance.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this invention idea instance.
	*
	* @param companyId the company ID of this invention idea instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_inventionIdeaInstance.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this invention idea instance.
	*
	* @param createDate the create date of this invention idea instance
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_inventionIdeaInstance.setCreateDate(createDate);
	}

	/**
	* Sets the description of this invention idea instance.
	*
	* @param description the description of this invention idea instance
	*/
	@Override
	public void setDescription(String description) {
		_inventionIdeaInstance.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_inventionIdeaInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_inventionIdeaInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_inventionIdeaInstance.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this invention idea instance.
	*
	* @param groupId the group ID of this invention idea instance
	*/
	@Override
	public void setGroupId(long groupId) {
		_inventionIdeaInstance.setGroupId(groupId);
	}

	/**
	* Sets the ID of this invention idea instance.
	*
	* @param id the ID of this invention idea instance
	*/
	@Override
	public void setId(long id) {
		_inventionIdeaInstance.setId(id);
	}

	/**
	* Sets the inventor name of this invention idea instance.
	*
	* @param inventorName the inventor name of this invention idea instance
	*/
	@Override
	public void setInventorName(String inventorName) {
		_inventionIdeaInstance.setInventorName(inventorName);
	}

	/**
	* Sets the modified date of this invention idea instance.
	*
	* @param modifiedDate the modified date of this invention idea instance
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_inventionIdeaInstance.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this invention idea instance.
	*
	* @param name the name of this invention idea instance
	*/
	@Override
	public void setName(String name) {
		_inventionIdeaInstance.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_inventionIdeaInstance.setNew(n);
	}

	/**
	* Sets the primary key of this invention idea instance.
	*
	* @param primaryKey the primary key of this invention idea instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_inventionIdeaInstance.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_inventionIdeaInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the short description of this invention idea instance.
	*
	* @param shortDescription the short description of this invention idea instance
	*/
	@Override
	public void setShortDescription(String shortDescription) {
		_inventionIdeaInstance.setShortDescription(shortDescription);
	}

	/**
	* Sets the user ID of this invention idea instance.
	*
	* @param userId the user ID of this invention idea instance
	*/
	@Override
	public void setUserId(long userId) {
		_inventionIdeaInstance.setUserId(userId);
	}

	/**
	* Sets the user name of this invention idea instance.
	*
	* @param userName the user name of this invention idea instance
	*/
	@Override
	public void setUserName(String userName) {
		_inventionIdeaInstance.setUserName(userName);
	}

	/**
	* Sets the user uuid of this invention idea instance.
	*
	* @param userUuid the user uuid of this invention idea instance
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_inventionIdeaInstance.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this invention idea instance.
	*
	* @param uuid the uuid of this invention idea instance
	*/
	@Override
	public void setUuid(String uuid) {
		_inventionIdeaInstance.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<InventionIdeaInstance> toCacheModel() {
		return _inventionIdeaInstance.toCacheModel();
	}

	@Override
	public InventionIdeaInstance toEscapedModel() {
		return new InventionIdeaInstanceWrapper(_inventionIdeaInstance.toEscapedModel());
	}

	@Override
	public String toString() {
		return _inventionIdeaInstance.toString();
	}

	@Override
	public InventionIdeaInstance toUnescapedModel() {
		return new InventionIdeaInstanceWrapper(_inventionIdeaInstance.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _inventionIdeaInstance.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InventionIdeaInstanceWrapper)) {
			return false;
		}

		InventionIdeaInstanceWrapper inventionIdeaInstanceWrapper = (InventionIdeaInstanceWrapper)obj;

		if (Objects.equals(_inventionIdeaInstance,
					inventionIdeaInstanceWrapper._inventionIdeaInstance)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _inventionIdeaInstance.getStagedModelType();
	}

	@Override
	public InventionIdeaInstance getWrappedModel() {
		return _inventionIdeaInstance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _inventionIdeaInstance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _inventionIdeaInstance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_inventionIdeaInstance.resetOriginalValues();
	}

	private final InventionIdeaInstance _inventionIdeaInstance;
}