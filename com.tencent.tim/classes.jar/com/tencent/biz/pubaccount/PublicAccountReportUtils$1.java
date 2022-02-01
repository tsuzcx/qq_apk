package com.tencent.biz.pubaccount;

import acja;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kbp;
import org.json.JSONObject;

public final class PublicAccountReportUtils$1
  implements Runnable
{
  public PublicAccountReportUtils$1(String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.val$r5;
    Object localObject = str;
    if (!TextUtils.isEmpty(this.Lw)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$r5);
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        if (localObject != null) {
          if (!((acja)((AppInterface)localObject).getManager(56)).f(Long.valueOf(this.Lw))) {
            break label135;
          }
        }
        label135:
        for (localObject = "1";; localObject = "0")
        {
          localJSONObject.put("fans", localObject);
          localObject = localJSONObject.toString();
          kbp.a(this.val$app, this.Lw, this.VN, this.val$actionName, this.lM, this.val$result, this.VO, this.VP, this.VQ, (String)localObject, this.adw);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.e("PublicAccountReportUtils", 2, "doVideoDataReportWithFansInfoInR5() error exception = " + localException.getMessage());
          localObject = str;
          continue;
          localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountReportUtils.1
 * JD-Core Version:    0.7.0.1
 */