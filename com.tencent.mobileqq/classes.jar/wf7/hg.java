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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("_");
    localStringBuilder.append(gi.k(paramq));
    paramq = localStringBuilder.toString();
    this.qx.beginTransaction();
    this.qx.b(String.valueOf(i), paramq);
    this.qx.m("aid", i + 1);
    this.qx.eQ();
  }
  
  public Map<String, hg.a> getAll()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.qx.getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str;
      if (!"aid".equals(((Map.Entry)localObject).getKey()))
      {
        str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
      }
      try
      {
        int i = ((String)localObject).indexOf("_");
        if (i >= 0)
        {
          hg.a locala = new hg.a();
          locala.td = Integer.parseInt(((String)localObject).substring(0, i));
          locala.te = ((q)df.a(gi.F(((String)localObject).substring(i + 1)), new q(), false));
          localHashMap.put(str, locala);
        }
      }
      catch (Throwable localThrowable)
      {
        label173:
        break label173;
      }
    }
    return localHashMap;
  }
  
  public void remove(String paramString)
  {
    this.qx.L(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.hg
 * JD-Core Version:    0.7.0.1
 */