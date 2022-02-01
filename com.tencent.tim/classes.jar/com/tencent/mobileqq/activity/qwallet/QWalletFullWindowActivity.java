package com.tencent.mobileqq.activity.qwallet;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import zyc;

public class QWalletFullWindowActivity
  extends QQTranslucentBrowserActivity
{
  public QWalletFullWindowActivity()
  {
    this.s = QWalletFullWindowFragment.class;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    sendBroadcast(new Intent("action_onpause"));
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    sendBroadcast(new Intent("action_onresume"));
  }
  
  public void onBackPressed()
  {
    sendBroadcast(new Intent("action_close_camera"));
  }
  
  public boolean showPreview()
  {
    boolean bool = super.showPreview();
    if (findViewById(2131363728) != null) {}
    return bool;
  }
  
  public static class QWalletFullWindowFragment
    extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
  {
    BroadcastReceiver aS = new zyc(this);
    
    public int a(Bundle paramBundle)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_close_camera");
      localIntentFilter.addAction("cn.abel.action.broadcast");
      BaseApplicationImpl.getApplication().registerReceiver(this.aS, localIntentFilter);
      return super.a(paramBundle);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      if (this.aS != null) {}
      try
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(this.aS);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletFullWindowActivity
 * JD-Core Version:    0.7.0.1
 */