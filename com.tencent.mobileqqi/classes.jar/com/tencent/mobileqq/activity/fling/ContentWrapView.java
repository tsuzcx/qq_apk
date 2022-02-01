package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import egy;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private egy jdField_a_of_type_Egy;
  
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
    egy localegy = this.jdField_a_of_type_Egy;
    if (localegy == null) {}
    while (!localegy.jdField_a_of_type_Boolean) {
      return;
    }
    egy.a(localegy).setTranslate(localegy.jdField_a_of_type_Float, localegy.b);
    localegy.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    egy localegy = this.jdField_a_of_type_Egy;
    if (localegy != null)
    {
      a();
      paramCanvas.concat(egy.a(localegy));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Egy == null) {
      this.jdField_a_of_type_Egy = new egy();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Egy != null) {
      return this.jdField_a_of_type_Egy.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Egy != null) {
      return this.jdField_a_of_type_Egy.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    egy localegy = this.jdField_a_of_type_Egy;
    if (localegy.jdField_a_of_type_Float != paramFloat)
    {
      localegy.jdField_a_of_type_Float = paramFloat;
      localegy.jdField_a_of_type_Boolean = true;
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
    egy localegy = this.jdField_a_of_type_Egy;
    if (localegy.b != paramFloat)
    {
      localegy.b = paramFloat;
      localegy.jdField_a_of_type_Boolean = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ContentWrapView
 * JD-Core Version:    0.7.0.1
 */