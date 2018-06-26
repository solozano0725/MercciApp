package complement.merci.app.mercciapp;

public class Informacion {

    private String titleClass;
    private int img;
    private String ref;
    private String nameI;
    private String colorI;
    private String priceI;
    private String descI;
    private int cantI;

    public Informacion(String titleClass, int img, String ref, String nameI, String colorI, String descI, String priceI, int cantI) {
        this.titleClass = titleClass;
        this.img = img;
        this.ref = ref;
        this.nameI = nameI;
        this.colorI = colorI;
        this.priceI = priceI;
        this.cantI = cantI;
        this.descI = descI;
    }

    public String getTitleClass() {
        return titleClass;
    }

    public void setTitleClass(String titleClass) {
        this.titleClass = titleClass;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNameI() {
        return nameI;
    }

    public void setNameI(String nameI) {
        this.nameI = nameI;
    }

    public String getColorI() {
        return colorI;
    }

    public void setColorI(String colorI) {
        this.colorI = colorI;
    }

    public String getPriceI() {
        return priceI;
    }

    public void setPriceI(String priceI) {
        this.priceI = priceI;
    }

    public int getCantI() {
        return cantI;
    }

    public void setCantI(int cantI) {
        this.cantI = cantI;
    }

    public String getDescI() {
        return descI;
    }

    public void setDescI(String descI) {
        this.descI = descI;
    }
}
