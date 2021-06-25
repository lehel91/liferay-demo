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

package hu.webtown.liferay.invention.ideas.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for InventionIdeaInstance. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author lehel
 * @see InventionIdeaInstanceLocalServiceUtil
 * @see hu.webtown.liferay.invention.ideas.service.base.InventionIdeaInstanceLocalServiceBaseImpl
 * @see hu.webtown.liferay.invention.ideas.service.impl.InventionIdeaInstanceLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface InventionIdeaInstanceLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InventionIdeaInstanceLocalServiceUtil} to access the invention idea instance local service. Add custom service methods to {@link hu.webtown.liferay.invention.ideas.service.impl.InventionIdeaInstanceLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the invention idea instance to the database. Also notifies the appropriate model listeners.
	*
	* @param inventionIdeaInstance the invention idea instance
	* @return the invention idea instance that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public InventionIdeaInstance addInventionIdeaInstance(
		InventionIdeaInstance inventionIdeaInstance);

	/**
	* Creates a new invention idea instance with the primary key. Does not add the invention idea instance to the database.
	*
	* @param id the primary key for the new invention idea instance
	* @return the new invention idea instance
	*/
	@Transactional(enabled = false)
	public InventionIdeaInstance createInventionIdeaInstance(long id);

	/**
	* Deletes the invention idea instance from the database. Also notifies the appropriate model listeners.
	*
	* @param inventionIdeaInstance the invention idea instance
	* @return the invention idea instance that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public InventionIdeaInstance deleteInventionIdeaInstance(
		InventionIdeaInstance inventionIdeaInstance);

	/**
	* Deletes the invention idea instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance that was removed
	* @throws PortalException if a invention idea instance with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public InventionIdeaInstance deleteInventionIdeaInstance(long id)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.invention.ideas.model.impl.InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.invention.ideas.model.impl.InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public InventionIdeaInstance fetchInventionIdeaInstance(long id);

	/**
	* Returns the invention idea instance matching the UUID and group.
	*
	* @param uuid the invention idea instance's UUID
	* @param groupId the primary key of the group
	* @return the matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public InventionIdeaInstance fetchInventionIdeaInstanceByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the invention idea instance with the primary key.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance
	* @throws PortalException if a invention idea instance with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public InventionIdeaInstance getInventionIdeaInstance(long id)
		throws PortalException;

	/**
	* Returns the invention idea instance matching the UUID and group.
	*
	* @param uuid the invention idea instance's UUID
	* @param groupId the primary key of the group
	* @return the matching invention idea instance
	* @throws PortalException if a matching invention idea instance could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public InventionIdeaInstance getInventionIdeaInstanceByUuidAndGroupId(
		String uuid, long groupId) throws PortalException;

	/**
	* Returns a range of all the invention idea instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.invention.ideas.model.impl.InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @return the range of invention idea instances
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InventionIdeaInstance> getInventionIdeaInstances(int start,
		int end);

	/**
	* Returns all the invention idea instances matching the UUID and company.
	*
	* @param uuid the UUID of the invention idea instances
	* @param companyId the primary key of the company
	* @return the matching invention idea instances, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InventionIdeaInstance> getInventionIdeaInstancesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	* Returns a range of invention idea instances matching the UUID and company.
	*
	* @param uuid the UUID of the invention idea instances
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching invention idea instances, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InventionIdeaInstance> getInventionIdeaInstancesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator);

	/**
	* Returns the number of invention idea instances.
	*
	* @return the number of invention idea instances
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getInventionIdeaInstancesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Updates the invention idea instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param inventionIdeaInstance the invention idea instance
	* @return the invention idea instance that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public InventionIdeaInstance updateInventionIdeaInstance(
		InventionIdeaInstance inventionIdeaInstance);
}