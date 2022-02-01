package com.tencent.mobileqq.activity;

import acbn;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import aqij;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;

public class qfileJumpActivity
  extends BaseActivity
{
  protected String baY;
  protected int cM;
  
  private int yr()
  {
    if ((this.cM != 0) && (this.cM != 1)) {}
    while ((!acbn.bkw.equalsIgnoreCase(this.baY)) && (!acbn.bkx.equalsIgnoreCase(this.baY))) {
      return -1;
    }
    if (this.cM == 0)
    {
      if (!acbn.bkw.equalsIgnoreCase(this.baY)) {
        return -2;
      }
    }
    else if (!acbn.bkx.equalsIgnoreCase(this.baY)) {
      return -2;
    }
    return 0;
  }
  
  protected void csf()
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if (!this.app.isLogin())
    {
      localObject2 = new Intent(this, LoginActivity.class);
      ((Intent)localObject2).setAction(localIntent.getAction());
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 8);
      return;
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      localObject2 = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      ((Intent)localObject2).putExtra("key_gesture_from_jumpactivity", true);
      ((Intent)localObject2).setAction(localIntent.getAction());
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 8);
      return;
    }
    csg();
  }
  
  protected void csg()
  {
    new Handler().postDelayed(new qfileJumpActivity.1(this), 10L);
  }
  
  protected void csh()
  {
    new Handler().postDelayed(new qfileJumpActivity.2(this), 10L);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 8)
      {
        csg();
        return;
      }
      if (paramInt1 == 9)
      {
        csh();
        return;
      }
      finish();
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    try
    {
      super.doOnCreate(paramBundle);
      if (!aqij.a(this, true))
      {
        super.finish();
        return false;
      }
      this.baY = acbn.bkw;
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        this.baY = paramBundle.getStringExtra("targetUin");
        this.cM = paramBundle.getIntExtra("device_type", -1);
        int i = yr();
        if (i != 0)
        {
          QLog.w("qfileJump", 1, "targetparam no match, modify it " + i);
          this.cM = 0;
          this.baY = acbn.bkw;
          paramBundle.putExtra("device_type", this.cM);
          paramBundle.putExtra("targetUin", this.baY);
        }
        if ((!TextUtils.isEmpty(paramBundle.getAction())) && ((paramBundle.getAction().equals("android.intent.action.SEND")) || (paramBundle.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
        {
          csf();
          return true;
        }
        if (paramBundle.getBooleanExtra("jump_shortcut_dataline", false))
        {
          Intent localIntent;
          if (!this.app.isLogin())
          {
            localIntent = new Intent();
            localIntent.setClass(this, LoginActivity.class);
            localIntent.addFlags(67371008);
            localIntent.putExtras(paramBundle.getExtras());
            startActivityForResult(localIntent, 9);
          }
          else if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
          {
            localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
            localIntent.putExtra("key_gesture_from_jumpactivity", true);
            localIntent.putExtras(paramBundle.getExtras());
            startActivityForResult(localIntent, 9);
          }
        }
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
      return false;
    }
    csh();
    return true;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public boolean showPreview()
  {
    try
    {
      boolean bool = aqij.w(this);
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qfileJumpActivity
 * JD-Core Version:    0.7.0.1
 */