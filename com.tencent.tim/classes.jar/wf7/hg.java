package wf7;

import com.tencent.wifisdk.services.common.api.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class hg
{
  private final e qx;
  
  hg(e parame)
  {
    this.qx = parame;
  }
  
  public void b(int paramInt, q paramq)
  {
    int i = this.qx.getInt("aid", 0);
    paramq = df.a(paramq);
    paramq = String.valueOf(paramInt) + "_" + gi.k(paramq);
    this.qx.beginTransaction();
    this.qx.b(String.valueOf(i), paramq);
    this.qx.m("aid", i + 1);
    this.qx.eQ();
  }
  
  public Map<String, a> getAll()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.qx.getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (!"aid".equals(((Map.Entry)localObject).getKey()))
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        try
        {
          int i = ((String)localObject).indexOf("_");
          if (i >= 0)
          {
            a locala = new a();
            locala.td = Integer.parseInt(((String)localObject).substring(0, i));
            locala.te = ((q)df.a(gi.F(((String)localObject).substring(i + 1)), new q(), false));
            localHashMap.put(str, locala);
          }
        }
        catch (Throwable localThrowable) {}
      }
    }
    return localHashMap;
  }
  
  public void remove(String paramString)
  {
    this.qx.L(paramString);
  }
  
  public static final class a
  {
    int td;
    q te;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.hg
 * JD-Core Version:    0.7.0.1
 */