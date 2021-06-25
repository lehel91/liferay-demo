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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InventionIdeaInstanceLocalService}.
 *
 * @author lehel
 * @see InventionIdeaInstanceLocalService
 * @generated
 */
@ProviderType
public class InventionIdeaInstanceLocalServiceWrapper
	implements InventionIdeaInstanceLocalService,
		ServiceWrapper<InventionIdeaInstanceLocalService> {
	public InventionIdeaInstanceLocalServiceWrapper(
		InventionIdeaInstanceLocalService inventionIdeaInstanceLocalService) {
		_inventionIdeaInstanceLocalService = inventionIdeaInstanceLocalService;
	}

	/**
	* Adds the invention idea instance to the database. Also notifies the appropriate model listeners.
	*
	* @param inventionIdeaInstance the invention idea instance
	* @return the invention idea instance that was added
	*/
	@Override
	public hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance addInventionIdeaInstance(
		hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance inventionIdeaInstance) {
		return _inventionIdeaInstanceLocalService.addInventionIdeaInstance(inventionIdeaInstance);
	}

	/**
	* Creates a new invention idea instance with the primary key. Does not add the invention idea instance to the database.
	*
	* @param id the primary key for the new invention idea instance
	* @return the new invention idea instance
	*/
	@Override
	public hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance createInventionIdeaInstance(
		long id) {
		return _inventionIdeaInstanceLocalService.createInventionIdeaInstance(id);
	}

	/**
	* Deletes the invention idea instance from the database. Also notifies the appropriate model listeners.
	*
	* @param inventionIdeaInstance the invention idea instance
	* @return the invention idea instance that was removed
	*/
	@Override
	public hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance deleteInventionIdeaInstance(
		hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance inventionIdeaInstance) {
		return _inventionIdeaInstanceLocalService.deleteInventionIdeaInstance(inventionIdeaInstance);
	}

	/**
	* Deletes the invention idea instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance that was removed
	* @throws PortalException if a invention idea instance with the primary key could not be found
	*/
	@Override
	public hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance deleteInventionIdeaInstance(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _inventionIdeaInstanceLocalService.deleteInventionIdeaInstance(id);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _inventionIdeaInstanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _inventionIdeaInstanceLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _inventionIdeaInstanceLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _inventionIdeaInstanceLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _inventionIdeaInstanceLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _inventionIdeaInstanceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _inventionIdeaInstanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance fetchInventionIdeaInstance(
		long id) {
		return _inventionIdeaInstanceLocalService.fetchInventionIdeaInstance(id);
	}

	/**
	* Returns the invention idea instance matching the UUID and group.
	*
	* @param uuid the invention idea instance's UUID
	* @param groupId the primary key of the group
	* @return the matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	@Override
	public hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance fetchInventionIdeaInstanceByUuidAndGroupId(
		String uuid, long groupId) {
		return _inventionIdeaInstanceLocalService.fetchInventionIdeaInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _inventionIdeaInstanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _inventionIdeaInstanceLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _inventionIdeaInstanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the invention idea instance with the primary key.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance
	* @throws PortalException if a invention idea instance with the primary key could not be found
	*/
	@Override
	public hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance getInventionIdeaInstance(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _inventionIdeaInstanceLocalService.getInventionIdeaInstance(id);
	}

	/**
	* Returns the invention idea instance matching the UUID and group.
	*
	* @param uuid the invention idea instance's UUID
	* @param groupId the primary key of the group
	* @return the matching invention idea instance
	* @throws PortalException if a matching invention idea instance could not be found
	*/
	@Override
	public hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance getInventionIdeaInstanceByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _inventionIdeaInstanceLocalService.getInventionIdeaInstanceByUuidAndGroupId(uuid,
			groupId);
	}

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
	@Override
	public java.util.List<hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance> getInventionIdeaInstances(
		int start, int end) {
		return _inventionIdeaInstanceLocalService.getInventionIdeaInstances(start,
			end);
	}

	/**
	* Returns all the invention idea instances matching the UUID and company.
	*
	* @param uuid the UUID of the invention idea instances
	* @param companyId the primary key of the company
	* @return the matching invention idea instances, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance> getInventionIdeaInstancesByUuidAndCompanyId(
		String uuid, long companyId) {
		return _inventionIdeaInstanceLocalService.getInventionIdeaInstancesByUuidAndCompanyId(uuid,
			companyId);
	}

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
	@Override
	public java.util.List<hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance> getInventionIdeaInstancesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance> orderByComparator) {
		return _inventionIdeaInstanceLocalService.getInventionIdeaInstancesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of invention idea instances.
	*
	* @return the number of invention idea instances
	*/
	@Override
	public int getInventionIdeaInstancesCount() {
		return _inventionIdeaInstanceLocalService.getInventionIdeaInstancesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _inventionIdeaInstanceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _inventionIdeaInstanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the invention idea instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param inventionIdeaInstance the invention idea instance
	* @return the invention idea instance that was updated
	*/
	@Override
	public hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance updateInventionIdeaInstance(
		hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance inventionIdeaInstance) {
		return _inventionIdeaInstanceLocalService.updateInventionIdeaInstance(inventionIdeaInstance);
	}

	@Override
	public InventionIdeaInstanceLocalService getWrappedService() {
		return _inventionIdeaInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		InventionIdeaInstanceLocalService inventionIdeaInstanceLocalService) {
		_inventionIdeaInstanceLocalService = inventionIdeaInstanceLocalService;
	}

	private InventionIdeaInstanceLocalService _inventionIdeaInstanceLocalService;
}