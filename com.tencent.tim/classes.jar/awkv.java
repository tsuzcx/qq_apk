import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.Matrix;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceHolder;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ar.controller.VipARCameraController.3;
import cooperation.vip.ar.controller.VipARCameraController.6;
import cooperation.vip.ar.controller.VipARCameraController.7;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

public class awkv
  extends awla
{
  private View.OnTouchListener G = new awky(this);
  private ScaleGestureDetector.OnScaleGestureListener jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener = new awkz(this);
  private awlb jdField_a_of_type_Awlb;
  private awld jdField_a_of_type_Awld;
  private awle jdField_a_of_type_Awle;
  private awlg.a jdField_a_of_type_Awlg$a = new awkw(this);
  private boolean aYG = true;
  private TextView agD;
  private awlg.a b = new awkx(this);
  private EGLContext c;
  private float[] dS;
  private float[] dT;
  private float[] dU;
  private boolean dqG;
  private boolean dqH;
  private boolean dqI;
  private boolean dqJ;
  private boolean dqK;
  private boolean dqL = true;
  private boolean dqM;
  private boolean dqN;
  private GLSurfaceView jdField_e_of_type_AndroidOpenglGLSurfaceView;
  private SurfaceHolder jdField_e_of_type_AndroidViewSurfaceHolder;
  private int mFrameHeight;
  private int mFrameWidth;
  private boolean mIsResume;
  private int mOrientation;
  private ScaleGestureDetector mScaleGestureDetector;
  private int mScreenHeight;
  private int mScreenWidth;
  
  static
  {
    System.loadLibrary("c++_shared");
  }
  
  @RequiresApi(8)
  public awkv(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    if (paramContext.getResources().getConfiguration().orientation == 2) {}
    for (this.mOrientation = 0;; this.mOrientation = 1)
    {
      awlg.a().b(this.b);
      this.jdField_a_of_type_Awlb = new awlb(paramContext, paramViewGroup);
      return;
    }
  }
  
  private float[] a(float paramFloat1, float paramFloat2)
  {
    float f;
    if (this.mOrientation == 0)
    {
      paramFloat1 /= this.mScreenWidth;
      paramFloat1 = this.mFrameWidth * paramFloat1;
      f = paramFloat2 / this.mScreenHeight * this.mFrameHeight;
      paramFloat2 = paramFloat1;
    }
    for (paramFloat1 = f;; paramFloat1 = this.mFrameHeight - paramFloat1 * f)
    {
      return new float[] { paramFloat2, paramFloat1 };
      paramFloat1 /= this.mScreenWidth;
      f = this.mFrameHeight;
      paramFloat2 = paramFloat2 / this.mScreenHeight * this.mFrameWidth;
    }
  }
  
  private void eEg()
  {
    this.jdField_a_of_type_Awld = new awld();
    this.jdField_a_of_type_Awld.init(this.mContext, this.mOrientation);
    this.mFrameWidth = this.jdField_a_of_type_Awld.Qn();
    this.mFrameHeight = this.jdField_a_of_type_Awld.Qo();
    this.dqI = true;
    ThreadManager.getUIHandler().post(new VipARCameraController.3(this));
  }
  
  private void eEj()
  {
    if (!this.dqM)
    {
      this.dqM = true;
      ThreadManagerV2.getUIHandlerV2().post(new VipARCameraController.6(this));
    }
  }
  
  private void eEk()
  {
    if (!this.dqN)
    {
      this.dqN = true;
      ThreadManagerV2.getUIHandlerV2().post(new VipARCameraController.7(this));
    }
  }
  
  public void eEh()
  {
    this.jdField_e_of_type_AndroidOpenglGLSurfaceView = ((GLSurfaceView)this.as.findViewById(2131364214));
    this.jdField_e_of_type_AndroidOpenglGLSurfaceView.setEGLContextClientVersion(2);
    this.jdField_e_of_type_AndroidOpenglGLSurfaceView.setEGLContextFactory(new awkv.a(null));
    this.jdField_e_of_type_AndroidOpenglGLSurfaceView.setRenderer(this);
    this.jdField_e_of_type_AndroidOpenglGLSurfaceView.setRenderMode(1);
    this.jdField_e_of_type_AndroidOpenglGLSurfaceView.setPreserveEGLContextOnPause(true);
    this.mScaleGestureDetector = new ScaleGestureDetector(this.mContext, this.jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener);
    this.jdField_e_of_type_AndroidOpenglGLSurfaceView.setOnTouchListener(this.G);
    this.jdField_e_of_type_AndroidOpenglGLSurfaceView.setVisibility(8);
    this.agD = ((TextView)this.as.findViewById(2131379558));
  }
  
  public void eEi()
  {
    if (this.dqI) {
      this.jdField_a_of_type_Awld.onResume();
    }
  }
  
  public void jE(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Awle == null) {
      this.jdField_a_of_type_Awle = new awle();
    }
    this.jdField_a_of_type_Awle.width = aqnm.getScreenWidth();
    this.jdField_a_of_type_Awle.height = aqnm.getScreenHeight();
    this.jdField_a_of_type_Awle.resUrl = paramString1;
    this.jdField_a_of_type_Awle.resMD5 = paramString2;
    if (this.jdField_a_of_type_Awlb != null) {
      this.jdField_a_of_type_Awlb.a(this.jdField_a_of_type_Awle);
    }
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    QLog.d("VipARCameraController", 2, "onActivityDestroy " + this.dqI);
    if (this.dqI) {
      this.jdField_a_of_type_Awld.onDestroy();
    }
    if (this.jdField_a_of_type_Awlb != null) {
      this.jdField_a_of_type_Awlb.onActivityDestroy();
    }
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (this.jdField_a_of_type_Awlb != null) {
      this.jdField_a_of_type_Awlb.onActivityPause();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    QLog.d("VipARCameraController", 2, "onActivityResume " + this.dqI);
    this.mIsResume = true;
    if (this.dqI) {
      this.jdField_a_of_type_Awld.onResume();
    }
    if (this.jdField_a_of_type_Awlb != null) {
      this.jdField_a_of_type_Awlb.onActivityResume();
    }
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    QLog.d("VipARCameraController", 2, "onActivityStop " + this.dqI);
    this.mIsResume = false;
    if (this.dqI) {
      this.jdField_a_of_type_Awld.onStop();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16640);
    if (!this.dqI) {}
    do
    {
      float[] arrayOfFloat;
      do
      {
        do
        {
          return;
          eEj();
          if (this.jdField_a_of_type_Awld.a(this.jdField_e_of_type_AndroidViewSurfaceHolder, false) == 0) {
            break;
          }
        } while (this.jdField_a_of_type_Awlb == null);
        this.jdField_a_of_type_Awlb.onDrawFrame(null);
        return;
        if (this.dqL)
        {
          awlg.jF("ar_tar_show", "1");
          this.dqL = false;
        }
        eEk();
        if (this.dS == null) {
          this.dS = new float[16];
        }
        if (this.dT == null) {
          this.dT = new float[16];
        }
        if (this.dU == null) {
          this.dU = new float[16];
        }
        Matrix.setIdentityM(this.dS, 0);
        Matrix.setIdentityM(this.dT, 0);
        Matrix.setIdentityM(this.dU, 0);
        arrayOfFloat = this.jdField_a_of_type_Awld.l();
      } while (arrayOfFloat == null);
      this.dT[0] = arrayOfFloat[0];
      this.dT[5] = arrayOfFloat[1];
      this.dT[10] = arrayOfFloat[2];
      Matrix.scaleM(this.dU, 0, this.jdField_a_of_type_Awld.i(), 0, 1.0F / arrayOfFloat[0], 1.0F / arrayOfFloat[1], 1.0F / arrayOfFloat[2]);
      Matrix.multiplyMM(this.dS, 0, this.jdField_a_of_type_Awld.j(), 0, this.dU, 0);
    } while (this.jdField_a_of_type_Awlb == null);
    this.jdField_a_of_type_Awlb.a(this.dT, this.dS, this.jdField_a_of_type_Awld.k());
    this.jdField_a_of_type_Awlb.onDrawFrame(paramGL10);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    QLog.d("VipARCameraController", 2, "onSurfaceChanged");
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClearDepthf(1.0F);
    GLES20.glEnable(2929);
    GLES20.glDepthFunc(515);
    this.mScreenWidth = paramInt1;
    this.mScreenHeight = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.dqI) {
      this.jdField_a_of_type_Awld.X(0, 0, paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_Awlb != null) {
      this.jdField_a_of_type_Awlb.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
    this.dqH = true;
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    QLog.d("VipARCameraController", 2, "onSurfaceCreated" + this.dqI);
    this.jdField_a_of_type_Awle.d = this.c;
    if (this.dqI) {
      this.jdField_a_of_type_Awld.akO();
    }
    if (this.jdField_a_of_type_Awlb != null) {
      this.jdField_a_of_type_Awlb.onSurfaceCreated(paramGL10, paramEGLConfig);
    }
    this.dqG = true;
  }
  
  class a
    implements GLSurfaceView.EGLContextFactory
  {
    private int EGL_CONTEXT_CLIENT_VERSION = 12440;
    
    private a() {}
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int i = this.EGL_CONTEXT_CLIENT_VERSION;
      awkv.a(awkv.this, paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 }));
      return awkv.a(awkv.this);
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext)) {
        QLog.e("VipARCameraController", 2, new Object[] { "DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awkv
 * JD-Core Version:    0.7.0.1
 */