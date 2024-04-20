import java.util.Random;
import java.util.Scanner;

public class Empresas {
    private String [] nomes = new String [5];
    private String [] nomeEmpresa = new String [5];
    private Random bayo = new Random();
    private String red = "\u001B[31m";
    private String green = "\u001B[32m";
    private String yellow = "\u001B[33m"; 
    private String reset = "\u001B[0m";  
    private Scanner input = new Scanner(System.in);
    

    public Empresas(){
        nomes[0] = "Carlos";
        nomes[1] = "Tuga";
        nomes[2] = "Leo";
        nomes[3] = "Cruz";
        nomes[4] = "Calvin";

        nomeEmpresa[0] = "Enterprises";
        nomeEmpresa[1] = "Company";
        nomeEmpresa[2] = "Business";
        nomeEmpresa[3] = "Refeições";
        nomeEmpresa[4] = "Hamburgueria";

    }

    public String randomicoN(){
        int numRandom = bayo.nextInt(5);
        String frase = "";
        if(nomes != null){
            frase = nomes[numRandom];
        }

        return frase;
    }

    public String randomicoNE(){
        int numRandom2 = bayo.nextInt(5);
        String frase = "";
        if(nomes != null){
            frase = nomeEmpresa[numRandom2];
        }

        return frase;
    }



    public void contratos(reator r){
        double valorE = 7.5;
        double probabilidadeBase = 0.2;
        boolean fatorV = false;
        double QuantE = 0;
        double luck = 0;
        QuantE = Math.floor(r.getEnergia()/10000);
        luck = Math.pow(1.5, QuantE);
        double probabilidadeFinal = probabilidadeBase * luck;
        double numeroAleatorio = Math.random();
        fatorV = numeroAleatorio < probabilidadeFinal;
        if(fatorV && r.getEnergia() > 0){
            double formulaE = .3 * r.getEnergia();
            double finalE = formulaE * valorE;
            System.out.println("Contrato de Fornecimento de Energia");
            System.out.println("------------------------------");
            System.out.println("Empresa: " + randomicoN() + " " + randomicoNE());
            System.out.println("Prezado Cliente,");
            System.out.println("Estamos entrando em contato para formalizar o contrato de fornecimento de energia entre a nossa empresa e o reator.");
            System.out.println("De acordo com nossas negociações, informamos os detalhes do contrato:");
            System.out.println("Quantidade de energia contratada: " + formulaE);
            System.out.println("Valor a receber: "  + yellow + finalE + reset);
            System.out.println("Agradecemos pela confiança em nossa empresa e estamos à disposição para esclarecer qualquer dúvida.");
            System.out.println("1. Aceitar;");
            System.out.println("2. Negar;");
            int menu = input.nextInt();
            if(menu == 1){
                System.out.println(green + "Contrato aceito." + reset);
                r.setDinheiro(r.getDinheiro() + finalE);
                r.setEnergia(r.getEnergia() - formulaE);
            } else{
                System.out.println(red + "Contrato negado." + reset);
            }

        } else{
            System.out.println(red + "Nenhuma proposta recebida." + reset);
        }

         


        

    }
    
}
