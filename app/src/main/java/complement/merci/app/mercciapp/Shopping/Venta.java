package complement.merci.app.mercciapp.Shopping;

public class Venta {

    private int img;
    private String title;
    private double price;
    private int cant;

    public Venta(int img, String title, double price, int cant) {
        this.img = img;
        this.title = title;
        this.price = price;
        this.cant = cant;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}
