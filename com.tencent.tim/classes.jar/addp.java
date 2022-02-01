import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.1;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.10;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.11;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;

public class addp
  implements adcy, ARNativeBridge.ActionCallback
{
  private long Ss;
  private addq a;
  private adbc jdField_b_of_type_Adbc;
  private GLSurfaceView jdField_b_of_type_AndroidOpenglGLSurfaceView;
  public boolean bLW = false;
  private String bsj;
  private ARNativeBridge c;
  private int cCK;
  private volatile int cCL = 1;
  private int cDK;
  private int cDL;
  private adda d;
  private String[] eq;
  private Context mContext;
  private volatile int mCurrentState = 1;
  private int mHeight;
  private int mWidth;
  
  public addp(adda paramadda, addq paramaddq, GLSurfaceView paramGLSurfaceView)
  {
    this.d = paramadda;
    this.a = paramaddq;
    this.jdField_b_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    this.mContext = this.d.n();
    this.c = ((ARNativeBridge)this.d.m(0));
  }
  
  public int Bx()
  {
    return 1;
  }
  
  public void Gs(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "playEffectMusic, " + paramString);
    }
    this.jdField_b_of_type_AndroidOpenglGLSurfaceView.queueEvent(new Interactive3DRenderable.10(this, paramString));
  }
  
  public void Gt(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "playBgMusic, " + paramString);
    }
    this.jdField_b_of_type_AndroidOpenglGLSurfaceView.queueEvent(new Interactive3DRenderable.11(this, paramString));
  }
  
  public void KI(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "setNativeState, mCurState=" + this.mCurrentState + ", new State=" + paramInt);
    }
    this.mCurrentState = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    case 11: 
    default: 
      return;
    case 2: 
      ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
      this.cCK = this.c.getIndentification();
      this.c.nativeCreateEngineBusiness(this.cCK, this.a.bsg, this.mContext, this.mContext.getAssets(), this.a.bsh, this.mWidth, this.mHeight, 100);
      this.c.setupActionCallback(this);
      KI(7);
      return;
    case 6: 
      this.c.nativeonSurfaceChanged(this.cCK, this.mWidth, this.mHeight);
      return;
    case 7: 
      this.c.nativeResume(this.cCK);
      this.cCL = 0;
      KI(11);
      return;
    case 9: 
      this.d.Z(new Interactive3DRenderable.1(this));
      return;
    case 8: 
      this.c.nativePause(this.cCK);
      return;
    }
    this.c.nativeDestroyCertainEngine(this.cCK);
    this.c.setupActionCallback(null);
    this.cCK = 0;
    if (this.jdField_b_of_type_Adbc != null)
    {
      this.jdField_b_of_type_Adbc.cPE();
      this.jdField_b_of_type_Adbc.destroy();
    }
    this.mCurrentState = 1;
  }
  
  public void a(addf.a parama)
  {
    this.c.nativeOnDrawFrame(this.cCK, parama.bB, (float[])parama.r("CAMERA_POSITION"));
  }
  
  public boolean adF()
  {
    return true;
  }
  
  public void callback(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "fNativeDoActionCallback action=" + paramInt1 + ", params=" + paramString1 + ", callbackId=" + paramInt2 + ", result=" + paramString2);
    }
    if (this.d == null) {}
    do
    {
      return;
      switch (paramInt1)
      {
      case 57: 
      default: 
        this.d.a(this, this.a.b, paramInt1, 0, paramString2);
        return;
      }
    } while (System.currentTimeMillis() - this.Ss < 300L);
    this.Ss = System.currentTimeMillis();
    Gs("res/music/fudai_click.mp3");
    return;
    Gs("res/music/fudai_explode.mp3");
    return;
    Gs("res/music/fudai_appear.mp3");
    Gt("res/music/fudai_background.mp3");
    return;
    Gt("res/music/gameing_background.mp3");
    return;
    Gt("res/music/gameend_background.mp3");
    return;
    Gs("res/music/redpack_get.mp3");
    return;
    Gs("res/music/aimed.mp3");
    return;
    this.cDL += 1;
    this.cDK += paramInt2;
  }
  
  public boolean canRender()
  {
    return (this.mCurrentState == 9) && (this.cCK != 0);
  }
  
  public int getType()
  {
    return this.a.b.type;
  }
  
  public String getUniqueKey()
  {
    return this.a.key;
  }
  
  public void init()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "init");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "onDestroy, " + this);
    }
    if (this.mCurrentState == 9)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_Interactive3DRenderable", 2, "onDestroy, queueEvent, " + this);
      }
      if ((this.d != null) && (this.bLW == true))
      {
        this.d.hg(1, 0);
        this.bLW = false;
      }
      if (this.d != null)
      {
        this.d.Gr(this.a.key);
        QLog.d("AREngine_Interactive3DRenderable", 2, "onDestroy, remove hsRender here, " + this);
        this.d.a(this, this.a.b, 101, 0, null);
      }
      if (this.mCurrentState == 9) {
        KI(10);
      }
    }
    if (this.cDL > 0)
    {
      float f = this.cDK * 1.0F / this.cDL;
      HashMap localHashMap = new HashMap();
      localHashMap.put("fps_total", String.valueOf(this.cDK));
      localHashMap.put("fps_count", String.valueOf(this.cDL));
      localHashMap.put("fps_avg", String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(f) }));
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(BaseActivity.sTopActivity.getCurrentAccountUin(), "binhai_fps", true, 0L, 0L, localHashMap, "", false);
    }
  }
  
  public void onUpdate()
  {
    if (this.mCurrentState == 11)
    {
      int i = this.cCL + 1;
      this.cCL = i;
      if (i >= 2) {
        KI(9);
      }
    }
  }
  
  public void setWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "start");
    }
    if (1 == this.mCurrentState)
    {
      String str = this.a.bsh;
      this.bsj = str;
      this.eq = new String[8];
      this.eq[0] = (str + "res/music/loading.mp3");
      this.eq[1] = (str + "res/music/321ready.mp3");
      this.eq[2] = (str + "res/music/redpack_open.mp3");
      this.eq[3] = (str + "res/music/fudai_click.mp3");
      this.eq[4] = (str + "res/music/fudai_explode.mp3");
      this.eq[5] = (str + "res/music/fudai_appear.mp3");
      this.eq[6] = (str + "res/music/redpack_get.mp3");
      this.eq[7] = (str + "res/music/aimed.mp3");
      this.jdField_b_of_type_Adbc = new adbc(1, this.eq);
      KI(2);
      this.cDL = 0;
      this.cDK = 0;
    }
    if (this.d != null) {
      this.d.a(this, this.a.b, 100, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addp
 * JD-Core Version:    0.7.0.1
 */