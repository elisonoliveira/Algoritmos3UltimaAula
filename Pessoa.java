import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;


public class Pessoa {
	
	String nome;
	int cod_instituicao;
	int idade;
	int CGU;
	float notag1;
	float notag2;
	Scanner tc = new Scanner(System.in);
	Banco b = new Banco();
	
	public boolean cadastro(){
		System.out.println("Informe seu nome:");
		this.nome=tc.nextLine();
		
		System.out.println("Informe o código da sua instituição:");
		this.cod_instituicao=tc.nextInt();
		
		System.out.println("Informe sua idade:");
		this.idade=tc.nextInt();
		
		System.out.println("Informe sua nota na G1:");
		this.notag1=tc.nextFloat();
		
		System.out.println("Informe sua nota na G2:");
		this.notag2=tc.nextFloat();
		
		return true;
		
	}
	
	public boolean delete_por_CGU(int cgu){
		b.Mysql();
		
		try {
			String sql =" DELETE FROM pessoa WHERE CGU=?;";
			PreparedStatement comandoSQL = b.conexao.prepareStatement(sql);
			comandoSQL.setInt(1, cgu);
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
	
	public boolean ver_cadastro_por_CGU(int cgu){
		b.Mysql();
		
		try {
			String sql =" SELECT * FROM pessoa WHERE CGU=?;";
			PreparedStatement comandoSQL = b.conexao.prepareStatement(sql);
			comandoSQL.setInt(1, cgu);
			ResultSet rs = comandoSQL.executeQuery();
			while(rs.next()){
				this.CGU = rs.getInt("CGU");
				this.nome = rs.getString("nome");
				this.idade = rs.getInt("idade");
				this.cod_instituicao = rs.getInt("codigo_instituicao");
				this.notag1 = rs.getFloat("notag1");
				this.notag2 = rs.getFloat("notag2");
				
				System.out.println("CGU: "+this.CGU);
				System.out.println("Nome: "+this.nome);
				System.out.println("Idade: "+this.idade);
				System.out.println("Código da Instituição: "+this.cod_instituicao);
				System.out.println("Nota da G1: "+this.notag1);
				System.out.println("Nota da G2: "+this.notag2);
				return true;
			}
		} catch (Exception e) {
			b.msg=e.getMessage();
			return false;
		}
		
		return false;
		
	}
	
	public boolean ver_todos(){
		b.Mysql();
		
		try {
			String sql =" SELECT * FROM pessoa;";
			PreparedStatement comandoSQL = b.conexao.prepareStatement(sql);
			ResultSet rs = comandoSQL.executeQuery();
			while(rs.next()){
				this.CGU = rs.getInt("CGU");
				this.nome = rs.getString("nome");
				this.idade = rs.getInt("idade");
				this.cod_instituicao = rs.getInt("codigo_instituicao");
				this.notag1 = rs.getFloat("notag1");
				this.notag2 = rs.getFloat("notag2");
				
				System.out.println("\nCGU: "+this.CGU);
				System.out.println("Nome: "+this.nome);
				System.out.println("Idade: "+this.idade);
				System.out.println("Código da Instituição: "+this.cod_instituicao);
				System.out.println("Nota da G1: "+this.notag1);
				System.out.println("Nota da G2: "+this.notag2);
				
			}
			return true;
		} catch (Exception e) {
			b.msg=e.getMessage();
			return false;
		}
		
	}
	
	public boolean atualizar(int cgu){
		b.Mysql();
		
		System.out.println("Informe o novo nome:");
		this.nome = tc.nextLine();
		System.out.println("Informe a nova idade:");
		this.idade = tc.nextInt();
		System.out.println("Informe o novo codigo da instituição:");
		this.cod_instituicao = tc.nextInt();
		System.out.println("Informe a nova nota na G1:");
		this.notag1 = tc.nextFloat(); 
		System.out.println("Informe a nova nota na G2:");
		this.notag2 = tc.nextFloat();
		
		try {
			String sql =" UPDATE pessoa SET nome= ?, idade= ?, "
					+ "codigo_instituicao= ?, notag1= ?,"
					+ "notag2= ?"
					+ "WHERE CGU=?;";
			PreparedStatement comandoSQL = b.conexao.prepareStatement(sql);
			comandoSQL.setString(1, this.nome);
			comandoSQL.setInt(2, this.idade);
			comandoSQL.setInt(3, this.cod_instituicao);
			comandoSQL.setFloat(4, this.notag1);
			comandoSQL.setFloat(5, this.notag2);
			comandoSQL.setInt(6, cgu);
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
	
	public boolean salvar(){
		Banco b = new Banco();
		try {
			b.Mysql();
			String sql = "INSERT INTO pessoa (nome,idade,notag1,notag2,codigo_instituicao) VALUES(?,?,?,?,?);";
			PreparedStatement comandoSQL = b.conexao.prepareStatement(sql);
			
			comandoSQL.setString(1, this.nome);
			comandoSQL.setInt(2, this.idade);
			comandoSQL.setDouble(3, notag1);
			comandoSQL.setDouble(4, notag2);
			comandoSQL.setInt(5, this.cod_instituicao);
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
