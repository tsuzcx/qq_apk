package com.tencent.android.tpush.service.channel;

import android.util.SparseArray;

public class a
{
  private static a a = new a();
  private SparseArray<Object> b = new SparseArray();
  
  public a() {}
  
  public a(Object... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.b.put(((Integer)paramVarArgs[i]).intValue(), paramVarArgs[(i + 1)]);
      i += 2;
    }
  }
  
  public boolean a()
  {
    return ((Boolean)this.b.get(2, Boolean.valueOf(false))).booleanValue();
  }
  
  public String b()
  {
    return (String)this.b.get(0, "");
  }
  
  public int c()
  {
    return ((Integer)this.b.get(1, Integer.valueOf(0))).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.channel.a
 * JD-Core Version:    0.7.0.1
 */