import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class rpu
{
  private static final Object lock = new Object();
  private static List<rpu.a> ph;
  
  @Nullable
  private static rpu.a a(int paramInt)
  {
    bvQ();
    Iterator localIterator = Collections.unmodifiableList(ph).iterator();
    while (localIterator.hasNext())
    {
      rpu.a locala = (rpu.a)localIterator.next();
      if (locala.type == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  private static void bvQ()
  {
    if (ph == null) {
      synchronized (lock)
      {
        ph = new ArrayList();
        String str1 = ((psr)psx.a(10)).mx();
        try
        {
          JSONObject localJSONObject = new JSONObject(str1);
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            Object localObject3 = localJSONObject.getJSONObject(str2);
            String str3 = ((JSONObject)localObject3).optString("jump_url", "");
            localObject3 = ((JSONObject)localObject3).optString("wording", "");
            ph.add(new rpu.a(Integer.valueOf(str2).intValue(), str3, (String)localObject3));
          }
          localObject2 = finally;
        }
        catch (JSONException localJSONException)
        {
          ram.e("VideoSourceTagInfoHelper", "check read config error : %s, configStr : %s", new Object[] { localJSONException, str1 });
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            ram.e("VideoSourceTagInfoHelper", "type format error : %s", new Object[] { str1 });
          }
        }
      }
    }
  }
  
  public static String ci(int paramInt)
  {
    bvQ();
    rpu.a locala = a(paramInt);
    if (locala != null) {
      return locala.wording;
    }
    return "";
  }
  
  public static void clearConfig()
  {
    synchronized (lock)
    {
      if (ph != null)
      {
        ph.clear();
        ph = null;
      }
      return;
    }
  }
  
  public static String getJumpUrl(int paramInt)
  {
    bvQ();
    rpu.a locala = a(paramInt);
    if (locala != null) {
      return locala.jumpUrl;
    }
    return "";
  }
  
  static class a
  {
    public final String jumpUrl;
    public final int type;
    public final String wording;
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.type = paramInt;
      this.jumpUrl = paramString1;
      this.wording = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpu
 * JD-Core Version:    0.7.0.1
 */