package com.tencent.qqpimsecure.taiji;

import Protocol.MMGRAuth.SolutionItem;
import android.content.Context;
import java.util.List;

public class g
{
  private static g a;
  private h b;
  
  private g(Context paramContext)
  {
    this.b = h.a(paramContext);
  }
  
  public static g a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new g(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public SolutionItem a(int paramInt)
  {
    return this.b.a(paramInt);
  }
  
  public void a(List<Integer> paramList)
  {
    this.b.a(paramList);
  }
  
  public boolean a()
  {
    return this.b.a();
  }
  
  public List<SolutionItem> b(List<Integer> paramList)
  {
    return this.b.b(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.g
 * JD-Core Version:    0.7.0.1
 */