package uilib.doraemon;

import com.tencent.token.gm;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class h
{
  private boolean a;
  private final List<a> b;
  private Map<String, gm> c;
  
  public void a(String paramString, float paramFloat)
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      gm localgm2 = (gm)this.c.get(paramString);
      gm localgm1 = localgm2;
      if (localgm2 == null)
      {
        localgm1 = new gm();
        this.c.put(paramString, localgm1);
      }
      localgm1.a(paramFloat);
      if (paramString.equals("root"))
      {
        paramString = this.b.iterator();
        while (paramString.hasNext()) {
          ((a)paramString.next()).a(paramFloat);
        }
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.h
 * JD-Core Version:    0.7.0.1
 */