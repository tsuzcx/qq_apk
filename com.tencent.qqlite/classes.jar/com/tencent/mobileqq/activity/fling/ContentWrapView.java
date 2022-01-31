package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import cfm;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private cfm jdField_a_of_type_Cfm;
  
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
    cfm localcfm = this.jdField_a_of_type_Cfm;
    if (localcfm == null) {}
    while (!localcfm.jdField_a_of_type_Boolean) {
      return;
    }
    cfm.a(localcfm).setTranslate(localcfm.jdField_a_of_type_Float, localcfm.b);
    localcfm.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    cfm localcfm = this.jdField_a_of_type_Cfm;
    if (localcfm != null)
    {
      a();
      paramCanvas.concat(cfm.a(localcfm));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Cfm == null) {
      this.jdField_a_of_type_Cfm = new cfm();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Cfm != null) {
      return this.jdField_a_of_type_Cfm.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Cfm != null) {
      return this.jdField_a_of_type_Cfm.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    cfm localcfm = this.jdField_a_of_type_Cfm;
    if (localcfm.jdField_a_of_type_Float != paramFloat)
    {
      localcfm.jdField_a_of_type_Float = paramFloat;
      localcfm.jdField_a_of_type_Boolean = true;
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
    cfm localcfm = this.jdField_a_of_type_Cfm;
    if (localcfm.b != paramFloat)
    {
      localcfm.b = paramFloat;
      localcfm.jdField_a_of_type_Boolean = true;
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