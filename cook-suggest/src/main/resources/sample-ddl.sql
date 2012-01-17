create schema if not exists cooking;

create table if not exists cooking.recipe(
id number identity,
name varchar(100) not null,
lastSuggestedDate date,
lastPreparedDate date);