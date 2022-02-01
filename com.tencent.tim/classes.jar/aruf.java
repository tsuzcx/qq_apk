import java.util.ArrayList;
import java.util.List;

public class aruf
{
  protected static volatile aruf a;
  protected boolean ddd = true;
  protected List<aruf.a> observers = new ArrayList();
  
  public static aruf a()
  {
    if (a == null) {
      a = new aruf();
    }
    return a;
  }
  
  public void Uj(boolean paramBoolean)
  {
    try
    {
      this.ddd = paramBoolean;
      notifyObservers(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean aHc()
  {
    return this.ddd;
  }
  
  protected void notifyObservers(boolean paramBoolean)
  {
    synchronized (this.observers)
    {
      aruf.a[] arrayOfa = new aruf.a[this.observers.size()];
      this.observers.toArray(arrayOfa);
      if (arrayOfa != null)
      {
        int j = arrayOfa.length;
        int i = 0;
        if (i < j)
        {
          arrayOfa[i].Uk(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Uk(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aruf
 * JD-Core Version:    0.7.0.1
 */