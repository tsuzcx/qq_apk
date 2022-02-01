package uilib.doraemon;

import com.tencent.token.gl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class h
{
  private boolean a;
  private final List<a> b;
  private Map<String, gl> c;
  
  public void a(String paramString, float paramFloat)
  {
    if (!this.a) {
      return;
    }
    gl localgl2 = (gl)this.c.get(paramString);
    gl localgl1 = localgl2;
    if (localgl2 == null)
    {
      localgl1 = new gl();
      this.c.put(paramString, localgl1);
    }
    localgl1.a(paramFloat);
    if (paramString.equals("root"))
    {
      paramString = this.b.iterator();
      while (paramString.hasNext()) {
        ((a)paramString.next()).a(paramFloat);
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