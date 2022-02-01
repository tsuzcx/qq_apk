package com.tencent.qg;

import android.content.Context;
import asfz;
import asgb;
import asgc;
import asgk;
import com.tencent.qg.sdk.QGBitmapLoader;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.QGReporter;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qg.sdk.log.GLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

public class StoryQGSurfaceView
  extends QGGLSurfaceView
{
  private static String TAG = "StoryQGSurfaceView";
  private ModuleEngine a;
  
  public StoryQGSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public StoryQGSurfaceView(Context paramContext, int paramInt1, int paramInt2, EGLContext paramEGLContext, EGLConfig paramEGLConfig, String paramString)
  {
    super(paramContext, paramInt1, paramInt2, paramEGLContext, paramEGLConfig, paramString);
    init();
  }
  
  public void init()
  {
    GLog.init(new asgb());
    QGBitmapLoader.setBitmapLoader(new asfz());
    QGReporter.setReporter(new asgc());
    this.a = new ModuleEngine();
    this.a.registerJsModule(new asgk());
    setModuleEngin(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.StoryQGSurfaceView
 * JD-Core Version:    0.7.0.1
 */