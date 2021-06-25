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

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;

import hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing InventionIdeaInstance in entity cache.
 *
 * @author lehel
 * @see InventionIdeaInstance
 * @generated
 */
@ProviderType
public class InventionIdeaInstanceCacheModel implements CacheModel<InventionIdeaInstance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InventionIdeaInstanceCacheModel)) {
			return false;
		}

		InventionIdeaInstanceCacheModel inventionIdeaInstanceCacheModel = (InventionIdeaInstanceCacheModel)obj;

		if (id == inventionIdeaInstanceCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", inventorName=");
		sb.append(inventorName);
		sb.append(", shortDescription=");
		sb.append(shortDescription);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InventionIdeaInstance toEntityModel() {
		InventionIdeaInstanceImpl inventionIdeaInstanceImpl = new InventionIdeaInstanceImpl();

		if (uuid == null) {
			inventionIdeaInstanceImpl.setUuid("");
		}
		else {
			inventionIdeaInstanceImpl.setUuid(uuid);
		}

		inventionIdeaInstanceImpl.setId(id);
		inventionIdeaInstanceImpl.setGroupId(groupId);
		inventionIdeaInstanceImpl.setCompanyId(companyId);
		inventionIdeaInstanceImpl.setUserId(userId);

		if (userName == null) {
			inventionIdeaInstanceImpl.setUserName("");
		}
		else {
			inventionIdeaInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			inventionIdeaInstanceImpl.setCreateDate(null);
		}
		else {
			inventionIdeaInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			inventionIdeaInstanceImpl.setModifiedDate(null);
		}
		else {
			inventionIdeaInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			inventionIdeaInstanceImpl.setName("");
		}
		else {
			inventionIdeaInstanceImpl.setName(name);
		}

		if (inventorName == null) {
			inventionIdeaInstanceImpl.setInventorName("");
		}
		else {
			inventionIdeaInstanceImpl.setInventorName(inventorName);
		}

		if (shortDescription == null) {
			inventionIdeaInstanceImpl.setShortDescription("");
		}
		else {
			inventionIdeaInstanceImpl.setShortDescription(shortDescription);
		}

		if (description == null) {
			inventionIdeaInstanceImpl.setDescription("");
		}
		else {
			inventionIdeaInstanceImpl.setDescription(description);
		}

		inventionIdeaInstanceImpl.resetOriginalValues();

		return inventionIdeaInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		inventorName = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (inventorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(inventorName);
		}

		if (shortDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortDescription);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String inventorName;
	public String shortDescription;
	public String description;
}