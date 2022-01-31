package com.tencent.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import fhu;
import fhv;
import fja;
import fjb;

public abstract class XCursorAdapter
  extends XBaseAdapter
  implements Filterable, fhv
{
  @Deprecated
  public static final int b = 1;
  public static final int c = 2;
  protected int a;
  protected Context a;
  protected Cursor a;
  protected DataSetObserver a;
  protected FilterQueryProvider a;
  protected fhu a;
  protected fja a;
  public boolean a;
  protected boolean b;
  
  @Deprecated
  public XCursorAdapter(Context paramContext, Cursor paramCursor)
  {
    a(paramContext, paramCursor, 1);
  }
  
  public XCursorAdapter(Context paramContext, Cursor paramCursor, int paramInt)
  {
    a(paramContext, paramCursor, paramInt);
  }
  
  public XCursorAdapter(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      a(paramContext, paramCursor, i);
      return;
    }
  }
  
  public int a(Cursor paramCursor, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidDatabaseCursor != null) && (this.jdField_a_of_type_AndroidDatabaseCursor.moveToFirst()) && (paramCursor != null))
    {
      long l = this.jdField_a_of_type_AndroidDatabaseCursor.getLong(0);
      paramInt = 0;
      while (paramInt < paramCursor.getCount())
      {
        if ((paramCursor.moveToPosition(paramInt)) && (paramCursor.getLong(0) == l))
        {
          paramCursor = a(paramCursor, paramInt);
          if (paramCursor != null) {
            paramCursor.close();
          }
          return paramInt;
        }
        paramInt += 1;
      }
    }
    a(paramCursor);
    return 0;
  }
  
  public Cursor a()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor;
  }
  
  public Cursor a(Cursor paramCursor)
  {
    if (paramCursor == this.jdField_a_of_type_AndroidDatabaseCursor) {
      return null;
    }
    Cursor localCursor = this.jdField_a_of_type_AndroidDatabaseCursor;
    if (localCursor != null)
    {
      if (this.jdField_a_of_type_Fja != null) {
        localCursor.unregisterContentObserver(this.jdField_a_of_type_Fja);
      }
      if (this.jdField_a_of_type_AndroidDatabaseDataSetObserver != null) {
        localCursor.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      }
    }
    this.jdField_a_of_type_AndroidDatabaseCursor = paramCursor;
    if (paramCursor != null)
    {
      if (this.jdField_a_of_type_Fja != null) {
        paramCursor.registerContentObserver(this.jdField_a_of_type_Fja);
      }
      if (this.jdField_a_of_type_AndroidDatabaseDataSetObserver != null) {
        paramCursor.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      }
      this.jdField_a_of_type_Int = paramCursor.getColumnIndexOrThrow("_id");
      this.jdField_a_of_type_Boolean = true;
      notifyDataSetChanged();
      return localCursor;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    notifyDataSetInvalidated();
    return localCursor;
  }
  
  public Cursor a(Cursor paramCursor, int paramInt)
  {
    if (paramCursor == this.jdField_a_of_type_AndroidDatabaseCursor) {
      return null;
    }
    Cursor localCursor = this.jdField_a_of_type_AndroidDatabaseCursor;
    if (localCursor != null)
    {
      if (this.jdField_a_of_type_Fja != null) {
        localCursor.unregisterContentObserver(this.jdField_a_of_type_Fja);
      }
      if (this.jdField_a_of_type_AndroidDatabaseDataSetObserver != null) {
        localCursor.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      }
    }
    this.jdField_a_of_type_AndroidDatabaseCursor = paramCursor;
    if (paramCursor != null)
    {
      if (this.jdField_a_of_type_Fja != null) {
        paramCursor.registerContentObserver(this.jdField_a_of_type_Fja);
      }
      if (this.jdField_a_of_type_AndroidDatabaseDataSetObserver != null) {
        paramCursor.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      }
      this.jdField_a_of_type_Int = paramCursor.getColumnIndexOrThrow("_id");
      this.jdField_a_of_type_Boolean = true;
      if (paramInt > 0) {
        a(0, paramInt - 1);
      }
      notifyDataSetChanged();
      return localCursor;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    notifyDataSetInvalidated();
    return localCursor;
  }
  
  public Cursor a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_AndroidWidgetFilterQueryProvider != null) {
      return this.jdField_a_of_type_AndroidWidgetFilterQueryProvider.runQuery(paramCharSequence);
    }
    return this.jdField_a_of_type_AndroidDatabaseCursor;
  }
  
  public abstract View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  public FilterQueryProvider a()
  {
    return this.jdField_a_of_type_AndroidWidgetFilterQueryProvider;
  }
  
  public CharSequence a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return "";
    }
    return paramCursor.toString();
  }
  
  public void a()
  {
    if ((this.b) && (this.jdField_a_of_type_AndroidDatabaseCursor != null) && (!this.jdField_a_of_type_AndroidDatabaseCursor.isClosed())) {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidDatabaseCursor.requery();
    }
  }
  
  void a(Context paramContext, Cursor paramCursor, int paramInt)
  {
    boolean bool = true;
    label23:
    int i;
    if ((paramInt & 0x1) == 1)
    {
      paramInt |= 0x2;
      this.b = true;
      if (paramCursor == null) {
        break label140;
      }
      this.jdField_a_of_type_AndroidDatabaseCursor = paramCursor;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      if (!bool) {
        break label146;
      }
      i = paramCursor.getColumnIndexOrThrow("_id");
      label54:
      this.jdField_a_of_type_Int = i;
      if ((paramInt & 0x2) != 2) {
        break label152;
      }
      this.jdField_a_of_type_Fja = new fja(this);
    }
    for (this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new fjb(this, null);; this.jdField_a_of_type_AndroidDatabaseDataSetObserver = null)
    {
      if (bool)
      {
        if (this.jdField_a_of_type_Fja != null) {
          paramCursor.registerContentObserver(this.jdField_a_of_type_Fja);
        }
        if (this.jdField_a_of_type_AndroidDatabaseDataSetObserver != null) {
          paramCursor.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
        }
      }
      return;
      this.b = false;
      break;
      label140:
      bool = false;
      break label23;
      label146:
      i = -1;
      break label54;
      label152:
      this.jdField_a_of_type_Fja = null;
    }
  }
  
  @Deprecated
  protected void a(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      a(paramContext, paramCursor, i);
      return;
    }
  }
  
  public void a(Cursor paramCursor)
  {
    paramCursor = a(paramCursor);
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public abstract void a(View paramView, Context paramContext, Cursor paramCursor);
  
  public void a(FilterQueryProvider paramFilterQueryProvider)
  {
    this.jdField_a_of_type_AndroidWidgetFilterQueryProvider = paramFilterQueryProvider;
  }
  
  public View b(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return a(paramContext, paramCursor, paramViewGroup);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidDatabaseCursor != null)) {
      return this.jdField_a_of_type_AndroidDatabaseCursor.getCount();
    }
    return 0;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidDatabaseCursor.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidDatabaseCursor, paramViewGroup);
      }
      a(localView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidDatabaseCursor);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.jdField_a_of_type_Fhu == null) {
      this.jdField_a_of_type_Fhu = new fhu(this);
    }
    return this.jdField_a_of_type_Fhu;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidDatabaseCursor != null))
    {
      this.jdField_a_of_type_AndroidDatabaseCursor.moveToPosition(paramInt);
      return this.jdField_a_of_type_AndroidDatabaseCursor;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_Boolean)
    {
      l1 = l2;
      if (this.jdField_a_of_type_AndroidDatabaseCursor != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_AndroidDatabaseCursor.moveToPosition(paramInt)) {
          l1 = this.jdField_a_of_type_AndroidDatabaseCursor.getLong(this.jdField_a_of_type_Int);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.jdField_a_of_type_AndroidDatabaseCursor.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position " + paramInt);
    }
    View localView = paramView;
    if (paramView == null) {
      localView = a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidDatabaseCursor, paramViewGroup);
    }
    a(localView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidDatabaseCursor);
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.XCursorAdapter
 * JD-Core Version:    0.7.0.1
 */