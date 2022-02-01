package com.tencent.mobileqq.fragment;

import ahov;
import ahow;
import ahox;
import ahoy;
import ahoz;
import ahpa;
import aizh;
import aizh.a;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.Map;

public class TempMsgSettingFragment
  extends IphoneTitleBarFragment
  implements aizh.a
{
  CompoundButton.OnCheckedChangeListener A;
  CompoundButton.OnCheckedChangeListener B;
  CompoundButton.OnCheckedChangeListener C;
  CompoundButton.OnCheckedChangeListener D;
  private CompoundButton.OnCheckedChangeListener E;
  public QQAppInterface app;
  FormSwitchItem bl;
  FormSwitchItem bm;
  FormSwitchItem bn;
  FormSwitchItem bo;
  FormSwitchItem bp;
  private FormSwitchItem bq;
  CompoundButton.OnCheckedChangeListener z;
  
  private void initUI()
  {
    this.bl = ((FormSwitchItem)this.mContentView.findViewById(2131379300));
    this.bm = ((FormSwitchItem)this.mContentView.findViewById(2131379299));
    this.bn = ((FormSwitchItem)this.mContentView.findViewById(2131379298));
    this.bo = ((FormSwitchItem)this.mContentView.findViewById(2131379297));
    this.bp = ((FormSwitchItem)this.mContentView.findViewById(2131379296));
    this.bq = ((FormSwitchItem)this.mContentView.findViewById(2131367742));
    Object localObject = (aizh)this.app.getManager(303);
    ((aizh)localObject).a(this);
    localObject = ((aizh)localObject).aq();
    this.bl.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_troop_")).booleanValue());
    this.bm.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_nearby_")).booleanValue());
    this.bn.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_interest_v2")).booleanValue());
    this.bo.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_contact_")).booleanValue());
    this.bp.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_consult_")).booleanValue());
    this.bq.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_circle_v2")).booleanValue());
    if (AppSetting.enableTalkBack)
    {
      this.bl.setContentDescription(getString(2131720988));
      this.bm.setContentDescription(getString(2131720983));
      this.bn.setContentDescription(getString(2131720982));
      this.bo.setContentDescription(getString(2131720978));
      this.bp.setContentDescription(getString(2131720977));
      this.bq.setContentDescription(getString(2131700063));
    }
    this.z = new ahov(this);
    this.bl.setOnCheckedChangeListener(this.z);
    this.A = new ahow(this);
    this.bm.setOnCheckedChangeListener(this.A);
    this.B = new ahox(this);
    this.bn.setOnCheckedChangeListener(this.B);
    this.C = new ahoy(this);
    this.bo.setOnCheckedChangeListener(this.C);
    this.D = new ahoz(this);
    this.bp.setOnCheckedChangeListener(this.D);
    this.E = new ahpa(this);
    this.bq.setOnCheckedChangeListener(this.E);
  }
  
  public void a(short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    switch (paramShort)
    {
    default: 
      return;
    case -23308: 
      this.bl.setOnCheckedChangeListener(null);
      this.bl.setChecked(paramBoolean2);
      this.bl.setOnCheckedChangeListener(this.z);
      return;
    case -23309: 
      this.bp.setOnCheckedChangeListener(null);
      this.bp.setChecked(paramBoolean2);
      this.bp.setOnCheckedChangeListener(this.D);
      return;
    case -23310: 
      this.bo.setOnCheckedChangeListener(null);
      this.bo.setChecked(paramBoolean2);
      this.bo.setOnCheckedChangeListener(this.C);
      return;
    case -23166: 
      this.bn.setOnCheckedChangeListener(null);
      this.bn.setChecked(paramBoolean2);
      this.bn.setOnCheckedChangeListener(this.B);
      return;
    case -23312: 
      this.bm.setOnCheckedChangeListener(null);
      this.bm.setChecked(paramBoolean2);
      this.bm.setOnCheckedChangeListener(this.A);
      return;
    }
    this.bq.setOnCheckedChangeListener(null);
    this.bq.setChecked(paramBoolean2);
    this.bq.setOnCheckedChangeListener(this.E);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)getActivity().getAppRuntime());
    }
    initUI();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561695;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getString(2131720984));
    return localView;
  }
  
  public void onDestroy()
  {
    ((aizh)this.app.getManager(303)).a(null);
    this.app = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TempMsgSettingFragment
 * JD-Core Version:    0.7.0.1
 */