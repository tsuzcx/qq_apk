import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.util.Locale;

public class iot
  extends ipb
  implements SurfaceTexture.OnFrameAvailableListener
{
  private float[] T;
  private boolean TG;
  private boolean TH = true;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private final iot.a jdField_a_of_type_Iot$a = new iot.a();
  private iot.b jdField_a_of_type_Iot$b;
  private ipg jdField_a_of_type_Ipg;
  private final itn jdField_a_of_type_Itn = new itn();
  private byte[] aP;
  private final int ark = 1;
  private final int arl = 2;
  private final int arm = 3;
  private int arn = 100;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private final itn jdField_b_of_type_Itn = new itn();
  private ByteBuffer c;
  private float gK = -1.0F;
  private float[] mMvpMatrix;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private int mTextureHeight;
  private int mTextureId;
  private TextureRender mTextureRender;
  private int mTextureWidth;
  private long mp;
  private long mq;
  private long mr;
  
  @RequiresApi(api=21)
  private void aoR()
  {
    this.mTextureId = GlUtil.createTexture(36197);
    GLES20.glBindTexture(36197, 0);
    this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
    this.mSurfaceTexture.setOnFrameAvailableListener(this, getHandler());
    this.mSurfaceTexture.setDefaultBufferSize(this.mTextureWidth, this.mTextureHeight);
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.mTextureRender = new TextureRender();
    this.TG = true;
    this.mq = 0L;
    this.mp = 0L;
    this.mr = 0L;
    this.jdField_a_of_type_Iot$a.reset();
    if (QLog.isColorLevel()) {
      QLog.i("EGLScreenCaptureThread", 2, "initGLEnv");
    }
  }
  
  private void aoS()
  {
    this.TG = false;
    this.mHandler.removeMessages(3);
    if (this.mTextureRender != null)
    {
      this.mTextureRender.release();
      this.mTextureRender = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
    {
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    if (this.jdField_a_of_type_Ipg != null)
    {
      this.jdField_a_of_type_Ipg.destroy();
      this.jdField_a_of_type_Ipg = null;
    }
    this.jdField_a_of_type_Iot$a.print();
    this.mq = 0L;
    this.mp = 0L;
    this.mr = 0L;
    if (QLog.isColorLevel()) {
      QLog.i("EGLScreenCaptureThread", 2, "releaseGLEnv");
    }
  }
  
  private void aoT()
  {
    boolean bool = this.jdField_a_of_type_Itn.a(this.jdField_b_of_type_Itn);
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || (bool))
    {
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      }
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Itn.width, this.jdField_a_of_type_Itn.height, 33984);
    }
    if (this.TH)
    {
      if ((this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || (bool))
      {
        if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
          this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
        }
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Itn.width, this.jdField_a_of_type_Itn.height, 33985);
      }
      if (this.jdField_a_of_type_Ipg == null)
      {
        this.jdField_a_of_type_Ipg = new ipg();
        this.jdField_a_of_type_Ipg.onCreate();
      }
      if (bool) {
        this.jdField_a_of_type_Ipg.bG(this.jdField_a_of_type_Itn.width, this.jdField_a_of_type_Itn.height);
      }
      if ((this.c == null) || (bool)) {
        this.c = ByteBuffer.allocate(this.jdField_a_of_type_Itn.width * this.jdField_a_of_type_Itn.height * 3 / 2);
      }
    }
    if ((this.aP == null) || (bool)) {
      this.aP = new byte[this.jdField_a_of_type_Itn.width * this.jdField_a_of_type_Itn.height * 3 / 2];
    }
  }
  
  private void aoU()
  {
    long l6 = SystemClock.elapsedRealtime();
    aoT();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    if (this.mMvpMatrix == null)
    {
      this.mMvpMatrix = GPUBaseFilter.caculateCenterCropMvpMatrix(this.mTextureWidth, this.mTextureHeight, this.jdField_a_of_type_Itn.width, this.jdField_a_of_type_Itn.height);
      Matrix.scaleM(this.mMvpMatrix, 0, 1.0F, -1.0F, 1.0F);
    }
    this.mTextureRender.drawTexture(36197, this.mTextureId, this.T, this.mMvpMatrix);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    long l7 = Math.abs(SystemClock.elapsedRealtime() - l6);
    long l4 = 0L;
    long l5 = 0L;
    long l1 = 0L;
    long l3;
    long l2;
    Object localObject;
    if (this.TH)
    {
      l1 = SystemClock.elapsedRealtime();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Ipg.draw(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
      l3 = Math.abs(SystemClock.elapsedRealtime() - l1);
      l1 = SystemClock.elapsedRealtime();
      GLES20.glReadPixels(0, 0, this.jdField_a_of_type_Itn.width, this.jdField_a_of_type_Itn.height * 3 / 8, 6408, 5121, this.c);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      l2 = Math.abs(SystemClock.elapsedRealtime() - l1);
      this.c.get(this.aP, 0, this.jdField_a_of_type_Itn.width * this.jdField_a_of_type_Itn.height * 3 / 2);
      this.c.clear();
      localObject = this.jdField_a_of_type_Iot$b;
      if (localObject == null) {
        break label398;
      }
      l1 = SystemClock.elapsedRealtime();
      ((iot.b)localObject).a(this.aP, this.arn, 2, this.jdField_a_of_type_Itn);
      l1 = SystemClock.elapsedRealtime() - l1;
    }
    for (;;)
    {
      this.mr = SystemClock.elapsedRealtime();
      l4 = this.mr;
      this.jdField_a_of_type_Iot$a.a(l7, l3, l2, l1, l4 - l6);
      return;
      localObject = GlUtil.captureFrame(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_a_of_type_Itn.width, this.jdField_a_of_type_Itn.height, 0);
      iot.b localb = this.jdField_a_of_type_Iot$b;
      l3 = l4;
      l2 = l5;
      if (localb != null)
      {
        l1 = SystemClock.elapsedRealtime();
        localb.a((Bitmap)localObject, this.jdField_a_of_type_Itn);
        l1 = SystemClock.elapsedRealtime() - l1;
        l3 = l4;
        l2 = l5;
        continue;
        label398:
        l1 = 0L;
      }
    }
  }
  
  private void check()
  {
    if (!this.TG) {
      return;
    }
    if ((this.jdField_b_of_type_Itn.isValid()) || (this.jdField_a_of_type_Itn.isValid())) {
      aoU();
    }
    for (;;)
    {
      this.mHandler.removeMessages(3);
      this.mHandler.sendEmptyMessageDelayed(3, 2000L);
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("EGLScreenCaptureThread", 4, "check, param not valid.");
      }
    }
  }
  
  public void a(iot.b paramb)
  {
    this.jdField_a_of_type_Iot$b = paramb;
  }
  
  public void a(itn paramitn)
  {
    if ((paramitn == null) || (!paramitn.isValid())) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("EGLScreenCaptureThread", 4, "updateRecordParam cur[" + this.jdField_b_of_type_Itn + "], come[" + paramitn + "]");
    }
    this.jdField_b_of_type_Itn.a(paramitn);
  }
  
  @RequiresApi(api=21)
  public void ai(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      init();
      aoR();
      return;
    case 2: 
      aoS();
      release();
      return;
    }
    check();
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  @RequiresApi(api=18)
  public void iD(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("EGLScreenCaptureThread", 4, "quit");
    }
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(2);
    }
    if ((paramBoolean) && (this.mHandler != null)) {
      this.mHandler.getLooper().quitSafely();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    int i = 0;
    if (!this.TG) {}
    do
    {
      return;
      this.mq += 1L;
      l = SystemClock.elapsedRealtime();
      this.mp = l;
      if (this.T == null) {
        this.T = new float[16];
      }
      paramSurfaceTexture.updateTexImage();
      paramSurfaceTexture.getTransformMatrix(this.T);
      this.gK = ((float)paramSurfaceTexture.getTimestamp());
      if (this.gK != 0.0F) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("EGLScreenCaptureThread", 4, "onFrameAvailable, time[" + this.gK + "]");
    return;
    long l = Math.abs(l - this.mr);
    if (this.mr != 0L) {
      if (l >= this.jdField_a_of_type_Itn.intervalTime) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {}
      for (l = Math.min(this.jdField_a_of_type_Itn.intervalTime - l, 2000L);; l = 2000L)
      {
        this.mHandler.removeMessages(3);
        this.mHandler.sendEmptyMessageDelayed(3, l);
        if ((i != 0) || ((!this.jdField_b_of_type_Itn.isValid()) && (!this.jdField_a_of_type_Itn.isValid()))) {
          break;
        }
        aoU();
        return;
      }
    }
  }
  
  public void setTextureSize(int paramInt1, int paramInt2)
  {
    this.mTextureWidth = paramInt1;
    this.mTextureHeight = paramInt2;
  }
  
  public void start()
  {
    this.mHandler.sendEmptyMessage(1);
  }
  
  static class a
  {
    public long count;
    public long ms;
    public long mt;
    public long mu;
    public long mv;
    public long mw;
    public long totalCost;
    
    public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      long l = SystemClock.elapsedRealtime();
      this.count += 1L;
      this.ms = ((this.ms + paramLong1) / 2L);
      this.mt = ((this.mt + paramLong2) / 2L);
      this.mu = ((this.mu + paramLong3) / 2L);
      this.mv = ((this.mv + paramLong4) / 2L);
      this.totalCost = ((this.totalCost + paramLong5) / 2L);
      if (this.mw != 0L) {
        paramLong1 = this.mw;
      }
      this.mw = l;
    }
    
    public void print()
    {
      if (QLog.isColorLevel()) {
        QLog.i("PerfData", 2, String.format(Locale.getDefault(), "addPerfData, [count: %s, oes2NormalCost: %s, gpuDrawCost: %s, readPixelCost:%s, sendDataCost:%s, totalCost:%s", new Object[] { Long.valueOf(this.count), Long.valueOf(this.ms), Long.valueOf(this.mt), Long.valueOf(this.mu), Long.valueOf(this.mv), Long.valueOf(this.totalCost) }));
      }
    }
    
    public void reset()
    {
      this.count = 0L;
      this.ms = 0L;
      this.mt = 0L;
      this.mu = 0L;
      this.mv = 0L;
      this.totalCost = 0L;
      this.mw = 0L;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(Bitmap paramBitmap, itn paramitn);
    
    public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, itn paramitn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iot
 * JD-Core Version:    0.7.0.1
 */