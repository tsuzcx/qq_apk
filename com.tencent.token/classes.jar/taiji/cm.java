package taiji;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import java.util.List;
import uilib.doraemon.e;

public class cm
  implements an
{
  private final String a;
  private final ac b;
  private final List<ac> c;
  private final ab d;
  private final ad e;
  private final ac f;
  private final b g;
  private final c h;
  
  public String a()
  {
    return this.a;
  }
  
  public br a(e parame, ar paramar)
  {
    return new j(parame, paramar, this);
  }
  
  public ab b()
  {
    return this.d;
  }
  
  public ad c()
  {
    return this.e;
  }
  
  public ac d()
  {
    return this.f;
  }
  
  public List<ac> e()
  {
    return this.c;
  }
  
  public ac f()
  {
    return this.b;
  }
  
  public b g()
  {
    return this.g;
  }
  
  public c h()
  {
    return this.h;
  }
  
  public static enum b
  {
    private b() {}
    
    public Paint.Cap a()
    {
      switch (cm.1.a[ordinal()])
      {
      default: 
        return Paint.Cap.SQUARE;
      case 2: 
        return Paint.Cap.ROUND;
      }
      return Paint.Cap.BUTT;
    }
  }
  
  public static enum c
  {
    private c() {}
    
    public Paint.Join a()
    {
      switch (cm.1.b[ordinal()])
      {
      default: 
        return null;
      case 3: 
        return Paint.Join.ROUND;
      case 2: 
        return Paint.Join.MITER;
      }
      return Paint.Join.BEVEL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.cm
 * JD-Core Version:    0.7.0.1
 */