import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.subscribe.other.story.VSDbOperationHelper.2;
import com.tencent.biz.subscribe.other.story.VSDbOperationHelper.3;
import com.tencent.biz.subscribe.other.story.VSDbOperationHelper.4;
import com.tencent.biz.subscribe.other.story.VSDbOperationHelper.5;
import com.tencent.biz.subscribe.other.story.VSDbOperationHelper.6;
import com.tencent.biz.subscribe.other.story.VSDbOperationHelper.7;
import com.tencent.biz.subscribe.other.story.VSUploadVideoEntry;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class sfk
{
  private EntityManager b;
  private Handler mHandler;
  private HandlerThread mThread = ThreadManager.newFreeHandlerThread("VSDbOperationThread", 0);
  
  public sfk()
  {
    this.mThread.start();
    this.mHandler = new Handler(this.mThread.getLooper());
    this.b = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
  }
  
  private VSUploadVideoEntry a(String paramString)
  {
    Object localObject = QQStoryContext.a().mi();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "getOperationEntry() user id == null");
      return null;
    }
    localObject = this.b.query(VSUploadVideoEntry.class, VSUploadVideoEntry.class.getSimpleName(), false, "uid=? and fakeId=?", new String[] { localObject, paramString }, null, null, null, null, null);
    fd((List)localObject);
    return a((List)localObject, paramString);
  }
  
  private VSUploadVideoEntry a(List<VSUploadVideoEntry> paramList, String paramString)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VSUploadVideoEntry localVSUploadVideoEntry = (VSUploadVideoEntry)paramList.next();
      if (paramString.equals(localVSUploadVideoEntry.fakeId)) {
        return localVSUploadVideoEntry;
      }
    }
    return null;
  }
  
  private void b(PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramPublishVideoEntry.mLocalRawVideoDir)) && (!paramPublishVideoEntry.mLocalRawVideoDir.contains(Environment.DIRECTORY_DCIM)))
    {
      if (!new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory()) {
        break label90;
      }
      rox.fA(paramPublishVideoEntry.mLocalRawVideoDir);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramPublishVideoEntry.videoUploadGroupTempDir)) {
        rox.fA(paramPublishVideoEntry.videoUploadGroupTempDir);
      }
      if (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) {
        break;
      }
      rox.fB(paramPublishVideoEntry.backgroundMusicPath);
      return;
      label90:
      int i = paramPublishVideoEntry.mLocalRawVideoDir.lastIndexOf("/");
      rox.fA(paramPublishVideoEntry.mLocalRawVideoDir.substring(0, i));
    }
  }
  
  private void e(VSUploadVideoEntry paramVSUploadVideoEntry)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new VSDbOperationHelper.3(this, paramVSUploadVideoEntry));
  }
  
  private void f(VSUploadVideoEntry paramVSUploadVideoEntry)
  {
    if (paramVSUploadVideoEntry == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramVSUploadVideoEntry.localVideoPath)) {
        rox.fB(paramVSUploadVideoEntry.localVideoPath);
      }
    } while ((paramVSUploadVideoEntry.originalEntry == null) || (TextUtils.isEmpty(paramVSUploadVideoEntry.originalEntry.videoUploadTempDir)));
    rox.fA(paramVSUploadVideoEntry.originalEntry.videoUploadTempDir);
  }
  
  private void fd(List<VSUploadVideoEntry> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VSUploadVideoEntry localVSUploadVideoEntry = (VSUploadVideoEntry)paramList.next();
        long l = localVSUploadVideoEntry.originalEntryId;
        localVSUploadVideoEntry.originalEntry = ((PublishVideoEntry)this.b.find(PublishVideoEntry.class, l));
      }
    }
  }
  
  /* Error */
  public void a(VSUploadVideoEntry paramVSUploadVideoEntry, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	sfk:mHandler	Landroid/os/Handler;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 45	sfk:mHandler	Landroid/os/Handler;
    //   18: new 227	com/tencent/biz/subscribe/other/story/VSDbOperationHelper$1
    //   21: dup
    //   22: aload_0
    //   23: aload_1
    //   24: iload_2
    //   25: invokespecial 230	com/tencent/biz/subscribe/other/story/VSDbOperationHelper$1:<init>	(Lsfk;Lcom/tencent/biz/subscribe/other/story/VSUploadVideoEntry;Z)V
    //   28: invokevirtual 205	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   31: pop
    //   32: goto -21 -> 11
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	sfk
    //   0	40	1	paramVSUploadVideoEntry	VSUploadVideoEntry
    //   0	40	2	paramBoolean	boolean
    //   6	2	3	localHandler	Handler
    // Exception table:
    //   from	to	target	type
    //   2	7	35	finally
    //   14	32	35	finally
  }
  
  public void a(String paramString, sfk.b paramb, Handler paramHandler)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new VSDbOperationHelper.6(this, paramString, paramb, paramHandler));
  }
  
  public void a(sfk.a parama, String paramString)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new VSDbOperationHelper.2(this, paramString, parama));
  }
  
  public void byl()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    if (this.mThread != null)
    {
      this.mThread.quit();
      this.mThread = null;
    }
  }
  
  public void bym()
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.postDelayed(new VSDbOperationHelper.4(this), 2000L);
  }
  
  public void g(VSUploadVideoEntry paramVSUploadVideoEntry)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new VSDbOperationHelper.5(this, paramVSUploadVideoEntry));
  }
  
  public void tb(String paramString)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new VSDbOperationHelper.7(this, paramString));
  }
  
  public static abstract interface a
  {
    public abstract void bl(List<VSUploadVideoEntry> paramList);
  }
  
  public static abstract interface b
  {
    public abstract void h(VSUploadVideoEntry paramVSUploadVideoEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfk
 * JD-Core Version:    0.7.0.1
 */