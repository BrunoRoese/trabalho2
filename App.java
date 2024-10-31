import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main (String args []){
        List<Integer> paradas = List.of(0,1,5,11,14,21,24,31,33,41);
        int ultimo = paradas.get(paradas.size() - 1);
        List<Integer> result = funciona(paradas, 10, ultimo);
        System.out.println(result);

        //List<Integer> distancias = retornaDistancias(paradas);
        
    }
    
    public static List<Integer> funciona(List<Integer> paradas, int d, int L){
        List<Integer> ondeParei = new ArrayList<Integer>();
        int possoAndar = d;
        for (int i = 0; i < paradas.size(); i++) {
            int atual = paradas.get(i);
            //se o atual eh o ultimo, adiciona na lista e evita o nullpointer
            if(atual == L){
                ondeParei.add(atual);
                break;
            }
            int proximo = paradas.get(i+1);
            int dif = proximo - atual;
            possoAndar = possoAndar - dif;

            if(possoAndar<0){
                ondeParei.add(atual);
                possoAndar = d;
                i--;
            }
            
        }
        return ondeParei;
    }
    
    public static List<Integer> algoritmo(List<Integer> paradas, List<Integer> distancias, int d){
        int soma = 0;
        List<Integer> vetor = new ArrayList<>();
        for (int i = 0; i < distancias.size(); i++) {
            if(soma+distancias.get(i) <= d) soma += distancias.get(i);
            else{
                vetor.add(i);
                soma = 0;
            }
        }
        
        return vetor;
    }

    public static List<Integer> retornaDistancias(List<Integer> paradas){
        List<Integer> distancias = new ArrayList<Integer>();
        for (int i = 0; i < paradas.size()-1; i++) {
            int distancia = paradas.get(i+1) - paradas.get(i);
            distancias.add(distancia);
        }
        return distancias;
    }


}
