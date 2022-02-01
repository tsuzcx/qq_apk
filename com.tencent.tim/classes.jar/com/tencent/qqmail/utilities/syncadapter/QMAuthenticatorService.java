package com.tencent.qqmail.utilities.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.qqmail.utilities.log.QMLog;

public class QMAuthenticatorService
  extends Service
{
  private static final String TAG = "QMAuthenticatorService";
  private QMAuthenticator mAuthenticator;
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mAuthenticator.getIBinder();
  }
  
  public void onCreate()
  {
    QMLog.log(4, "QMAuthenticatorService", "onCreate");
    super.onCreate();
    this.mAuthenticator = new QMAuthenticator(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.syncadapter.QMAuthenticatorService
 * JD-Core Version:    0.7.0.1
 */