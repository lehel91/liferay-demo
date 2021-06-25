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

package hu.webtown.liferay.invention.ideas.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the invention idea instance service. This utility wraps {@link hu.webtown.liferay.invention.ideas.service.persistence.impl.InventionIdeaInstancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lehel
 * @see InventionIdeaInstancePersistence
 * @see hu.webtown.liferay.invention.ideas.service.persistence.impl.InventionIdeaInstancePersistenceImpl
 * @generated
 */
@ProviderType
public class InventionIdeaInstanceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(InventionIdeaInstance inventionIdeaInstance) {
		getPersistence().clearCache(inventionIdeaInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<InventionIdeaInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InventionIdeaInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InventionIdeaInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InventionIdeaInstance update(
		InventionIdeaInstance inventionIdeaInstance) {
		return getPersistence().update(inventionIdeaInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InventionIdeaInstance update(
		InventionIdeaInstance inventionIdeaInstance,
		ServiceContext serviceContext) {
		return getPersistence().update(inventionIdeaInstance, serviceContext);
	}

	/**
	* Returns all the invention idea instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the invention idea instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @return the range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the invention idea instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the invention idea instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first invention idea instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance findByUuid_First(String uuid,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first invention idea instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance fetchByUuid_First(String uuid,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last invention idea instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance findByUuid_Last(String uuid,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last invention idea instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance fetchByUuid_Last(String uuid,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the invention idea instances before and after the current invention idea instance in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current invention idea instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public static InventionIdeaInstance[] findByUuid_PrevAndNext(long id,
		String uuid, OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence()
				   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
	}

	/**
	* Removes all the invention idea instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of invention idea instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching invention idea instances
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the invention idea instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchInventionIdeaInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance findByUUID_G(String uuid, long groupId)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the invention idea instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the invention idea instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance fetchByUUID_G(String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the invention idea instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the invention idea instance that was removed
	*/
	public static InventionIdeaInstance removeByUUID_G(String uuid, long groupId)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of invention idea instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching invention idea instances
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the invention idea instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the invention idea instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @return the range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the invention idea instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the invention idea instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance findByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance fetchByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance findByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance fetchByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the invention idea instances before and after the current invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param id the primary key of the current invention idea instance
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public static InventionIdeaInstance[] findByUuid_C_PrevAndNext(long id,
		String uuid, long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(id, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the invention idea instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of invention idea instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching invention idea instances
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the invention idea instances where name = &#63;.
	*
	* @param name the name
	* @return the matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the invention idea instances where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @return the range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByName(String name,
		int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the invention idea instances where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByName(String name,
		int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the invention idea instances where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByName(String name,
		int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByName(name, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first invention idea instance in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance findByName_First(String name,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first invention idea instance in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance fetchByName_First(String name,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last invention idea instance in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance findByName_Last(String name,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last invention idea instance in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance fetchByName_Last(String name,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the invention idea instances before and after the current invention idea instance in the ordered set where name = &#63;.
	*
	* @param id the primary key of the current invention idea instance
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public static InventionIdeaInstance[] findByName_PrevAndNext(long id,
		String name, OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence()
				   .findByName_PrevAndNext(id, name, orderByComparator);
	}

	/**
	* Removes all the invention idea instances where name = &#63; from the database.
	*
	* @param name the name
	*/
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of invention idea instances where name = &#63;.
	*
	* @param name the name
	* @return the number of matching invention idea instances
	*/
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the invention idea instances where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @return the matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByInventorName(
		String inventorName) {
		return getPersistence().findByInventorName(inventorName);
	}

	/**
	* Returns a range of all the invention idea instances where inventorName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inventorName the inventor name
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @return the range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByInventorName(
		String inventorName, int start, int end) {
		return getPersistence().findByInventorName(inventorName, start, end);
	}

	/**
	* Returns an ordered range of all the invention idea instances where inventorName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inventorName the inventor name
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByInventorName(
		String inventorName, int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence()
				   .findByInventorName(inventorName, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the invention idea instances where inventorName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inventorName the inventor name
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching invention idea instances
	*/
	public static List<InventionIdeaInstance> findByInventorName(
		String inventorName, int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByInventorName(inventorName, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first invention idea instance in the ordered set where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance findByInventorName_First(
		String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence()
				   .findByInventorName_First(inventorName, orderByComparator);
	}

	/**
	* Returns the first invention idea instance in the ordered set where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance fetchByInventorName_First(
		String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence()
				   .fetchByInventorName_First(inventorName, orderByComparator);
	}

	/**
	* Returns the last invention idea instance in the ordered set where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance findByInventorName_Last(
		String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence()
				   .findByInventorName_Last(inventorName, orderByComparator);
	}

	/**
	* Returns the last invention idea instance in the ordered set where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public static InventionIdeaInstance fetchByInventorName_Last(
		String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence()
				   .fetchByInventorName_Last(inventorName, orderByComparator);
	}

	/**
	* Returns the invention idea instances before and after the current invention idea instance in the ordered set where inventorName = &#63;.
	*
	* @param id the primary key of the current invention idea instance
	* @param inventorName the inventor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public static InventionIdeaInstance[] findByInventorName_PrevAndNext(
		long id, String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence()
				   .findByInventorName_PrevAndNext(id, inventorName,
			orderByComparator);
	}

	/**
	* Removes all the invention idea instances where inventorName = &#63; from the database.
	*
	* @param inventorName the inventor name
	*/
	public static void removeByInventorName(String inventorName) {
		getPersistence().removeByInventorName(inventorName);
	}

	/**
	* Returns the number of invention idea instances where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @return the number of matching invention idea instances
	*/
	public static int countByInventorName(String inventorName) {
		return getPersistence().countByInventorName(inventorName);
	}

	/**
	* Caches the invention idea instance in the entity cache if it is enabled.
	*
	* @param inventionIdeaInstance the invention idea instance
	*/
	public static void cacheResult(InventionIdeaInstance inventionIdeaInstance) {
		getPersistence().cacheResult(inventionIdeaInstance);
	}

	/**
	* Caches the invention idea instances in the entity cache if it is enabled.
	*
	* @param inventionIdeaInstances the invention idea instances
	*/
	public static void cacheResult(
		List<InventionIdeaInstance> inventionIdeaInstances) {
		getPersistence().cacheResult(inventionIdeaInstances);
	}

	/**
	* Creates a new invention idea instance with the primary key. Does not add the invention idea instance to the database.
	*
	* @param id the primary key for the new invention idea instance
	* @return the new invention idea instance
	*/
	public static InventionIdeaInstance create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the invention idea instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance that was removed
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public static InventionIdeaInstance remove(long id)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence().remove(id);
	}

	public static InventionIdeaInstance updateImpl(
		InventionIdeaInstance inventionIdeaInstance) {
		return getPersistence().updateImpl(inventionIdeaInstance);
	}

	/**
	* Returns the invention idea instance with the primary key or throws a {@link NoSuchInventionIdeaInstanceException} if it could not be found.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public static InventionIdeaInstance findByPrimaryKey(long id)
		throws hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the invention idea instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance, or <code>null</code> if a invention idea instance with the primary key could not be found
	*/
	public static InventionIdeaInstance fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, InventionIdeaInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the invention idea instances.
	*
	* @return the invention idea instances
	*/
	public static List<InventionIdeaInstance> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the invention idea instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @return the range of invention idea instances
	*/
	public static List<InventionIdeaInstance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the invention idea instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of invention idea instances
	*/
	public static List<InventionIdeaInstance> findAll(int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the invention idea instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InventionIdeaInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invention idea instances
	* @param end the upper bound of the range of invention idea instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of invention idea instances
	*/
	public static List<InventionIdeaInstance> findAll(int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the invention idea instances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of invention idea instances.
	*
	* @return the number of invention idea instances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static InventionIdeaInstancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<InventionIdeaInstancePersistence, InventionIdeaInstancePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(InventionIdeaInstancePersistence.class);

		ServiceTracker<InventionIdeaInstancePersistence, InventionIdeaInstancePersistence> serviceTracker =
			new ServiceTracker<InventionIdeaInstancePersistence, InventionIdeaInstancePersistence>(bundle.getBundleContext(),
				InventionIdeaInstancePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}