import java.util.Scanner;

public class mainReator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        reator r = new reator();
        Uranio U = new Uranio();
        Empresas e = new Empresas();
        Bombeador b = new Bombeador();
        while(r.Explodir() == false){
            r.resfriamento(); 
            r.aquecimento();
            System.out.println();
            System.out.println("Status Operacional do Reator Nuclear");
            System.out.println("Taxa de fissão (BurnRate): " + r.getBurnRate());
            System.out.printf("Nível do tanque de água: %.1f / %.1f m³%n", r.getTanqueAgua(), r.getTanqueAguaMax());
            System.out.printf("Censor de temperatura: %.1f C%n", r.getTemperatura());
            System.out.println("Energia total: " + r.getEnergia() + " J");
            System.out.println("Situação atual: " + r.Situacao());
            System.out.println("Radiação emitida: " + r.getLixoRad());
            System.out.println("Dinheiro total: " + r.getDinheiro());
            System.out.println();
            System.out.println("Opções disponíveis para Controle do Reator;");
            System.out.println("1. Iniciar processo de fissão de Urânio;");
            System.out.println("2. Ajustar a taxa de fissão (BurnRate)");
            System.out.println("3. Iniciar ativação da válvula de bombeamento de água;");
            System.out.println("4. Aprimorar sistema de bombear água;");
            System.out.println("5. Verificar contratos;");
            System.out.println("6. Continuar;");
            System.out.println();
            int menu = input.nextInt();
            System.out.println("\033[H\033[J");
            switch(menu){
                case 1:
                r.Fissao(U);
                break;
                case 2:
                r.valorBR();
                break;
                case 3:
                b.bombeando(r);
                break;
                case 4:
                b.upgraderA(r);
                break;
                case 5:
                e.contratos(r);
                break;
                case 6:
                break;
                default:
                System.out.println("Opção inválida, tente novamente.");
                break;
            }
             r.avisos();
        }
        input.close();
    }
}
