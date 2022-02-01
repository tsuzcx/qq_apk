import java.util.Comparator;

class abph
  implements Comparator<abpg.a>
{
  abph(abpg paramabpg) {}
  
  public int a(abpg.a parama1, abpg.a parama2)
  {
    if (parama1.Oj == parama2.Oj) {
      return 0;
    }
    if (parama1.Oj > parama2.Oj) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abph
 * JD-Core Version:    0.7.0.1
 */