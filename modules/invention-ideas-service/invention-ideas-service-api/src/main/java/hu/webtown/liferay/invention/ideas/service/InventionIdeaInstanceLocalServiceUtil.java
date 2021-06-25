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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for InventionIdeaInstance. This utility wraps
 * {@link hu.webtown.liferay.invention.ideas.service.impl.InventionIdeaInstanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author lehel
 * @see InventionIdeaInstanceLocalService
 * @see hu.webtown.liferay.invention.ideas.service.base.InventionIdeaInstanceLocalServiceBaseImpl
 * @see hu.webtown.liferay.invention.ideas.service.impl.InventionIdeaInstanceLocalServiceImpl
 * @generated
 */
@ProviderType
public class InventionIdeaInstanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.webtown.liferay.invention.ideas.service.impl.InventionIdeaInstanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the invention idea instance to the database. Also notifies the appropriate model listeners.
	*
	* @param inventionIdeaInstance the invention idea instance
	* @return the invention idea instance that was added
	*/
	public static hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance addInventionIdeaInstance(
		hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance inventionIdeaInstance) {
		return getService().addInventionIdeaInstance(inventionIdeaInstance);
	}

	/**
	* Creates a new invention idea instance with the primary key. Does not add the invention idea instance to the database.
	*
	* @param id the primary key for the new invention idea instance
	* @return the new invention idea instance
	*/
	public static hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance createInventionIdeaInstance(
		long id) {
		return getService().createInventionIdeaInstance(id);
	}

	/**
	* Deletes the invention idea instance from the database. Also notifies the appropriate model listeners.
	*
	* @param inventionIdeaInstance the invention idea instance
	* @return the invention idea instance that was removed
	*/
	public static hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance deleteInventionIdeaInstance(
		hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance inventionIdeaInstance) {
		return getService().deleteInventionIdeaInstance(inventionIdeaInstance);
	}

	/**
	* Deletes the invention idea instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance that was removed
	* @throws PortalException if a invention idea instance with the primary key could not be found
	*/
	public static hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance deleteInventionIdeaInstance(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteInventionIdeaInstance(id);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance fetchInventionIdeaInstance(
		long id) {
		return getService().fetchInventionIdeaInstance(id);
	}

	/**
	* Returns the invention idea instance matching the UUID and group.
	*
	* @param uuid the invention idea instance's UUID
	* @param groupId the primary key of the group
	* @return the matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance fetchInventionIdeaInstanceByUuidAndGroupId(
		String uuid, long groupId) {
		return getService()
				   .fetchInventionIdeaInstanceByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the invention idea instance with the primary key.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance
	* @throws PortalException if a invention idea instance with the primary key could not be found
	*/
	public static hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance getInventionIdeaInstance(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getInventionIdeaInstance(id);
	}

	/**
	* Returns the invention idea instance matching the UUID and group.
	*
	* @param uuid the invention idea instance's UUID
	* @param groupId the primary key of the group
	* @return the matching invention idea instance
	* @throws PortalException if a matching invention idea instance could not be found
	*/
	public static hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance getInventionIdeaInstanceByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getInventionIdeaInstanceByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance> getInventionIdeaInstances(
		int start, int end) {
		return getService().getInventionIdeaInstances(start, end);
	}

	/**
	* Returns all the invention idea instances matching the UUID and company.
	*
	* @param uuid the UUID of the invention idea instances
	* @param companyId the primary key of the company
	* @return the matching invention idea instances, or an empty list if no matches were found
	*/
	public static java.util.List<hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance> getInventionIdeaInstancesByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService()
				   .getInventionIdeaInstancesByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance> getInventionIdeaInstancesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance> orderByComparator) {
		return getService()
				   .getInventionIdeaInstancesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of invention idea instances.
	*
	* @return the number of invention idea instances
	*/
	public static int getInventionIdeaInstancesCount() {
		return getService().getInventionIdeaInstancesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the invention idea instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param inventionIdeaInstance the invention idea instance
	* @return the invention idea instance that was updated
	*/
	public static hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance updateInventionIdeaInstance(
		hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance inventionIdeaInstance) {
		return getService().updateInventionIdeaInstance(inventionIdeaInstance);
	}

	public static InventionIdeaInstanceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<InventionIdeaInstanceLocalService, InventionIdeaInstanceLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(InventionIdeaInstanceLocalService.class);

		ServiceTracker<InventionIdeaInstanceLocalService, InventionIdeaInstanceLocalService> serviceTracker =
			new ServiceTracker<InventionIdeaInstanceLocalService, InventionIdeaInstanceLocalService>(bundle.getBundleContext(),
				InventionIdeaInstanceLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}