package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import alza;
import alzd;
import alzg;
import alzj;
import alzk;
import alzr;
import alzs;
import alzt;
import alzv;
import amab;
import amae;
import amah.a;
import amal;
import amas;
import amax;
import amba;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class Mp4FlowReEncoder
  implements alzd, alzk, alzt, amal
{
  private Comparator<alzg> S = new alzv(this);
  private alza jdField_a_of_type_Alza;
  private alzs jdField_a_of_type_Alzs = new alzs();
  private amab jdField_a_of_type_Amab = new amab();
  private amae jdField_a_of_type_Amae;
  private amah.a jdField_a_of_type_Amah$a;
  private amal jdField_a_of_type_Amal;
  private amba jdField_a_of_type_Amba;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private long aii = 9223372036854775807L;
  private AtomicInteger bG = new AtomicInteger(0);
  private boolean canceled;
  private RenderBuffer mRenderFBO;
  private int mWatermarkHeight;
  private int mWatermarkTextureIdForEncode = -1;
  private int mWatermarkWidth;
  
  private void dLM()
  {
    if (this.jdField_a_of_type_Amba != null) {
      this.jdField_a_of_type_Amba.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
  }
  
  private void lX(List<alzg> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((alzg)paramList.get(0)).gH() + " - " + ((alzg)paramList.get(paramList.size() - 1)).gH() + "]");
      Collections.sort(paramList, this.S);
      if (this.aii == 9223372036854775807L)
      {
        this.aii = ((alzg)paramList.get(0)).gH();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.aii);
      }
      int i = 0;
      while (i < paramList.size())
      {
        alzg localalzg = (alzg)paramList.get(i);
        RenderBuffer localRenderBuffer = this.mRenderFBO;
        this.mRenderFBO.bind();
        int k = localalzg.getTextureId();
        int j = k;
        if (this.jdField_a_of_type_Amba != null)
        {
          this.mRenderFBO.unbind();
          this.jdField_a_of_type_Amba.drawTexture(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_Amba.a();
          localRenderBuffer.bind();
          j = localRenderBuffer.getTexId();
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Amae.width, this.jdField_a_of_type_Amae.height, this.mWatermarkWidth, this.mWatermarkHeight);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.mWatermarkTextureIdForEncode, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Amah$a != null) {
          this.jdField_a_of_type_Amah$a.onRenderFrame();
        }
        localRenderBuffer.unbind();
        long l = (localalzg.gH() - this.aii) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_Alzs.g(3553, j, localalzg.dq, null, l);
        this.bG.decrementAndGet();
        localalzg.recycle();
        i += 1;
      }
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Amab.stopDecode();
    if (this.jdField_a_of_type_Amal != null) {
      this.jdField_a_of_type_Amal.a(paramInt, paramThrowable);
    }
  }
  
  public void a(alza paramalza, amae paramamae, amal paramamal, amah.a parama)
  {
    this.jdField_a_of_type_Alza = paramalza;
    this.jdField_a_of_type_Amae = paramamae;
    this.jdField_a_of_type_Amal = paramamal;
    this.jdField_a_of_type_Amah$a = parama;
    this.jdField_a_of_type_Alzs.a(paramamae, this);
    this.canceled = false;
  }
  
  public void auv()
  {
    try
    {
      this.mRenderFBO = new RenderBuffer(this.jdField_a_of_type_Amae.width, this.jdField_a_of_type_Amae.height, 33984);
      if ((amas.lb(this.jdField_a_of_type_Amae.filterType)) || (this.jdField_a_of_type_Amae.mosaicPath != null))
      {
        this.jdField_a_of_type_Amba = new amba();
        if (amas.lb(this.jdField_a_of_type_Amae.filterType)) {
          this.jdField_a_of_type_Amba.a(amas.a(this.jdField_a_of_type_Amae.filterType));
        }
        if (this.jdField_a_of_type_Amae.mosaicPath != null)
        {
          localObject = amas.a(106);
          ((amax)localObject).Pv(this.jdField_a_of_type_Amae.mosaicPath);
          this.jdField_a_of_type_Amba.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_Amba.onOutputSizeChanged(this.jdField_a_of_type_Amae.width, this.jdField_a_of_type_Amae.height);
        this.jdField_a_of_type_Amba.init();
      }
      Object localObject = this.jdField_a_of_type_Amae.watermarkPath;
      if (localObject != null) {}
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_Amae.watermarkPath);
        this.mWatermarkTextureIdForEncode = alzr.createTexture(3553, (Bitmap)localObject);
        this.mWatermarkWidth = ((Bitmap)localObject).getWidth();
        this.mWatermarkHeight = ((Bitmap)localObject).getHeight();
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = amas.a(101);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_Amae.width, this.jdField_a_of_type_Amae.height);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
        localObject = new alzj(this.jdField_a_of_type_Alza);
        ((alzj)localObject).repeat = false;
        ((alzj)localObject).a = EGL14.eglGetCurrentContext();
        ((alzj)localObject).decodeType = 2;
        this.jdField_a_of_type_Amab.a((alzj)localObject, this, this);
        if (this.jdField_a_of_type_Amal != null)
        {
          this.jdField_a_of_type_Amal.auv();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_Amae.watermarkPath, localOutOfMemoryError);
        }
        a(1, localOutOfMemoryError);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      a(4, localException);
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onEncodeStart ex=" + localException);
    }
  }
  
  public void btD()
  {
    if (this.jdField_a_of_type_Amal != null) {
      this.jdField_a_of_type_Amal.btD();
    }
  }
  
  public void dLJ() {}
  
  public void dLK() {}
  
  public void fp(long paramLong)
    throws InterruptedException
  {}
  
  public int getFrameCount()
  {
    return this.bG.get();
  }
  
  public void kf(String paramString)
  {
    if (this.jdField_a_of_type_Amal != null) {
      this.jdField_a_of_type_Amal.kf(paramString);
    }
    if (this.mWatermarkTextureIdForEncode != -1)
    {
      alzr.deleteTexture(this.mWatermarkTextureIdForEncode);
      this.mWatermarkTextureIdForEncode = -1;
    }
    dLM();
    this.mRenderFBO.destroy();
    alzg.releaseAll();
  }
  
  public void onDecodeCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Alzs.stopRecording();
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    a(paramInt + 10000, paramThrowable);
  }
  
  public void onDecodeFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_a_of_type_Alzs.stopRecording();
  }
  
  public void onDecodeRepeat() {}
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeStart");
    }
  }
  
  public int y(List<alzg> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((alzg)paramList.get(0)).gH() + " - " + ((alzg)paramList.get(paramList.size() - 1)).gH() + "]");
    this.bG.addAndGet(paramList.size());
    this.jdField_a_of_type_Alzs.ag(new HandleFrameListRunable(paramList));
    return paramList.size();
  }
  
  class HandleFrameListRunable
    implements Runnable
  {
    private List<alzg> Fw = new ArrayList();
    
    public HandleFrameListRunable()
    {
      Collection localCollection;
      this.Fw.addAll(localCollection);
    }
    
    public void run()
    {
      Mp4FlowReEncoder.a(Mp4FlowReEncoder.this, this.Fw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder
 * JD-Core Version:    0.7.0.1
 */