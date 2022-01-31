package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.qqlite.R.styleable;
import exl;
import exm;
import java.lang.reflect.Field;

public class ClearableEditText
  extends EditText
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private float a;
  public Drawable a;
  public ClearableEditText.OnTextClearedListener a;
  private int d;
  private int e;
  private int f = 0;
  
  public ClearableEditText(Context paramContext)
  {
    this(paramContext, null, 16842862);
  }
  
  public ClearableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }
  
  public ClearableEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.F);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(0);
    this.d = paramContext.getDimensionPixelSize(1, -1);
    this.e = paramContext.getDimensionPixelSize(2, -1);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837959);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if ((this.d == -1) || (this.e == -1))
      {
        this.d = ((int)(this.jdField_a_of_type_Float * 19.0F));
        this.e = ((int)(this.jdField_a_of_type_Float * 19.0F));
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.d, this.e);
      setClearButtonVisible(false);
    }
    setOnTouchListener(new exl(this));
    addTextChangedListener(new exm(this));
    paramContext.recycle();
  }
  
  private boolean a()
  {
    for (;;)
    {
      try
      {
        Object localObject = TextView.class.getDeclaredField("mSingleLine");
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(this);
        if ((localObject instanceof Boolean))
        {
          bool = ((Boolean)localObject).booleanValue();
          return bool;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
        return false;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return false;
      }
      boolean bool = false;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean)
    {
      setCursorVisible(false);
      setClearButtonVisible(false);
    }
    do
    {
      return;
      setCursorVisible(true);
    } while (getText().toString().length() == 0);
    setClearButtonVisible(true);
  }
  
  public void setClearButtonStyle(int paramInt)
  {
    this.f = paramInt;
    if (this.f == 1) {
      setClearButtonVisible(false);
    }
    while (this.f != 2) {
      return;
    }
    setClearButtonVisible(true);
  }
  
  public void setClearButtonVisible(boolean paramBoolean)
  {
    if (((paramBoolean) && (this.f == 1)) || ((!paramBoolean) && (this.f == 2))) {
      return;
    }
    if (paramBoolean) {}
    for (Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;; localDrawable = null)
    {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
      return;
    }
  }
  
  public void setTextClearedListener(ClearableEditText.OnTextClearedListener paramOnTextClearedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener = paramOnTextClearedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClearableEditText
 * JD-Core Version:    0.7.0.1
 */