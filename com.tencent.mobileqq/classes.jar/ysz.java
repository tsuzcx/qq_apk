import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class ysz
  implements GLSurfaceView.EGLContextFactory
{
  private ysz(ApolloSurfaceView paramApolloSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[createContext], id:" + Thread.currentThread().getId());
    }
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    this.a.mIsDestroy.set(false);
    return paramEGL10;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[destroyContext], id:" + Thread.currentThread().getId());
    }
    Object localObject;
    if (ApolloSurfaceView.access$700(this.a))
    {
      localObject = CmGameUtil.a();
      if (localObject != null)
      {
        if (!(localObject instanceof QQAppInterface)) {
          break label167;
        }
        localObject = ApolloCmdChannel.getChannel((QQAppInterface)localObject);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((ApolloCmdChannel)localObject).callbackDirect(this.a.isJsRuntime(), this.a.getLuaState(), 0, "sc.force_stop_game.local", "{}");
        ((ApolloCmdChannel)localObject).destroyMusic();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloSurfaceView", 2, "destroyContext, closeGame)");
        }
      }
      for (;;)
      {
        this.a.mIsDestroy.set(true);
        if (this.a.mRender != null) {
          this.a.mRender.onDestroy();
        }
        if (paramEGL10 != null) {
          paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
        }
        return;
        label167:
        if (!(localObject instanceof CmGameAppInterface)) {
          break label232;
        }
        QLog.i("cmgame_process.", 1, "[destroyContext] in game.");
        localObject = CmGameUtil.a();
        break;
        if ((this.a.mApolloWorker != null) && (this.a.mApolloWorker.a != null)) {
          this.a.mApolloWorker.a.a("if(\"undefined\" != typeof clearSprite && clearSprite){clearSprite();}");
        }
      }
      label232:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysz
 * JD-Core Version:    0.7.0.1
 */