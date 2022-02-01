package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.ab;

public final class d
{
  private final Set<ab> a = new LinkedHashSet();
  
  public void a(ab paramab)
  {
    try
    {
      this.a.add(paramab);
      return;
    }
    finally
    {
      paramab = finally;
      throw paramab;
    }
  }
  
  public void b(ab paramab)
  {
    try
    {
      this.a.remove(paramab);
      return;
    }
    finally
    {
      paramab = finally;
      throw paramab;
    }
  }
  
  public boolean c(ab paramab)
  {
    try
    {
      boolean bool = this.a.contains(paramab);
      return bool;
    }
    finally
    {
      paramab = finally;
      throw paramab;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.d
 * JD-Core Version:    0.7.0.1
 */