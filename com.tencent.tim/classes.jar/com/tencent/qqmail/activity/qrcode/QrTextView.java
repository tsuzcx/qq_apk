package com.tencent.qqmail.activity.qrcode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class QrTextView
  extends TextView
{
  private static final String TAG = "QrTextView";
  private Method mHideCursorMethod;
  private Object mSelectionCursor;
  private Method mShowCursorMethod;
  
  public QrTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QrTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QrTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @SuppressLint({"NewApi"})
  public QrTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void getCursorShowAndHideMethod()
  {
    try
    {
      Object localObject = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject).setAccessible(true);
      Class localClass = Class.forName("android.widget.Editor");
      localObject = localClass.cast(((Field)localObject).get(this));
      Method localMethod = localClass.getDeclaredMethod("getSelectionController", new Class[0]);
      localMethod.setAccessible(true);
      localClass = Class.forName("android.widget.Editor$SelectionModifierCursorController");
      this.mSelectionCursor = localClass.cast(localMethod.invoke(localObject, new Object[0]));
      localObject = localClass.getDeclaredMethod("show", new Class[0]);
      ((Method)localObject).setAccessible(true);
      this.mShowCursorMethod = ((Method)localObject);
      this.mHideCursorMethod = localClass.getDeclaredMethod("hide", new Class[0]);
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "QrTextView", "get editor error", localException);
    }
  }
  
  public void hideCuror()
  {
    try
    {
      this.mHideCursorMethod.invoke(this.mSelectionCursor, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "QrTextView", "hide error", localException);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getCursorShowAndHideMethod();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void showCursor()
  {
    try
    {
      this.mShowCursorMethod.invoke(this.mSelectionCursor, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "QrTextView", "show error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.qrcode.QrTextView
 * JD-Core Version:    0.7.0.1
 */