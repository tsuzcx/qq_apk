package com.tencent.av.ui;

import SharpSvrPack.SharpVideoMsg;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import anpc;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import igv;
import ihk;
import ihk.a;
import iiv;
import ikn;
import ikp;
import java.util.HashMap;
import jkq;
import mqq.app.AccountNotMatchException;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.app.Packet;

public class VChatActivity
  extends BaseActivity
{
  private boolean XY;
  public VideoController a;
  public VideoAppInterface mApp;
  
  private void a(FromServiceMsg paramFromServiceMsg, String paramString)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getWupBuffer() != null) && ("SharpSvr.s2c".equalsIgnoreCase(paramString))) {}
    try
    {
      SharpVideoMsg localSharpVideoMsg = (SharpVideoMsg)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
      ihk.a locala;
      String str1;
      String str2;
      int i;
      if (localSharpVideoMsg != null)
      {
        locala = ihk.a(localSharpVideoMsg.video_buff);
        if ((locala != null) && (locala.sD()))
        {
          ikp.kQ(34);
          str1 = String.valueOf(locala.kY);
          str2 = igv.a(3, str1, new int[0]);
          iiv localiiv = igv.a().c(str2);
          QLog.d("VChatActivity", 1, "onCreate--onRequestVideo,  VideoPacket[" + locala + "], session[" + localiiv + "]");
          if (localiiv == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("tagSharpSvr", 2, "<-- VChatActivity cmd = " + paramString + " , msg_type = " + localSharpVideoMsg.msg_type + ", bodyType = " + locala.alZ);
            }
            jkq.a("VChatActivity", str2, this.mApp, locala);
            paramFromServiceMsg = paramFromServiceMsg.getAttribute("__timestamp_net2msf");
            if (paramFromServiceMsg != null)
            {
              long l = ((Long)paramFromServiceMsg).longValue();
              this.a.l(str1, l);
            }
            i = locala.amc;
            paramFromServiceMsg = jkq.a(locala);
            if (locala.amb != 1) {
              break label320;
            }
          }
        }
      }
      label320:
      for (boolean bool = true;; bool = false)
      {
        this.a.a(i, str1, paramFromServiceMsg, null, bool, null, 0, locala.ama);
        paramFromServiceMsg = igv.a().c(str2);
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.bP(locala.roomId);
        }
        return;
      }
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  private void kg(String paramString)
  {
    try
    {
      MobileQQ.sMobileQQ.getAppRuntime(paramString);
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      do
      {
        QLog.d("VChatActivity", 1, "AV_UIN_NOT_MATCH, MSFUIN: " + paramString + " AVUIN:" + this.mApp.getCurrentAccountUin());
        HashMap localHashMap = new HashMap();
        localHashMap.put("avuin", this.mApp.getCurrentAccountUin());
        localHashMap.put("msfuin", String.valueOf(paramString));
        anpc.a(super.getApplicationContext()).collectPerformance(this.mApp.getCurrentAccountUin(), "AV_UIN_NOT_MATCH", false, 0L, 0L, localHashMap, "", true);
      } while (paramString.equals("0"));
      this.mApp.iA(paramString);
    }
  }
  
  public void M(long paramLong, int paramInt)
  {
    QLog.w("VChatActivity", 1, "exitVideoProcess, reason[" + paramInt + "], seq[" + paramLong + "]");
    super.finish();
    if (this.a != null) {
      return;
    }
    this.mApp.q(paramLong, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("VChatActivity", 1, "onCreate()");
    if ((super.getAppRuntime() instanceof VideoAppInterface)) {
      this.mApp = ((VideoAppInterface)super.getAppRuntime());
    }
    if (this.mApp == null)
    {
      QLog.d("VChatActivity", 1, "onCreate mApp is null! ");
      super.finish();
    }
    String str;
    FromServiceMsg localFromServiceMsg;
    do
    {
      return;
      this.mApp.hZ(false);
      this.XY = false;
      this.a = this.mApp.b();
      paramBundle = super.getIntent();
      str = paramBundle.getStringExtra("uin");
      localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelableExtra("fromServiceMsg");
      paramBundle = null;
      if (localFromServiceMsg != null) {
        paramBundle = localFromServiceMsg.getServiceCmd();
      }
      QLog.d("VChatActivity", 1, "onCreate fromServiceMsg =  " + localFromServiceMsg + ",cmd = " + paramBundle);
    } while (str == null);
    kg(str);
    a(localFromServiceMsg, paramBundle);
    super.finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("VChatActivity", 1, "onDestroy()");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    super.finish();
    long l = AudioHelper.hG();
    QLog.w("VChatActivity", 1, "exit when KEYCODE_BACK, seq[" + l + "]");
    M(l, 1009);
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d("VChatActivity", 1, "onNewIntent()");
    ikn.ans();
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.d("VChatActivity", 1, "onPause()");
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("VChatActivity", 1, "onResume()  mIsEffectiveRequest = " + this.XY);
    if (!this.XY) {
      super.finish();
    }
  }
  
  public void onStop()
  {
    QLog.d("VChatActivity", 1, "onStop()");
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VChatActivity
 * JD-Core Version:    0.7.0.1
 */