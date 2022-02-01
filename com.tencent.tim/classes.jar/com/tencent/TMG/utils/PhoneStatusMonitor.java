package com.tencent.TMG.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;

public class PhoneStatusMonitor
{
  static final String TAG = "PhoneStatusMonitor";
  Context mContext;
  boolean mIsCalling = false;
  PhoneStateListener mPhoneStateListener;
  PhoneStatusListener mPhoneStatusListener;
  PhoneStatusReceiver mPhoneStatusReceiver;
  
  public PhoneStatusMonitor(Context paramContext, PhoneStatusListener paramPhoneStatusListener)
  {
    this.mContext = paramContext;
    this.mPhoneStatusListener = paramPhoneStatusListener;
    this.mPhoneStateListener = new QQPhoneStateListener();
    this.mPhoneStatusReceiver = new PhoneStatusReceiver();
    PhoneStatusTools.listen(paramContext, this.mPhoneStateListener, 32);
    paramPhoneStatusListener = new IntentFilter();
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE2");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_2");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_EXT");
    paramPhoneStatusListener.addAction("android.intent.action.NEW_OUTGOING_CALL");
    paramContext.registerReceiver(this.mPhoneStatusReceiver, paramPhoneStatusListener);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
  }
  
  public boolean isCalling()
  {
    return this.mIsCalling;
  }
  
  public void uninit()
  {
    PhoneStatusTools.listen(this.mContext, this.mPhoneStateListener, 0);
    this.mContext.unregisterReceiver(this.mPhoneStatusReceiver);
    this.mPhoneStatusListener = null;
    this.mPhoneStatusReceiver = null;
    this.mPhoneStateListener = null;
    this.mContext = null;
  }
  
  public static abstract interface PhoneStatusListener
  {
    public abstract void onCallStateChanged(boolean paramBoolean);
  }
  
  class PhoneStatusReceiver
    extends BroadcastReceiver
  {
    PhoneStatusReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusMonitor", 0, "onReceive NEW_OUTGOING_CALL");
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("PhoneStatusMonitor", 0, "onReceive PHONE_STATE");
            }
            if ((!PhoneStatusMonitor.this.mIsCalling) || (PhoneStatusTools.isCalling(PhoneStatusMonitor.this.mContext))) {
              break;
            }
            PhoneStatusMonitor.this.mIsCalling = false;
          } while (PhoneStatusMonitor.this.mPhoneStatusListener == null);
          PhoneStatusMonitor.this.mPhoneStatusListener.onCallStateChanged(false);
          return;
        } while ((PhoneStatusMonitor.this.mIsCalling) || (!PhoneStatusTools.isCalling(PhoneStatusMonitor.this.mContext)));
        PhoneStatusMonitor.this.mIsCalling = true;
      } while (PhoneStatusMonitor.this.mPhoneStatusListener == null);
      PhoneStatusMonitor.this.mPhoneStatusListener.onCallStateChanged(true);
    }
  }
  
  class QQPhoneStateListener
    extends PhoneStateListener
  {
    QQPhoneStateListener() {}
    
    public void onCallStateChanged(int paramInt, String paramString)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        super.onCallStateChanged(paramInt, paramString);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusMonitor", 0, "onCallStateChanged CALL_STATE_IDLE");
        }
        if ((PhoneStatusMonitor.this.mIsCalling) && (!PhoneStatusTools.isCalling(PhoneStatusMonitor.this.mContext)))
        {
          PhoneStatusMonitor.this.mIsCalling = false;
          if (PhoneStatusMonitor.this.mPhoneStatusListener != null)
          {
            PhoneStatusMonitor.this.mPhoneStatusListener.onCallStateChanged(false);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("PhoneStatusMonitor", 0, "onCallStateChanged CALL_STATE_RINGING or CALL_STATE_OFFHOOK");
            }
            if (!PhoneStatusMonitor.this.mIsCalling)
            {
              PhoneStatusMonitor.this.mIsCalling = true;
              if (PhoneStatusMonitor.this.mPhoneStatusListener != null) {
                PhoneStatusMonitor.this.mPhoneStatusListener.onCallStateChanged(true);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.utils.PhoneStatusMonitor
 * JD-Core Version:    0.7.0.1
 */