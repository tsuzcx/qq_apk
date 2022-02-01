package taiji;

import android.util.Log;
import uilib.doraemon.e;

public class cd
  implements an
{
  private final String a;
  private final b b;
  
  public String a()
  {
    return this.a;
  }
  
  public br a(e parame, ar paramar)
  {
    if (!parame.a())
    {
      Log.w("Doraemon", "Animation contains merge paths but they are disabled.");
      return null;
    }
    return new g(this);
  }
  
  public b b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "MergePaths{mode=" + this.b + '}';
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.cd
 * JD-Core Version:    0.7.0.1
 */