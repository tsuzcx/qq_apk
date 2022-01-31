package com.tencent.mobileqq.troop.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class TroopLocationActivity$UIHandler
  extends Handler
{
  private WeakReference a;
  
  public TroopLocationActivity$UIHandler(TroopLocationActivity paramTroopLocationActivity)
  {
    this.a = new WeakReference(paramTroopLocationActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TroopLocationActivity localTroopLocationActivity = (TroopLocationActivity)this.a.get();
    if (localTroopLocationActivity == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      localTroopLocationActivity.a(false);
      return;
    case 3: 
      localTroopLocationActivity.a.B();
      return;
    }
    TroopLocationActivity.a(localTroopLocationActivity);
    localTroopLocationActivity.a.B();
    localTroopLocationActivity.a(1, localTroopLocationActivity.getString(2131363366));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopLocationActivity.UIHandler
 * JD-Core Version:    0.7.0.1
 */