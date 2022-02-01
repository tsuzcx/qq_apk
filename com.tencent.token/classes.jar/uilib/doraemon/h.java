package uilib.doraemon;

import com.tencent.token.go;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class h
{
  private boolean a;
  private final List<a> b;
  private Map<String, go> c;
  
  public void a(String paramString, float paramFloat)
  {
    if (!this.a) {
      return;
    }
    go localgo2 = (go)this.c.get(paramString);
    go localgo1 = localgo2;
    if (localgo2 == null)
    {
      localgo1 = new go();
      this.c.put(paramString, localgo1);
    }
    localgo1.a(paramFloat);
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