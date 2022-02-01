package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import apmj;
import assi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import jqc;
import org.json.JSONException;
import org.json.JSONObject;

class AddFriendVerifyActivity$23
  implements Runnable
{
  AddFriendVerifyActivity$23(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void run()
  {
    int i = AddFriendVerifyActivity.d(this.this$0);
    Object localObject = "{\"m\":0,\"source\":\"joinTroop\", \"gc\":" + this.this$0.mTroopUin + "}";
    this.this$0.mHandler.sendEmptyMessage(1);
    for (;;)
    {
      try
      {
        AddFriendVerifyActivity.b(this.this$0, true);
        AddFriendVerifyActivity.a(this.this$0, "");
        String str = apmj.b(this.this$0.app.getCurrentAccountUin(), "https://admin.qun.qq.com/cgi-bin/qun_admin/upload_msg_img", this.val$path, (String)localObject, "", assi.n(this.this$0.app), apmj.cpY);
        if (i != AddFriendVerifyActivity.e(this.this$0))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.w("AddFriendVerifyActivity", 2, "uploadImage task cancelled.");
          return;
        }
        AddFriendVerifyActivity.b(this.this$0, false);
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          localObject = jqc.dR(str);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        localObject = new JSONObject((String)localObject);
        i = ((JSONObject)localObject).optInt("ec", -1);
        if (i != 0) {
          continue;
        }
        AddFriendVerifyActivity.a(this.this$0, ((JSONObject)localObject).optLong("gc"));
        AddFriendVerifyActivity.c(this.this$0, ((JSONObject)localObject).optInt("fileid"));
        AddFriendVerifyActivity.b(this.this$0, ((JSONObject)localObject).optString("md5"));
        AddFriendVerifyActivity.a(this.this$0, ((JSONObject)localObject).optString("url"));
      }
      catch (InterruptedException localInterruptedException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage exception:" + localInterruptedException.getMessage());
        continue;
        this.this$0.mHandler.sendEmptyMessage(3);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage error.");
        continue;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage json exception:" + localJSONException.getMessage());
        continue;
      }
      this.this$0.mHandler.sendEmptyMessage(2);
      return;
      this.this$0.mHandler.sendEmptyMessage(3);
      if (QLog.isColorLevel()) {
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage error. ec:" + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.23
 * JD-Core Version:    0.7.0.1
 */