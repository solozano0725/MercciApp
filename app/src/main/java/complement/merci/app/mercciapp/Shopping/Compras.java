package complement.merci.app.mercciapp.Shopping;

import java.util.ArrayList;

public class Compras {

    private static ArrayList<Venta> totalCompra = new ArrayList<>();

    public Compras() {

    }

    public ArrayList<Venta> getTotalCompra() {
        return totalCompra;
    }

    public void addCompra(Venta v){
        this.totalCompra.add(v);
    }

    public void deleteCompra(Venta v){
        for(int i =0;i <totalCompra.size();i++){
            if(totalCompra.get(i).getTitle().equalsIgnoreCase(v.getTitle())){
                this.totalCompra.remove(i);
            }
        }
    }
}
