package taiji;

import android.util.Log;
import uilib.doraemon.e;

public class cd
  implements ay
{
  private final String a;
  private final cd.b b;
  
  public String a()
  {
    return this.a;
  }
  
  public cx a(e parame, bd parambd)
  {
    if (!parame.a())
    {
      Log.w("Doraemon", "Animation contains merge paths but they are disabled.");
      return null;
    }
    return new g(this);
  }
  
  public cd.b b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "MergePaths{mode=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.cd
 * JD-Core Version:    0.7.0.1
 */