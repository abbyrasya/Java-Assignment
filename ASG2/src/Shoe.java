import javax.print.attribute.standard.SheetCollate;
import java.util.Date;

public class Shoe {

    private String name;
    private String category;
    private Date date;
    private Integer price;

    public Shoe(String name, String Category, Date date, Integer price) {
        setName(name);
        setCategory(Category);
        setDate(date);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
