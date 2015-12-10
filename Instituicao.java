import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;


public class Instituicao {
	
	String nome;
	String endereco;
	int telefone;
	int cod_instituicao1;
	Scanner tc = new Scanner(System.in);
	Banco b = new Banco();
	
	
	public boolean cadastro_instituicao(){
		System.out.println("Informe o nome da instituição:");
		this.nome=tc.next();
		
		System.out.println("Informe o endereço:");
		this.endereco=tc.next();
		
		System.out.println("Informe o telefone:");
		this.telefone=tc.nextInt();
		
		return true;
		
	}
	
	public boolean delete_por_cod(int cod){
		b.Mysql();
		
		try {
			String sql =" DELETE FROM instituicao WHERE codigo_instituicao=?;";
			PreparedStatement comandoSQL = b.conexao.prepareStatement(sql);
			comandoSQL.setInt(1, cod);
			int rs = comandoSQL.executeUpdate();
			comandoSQL.execute();
			comandoSQL.close();
		    
		    return true;

		} catch (Exception e) {
			b.msg=e.getMessage();
			System.out.println(b.msg);
			return false;
		}
		
	}
	
	public boolean ver_por_cod(int cod){
		b.Mysql();
		
		try {
			String sql =" SELECT * FROM instituicao WHERE codigo_instituicao=?;";
			PreparedStatement comandoSQL = b.conexao.prepareStatement(sql);
			comandoSQL.setInt(1, cod);
			ResultSet rs = comandoSQL.executeQuery();
			while(rs.next()){
				this.cod_instituicao1 = rs.getInt("codigo_instituicao");
				this.nome = rs.getString("nome");
				this.endereco = rs.getString("endereco");
				this.telefone = rs.getInt("telefone");
				
				System.out.println("Nome: "+this.nome);
				System.out.println("Endereço: "+this.endereco);
				System.out.println("Código da Instituição: "+this.cod_instituicao1);
				System.out.println("Telefone: "+this.telefone);
				return true;
			}
		} catch (Exception e) {
			b.msg=e.getMessage();
			System.out.println(b.msg);
			return false;
		}
		
		return false;
	}
	
	public boolean atualizar_por_cod(int cod){
		b.Mysql();
		
		System.out.println("Informe o novo nome:");
		this.nome = tc.nextLine();
		System.out.println("Informe o novo endereço:");
		this.endereco = tc.nextLine();
		System.out.println("Informe o novo telefone:");
		this.telefone = tc.nextInt(); 
		
		try {
			String sql =" UPDATE instituicao SET nome= ?, endereco= ?,telefone= ? WHERE codigo_instituicao=?;";
			PreparedStatement comandoSQL = b.conexao.prepareStatement(sql);
			comandoSQL.setString(1, this.nome);
			comandoSQL.setString(2, this.endereco);
			comandoSQL.setInt(3, this.telefone);
			comandoSQL.setInt(4, cod);
			int rs= comandoSQL.executeUpdate();
			comandoSQL.execute();
			comandoSQL.close();
		    return true;

		} catch (Exception e) {
			b.msg=e.getMessage();
			System.out.println(b.msg);
			return false;
		}
		
	}
	
	public boolean ver_todas(){
		
		b.Mysql();
		
		try {
			String sql ="SELECT*FROM instituicao;";
			PreparedStatement comandoSQL = b.conexao.prepareStatement(sql);
			ResultSet rs = comandoSQL.executeQuery();
			while(rs.next()){
				this.cod_instituicao1 = rs.getInt("codigo_instituicao");
				this.nome = rs.getString("nome");
				this.endereco = rs.getString("endereco");
				this.telefone = rs.getInt("telefone");
				
				System.out.println("\nNome: "+this.nome);
				System.out.println("Endereço: "+this.endereco);
				System.out.println("Código da Instituição: "+this.cod_instituicao1);
				System.out.println("Telefone: "+this.telefone);
				
			}
			return true;
		} catch (Exception e) {
			b.msg=e.getMessage();
			System.out.println(b.msg);
			return false;
		}
	}
	
	public boolean salvar_insti(){
		b.Mysql();
		try {
			b.Mysql();
			String sql = "INSERT INTO instituicao (nome,endereco,telefone) VALUES(?,?,?);";
			PreparedStatement comandoSQL = b.conexao.prepareStatement(sql);
			
			comandoSQL.setString(1, this.nome);
			comandoSQL.setString(2, this.endereco);
			comandoSQL.setInt(3, this.telefone);
			comandoSQL.execute();
			comandoSQL.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			b.msg=e.getMessage();
			return false;
		}
		
	}

}
