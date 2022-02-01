package com.tencent.biz.qqcircle.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleFolderActivityFragment;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.qphone.base.util.QLog;
import oum;
import ous;
import ovd;
import pco;
import pcr;
import pcu;
import pdd;

public class QCircleFolderActivity
  extends FragmentActivity
{
  private QCircleFolderActivityFragment a;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (300001 == paramInt1)
    {
      QLog.d("QCircleFolderActivity", 1, "doOnActivityResult，return from qzone publish page");
      pcr.a().vq(36);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnCreate");
    if (paramBundle != null) {
      paramBundle.remove("android:support:fragments");
    }
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    ovd.bc(this);
    getWindow().setSoftInputMode(32);
    setContentView(2131560907);
    QCircleBaseTabFragment.biK();
    this.a = new QCircleFolderActivityFragment();
    getSupportFragmentManager().beginTransaction().add(2131374535, this.a).commit();
    this.mFlingHandler = new a(this);
    if (pcr.a().ey(0)) {
      pcr.a().aX(getActivity().getIntent());
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnDestroy");
    super.doOnDestroy();
    pcr.a().vq(0);
    ous.clearMemoryCache();
    pcu.a().flush();
    VSNetworkHelper.a().cK(this);
    pdd.flush();
    oum.bhJ();
    QCircleFeedPicLoader.a().destroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    if (this.a != null) {
      this.a.onNewIntent(paramIntent);
    }
    if (paramIntent.hasExtra("key_is_publish"))
    {
      boolean bool = paramIntent.getBooleanExtra("key_is_publish", false);
      QLog.d("QCircleFolderActivity", 1, "resetNewIntent key_is_publish");
      getIntent().putExtra("key_is_publish", bool);
    }
  }
  
  public void doOnResume()
  {
    boolean bool1 = true;
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnResume");
    super.doOnResume();
    boolean bool2 = getIntent().getBooleanExtra("key_is_publish", false);
    StringBuilder localStringBuilder = new StringBuilder().append("doOnResume isWrite?").append(bool2).append(", mQCircleFragment?");
    if (this.a != null) {}
    for (;;)
    {
      QLog.d("QCircleFolderActivity", 4, bool1);
      if ((bool2) && (this.a != null))
      {
        this.a.biQ();
        getIntent().putExtra("key_is_publish", false);
      }
      return;
      bool1 = false;
    }
  }
  
  public boolean onBackEvent()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->onBackEvent");
    if ((this.a != null) && (this.a.onBackEvent())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    super.requestWindowFeature(paramIntent);
  }
  
  static class a
    extends FlingGestureHandler
  {
    public a(Activity paramActivity)
    {
      super();
    }
    
    public void flingLToR()
    {
      pco.h("", 22, 10L);
      super.flingLToR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.activity.QCircleFolderActivity
 * JD-Core Version:    0.7.0.1
 */