package taiji;

import java.util.Arrays;
import java.util.List;
import uilib.doraemon.e;

public class ba
  implements ay
{
  private final String a;
  private final List b;
  
  public ba(String paramString, List paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public cx a(e parame, bd parambd)
  {
    return new cy(parame, parambd, this);
  }
  
  public List b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ba
 * JD-Core Version:    0.7.0.1
 */