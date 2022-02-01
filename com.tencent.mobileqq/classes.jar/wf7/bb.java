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
    if (paramString != null) {}
    for (;;)
    {
      localMap.put(Integer.valueOf(paramInt), paramString);
      return;
      paramString = "";
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      a(paramInt, str);
      return;
    }
  }
  
  public abstract void a(String... paramVarArgs);
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, String.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.bb
 * JD-Core Version:    0.7.0.1
 */