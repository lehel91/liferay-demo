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

package hu.webtown.liferay.invention.ideas.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance;
import hu.webtown.liferay.invention.ideas.model.InventionIdeaInstanceModel;
import hu.webtown.liferay.invention.ideas.model.InventionIdeaInstanceSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the InventionIdeaInstance service. Represents a row in the &quot;le_demo_InventionIdeaInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link InventionIdeaInstanceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link InventionIdeaInstanceImpl}.
 * </p>
 *
 * @author lehel
 * @see InventionIdeaInstanceImpl
 * @see InventionIdeaInstance
 * @see InventionIdeaInstanceModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class InventionIdeaInstanceModelImpl extends BaseModelImpl<InventionIdeaInstance>
	implements InventionIdeaInstanceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a invention idea instance model instance should use the {@link InventionIdeaInstance} interface instead.
	 */
	public static final String TABLE_NAME = "le_demo_InventionIdeaInstance";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "id_", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "inventorName", Types.VARCHAR },
			{ "shortDescription", Types.VARCHAR },
			{ "description", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("inventorName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shortDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table le_demo_InventionIdeaInstance (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,inventorName VARCHAR(75) null,shortDescription VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table le_demo_InventionIdeaInstance";
	public static final String ORDER_BY_JPQL = " ORDER BY inventionIdeaInstance.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY le_demo_InventionIdeaInstance.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(hu.webtown.liferay.invention.ideas.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(hu.webtown.liferay.invention.ideas.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(hu.webtown.liferay.invention.ideas.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long INVENTORNAME_COLUMN_BITMASK = 4L;
	public static final long NAME_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static InventionIdeaInstance toModel(
		InventionIdeaInstanceSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		InventionIdeaInstance model = new InventionIdeaInstanceImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setInventorName(soapModel.getInventorName());
		model.setShortDescription(soapModel.getShortDescription());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<InventionIdeaInstance> toModels(
		InventionIdeaInstanceSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<InventionIdeaInstance> models = new ArrayList<InventionIdeaInstance>(soapModels.length);

		for (InventionIdeaInstanceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(hu.webtown.liferay.invention.ideas.service.util.ServiceProps.get(
				"lock.expiration.time.hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance"));

	public InventionIdeaInstanceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getInventorName() {
		if (_inventorName == null) {
			return "";
		}
		else {
			return _inventorName;
		}
	}

	@Override
	public void setInventorName(String inventorName) {
		_columnBitmask |= INVENTORNAME_COLUMN_BITMASK;

		if (_originalInventorName == null) {
			_originalInventorName = _inventorName;
		}

		_inventorName = inventorName;
	}

	public String getOriginalInventorName() {
		return GetterUtil.getString(_originalInventorName);
	}

	@JSON
	@Override
	public String getShortDescription() {
		if (_shortDescription == null) {
			return "";
		}
		else {
			return _shortDescription;
		}
	}

	@Override
	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				InventionIdeaInstance.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			InventionIdeaInstance.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public InventionIdeaInstance toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (InventionIdeaInstance)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		InventionIdeaInstanceImpl inventionIdeaInstanceImpl = new InventionIdeaInstanceImpl();

		inventionIdeaInstanceImpl.setUuid(getUuid());
		inventionIdeaInstanceImpl.setId(getId());
		inventionIdeaInstanceImpl.setGroupId(getGroupId());
		inventionIdeaInstanceImpl.setCompanyId(getCompanyId());
		inventionIdeaInstanceImpl.setUserId(getUserId());
		inventionIdeaInstanceImpl.setUserName(getUserName());
		inventionIdeaInstanceImpl.setCreateDate(getCreateDate());
		inventionIdeaInstanceImpl.setModifiedDate(getModifiedDate());
		inventionIdeaInstanceImpl.setName(getName());
		inventionIdeaInstanceImpl.setInventorName(getInventorName());
		inventionIdeaInstanceImpl.setShortDescription(getShortDescription());
		inventionIdeaInstanceImpl.setDescription(getDescription());

		inventionIdeaInstanceImpl.resetOriginalValues();

		return inventionIdeaInstanceImpl;
	}

	@Override
	public int compareTo(InventionIdeaInstance inventionIdeaInstance) {
		int value = 0;

		value = getName().compareTo(inventionIdeaInstance.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InventionIdeaInstance)) {
			return false;
		}

		InventionIdeaInstance inventionIdeaInstance = (InventionIdeaInstance)obj;

		long primaryKey = inventionIdeaInstance.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		InventionIdeaInstanceModelImpl inventionIdeaInstanceModelImpl = this;

		inventionIdeaInstanceModelImpl._originalUuid = inventionIdeaInstanceModelImpl._uuid;

		inventionIdeaInstanceModelImpl._originalGroupId = inventionIdeaInstanceModelImpl._groupId;

		inventionIdeaInstanceModelImpl._setOriginalGroupId = false;

		inventionIdeaInstanceModelImpl._originalCompanyId = inventionIdeaInstanceModelImpl._companyId;

		inventionIdeaInstanceModelImpl._setOriginalCompanyId = false;

		inventionIdeaInstanceModelImpl._setModifiedDate = false;

		inventionIdeaInstanceModelImpl._originalName = inventionIdeaInstanceModelImpl._name;

		inventionIdeaInstanceModelImpl._originalInventorName = inventionIdeaInstanceModelImpl._inventorName;

		inventionIdeaInstanceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<InventionIdeaInstance> toCacheModel() {
		InventionIdeaInstanceCacheModel inventionIdeaInstanceCacheModel = new InventionIdeaInstanceCacheModel();

		inventionIdeaInstanceCacheModel.uuid = getUuid();

		String uuid = inventionIdeaInstanceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			inventionIdeaInstanceCacheModel.uuid = null;
		}

		inventionIdeaInstanceCacheModel.id = getId();

		inventionIdeaInstanceCacheModel.groupId = getGroupId();

		inventionIdeaInstanceCacheModel.companyId = getCompanyId();

		inventionIdeaInstanceCacheModel.userId = getUserId();

		inventionIdeaInstanceCacheModel.userName = getUserName();

		String userName = inventionIdeaInstanceCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			inventionIdeaInstanceCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			inventionIdeaInstanceCacheModel.createDate = createDate.getTime();
		}
		else {
			inventionIdeaInstanceCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			inventionIdeaInstanceCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			inventionIdeaInstanceCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		inventionIdeaInstanceCacheModel.name = getName();

		String name = inventionIdeaInstanceCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			inventionIdeaInstanceCacheModel.name = null;
		}

		inventionIdeaInstanceCacheModel.inventorName = getInventorName();

		String inventorName = inventionIdeaInstanceCacheModel.inventorName;

		if ((inventorName != null) && (inventorName.length() == 0)) {
			inventionIdeaInstanceCacheModel.inventorName = null;
		}

		inventionIdeaInstanceCacheModel.shortDescription = getShortDescription();

		String shortDescription = inventionIdeaInstanceCacheModel.shortDescription;

		if ((shortDescription != null) && (shortDescription.length() == 0)) {
			inventionIdeaInstanceCacheModel.shortDescription = null;
		}

		inventionIdeaInstanceCacheModel.description = getDescription();

		String description = inventionIdeaInstanceCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			inventionIdeaInstanceCacheModel.description = null;
		}

		return inventionIdeaInstanceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", inventorName=");
		sb.append(getInventorName());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append(
			"hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inventorName</column-name><column-value><![CDATA[");
		sb.append(getInventorName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = InventionIdeaInstance.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			InventionIdeaInstance.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _id;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _originalName;
	private String _inventorName;
	private String _originalInventorName;
	private String _shortDescription;
	private String _description;
	private long _columnBitmask;
	private InventionIdeaInstance _escapedModel;
}