package GhulamJmartAK;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * @ghulamif8
 * @abrahamkristanto
 */
public class Payment extends Invoice implements Transactor
{
    // instance variables - replace the example below with your own
    public Shipment shipment;
    public int productCount;
    
    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment){
        super(id,buyerId,productId);
        this.shipment = shipment;
    }

    @Override
    public double getTotalPay(){
        return 0.0;
    }

    public boolean validate(){
        return false;
    }
    
    public Invoice perform(){
        return null;
    }
}