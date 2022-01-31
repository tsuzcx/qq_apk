package com.tencent.qqpimsecure.taiji;

import Protocol.MMGRAuth.SolutionItem;
import android.content.Context;
import java.util.List;

public class n
{
  private static n a;
  private o b;
  
  private n(Context paramContext)
  {
    this.b = o.a(paramContext);
  }
  
  public static n a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new n(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public SolutionItem a(int paramInt)
  {
    return this.b.a(paramInt);
  }
  
  public void a(List paramList)
  {
    this.b.a(paramList);
  }
  
  public boolean a()
  {
    return this.b.a();
  }
  
  public List b(List paramList)
  {
    return this.b.b(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.n
 * JD-Core Version:    0.7.0.1
 */