package cnam.aisl.democ1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import cnam.aisl.democ1.entity.Addresse;

@Repository
public interface AddresseRepository extends JpaRepository<Addresse, Integer>, JpaSpecificationExecutor<Addresse> {}