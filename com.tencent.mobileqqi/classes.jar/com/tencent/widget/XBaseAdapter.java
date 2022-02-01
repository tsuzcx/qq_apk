package com.tencent.widget;

import android.database.DataSetObserver;
import android.widget.BaseAdapter;
import hxc;

public abstract class XBaseAdapter
  extends BaseAdapter
  implements XListAdapter
{
  private final hxc a = new hxc(this);
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2);
  }
  
  public void a(int... paramVarArgs)
  {
    this.a.a(paramVarArgs);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.a.b(paramInt1, paramInt2);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.a.c(paramInt1, paramInt2);
  }
  
  public void notifyDataSetChanged()
  {
    this.a.notifyChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    this.a.notifyInvalidated();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.registerObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.XBaseAdapter
 * JD-Core Version:    0.7.0.1
 */