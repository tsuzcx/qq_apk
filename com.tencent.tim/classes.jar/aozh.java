import java.util.Comparator;
import java.util.Map.Entry;

class aozh
  implements Comparator<Map.Entry<String, aozf.a>>
{
  aozh(aozf paramaozf) {}
  
  public int compare(Map.Entry<String, aozf.a> paramEntry1, Map.Entry<String, aozf.a> paramEntry2)
  {
    long l = ((aozf.a)paramEntry2.getValue()).aqF - ((aozf.a)paramEntry1.getValue()).aqF;
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
 * Qualified Name:     aozh
 * JD-Core Version:    0.7.0.1
 */