package com.tencent.qqmail.nativepages;

import android.content.Context;
import com.tencent.moai.nativepages.util.AppInfoUtil.AppOperationDelegate;
import com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;

public class NativePageAppOperationDelegate
  implements AppInfoUtil.AppOperationDelegate
{
  public boolean downloadApp(Context paramContext, String paramString1, String paramString2)
  {
    QMAttachUtils.goToDownload(paramContext, paramString1, 2, paramString2, null);
    return true;
  }
  
  public boolean isAppInstalled(Context paramContext, String paramString)
  {
    return DeviceUtil.isAppInstalled(paramString);
  }
  
  public boolean openApp(Context paramContext, String paramString)
  {
    return IntentUtil.openApp(paramString);
  }
  
  public boolean openUrl(Context paramContext, String paramString)
  {
    paramContext.startActivity(WebViewExplorer.createIntent(paramString, null, 0, false));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.nativepages.NativePageAppOperationDelegate
 * JD-Core Version:    0.7.0.1
 */