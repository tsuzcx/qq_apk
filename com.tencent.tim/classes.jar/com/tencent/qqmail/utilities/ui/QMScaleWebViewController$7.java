package com.tencent.qqmail.utilities.ui;

import com.tencent.qqmail.model.mail.loader.MailContentLoader;
import com.tencent.qqmail.model.mail.loader.MailContentLoaderCallback;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class QMScaleWebViewController$7
  implements MailContentLoaderCallback
{
  QMScaleWebViewController$7(QMScaleWebViewController paramQMScaleWebViewController) {}
  
  public void onError(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (QMScaleWebViewController.access$000(this.this$0) == null) {
          break label270;
        }
        String str = MailContentLoader.transformUrl(paramString1);
        paramString2 = str.replace("localhost", "");
        if (!QMScaleWebViewController.access$200(this.this$0).containsValue(paramString2)) {
          break label270;
        }
        int i = 0;
        paramString1 = "";
        Object localObject1 = QMScaleWebViewController.access$200(this.this$0).keySet().iterator();
        Object localObject2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (((String)QMScaleWebViewController.access$200(this.this$0).get(localObject2)).equals(paramString2))
          {
            StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
            int j = i + 1;
            if (i <= 0) {
              break label264;
            }
            paramString1 = ",|,";
            paramString1 = paramString1 + (String)localObject2;
            i = j;
          }
        }
        else
        {
          if (i <= 0) {
            break label270;
          }
          localObject1 = this.this$0;
          localObject2 = new StringBuilder().append("loadImage");
          if (i <= 1) {
            break label271;
          }
          paramString2 = "s";
          paramString2 = ((StringBuilder)localObject2).append(paramString2).append("(\"").append(paramString1).append("\",\"file:///android_res/drawable/imagefault_placeholder.png\", ");
          if (str.indexOf("/cgi-bin/viewfile") > -1)
          {
            paramString1 = "true";
            ((QMScaleWebViewController)localObject1).execJs(paramString1 + ")");
            return;
          }
          paramString1 = "false";
          continue;
        }
        continue;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QMLog.log(6, "QMScaleWebViewCtrlr", paramString1.toString());
        return;
      }
      label264:
      paramString1 = "";
      continue;
      label270:
      return;
      label271:
      paramString2 = "";
    }
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (QMScaleWebViewController.access$000(this.this$0) == null) {
          break;
        }
        String str = MailContentLoader.transformUrl(paramString1).replace("localhost", "");
        if (!QMScaleWebViewController.access$200(this.this$0).containsValue(str)) {
          break;
        }
        int i = 0;
        paramString1 = "";
        Object localObject1 = QMScaleWebViewController.access$200(this.this$0).keySet().iterator();
        Object localObject2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (((String)QMScaleWebViewController.access$200(this.this$0).get(localObject2)).equals(str))
          {
            StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
            int j = i + 1;
            if (i <= 0) {
              break label292;
            }
            paramString1 = ",|,";
            paramString1 = paramString1 + (String)localObject2;
            i = j;
          }
        }
        else
        {
          if (i <= 0) {
            break;
          }
          str = paramString2;
          if (!paramString2.equals("")) {
            str = ImageUtil.checkPathSuffix(paramString2);
          }
          QMLog.log(4, "QMScaleWebViewCtrlr", "loadImage:" + str);
          localObject1 = this.this$0;
          localObject2 = new StringBuilder().append("loadImage");
          if (i > 1)
          {
            paramString2 = "s";
            ((QMScaleWebViewController)localObject1).execJs(paramString2 + "(\"" + paramString1 + "\",\"file://" + str + "\")");
            return;
          }
          paramString2 = "";
          continue;
        }
        continue;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QMLog.log(6, "QMScaleWebViewCtrlr", paramString1.toString());
        return;
      }
      label292:
      paramString1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.7
 * JD-Core Version:    0.7.0.1
 */