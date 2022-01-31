package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import cel;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private cel jdField_a_of_type_Cel;
  
  public ContentWrapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    cel localcel = this.jdField_a_of_type_Cel;
    if (localcel == null) {}
    while (!localcel.jdField_a_of_type_Boolean) {
      return;
    }
    cel.a(localcel).setTranslate(localcel.jdField_a_of_type_Float, localcel.b);
    localcel.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    cel localcel = this.jdField_a_of_type_Cel;
    if (localcel != null)
    {
      a();
      paramCanvas.concat(cel.a(localcel));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Cel == null) {
      this.jdField_a_of_type_Cel = new cel();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Cel != null) {
      return this.jdField_a_of_type_Cel.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Cel != null) {
      return this.jdField_a_of_type_Cel.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    cel localcel = this.jdField_a_of_type_Cel;
    if (localcel.jdField_a_of_type_Float != paramFloat)
    {
      localcel.jdField_a_of_type_Float = paramFloat;
      localcel.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void transXBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(getTransX() + paramFloat);
    }
  }
  
  public void transY(float paramFloat)
  {
    ensureTransformationInfo();
    cel localcel = this.jdField_a_of_type_Cel;
    if (localcel.b != paramFloat)
    {
      localcel.b = paramFloat;
      localcel.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void transYBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(getTransX() + paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ContentWrapView
 * JD-Core Version:    0.7.0.1
 */