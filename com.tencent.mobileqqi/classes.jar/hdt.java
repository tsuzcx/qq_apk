import java.util.Comparator;

public final class hdt
  implements Comparator
{
  public int a(hdu paramhdu1, hdu paramhdu2)
  {
    return (paramhdu1.c - paramhdu2.c) * 100 + (paramhdu1.e - paramhdu2.e) * 10 + (paramhdu1.d - paramhdu2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hdt
 * JD-Core Version:    0.7.0.1
 */