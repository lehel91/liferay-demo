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

package hu.webtown.liferay.invention.ideas.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import hu.webtown.liferay.invention.ideas.exception.NoSuchInventionIdeaInstanceException;
import hu.webtown.liferay.invention.ideas.model.InventionIdeaInstance;
import hu.webtown.liferay.invention.ideas.model.impl.InventionIdeaInstanceImpl;
import hu.webtown.liferay.invention.ideas.model.impl.InventionIdeaInstanceModelImpl;
import hu.webtown.liferay.invention.ideas.service.persistence.InventionIdeaInstancePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the invention idea instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author lehel
 * @see InventionIdeaInstancePersistence
 * @see hu.webtown.liferay.invention.ideas.service.persistence.InventionIdeaInstanceUtil
 * @generated
 */
@ProviderType
public class InventionIdeaInstancePersistenceImpl extends BasePersistenceImpl<InventionIdeaInstance>
	implements InventionIdeaInstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InventionIdeaInstanceUtil} to access the invention idea instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InventionIdeaInstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			InventionIdeaInstanceModelImpl.UUID_COLUMN_BITMASK |
			InventionIdeaInstanceModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the invention idea instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching invention idea instances
	 */
	@Override
	public List<InventionIdeaInstance> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<InventionIdeaInstance> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<InventionIdeaInstance> findByUuid(String uuid, int start,
		int end, OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<InventionIdeaInstance> findByUuid(String uuid, int start,
		int end, OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<InventionIdeaInstance> list = null;

		if (retrieveFromCache) {
			list = (List<InventionIdeaInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InventionIdeaInstance inventionIdeaInstance : list) {
					if (!Objects.equals(uuid, inventionIdeaInstance.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InventionIdeaInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<InventionIdeaInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InventionIdeaInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first invention idea instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invention idea instance
	 * @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance findByUuid_First(String uuid,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = fetchByUuid_First(uuid,
				orderByComparator);

		if (inventionIdeaInstance != null) {
			return inventionIdeaInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchInventionIdeaInstanceException(msg.toString());
	}

	/**
	 * Returns the first invention idea instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByUuid_First(String uuid,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		List<InventionIdeaInstance> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invention idea instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invention idea instance
	 * @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance findByUuid_Last(String uuid,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = fetchByUuid_Last(uuid,
				orderByComparator);

		if (inventionIdeaInstance != null) {
			return inventionIdeaInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchInventionIdeaInstanceException(msg.toString());
	}

	/**
	 * Returns the last invention idea instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByUuid_Last(String uuid,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<InventionIdeaInstance> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public InventionIdeaInstance[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			InventionIdeaInstance[] array = new InventionIdeaInstanceImpl[3];

			array[0] = getByUuid_PrevAndNext(session, inventionIdeaInstance,
					uuid, orderByComparator, true);

			array[1] = inventionIdeaInstance;

			array[2] = getByUuid_PrevAndNext(session, inventionIdeaInstance,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected InventionIdeaInstance getByUuid_PrevAndNext(Session session,
		InventionIdeaInstance inventionIdeaInstance, String uuid,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(InventionIdeaInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(inventionIdeaInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<InventionIdeaInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invention idea instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (InventionIdeaInstance inventionIdeaInstance : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(inventionIdeaInstance);
		}
	}

	/**
	 * Returns the number of invention idea instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching invention idea instances
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVENTIONIDEAINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "inventionIdeaInstance.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "inventionIdeaInstance.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(inventionIdeaInstance.uuid IS NULL OR inventionIdeaInstance.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			InventionIdeaInstanceModelImpl.UUID_COLUMN_BITMASK |
			InventionIdeaInstanceModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the invention idea instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchInventionIdeaInstanceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching invention idea instance
	 * @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = fetchByUUID_G(uuid,
				groupId);

		if (inventionIdeaInstance == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchInventionIdeaInstanceException(msg.toString());
		}

		return inventionIdeaInstance;
	}

	/**
	 * Returns the invention idea instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the invention idea instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof InventionIdeaInstance) {
			InventionIdeaInstance inventionIdeaInstance = (InventionIdeaInstance)result;

			if (!Objects.equals(uuid, inventionIdeaInstance.getUuid()) ||
					(groupId != inventionIdeaInstance.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<InventionIdeaInstance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					InventionIdeaInstance inventionIdeaInstance = list.get(0);

					result = inventionIdeaInstance;

					cacheResult(inventionIdeaInstance);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (InventionIdeaInstance)result;
		}
	}

	/**
	 * Removes the invention idea instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the invention idea instance that was removed
	 */
	@Override
	public InventionIdeaInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = findByUUID_G(uuid, groupId);

		return remove(inventionIdeaInstance);
	}

	/**
	 * Returns the number of invention idea instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching invention idea instances
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INVENTIONIDEAINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "inventionIdeaInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "inventionIdeaInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(inventionIdeaInstance.uuid IS NULL OR inventionIdeaInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "inventionIdeaInstance.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			InventionIdeaInstanceModelImpl.UUID_COLUMN_BITMASK |
			InventionIdeaInstanceModelImpl.COMPANYID_COLUMN_BITMASK |
			InventionIdeaInstanceModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the invention idea instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching invention idea instances
	 */
	@Override
	public List<InventionIdeaInstance> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<InventionIdeaInstance> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<InventionIdeaInstance> list = null;

		if (retrieveFromCache) {
			list = (List<InventionIdeaInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InventionIdeaInstance inventionIdeaInstance : list) {
					if (!Objects.equals(uuid, inventionIdeaInstance.getUuid()) ||
							(companyId != inventionIdeaInstance.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InventionIdeaInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<InventionIdeaInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InventionIdeaInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public InventionIdeaInstance findByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (inventionIdeaInstance != null) {
			return inventionIdeaInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchInventionIdeaInstanceException(msg.toString());
	}

	/**
	 * Returns the first invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		List<InventionIdeaInstance> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public InventionIdeaInstance findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (inventionIdeaInstance != null) {
			return inventionIdeaInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchInventionIdeaInstanceException(msg.toString());
	}

	/**
	 * Returns the last invention idea instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<InventionIdeaInstance> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public InventionIdeaInstance[] findByUuid_C_PrevAndNext(long id,
		String uuid, long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			InventionIdeaInstance[] array = new InventionIdeaInstanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, inventionIdeaInstance,
					uuid, companyId, orderByComparator, true);

			array[1] = inventionIdeaInstance;

			array[2] = getByUuid_C_PrevAndNext(session, inventionIdeaInstance,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected InventionIdeaInstance getByUuid_C_PrevAndNext(Session session,
		InventionIdeaInstance inventionIdeaInstance, String uuid,
		long companyId,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(InventionIdeaInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(inventionIdeaInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<InventionIdeaInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invention idea instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (InventionIdeaInstance inventionIdeaInstance : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(inventionIdeaInstance);
		}
	}

	/**
	 * Returns the number of invention idea instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching invention idea instances
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INVENTIONIDEAINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "inventionIdeaInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "inventionIdeaInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(inventionIdeaInstance.uuid IS NULL OR inventionIdeaInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "inventionIdeaInstance.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			InventionIdeaInstanceModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the invention idea instances where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching invention idea instances
	 */
	@Override
	public List<InventionIdeaInstance> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<InventionIdeaInstance> findByName(String name, int start,
		int end) {
		return findByName(name, start, end, null);
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
	@Override
	public List<InventionIdeaInstance> findByName(String name, int start,
		int end, OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return findByName(name, start, end, orderByComparator, true);
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
	@Override
	public List<InventionIdeaInstance> findByName(String name, int start,
		int end, OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<InventionIdeaInstance> list = null;

		if (retrieveFromCache) {
			list = (List<InventionIdeaInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InventionIdeaInstance inventionIdeaInstance : list) {
					if (!Objects.equals(name, inventionIdeaInstance.getName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals("")) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InventionIdeaInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<InventionIdeaInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InventionIdeaInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first invention idea instance in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invention idea instance
	 * @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance findByName_First(String name,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = fetchByName_First(name,
				orderByComparator);

		if (inventionIdeaInstance != null) {
			return inventionIdeaInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append("}");

		throw new NoSuchInventionIdeaInstanceException(msg.toString());
	}

	/**
	 * Returns the first invention idea instance in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByName_First(String name,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		List<InventionIdeaInstance> list = findByName(name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invention idea instance in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invention idea instance
	 * @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance findByName_Last(String name,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = fetchByName_Last(name,
				orderByComparator);

		if (inventionIdeaInstance != null) {
			return inventionIdeaInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append("}");

		throw new NoSuchInventionIdeaInstanceException(msg.toString());
	}

	/**
	 * Returns the last invention idea instance in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByName_Last(String name,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<InventionIdeaInstance> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public InventionIdeaInstance[] findByName_PrevAndNext(long id, String name,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			InventionIdeaInstance[] array = new InventionIdeaInstanceImpl[3];

			array[0] = getByName_PrevAndNext(session, inventionIdeaInstance,
					name, orderByComparator, true);

			array[1] = inventionIdeaInstance;

			array[2] = getByName_PrevAndNext(session, inventionIdeaInstance,
					name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected InventionIdeaInstance getByName_PrevAndNext(Session session,
		InventionIdeaInstance inventionIdeaInstance, String name,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals("")) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(InventionIdeaInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(inventionIdeaInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<InventionIdeaInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invention idea instances where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (InventionIdeaInstance inventionIdeaInstance : findByName(name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(inventionIdeaInstance);
		}
	}

	/**
	 * Returns the number of invention idea instances where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching invention idea instances
	 */
	@Override
	public int countByName(String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVENTIONIDEAINSTANCE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals("")) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "inventionIdeaInstance.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "inventionIdeaInstance.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(inventionIdeaInstance.name IS NULL OR inventionIdeaInstance.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INVENTORNAME =
		new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInventorName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVENTORNAME =
		new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInventorName",
			new String[] { String.class.getName() },
			InventionIdeaInstanceModelImpl.INVENTORNAME_COLUMN_BITMASK |
			InventionIdeaInstanceModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INVENTORNAME = new FinderPath(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInventorName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the invention idea instances where inventorName = &#63;.
	 *
	 * @param inventorName the inventor name
	 * @return the matching invention idea instances
	 */
	@Override
	public List<InventionIdeaInstance> findByInventorName(String inventorName) {
		return findByInventorName(inventorName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<InventionIdeaInstance> findByInventorName(String inventorName,
		int start, int end) {
		return findByInventorName(inventorName, start, end, null);
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
	@Override
	public List<InventionIdeaInstance> findByInventorName(String inventorName,
		int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return findByInventorName(inventorName, start, end, orderByComparator,
			true);
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
	@Override
	public List<InventionIdeaInstance> findByInventorName(String inventorName,
		int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVENTORNAME;
			finderArgs = new Object[] { inventorName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INVENTORNAME;
			finderArgs = new Object[] {
					inventorName,
					
					start, end, orderByComparator
				};
		}

		List<InventionIdeaInstance> list = null;

		if (retrieveFromCache) {
			list = (List<InventionIdeaInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InventionIdeaInstance inventionIdeaInstance : list) {
					if (!Objects.equals(inventorName,
								inventionIdeaInstance.getInventorName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE);

			boolean bindInventorName = false;

			if (inventorName == null) {
				query.append(_FINDER_COLUMN_INVENTORNAME_INVENTORNAME_1);
			}
			else if (inventorName.equals("")) {
				query.append(_FINDER_COLUMN_INVENTORNAME_INVENTORNAME_3);
			}
			else {
				bindInventorName = true;

				query.append(_FINDER_COLUMN_INVENTORNAME_INVENTORNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InventionIdeaInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindInventorName) {
					qPos.add(inventorName);
				}

				if (!pagination) {
					list = (List<InventionIdeaInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InventionIdeaInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first invention idea instance in the ordered set where inventorName = &#63;.
	 *
	 * @param inventorName the inventor name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invention idea instance
	 * @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance findByInventorName_First(String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = fetchByInventorName_First(inventorName,
				orderByComparator);

		if (inventionIdeaInstance != null) {
			return inventionIdeaInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("inventorName=");
		msg.append(inventorName);

		msg.append("}");

		throw new NoSuchInventionIdeaInstanceException(msg.toString());
	}

	/**
	 * Returns the first invention idea instance in the ordered set where inventorName = &#63;.
	 *
	 * @param inventorName the inventor name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByInventorName_First(
		String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		List<InventionIdeaInstance> list = findByInventorName(inventorName, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invention idea instance in the ordered set where inventorName = &#63;.
	 *
	 * @param inventorName the inventor name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invention idea instance
	 * @throws NoSuchInventionIdeaInstanceException if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance findByInventorName_Last(String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = fetchByInventorName_Last(inventorName,
				orderByComparator);

		if (inventionIdeaInstance != null) {
			return inventionIdeaInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("inventorName=");
		msg.append(inventorName);

		msg.append("}");

		throw new NoSuchInventionIdeaInstanceException(msg.toString());
	}

	/**
	 * Returns the last invention idea instance in the ordered set where inventorName = &#63;.
	 *
	 * @param inventorName the inventor name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invention idea instance, or <code>null</code> if a matching invention idea instance could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByInventorName_Last(String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		int count = countByInventorName(inventorName);

		if (count == 0) {
			return null;
		}

		List<InventionIdeaInstance> list = findByInventorName(inventorName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public InventionIdeaInstance[] findByInventorName_PrevAndNext(long id,
		String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			InventionIdeaInstance[] array = new InventionIdeaInstanceImpl[3];

			array[0] = getByInventorName_PrevAndNext(session,
					inventionIdeaInstance, inventorName, orderByComparator, true);

			array[1] = inventionIdeaInstance;

			array[2] = getByInventorName_PrevAndNext(session,
					inventionIdeaInstance, inventorName, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected InventionIdeaInstance getByInventorName_PrevAndNext(
		Session session, InventionIdeaInstance inventionIdeaInstance,
		String inventorName,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE);

		boolean bindInventorName = false;

		if (inventorName == null) {
			query.append(_FINDER_COLUMN_INVENTORNAME_INVENTORNAME_1);
		}
		else if (inventorName.equals("")) {
			query.append(_FINDER_COLUMN_INVENTORNAME_INVENTORNAME_3);
		}
		else {
			bindInventorName = true;

			query.append(_FINDER_COLUMN_INVENTORNAME_INVENTORNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(InventionIdeaInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindInventorName) {
			qPos.add(inventorName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(inventionIdeaInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<InventionIdeaInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invention idea instances where inventorName = &#63; from the database.
	 *
	 * @param inventorName the inventor name
	 */
	@Override
	public void removeByInventorName(String inventorName) {
		for (InventionIdeaInstance inventionIdeaInstance : findByInventorName(
				inventorName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(inventionIdeaInstance);
		}
	}

	/**
	 * Returns the number of invention idea instances where inventorName = &#63;.
	 *
	 * @param inventorName the inventor name
	 * @return the number of matching invention idea instances
	 */
	@Override
	public int countByInventorName(String inventorName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INVENTORNAME;

		Object[] finderArgs = new Object[] { inventorName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVENTIONIDEAINSTANCE_WHERE);

			boolean bindInventorName = false;

			if (inventorName == null) {
				query.append(_FINDER_COLUMN_INVENTORNAME_INVENTORNAME_1);
			}
			else if (inventorName.equals("")) {
				query.append(_FINDER_COLUMN_INVENTORNAME_INVENTORNAME_3);
			}
			else {
				bindInventorName = true;

				query.append(_FINDER_COLUMN_INVENTORNAME_INVENTORNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindInventorName) {
					qPos.add(inventorName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_INVENTORNAME_INVENTORNAME_1 = "inventionIdeaInstance.inventorName IS NULL";
	private static final String _FINDER_COLUMN_INVENTORNAME_INVENTORNAME_2 = "inventionIdeaInstance.inventorName = ?";
	private static final String _FINDER_COLUMN_INVENTORNAME_INVENTORNAME_3 = "(inventionIdeaInstance.inventorName IS NULL OR inventionIdeaInstance.inventorName = '')";

	public InventionIdeaInstancePersistenceImpl() {
		setModelClass(InventionIdeaInstance.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
			dbColumnNames.put("id", "id_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the invention idea instance in the entity cache if it is enabled.
	 *
	 * @param inventionIdeaInstance the invention idea instance
	 */
	@Override
	public void cacheResult(InventionIdeaInstance inventionIdeaInstance) {
		entityCache.putResult(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			inventionIdeaInstance.getPrimaryKey(), inventionIdeaInstance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				inventionIdeaInstance.getUuid(),
				inventionIdeaInstance.getGroupId()
			}, inventionIdeaInstance);

		inventionIdeaInstance.resetOriginalValues();
	}

	/**
	 * Caches the invention idea instances in the entity cache if it is enabled.
	 *
	 * @param inventionIdeaInstances the invention idea instances
	 */
	@Override
	public void cacheResult(List<InventionIdeaInstance> inventionIdeaInstances) {
		for (InventionIdeaInstance inventionIdeaInstance : inventionIdeaInstances) {
			if (entityCache.getResult(
						InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
						InventionIdeaInstanceImpl.class,
						inventionIdeaInstance.getPrimaryKey()) == null) {
				cacheResult(inventionIdeaInstance);
			}
			else {
				inventionIdeaInstance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all invention idea instances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InventionIdeaInstanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the invention idea instance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InventionIdeaInstance inventionIdeaInstance) {
		entityCache.removeResult(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			inventionIdeaInstance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((InventionIdeaInstanceModelImpl)inventionIdeaInstance,
			true);
	}

	@Override
	public void clearCache(List<InventionIdeaInstance> inventionIdeaInstances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InventionIdeaInstance inventionIdeaInstance : inventionIdeaInstances) {
			entityCache.removeResult(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
				InventionIdeaInstanceImpl.class,
				inventionIdeaInstance.getPrimaryKey());

			clearUniqueFindersCache((InventionIdeaInstanceModelImpl)inventionIdeaInstance,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		InventionIdeaInstanceModelImpl inventionIdeaInstanceModelImpl) {
		Object[] args = new Object[] {
				inventionIdeaInstanceModelImpl.getUuid(),
				inventionIdeaInstanceModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			inventionIdeaInstanceModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		InventionIdeaInstanceModelImpl inventionIdeaInstanceModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					inventionIdeaInstanceModelImpl.getUuid(),
					inventionIdeaInstanceModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((inventionIdeaInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					inventionIdeaInstanceModelImpl.getOriginalUuid(),
					inventionIdeaInstanceModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new invention idea instance with the primary key. Does not add the invention idea instance to the database.
	 *
	 * @param id the primary key for the new invention idea instance
	 * @return the new invention idea instance
	 */
	@Override
	public InventionIdeaInstance create(long id) {
		InventionIdeaInstance inventionIdeaInstance = new InventionIdeaInstanceImpl();

		inventionIdeaInstance.setNew(true);
		inventionIdeaInstance.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		inventionIdeaInstance.setUuid(uuid);

		inventionIdeaInstance.setCompanyId(companyProvider.getCompanyId());

		return inventionIdeaInstance;
	}

	/**
	 * Removes the invention idea instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the invention idea instance
	 * @return the invention idea instance that was removed
	 * @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	 */
	@Override
	public InventionIdeaInstance remove(long id)
		throws NoSuchInventionIdeaInstanceException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the invention idea instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the invention idea instance
	 * @return the invention idea instance that was removed
	 * @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	 */
	@Override
	public InventionIdeaInstance remove(Serializable primaryKey)
		throws NoSuchInventionIdeaInstanceException {
		Session session = null;

		try {
			session = openSession();

			InventionIdeaInstance inventionIdeaInstance = (InventionIdeaInstance)session.get(InventionIdeaInstanceImpl.class,
					primaryKey);

			if (inventionIdeaInstance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInventionIdeaInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(inventionIdeaInstance);
		}
		catch (NoSuchInventionIdeaInstanceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected InventionIdeaInstance removeImpl(
		InventionIdeaInstance inventionIdeaInstance) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(inventionIdeaInstance)) {
				inventionIdeaInstance = (InventionIdeaInstance)session.get(InventionIdeaInstanceImpl.class,
						inventionIdeaInstance.getPrimaryKeyObj());
			}

			if (inventionIdeaInstance != null) {
				session.delete(inventionIdeaInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (inventionIdeaInstance != null) {
			clearCache(inventionIdeaInstance);
		}

		return inventionIdeaInstance;
	}

	@Override
	public InventionIdeaInstance updateImpl(
		InventionIdeaInstance inventionIdeaInstance) {
		boolean isNew = inventionIdeaInstance.isNew();

		if (!(inventionIdeaInstance instanceof InventionIdeaInstanceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(inventionIdeaInstance.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(inventionIdeaInstance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in inventionIdeaInstance proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom InventionIdeaInstance implementation " +
				inventionIdeaInstance.getClass());
		}

		InventionIdeaInstanceModelImpl inventionIdeaInstanceModelImpl = (InventionIdeaInstanceModelImpl)inventionIdeaInstance;

		if (Validator.isNull(inventionIdeaInstance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			inventionIdeaInstance.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (inventionIdeaInstance.getCreateDate() == null)) {
			if (serviceContext == null) {
				inventionIdeaInstance.setCreateDate(now);
			}
			else {
				inventionIdeaInstance.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!inventionIdeaInstanceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				inventionIdeaInstance.setModifiedDate(now);
			}
			else {
				inventionIdeaInstance.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (inventionIdeaInstance.isNew()) {
				session.save(inventionIdeaInstance);

				inventionIdeaInstance.setNew(false);
			}
			else {
				inventionIdeaInstance = (InventionIdeaInstance)session.merge(inventionIdeaInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!InventionIdeaInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					inventionIdeaInstanceModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					inventionIdeaInstanceModelImpl.getUuid(),
					inventionIdeaInstanceModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { inventionIdeaInstanceModelImpl.getName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
				args);

			args = new Object[] { inventionIdeaInstanceModelImpl.getInventorName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_INVENTORNAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVENTORNAME,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((inventionIdeaInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						inventionIdeaInstanceModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { inventionIdeaInstanceModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((inventionIdeaInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						inventionIdeaInstanceModelImpl.getOriginalUuid(),
						inventionIdeaInstanceModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						inventionIdeaInstanceModelImpl.getUuid(),
						inventionIdeaInstanceModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((inventionIdeaInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						inventionIdeaInstanceModelImpl.getOriginalName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { inventionIdeaInstanceModelImpl.getName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((inventionIdeaInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVENTORNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						inventionIdeaInstanceModelImpl.getOriginalInventorName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INVENTORNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVENTORNAME,
					args);

				args = new Object[] {
						inventionIdeaInstanceModelImpl.getInventorName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INVENTORNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVENTORNAME,
					args);
			}
		}

		entityCache.putResult(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
			InventionIdeaInstanceImpl.class,
			inventionIdeaInstance.getPrimaryKey(), inventionIdeaInstance, false);

		clearUniqueFindersCache(inventionIdeaInstanceModelImpl, false);
		cacheUniqueFindersCache(inventionIdeaInstanceModelImpl);

		inventionIdeaInstance.resetOriginalValues();

		return inventionIdeaInstance;
	}

	/**
	 * Returns the invention idea instance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the invention idea instance
	 * @return the invention idea instance
	 * @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	 */
	@Override
	public InventionIdeaInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInventionIdeaInstanceException {
		InventionIdeaInstance inventionIdeaInstance = fetchByPrimaryKey(primaryKey);

		if (inventionIdeaInstance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInventionIdeaInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return inventionIdeaInstance;
	}

	/**
	 * Returns the invention idea instance with the primary key or throws a {@link NoSuchInventionIdeaInstanceException} if it could not be found.
	 *
	 * @param id the primary key of the invention idea instance
	 * @return the invention idea instance
	 * @throws NoSuchInventionIdeaInstanceException if a invention idea instance with the primary key could not be found
	 */
	@Override
	public InventionIdeaInstance findByPrimaryKey(long id)
		throws NoSuchInventionIdeaInstanceException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the invention idea instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the invention idea instance
	 * @return the invention idea instance, or <code>null</code> if a invention idea instance with the primary key could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
				InventionIdeaInstanceImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		InventionIdeaInstance inventionIdeaInstance = (InventionIdeaInstance)serializable;

		if (inventionIdeaInstance == null) {
			Session session = null;

			try {
				session = openSession();

				inventionIdeaInstance = (InventionIdeaInstance)session.get(InventionIdeaInstanceImpl.class,
						primaryKey);

				if (inventionIdeaInstance != null) {
					cacheResult(inventionIdeaInstance);
				}
				else {
					entityCache.putResult(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
						InventionIdeaInstanceImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
					InventionIdeaInstanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return inventionIdeaInstance;
	}

	/**
	 * Returns the invention idea instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the invention idea instance
	 * @return the invention idea instance, or <code>null</code> if a invention idea instance with the primary key could not be found
	 */
	@Override
	public InventionIdeaInstance fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, InventionIdeaInstance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, InventionIdeaInstance> map = new HashMap<Serializable, InventionIdeaInstance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			InventionIdeaInstance inventionIdeaInstance = fetchByPrimaryKey(primaryKey);

			if (inventionIdeaInstance != null) {
				map.put(primaryKey, inventionIdeaInstance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
					InventionIdeaInstanceImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (InventionIdeaInstance)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (InventionIdeaInstance inventionIdeaInstance : (List<InventionIdeaInstance>)q.list()) {
				map.put(inventionIdeaInstance.getPrimaryKeyObj(),
					inventionIdeaInstance);

				cacheResult(inventionIdeaInstance);

				uncachedPrimaryKeys.remove(inventionIdeaInstance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(InventionIdeaInstanceModelImpl.ENTITY_CACHE_ENABLED,
					InventionIdeaInstanceImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the invention idea instances.
	 *
	 * @return the invention idea instances
	 */
	@Override
	public List<InventionIdeaInstance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<InventionIdeaInstance> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<InventionIdeaInstance> findAll(int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<InventionIdeaInstance> findAll(int start, int end,
		OrderByComparator<InventionIdeaInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<InventionIdeaInstance> list = null;

		if (retrieveFromCache) {
			list = (List<InventionIdeaInstance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_INVENTIONIDEAINSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INVENTIONIDEAINSTANCE;

				if (pagination) {
					sql = sql.concat(InventionIdeaInstanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<InventionIdeaInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InventionIdeaInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the invention idea instances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (InventionIdeaInstance inventionIdeaInstance : findAll()) {
			remove(inventionIdeaInstance);
		}
	}

	/**
	 * Returns the number of invention idea instances.
	 *
	 * @return the number of invention idea instances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INVENTIONIDEAINSTANCE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InventionIdeaInstanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the invention idea instance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(InventionIdeaInstanceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_INVENTIONIDEAINSTANCE = "SELECT inventionIdeaInstance FROM InventionIdeaInstance inventionIdeaInstance";
	private static final String _SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE_PKS_IN = "SELECT inventionIdeaInstance FROM InventionIdeaInstance inventionIdeaInstance WHERE id_ IN (";
	private static final String _SQL_SELECT_INVENTIONIDEAINSTANCE_WHERE = "SELECT inventionIdeaInstance FROM InventionIdeaInstance inventionIdeaInstance WHERE ";
	private static final String _SQL_COUNT_INVENTIONIDEAINSTANCE = "SELECT COUNT(inventionIdeaInstance) FROM InventionIdeaInstance inventionIdeaInstance";
	private static final String _SQL_COUNT_INVENTIONIDEAINSTANCE_WHERE = "SELECT COUNT(inventionIdeaInstance) FROM InventionIdeaInstance inventionIdeaInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "inventionIdeaInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InventionIdeaInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No InventionIdeaInstance exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(InventionIdeaInstancePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "id"
			});
}