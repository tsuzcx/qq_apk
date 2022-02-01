package com.tencent.mobileqq.activity;

import accn;
import acff;
import acfp;
import acha;
import aela;
import aelb;
import aerk;
import aerl;
import aiwk;
import ajnl;
import ajns;
import ajnu;
import ajog;
import ajog.a;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqiw;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.ArrayList;
import java.util.Iterator;
import vum;
import vun;
import wja;

public class ShowReactiveActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  TextView FL;
  TextView FM;
  int RH;
  FormMutiItem a;
  public FormSwitchItem aC;
  FormSimpleItem ai;
  acff c;
  private accn cardObserver = new vun(this);
  Button dA;
  LinearLayout gy;
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this);
  }
  
  private boolean a(ajog.a parama)
  {
    return (parama.a != null) && (!TextUtils.isEmpty(parama.a.bRN));
  }
  
  private void initUI()
  {
    setLeftViewName(2131690700);
    this.ai = ((FormSimpleItem)$(2131362675));
    this.aC = ((FormSwitchItem)$(2131362685));
    this.FL = ((TextView)$(2131362686));
    this.gy = ((LinearLayout)$(2131372140));
    this.a = ((FormMutiItem)$(2131363569));
    this.dA = ((Button)$(2131376989));
    this.FM = ((TextView)$(2131376990));
    aela localaela = aelb.b();
    boolean bool;
    label159:
    FormMutiItem localFormMutiItem;
    if (!TextUtils.isEmpty(localaela.bze))
    {
      if (acha.isLocaleCN()) {
        this.FL.setText(localaela.bze);
      }
    }
    else
    {
      bool = ((acff)this.app.getManager(51)).aL(false);
      localObject = this.aC;
      if (bool) {
        break label433;
      }
      bool = true;
      ((FormSwitchItem)localObject).setChecked(bool);
      ((CardHandler)this.app.getBusinessHandler(2)).cHC();
      this.aC.setOnCheckedChangeListener(this);
      this.ai.setOnClickListener(this);
      if (this.RH == 1)
      {
        this.ai.setVisibility(0);
        anot.a(null, "dc00898", "", "", "0X800A1FC", "0X800A1FC", 0, 0, "", "", "", "");
      }
      localObject = ajnl.g(this.app);
      LayoutInflater localLayoutInflater = LayoutInflater.from(this);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      localObject = null;
      label256:
      ajog.a locala;
      int i;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (ajog.a)localIterator.next();
        i = ajnl.a(this.app, null, locala.type, locala.ada, true);
      } while (i == 0);
      localFormMutiItem = (FormMutiItem)localLayoutInflater.inflate(2131561694, null);
      localFormMutiItem.setLeftIcon(m(i));
      localFormMutiItem.setFirstLineText(locala.name);
      localFormMutiItem.setSecondLineText(locala.bRO);
      if (!a(locala)) {
        break label438;
      }
      FormMutiItem.setNeedFocusBg(true);
      localFormMutiItem.setBgType(2);
      localFormMutiItem.setTag(locala);
      localFormMutiItem.setOnClickListener(this);
      localFormMutiItem.setRightIcon(getResources().getDrawable(2130839628));
    }
    for (;;)
    {
      this.gy.addView(localFormMutiItem);
      if (localObject == null) {
        localFormMutiItem.setBgType(1);
      }
      localObject = localFormMutiItem;
      break label256;
      this.FL.setText(acfp.m(2131691046));
      break;
      label433:
      bool = false;
      break label159;
      label438:
      FormMutiItem.setNeedFocusBg(false);
      localFormMutiItem.setBgType(2);
      localFormMutiItem.setSecondLineTextViewPaddingRight(wja.dp2px(12.0F, getResources()));
    }
    if (localObject != null) {
      ((FormMutiItem)localObject).setBgType(3);
    }
    Object localObject = new ajns(this, 2130851200);
    this.a.setLeftIcon((Drawable)localObject);
    ((ajns)localObject).ME("");
    if (!TextUtils.isEmpty(localaela.bzf)) {
      this.a.setFirstLineText(localaela.bzf);
    }
    if (!TextUtils.isEmpty(localaela.bzg)) {
      this.a.setSecondLineText(localaela.bzg);
    }
    localObject = aerl.c();
    this.dA.setOnClickListener(new vum(this, (aerk)localObject));
    if (((aerk)localObject).bVY)
    {
      this.dA.setVisibility(0);
      this.FM.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        this.aC.setContentDescription(getString(2131719958));
      }
      aiwk.K("1", "1", "1", LpReportInfo_dc03950.getReportUserType(this.app));
      return;
      this.dA.setVisibility(8);
      this.FM.setVisibility(8);
    }
  }
  
  private void lp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    startActivity(localIntent);
  }
  
  public <T extends View> T $(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561693);
    setTitle(2131691045);
    this.c = ((acff)this.app.getManager(51));
    this.RH = getIntent().getIntExtra("entry", 1);
    initUI();
    addObserver(this.cardObserver);
    anot.a(null, "dc00898", "", "", "0X800A1FB", "0X800A1FB", 0, 0, "", "", "", "");
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.cardObserver != null) {
      removeObserver(this.cardObserver);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  protected Drawable m(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
    return localDrawable;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!aqiw.isNetSupport(getActivity()))
    {
      QQToast.a(getApplicationContext(), 2131719890, 1).show();
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
      a(paramCompoundButton, bool1);
    }
    while (paramCompoundButton != this.aC.a())
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    Object localObject = this.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      label81:
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8007021", "0X8007021", 0, 0, String.valueOf(i), "", "", "");
      localObject = (CardHandler)this.app.getBusinessHandler(2);
      if (paramBoolean) {
        break label143;
      }
    }
    for (;;)
    {
      ((CardHandler)localObject).Ez(bool1);
      break;
      i = 0;
      break label81;
      label143:
      bool1 = false;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView.getId() == 2131362675)
    {
      anot.a(null, "dc00898", "", "", "0X800A1FD", "0X800A1FD", 0, 0, "", "", "", "");
      localObject = aelb.b().tv();
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("finish_animation_out_to_right", true);
      localIntent.putExtra("is_wrap_content", true);
      localIntent.putExtra("hide_left_button", false);
      startActivity(localIntent);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof ajog.a)))
      {
        localObject = (ajog.a)paramView.getTag();
        if (localObject != null) {
          if (((ajog.a)localObject).type == 7L) {
            aiwk.a(this.app, this, 2087, "1");
          } else if ((((ajog.a)localObject).a != null) && (!TextUtils.isEmpty(((ajog.a)localObject).a.bRN))) {
            lp(ajnu.mj(((ajog.a)localObject).a.bRN));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShowReactiveActivity
 * JD-Core Version:    0.7.0.1
 */