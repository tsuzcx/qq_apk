package com.tencent.qqmail.fragment.base;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.BaseActivityImpl.PrivateAccess;
import moai.fragment.app.FragmentManager;
import moai.fragment.base.BaseFragmentActivity;

class QMBaseFragment$1
  implements BaseActivityImpl.PrivateAccess
{
  QMBaseFragment$1(QMBaseFragment paramQMBaseFragment) {}
  
  public boolean checkGesturePassword()
  {
    return this.this$0.checkGesturePassword();
  }
  
  public boolean checkWelcomePopularize()
  {
    return this.this$0.checkWelcomePopularize();
  }
  
  public Object getPage()
  {
    return this.this$0;
  }
  
  public boolean isMultiStartAllowed()
  {
    return this.this$0.isMultiStartAllowed();
  }
  
  public void removeSelf()
  {
    BaseFragmentActivity localBaseFragmentActivity = this.this$0.getBaseFragmentActivity();
    if (localBaseFragmentActivity != null)
    {
      if (localBaseFragmentActivity.getSupportFragmentManager().getBackStackEntryCount() == 0) {
        localBaseFragmentActivity.super_finish();
      }
    }
    else {
      return;
    }
    this.this$0.noteFMStateNotSaved();
    this.this$0.popBackStack();
    this.this$0.overridePendingTransition(-1, 0);
  }
  
  public void super_finish()
  {
    BaseFragmentActivity localBaseFragmentActivity = this.this$0.getBaseFragmentActivity();
    if (localBaseFragmentActivity != null) {
      localBaseFragmentActivity.super_finish();
    }
  }
  
  public void super_finishActivity(int paramInt)
  {
    BaseFragmentActivity localBaseFragmentActivity = this.this$0.getBaseFragmentActivity();
    if (localBaseFragmentActivity != null) {
      localBaseFragmentActivity.super_finishActivity(paramInt);
    }
  }
  
  public void super_onCreate(Bundle paramBundle)
  {
    QMBaseFragment.access$001(this.this$0, paramBundle);
  }
  
  public void super_onDestroy()
  {
    QMBaseFragment.access$101(this.this$0);
  }
  
  public void super_onPause()
  {
    QMBaseFragment.access$501(this.this$0);
  }
  
  public void super_onResume()
  {
    QMBaseFragment.access$401(this.this$0);
  }
  
  public void super_onStart()
  {
    QMBaseFragment.access$201(this.this$0);
  }
  
  public void super_onStop()
  {
    QMBaseFragment.access$301(this.this$0);
  }
  
  public void super_startActivity(Intent paramIntent)
  {
    QMBaseFragment.access$601(this.this$0, paramIntent);
  }
  
  public void super_startActivityForResult(Intent paramIntent, int paramInt)
  {
    QMBaseFragment.access$701(this.this$0, paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.fragment.base.QMBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */