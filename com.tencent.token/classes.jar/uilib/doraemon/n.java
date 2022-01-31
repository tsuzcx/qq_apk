package uilib.doraemon;

import com.tencent.token.is;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class n
{
  private boolean a;
  private final List b;
  private Map c;
  
  public void a(String paramString, float paramFloat)
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      is localis2 = (is)this.c.get(paramString);
      is localis1 = localis2;
      if (localis2 == null)
      {
        localis1 = new is();
        this.c.put(paramString, localis1);
      }
      localis1.a(paramFloat);
      if (paramString.equals("root"))
      {
        paramString = this.b.iterator();
        while (paramString.hasNext()) {
          ((o)paramString.next()).a(paramFloat);
        }
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.n
 * JD-Core Version:    0.7.0.1
 */