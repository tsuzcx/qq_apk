package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.RestrictTo;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter
  extends ResourceCursorAdapter
{
  private CursorToStringConverter mCursorToStringConverter;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected int[] mFrom;
  String[] mOriginalFrom;
  private int mStringConversionColumn = -1;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected int[] mTo;
  private ViewBinder mViewBinder;
  
  @Deprecated
  public SimpleCursorAdapter(Context paramContext, int paramInt, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramContext, paramInt, paramCursor);
    this.mTo = paramArrayOfInt;
    this.mOriginalFrom = paramArrayOfString;
    findColumns(paramCursor, paramArrayOfString);
  }
  
  public SimpleCursorAdapter(Context paramContext, int paramInt1, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2)
  {
    super(paramContext, paramInt1, paramCursor, paramInt2);
    this.mTo = paramArrayOfInt;
    this.mOriginalFrom = paramArrayOfString;
    findColumns(paramCursor, paramArrayOfString);
  }
  
  private void findColumns(Cursor paramCursor, String[] paramArrayOfString)
  {
    if (paramCursor != null)
    {
      int j = paramArrayOfString.length;
      int[] arrayOfInt = this.mFrom;
      if ((arrayOfInt == null) || (arrayOfInt.length != j)) {
        this.mFrom = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        this.mFrom[i] = paramCursor.getColumnIndexOrThrow(paramArrayOfString[i]);
        i += 1;
      }
    }
    this.mFrom = null;
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ViewBinder localViewBinder = this.mViewBinder;
    int[] arrayOfInt1 = this.mTo;
    int j = arrayOfInt1.length;
    int[] arrayOfInt2 = this.mFrom;
    int i = 0;
    while (i < j)
    {
      View localView = paramView.findViewById(arrayOfInt1[i]);
      if (localView != null)
      {
        boolean bool;
        if (localViewBinder != null) {
          bool = localViewBinder.setViewValue(localView, paramCursor, arrayOfInt2[i]);
        } else {
          bool = false;
        }
        if (!bool)
        {
          String str = paramCursor.getString(arrayOfInt2[i]);
          paramContext = str;
          if (str == null) {
            paramContext = "";
          }
          if ((localView instanceof TextView))
          {
            setViewText((TextView)localView, paramContext);
          }
          else if ((localView instanceof ImageView))
          {
            setViewImage((ImageView)localView, paramContext);
          }
          else
          {
            paramView = new StringBuilder();
            paramView.append(localView.getClass().getName());
            paramView.append(" is not a ");
            paramView.append(" view that can be bounds by this SimpleCursorAdapter");
            throw new IllegalStateException(paramView.toString());
          }
        }
      }
      i += 1;
    }
  }
  
  public void changeCursorAndColumns(Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mOriginalFrom = paramArrayOfString;
    this.mTo = paramArrayOfInt;
    findColumns(paramCursor, this.mOriginalFrom);
    super.changeCursor(paramCursor);
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    CursorToStringConverter localCursorToStringConverter = this.mCursorToStringConverter;
    if (localCursorToStringConverter != null) {
      return localCursorToStringConverter.convertToString(paramCursor);
    }
    int i = this.mStringConversionColumn;
    if (i > -1) {
      return paramCursor.getString(i);
    }
    return super.convertToString(paramCursor);
  }
  
  public CursorToStringConverter getCursorToStringConverter()
  {
    return this.mCursorToStringConverter;
  }
  
  public int getStringConversionColumn()
  {
    return this.mStringConversionColumn;
  }
  
  public ViewBinder getViewBinder()
  {
    return this.mViewBinder;
  }
  
  public void setCursorToStringConverter(CursorToStringConverter paramCursorToStringConverter)
  {
    this.mCursorToStringConverter = paramCursorToStringConverter;
  }
  
  public void setStringConversionColumn(int paramInt)
  {
    this.mStringConversionColumn = paramInt;
  }
  
  public void setViewBinder(ViewBinder paramViewBinder)
  {
    this.mViewBinder = paramViewBinder;
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    try
    {
      paramImageView.setImageResource(Integer.parseInt(paramString));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label9:
      break label9;
    }
    paramImageView.setImageURI(Uri.parse(paramString));
  }
  
  public void setViewText(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    findColumns(paramCursor, this.mOriginalFrom);
    return super.swapCursor(paramCursor);
  }
  
  public static abstract interface CursorToStringConverter
  {
    public abstract CharSequence convertToString(Cursor paramCursor);
  }
  
  public static abstract interface ViewBinder
  {
    public abstract boolean setViewValue(View paramView, Cursor paramCursor, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SimpleCursorAdapter
 * JD-Core Version:    0.7.0.1
 */