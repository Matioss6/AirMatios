package com.AirMatios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, String> {
}
