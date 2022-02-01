import java.util.Comparator;

final class amvh
  implements Comparator<ampt>
{
  public int c(ampt paramampt1, ampt paramampt2)
  {
    int j = Long.signum(paramampt2.gN() - paramampt1.gN());
    int i = j;
    if (j == 0) {
      i = amvg.b(paramampt1, paramampt2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amvh
 * JD-Core Version:    0.7.0.1
 */