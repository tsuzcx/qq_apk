package com.tencent.token;

import android.database.DataSetObservable;
import android.database.DataSetObserver;

public abstract class ev
{
  private final DataSetObservable a = new DataSetObservable();
  private DataSetObserver b;
  
  public static void b()
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }
  
  public abstract int a();
  
  public final void a(DataSetObserver paramDataSetObserver)
  {
    this.a.registerObserver(paramDataSetObserver);
  }
  
  public final void b(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterObserver(paramDataSetObserver);
  }
  
  public final void c(DataSetObserver paramDataSetObserver)
  {
    try
    {
      this.b = paramDataSetObserver;
      return;
    }
    finally {}
  }
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ev
 * JD-Core Version:    0.7.0.1
 */