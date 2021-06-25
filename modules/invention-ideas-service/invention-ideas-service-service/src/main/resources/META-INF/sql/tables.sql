create table le_demo_InventionIdeaInstance (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	inventorName VARCHAR(75) null,
	shortDescription VARCHAR(75) null,
	description VARCHAR(75) null
);