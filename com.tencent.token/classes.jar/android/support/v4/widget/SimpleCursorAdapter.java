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
  private SimpleCursorAdapter.CursorToStringConverter mCursorToStringConverter;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected int[] mFrom;
  String[] mOriginalFrom;
  private int mStringConversionColumn = -1;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected int[] mTo;
  private SimpleCursorAdapter.ViewBinder mViewBinder;
  
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
      if ((this.mFrom == null) || (this.mFrom.length != j)) {
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
    SimpleCursorAdapter.ViewBinder localViewBinder = this.mViewBinder;
    int j = this.mTo.length;
    int[] arrayOfInt1 = this.mFrom;
    int[] arrayOfInt2 = this.mTo;
    int i = 0;
    View localView;
    if (i < j)
    {
      localView = paramView.findViewById(arrayOfInt2[i]);
      if (localView != null) {
        if (localViewBinder == null) {
          break label190;
        }
      }
    }
    label129:
    label150:
    label190:
    for (boolean bool = localViewBinder.setViewValue(localView, paramCursor, arrayOfInt1[i]);; bool = false)
    {
      if (!bool)
      {
        String str = paramCursor.getString(arrayOfInt1[i]);
        paramContext = str;
        if (str == null) {
          paramContext = "";
        }
        if (!(localView instanceof TextView)) {
          break label129;
        }
        setViewText((TextView)localView, paramContext);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!(localView instanceof ImageView)) {
          break label150;
        }
        setViewImage((ImageView)localView, paramContext);
      }
      throw new IllegalStateException(localView.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
      return;
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
    if (this.mCursorToStringConverter != null) {
      return this.mCursorToStringConverter.convertToString(paramCursor);
    }
    if (this.mStringConversionColumn > -1) {
      return paramCursor.getString(this.mStringConversionColumn);
    }
    return super.convertToString(paramCursor);
  }
  
  public SimpleCursorAdapter.CursorToStringConverter getCursorToStringConverter()
  {
    return this.mCursorToStringConverter;
  }
  
  public int getStringConversionColumn()
  {
    return this.mStringConversionColumn;
  }
  
  public SimpleCursorAdapter.ViewBinder getViewBinder()
  {
    return this.mViewBinder;
  }
  
  public void setCursorToStringConverter(SimpleCursorAdapter.CursorToStringConverter paramCursorToStringConverter)
  {
    this.mCursorToStringConverter = paramCursorToStringConverter;
  }
  
  public void setStringConversionColumn(int paramInt)
  {
    this.mStringConversionColumn = paramInt;
  }
  
  public void setViewBinder(SimpleCursorAdapter.ViewBinder paramViewBinder)
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
      paramImageView.setImageURI(Uri.parse(paramString));
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SimpleCursorAdapter
 * JD-Core Version:    0.7.0.1
 */