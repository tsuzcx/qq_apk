package okhttp3.internal.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.ax;

public final class f
{
  private final List a;
  private int b = 0;
  
  f(List paramList)
  {
    this.a = paramList;
  }
  
  public boolean a()
  {
    return this.b < this.a.size();
  }
  
  public ax b()
  {
    if (!a()) {
      throw new NoSuchElementException();
    }
    List localList = this.a;
    int i = this.b;
    this.b = (i + 1);
    return (ax)localList.get(i);
  }
  
  public List c()
  {
    return new ArrayList(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.f
 * JD-Core Version:    0.7.0.1
 */