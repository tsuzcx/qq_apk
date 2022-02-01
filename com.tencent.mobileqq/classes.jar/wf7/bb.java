package wf7;

import java.util.HashMap;
import java.util.Map;

public abstract class bb
{
  private bb.a fe;
  
  public bb.a E()
  {
    return this.fe;
  }
  
  public abstract int F();
  
  public void a(int paramInt, long paramLong)
  {
    a(paramInt, String.valueOf(paramLong));
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.fe == null)
    {
      this.fe = new bb.a(this);
      this.fe.bN = new HashMap();
    }
    Map localMap = this.fe.bN;
    if (paramString == null) {
      paramString = "";
    }
    localMap.put(Integer.valueOf(paramInt), paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    a(paramInt, str);
  }
  
  public abstract void a(String... paramVarArgs);
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, String.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.bb
 * JD-Core Version:    0.7.0.1
 */