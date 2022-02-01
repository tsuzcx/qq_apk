package com.tencent.androidqqmail.tim;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import cooperation.mailplugin.ipc.IMailRemoteInterface.Stub;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class MailPluginService$1
  extends IMailRemoteInterface.Stub
{
  MailPluginService$1(MailPluginService paramMailPluginService) {}
  
  public boolean transfer(String paramString, Bundle paramBundle)
    throws RemoteException
  {
    Log.i("MailPluginService", "log cmd=" + paramString + ", data=" + paramBundle + " isAppOnForeground = " + AppStatusUtil.isAppOnForeground());
    QMLog.log(4, "MailPluginService", "cmd=" + paramString + ", data=" + paramBundle);
    if ("cmd_get_unread".equals(paramString)) {
      QMMailManager.sharedInstance().syncAllProtocalAccount();
    }
    do
    {
      return true;
      if ("cmd_preload".equals(paramString))
      {
        TimNotificationManager.getInstance().notifyPreloadFinished();
        return true;
      }
      if ("cmd_bind_list".equals(paramString))
      {
        paramString = (HashMap)paramBundle.getSerializable("bindMailList");
        if (paramString == null)
        {
          Log.i("MailPluginService", "map is null");
          return true;
        }
        Log.i("MailPluginService", "map keys " + paramString.keySet());
        TimMailLoginManager.syncAccountList = paramString.keySet();
        SharedPreferenceUtil.setSyncAccountList(paramString.keySet());
        return true;
      }
    } while (!"cmd_send_mail".equals(paramString));
    paramString = paramBundle.getString("mail_subject");
    String str = paramBundle.getCharSequence("mail_text").toString();
    ArrayList localArrayList = (ArrayList)paramBundle.getSerializable("mail_pic_path");
    paramBundle = (ArrayList)paramBundle.getSerializable("mail_attachment_path");
    Log.i("MailPluginService", " subject=" + paramString + " content = " + str);
    if (localArrayList != null) {
      Log.i("MailPluginService", "inline_imgs " + Arrays.toString(localArrayList.toArray()));
    }
    if (paramBundle != null) {
      Log.i("MailPluginService", "attaches " + Arrays.toString(paramBundle.toArray()));
    }
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    if ((localAccountList.isEmpty()) || (localAccountList.getDefaultMailAccount() == null))
    {
      Log.i("MailPluginService", "find default account fail");
      return true;
    }
    paramString = ComposeMailActivity.createIntentFromTimChatRecord(localAccountList.getDefaultMailAccount().getId(), paramString, str, localArrayList, paramBundle);
    paramString.addFlags(268468224);
    this.this$0.startActivity(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MailPluginService.1
 * JD-Core Version:    0.7.0.1
 */