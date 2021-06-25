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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException;
import hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance;

/**
 * The persistence interface for the invention idea instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lehel
 * @see hu.webtown.liferay.invention.ideas.service.persistence.impl.InventionIdeaInstancePersistenceImpl
 * @see InventionIdeaInstanceUtil
 * @generated
 */
@ProviderType
public interface InventionIdeaInstancePersistence extends BasePersistence<InventionIdeaInstance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InventionIdeaInstanceUtil} to access the invention idea instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the invention idea instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching invention idea instances
	*/
	public java.util.List<InventionIdeaInstance> findByUuid(String uuid);

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
	public java.util.List<InventionIdeaInstance> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<InventionIdeaInstance> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

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
	public java.util.List<InventionIdeaInstance> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first invention idea instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the first invention idea instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

	/**
	* Returns the last invention idea instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the last invention idea instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

	/**
	* Returns the invention idea instances before and after the current invention idea instance in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current invention idea instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public InventionIdeaInstance[] findByUuid_PrevAndNext(long id, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Removes all the invention idea instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of invention idea instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching invention idea instances
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the invention idea instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchInventionIdeaInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the invention idea instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the invention idea instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the invention idea instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the invention idea instance that was removed
	*/
	public InventionIdeaInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the number of invention idea instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching invention idea instances
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the invention idea instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching invention idea instances
	*/
	public java.util.List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId);

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
	public java.util.List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId, int start, int end);

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
	public java.util.List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

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
	public java.util.List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance findByUuid_C_First(String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the first invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance fetchByUuid_C_First(String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

	/**
	* Returns the last invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the last invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance fetchByUuid_C_Last(String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

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
	public InventionIdeaInstance[] findByUuid_C_PrevAndNext(long id,
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Removes all the invention idea instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of invention idea instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching invention idea instances
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the invention idea instances where name = &#63;.
	*
	* @param name the name
	* @return the matching invention idea instances
	*/
	public java.util.List<InventionIdeaInstance> findByName(String name);

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
	public java.util.List<InventionIdeaInstance> findByName(String name,
		int start, int end);

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
	public java.util.List<InventionIdeaInstance> findByName(String name,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

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
	public java.util.List<InventionIdeaInstance> findByName(String name,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first invention idea instance in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance findByName_First(String name,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the first invention idea instance in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance fetchByName_First(String name,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

	/**
	* Returns the last invention idea instance in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance findByName_Last(String name,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the last invention idea instance in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance fetchByName_Last(String name,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

	/**
	* Returns the invention idea instances before and after the current invention idea instance in the ordered set where name = &#63;.
	*
	* @param id the primary key of the current invention idea instance
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public InventionIdeaInstance[] findByName_PrevAndNext(long id, String name,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Removes all the invention idea instances where name = &#63; from the database.
	*
	* @param name the name
	*/
	public void removeByName(String name);

	/**
	* Returns the number of invention idea instances where name = &#63;.
	*
	* @param name the name
	* @return the number of matching invention idea instances
	*/
	public int countByName(String name);

	/**
	* Returns all the invention idea instances where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @return the matching invention idea instances
	*/
	public java.util.List<InventionIdeaInstance> findByInventorName(
		String inventorName);

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
	public java.util.List<InventionIdeaInstance> findByInventorName(
		String inventorName, int start, int end);

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
	public java.util.List<InventionIdeaInstance> findByInventorName(
		String inventorName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

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
	public java.util.List<InventionIdeaInstance> findByInventorName(
		String inventorName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first invention idea instance in the ordered set where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance findByInventorName_First(String inventorName,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the first invention idea instance in the ordered set where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance fetchByInventorName_First(
		String inventorName,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

	/**
	* Returns the last invention idea instance in the ordered set where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance findByInventorName_Last(String inventorName,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the last invention idea instance in the ordered set where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	*/
	public InventionIdeaInstance fetchByInventorName_Last(String inventorName,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

	/**
	* Returns the invention idea instances before and after the current invention idea instance in the ordered set where inventorName = &#63;.
	*
	* @param id the primary key of the current invention idea instance
	* @param inventorName the inventor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public InventionIdeaInstance[] findByInventorName_PrevAndNext(long id,
		String inventorName,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Removes all the invention idea instances where inventorName = &#63; from the database.
	*
	* @param inventorName the inventor name
	*/
	public void removeByInventorName(String inventorName);

	/**
	* Returns the number of invention idea instances where inventorName = &#63;.
	*
	* @param inventorName the inventor name
	* @return the number of matching invention idea instances
	*/
	public int countByInventorName(String inventorName);

	/**
	* Caches the invention idea instance in the entity cache if it is enabled.
	*
	* @param inventionIdeaInstance the invention idea instance
	*/
	public void cacheResult(InventionIdeaInstance inventionIdeaInstance);

	/**
	* Caches the invention idea instances in the entity cache if it is enabled.
	*
	* @param inventionIdeaInstances the invention idea instances
	*/
	public void cacheResult(
		java.util.List<InventionIdeaInstance> inventionIdeaInstances);

	/**
	* Creates a new invention idea instance with the primary key. Does not add the invention idea instance to the database.
	*
	* @param id the primary key for the new invention idea instance
	* @return the new invention idea instance
	*/
	public InventionIdeaInstance create(long id);

	/**
	* Removes the invention idea instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance that was removed
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public InventionIdeaInstance remove(long id)
		throws NoSuchInventionIdeaInstanceException;

	public InventionIdeaInstance updateImpl(
		InventionIdeaInstance inventionIdeaInstance);

	/**
	* Returns the invention idea instance with the primary key or throws a {@link NoSuchInventionIdeaInstanceException} if it could not be found.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance
	* @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	*/
	public InventionIdeaInstance findByPrimaryKey(long id)
		throws NoSuchInventionIdeaInstanceException;

	/**
	* Returns the invention idea instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the invention idea instance
	* @return the invention idea instance, or <code>null</code> if a invention idea instance with the primary key could not be found
	*/
	public InventionIdeaInstance fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, InventionIdeaInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the invention idea instances.
	*
	* @return the invention idea instances
	*/
	public java.util.List<InventionIdeaInstance> findAll();

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
	public java.util.List<InventionIdeaInstance> findAll(int start, int end);

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
	public java.util.List<InventionIdeaInstance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator);

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
	public java.util.List<InventionIdeaInstance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the invention idea instances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of invention idea instances.
	*
	* @return the number of invention idea instances
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}