package com.tencent.mobileqq.apollo.lightGame;

import affz;
import afjy;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import auru;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;

public class CmGameFragment
  extends WebViewFragment
  implements Handler.Callback
{
  private boolean Yp;
  private boolean bDR;
  private auru l = new auru(Looper.getMainLooper(), this);
  private Bundle mReqBundle;
  
  private void br(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, new Object[] { "[sendStatus] isAlive=", Boolean.valueOf(paramBoolean1), ", wakeup=", Boolean.valueOf(paramBoolean2) });
    }
    if (paramBoolean1) {
      this.bDR = true;
    }
    this.mReqBundle.clear();
    this.mReqBundle.putBoolean("isAlive", paramBoolean1);
    this.mReqBundle.putBoolean("wakeup", paramBoolean2);
    Bundle localBundle = affz.a("ipc_cm_game_match_page_report_status", "", 0, this.mReqBundle);
    afjy.a().cr(localBundle);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Message localMessage;
    switch (paramMessage.what)
    {
    default: 
    case 16: 
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameConn_CmGameFragment", 2, new Object[] { "[handleMessage] check service, mIsDestroy=", Boolean.valueOf(this.Yp) });
        }
      } while (this.Yp);
      if (!afjy.a().ajq())
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameConn_CmGameFragment", 2, "[handleMessage] service not binded");
        }
        this.l.sendEmptyMessageDelayed(16, 100L);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmGameConn_CmGameFragment", 2, "[handleMessage] service binded");
      }
      this.l.removeMessages(32);
      localMessage = this.l.obtainMessage(32);
      localMessage.obj = Boolean.valueOf(true);
      paramMessage.arg1 = 1;
      this.l.sendMessage(localMessage);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, new Object[] { "[handleMessage] MSG_REPORT_STATUS, isAlive=", paramMessage.obj, ", wakeup=", Integer.valueOf(paramMessage.arg1) });
    }
    boolean bool2 = ((Boolean)paramMessage.obj).booleanValue();
    if (paramMessage.arg1 == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      br(bool2, bool1);
      if (!bool2) {
        break;
      }
      this.l.removeMessages(32);
      localMessage = this.l.obtainMessage(32);
      localMessage.obj = Boolean.valueOf(true);
      paramMessage.arg1 = 0;
      this.l.sendMessageDelayed(localMessage, 120000L);
      return false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, "[onCreate]");
    }
    this.mReqBundle = new Bundle();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, "[onDestroy]");
    }
    this.Yp = true;
    this.l.removeMessages(16);
    if (this.bDR)
    {
      this.l.removeMessages(32);
      Message localMessage = this.l.obtainMessage(32);
      localMessage.obj = Boolean.valueOf(false);
      this.l.sendMessage(localMessage);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, "[onPause]");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, "[onResume]");
    }
    try
    {
      if (!afjy.a().ajq())
      {
        QLog.w("CmGameConn_CmGameFragment", 1, "[onResume] ipc not binded");
        this.l.sendEmptyMessage(16);
        return;
      }
      QLog.d("CmGameConn_CmGameFragment", 2, "[onResume] ipc binded");
      this.l.removeMessages(32);
      Message localMessage = this.l.obtainMessage(32);
      localMessage.obj = Boolean.valueOf(true);
      localMessage.arg1 = 1;
      this.l.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmGameConn_CmGameFragment", 1, "[onResume] exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameFragment
 * JD-Core Version:    0.7.0.1
 */