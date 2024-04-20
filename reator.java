import java.util.Random;
import java.util.Scanner;

public class reator {
   Scanner input = new Scanner(System.in);
   private String red = "\u001B[31m";
   private String brightRed = "\u001B[91m";
   private String green = "\u001B[32m";
   private String brightBlue = "\u001B[94m";
   private String blue = "\u001B[34m";
   private String reset = "\u001B[0m";  
   private String yellow = "\u001B[33m"; 
   private String purple = "\u001B[35m";
   boolean condicao, res, superes, aqc, superaqc = false;
    
 private int LixoRadioativo;
 double temperatura, tanqueAgua, tanqueAguaMax, energia, BurnRate, dinheiro;

 public reator() {
   BurnRate = 1;
   tanqueAgua = 10000000;
   tanqueAguaMax = 10000000;
   temperatura = 15;
   energia = 0;
   LixoRadioativo = 0;
 }
 

 public double getDinheiro() {
   return dinheiro;
}


public void setDinheiro(double dinheiro) {
   this.dinheiro = dinheiro;
}


public void avisos(){
   if(getTanqueAgua() < 1000){
      System.out.println(red + "ALERTA DE SEGURANÇA: O nível do tanque de água encontra-se abaixo do limite mínimo!" + reset);
   }
   if(getTemperatura() > 13000){
      System.out.println(red + "ALERTA DE SEGURANÇA: A temperatura do reator ultrapassou o limite máximo permitido!" + reset);
      System.out.println(purple + "AVISO EMÊRGENCIAL: Possível risco de colapso nuclear detectado!" + reset);
   }
   if(res == true){
      System.out.println(blue + "NOTIFICAÇÃO DE SEGURANÇA: Ativação do Sistema de Resfriamento I do Reator!" + reset);
   } if(getTemperatura() > 8500 && getTemperatura() < 12500){
      System.out.println(red + "ALERTA DE SEGURANÇA: Elevação da Temperatura do Reator Detectada!" + reset);
   } if(superaqc == true){
      System.out.println(red + "ALERTA DE SEGURANÇA: Reator entrou em superaquecimento." + reset);
   } if(superes == true){
      System.out.println(blue + "ALERTA DE EMÊRGENCIA: O sistema de bombeamento de emergência foi ativado." + reset);
   }
 }
  public String Situacao(){
    String Status = "";
    if(getTemperatura() >= 0 && getTemperatura() < 2000){
        Status = (blue + "Absoluto" + reset);
    } else if (getTemperatura() > 2000 && getTemperatura() < 4500){
        Status = (brightBlue + "Eficiente" + reset);
    } else if (getTemperatura() > 4500 && getTemperatura() < 6000){
        Status = (green + "Bom" + reset);
    } else if (getTemperatura() > 6000 && getTemperatura() < 10000){
        Status = (yellow + "Estável" + reset);
    } else if (getTemperatura() > 10000 && getTemperatura() < 14000){
        Status = (red + "Ruim" + reset);
    }else if (getTemperatura() > 14000){
        Status = (brightRed + "CRÍTICO" + reset);
    }
    
    return Status;
}

 public void setBurnRate(double b){
    BurnRate = b;
 }

 public double getBurnRate(){
    return BurnRate;
 }

 public void setTanqueAgua(double T){
    tanqueAgua = T;
 }

 public double getTanqueAgua(){
    return tanqueAgua;
 }

  public void setTanqueAguaMax(int TM){
    tanqueAguaMax = TM;
 }

 public double getTanqueAguaMax(){
    return tanqueAguaMax;
 }

  public void setTemperatura(double t){
    temperatura = t;
 }

 public double getTemperatura(){
    return temperatura;
 }

  public void setEnergia(double e){
    energia = e;
 }

 public double getEnergia(){
    return energia;
 }

 public void setLixoRad(int LD){
    LixoRadioativo = LD;
 }

 public int getLixoRad(){
    return LixoRadioativo;
 }
 
public boolean aquecimento(){
   aqc = false;
   superaqc = false;
   double deltaTemp = 0;
   int incremento250Graus = 0;
   double fatorAquecimento = 0;
   double aguaAquecimento = 0;
   if(getTemperatura() >= 15 && superaqc == false){
      aqc = true;
      deltaTemp = .15;
      incremento250Graus = (int) Math.floor(getTemperatura()/500);
      fatorAquecimento = Math.pow(2, incremento250Graus);
      aguaAquecimento = fatorAquecimento * deltaTemp;
      setTemperatura(getTemperatura() + aguaAquecimento);
   } if(getTanqueAgua() == 0){
      superaqc = true;
      double supaqcdeltaTemp = 5;
      double supaqc50Graus = (int) Math.floor(getTemperatura()/100);
      double fatorsupAqc = Math.pow(2, supaqc50Graus);
      double aguasupAqc = fatorsupAqc * supaqcdeltaTemp;
      setTemperatura(getTemperatura() + aguasupAqc);

   }
   return aqc;
}

 public boolean resfriamento(){
   res = false;
   superes = false;
   if(getTemperatura() >= 3500 && getTemperatura() < 6500 &&  getTanqueAgua() > 0){
      res = true;
      double deltaTemp = .5;
      int decremento500Graus = (int) Math.floor(getTemperatura()/500);
      double fatorResfriamento = Math.pow(2, decremento500Graus);
      double aguaResfriar = fatorResfriamento * deltaTemp;
      setTemperatura(getTemperatura() - aguaResfriar);
      if(getTanqueAgua() > aguaResfriar){
      setTanqueAgua(getTanqueAgua() - aguaResfriar * 2);
      } else {
         setTanqueAgua(0);
      }
      } if(getTemperatura() >= 6500 && getTemperatura() < 15000 && getTanqueAgua() > 0){
         superes = true;
         double superdeltaTemp = 1.5;
         int superdecremento1000Graus = (int) Math.floor(getTemperatura()/1000);
         double superfatorResfriamento = Math.pow(2, superdecremento1000Graus);
         double superAguaResfriar = superfatorResfriamento * superdeltaTemp;
         setTemperatura(getTemperatura() - superAguaResfriar);
         if(getTanqueAgua() > superAguaResfriar){
         setTanqueAgua(getTanqueAgua() - superAguaResfriar * 2);
         } else {
            setTanqueAgua(0);
         }

      }
         if(getTemperatura() < 0){
          setTemperatura(0);
      }
         return res;
 }
 public void valorBR(){
   if(getBurnRate() > 0){
      System.out.println("Qual seria o valor apropriado para a taxa de queima (BurnRate) que o sistema deveria empregar?");
      System.out.println(red + "NOTA: Níveis de BR acima de 15 são considerados perigosos!" + reset);
      double BR = input.nextDouble();
      if(BR > 25){
         System.out.println(red + "ALERTA DE SEGURANÇA: A Taxa de fissão (BurnRate) encontra-se significativamente acima do limite suportado pelo reator. " + reset);
         System.out.println(red + "Deseja prosseguir com essa configuração de BR?" + reset);
            System.out.println("1. Sim;");
            System.out.println("2. Não;");
            int menu = input.nextInt();
            if(menu == 1){
               condicao = true;
               setBurnRate(BR);
            } else{
               System.out.println(green + "Ação negada." + reset);
               condicao = false;
            }
      } else {
         System.out.println(green + "Configuração alterada com sucesso." + reset);
         setBurnRate(BR);
      }
   }
 }

public boolean Explodir(){
    boolean explosao = false;
    Random rdm = new Random();
    int valorR = rdm.nextInt(3);
    if(valorR == 2 && getTemperatura() > 15000){
        explosao = true;
    } 
return explosao;
}

public void Fissao(Uranio U){
   double Temp = 0;
   double novaTemp = 0;
    if(U != null && getBurnRate() > 0){
      if(getBurnRate() <= U.getQuantU()){
         double deltaTemperatura = 0.125;
         double EnergiaPorKg = getBurnRate();
         double MaterialFissionado = U.getEnergia() * EnergiaPorKg;
         double aguaNecessaria = (U.getEnergia() * EnergiaPorKg) * deltaTemperatura * getTemperatura();
         if(getTanqueAgua() > aguaNecessaria && getTanqueAgua() > 0 || condicao == true){
            double soma = getTanqueAgua() - aguaNecessaria;
            if(soma >= 0){
         setTanqueAgua(getTanqueAgua() - aguaNecessaria);
         setEnergia(getEnergia() + MaterialFissionado);
         Temp = getTemperatura() + U.getTemperatura() + EnergiaPorKg / getTanqueAgua();
         novaTemp = Temp * deltaTemperatura;
         setTemperatura(getTemperatura() + novaTemp);
         setLixoRad(getLixoRad() + U.getLixoRad());
         System.out.println(green + getBurnRate() + " kg de urânio foram fissionados." + reset);
         System.out.println(brightBlue + "Foram gerados " + MaterialFissionado + " de energia. " + reset);
            } else {
               setTanqueAgua(0);
               Temp = getTemperatura() + U.getTemperatura() * EnergiaPorKg;
               novaTemp = Temp * deltaTemperatura;
               setTemperatura(getTemperatura() + novaTemp);
               setLixoRad(U.getLixoRad());
            }
         } else{
            System.out.println(red + "ALERTA DE SEGURANÇA: A Taxa de Fissão (BurnRate) requer um volume de água superior à capacidade disponível no tanque." + reset);
            System.out.println("Deseja continuar apesar disso?");
            System.out.println("1. Sim;");
            System.out.println("2. Não;");
            int menu2 = input.nextInt();
            if(menu2 == 1){
             condicao = true;  
            } else {
               System.out.println(green + "Ação negada." + reset);
               condicao = false;
            }      
         }
      } else {
         System.out.println(red + "AVISO! Sistema detectou BurnRate maior que a capacidade de urânio. O problema foi corrigido." + reset);
         setBurnRate(U.getQuantU());
      }
    }
}
}
    

