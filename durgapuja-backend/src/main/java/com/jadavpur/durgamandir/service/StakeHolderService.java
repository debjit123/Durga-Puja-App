package com.jadavpur.durgamandir.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jadavpur.durgamandir.dto.StakeHolderDto;

@Service
public interface StakeHolderService {

	public List<StakeHolderDto> calculateExpenseForEachStakeHolder();
}
