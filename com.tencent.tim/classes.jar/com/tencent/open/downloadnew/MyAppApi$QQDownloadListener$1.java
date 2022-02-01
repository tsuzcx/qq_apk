package com.tencent.open.downloadnew;

import arvv;
import arwt;
import aryy;
import arzk;
import arzk.e;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class MyAppApi$QQDownloadListener$1
  implements Runnable
{
  public MyAppApi$QQDownloadListener$1(arzk.e parame, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = null;
    int i;
    aryy localaryy;
    DownloadInfo localDownloadInfo;
    if (this.e != null)
    {
      arwt.v("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + this.val$state + " errorCode=" + this.val$errorCode + " param SNGAppId=" + this.e.SNGAppId + " apkId=" + this.e.taskApkId + " taskAppId=" + this.e.taskAppId + " packageName=" + this.e.taskPackageName + " version=" + this.e.taskVersion + " uin=" + this.e.uin + " via=" + this.e.via);
      i = aryy.kO(this.val$state);
      arwt.d("State_Log", "onDownloadTaskStateChanged--localState = " + i + "state = " + this.val$state + "errorCode = " + this.val$errorCode);
      localaryy = aryy.a();
      localDownloadInfo = localaryy.b(this.e.SNGAppId, i);
      if ((localDownloadInfo != null) || (this.val$state == 6)) {
        break label413;
      }
      localDownloadInfo = this.a.this$0.a(this.e, null);
      localaryy.j(localDownloadInfo);
      localaryy.b(this.e.SNGAppId, i);
      localObject = null;
    }
    for (;;)
    {
      if (localDownloadInfo != null)
      {
        arwt.d("State_Log", "onDownloadTaskStateChanged notifyListener localState=" + i + " dlInfo=" + localDownloadInfo.toString());
        localaryy.a(i, localDownloadInfo, this.val$errorCode, this.val$errorMsg);
      }
      for (;;)
      {
        for (;;)
        {
          arvv.a().a(this.e, this.val$state, (TMAssistantCallYYBTaskInfo)localObject, this.val$errorCode, this.val$errorMsg);
          return;
          arwt.v("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + this.val$state + " errorCode=" + this.val$errorCode + " param== null");
          return;
          label413:
          if (((this.val$state != 2) && (this.val$state != 3)) || (!this.a.this$0.aHz())) {
            break label571;
          }
          try
          {
            TMAssistantCallYYBTaskInfo localTMAssistantCallYYBTaskInfo = this.a.this$0.a().getDownloadTaskState(this.e);
            if (localTMAssistantCallYYBTaskInfo != null)
            {
              localObject = localTMAssistantCallYYBTaskInfo;
              long l1 = localTMAssistantCallYYBTaskInfo.mReceiveDataLen;
              localObject = localTMAssistantCallYYBTaskInfo;
              long l2 = localTMAssistantCallYYBTaskInfo.mTotalDataLen;
              localObject = localTMAssistantCallYYBTaskInfo;
              int j = (int)((float)l1 * 100.0F / (float)l2);
              localObject = localTMAssistantCallYYBTaskInfo;
              localDownloadInfo.progress = j;
              localObject = localTMAssistantCallYYBTaskInfo;
              arwt.v("MyAppApi", "onDownloadTaskStateChanged info progress = " + j);
            }
            localObject = localTMAssistantCallYYBTaskInfo;
          }
          catch (Exception localException)
          {
            arwt.e("MyAppApi", "getDownloadTaskState>>>", localException);
          }
        }
        break;
        arwt.d("MyAppApi", "onDownloadTaskStateChanged notifyListener error dlInfo == null");
      }
      label571:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */