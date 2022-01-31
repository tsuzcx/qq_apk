package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import cef;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private cef jdField_a_of_type_Cef;
  
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
    cef localcef = this.jdField_a_of_type_Cef;
    if (localcef == null) {}
    while (!localcef.jdField_a_of_type_Boolean) {
      return;
    }
    cef.a(localcef).setTranslate(localcef.jdField_a_of_type_Float, localcef.b);
    localcef.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    cef localcef = this.jdField_a_of_type_Cef;
    if (localcef != null)
    {
      a();
      paramCanvas.concat(cef.a(localcef));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Cef == null) {
      this.jdField_a_of_type_Cef = new cef();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Cef != null) {
      return this.jdField_a_of_type_Cef.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Cef != null) {
      return this.jdField_a_of_type_Cef.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    cef localcef = this.jdField_a_of_type_Cef;
    if (localcef.jdField_a_of_type_Float != paramFloat)
    {
      localcef.jdField_a_of_type_Float = paramFloat;
      localcef.jdField_a_of_type_Boolean = true;
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
    cef localcef = this.jdField_a_of_type_Cef;
    if (localcef.b != paramFloat)
    {
      localcef.b = paramFloat;
      localcef.jdField_a_of_type_Boolean = true;
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