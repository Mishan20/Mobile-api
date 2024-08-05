package com.mobile.api.repository;

import com.mobile.api.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepo extends JpaRepository<Mobile, Integer> {
}
