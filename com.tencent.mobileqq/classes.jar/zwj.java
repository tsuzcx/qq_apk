import java.util.concurrent.ConcurrentHashMap;

public class zwj
{
  private static ConcurrentHashMap<String, zwe> a = new ConcurrentHashMap();
  
  public static zwe a(zwd paramzwd)
  {
    zwe localzwe = (zwe)a.get(paramzwd.a());
    if (localzwe == null) {
      try
      {
        localzwe = new zwe(paramzwd);
        a.put(paramzwd.a(), localzwe);
        return localzwe;
      }
      finally {}
    }
    return localzwe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwj
 * JD-Core Version:    0.7.0.1
 */