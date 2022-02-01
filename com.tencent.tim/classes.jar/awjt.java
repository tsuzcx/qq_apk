import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import cooperation.troop_homework.jsp.TroopHWFileDownloadManager.1;
import cooperation.troop_homework.jsp.TroopHWFileDownloadManager.2;
import java.io.File;
import java.util.HashMap;

public class awjt
{
  public static final String TAG = awjt.class.getName();
  private TMAssistantDownloadSettingClient a;
  private TMAssistantDownloadClient b;
  private ITMAssistantDownloadClientListener c = new awju(this);
  private String mKey;
  private HashMap<String, String> qP = new HashMap();
  private HashMap<String, awjt.a> qQ = new HashMap();
  
  public awjt(Context paramContext)
  {
    TMAssistantDownloadManager localTMAssistantDownloadManager = TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext());
    this.mKey = (TAG + Process.myPid() + "_" + System.currentTimeMillis());
    this.b = localTMAssistantDownloadManager.getDownloadSDKClient(this.mKey);
    this.a = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKSettingClient();
    this.b.registerDownloadTaskListener(this.c);
  }
  
  public void a(String paramString1, String paramString2, awjt.a parama)
  {
    String str = paramString2.substring(paramString2.lastIndexOf("/") + 1);
    File localFile = new File(paramString2);
    if (localFile.exists())
    {
      if (parama != null)
      {
        parama.onProgress(paramString1, localFile.length(), localFile.length());
        parama.f(paramString1, 3, 0, null, paramString2);
      }
      return;
    }
    if (!this.qQ.containsKey(paramString1))
    {
      this.qQ.put(paramString1, parama);
      this.qP.put(paramString1, paramString2);
    }
    ThreadManager.post(new TroopHWFileDownloadManager.1(this, paramString1, str), 5, null, true);
  }
  
  public void destroy(Context paramContext)
  {
    this.b.unRegisterDownloadTaskListener(this.c);
    TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext()).releaseDownloadSDKClient(this.mKey);
  }
  
  public void pauseDownloadTask(String paramString)
  {
    ThreadManager.post(new TroopHWFileDownloadManager.2(this, paramString), 5, null, true);
  }
  
  public static abstract interface a
  {
    public abstract void f(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
    
    public abstract void onProgress(String paramString, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjt
 * JD-Core Version:    0.7.0.1
 */