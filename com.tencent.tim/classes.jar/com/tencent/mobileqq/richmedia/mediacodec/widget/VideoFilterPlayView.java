package com.tencent.mobileqq.richmedia.mediacodec.widget;

import alza;
import amas;
import amax;
import ambb;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class VideoFilterPlayView
  extends HWVideoPlayView
{
  public static int bmZ;
  private ambb a;
  private GPUBaseFilter d;
  private GPUBaseFilter e;
  private GPUBaseFilter f;
  private RenderBuffer h;
  private RenderBuffer i;
  protected final LinkedList<Runnable> mRunOnDraw = new LinkedList();
  public int mSeq;
  
  public VideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initFilter();
    int j = bmZ + 1;
    bmZ = j;
    this.mSeq = j;
  }
  
  private void initFilter()
  {
    this.a = new ambb();
    GPUBaseFilter localGPUBaseFilter = amas.a(101);
    this.e = localGPUBaseFilter;
    this.jdField_d_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = localGPUBaseFilter;
    runOnDraw(new VideoFilterPlayView.1(this));
  }
  
  protected void c(@NonNull LinkedList<Runnable> paramLinkedList)
  {
    try
    {
      while (!paramLinkedList.isEmpty())
      {
        Runnable localRunnable = (Runnable)paramLinkedList.poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    finally {}
  }
  
  protected void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.a.dMa();
    int j = paramInt;
    if (this.a.ave())
    {
      this.i.bind();
      this.a.drawTexture(paramInt, null, null);
      this.i.unbind();
      j = this.i.getTexId();
    }
    this.jdField_d_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(j, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void fp(long paramLong)
    throws InterruptedException
  {
    super.fp(paramLong);
  }
  
  protected void g(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    c(this.mRunOnDraw);
    this.h.bind();
    super.g(null, null);
    this.h.unbind();
    drawTexture(this.h.getTexId(), paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void onDecodeRepeat()
  {
    QLog.w("VideoFilterPlayView", 4, "onDecodeRepeat. can't just repeat");
    super.onDecodeRepeat();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    this.h = new RenderBuffer(paramInt1, paramInt2, 33984);
    this.i = new RenderBuffer(paramInt1, paramInt2, 33984);
    this.a.onOutputSizeChanged(paramInt1, paramInt2);
    this.jdField_d_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.jdField_d_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = amas.a(101);
    this.jdField_d_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    this.h.destroy();
    this.i.destroy();
  }
  
  protected void runOnDraw(@NonNull Runnable paramRunnable)
  {
    synchronized (this.mRunOnDraw)
    {
      this.mRunOnDraw.add(paramRunnable);
      return;
    }
  }
  
  public void setColorFilterType(int paramInt)
  {
    if ((!this.a.ave()) && (paramInt == 0)) {
      return;
    }
    this.a.aY(paramInt, this.surfaceWidth, this.surfaceHeight);
  }
  
  public void setColorFilterType(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.a.a(paramInt1, paramInt2, paramFloat, paramInt3, this.surfaceWidth, this.surfaceHeight);
  }
  
  public void setMosaicFilterType(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.jdField_d_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = this.e;
      return;
    }
    if (this.f == null)
    {
      this.f = amas.a(106);
      runOnDraw(new VideoFilterPlayView.2(this));
    }
    ((amax)this.f).i(paramBitmap, this.jdField_d_of_type_Alza.adjustRotation);
    this.jdField_d_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */