package wf7;

import com.tencent.wifisdk.services.common.api.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class he
{
  private final e qx;
  
  he(e parame)
  {
    this.qx = parame;
  }
  
  public void a(j paramj)
  {
    int i = this.qx.getInt("aid", 0);
    paramj = gi.k(df.a(paramj));
    this.qx.beginTransaction();
    this.qx.b(String.valueOf(i), paramj);
    this.qx.m("aid", i + 1);
    this.qx.eQ();
  }
  
  public Map<String, j> getAll()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.qx.getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!"aid".equals(localEntry.getKey())) {
        localHashMap.put((String)localEntry.getKey(), (j)df.a(gi.F((String)localEntry.getValue()), new j(), false));
      }
    }
    return localHashMap;
  }
  
  public void remove(String paramString)
  {
    this.qx.L(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.he
 * JD-Core Version:    0.7.0.1
 */