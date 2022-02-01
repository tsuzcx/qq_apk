import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.3;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.5;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.6;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.7;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;

public class pno
  implements pnb.a
{
  private pnb b = new pnb();
  private Map<String, png> fE = new HashMap();
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private Handler mWorkerHandler = new Handler(ThreadManager.getSubThreadLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, pno.a parama)
  {
    if (parama == null) {
      return;
    }
    this.mUIHandler.post(new StorySingleFileDownloader.7(this, parama, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, pno.a parama)
  {
    if (parama == null) {
      return;
    }
    this.mUIHandler.post(new StorySingleFileDownloader.5(this, parama, paramString, paramInt));
  }
  
  private void b(String paramString, int paramInt, pno.a parama)
  {
    if (parama == null) {
      return;
    }
    this.mUIHandler.post(new StorySingleFileDownloader.6(this, parama, paramString, paramInt));
  }
  
  private void e(png parampng, ErrorMessage paramErrorMessage)
  {
    int i = 1;
    ram.w("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { parampng.downloadKey, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0)
    {
      if (i == 0) {
        break label147;
      }
      parampng.status = 3;
      ((pmq)psx.a(28)).bg(parampng.vid, parampng.fileType);
      paramErrorMessage = ((psu)psx.a(5)).a(parampng.vid);
      if (paramErrorMessage != null) {
        pnh.a(paramErrorMessage, parampng.localPath, parampng.fileType, rar.getNetworkType(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = parampng.fD.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof pno.a))) {
        a(parampng.vid, parampng.fileType, (pno.a)paramErrorMessage);
      }
    }
    label147:
    Object localObject;
    do
    {
      return;
      i = 0;
      break;
      localObject = parampng.fD.get("DOWNLOAD_TASK_KEY_LISTENER");
    } while ((localObject == null) || (!(localObject instanceof pno.a)));
    a(parampng.vid, parampng.fileType, paramErrorMessage, (pno.a)localObject);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, pno.a parama)
  {
    this.mWorkerHandler.post(new StorySingleFileDownloader.2(this, paramString, paramInt, parama, paramBoolean));
  }
  
  public void a(png parampng, ErrorMessage paramErrorMessage)
  {
    this.mWorkerHandler.post(new StorySingleFileDownloader.4(this, parampng, paramErrorMessage));
  }
  
  public void bi(String paramString, int paramInt)
  {
    this.mWorkerHandler.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void stop()
  {
    this.mWorkerHandler.post(new StorySingleFileDownloader.1(this));
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt, ErrorMessage paramErrorMessage);
    
    public abstract void bj(String paramString, int paramInt);
    
    public abstract void onSuccess(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pno
 * JD-Core Version:    0.7.0.1
 */