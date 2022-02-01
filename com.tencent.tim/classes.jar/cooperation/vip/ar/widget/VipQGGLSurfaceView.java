package cooperation.vip.ar.widget;

import android.content.Context;
import asfz;
import asgc;
import asgk;
import awlf;
import com.tencent.qg.sdk.QGBitmapLoader;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.QGReporter;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qg.sdk.log.GLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

public class VipQGGLSurfaceView
  extends QGGLSurfaceView
{
  private static String TAG = "VipQGGLSurfaceView";
  private asgk a;
  private ModuleEngine mModuleEngine;
  
  public VipQGGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VipQGGLSurfaceView(Context paramContext, int paramInt1, int paramInt2, EGLContext paramEGLContext, EGLConfig paramEGLConfig, String paramString)
  {
    super(paramContext, paramInt1, paramInt2, paramEGLContext, paramEGLConfig, paramString);
    init();
  }
  
  public void init()
  {
    GLog.init(new awlf());
    QGBitmapLoader.setBitmapLoader(new asfz());
    QGReporter.setReporter(new asgc());
    this.mModuleEngine = new ModuleEngine();
    this.a = new asgk();
    this.mModuleEngine.registerJsModule(this.a);
    setModuleEngin(this.mModuleEngine);
  }
  
  public void onDestory()
  {
    if ((this.mModuleEngine != null) && (this.a != null)) {
      this.mModuleEngine.unRegisterJsModule(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.ar.widget.VipQGGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */