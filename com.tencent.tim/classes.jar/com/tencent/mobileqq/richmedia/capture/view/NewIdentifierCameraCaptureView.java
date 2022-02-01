package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import ankt;

public class NewIdentifierCameraCaptureView
  extends IdentifierCameraCaptureView
{
  private float mAspectRatio = 0.75F;
  private float sF = 0.55F;
  
  public NewIdentifierCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public NewIdentifierCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = ankt.aD(getContext());
    paramInt2 = (int)(paramInt1 / this.mAspectRatio);
    setMeasuredDimension((int)(paramInt1 * this.sF), (int)(paramInt2 * this.sF));
  }
  
  public void setAspectRatio(float paramFloat)
  {
    this.mAspectRatio = paramFloat;
    requestLayout();
  }
  
  public void setSurfaceScale(float paramFloat)
  {
    this.sF = paramFloat;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.NewIdentifierCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */