package com.tencent.qqmini.sdk.launcher;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class MiniAppInfoLoadingFragment$2$1
  implements Runnable
{
  MiniAppInfoLoadingFragment$2$1(MiniAppInfoLoadingFragment.2 param2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    long l = this.val$ret.optLong("retCode");
    String str2 = this.val$ret.optString("errMsg");
    QMLog.e("MiniAppInfoLoadingFragment", "GetAppInfoByLink failed. retCode=" + l + " errMsg=" + str2);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "网络请求错误，无法加载";
    }
    MiniAppInfoLoadingFragment.access$200(this.this$1.this$0, str1, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment.2.1
 * JD-Core Version:    0.7.0.1
 */