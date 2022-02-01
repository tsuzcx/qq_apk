package com.tencent.mobileqq.contactsync.authenticator;

import aewe;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AuthenticationService
  extends Service
{
  private aewe a;
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a.getIBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = new aewe(this);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.authenticator.AuthenticationService
 * JD-Core Version:    0.7.0.1
 */