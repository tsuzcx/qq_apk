import java.util.Comparator;

final class amvi
  implements Comparator<ampt>
{
  public int c(ampt paramampt1, ampt paramampt2)
  {
    int j = Long.signum(paramampt2.gN() - paramampt1.gN());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramampt2.gM() - paramampt1.gM());
    }
    j = i;
    if (i == 0) {
      j = amvg.b(paramampt1, paramampt2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amvi
 * JD-Core Version:    0.7.0.1
 */