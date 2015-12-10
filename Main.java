import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
	
		int menu;
		Scanner tc = new Scanner(System.in);
		Banco b = new Banco();
		boolean ret;
		
		
		
		do{
		
		System.out.println("\nInforme a operação que deseja realizar:");
		System.out.println("Digite:");
		System.out.println("1-Fazer um novo cadastro de uma pessoa.");
		System.out.println("2-Deletar um cadastro de uma pessoa pelo CGU.");
		System.out.println("3-Atualizar um cadastro de uma pessoa pelo CGU.");
		System.out.println("4-Ver um cadastro de uma pessoa por CGU.");
		System.out.println("5-Fazer um novo cadastro de instituição.");
		System.out.println("6-Deletar um cadastro de instituição pelo código.");
		System.out.println("7-Ver um cadastro de instituição.");
		System.out.println("8-Ver todos cadastros de pessoas.");
		System.out.println("9-Ver todos cadastros de instituições.");
		System.out.println("10-Atualizar um cadastro de instituição.");
		System.out.println("0-Sair.");
		menu=tc.nextInt();
		
		switch(menu){
		case 1:{
			Pessoa p = new Pessoa();
			ret=p.cadastro();
				if(ret==true){
					p.salvar();
					System.out.println("Cadastro efetuado com sucesso!");
				}else{
					System.out.println("Erro ao cadastrar!");
				}
				break;
		}
		
		case 2:{
			Pessoa p = new Pessoa();
			int cgu;
			
			System.out.println("Informe o CGU do cadastro que deseja deletar:");
			cgu=tc.nextInt();
			ret=p.delete_por_CGU(cgu);
				if(ret==true){
					System.out.println("Deletado com sucesso!");
				}else{
					System.out.println("Erro ao deletar!");
				}
			break;
		}
		
		case 3:{
			Pessoa p = new Pessoa();
			int cgu;
			
			System.out.println("Informe o CGU que deseja atualizar:");
			cgu=tc.nextInt();
			
			ret=p.atualizar(cgu);
				if(ret==true){
					System.out.println("Atualizado com sucesso!");
				}else{
					System.out.println("Erro ao atualizar!");
				}
			break;
		}
		
		case 4:{
			Pessoa p = new Pessoa();
			int cgu;
			
			System.out.println("Informe o CGU do cadastro que deseja ver:");
			cgu=tc.nextInt();
			
			ret = p.ver_cadastro_por_CGU(cgu);
				if(ret==false){
					System.out.println("Esse número de CGU não existe!");
				}
			break;
		}
		
		case 5:{
			Instituicao i = new Instituicao();
			
			ret=i.cadastro_instituicao();
				if(ret==true){
					System.out.println("Cadastro efetuado com sucesso!");
					i.salvar_insti();
				}else{
					System.out.println("Erro ao cadastrar!");
				}
		}
		break;
		case 6:{
			Instituicao i = new Instituicao();
			int cod;
			System.out.println("Informe o código da instituição que deseja deletar;");
			cod=tc.nextInt();
			
			ret=i.delete_por_cod(cod);
				if(ret==true){
					System.out.println("Deletado com sucesso!");
				}else{
					System.out.println("Erro ao deletar!");
				}
			
			break;
		}
		
		case 7:{
			Instituicao i = new Instituicao();
			int cod = 0;
			System.out.println("Informe o código da instituição:");
			cod=tc.nextInt();
			
			ret=i.ver_por_cod(cod);
				if(ret==false){
					System.out.println("Não existe nenhuma instituição com esse código!");
				}
			break;
		}
		
		case 8:{
			Pessoa p = new Pessoa();
			p.ver_todos();
			
			break;
		}
		
		case 9:{
			Instituicao i = new Instituicao();
			i.ver_todas();
			break;
		}
		
		case 10:{
			Instituicao i = new Instituicao();
			int cod = 0;
			System.out.println("Informe o código da instituição:");
			cod=tc.nextInt();
			
			ret=i.atualizar_por_cod(cod);
				if(ret==true){
					System.out.println("Atualizado com Sucesso!");
				}else{
					System.out.println("Erro ao atualizar!");
				}
			break;
		}
		}
		
		}while(menu!=0);
	b.desconectar();	
	}
	
}
