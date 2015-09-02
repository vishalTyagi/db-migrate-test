databaseChangeLog = {

	changeSet(author: "intelligrape (generated)", id: "1438326961319-1") {
		createTable(tableName: "person") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "personPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "age", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "hello", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "name1", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "name11", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "name111", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}
}
