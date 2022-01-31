package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import emc;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private emc jdField_a_of_type_Emc;
  
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
    emc localemc = this.jdField_a_of_type_Emc;
    if (localemc == null) {}
    while (!localemc.jdField_a_of_type_Boolean) {
      return;
    }
    emc.a(localemc).setTranslate(localemc.jdField_a_of_type_Float, localemc.b);
    localemc.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    emc localemc = this.jdField_a_of_type_Emc;
    if (localemc != null)
    {
      a();
      paramCanvas.concat(emc.a(localemc));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Emc == null) {
      this.jdField_a_of_type_Emc = new emc();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Emc != null) {
      return this.jdField_a_of_type_Emc.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Emc != null) {
      return this.jdField_a_of_type_Emc.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    emc localemc = this.jdField_a_of_type_Emc;
    if (localemc.jdField_a_of_type_Float != paramFloat)
    {
      localemc.jdField_a_of_type_Float = paramFloat;
      localemc.jdField_a_of_type_Boolean = true;
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
    emc localemc = this.jdField_a_of_type_Emc;
    if (localemc.b != paramFloat)
    {
      localemc.b = paramFloat;
      localemc.jdField_a_of_type_Boolean = true;
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