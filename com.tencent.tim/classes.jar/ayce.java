import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qg.StoryQGSurfaceView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayce
  implements IEventReceiver
{
  private Queue<Runnable> U = new LinkedList();
  private boolean Yp;
  private final ayce.b a = new ayce.b(this);
  private boolean mIsSurfaceCreated;
  
  public ayce()
  {
    pmi.a().registerSubscriber(this.a);
  }
  
  private void eQd()
  {
    Object localObject = new StringBuilder().append("mIsSurfaceCreated = ").append(this.mIsSurfaceCreated).append(", qgloaded = ").append(asgf.isSoLoaded.get()).append(", renderManager = ");
    if (EffectsCameraCaptureView.b() != null) {}
    for (boolean bool = true;; bool = false)
    {
      ram.d("QGEnvironment", bool + ", aeRenderManager = ");
      if ((!this.mIsSurfaceCreated) || (!asgf.isSoLoaded.get()) || (EffectsCameraCaptureView.b() == null)) {
        break;
      }
      while (!this.U.isEmpty())
      {
        localObject = (Runnable)this.U.poll();
        if (localObject != null) {
          ((Runnable)localObject).run();
        }
      }
    }
  }
  
  public StoryQGSurfaceView a(awsy paramawsy)
  {
    CameraCaptureView localCameraCaptureView = paramawsy.a();
    Context localContext = localCameraCaptureView.getContext();
    int i = rpq.getScreenWidth(localContext);
    int j = rpq.getScreenHeight(localContext);
    int k = j - paramawsy.Qz() - paramawsy.QA();
    if (QLog.isColorLevel()) {
      QLog.d("QGEnvironment", 2, new Object[] { "createQGGLView width:", Integer.valueOf(i), ", height:", Integer.valueOf(j), ", realHeight=", Integer.valueOf(k) });
    }
    paramawsy = new StoryQGSurfaceView(localContext, i, k, localCameraCaptureView.eglContext, localCameraCaptureView.a, jpe.hP());
    QLog.i("QGEnvironment", 1, "QGVersion = " + StoryQGSurfaceView.getQGVersion() + " QGBuildTimeStamp = " + paramawsy.getQGBuildTimeStamp());
    return paramawsy;
  }
  
  public void aH(Runnable paramRunnable)
  {
    this.U.offer(paramRunnable);
    eQd();
  }
  
  public void aI(Runnable paramRunnable)
  {
    this.U.remove(paramRunnable);
  }
  
  public void eQc()
  {
    asgf.b("1018", true, new aycf(this));
  }
  
  public boolean isValidate()
  {
    return !this.Yp;
  }
  
  public void onDestroy()
  {
    this.Yp = true;
    pmi.a().unRegisterSubscriber(this.a);
  }
  
  public static class a
    extends plt
  {
    private final int mEventType;
    private final boolean mIsSuccess;
    
    public a(int paramInt, boolean paramBoolean)
    {
      this.mEventType = paramInt;
      this.mIsSuccess = paramBoolean;
    }
    
    public int getEventType()
    {
      return this.mEventType;
    }
  }
  
  static class b
    extends QQUIEventReceiver<ayce, ayce.a>
  {
    public b(@NonNull ayce paramayce)
    {
      super();
    }
    
    public void a(@NonNull ayce paramayce, @NonNull ayce.a parama)
    {
      if (ayce.a.a(parama))
      {
        switch (parama.getEventType())
        {
        }
        for (;;)
        {
          ayce.a(paramayce);
          return;
          ayce.a(paramayce, true);
          ram.d("QGEnvironment", "surface created");
          continue;
          ram.d("QGEnvironment", "qg so loaded");
          continue;
          ram.d("QGEnvironment", "filter manager inited");
        }
      }
      ram.e("QGEnvironment", "QG environment init error :  event type = " + parama.getEventType());
    }
    
    public Class acceptEventClass()
    {
      return ayce.a.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayce
 * JD-Core Version:    0.7.0.1
 */