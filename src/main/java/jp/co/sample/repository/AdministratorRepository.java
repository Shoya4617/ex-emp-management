package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

/**
 * 管理者用リポジトリ.
 * 
 * @author yamaseki
 */
@Repository
public class AdministratorRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Administrator>ADMIN_ROW_MAPPER = (rs,i) -> {
		Administrator admin = new Administrator();
		admin.setId(rs.getInt("id"));
		admin.setName(rs.getString("name"));
		admin.setMailAddress(rs.getString("mail_address"));
		admin.setPassword(rs.getString("password"));
		return admin;
	};
	
	/*
	 * insertメソッド
	 * データベースに管理者情報を挿入するためのメソッド
	 * @param administratorクラス
	 */
	public void insert(Administrator administrator) {
		String sql="INSERT INTO Administrators(name,mail_address,password)"+"VALUES(:name,:mailAddress,:password)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		template.update(sql, param);		
	}
	
	/* findByMailAddressAndPasswordメソッド.
	 * メールアドレスとパスワードで管理者情報を検索するメソッド
	 * @param 管理者クラス
	 * @return 管理者情報
	 */ 
	public Administrator findByMailAddressAndPassword(String mailAddress,String password) {
		//メールアドレスとパスワードでユーザー検索をするメソッド
		String sql = "select id,name,mail_address,password from administrators where mail_address=:mailAddress,password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
		Administrator admin = template.queryForObject(sql, param, ADMIN_ROW_MAPPER);
		return admin;
	}
}
