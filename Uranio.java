public class Uranio{
    private String nome;
    private int  energia, temperatura, QuantU, QuantMaxU, LixoRad;


    public Uranio(){
        nome = "Urânio";
        energia = 500;
        temperatura = 5000;
        QuantU = 500;
        QuantMaxU = 500;
        LixoRad = 100;

    }

    public void setNome(String n){
        nome = n;
    }

    public String getNome(){
        return nome;
    }

    public void setEnergia(int e){
        energia = e;
    }

    public int getEnergia(){
        return energia;
    }

    public void setTemperatura(int T){
        temperatura = T;
    }

    public int getTemperatura(){
        return temperatura;
    }

    public void setQuantU(int U){
        QuantU = U;
    }

    public int getQuantU(){
        return QuantU;
    }

    public int getQuantMaxU(){
        return QuantMaxU;
    }

    public void setQuantMaxU(int QU){
        QuantMaxU = QU;
    }


    public void setLixoRad(int LR){
        LixoRad = LR;
    }

    public int getLixoRad(){
        return LixoRad;
    }

}