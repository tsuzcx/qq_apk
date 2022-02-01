import java.util.HashMap;
import java.util.Observable;

public class tyy
  extends Observable
{
  private static tyy a;
  public HashMap<String, String> gu;
  
  public static tyy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new tyy();
      }
      return a;
    }
    finally {}
  }
  
  public void v(HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("key_type", "t_held_thread");
    this.gu = paramHashMap;
    setChanged();
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tyy
 * JD-Core Version:    0.7.0.1
 */