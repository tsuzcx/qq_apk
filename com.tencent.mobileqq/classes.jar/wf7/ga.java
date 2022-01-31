package wf7;

import com.tencent.wifisdk.services.common.api.e;
import java.util.Map;

public class ga
  implements e, au
{
  private hh rP;
  
  public ga(hh paramhh)
  {
    this.rP = paramhh;
  }
  
  public boolean L(String paramString)
  {
    return this.rP.L(paramString);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    return this.rP.a(paramString, paramLong);
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    return this.rP.b(paramString1, paramString2);
  }
  
  public void beginTransaction()
  {
    this.rP.beginTransaction();
  }
  
  public boolean e(String paramString, boolean paramBoolean)
  {
    return this.rP.e(paramString, paramBoolean);
  }
  
  public boolean eQ()
  {
    return this.rP.eQ();
  }
  
  public Map<String, ?> getAll()
  {
    return this.rP.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.rP.getBoolean(paramString, paramBoolean);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.rP.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.rP.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString)
  {
    return this.rP.getString(paramString);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.rP.getString(paramString1, paramString2);
  }
  
  public boolean m(String paramString, int paramInt)
  {
    return this.rP.m(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ga
 * JD-Core Version:    0.7.0.1
 */