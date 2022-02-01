import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.util.Log;
import android.util.Size;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.1;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class adky
  implements adda, adkx
{
  public static int screenHeight;
  public static int screenWidth;
  public static float ve = 1.0F;
  private long UV;
  private long UW;
  private boolean YI;
  adcz jdField_a_of_type_Adcz;
  private addk jdField_a_of_type_Addk = new addk(this);
  private adly jdField_a_of_type_Adly;
  private amac jdField_a_of_type_Amac;
  private VideoRecordController jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private volatile boolean aMZ;
  public addf b = new addf();
  private boolean bOL;
  private boolean bOM;
  public boolean bON;
  GLSurfaceView jdField_c_of_type_AndroidOpenglGLSurfaceView;
  FramePerformanceMonitor jdField_c_of_type_ComTencentMobileqqArFramePerformanceMonitor = new FramePerformanceMonitor();
  int cIC = 0;
  int cID = 0;
  public volatile adcy d;
  private TextureRender d;
  private Map<Integer, Object> jE = new ConcurrentHashMap();
  public Map<String, adcy> jF = new ConcurrentHashMap();
  private Context mContext;
  
  private adcy a(String paramString)
  {
    if (this.jF.containsKey(paramString)) {
      return (adcy)this.jF.get(paramString);
    }
    return null;
  }
  
  private void b(GL10 paramGL10)
  {
    if (this.jdField_d_of_type_Adcy != null) {
      this.jdField_d_of_type_Adcy.onUpdate();
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDepthMask(true);
    GLES20.glColorMask(true, true, true, true);
    GLES20.glClear(16640);
    GLES20.glDisable(2929);
    c(paramGL10);
    GLES20.glFinish();
  }
  
  private void c(GL10 paramGL10)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Addk.onDrawFrame(paramGL10);
    long l2 = System.currentTimeMillis();
    if (QLog.isDebugVersion())
    {
      this.cID += 1;
      this.cIC = ((int)(l2 - l1 + this.cIC));
      if (this.cID % 100 == 0) {
        Log.i("wing", "scan line anime cameraRenderer cost---- " + this.cIC * 1.0F / Math.max(1, this.cID));
      }
    }
    paramGL10 = this.jdField_d_of_type_Adcy;
    if ((paramGL10 != null) && (paramGL10.canRender()))
    {
      System.currentTimeMillis();
      GLES20.glEnable(2929);
      addf.a locala = this.b.a(paramGL10.getType(), paramGL10.Bx());
      if (locala != null) {
        paramGL10.a(locala);
      }
      GLES20.glDisable(2929);
      System.currentTimeMillis();
    }
    System.currentTimeMillis();
  }
  
  public void A(int paramInt, Object paramObject)
  {
    this.jE.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public int BQ()
  {
    return this.jdField_a_of_type_Addk.Bz();
  }
  
  public void Gr(String paramString)
  {
    this.jF.remove(paramString);
  }
  
  public void Lk(int paramInt)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startARCorePreViewRender. textureId = " + paramInt);
    this.jdField_a_of_type_Addk.KJ(paramInt);
  }
  
  public void Z(Runnable paramRunnable)
  {
    if (this.jdField_c_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_c_of_type_AndroidOpenglGLSurfaceView.queueEvent(paramRunnable);
    }
  }
  
  public addf a()
  {
    return this.b;
  }
  
  public adkx a()
  {
    return this;
  }
  
  public void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startCameraPreviewRender. textureId = " + paramInt1 + ", surfaceTexture = " + paramSurfaceTexture);
    this.jdField_a_of_type_Addk.a(paramInt1, paramSurfaceTexture);
    this.jdField_a_of_type_Addk.M(paramInt2, paramInt3, paramInt4, paramInt5);
    this.UV = 0L;
    this.UW = 0L;
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    this.b.c(paramArrayOfFloat);
  }
  
  public void a(adcy paramadcy, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.aef()) && (this.jdField_a_of_type_Adcz != null)) {
      this.jdField_a_of_type_Adcz.a(paramArCloudConfigInfo, paramInt1, paramInt2, paramObject);
    }
  }
  
  public void a(adcz paramadcz)
  {
    this.jdField_a_of_type_Adcz = paramadcz;
  }
  
  public void a(adly paramadly)
  {
    this.jdField_a_of_type_Adly = paramadly;
  }
  
  public void a(VideoRecordController paramVideoRecordController)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = paramVideoRecordController;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo) {}
  
  public boolean a(addc paramaddc)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startModelRender. resourceInfo.key = " + paramaddc.key + ", resourceInfo.arType = " + paramaddc.cCE + ", resourceInfo.trackMode = " + paramaddc.cCF);
    if (!this.aMZ)
    {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startModelRender. fail because of render not ready");
      return false;
    }
    adcy localadcy2 = a(paramaddc.key);
    adcy localadcy1 = localadcy2;
    if (localadcy2 == null)
    {
      localadcy1 = adde.a(this, paramaddc, this.jdField_c_of_type_AndroidOpenglGLSurfaceView);
      QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "crate new render here 1" + localadcy1);
      this.jF.put(paramaddc.key, localadcy1);
      QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "crate new render here " + localadcy1);
    }
    if (localadcy1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HSRender", 1, "onARStateChanged, renderable == null");
      }
      paramaddc = this.jdField_d_of_type_Adcy;
      this.jdField_d_of_type_Adcy = null;
      this.jdField_c_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.1(this, paramaddc));
      return false;
    }
    this.jdField_c_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.2(this, localadcy1, paramaddc));
    return true;
  }
  
  public boolean a(GLSurfaceView paramGLSurfaceView, Context paramContext)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "init.");
    this.jdField_c_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    this.mContext = paramContext;
    this.jdField_d_of_type_Adcy = null;
    return true;
  }
  
  public boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "enableCameraPreviewScanLine. isEnable = " + paramBoolean + ", endY = " + paramFloat2);
    if (this.jdField_a_of_type_Addk != null)
    {
      this.jdField_a_of_type_Addk.FX(paramBoolean);
      this.jdField_a_of_type_Addk.aD(paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean afc()
  {
    if (this.jdField_a_of_type_Addk != null) {
      return this.jdField_a_of_type_Addk.adH();
    }
    return false;
  }
  
  public void b(addd paramaddd)
  {
    this.b.a(paramaddd);
  }
  
  public void b(ArVideoResourceInfo paramArVideoResourceInfo, adda paramadda)
  {
    if (this.jdField_a_of_type_Adcz == null) {
      return;
    }
    this.jdField_a_of_type_Adcz.a(paramArVideoResourceInfo, paramadda);
  }
  
  public void b(FloatBuffer paramFloatBuffer, Size paramSize)
  {
    this.jdField_a_of_type_Addk.a(paramFloatBuffer, paramSize);
  }
  
  public void cSm()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender.");
    this.jdField_c_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.3(this));
  }
  
  public long fq()
  {
    return this.b.Sm;
  }
  
  public void hg(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Adcz == null) || (this.jdField_d_of_type_Adcy == null))
    {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "notifyAnimationPlayStatusChange.mCurrentRenderable or mOutCallBack is null");
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Adcz.eb(this.jdField_d_of_type_Adcy.getUniqueKey(), paramInt2);
      return;
    case 1: 
      this.jdField_a_of_type_Adcz.ed(this.jdField_d_of_type_Adcy.getUniqueKey(), paramInt2);
      return;
    case 2: 
      this.jdField_a_of_type_Adcz.ec(this.jdField_d_of_type_Adcy.getUniqueKey(), paramInt2);
      return;
    }
    this.jdField_a_of_type_Adcz.ee(this.jdField_d_of_type_Adcy.getUniqueKey(), paramInt2);
  }
  
  public void iP(long paramLong)
  {
    this.b.Sm = paramLong;
  }
  
  public void iQ(long paramLong)
  {
    this.b.So = paramLong;
  }
  
  public Object m(int paramInt)
  {
    return this.jE.get(Integer.valueOf(paramInt));
  }
  
  public Context n()
  {
    return this.mContext;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.adz())) {
      i = 1;
    }
    while (i != 0)
    {
      if (!this.YI)
      {
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(screenWidth, screenHeight, 33984);
        }
        if (this.jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
          this.jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        }
        i = screenWidth;
        int j = screenHeight;
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(this.jdField_a_of_type_Amac, i, j);
        this.YI = true;
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null)
      {
        b(paramGL10);
        QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "onDrawFrame, mRecordFBO == null");
        return;
        i = 0;
      }
      else
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        b(paramGL10);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.d(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, screenWidth, screenHeight);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        GLES20.glDisable(3042);
        this.jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
        if (this.UV == 0L) {
          this.UV = System.currentTimeMillis();
        }
        this.UW += 1L;
        return;
      }
    }
    if (this.YI)
    {
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
      {
        GLES20.glDeleteTextures(1, new int[] { this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId() }, 0);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      }
      if (this.jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender != null)
      {
        this.jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
        this.jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.czb();
      }
      this.YI = false;
    }
    GLES20.glViewport(0, 0, screenWidth, screenHeight);
    RenderBuffer localRenderBuffer1;
    if (this.bOL)
    {
      localRenderBuffer1 = new RenderBuffer(screenWidth, screenHeight, 33984);
      localRenderBuffer1.bind();
    }
    for (;;)
    {
      b(paramGL10);
      if (!this.bOL) {
        break;
      }
      localRenderBuffer1.unbind();
      paramGL10 = new TextureRender();
      GLES20.glViewport(0, 0, screenWidth, screenHeight);
      paramGL10.drawTexture(3553, localRenderBuffer1.getTexId(), null, null);
      RenderBuffer localRenderBuffer2 = new RenderBuffer(540, 960, 33984);
      localRenderBuffer2.bind();
      paramGL10.drawTexture(3553, localRenderBuffer1.getTexId(), null, null);
      localRenderBuffer2.unbind();
      Bitmap localBitmap = GlUtil.captureFrame(localRenderBuffer2.getTexId(), 540, 960, 0);
      GLES20.glDeleteTextures(1, new int[] { localRenderBuffer2.getTexId() }, 0);
      GLES20.glDeleteTextures(1, new int[] { localRenderBuffer1.getTexId() }, 0);
      localRenderBuffer2.destroy();
      paramGL10.release();
      localRenderBuffer1.destroy();
      if (this.jdField_a_of_type_Adcz != null) {
        this.jdField_a_of_type_Adcz.a(null, 1001, 0, localBitmap);
      }
      this.bOL = false;
      break;
      localRenderBuffer1 = null;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    screenWidth = paramInt1;
    screenHeight = paramInt2;
    if (this.jdField_a_of_type_Adly != null) {
      this.jdField_a_of_type_Adly.b(paramGL10, paramInt1, paramInt2);
    }
    this.jdField_a_of_type_Addk.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Adcz != null) {
      this.jdField_a_of_type_Adcz.cQu();
    }
    this.aMZ = true;
    this.bON = true;
    GLES20.glEnable(2884);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "onSurfaceCreated.");
    this.bOM = false;
    if (adcs.adD()) {
      this.jdField_a_of_type_Amac = new amac(EGL14.eglGetCurrentContext(), 1);
    }
    adaq.a().Gn(paramGL10.glGetString(7937));
    this.jdField_a_of_type_Addk.onSurfaceCreated(paramGL10, paramEGLConfig);
    if (this.jdField_a_of_type_Adly != null) {
      this.jdField_a_of_type_Adly.d(paramGL10);
    }
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.5F);
    paramEGLConfig = new StringBuilder();
    if (QLog.isColorLevel()) {
      QLog.d("GPU_INFO", 2, "GL_RENDERER = " + paramGL10.glGetString(7937));
    }
    paramEGLConfig.append("GL_RENDERER = " + paramGL10.glGetString(7937));
    paramEGLConfig.append('\n');
    if (QLog.isColorLevel()) {
      QLog.d("GPU_INFO", 1, "GL_VENDOR = " + paramGL10.glGetString(7936));
    }
    paramEGLConfig.append("GL_VENDOR = " + paramGL10.glGetString(7936));
    paramEGLConfig.append('\n');
    if (QLog.isColorLevel()) {
      QLog.d("GPU_INFO", 2, "GL_VERSION = " + paramGL10.glGetString(7938));
    }
    paramEGLConfig.append("GL_VERSION = " + paramGL10.glGetString(7938));
    paramEGLConfig.append('\n');
    Object localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36347, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_VERTEX_UNIFORM_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(35661, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34076, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_CUBE_MAP_TEXTURE_SIZE = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34024, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_RENDERBUFFER_SIZE = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34930, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_TEXTURE_IMAGE_UNITS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(3379, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_TEXTURE_SIZE = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36349, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_FRAGMENT_UNIFORM_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34921, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_VERTEX_ATTRIBS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36348, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_VARYING_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36349, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_FRAGMENT_UNIFORM_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    paramEGLConfig = new StringBuilder();
    localObject = paramGL10.glGetString(7939).split(" ");
    int i = 0;
    while (i < localObject.length)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("GPU_INFO", 2, "GL_EXTENSIONS = " + localObject[i]);
        paramEGLConfig.append(localObject[i] + " ");
      }
      i += 1;
    }
    adfv.D(paramGL10.glGetString(7937), paramGL10.glGetString(7936), paramGL10.glGetString(7938), paramEGLConfig.toString());
  }
  
  public void requestRender()
  {
    if (this.jdField_c_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_c_of_type_AndroidOpenglGLSurfaceView.requestRender();
    }
  }
  
  public boolean start()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "start.");
    return true;
  }
  
  public void stop()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stop. mHasDestroyElgContext:" + this.bOM);
    this.bON = false;
    if (this.bOM) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jF.values().iterator();
      while (localIterator.hasNext()) {
        ((adcy)localIterator.next()).onDestroy();
      }
      this.jF.clear();
      this.jdField_d_of_type_Adcy = null;
      this.jdField_a_of_type_Addk.destroy();
      this.b.reset();
      this.aMZ = false;
      this.bOM = true;
      try
      {
        if (this.jdField_a_of_type_Amac != null)
        {
          this.jdField_a_of_type_Amac.release();
          this.jdField_a_of_type_Amac = null;
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_UniformGLRenderManagerImpl", 1, "stop, mEglCore release: " + localException.getMessage());
      }
    }
  }
  
  public void uninit()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "uninit.");
    this.jdField_c_of_type_AndroidOpenglGLSurfaceView = null;
    this.mContext = null;
    this.jdField_a_of_type_Adcz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adky
 * JD-Core Version:    0.7.0.1
 */