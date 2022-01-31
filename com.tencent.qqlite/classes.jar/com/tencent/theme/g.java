package com.tencent.theme;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.LongSparseArray;

@TargetApi(16)
public class g
  extends LongSparseArray<Drawable.ConstantState>
{
  private int a;
  private f b;
  
  public g(int paramInt, f paramf)
  {
    this.a = paramInt;
    this.b = paramf;
  }
  
  public Drawable.ConstantState a(int paramInt)
  {
    return (Drawable.ConstantState)this.b.b[this.a].valueAt(paramInt);
  }
  
  public Drawable.ConstantState a(long paramLong)
  {
    return this.b.a(this.a, paramLong);
  }
  
  public void a(long paramLong, Drawable.ConstantState paramConstantState)
  {
    this.b.b[this.a].put(paramLong, paramConstantState);
  }
  
  public int size()
  {
    return this.b.b[this.a].size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.theme.g
 * JD-Core Version:    0.7.0.1
 */