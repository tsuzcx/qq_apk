import java.util.Comparator;

public class puj
  implements Comparator<puh>
{
  public int a(puh parampuh1, puh parampuh2)
  {
    if (parampuh1.nodePosition < parampuh2.nodePosition) {
      return 1;
    }
    if (parampuh1.nodePosition > parampuh2.nodePosition) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     puj
 * JD-Core Version:    0.7.0.1
 */