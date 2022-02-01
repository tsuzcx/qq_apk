package com.tencent.mobileqq.app;

import acll;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class SecSvcHandler$1
  implements Runnable
{
  public SecSvcHandler$1(acll paramacll, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent(this.this$0.app.getApp(), NotificationActivity.class);
      localIntent.putExtra("type", 11);
      Bundle localBundle = new Bundle();
      localBundle.putString("dlg_title", this.bpd);
      localBundle.putString("dlg_content", this.bpe);
      localBundle.putString("dlg_lbutton", this.bpf);
      localBundle.putString("dlg_rbutton", this.bpg);
      localBundle.putString("dlg_url", this.bph);
      localBundle.putInt("dlg_lbtnid", this.bIS);
      localBundle.putInt("dlg_rbtnid", this.bIR);
      localBundle.putInt("dlg_seccmd", this.cya);
      localIntent.putExtras(localBundle);
      localIntent.setFlags(872415232);
      if (!this.this$0.app.isBackground_Stop) {
        this.this$0.app.getApp().startActivity(localIntent);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcHandler.1
 * JD-Core Version:    0.7.0.1
 */