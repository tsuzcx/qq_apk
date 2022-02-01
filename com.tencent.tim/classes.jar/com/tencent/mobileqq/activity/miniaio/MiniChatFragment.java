package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import wkj;
import zof;
import zol;
import zos;

public class MiniChatFragment
  extends PublicBaseFragment
{
  protected zof a;
  int mWindowHeight;
  private float rb = 0.85F;
  protected SessionInfo sessionInfo = new SessionInfo();
  
  private Window a(Activity paramActivity)
  {
    return paramActivity.getWindow();
  }
  
  private WindowManager a(Activity paramActivity)
  {
    return paramActivity.getWindowManager();
  }
  
  protected Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  public SessionInfo a()
  {
    return this.sessionInfo;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Display localDisplay = a(getActivity()).getDefaultDisplay();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent.offsetLocation((f1 - localDisplay.getWidth() * (1.0F - this.rb) / 2.0F) / this.rb - f1, (f2 - localDisplay.getHeight() * (1.0F - this.rb) / 2.0F) / this.rb - f2);
    if ((!super.dispatchTouchEvent(paramMotionEvent)) && (f2 > this.mWindowHeight))
    {
      getActivity().finish();
      return true;
    }
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    try
    {
      Object localObject = a(paramActivity);
      ((Window)localObject).setFormat(-3);
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      Display localDisplay = a(paramActivity).getDefaultDisplay();
      float f = a(paramActivity).getFloatExtra("minaio_height_ration", 0.56F);
      localLayoutParams.height = ((int)(localDisplay.getHeight() * f));
      this.mWindowHeight = localLayoutParams.height;
      int i = a(paramActivity).getIntExtra("key_mini_from", 0);
      if ((i == 2) || (i == 5))
      {
        localLayoutParams.gravity = 49;
        localLayoutParams.y = ImmersiveUtils.getStatusBarHeight(paramActivity);
      }
      ((Window)localObject).setAttributes(localLayoutParams);
      localObject = ((Window)localObject).getDecorView();
      if (zos.VB())
      {
        this.rb = a(paramActivity).getFloatExtra("minaio_scaled_ration", 0.95F);
        ((View)localObject).setScaleX(this.rb);
        ((View)localObject).setScaleY(this.rb);
        QLog.i("MiniChatFragment", 2, "surport scale ");
        return;
      }
      this.rb = 1.0F;
      QLog.i("MiniChatFragment", 2, "not surport scale ");
      return;
    }
    catch (Throwable paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MiniChatFragment", 1, "initWindowStyleAndAnimation ", paramActivity);
      }
    }
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.a != null) {
      this.a.cqt();
    }
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getActivity().app == null) {
      paramLayoutInflater = null;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramBundle = a(getActivity());
      this.sessionInfo.aTl = paramBundle.getStringExtra("uin");
      this.sessionInfo.cZ = paramBundle.getIntExtra("uintype", -1);
      this.sessionInfo.aTn = paramBundle.getStringExtra("uinname");
      if ((this.sessionInfo.cZ == 1) && (TextUtils.isEmpty(this.sessionInfo.aTn)))
      {
        localObject = (TroopManager)getActivity().app.getManager(52);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).c(this.sessionInfo.aTl);
          if (localObject != null) {
            this.sessionInfo.aTn = ((TroopInfo)localObject).troopname;
          }
        }
      }
      this.sessionInfo.bPu = paramBundle.getIntExtra("key_mini_from", 0);
      this.sessionInfo.troopUin = this.sessionInfo.aTl;
      this.sessionInfo.a = new wkj();
      this.sessionInfo.a.img = getResources().getDrawable(2130851037);
      this.sessionInfo.a.k = getResources().getColorStateList(2131165375);
      this.sessionInfo.cN = ChatTextSizeSettingActivity.ag(getActivity());
      this.sessionInfo.Ic = paramBundle.getLongExtra("key_mini_aio_msg_shmsgseq", 0L);
      int i = paramBundle.getIntExtra("key_mini_from", 0);
      Object localObject = this.sessionInfo;
      if (i == 5) {}
      for (boolean bool = true;; bool = false)
      {
        ((SessionInfo)localObject).isBarrageMsg = bool;
        this.sessionInfo.Ie = paramBundle.getLongExtra("key_mini_aio_barrage_time_location", 0L);
        i = paramBundle.getIntExtra("key_mini_msgtab_businame", 0);
        if (i > 0)
        {
          localObject = this.sessionInfo.getExtras();
          paramBundle = (Bundle)localObject;
          if (localObject == null) {
            paramBundle = new Bundle();
          }
          paramBundle.putInt("key_mini_msgtab_businame", i);
          this.sessionInfo.setExtras(paramBundle);
        }
        this.a = zol.a(getActivity(), this.sessionInfo, getActivity().app);
        if (this.a != null) {
          break label414;
        }
        getActivity().finish();
        paramLayoutInflater = null;
        break;
      }
      label414:
      paramViewGroup = this.a.a(paramLayoutInflater, null, paramViewGroup);
      this.a.Vy();
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null)
      {
        getActivity().finish();
        paramLayoutInflater = null;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.doOnDestroy();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.a != null) {
      this.a.cqr();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.doOnPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.doOnResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.a != null) {
      this.a.doOnStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.a != null) {
      this.a.doOnStop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.a != null) {
      this.a.onWindowFocusChanged(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatFragment
 * JD-Core Version:    0.7.0.1
 */