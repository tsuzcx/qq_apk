import java.util.Comparator;

public final class evs
  implements Comparator
{
  public int a(evt paramevt1, evt paramevt2)
  {
    return (paramevt1.c - paramevt2.c) * 100 + (paramevt1.e - paramevt2.e) * 10 + (paramevt1.d - paramevt2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     evs
 * JD-Core Version:    0.7.0.1
 */