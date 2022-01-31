package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import egz;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private egz jdField_a_of_type_Egz;
  
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
    egz localegz = this.jdField_a_of_type_Egz;
    if (localegz == null) {}
    while (!localegz.jdField_a_of_type_Boolean) {
      return;
    }
    egz.a(localegz).setTranslate(localegz.jdField_a_of_type_Float, localegz.b);
    localegz.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    egz localegz = this.jdField_a_of_type_Egz;
    if (localegz != null)
    {
      a();
      paramCanvas.concat(egz.a(localegz));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Egz == null) {
      this.jdField_a_of_type_Egz = new egz();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Egz != null) {
      return this.jdField_a_of_type_Egz.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Egz != null) {
      return this.jdField_a_of_type_Egz.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    egz localegz = this.jdField_a_of_type_Egz;
    if (localegz.jdField_a_of_type_Float != paramFloat)
    {
      localegz.jdField_a_of_type_Float = paramFloat;
      localegz.jdField_a_of_type_Boolean = true;
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
    egz localegz = this.jdField_a_of_type_Egz;
    if (localegz.b != paramFloat)
    {
      localegz.b = paramFloat;
      localegz.jdField_a_of_type_Boolean = true;
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