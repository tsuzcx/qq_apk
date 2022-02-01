import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.videostory.video.SimpleGLThread.1;
import com.tencent.biz.videostory.video.SimpleGLThread.3;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;

@TargetApi(18)
public class sqw
{
  private EglCore mCore;
  private Handler mHandler;
  private OffscreenSurface mOffscreenSurface;
  
  public sqw(EGLContext paramEGLContext, String paramString)
  {
    paramString = new HandlerThread(paramString, 9);
    paramString.start();
    while (!paramString.isAlive()) {}
    QLog.i("SimpleGLThread", 2, "create SimpleGLThread");
    this.mHandler = new Handler(paramString.getLooper());
    this.mHandler.post(new SimpleGLThread.1(this, paramEGLContext));
  }
  
  /* Error */
  public void P(Runnable paramRunnable)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 18	java/lang/Object:<init>	()V
    //   7: astore_2
    //   8: ldc 32
    //   10: iconst_3
    //   11: new 77	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   18: ldc 80
    //   20: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 88	java/lang/Object:hashCode	()I
    //   27: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 98	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_2
    //   37: monitorenter
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 101	sqw:postJob	(Ljava/lang/Runnable;)V
    //   43: aload_0
    //   44: new 103	com/tencent/biz/videostory/video/SimpleGLThread$2
    //   47: dup
    //   48: aload_0
    //   49: aload_2
    //   50: invokespecial 106	com/tencent/biz/videostory/video/SimpleGLThread$2:<init>	(Lsqw;Ljava/lang/Object;)V
    //   53: invokevirtual 101	sqw:postJob	(Ljava/lang/Runnable;)V
    //   56: aload_2
    //   57: invokevirtual 109	java/lang/Object:wait	()V
    //   60: ldc 32
    //   62: iconst_3
    //   63: new 77	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   70: ldc 111
    //   72: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_2
    //   76: invokevirtual 88	java/lang/Object:hashCode	()I
    //   79: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 98	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_2
    //   89: monitorexit
    //   90: return
    //   91: astore_1
    //   92: ldc 32
    //   94: iconst_0
    //   95: ldc 113
    //   97: invokestatic 116	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: goto -12 -> 88
    //   103: astore_1
    //   104: aload_2
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	sqw
    //   0	108	1	paramRunnable	Runnable
    //   7	98	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	88	91	java/lang/InterruptedException
    //   38	56	103	finally
    //   56	88	103	finally
    //   88	90	103	finally
    //   92	100	103	finally
    //   104	106	103	finally
  }
  
  public void destroy()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new SimpleGLThread.3(this));
    }
  }
  
  public void postJob(Runnable paramRunnable)
  {
    if (this.mHandler != null) {
      this.mHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqw
 * JD-Core Version:    0.7.0.1
 */