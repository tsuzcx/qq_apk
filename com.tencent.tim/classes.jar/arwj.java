import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public class arwj
  implements aryx
{
  protected static arwj a;
  protected arwi a;
  
  public static arwj a()
  {
    try
    {
      if (jdField_a_of_type_Arwj == null) {
        jdField_a_of_type_Arwj = new arwj();
      }
      arwj localarwj = jdField_a_of_type_Arwj;
      return localarwj;
    }
    finally {}
  }
  
  protected void V(Message paramMessage)
  {
    if (this.jdField_a_of_type_Arwi == null) {
      this.jdField_a_of_type_Arwi = new arwi();
    }
    this.jdField_a_of_type_Arwi.sendMessage(paramMessage);
  }
  
  public void a(Looper paramLooper)
  {
    this.jdField_a_of_type_Arwi = new arwi(paramLooper);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    arwt.v("NoticeListener", "onInstallSucceed ,appId" + paramString1);
    paramString1 = aryy.a().f(paramString2);
    if (paramString1 != null)
    {
      paramString2 = this.jdField_a_of_type_Arwi.obtainMessage();
      paramString2.what = 6;
      Bundle localBundle = new Bundle();
      localBundle.putString(aryv.PARAM_TICKET, paramString1.ticket);
      paramString2.setData(localBundle);
      V(paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    arwt.v("NoticeListener", "onDownloadError ,downloadInfo" + paramDownloadInfo);
    if ((paramDownloadInfo == null) || (paramDownloadInfo.downloadType == 1)) {}
    while (paramDownloadInfo.ddi) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Arwi.obtainMessage();
    localMessage.what = -2;
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_TICKET, paramDownloadInfo.ticket);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    localMessage.arg2 = paramInt2;
    V(localMessage);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    arwt.v("NoticeListener", "onDownloadFinish ");
    if ((paramDownloadInfo == null) || (paramDownloadInfo.downloadType == 1)) {}
    while (paramDownloadInfo.ddi) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Arwi.obtainMessage();
    localMessage.what = 4;
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_TICKET, paramDownloadInfo.ticket);
    localMessage.setData(localBundle);
    V(localMessage);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    do
    {
      return;
      arwt.v("NoticeListener", "onDownloadPause " + paramDownloadInfo.appId);
    } while ((paramDownloadInfo.downloadType == 1) || (paramDownloadInfo.ddi));
    Message localMessage = this.jdField_a_of_type_Arwi.obtainMessage();
    localMessage.what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_TICKET, paramDownloadInfo.ticket);
    localMessage.setData(localBundle);
    V(localMessage);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    arwt.v("NoticeListener", "onDownloadUpdate notify enter infos=" + paramList.size());
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
      Message localMessage = this.jdField_a_of_type_Arwi.obtainMessage();
      localMessage.what = 2;
      Bundle localBundle = new Bundle();
      localBundle.putString(aryv.PARAM_TICKET, localDownloadInfo.ticket);
      localMessage.setData(localBundle);
      V(localMessage);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.downloadType == 1)) {}
    while (paramDownloadInfo.ddi) {
      return;
    }
    arwt.v("NoticeListener", "onDownloadWait notify enter info.id=" + paramDownloadInfo.appId);
    Message localMessage = this.jdField_a_of_type_Arwi.obtainMessage();
    localMessage.what = 20;
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_TICKET, paramDownloadInfo.ticket);
    localMessage.setData(localBundle);
    V(localMessage);
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwj
 * JD-Core Version:    0.7.0.1
 */