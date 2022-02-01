import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSVArtFilterNew;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.IntBuffer;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ayym
  implements GLSurfaceView.Renderer
{
  private amac jdField_a_of_type_Amac;
  private amad jdField_a_of_type_Amad;
  private long aDo;
  private azap b;
  private int dBm;
  private int dBn;
  private boolean dCa = true;
  private int eNo = awte.eCQ;
  private QQFilterRenderManager h;
  private Bitmap mBitmap;
  private GPUBaseFilter mGPU2DFilter;
  public EGLContext sharedContext;
  private int surfaceHeight;
  private int surfaceWidth;
  
  private void createEglSurfceBase(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Amad = new amad(this.jdField_a_of_type_Amac);
    this.jdField_a_of_type_Amad.createOffscreenSurface(paramInt1, paramInt2);
    this.jdField_a_of_type_Amad.makeCurrent();
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
  }
  
  public Bitmap a(Bitmap paramBitmap, long paramLong)
  {
    this.aDo = paramLong;
    Object localObject = ayyl.a(0);
    QQFilterRenderManager localQQFilterRenderManager = awte.a(awte.eCS);
    if (localQQFilterRenderManager != null)
    {
      MusicItemInfo localMusicItemInfo = localQQFilterRenderManager.getBusinessOperation().getMusicItemInfo();
      this.b = new azap(localQQFilterRenderManager.getBusinessOperation().getCurrentAVFilterIdList(), localMusicItemInfo, this.surfaceWidth, this.surfaceHeight, null);
      this.b.setRenderEditVideoFilterBitmap(true);
      if ((this.b == null) || (localObject == null)) {
        break label210;
      }
    }
    for (;;)
    {
      try
      {
        paramBitmap = rpq.a(paramBitmap, 1.0F, -1.0F);
        ((GPUBaseFilter)localObject).init();
        this.b.lH(this.surfaceWidth, this.surfaceHeight);
        paramBitmap = a(paramBitmap, (GPUBaseFilter)localObject);
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        paramBitmap = null;
      }
      try
      {
        ((GPUBaseFilter)localObject).destroy();
        this.b.eUE();
        localObject = rpq.a(paramBitmap, 1.0F, -1.0F);
        this.b = null;
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        break label161;
      }
      this.b = null;
      break;
      label161:
      localObject = paramBitmap;
      if (QLog.isColorLevel())
      {
        QLog.e("GPUBitmapImageRender", 2, "renderEditVideoFilterBitmap OutOfMemoryError" + localOutOfMemoryError1.toString());
        localObject = paramBitmap;
        continue;
        label210:
        localObject = null;
      }
    }
  }
  
  public Bitmap a(Bitmap paramBitmap, GPUBaseFilter paramGPUBaseFilter)
  {
    this.mBitmap = paramBitmap;
    this.mGPU2DFilter = paramGPUBaseFilter;
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramBitmap.getWidth(), paramBitmap.getHeight());
    if ((this.b != null) && (this.b.dCn)) {}
    for (int i = 30;; i = 2)
    {
      int j = 0;
      while (j < i)
      {
        onDrawFrame(null);
        j += 1;
      }
    }
    paramGPUBaseFilter = IntBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight());
    GLES20.glReadPixels(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), 6408, 5121, paramGPUBaseFilter);
    paramGPUBaseFilter = paramGPUBaseFilter.array();
    paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(paramGPUBaseFilter));
    return paramBitmap;
  }
  
  public Bitmap a(Bitmap paramBitmap, List<FilterDesc> paramList, ayym paramayym)
  {
    this.mGPU2DFilter = paramayym.mGPU2DFilter;
    this.h = paramayym.h;
    if ((this.h != null) && (this.mGPU2DFilter != null) && (paramList != null))
    {
      paramBitmap = rpq.a(paramBitmap, 1.0F, -1.0F);
      this.h.getBusinessOperation().setFilterEffectList(paramList);
      this.mBitmap = paramBitmap;
      int i = 5;
      if (paramayym.dCa)
      {
        paramayym.dCa = false;
        i = 20;
      }
      int j = 0;
      while (j < i)
      {
        onDrawFrame(null);
        j += 1;
      }
      paramList = IntBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight());
      GLES20.glReadPixels(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), 6408, 5121, paramList);
      paramList = paramList.array();
      paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(paramList));
      return rpq.a(paramBitmap, 1.0F, -1.0F);
    }
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, List<FilterDesc> paramList, boolean paramBoolean)
  {
    GPUBaseFilter localGPUBaseFilter = ayyl.a(0);
    this.h = awte.c();
    if ((this.h != null) && (localGPUBaseFilter != null) && (paramList != null))
    {
      paramBitmap = rpq.a(paramBitmap, 1.0F, -1.0F);
      localGPUBaseFilter.init();
      this.h.surfaceCreate(this.surfaceWidth, this.surfaceHeight, this.surfaceWidth, this.surfaceHeight);
      this.h.setParam("key_orientation_degree", String.valueOf(90));
      this.h.getBusinessOperation().setFilterEffectList(paramList);
      return rpq.a(a(paramBitmap, localGPUBaseFilter), 1.0F, -1.0F);
    }
    return null;
  }
  
  public void b(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Amac = new amac(paramEGLContext, 1);
    createEglSurfceBase(paramInt1, paramInt2);
  }
  
  public void destory()
  {
    if (this.jdField_a_of_type_Amad != null)
    {
      this.jdField_a_of_type_Amad.releaseEglSurface();
      this.jdField_a_of_type_Amad = null;
    }
    if (this.jdField_a_of_type_Amac != null)
    {
      this.jdField_a_of_type_Amac.release();
      this.jdField_a_of_type_Amac = null;
    }
    if (this.mGPU2DFilter != null) {
      this.mGPU2DFilter.destroy();
    }
    if (this.h != null)
    {
      this.h.surfaceDestroyed();
      this.h = null;
      this.eNo = awte.eCQ;
    }
  }
  
  @TargetApi(17)
  public void init(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_Amac = new amac(EGL14.eglGetCurrentContext(), 1);
    }
    createEglSurfceBase(paramInt1, paramInt2);
  }
  
  public void lD(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_Amac = new amac(EGL14.EGL_NO_CONTEXT, 1);
    }
    createEglSurfceBase(paramInt1, paramInt2);
  }
  
  @TargetApi(17)
  public void lE(int paramInt1, int paramInt2)
  {
    init(paramInt1, paramInt2);
    this.sharedContext = EGL14.eglGetCurrentContext();
    this.mGPU2DFilter = ayyl.a(0);
    this.h = awte.d();
    this.mGPU2DFilter.init();
    this.h.surfaceCreate(this.surfaceWidth, this.surfaceHeight, this.surfaceWidth, this.surfaceHeight);
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramInt1, paramInt2);
    List localList = this.h.getQQFilters(90);
    if ((localList != null) && (localList.size() > 0)) {}
    try
    {
      ((QQSVArtFilterNew)localList.get(0)).onSurfaceChange(paramInt1, paramInt2);
      label109:
      this.h.setParam("key_orientation_degree", String.valueOf(90));
      return;
    }
    catch (Exception localException)
    {
      break label109;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16640);
    if (this.mBitmap.getWidth() % 2 == 1)
    {
      paramGL10 = Bitmap.createBitmap(this.mBitmap.getWidth() + 1, this.mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramGL10);
      ((Canvas)localObject).drawARGB(0, 0, 0, 0);
      ((Canvas)localObject).drawBitmap(this.mBitmap, 0.0F, 0.0F, null);
      this.dBm = 1;
      if (paramGL10 != null) {
        break label258;
      }
    }
    label258:
    for (Object localObject = this.mBitmap;; localObject = paramGL10)
    {
      this.dBn = GlUtil.createTexture(3553, (Bitmap)localObject);
      if ((paramGL10 != null) && (!paramGL10.isRecycled())) {
        paramGL10.recycle();
      }
      paramGL10 = new float[16];
      Matrix.setIdentityM(paramGL10, 0);
      if (this.b != null) {
        this.dBn = this.b.a(this.surfaceWidth, this.surfaceHeight, this.dBn, this.aDo);
      }
      if (this.h != null)
      {
        this.h.setParam("key_draw_screen", String.valueOf(false));
        this.h.setParam("key_width", String.valueOf(this.surfaceWidth));
        this.h.setParam("key_height", String.valueOf(this.surfaceHeight));
        int i = this.h.drawFrame(this.dBn);
        if (i != -1) {
          this.dBn = i;
        }
      }
      GLES20.glFinish();
      this.mGPU2DFilter.drawTexture(this.dBn, null, paramGL10);
      return;
      this.dBm = 0;
      paramGL10 = null;
      break;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glUseProgram(this.mGPU2DFilter.getProgram());
    this.mGPU2DFilter.onOutputSizeChanged(paramInt1, paramInt2);
    if (this.h != null) {
      this.h.surfaceChange(this.surfaceWidth, this.surfaceHeight, this.surfaceWidth, this.surfaceHeight);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayym
 * JD-Core Version:    0.7.0.1
 */