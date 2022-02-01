package moai.rx;

import com.google.common.cache.Cache;
import java.util.Comparator;
import java.util.Map.Entry;

class SharedDumper$1
  implements Comparator<Map.Entry<String, Cache>>
{
  SharedDumper$1(SharedDumper paramSharedDumper) {}
  
  public int compare(Map.Entry<String, Cache> paramEntry1, Map.Entry<String, Cache> paramEntry2)
  {
    return ((String)paramEntry1.getKey()).compareTo((String)paramEntry2.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.SharedDumper.1
 * JD-Core Version:    0.7.0.1
 */