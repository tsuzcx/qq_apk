import java.util.Comparator;
import java.util.Map.Entry;

class anpe
  implements Comparator<Map.Entry<String, Integer>>
{
  anpe(anpd paramanpd) {}
  
  public int compare(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    return -((Integer)paramEntry1.getValue()).compareTo((Integer)paramEntry2.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anpe
 * JD-Core Version:    0.7.0.1
 */