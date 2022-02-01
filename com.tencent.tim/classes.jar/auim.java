import java.util.Comparator;

class auim
  implements Comparator<atiu>
{
  auim(auif paramauif) {}
  
  public int a(atiu paramatiu1, atiu paramatiu2)
  {
    long l = paramatiu2.getSortTime() - paramatiu1.getSortTime();
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auim
 * JD-Core Version:    0.7.0.1
 */