import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class amxe
{
  static amxe a;
  public boolean cEr = true;
  public boolean cEs = true;
  public String ccn = "0";
  AtomicBoolean dK = new AtomicBoolean(false);
  HashMap<String, Integer> hb = new HashMap();
  public boolean needUpdate = false;
  ArrayList<Entity> zG = null;
  
  public static amxe a()
  {
    try
    {
      if (a == null) {
        a = new amxe();
      }
      amxe localamxe = a;
      return localamxe;
    }
    finally {}
  }
  
  public boolean oJ(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (this.hb == null) {
      this.hb = new HashMap();
    }
    return this.hb.containsKey(paramString);
  }
  
  public void release()
  {
    this.zG.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxe
 * JD-Core Version:    0.7.0.1
 */