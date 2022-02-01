package com.tencent.biz.qqcircle.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import ous;
import pcr;
import pcu;

public class QCircleFragmentActivity
  extends PublicFragmentActivity
{
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (300001 == paramInt1)
    {
      QLog.d("QCircleFragmentActivity", 1, "doOnActivityResult，return from qzone publish page");
      pcr.a().vq(36);
    }
  }
  
  public void doOnBackPressed()
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnBackPressed");
    super.doOnBackPressed();
    PublicBaseFragment localPublicBaseFragment = b();
    if ((localPublicBaseFragment instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)localPublicBaseFragment).onBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnCreate");
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnDestroy()
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnDestroy");
    super.doOnDestroy();
    ous.clearMemoryCache();
    VSNetworkHelper.a().cK(this);
    pcu.a().flush();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnNewIntent");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.activity.QCircleFragmentActivity
 * JD-Core Version:    0.7.0.1
 */