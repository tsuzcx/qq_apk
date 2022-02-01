package com.tencent.biz.qqstory.takevideo2;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import javax.microedition.khronos.opengles.GL10;
import ram;

public class StoryEffectsCameraCaptureView
  extends EffectsCameraCaptureView
{
  private a a;
  
  public StoryEffectsCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryEffectsCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void c(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.cAt) && (this.dzg == 1)) {
      ram.d("zhiqiang", "frameToMediaCodec the last frame=" + paramLong);
    }
    super.c(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    super.onDrawFrame(paramGL10);
    paramGL10 = this.a;
    if (paramGL10 != null)
    {
      paramGL10.w(GlUtil.captureFrame(iU(this.dzh), this.dzc, this.dzd, 0));
      this.a = null;
    }
  }
  
  public void setCaptureRequest(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void w(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryEffectsCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */