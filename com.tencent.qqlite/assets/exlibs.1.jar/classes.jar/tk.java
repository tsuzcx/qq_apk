import java.util.Iterator;

public final class tk
  implements Iterable
{
  public tk(Iterable paramIterable, boolean paramBoolean) {}
  
  public Iterator iterator()
  {
    return new tl(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tk
 * JD-Core Version:    0.7.0.1
 */