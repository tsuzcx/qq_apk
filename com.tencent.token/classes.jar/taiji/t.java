package taiji;

import java.util.ArrayList;
import java.util.List;

public class t
{
  private final List a;
  private final List b;
  private final List c;
  
  public t(List paramList)
  {
    this.c = paramList;
    this.a = new ArrayList(paramList.size());
    this.b = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      this.a.add(((cc)paramList.get(i)).b().c());
      ai localai = ((cc)paramList.get(i)).c();
      this.b.add(localai.a());
      i += 1;
    }
  }
  
  public List a()
  {
    return this.c;
  }
  
  public List b()
  {
    return this.a;
  }
  
  public List c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.t
 * JD-Core Version:    0.7.0.1
 */