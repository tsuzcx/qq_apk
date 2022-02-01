package com.tencent.biz.qqstory.settings;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import qok;
import qol;
import qom;

public class QGSettingFragment
  extends IphoneTitleBarFragment
{
  private static boolean aEA;
  private static boolean aEB;
  private static boolean aEz;
  protected FormSwitchItem f;
  protected FormSwitchItem g;
  protected FormSwitchItem h;
  
  public static boolean Kb()
  {
    return false;
  }
  
  public static boolean Kc()
  {
    return false;
  }
  
  public static boolean Kd()
  {
    return false;
  }
  
  public static void sO(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit();
    localEditor.putBoolean("qg_sdcard_so_local", paramBoolean);
    localEditor.apply();
    aEz = paramBoolean;
  }
  
  public static void sP(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit();
    localEditor.putBoolean("qg_libs_so_local", paramBoolean);
    localEditor.apply();
    aEA = paramBoolean;
  }
  
  public static void sQ(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit();
    localEditor.putBoolean("qg_js_debug", paramBoolean);
    localEditor.apply();
    aEB = paramBoolean;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.f = ((FormSwitchItem)this.mContentView.findViewById(2131377777));
    this.g = ((FormSwitchItem)this.mContentView.findViewById(2131370419));
    this.h = ((FormSwitchItem)this.mContentView.findViewById(2131369982));
    this.g.setChecked(Kc());
    this.g.setOnCheckedChangeListener(new qok(this));
    this.f.setChecked(Kb());
    this.f.setOnCheckedChangeListener(new qol(this));
    this.h.setChecked(Kd());
    this.h.setOnCheckedChangeListener(new qom(this));
  }
  
  public int getContentLayoutId()
  {
    return 2131561947;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle("QG设置");
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QGSettingFragment
 * JD-Core Version:    0.7.0.1
 */