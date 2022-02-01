import java.util.Comparator;
import java.util.Map.Entry;

class aozg
  implements Comparator<Map.Entry<String, aozf.a>>
{
  aozg(aozf paramaozf) {}
  
  public int compare(Map.Entry<String, aozf.a> paramEntry1, Map.Entry<String, aozf.a> paramEntry2)
  {
    float f = ((aozf.a)paramEntry2.getValue()).bx() - ((aozf.a)paramEntry1.getValue()).bx();
    if (f > 0.0F) {
      return 1;
    }
    if (f < 0.0F) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozg
 * JD-Core Version:    0.7.0.1
 */