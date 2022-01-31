package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import esd;
import ese;

public class RedDotImageView
  extends ImageView
{
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private int jdField_a_of_type_Int = 13;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 13;
  
  public RedDotImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramString))) {
      ThreadManager.a().post(new esd(this, paramAppInterface, paramString));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839400);
      }
      postInvalidate();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(AppInterface paramAppInterface, String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      a(false);
      ThreadManager.a().post(new ese(this, paramAppInterface, paramString));
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
      int i = (int)Math.ceil(getWidth() * 0.5D + this.jdField_a_of_type_Float * this.jdField_a_of_type_Int - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() * 0.5D);
      int j = (int)Math.ceil(getHeight() * 0.5D - this.jdField_a_of_type_Float * this.b - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() * 0.5D);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, j, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + i, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + j);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  public void setRedDotDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
  }
  
  public void setReddotXOffsetDp(int paramInt)
  {
    if ((paramInt > 0) && (paramInt != this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Int = paramInt;
      postInvalidate();
    }
  }
  
  public void setReddotYOffsetDp(int paramInt)
  {
    if ((paramInt > 0) && (paramInt != this.b))
    {
      this.b = paramInt;
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotImageView
 * JD-Core Version:    0.7.0.1
 */