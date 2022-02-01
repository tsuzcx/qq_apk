package com.tencent.mobileqq.app;

import accy;
import amhj;
import anpc;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigHandler$6
  implements Runnable
{
  public ConfigHandler$6(accy paramaccy, String paramString, amhj paramamhj, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = new File(this.this$0.app.getApplication().getFilesDir(), "rich_status.tmp");
    Object localObject2 = MsfSdkUtils.insertMtype("ConfigCheck", this.val$url);
    int i = HttpDownloadUtil.a(this.this$0.app, (String)localObject2, (File)localObject1);
    if (QLog.isColorLevel()) {
      QLog.w("Q.richstatus.xml", 2, "handleUpdateStatusActions download " + this.val$url + " result " + i);
    }
    String str;
    if (i == 0) {
      if (this.jdField_c_of_type_Amhj.a((File)localObject1, this.jdField_c_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer))
      {
        this.this$0.notifyUI(7, true, Integer.valueOf(102));
        localObject1 = anpc.a(BaseApplication.getContext());
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("result", String.valueOf(i));
        ((HashMap)localObject2).put("version", String.valueOf(this.jdField_c_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer));
        ((HashMap)localObject2).put("url", this.val$url);
        str = this.this$0.app.getCurrentAccountUin();
        if (i != 0) {
          break label327;
        }
      }
    }
    for (;;)
    {
      ((anpc)localObject1).collectPerformance(str, "RichStatusAction", bool, 0L, 0L, (HashMap)localObject2, "");
      return;
      this.this$0.notifyUI(7, false, Integer.valueOf(-3));
      break;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.xml", 2, "httpdownload failed: " + this.val$url + ", result " + i);
      }
      if ((i == 4) || (i == 12))
      {
        this.this$0.notifyUI(7, false, Integer.valueOf(-3));
        break;
      }
      this.this$0.notifyUI(7, false, Integer.valueOf(-1));
      break;
      label327:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.6
 * JD-Core Version:    0.7.0.1
 */