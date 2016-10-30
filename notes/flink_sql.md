# Flink SQL Notes

Note: run into issues when trying to run this; only read not experimented with.

Table and SQL Beta at
https://ci.apache.org/projects/flink/flink-docs-release-1.2/dev/table_api.html

Registering a table; makes it known with column names (and types?).

## Table API

| .select          | .select('a, 'c as 'd) |
| .as              | .as('a, 'b, 'c)       |
| .where / .filter | .where('b === "red")  |
| .groupBy         | |
| .join            | (tables must have distinct field names, and followed by where or filter operator)|
| .leftOuterJoin   | left.leftOuterJoin(right, 'a === 'd) |
| .rightOuterJoin  | |
| .fullOuterJoin   | |
| .union           | |
| .unionAll        | |
| .intersect       | |
| .intersectAll    | |
| .minus           | |
| .minusAll        | |
| .distinct        | |
| .orderBy         | |
| .limit           | |

## Expression Syntax

TODO: play with this once I get the basic functionality working.

## SQL on Streaming Tables

only select, from, where, and union.

## SQL Syntax

Apache Calcite for parsing

## Data Types

Uses Flink's TypeInformation

## Build-in Functions

## User-defined Scalar Functions

extend from ScalarFunction, implement eval and maybe getResultType.
