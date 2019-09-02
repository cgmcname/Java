package edu.uark.models.repositories;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;
import java.util.function.Consumer;

import edu.uark.dataaccess.entities.BaseFieldNames;
import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeRepository extends BaseRepository<EmployeeEntity> implements EmployeeRepositoryInterface {

	public EmployeeEntity byRecordID(String recordID) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(EmployeeFieldNames.RECORDID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, recordID.toLowerCase());
				} catch (SQLException e) {}

				return ps;
			}
		);
	}

	@Override
	public EmployeeEntity createOne() {
		return (new EmployeeEntity());
	}
	

	public EmployeeRepository() {
		super(DatabaseTable.EMPLOYEES);
	}
	
	@Override
	public EmployeeEntity get(String recordID) {
		return firstOrDefaultWhere(
				null,
				(new WhereContainer(
					(new WhereClause()).
						table(primaryTable).
						fieldName(BaseFieldNames.ID).
						comparison(SQLComparisonType.EQUALS)
				)),
				null,
				(ps) -> {
					try {
						ps.setObject(1, recordID);
					} catch (SQLException e) {}

					return ps;
				}
			);
	} 
}
