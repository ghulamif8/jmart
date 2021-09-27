package GhulamJmartAK;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;

    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag,ProductCategory category, Shipment.MultiDuration multiDuration) {
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.multiDuration = multiDuration;
    }
    
    public boolean read(String content) {
        return false;
    }
    
    public String toString(){
        return this.name + this.weight + this.conditionUsed + this.priceTag + this.category + this.rating + this.storeId;
    }
}
