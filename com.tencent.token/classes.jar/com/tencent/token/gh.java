package com.tencent.token;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class gh
  extends BaseAdapter
  implements Filterable, gi.a
{
  protected boolean a = false;
  protected boolean b = true;
  protected Cursor c = null;
  protected Context d;
  protected int e;
  protected a f;
  protected DataSetObserver g;
  protected gi h;
  protected FilterQueryProvider i;
  
  public gh(Context paramContext)
  {
    this.d = paramContext;
    this.e = -1;
    this.f = new a();
    this.g = new b();
  }
  
  public final Cursor a()
  {
    return this.c;
  }
  
  public Cursor a(CharSequence paramCharSequence)
  {
    FilterQueryProvider localFilterQueryProvider = this.i;
    if (localFilterQueryProvider != null) {
      return localFilterQueryProvider.runQuery(paramCharSequence);
    }
    return this.c;
  }
  
  public abstract View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  public void a(Cursor paramCursor)
  {
    Cursor localCursor = this.c;
    if (paramCursor == localCursor)
    {
      paramCursor = null;
    }
    else
    {
      Object localObject;
      if (localCursor != null)
      {
        localObject = this.f;
        if (localObject != null) {
          localCursor.unregisterContentObserver((ContentObserver)localObject);
        }
        localObject = this.g;
        if (localObject != null) {
          localCursor.unregisterDataSetObserver((DataSetObserver)localObject);
        }
      }
      this.c = paramCursor;
      if (paramCursor != null)
      {
        localObject = this.f;
        if (localObject != null) {
          paramCursor.registerContentObserver((ContentObserver)localObject);
        }
        localObject = this.g;
        if (localObject != null) {
          paramCursor.registerDataSetObserver((DataSetObserver)localObject);
        }
        this.e = paramCursor.getColumnIndexOrThrow("_id");
        this.a = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        this.e = -1;
        this.a = false;
        notifyDataSetInvalidated();
        paramCursor = localCursor;
      }
    }
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public abstract void a(View paramView, Cursor paramCursor);
  
  public View b(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return a(paramContext, paramCursor, paramViewGroup);
  }
  
  public CharSequence b(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return "";
    }
    return paramCursor.toString();
  }
  
  protected final void b()
  {
    if (this.b)
    {
      Cursor localCursor = this.c;
      if ((localCursor != null) && (!localCursor.isClosed())) {
        this.a = this.c.requery();
      }
    }
  }
  
  public int getCount()
  {
    if (this.a)
    {
      Cursor localCursor = this.c;
      if (localCursor != null) {
        return localCursor.getCount();
      }
    }
    return 0;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a)
    {
      this.c.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = b(this.d, this.c, paramViewGroup);
      }
      a(localView, this.c);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.h == null) {
      this.h = new gi(this);
    }
    return this.h;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a)
    {
      Cursor localCursor = this.c;
      if (localCursor != null)
      {
        localCursor.moveToPosition(paramInt);
        return this.c;
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.a)
    {
      Cursor localCursor = this.c;
      if (localCursor != null)
      {
        if (localCursor.moveToPosition(paramInt)) {
          return this.c.getLong(this.e);
        }
        return 0L;
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a)
    {
      if (this.c.moveToPosition(paramInt))
      {
        View localView = paramView;
        if (paramView == null) {
          localView = a(this.d, this.c, paramViewGroup);
        }
        a(localView, this.c);
        return localView;
      }
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    throw new IllegalStateException("this should only be called when the cursor is valid");
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  final class a
    extends ContentObserver
  {
    a()
    {
      super();
    }
    
    public final boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      gh.this.b();
    }
  }
  
  final class b
    extends DataSetObserver
  {
    b() {}
    
    public final void onChanged()
    {
      gh localgh = gh.this;
      localgh.a = true;
      localgh.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      gh localgh = gh.this;
      localgh.a = false;
      localgh.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gh
 * JD-Core Version:    0.7.0.1
 */