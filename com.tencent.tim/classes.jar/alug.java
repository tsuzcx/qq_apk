import java.util.Comparator;
import java.util.Map.Entry;

class alug
  implements Comparator<Map.Entry<String, Long>>
{
  alug(aluf paramaluf) {}
  
  public int compare(Map.Entry<String, Long> paramEntry1, Map.Entry<String, Long> paramEntry2)
  {
    return ((Long)paramEntry2.getValue()).compareTo((Long)paramEntry1.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alug
 * JD-Core Version:    0.7.0.1
 */