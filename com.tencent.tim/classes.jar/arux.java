import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl.3;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class arux
{
  private static arux a;
  private ArrayList<arva> Dw = new ArrayList();
  private INetEventHandler d = new aruy(this);
  private aryx e = new aruz(this);
  
  public arux()
  {
    aryy.a().a(this.e);
    AppNetConnInfo.registerNetChangeReceiver(aroi.a().getContext(), this.d);
  }
  
  public static arux a()
  {
    if (a == null) {
      a = new arux();
    }
    return a;
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    int i = 1;
    int j = 0;
    Object localObject1;
    if (arxn.appIsExists(paramDownloadInfo.packageName))
    {
      if ((paramDownloadInfo.versionCode != 0) && (paramDownloadInfo.versionCode > arxn.fA("com.tencent.now"))) {}
      for (i = 0;; i = 1)
      {
        paramDownloadInfo.setState(13);
        localObject1 = this.Dw.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((arva)((Iterator)localObject1).next()).e(paramDownloadInfo, i);
        }
      }
    }
    DownloadInfo localDownloadInfo = aryy.a().c(paramDownloadInfo.appId);
    boolean bool;
    if ("com.tencent.now".equals(paramDownloadInfo.packageName))
    {
      bool = aifg.bc(paramDownloadInfo.appId, paramDownloadInfo.packageName);
      if (localDownloadInfo == null)
      {
        i = j;
        if (bool)
        {
          i = arxn.fB(aifg.wS());
          if ((paramDownloadInfo.versionCode != 0) && (paramDownloadInfo.versionCode > i)) {
            break label277;
          }
          localObject1 = new DownloadInfo(paramDownloadInfo.appId, paramDownloadInfo.urlStr, paramDownloadInfo.packageName, paramDownloadInfo.pushTitle, paramDownloadInfo.via, null, paramDownloadInfo.source, paramDownloadInfo.ddw);
          ((DownloadInfo)localObject1).setState(4);
          ((DownloadInfo)localObject1).filePath = aifg.wS();
          ((DownloadInfo)localObject1).ddi = paramDownloadInfo.ddi;
          aryy.a().j((DownloadInfo)localObject1);
          i = 1;
        }
      }
    }
    for (;;)
    {
      paramDownloadInfo.setState(13);
      localObject1 = this.Dw.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((arva)((Iterator)localObject1).next()).e(paramDownloadInfo, i);
      }
      label277:
      aifg.delete(aifg.wS());
      i = j;
      continue;
      localObject1 = localDownloadInfo.filePath;
      if ((aifg.mW((String)localObject1)) || (bool))
      {
        if (bool)
        {
          i = arxn.fB(aifg.wS());
          label321:
          if ((paramDownloadInfo.versionCode != 0) && (paramDownloadInfo.versionCode > i)) {
            break label427;
          }
          if (bool) {
            break label399;
          }
          if (aifg.r((String)localObject1, paramDownloadInfo.appId, paramDownloadInfo.packageName))
          {
            aifg.delete((String)localObject1);
            localDownloadInfo.filePath = aifg.wS();
          }
        }
        for (;;)
        {
          localDownloadInfo.setState(4);
          aryy.a().j(localDownloadInfo);
          i = 1;
          break;
          i = arxn.fB((String)localObject1);
          break label321;
          label399:
          if (!aifg.wS().equals(localObject1))
          {
            aifg.delete((String)localObject1);
            localDownloadInfo.filePath = aifg.wS();
          }
        }
        label427:
        aryy.a().dx(localDownloadInfo.appId, true);
        aifg.delete(aifg.wS());
        aifg.delete((String)localObject1);
        i = j;
      }
      else
      {
        i = j;
        if (localDownloadInfo.getState() == 4)
        {
          aryy.a().dx(localDownloadInfo.appId, true);
          i = j;
          continue;
          if (localDownloadInfo != null)
          {
            Object localObject2 = "";
            TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
            if (TextUtils.isEmpty(localDownloadInfo.filePath)) {
              if (localDownloadInfo.downloadType == 0)
              {
                localTMAssistantDownloadTaskInfo2 = aryy.a().b(localDownloadInfo.urlStr);
                localObject1 = localObject2;
                if (localTMAssistantDownloadTaskInfo2 != null)
                {
                  localObject1 = localObject2;
                  if (localTMAssistantDownloadTaskInfo2.mState == 4) {
                    localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
                  }
                }
                localObject2 = localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localTMAssistantDownloadTaskInfo1 = aryy.a().a(localDownloadInfo);
                  localObject2 = localObject1;
                }
                label581:
                localObject1 = localObject2;
                if (localTMAssistantDownloadTaskInfo1 != null)
                {
                  localObject1 = localObject2;
                  if (localTMAssistantDownloadTaskInfo1.mState == 4) {
                    localObject1 = localTMAssistantDownloadTaskInfo1.mSavePath;
                  }
                }
                localObject2 = localObject1;
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localDownloadInfo.filePath = ((String)localObject1);
                  localDownloadInfo.setState(4);
                  aryy.a().j(localDownloadInfo);
                }
              }
            }
            for (localObject2 = localObject1;; localObject2 = localDownloadInfo.filePath)
            {
              if ((!aqmr.isEmpty((String)localObject2)) && (aifg.mW((String)localObject2))) {
                break label747;
              }
              i = 0;
              break;
              localTMAssistantDownloadTaskInfo2 = aryy.a().a(localDownloadInfo);
              localObject1 = localObject2;
              if (localTMAssistantDownloadTaskInfo2 != null)
              {
                localObject1 = localObject2;
                if (localTMAssistantDownloadTaskInfo2.mState == 4) {
                  localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
                }
              }
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                break label581;
              }
              localTMAssistantDownloadTaskInfo1 = aryy.a().b(localDownloadInfo.urlStr);
              localObject2 = localObject1;
              break label581;
            }
          }
          else
          {
            label747:
            i = 0;
          }
        }
      }
    }
    j = i;
    return j;
  }
  
  public void a(arva paramarva)
  {
    if ((paramarva != null) && (this.Dw != null) && (!this.Dw.contains(paramarva))) {
      this.Dw.add(paramarva);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    aryy.a().a(paramDownloadInfo, paramApkUpdateDetail);
  }
  
  public void b(arva paramarva)
  {
    if (this.Dw != null) {
      this.Dw.remove(paramarva);
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if (aifg.bc(paramDownloadInfo.appId, paramDownloadInfo.packageName))
    {
      paramDownloadInfo.setState(4);
      paramDownloadInfo.filePath = aifg.wS();
      aryy.a().j(paramDownloadInfo);
      this.e.onDownloadFinish(paramDownloadInfo);
      return;
    }
    aryy.a().b(paramDownloadInfo);
  }
  
  public DownloadInfo c(String paramString)
  {
    return aryy.a().c(paramString);
  }
  
  public void cancelDownload(String paramString)
  {
    DownloadInfo localDownloadInfo = aryy.a().c(paramString);
    aryy.a().dx(paramString, true);
    aryy.a().b(10, localDownloadInfo);
  }
  
  public void iI(String paramString1, String paramString2)
  {
    DownloadInfo localDownloadInfo = aryy.a().c(paramString1);
    paramString1 = localDownloadInfo;
    if (localDownloadInfo == null) {
      paramString1 = aryy.a().f(paramString2);
    }
    if (paramString1 != null)
    {
      paramString1.ekZ = 5;
      paramString1.downloadType = 0;
      paramString1.elk = 0;
      aryy.a().y(paramString1);
    }
  }
  
  public void pauseDownload(String paramString)
  {
    aryy.a().fw(paramString);
  }
  
  public int v(ArrayList<DownloadInfo> paramArrayList)
  {
    if (paramArrayList == null)
    {
      arwt.v("DownloadCenterImpl", "getDownloadProgressById infos == null");
      return -1;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadCenterImpl.3(this, paramArrayList));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arux
 * JD-Core Version:    0.7.0.1
 */