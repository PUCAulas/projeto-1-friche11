package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import business.Aluguel;
import business.Cliente;
import business.Empresa;
import business.Equipamento;

public class Aplicacao {

	public static void main(String[] args) {
		
	        Empresa empresa = new Empresa();
	        Scanner input = new Scanner(System.in);
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        List<Cliente> clientes = new ArrayList<>();
	        List<Equipamento> equipamentos = new ArrayList<>();
	        

	        int opc =  0;
	        while (opc <= 5) {
	        	
	        	System.out.println("Para usar o sistema é preciso se cadastrar como usuário e cadastrar equipamentos.");
	            System.out.println("0 - Sair do sistema");
	            System.out.println("1 - Cadastro de usuário");
	            System.out.println("2 - Cadastrar equipamento");
	            System.out.println("3 - Alugar um equipamento");
	            System.out.println("4 - Consultar todos os aluguéis de cliente");
	            System.out.println("5 - Relatório mensal da empresa");
	            System.out.println("Digite a Opcao Que Deseja: ");
	            opc = input.nextInt();
	            input.nextLine();
	            switch (opc) {
	            case 1:
                    System.out.println("Digite seu nome: ");
                    String nomeUsuario = input.nextLine();
                    System.out.println("Digite seu cpf: ");
                    String cpfUsuario = input.nextLine();
                    Cliente novoCliente = new Cliente(nomeUsuario, cpfUsuario);
                    empresa.registrarCliente(novoCliente);
                    System.out.println("Registrado com sucesso no sistema: " + nomeUsuario + ", Seu cpf: " + cpfUsuario);
                    break;
                case 2:
                    System.out.println("Digite o código do equipamento: ");
                    int cod = input.nextInt();
                    input.nextLine(); // Consumir a quebra de linha após o nextInt()
                    System.out.println("Digite o nome do equipamento: ");
                    String nomeEquipamento = input.nextLine();
                    System.out.println("Digite o valor diário do equipamento quando ele for alugado: ");
                    Double valorDiario = input.nextDouble();
                    input.nextLine(); // Consumir a quebra de linha após o nextDouble()
                    Equipamento novoEquipamento = new Equipamento(cod, nomeEquipamento, valorDiario);
                    empresa.registrarEquipamento(novoEquipamento);
                    break;
                case 3:
                    System.out.println("Digite o nome do cliente: ");
                    String nomeCliente = input.nextLine();
                    Cliente cliente = empresa.getClientePeloNome(nomeCliente);
                    if (cliente != null) {
                        System.out.println("Digite o código do equipamento: ");
                        int codigoEquipamento = input.nextInt();
                        input.nextLine(); // Consumir a quebra de linha após o nextInt()
                        Equipamento equipamento = empresa.getEquipamentoPeloCodigo(codigoEquipamento);

                        if (equipamento != null) {
                            System.out.println("Digite a data inicial do aluguel no formato YYYY-MM-DD: ");
                            String dataStr1 = input.nextLine();
                            LocalDate dataInicio = null;

                            try {
                                dataInicio = LocalDate.parse(dataStr1, dateFormatter);
                                System.out.println("Você digitou a data de início: " + dateFormatter.format(dataInicio));
                            } catch (Exception e) {
                                System.out.println("Formato de data inválido. Use o formato YYYY-MM-DD.");
                                break; // Saia do case 3 se a data de início for inválida
                            }

                            System.out.println("Digite a data final do aluguel no formato YYYY-MM-DD: ");
                            String dataStr2 = input.nextLine();
                            LocalDate dataFim = null;

                            try {
                                dataFim = LocalDate.parse(dataStr2, dateFormatter);
                                System.out.println("Você digitou a data de término: " + dateFormatter.format(dataFim));
                            } catch (Exception e) {
                                System.out.println("Formato de data inválido. Use o formato YYYY-MM-DD.");
                                break; // Saia do case 3 se a data de término for inválida
                            }

                            if (dataInicio.isAfter(dataFim)) {
                                System.out.println("A data de início não pode ser posterior à data de término.");
                            } else {
                                empresa.registrarAluguel(cliente, equipamento, dataInicio, dataFim);
                                System.out.println("Aluguel registrado com sucesso.");
                            }
                        } else {
                            System.out.println("Equipamento não encontrado.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do cliente: ");
                    String nomeClienteConsulta = input.nextLine();
                    Cliente clienteConsulta = empresa.getClientePeloNome(nomeClienteConsulta);

                    if (clienteConsulta != null) {
                        List<String> alugueisDetalhados = empresa.getAlugueisClienteDetalhados(clienteConsulta);

                        if (!alugueisDetalhados.isEmpty()) {
                            System.out.println("Aluguéis de " + nomeClienteConsulta + ":");
                            for (String detalhesAluguel : alugueisDetalhados) {
                                System.out.println(detalhesAluguel);
                            }
                        } else {
                            System.out.println("Nenhum aluguel encontrado para " + nomeClienteConsulta);
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Digite a data no formato YYYY-MM: ");
                    String dataStr = input.nextLine();

                    LocalDate dataRelatorio = null;
                    try {
                        dataRelatorio = LocalDate.parse(dataStr + "-01", dateFormatter);
                        System.out.println("Você digitou a data: " + dateFormatter.format(dataRelatorio));
                    } catch (Exception e) {
                        System.out.println("Formato de data inválido. Use o formato YYYY-MM.");
                        break; // Saia do case 5 se a data for inválida
                    }

                    double faturamentoMensal = empresa.gerarRelatorioMensal(dataRelatorio);
                    System.out.println("Faturamento total da empresa em " + dateFormatter.format(dataRelatorio) + ": " + faturamentoMensal);
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    System.exit(0);
                    break;
                	
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        input.close();
    }


	}

	    			
	    		



