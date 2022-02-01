package taiji;

import java.util.Arrays;
import java.util.List;
import uilib.doraemon.e;

public class ap
  implements an
{
  private final String a;
  private final List<an> b;
  
  public ap(String paramString, List<an> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public br a(e parame, ar paramar)
  {
    return new bs(parame, paramar, this);
  }
  
  public List<an> b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ap
 * JD-Core Version:    0.7.0.1
 */