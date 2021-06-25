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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the InventionIdeaInstance service. Represents a row in the &quot;le_demo_InventionIdeaInstance&quot; database table, with each column mapped to a property of this class.
 *
 * @author lehel
 * @see InventionIdeaInstanceModel
 * @see hu.webtown.liferay.invention.ideas.model.impl.InventionIdeaInstanceImpl
 * @see hu.webtown.liferay.invention.ideas.model.impl.InventionIdeaInstanceModelImpl
 * @generated
 */
@ImplementationClassName("hu.webtown.liferay.invention.ideas.model.impl.InventionIdeaInstanceImpl")
@ProviderType
public interface InventionIdeaInstance extends InventionIdeaInstanceModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link hu.webtown.liferay.invention.ideas.model.impl.InventionIdeaInstanceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<InventionIdeaInstance, Long> ID_ACCESSOR = new Accessor<InventionIdeaInstance, Long>() {
			@Override
			public Long get(InventionIdeaInstance inventionIdeaInstance) {
				return inventionIdeaInstance.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<InventionIdeaInstance> getTypeClass() {
				return InventionIdeaInstance.class;
			}
		};
}