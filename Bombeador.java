import java.util.Scanner;
public class Bombeador {
    Scanner input = new Scanner(System.in);
    private String red = "\u001B[31m";
    private String green = "\u001B[32m";
    private String reset = "\u001B[0m";  
    private double upgraderB, upgraderBM, bombaAgua, litroS, bombaAguaMax;
    private int contadorE;

    public Bombeador(){
        upgraderB = 1.25;
        upgraderBM = 1.25;
        bombaAgua = 0;
        litroS = 100;
        bombaAguaMax = 10000;
        contadorE = 1;

    }
    

    public double getLitroS() {
        return litroS;
    }


    public void setLitroS(double litroS) {
        this.litroS = litroS;
    }


    public int getContadorE() {
        return contadorE;
    }


    public void setContadorE(int contadorE) {
        this.contadorE = contadorE;
    }


    public double getUpgraderB() {
        return upgraderB;
    }

    public void setUpgraderB(double upgraderB) {
        this.upgraderB = upgraderB;
    }

    public double getUpgraderBM() {
        return upgraderBM;
    }

    public void setUpgraderBM(double upgraderBM) {
        this.upgraderBM = upgraderBM;
    }

    public double getBombaAgua() {
        return bombaAgua;
    }

    public void setBombaAgua(double bombaAgua) {
        this.bombaAgua = bombaAgua;
    }

    public double getBombaAguaMax() {
        return bombaAguaMax;
    }

    public void setBombaAguaMax(double bombaAguaMax) {
        this.bombaAguaMax = bombaAguaMax;
    }

    public void bombeando(reator r){
        double AguaSec = getBombaAgua();
        double AguaMax = getBombaAguaMax();
        while(AguaSec < AguaMax){
            AguaSec += getLitroS();
            if(r.getTanqueAgua() < r.getTanqueAguaMax()){
            r.setTanqueAgua(r.getTanqueAgua() + AguaSec);
            } else{
                r.setTanqueAgua(10000000);
            }
        }
        if(AguaMax == AguaMax){
            System.out.println(green + "Válvula bombeada com sucesso." + reset);
        }
    }

    public void upgraderA(reator r){
        contadorE = getContadorE();
        double dinheiro = 2500 * contadorE;
        System.out.println(red + "SISTEMA: Dinheiro necessário: " + dinheiro + reset);
        if(r.getDinheiro() >= dinheiro){
            System.out.println(green + "SISTEMA: Identificamos uma oportunidade de aprimoramento para otimizar o processo de bombeamento de água para o reator. Gostaria de prosseguir com essa melhoria?" + reset);
            System.out.println("1. Sim;");
            System.out.println("2. Não;");
            int menu = input.nextInt();
            switch(menu){
                case 1:
                setContadorE(getContadorE() + 1);
                setLitroS(getLitroS()* 2);
                setBombaAguaMax(getBombaAguaMax() * 2);
                r.setDinheiro(r.getDinheiro() - dinheiro);
                System.out.println("BA: " + getBombaAgua());
                System.out.println("BAM: " + getBombaAguaMax());
                System.out.println(green + "SISTEMA: Aprimoração realizada com sucesso." + reset);
                break;
                case 2:
                System.out.println(red + "Ação negada." + reset);
                break;
            }
        } else {
            System.out.println(red + "AVISO: Quantidade insuficiente de energia para aprimorar sistema de válvula." + reset);
        }
    }
    

    
    
}
