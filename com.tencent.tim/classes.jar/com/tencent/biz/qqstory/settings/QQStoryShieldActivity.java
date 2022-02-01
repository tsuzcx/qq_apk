package com.tencent.biz.qqstory.settings;

import acff;
import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqiw;
import arib;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import plr;
import pma;
import pmb;
import pmd;
import qou;
import qwq;
import rar;
import wja;

public class QQStoryShieldActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public arib a;
  pma b;
  ViewGroup bD;
  pmb c;
  pmd e = new qou(this);
  int mFromType = 3;
  String mUin;
  View[] o = new View[3];
  public Switch v;
  public Switch w;
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131561760, null);
    ((TextView)localView.findViewById(2131379769)).setText(paramString);
    ((TextView)localView.findViewById(2131369154)).setText("");
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.b.qO(this.mUin);
    super.startTitleProgress();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mUin = super.getIntent().getStringExtra("uin");
    this.mFromType = super.getIntent().getIntExtra("from", 3);
    if (TextUtils.isEmpty(this.mUin))
    {
      super.finish();
      return false;
    }
    this.c = ((pmb)this.app.getManager(181));
    this.b = ((pma)this.app.getBusinessHandler(98));
    this.app.addObserver(this.e);
    paramBundle = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130838901);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, wja.dp2px(20.0F, getResources()), 0, 0);
    this.bD = paramBundle;
    paramBundle = a(0, acfp.m(2131712433));
    paramBundle.setBackgroundResource(2130839689);
    this.bD.addView(paramBundle);
    if ((this.mFromType == 3) || (this.mFromType == 2)) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new FormSwitchItem(this, null);
    this.o[1] = paramBundle;
    paramBundle.setText(acfp.m(2131712451) + plr.asZ);
    paramBundle.setContentDescription(acfp.m(2131712420) + plr.asZ);
    paramBundle.setBgType(2);
    paramBundle.setTag(Integer.valueOf(1));
    paramBundle.getTextView().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.w = paramBundle.a();
    this.w.setTag(Integer.valueOf(1));
    this.w.setOnCheckedChangeListener(null);
    this.bD.addView(paramBundle);
    paramBundle = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
    if ((this.mFromType != 3) && (this.mFromType != 2)) {
      paramBundle.topMargin = wja.dp2px(20.0F, getResources());
    }
    paramBundle = new FormSwitchItem(this, null);
    this.o[2] = paramBundle;
    paramBundle.setText(acfp.m(2131712437) + plr.asZ);
    paramBundle.setContentDescription(acfp.m(2131712408) + plr.asZ);
    paramBundle.setBgType(3);
    paramBundle.setTag(Integer.valueOf(2));
    paramBundle.getTextView().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.v = paramBundle.a();
    this.v.setTag(Integer.valueOf(2));
    this.v.setOnCheckedChangeListener(null);
    this.bD.addView(paramBundle);
    paramBundle = this.c.a(this.mUin);
    boolean bool;
    if (paramBundle != null)
    {
      localObject = this.v;
      if (paramBundle.isAllowed == 1)
      {
        bool = true;
        ((Switch)localObject).setChecked(bool);
        localObject = this.w;
        if (paramBundle.isInterested != 1) {
          break label717;
        }
        bool = true;
        label558:
        ((Switch)localObject).setChecked(bool);
      }
    }
    else
    {
      this.v.setOnCheckedChangeListener(this);
      this.w.setOnCheckedChangeListener(this);
      super.setContentView(this.bD);
      if (this.mFromType != 3) {
        break label722;
      }
      super.setTitle(plr.asY + acfp.m(2131712409));
      label624:
      this.a = new arib(this, 2131561628);
      if (aqiw.isNetworkAvailable(this)) {
        break label801;
      }
      QQToast.a(this, 1, acfp.m(2131712405), 0).show(getTitleBarHeight());
      super.startTitleProgress();
    }
    for (;;)
    {
      rar.a("friend_story_settings", "exp_set", this.mFromType, 0, new String[] { "2", "", "", "" });
      return true;
      bool = false;
      break;
      label717:
      bool = false;
      break label558;
      label722:
      if (this.mFromType == 2)
      {
        if (QQStoryContext.a().eU(this.mUin))
        {
          super.setTitle(plr.asY + acfp.m(2131712450));
          break label624;
        }
        super.setTitle(acfp.m(2131712429));
        break label624;
      }
      super.setTitle(acfp.m(2131712446));
      break label624;
      label801:
      this.b.qO(this.mUin);
    }
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.e);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    qwq.aB(this.app);
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    if (!aqiw.isNetworkAvailable(this)) {
      QQToast.a(this, 1, acfp.m(2131712448), 0).show(getTitleBarHeight());
    }
    for (int i = 0;; i = 1)
    {
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(this.mUin);
      switch (j)
      {
      default: 
        if (j == 2) {
          if (paramBoolean)
          {
            localObject = "open_notletsee";
            label99:
            if (this.mFromType != 3) {
              break label296;
            }
            rar.a("person_data_set", (String)localObject, 0, 0, new String[] { "", "", "", "" });
          }
        }
        break;
      }
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        if (i != 0)
        {
          this.b.a((ArrayList)localObject, true, paramBoolean);
          this.a.aq(0, 2131718674, 0);
          break;
        }
        localObject = this.v;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          ((Switch)localObject).setChecked(bool);
          break;
        }
        if (i != 0)
        {
          this.b.a((ArrayList)localObject, false, paramBoolean);
          this.a.aq(0, 2131718674, 0);
          break;
        }
        localObject = this.w;
        if (!paramBoolean) {}
        for (bool = true;; bool = false)
        {
          ((Switch)localObject).setChecked(bool);
          break;
        }
        localObject = "close_notletsee";
        break label99;
        if (paramBoolean)
        {
          localObject = "open_notsee";
          break label99;
        }
        localObject = "close_notsee";
        break label99;
        label296:
        rar.a("list_settings", (String)localObject, 0, 0, new String[] { "", "", "", "" });
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (((acff)this.app.getManager(51)).isFriend(this.mUin)) {}
    for (int i = 1;; i = 19)
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.mUin, i);
      ProfileActivity.b(getActivity(), localAllInOne);
      rar.a("list_settings", "clk_person_data", 0, 0, new String[] { "", "", "", "" });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldActivity
 * JD-Core Version:    0.7.0.1
 */