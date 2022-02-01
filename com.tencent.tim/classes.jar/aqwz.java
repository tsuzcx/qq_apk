import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class aqwz
  extends aquy
{
  aqwz(aqwu paramaqwu, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onDone, status=" + paramaquz.getStatus() + ", task.errCode:" + paramaquz.errCode + ", key=" + paramaquz.key);
    }
    Bundle localBundle = paramaquz.getParams();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onDone Err0, key:" + paramaquz.key);
    }
    boolean bool;
    label121:
    do
    {
      return;
      if ((paramaquz.getStatus() != 3) || (paramaquz.errCode != 0)) {
        break;
      }
      bool = true;
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone fail, task.getStatus():" + paramaquz.getStatus() + ", task.errCode:" + paramaquz.errCode);
      }
    } while (localBundle.getInt("dealType") == 0);
    int i = localBundle.getInt("callId");
    int j = localBundle.getInt("resourceType");
    Object localObject = localBundle.getString("path");
    if (localBundle.getBoolean("isExists", false)) {}
    for (;;)
    {
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone rename failure. path:" + (String)localObject);
      }
      if ((localBundle.getBoolean("isIPC")) && (this.a.c != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fcStatus", 3);
        ((Bundle)localObject).putInt("callId", i);
        ((Bundle)localObject).putInt("srcType", localBundle.getInt("srcType"));
        ((Bundle)localObject).putBoolean("result_boo", bool);
        ((Bundle)localObject).putInt("resourceType", j);
        this.a.c.a(i, paramaquz.getStatus(), (Bundle)localObject);
      }
      if (9 != aqwu.getResourceType()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
      }
      paramaquz = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
      paramaquz.putExtra("fun_call_id", i);
      paramaquz.setPackage(this.a.mApp.getApp().getPackageName());
      this.a.mApp.getApp().sendBroadcast(paramaquz);
      return;
      bool = false;
      break label121;
      bool = aqhq.rename((String)localObject + ".tmp", (String)localObject);
    }
  }
  
  public void onProgress(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onProgress, loaded=" + paramaquz.atU + "percent=" + paramaquz.fj + ", key=" + paramaquz.key);
    }
    Bundle localBundle1 = paramaquz.getParams();
    if (localBundle1 == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onProgress Err0, key:" + paramaquz.key);
    }
    while ((localBundle1.getInt("dealType") == 0) || (!paramaquz.getParams().getBoolean("isIPC")) || (this.a.c == null)) {
      return;
    }
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("fcStatus", 2);
    localBundle2.putInt("callId", localBundle1.getInt("callId"));
    localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
    localBundle2.putInt("progress", (int)paramaquz.fj);
    localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
    this.a.c.onResponse(localBundle2);
  }
  
  public boolean onStart(aquz paramaquz)
  {
    Bundle localBundle = paramaquz.getParams();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onStart Err0, key:" + paramaquz.key);
    }
    int i;
    boolean bool;
    do
    {
      do
      {
        return true;
      } while (localBundle.getInt("dealType") == 0);
      i = localBundle.getInt("resourceType");
      bool = localBundle.getBoolean("isIPC");
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "onStart, loaded=" + paramaquz.atU + ", percent=" + paramaquz.fj + ", resType=" + i + ", isIPC=" + bool);
      }
    } while ((!bool) || (this.a.c == null));
    paramaquz = new Bundle();
    paramaquz.putInt("fcStatus", 1);
    paramaquz.putInt("callId", localBundle.getInt("callId"));
    paramaquz.putInt("srcType", localBundle.getInt("srcType"));
    paramaquz.putInt("resourceType", i);
    this.a.c.onResponse(paramaquz);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwz
 * JD-Core Version:    0.7.0.1
 */