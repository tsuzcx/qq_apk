import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public class asae
  implements aryx
{
  protected static asae a;
  protected asag a;
  
  public static asae a()
  {
    try
    {
      if (jdField_a_of_type_Asae == null) {
        jdField_a_of_type_Asae = new asae();
      }
      asae localasae = jdField_a_of_type_Asae;
      return localasae;
    }
    finally {}
  }
  
  public void a(Looper paramLooper)
  {
    this.jdField_a_of_type_Asag = new asag(paramLooper);
  }
  
  protected void aT(Message paramMessage)
  {
    if (this.jdField_a_of_type_Asag == null) {
      this.jdField_a_of_type_Asag = new asag();
    }
    this.jdField_a_of_type_Asag.sendMessage(paramMessage);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    arwt.v("NoticeDownloadListener", "onInstallSucceed ,appId" + paramString1);
    paramString1 = aryy.a().f(paramString2);
    if (paramString1 != null)
    {
      paramString2 = this.jdField_a_of_type_Asag.obtainMessage();
      paramString2.what = 6;
      Bundle localBundle = new Bundle();
      localBundle.putString(aryv.PARAM_SNG_APPID, paramString1.appId);
      paramString2.setData(localBundle);
      aT(paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    arwt.v("NoticeDownloadListener", "onDownloadError ,downloadInfo" + paramDownloadInfo);
    if ((paramDownloadInfo == null) || (paramDownloadInfo.downloadType == 1)) {}
    while (paramDownloadInfo.ddi) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Asag.obtainMessage();
    localMessage.what = -2;
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramDownloadInfo.appId);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    localMessage.arg2 = paramInt2;
    aT(localMessage);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    arwt.v("NoticeDownloadListener", "onDownloadFinish ");
    if ((paramDownloadInfo == null) || (paramDownloadInfo.downloadType == 1)) {}
    while (paramDownloadInfo.ddi) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Asag.obtainMessage();
    localMessage.what = 4;
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramDownloadInfo.appId);
    localMessage.setData(localBundle);
    aT(localMessage);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    do
    {
      return;
      arwt.v("NoticeDownloadListener", "onDownloadPause " + paramDownloadInfo.appId);
    } while ((paramDownloadInfo.downloadType == 1) || (paramDownloadInfo.ddi));
    Message localMessage = this.jdField_a_of_type_Asag.obtainMessage();
    localMessage.what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramDownloadInfo.appId);
    localMessage.setData(localBundle);
    aT(localMessage);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    arwt.v("NoticeDownloadListener", "onDownloadUpdate notify enter infos=" + paramList.size());
    paramList = paramList.iterator();
    for (;;)
    {
      DownloadInfo localDownloadInfo;
      if (paramList.hasNext())
      {
        localDownloadInfo = (DownloadInfo)paramList.next();
        if ((localDownloadInfo == null) || (localDownloadInfo.downloadType == 1)) {
          continue;
        }
        if (!localDownloadInfo.ddi) {}
      }
      else
      {
        return;
      }
      Message localMessage = this.jdField_a_of_type_Asag.obtainMessage();
      localMessage.what = 2;
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", localDownloadInfo.appId);
      localMessage.setData(localBundle);
      aT(localMessage);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.downloadType == 1)) {}
    while (paramDownloadInfo.ddi) {
      return;
    }
    Object localObject2 = new StringBuilder().append("onDownloadWait notify enter info.id=");
    if (paramDownloadInfo == null) {}
    for (Object localObject1 = "";; localObject1 = paramDownloadInfo.appId)
    {
      arwt.v("NoticeDownloadListener", (String)localObject1);
      localObject1 = this.jdField_a_of_type_Asag.obtainMessage();
      ((Message)localObject1).what = 20;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("appId", paramDownloadInfo.appId);
      ((Message)localObject1).setData((Bundle)localObject2);
      aT((Message)localObject1);
      return;
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asae
 * JD-Core Version:    0.7.0.1
 */