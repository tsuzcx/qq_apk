package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import aqfp;
import aqmq;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qphone.base.util.QLog;
import wja;

public class ChatActivity
  extends FragmentActivity
{
  private String TAG = "Q.aio.ChatActivity";
  private View hY;
  
  public void bI(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "switchToAio() called with: intent = [" + paramIntent + "]");
    }
    doOnNewIntent(paramIntent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null) {
      ((ChatFragment)localFragment).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (!onBackEvent()) {
      super.finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    ThreadRegulator.a().JW(1);
    aqmq.bU(null, "AIO_Start_cost");
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnCreate strat ");
    }
    aqfp.Sz(true);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (wja.a(this, this.app, true, getIntent())) {
      return false;
    }
    if (this.hY != null) {
      this.hY.setVisibility(0);
    }
    paramBundle = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramBundle != null)
    {
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.remove(paramBundle);
      localFragmentTransaction.add(16908290, ChatFragment.a(), ChatFragment.class.getName()).commit();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "doOnCreate f != null ");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "doOnCreate end ");
      }
      return true;
      getSupportFragmentManager().beginTransaction().add(16908290, ChatFragment.a(), ChatFragment.class.getName()).commit();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "doOnCreate f == null ");
      }
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "doOnDestroy ");
      }
      if (QLog.isColorLevel())
      {
        int i = URLDrawable.getPoolSize();
        QLog.i("URLDrawableOptions", 2, "URLDrawableOptions main size " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    ThreadRegulator.a().JW(1);
    aqmq.bU(null, "AIO_Start_cost");
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnNewIntent start ");
    }
    super.doOnNewIntent(paramIntent);
    if (wja.a(this, this.app, false, getIntent())) {}
    for (;;)
    {
      return;
      super.setIntent(paramIntent);
      paramIntent = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (paramIntent != null)
      {
        paramIntent.bJy();
        if (!paramIntent.isVisible())
        {
          FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
          localFragmentTransaction.show(paramIntent);
          localFragmentTransaction.commitAllowingStateLoss();
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "doOnNewIntent !cf.isVisible()");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "doOnNewIntent cf != null");
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d(this.TAG, 2, "doOnNewIntent end");
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "doOnNewIntent error cf == null");
        }
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnWindowFocusChanged");
    }
    if (paramBoolean)
    {
      ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localChatFragment != null) {
        localChatFragment.zZ(2);
      }
    }
  }
  
  public void finish()
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.sm(2);
    }
    super.finish();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    Intent localIntent = getIntent();
    if ((localChatFragment != null) && (localIntent != null))
    {
      if (localIntent.getIntExtra("entrance", 0) == 9) {
        setResult(0, localIntent);
      }
      return localChatFragment.onBackEvent();
    }
    return false;
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.onCreateDialog(paramInt);
    }
    return null;
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).onPostThemeChanged();
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).onPostThemeChanged();
    }
  }
  
  public void onPreThemeChanged()
  {
    super.onPreThemeChanged();
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null) {
      ((ChatFragment)localFragment).onPreThemeChanged();
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.onPrepareDialog(paramInt, paramDialog);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  public boolean showPreview()
  {
    SetSplash.a(this, null);
    getWindow().setFeatureInt(7, 2131559169);
    try
    {
      this.hY = ((View)findViewById(2131367153).getParent());
      this.hY.setVisibility(8);
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivity
 * JD-Core Version:    0.7.0.1
 */