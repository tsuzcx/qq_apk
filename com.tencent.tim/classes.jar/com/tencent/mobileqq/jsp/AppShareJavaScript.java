package com.tencent.mobileqq.jsp;

import aiim.a;
import aiim.b;
import aiju;
import android.content.Context;
import aqiz;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;

@Deprecated
public class AppShareJavaScript
  extends aiim.b
{
  private aiju a;
  private boolean inited;
  Context mContext;
  
  public AppShareJavaScript(Context paramContext)
  {
    this.mContext = paramContext;
    this.a = new aiju();
    try
    {
      Field localField = aiju.class.getDeclaredField("mContext");
      localField.setAccessible(true);
      localField.set(this.a, paramContext);
      this.inited = true;
      return;
    }
    catch (Exception paramContext)
    {
      QLog.d("QQApi", 2, "QQApi init error: " + paramContext.getMessage());
    }
  }
  
  public void call(String paramString, List<String> paramList, aiim.a parama)
  {
    if (!this.inited)
    {
      QLog.d("QQApi", 2, "QQApi not ready");
      return;
    }
    int i = paramList.size();
    for (;;)
    {
      try
      {
        if (("isAppInstalled".equals(paramString)) && (i == 1))
        {
          paramList = Boolean.valueOf(aqiz.isAppInstalled(this.mContext, (String)paramList.get(0)));
          parama.onComplete(paramList);
          return;
        }
      }
      catch (Exception paramList)
      {
        QLog.d("QQApi", 2, "error in QQApi." + paramString + ": " + paramList.getMessage());
        return;
      }
      if (("checkAppInstalled".equals(paramString)) && (i == 1))
      {
        paramList = aqiz.O(this.mContext, (String)paramList.get(0));
      }
      else if (("checkAppInstalledBatch".equals(paramString)) && (i == 1))
      {
        paramList = aqiz.P(this.mContext, (String)paramList.get(0));
      }
      else if (("isAppInstalledBatch".equals(paramString)) && (i == 1))
      {
        paramList = aqiz.Q(this.mContext, (String)paramList.get(0));
      }
      else if (("startAppWithPkgName".equals(paramString)) && (i == 1))
      {
        paramList = Boolean.valueOf(aqiz.r(this.mContext, (String)paramList.get(0), null));
      }
      else if (("startAppWithPkgNameAndOpenId".equals(paramString)) && (i == 2))
      {
        paramList = Boolean.valueOf(aqiz.r(this.mContext, (String)paramList.get(0), (String)paramList.get(1)));
      }
      else if (("getOpenidBatch".equals(paramString)) && (i == 1))
      {
        paramList = "";
      }
      else if (("launchAppWithTokens".equals(paramString)) && (i == 4))
      {
        this.a.k((String)paramList.get(0), (String)paramList.get(1), (String)paramList.get(2), (String)paramList.get(3), null, "");
        paramList = null;
      }
      else if (("getAppsVerionCodeBatch".equals(paramString)) && (i == 1))
      {
        paramList = aqiz.R(this.mContext, (String)paramList.get(0));
      }
      else if (("setShareURL".equals(paramString)) && (i == 1))
      {
        paramList = Boolean.valueOf(false);
      }
      else if (("setShareInfo".equals(paramString)) && (i == 1))
      {
        paramList = Boolean.valueOf(false);
      }
      else
      {
        if ((!"sendDocToChat".equals(paramString)) || (i != 1)) {
          break;
        }
        paramList = Boolean.valueOf(false);
      }
    }
    parama.dsA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AppShareJavaScript
 * JD-Core Version:    0.7.0.1
 */