package com.tencent.open.agent;

import acfp;
import acms;
import acnd;
import android.support.v4.app.FragmentActivity;
import arqy;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class JoinTroopPreVerificationFragment
  extends TroopAbilityPreVerificationFragment
{
  private acnd b = new arqy(this);
  
  protected void Uf(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((acms)this.mApp.getBusinessHandler(20)).hc(Integer.valueOf(this.mAppId).intValue(), Integer.valueOf(this.cBA).intValue());
      return;
    }
    hideProgress();
    WQ(acfp.m(2131707525));
    this.mActivity.finish();
  }
  
  protected boolean a(Set<Integer> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return false;
    }
    return paramSet.contains(Integer.valueOf(15));
  }
  
  protected void bpM()
  {
    super.bpM();
    this.mApp.addObserver(this.b);
  }
  
  protected void bpN()
  {
    super.bpN();
    this.mApp.removeObserver(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.JoinTroopPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */