import java.util.Comparator;
import java.util.Map.Entry;

final class ahar
  implements Comparator<Map.Entry<String, Integer>>
{
  public int compare(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    return ((Integer)paramEntry2.getValue()).intValue() - ((Integer)paramEntry1.getValue()).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ahar
 * JD-Core Version:    0.7.0.1
 */