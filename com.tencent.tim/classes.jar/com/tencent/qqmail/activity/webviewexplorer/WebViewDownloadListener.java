package com.tencent.qqmail.activity.webviewexplorer;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUrlUtil;

public class WebViewDownloadListener
  implements DownloadListener
{
  public static final String TAG = "WebViewDownloadListener";
  private Context context;
  
  public WebViewDownloadListener(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    String str2 = QMUrlUtil.getHost(paramString1);
    String str1 = CookieManager.getInstance().getCookie(paramString1);
    QMLog.log(4, "WebViewDownloadListener", "url = " + paramString1 + " host = " + str2 + " contentDisposition = " + paramString3 + " cookie = " + str1);
    try
    {
      paramString2 = paramString1.replaceAll("\\?.*$", "").replaceAll("^https?://[^/]*/?", "");
      int i = paramString2.lastIndexOf("/");
      paramString4 = paramString2;
      if (i != -1) {
        paramString4 = paramString2.substring(i);
      }
      paramString2 = paramString4;
      if (paramString4.length() == 0) {
        paramString2 = "Untitled";
      }
      paramString4 = paramString2;
      if (str2.endsWith("gz.fs.163.com"))
      {
        paramString4 = paramString2;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString3 = paramString3.split("\"");
          paramString4 = paramString2;
          if (paramString3.length >= 2) {
            paramString4 = paramString3[1];
          }
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString4 = "Untitled";
      }
    }
    QMAttachUtils.goToDownload(this.context, paramString1, 2, paramString4, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewDownloadListener
 * JD-Core Version:    0.7.0.1
 */