package com.tencent.mobileqq.apollo.debug.page;

import abkt;
import abku;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class CmGameDebugToolFragment
  extends CmGameDebugBaseFragment
  implements View.OnClickListener
{
  FormSwitchItem aM;
  FormSwitchItem aN;
  private SharedPreferences mPref;
  
  private void aAz()
  {
    this.aM.setOnCheckedChangeListener(new abkt(this));
    this.aN.setOnCheckedChangeListener(new abku(this));
  }
  
  private void ckj()
  {
    this.mPref = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 4);
    this.aM.setChecked(this.mPref.getBoolean("game_whitelist_verify_switch", true));
    this.aN.setChecked(this.mPref.getBoolean("game_storage_switch", false));
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131559004, paramViewGroup, false);
    this.aM = ((FormSwitchItem)paramLayoutInflater.findViewById(2131364830));
    this.aN = ((FormSwitchItem)paramLayoutInflater.findViewById(2131364829));
    ckj();
    aAz();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.page.CmGameDebugToolFragment
 * JD-Core Version:    0.7.0.1
 */