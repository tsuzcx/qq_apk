import java.util.concurrent.ConcurrentHashMap;

public class knq
{
  public static ConcurrentHashMap<Integer, Object> aW = new ConcurrentHashMap();
  
  public static Object get(int paramInt)
  {
    if (aW.containsKey(Integer.valueOf(paramInt))) {
      return aW.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public static void put(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    aW.remove(Integer.valueOf(paramInt));
    aW.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public static void remove(int paramInt)
  {
    aW.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knq
 * JD-Core Version:    0.7.0.1
 */