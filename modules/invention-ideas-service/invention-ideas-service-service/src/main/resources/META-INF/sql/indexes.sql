create index IX_1A4DEB66 on le_demo_InventionIdeaInstance (inventorName[$COLUMN_LENGTH:75$]);
create index IX_8F520E49 on le_demo_InventionIdeaInstance (name[$COLUMN_LENGTH:75$]);
create index IX_A226C17E on le_demo_InventionIdeaInstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D8CD8F80 on le_demo_InventionIdeaInstance (uuid_[$COLUMN_LENGTH:75$], groupId);