package com.tencent.androidqqmail.tim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class RouteActivity
  extends Activity
{
  public static final String TAG = "RouteActivity";
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getIntent().getExtras();
    if (localObject == null)
    {
      finish();
      return;
    }
    paramBundle = ((Bundle)localObject).getString("cmd");
    Log.i("RouteActivity", "recv cmd = " + paramBundle);
    if ("send_mail_chatrecord".equals(paramBundle))
    {
      paramBundle = ((Bundle)localObject).getString("mail_subject");
      String str = ((Bundle)localObject).getString("mail_text");
      ArrayList localArrayList = (ArrayList)((Bundle)localObject).getSerializable("mail_pic_path");
      localObject = (ArrayList)((Bundle)localObject).getSerializable("mail_attachment_path");
      Log.i("RouteActivity", " subject=" + paramBundle + " content = " + str);
      if (localArrayList != null) {
        Log.i("RouteActivity", "inline_imgs " + Arrays.toString(localArrayList.toArray()));
      }
      if (localObject != null) {
        Log.i("RouteActivity", "attaches " + Arrays.toString(((ArrayList)localObject).toArray()));
      }
      AccountList localAccountList = AccountManager.shareInstance().getAccountList();
      if ((localAccountList.isEmpty()) || (localAccountList.getDefaultMailAccount() == null))
      {
        Log.i("RouteActivity", "find default account fail");
        Toast.makeText(QMApplicationContext.sharedInstance(), "请先登录邮箱", 0).show();
        finish();
        return;
      }
      paramBundle = ComposeMailActivity.createIntentFromTimChatRecord(localAccountList.getDefaultMailAccount().getId(), paramBundle, str, localArrayList, (ArrayList)localObject);
      paramBundle.addFlags(268435456);
      startActivity(paramBundle);
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.RouteActivity
 * JD-Core Version:    0.7.0.1
 */