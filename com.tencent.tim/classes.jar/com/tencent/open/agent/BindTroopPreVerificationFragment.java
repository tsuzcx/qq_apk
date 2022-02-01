package com.tencent.open.agent;

import acfp;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import java.util.Set;

public class BindTroopPreVerificationFragment
  extends TroopAbilityPreVerificationFragment
{
  private static final Integer av = Integer.valueOf(16);
  
  protected void Uf(boolean paramBoolean)
  {
    hideProgress();
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_params", this.mParams);
      PublicFragmentActivity.b.start(this.mActivity, localIntent, PublicFragmentActivity.class, BindGroupFragment.class);
      this.mActivity.finish();
      return;
    }
    WQ(acfp.m(2131703224));
    this.mActivity.finish();
  }
  
  protected boolean a(Set<Integer> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return false;
    }
    return paramSet.contains(av);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindTroopPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */