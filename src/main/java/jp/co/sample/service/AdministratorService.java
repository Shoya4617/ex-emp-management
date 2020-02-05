package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * @author yamaseki
 * 管理者サービスクラス
 */
@Service
@Transactional
public class AdministratorService {

	@Autowired
	private AdministratorRepository repository;
	
	//管理者情報を挿入するメソッド
	public void insert(Administrator administrator) {
		repository.insert(administrator);
	}
	
	public Administrator login(String mailAddress,String password) {
		Administrator admin = repository.findByMailAddressAndPassword(mailAddress, password);
		return admin;
	}
}
