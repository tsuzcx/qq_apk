package com.tencent.mobileqq.activity;

import accn;
import acfp;
import acgx;
import ajpg;
import ajqy;
import ajqz;
import alen;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anot;
import aqqj;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.a;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import vfy;
import vfz;
import vga;
import wja;

public class LikeSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, PraiseManager.a
{
  public FormSwitchItem D;
  FormSimpleItem E;
  public FormSwitchItem R;
  public FormSwitchItem S;
  public FormSwitchItem T;
  public acgx a;
  ajqz jdField_a_of_type_Ajqz = new vfz(this);
  PraiseManager jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager;
  public CardHandler c;
  accn cardObserver = new vfy(this);
  CompoundButton.OnCheckedChangeListener r = new vga(this);
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.r);
  }
  
  public void a(int paramInt1, alen paramalen, int paramInt2, String paramString)
  {
    if ((paramInt1 == PraiseManager.f(this.app)) && (paramalen != null))
    {
      paramInt1 = wja.dp2px(34.0F, super.getResources());
      this.E.setRightIcon(new BitmapDrawable(super.getResources(), paramalen.fR), paramInt1, paramInt1);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561450);
    setTitle(acfp.m(2131707743));
    setLeftViewName(2131691039);
    this.jdField_a_of_type_Acgx = ((acgx)this.app.getManager(186));
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager = ((PraiseManager)this.app.getManager(209));
    this.c = ((CardHandler)this.app.getBusinessHandler(2));
    this.D = ((FormSwitchItem)super.findViewById(2131372545));
    this.R = ((FormSwitchItem)super.findViewById(2131372546));
    this.S = ((FormSwitchItem)super.findViewById(2131370449));
    this.T = ((FormSwitchItem)super.findViewById(2131372547));
    this.E = ((FormSimpleItem)super.findViewById(2131373019));
    refreshUI();
    this.app.addObserver(this.cardObserver);
    this.app.addObserver(this.jdField_a_of_type_Ajqz);
    this.app.cLF();
    this.c.cHA();
    this.c.cHy();
    ((ajqy)this.app.getBusinessHandler(66)).dyR();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.cardObserver);
    this.app.removeObserver(this.jdField_a_of_type_Ajqz);
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.b(this);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    VasWebviewUtil.openQQBrowserWithoutAD(this, aqqj.o(this, "praise", ""), 536870912L, localIntent, false, -1);
    anot.a(this.app, "CliOper", "", "", "like_mall", "like_enter", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  void refreshUI()
  {
    boolean bool = ((ajpg)this.app.getManager(161)).aro();
    this.D.setOnCheckedChangeListener(null);
    a(this.D.a(), bool);
    this.D.setOnCheckedChangeListener(this.r);
    bool = this.app.abx();
    a(this.S.a(), bool);
    this.S.setOnCheckedChangeListener(this.r);
    this.R.setOnCheckedChangeListener(null);
    Object localObject = this.R;
    if (this.jdField_a_of_type_Acgx.aay()) {}
    for (int i = 0;; i = 8)
    {
      ((FormSwitchItem)localObject).setVisibility(i);
      this.R.setChecked(this.jdField_a_of_type_Acgx.aaw());
      this.R.setOnCheckedChangeListener(this.r);
      this.T.setOnCheckedChangeListener(null);
      this.T.setChecked(this.jdField_a_of_type_Acgx.aay());
      this.T.setOnCheckedChangeListener(this.r);
      i = PraiseManager.f(this.app);
      if (i > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(i, true, "from_like_setting");
        if (localObject != null)
        {
          i = wja.dp2px(34.0F, super.getResources());
          this.E.setRightIcon(new BitmapDrawable(super.getResources(), ((alen)localObject).fR), i, i);
        }
      }
      this.E.setOnClickListener(this);
      ThreadManager.post(new LikeSettingActivity.4(this), 5, null, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeSettingActivity
 * JD-Core Version:    0.7.0.1
 */