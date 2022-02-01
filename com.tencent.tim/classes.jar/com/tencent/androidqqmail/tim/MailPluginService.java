package com.tencent.androidqqmail.tim;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.qqmail.utilities.log.QMLog;
import cooperation.mailplugin.ipc.IMailRemoteInterface.Stub;

public class MailPluginService
  extends Service
{
  private static final String TAG = "MailPluginService";
  private IMailRemoteInterface.Stub mBinder = new MailPluginService.1(this);
  
  public MailPluginService()
  {
    QMLog.log(4, "MailPluginService", "MailPluginService");
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mBinder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MailPluginService
 * JD-Core Version:    0.7.0.1
 */