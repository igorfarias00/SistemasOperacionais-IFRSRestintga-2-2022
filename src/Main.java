package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Random;


/*
popular-processos
+
escolhe_algoritmo
+
executa-processos
-- de 0 a 999
-- varrer a lista de processos e escolher qual executar
-- imprimir qual processo foi escolhido e o valor de i
-- armazenar o tempo de espera em uma variavel de controle
-- controlar o tempo restante de cada processo
+
calcula_estatisticas
+
imprime-estatisticas


-tempo de execução [nº de processos]
-tempo restante
-tempo espera
-tempo chegada

 */
public class Main {
    static ArrayList<Process> processes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader tcl = new BufferedReader(new InputStreamReader(System.in));

        int opc = 0, processNum = 3;

        menuProcesses();
        
        do {
            algortihmMenu();
            opc = Integer.parseInt(tcl.readLine());
            switch (opc) {
                // FCFS
                case 1: Fcfs fcfs= new Fcfs(processes);
                     break;

                        // SJF
                case 2:
                   Sjf sjf = new Sjf(processes);
                     break;

                        // SJF P
                case 3:
                   	SjfPreemptivo sjfPreemp = new SjfPreemptivo(processes);
                     break;

                       // ROBIN
                case 4:
                     System.out.println("ainda não implementado");
                      break;

                      // PRIORIDADE
                case 5:
                    System.out.println("ainda não implementado");
                      break;

                        // PRIORIDADE P
                case 6:
                       System.out.println("ainda não implementado");
                     break;
                        	
                case 7: showArrivalAndExecution();
                 		break;
                 		
                case 8:
                 	processes.clear();
                 	menuProcesses();
                   	break;
                        	
                case 0:
                     	System.out.println("Até mais!");
                       	break;

                    default:
                    	System.out.println("EEE O Q? não entendi");
                      break;
            }
        } while (opc != 0);
            
          

        
    }





	public static void menuProcesses() throws NumberFormatException, IOException { 
    	int opc, processNum;
    	BufferedReader tcl = new BufferedReader(new InputStreamReader(System.in));
    	
            do {
                // niveis do menu
                // menu - 0 - tempo de espera manual e Automatica
                // menu - 1 - tipo de algoritmo da fila de processos
                System.out.println("---- OPCÕES ----");
                System.out.println("1) Atribuição Automatica.");
                System.out.println("2) Atribuição Manual");
                
                opc = Integer.parseInt(tcl.readLine());
                if(opc == 1 || opc ==2) {
                    System.out.println("quantos Processos deseja inserir");
                    processNum = Integer.parseInt(tcl.readLine());
                    populateProcesses(opc, processNum);
                    opc = 0;        // reseta a opcao do menu para continuar a execução
                }
             } while (opc != 0);

    }

    public static void algortihmMenu(){
        System.out.println(" -- escolha o tipo de algoritmo --");
        System.out.println("1) FCFS");
        System.out.println("2) SJF");
        System.out.println("3) SJF P");
        System.out.println("4) ROBIN");
        System.out.println("5) PRIORIDADE ");
        System.out.println("6) PRIORIDADE P");
        System.out.println("7) Mostrar o tempo de chegada e de execução");
        System.out.println("8) Refazer a lista de processos");
        System.out.println("0) SAIR");

    }

    public static void populateProcesses(int opc, int processNum) throws IOException {
        Random generator = new Random();
        BufferedReader tcl = new BufferedReader(new InputStreamReader(System.in));

        if (opc == 1) {                                     // opção para popular o arraylist com a quantidade selecionada
            for (int i = 0; i < processNum; i++) {          // de forma aleatoria
                processes.add(new Process(true, (i+1)));
                if(processes.size() == 1){
                    processes.get(0).arrivalTime = 0;		// atribui ao primeiro processo o tempo de chegada 0
                } else {
                    processes.get(i).arrivalTime = generator.nextInt(1,50);			// gera o tempo de chegada aleatoriamente para os demais, entre 1 e 50
                }
            }
        } else if (opc == 2) {                              // opção para popular o arraylist com a quantidade selecionada
            for (int i = 0; i < processNum; i++) {          // de forma manual              
                processes.add(new Process(false, (i+1)));

            }
        }
    }
    
    
    public static void showExecution() {
    	for(int i = 0; i < processes.size(); i++ ) {
    		System.out.println("execução do processo " + processes.get(i).id +": "+processes.get(i).execution);
    	}
    	
    } 
    
    public static void showArrivalTime() {
    	for(int i = 0; i < processes.size(); i++ ) {
    		System.out.println("tempo de chegada do processo " + processes.get(i).id +": "+processes.get(i).arrivalTime);
    	}
    	
    }
    
    public static void showArrivalAndExecution() {
    	for(int i = 0; i < processes.size(); i++ ) {
    		System.out.println("tempo de chegada do processo " + processes.get(i).id +": "+processes.get(i).arrivalTime);
    		System.out.println("execução do processo " + processes.get(i).id +":         "+processes.get(i).execution);
    		System.out.println("----------------------------------------------------------------------------------");
    	}
    }

}

