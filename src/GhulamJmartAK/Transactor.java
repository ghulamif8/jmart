package GhulamJmartAK;


/**
 * Write a description of interface Transactor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Transactor
{
    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     * @return   the result produced by sampleMethod
     */
    public abstract boolean validate();
    public abstract Invoice perform();
}