package btmsdkobf;

import com.tmsdk.base.AbsTMSBaseConfig;
import java.util.Map;

public class ec
{
  private ej ob;
  
  public ec(String paramString)
  {
    String str = paramString;
    if (bc.o().getProductId() != 13) {
      str = bc.o().getProductId() + paramString;
    }
    this.ob = new ej(bc.n(), str);
  }
  
  public static ec cS()
  {
    return new ec("tms_base");
  }
  
  public void clear()
  {
    this.ob.clear();
  }
  
  public Map getAll()
  {
    return this.ob.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.ob.getBoolean(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return this.ob.getFloat(paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.ob.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.ob.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.ob.getString(paramString1, paramString2);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    this.ob.putBoolean(paramString, paramBoolean);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    this.ob.putInt(paramString, paramInt);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    this.ob.putLong(paramString, paramLong);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    this.ob.putString(paramString1, paramString2);
  }
  
  public void remove(String paramString)
  {
    this.ob.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ec
 * JD-Core Version:    0.7.0.1
 */