package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.ax;

public final class d
{
  private final Set a = new LinkedHashSet();
  
  public void a(ax paramax)
  {
    try
    {
      this.a.add(paramax);
      return;
    }
    finally
    {
      paramax = finally;
      throw paramax;
    }
  }
  
  public void b(ax paramax)
  {
    try
    {
      this.a.remove(paramax);
      return;
    }
    finally
    {
      paramax = finally;
      throw paramax;
    }
  }
  
  public boolean c(ax paramax)
  {
    try
    {
      boolean bool = this.a.contains(paramax);
      return bool;
    }
    finally
    {
      paramax = finally;
      throw paramax;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.d
 * JD-Core Version:    0.7.0.1
 */