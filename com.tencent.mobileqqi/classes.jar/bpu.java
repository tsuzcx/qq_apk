import java.util.Iterator;

public final class bpu
  implements Iterable
{
  public bpu(Iterable paramIterable, boolean paramBoolean) {}
  
  public Iterator iterator()
  {
    return new bpv(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bpu
 * JD-Core Version:    0.7.0.1
 */