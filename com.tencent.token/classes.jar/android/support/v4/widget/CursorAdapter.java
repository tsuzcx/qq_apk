package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.annotation.RestrictTo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter
  extends BaseAdapter
  implements CursorFilter.CursorFilterClient, Filterable
{
  @Deprecated
  public static final int FLAG_AUTO_REQUERY = 1;
  public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected boolean mAutoRequery;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected CursorAdapter.ChangeObserver mChangeObserver;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected Context mContext;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected Cursor mCursor;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected CursorFilter mCursorFilter;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected DataSetObserver mDataSetObserver;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected boolean mDataValid;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected FilterQueryProvider mFilterQueryProvider;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected int mRowIDColumn;
  
  @Deprecated
  public CursorAdapter(Context paramContext, Cursor paramCursor)
  {
    init(paramContext, paramCursor, 1);
  }
  
  public CursorAdapter(Context paramContext, Cursor paramCursor, int paramInt)
  {
    init(paramContext, paramCursor, paramInt);
  }
  
  public CursorAdapter(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      init(paramContext, paramCursor, i);
      return;
    }
  }
  
  public abstract void bindView(View paramView, Context paramContext, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    paramCursor = swapCursor(paramCursor);
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return "";
    }
    return paramCursor.toString();
  }
  
  public int getCount()
  {
    if ((this.mDataValid) && (this.mCursor != null)) {
      return this.mCursor.getCount();
    }
    return 0;
  }
  
  public Cursor getCursor()
  {
    return this.mCursor;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mDataValid)
    {
      this.mCursor.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = newDropDownView(this.mContext, this.mCursor, paramViewGroup);
      }
      bindView(localView, this.mContext, this.mCursor);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.mCursorFilter == null) {
      this.mCursorFilter = new CursorFilter(this);
    }
    return this.mCursorFilter;
  }
  
  public FilterQueryProvider getFilterQueryProvider()
  {
    return this.mFilterQueryProvider;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.mDataValid) && (this.mCursor != null))
    {
      this.mCursor.moveToPosition(paramInt);
      return this.mCursor;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.mDataValid)
    {
      l1 = l2;
      if (this.mCursor != null)
      {
        l1 = l2;
        if (this.mCursor.moveToPosition(paramInt)) {
          l1 = this.mCursor.getLong(this.mRowIDColumn);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.mDataValid) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.mCursor.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position " + paramInt);
    }
    View localView = paramView;
    if (paramView == null) {
      localView = newView(this.mContext, this.mCursor, paramViewGroup);
    }
    bindView(localView, this.mContext, this.mCursor);
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  void init(Context paramContext, Cursor paramCursor, int paramInt)
  {
    boolean bool = true;
    label23:
    int i;
    if ((paramInt & 0x1) == 1)
    {
      paramInt |= 0x2;
      this.mAutoRequery = true;
      if (paramCursor == null) {
        break label139;
      }
      this.mCursor = paramCursor;
      this.mDataValid = bool;
      this.mContext = paramContext;
      if (!bool) {
        break label145;
      }
      i = paramCursor.getColumnIndexOrThrow("_id");
      label54:
      this.mRowIDColumn = i;
      if ((paramInt & 0x2) != 2) {
        break label151;
      }
      this.mChangeObserver = new CursorAdapter.ChangeObserver(this);
    }
    for (this.mDataSetObserver = new CursorAdapter.MyDataSetObserver(this);; this.mDataSetObserver = null)
    {
      if (bool)
      {
        if (this.mChangeObserver != null) {
          paramCursor.registerContentObserver(this.mChangeObserver);
        }
        if (this.mDataSetObserver != null) {
          paramCursor.registerDataSetObserver(this.mDataSetObserver);
        }
      }
      return;
      this.mAutoRequery = false;
      break;
      label139:
      bool = false;
      break label23;
      label145:
      i = -1;
      break label54;
      label151:
      this.mChangeObserver = null;
    }
  }
  
  @Deprecated
  protected void init(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      init(paramContext, paramCursor, i);
      return;
    }
  }
  
  public View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return newView(paramContext, paramCursor, paramViewGroup);
  }
  
  public abstract View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  protected void onContentChanged()
  {
    if ((this.mAutoRequery) && (this.mCursor != null) && (!this.mCursor.isClosed())) {
      this.mDataValid = this.mCursor.requery();
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (this.mFilterQueryProvider != null) {
      return this.mFilterQueryProvider.runQuery(paramCharSequence);
    }
    return this.mCursor;
  }
  
  public void setFilterQueryProvider(FilterQueryProvider paramFilterQueryProvider)
  {
    this.mFilterQueryProvider = paramFilterQueryProvider;
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    if (paramCursor == this.mCursor) {
      return null;
    }
    Cursor localCursor = this.mCursor;
    if (localCursor != null)
    {
      if (this.mChangeObserver != null) {
        localCursor.unregisterContentObserver(this.mChangeObserver);
      }
      if (this.mDataSetObserver != null) {
        localCursor.unregisterDataSetObserver(this.mDataSetObserver);
      }
    }
    this.mCursor = paramCursor;
    if (paramCursor != null)
    {
      if (this.mChangeObserver != null) {
        paramCursor.registerContentObserver(this.mChangeObserver);
      }
      if (this.mDataSetObserver != null) {
        paramCursor.registerDataSetObserver(this.mDataSetObserver);
      }
      this.mRowIDColumn = paramCursor.getColumnIndexOrThrow("_id");
      this.mDataValid = true;
      notifyDataSetChanged();
      return localCursor;
    }
    this.mRowIDColumn = -1;
    this.mDataValid = false;
    notifyDataSetInvalidated();
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.CursorAdapter
 * JD-Core Version:    0.7.0.1
 */