package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private a a;
  private Matrix mMatrix = new Matrix();
  
  public ContentWrapView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void aoo()
  {
    a locala = this.a;
    if (locala == null) {}
    while (!locala.mMatrixDirty) {
      return;
    }
    a.a(locala).setTranslate(locala.mTranslationX, locala.mTranslationY);
    locala.mMatrixDirty = false;
  }
  
  private void init(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    a locala = this.a;
    if (locala != null)
    {
      aoo();
      paramCanvas.concat(a.a(locala));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.a == null) {
      this.a = new a();
    }
  }
  
  public float getTransX()
  {
    if (this.a != null) {
      return this.a.mTranslationX;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.a != null) {
      return this.a.mTranslationY;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    a locala = this.a;
    if (locala.mTranslationX != paramFloat)
    {
      locala.mTranslationX = paramFloat;
      locala.mMatrixDirty = true;
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
    a locala = this.a;
    if (locala.mTranslationY != paramFloat)
    {
      locala.mTranslationY = paramFloat;
      locala.mMatrixDirty = true;
      invalidate();
    }
  }
  
  public void transYBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(getTransX() + paramFloat);
    }
  }
  
  static class a
  {
    private final Matrix mMatrix = new Matrix();
    boolean mMatrixDirty = false;
    float mTranslationX = 0.0F;
    float mTranslationY = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ContentWrapView
 * JD-Core Version:    0.7.0.1
 */