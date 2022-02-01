package com.tencent.mobileqq.activity.specialcare;

import QQService.EVIPSPEC;
import abbh;
import abbi;
import abbj;
import abbk;
import abbl;
import abbm;
import abbn;
import abbo;
import abbp;
import abbq;
import abbr;
import abbs;
import abbt;
import abbu;
import abbv;
import abbw;
import abbx;
import acfd;
import acff;
import acfp;
import amfh;
import amhj;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import anot;
import aqdf;
import aqdf.a;
import aqex;
import aqgv;
import aqho;
import aqhu;
import aqiw;
import aqmr;
import aqnm;
import arhz;
import auuo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.a;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;
import wja;

public class SpecailCareListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aqdf.a, ActivateFriendGrid.a, AbsListView.e
{
  public static final String bfj = acfp.m(2131714690);
  public static final String bfk = acfp.m(2131714691);
  public View As;
  amhj jdField_a_of_type_Amhj;
  aqdf jdField_a_of_type_Aqdf;
  public arhz a;
  public b a;
  c jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$c = new abbs(this);
  public FriendListHandler a;
  int aTM;
  int aTN;
  acff jdField_b_of_type_Acff;
  auuo jdField_b_of_type_Auuo = new abbr(this);
  public boolean bBM = false;
  public boolean bBN = false;
  public boolean bBO = false;
  int bnr;
  public ActivateFriendGrid d;
  private String[] jdField_do;
  Drawable ee;
  Button fy;
  public PullRefreshHeader g;
  public LinearLayout ie;
  RelativeLayout ja;
  public Handler mHandler = new abbh(this);
  public XListView mListView;
  public int mScrollState = 0;
  public View nn;
  acfd p = new abbt(this);
  ArrayList<a> sA = new ArrayList();
  ArrayList<Entity> sB = new ArrayList();
  View xf;
  
  public void BW(int paramInt)
  {
    if (paramInt > 0)
    {
      this.fy.setEnabled(true);
      return;
    }
    this.fy.setEnabled(false);
  }
  
  public int a(View paramView, d paramd, boolean paramBoolean)
  {
    int j = getResources().getDimensionPixelSize(2131296995);
    int i;
    if (paramBoolean) {
      i = j;
    }
    do
    {
      return i;
      i = 0;
      if (this.mListView != null) {
        i = this.mListView.getWidth();
      }
      j = paramd.b.a(paramView, paramd, j, i);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("SpecailCareListActivity", 2, "getNickRightMargin=" + j);
    return j;
  }
  
  SpannableString a(Friends paramFriends, d paramd)
  {
    Object localObject1 = (amhj)this.app.getManager(15);
    Object localObject2 = (acff)this.app.getManager(51);
    if ((localObject1 == null) || (localObject2 == null)) {
      return null;
    }
    localObject1 = ((acff)localObject2).a(paramFriends.uin);
    paramFriends = null;
    boolean bool;
    label86:
    int j;
    label108:
    int k;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((ExtensionInfo)localObject1).feedContent)))
    {
      i = 1;
      if (localObject1 != null)
      {
        if (this.mScrollState == 0) {
          break label257;
        }
        bool = true;
        paramFriends = ((ExtensionInfo)localObject1).getRichStatus(bool);
      }
      if ((paramFriends == null) || (paramFriends.isEmpty())) {
        break label263;
      }
      j = 1;
      if ((j == 0) || (TextUtils.isEmpty(paramFriends.actionText))) {
        break label269;
      }
      k = 1;
      label126:
      if ((i == 0) || ((((ExtensionInfo)localObject1).feedTime <= ((ExtensionInfo)localObject1).richTime) && (j != 0))) {
        break label382;
      }
      paramFriends = new SpannableString(((ExtensionInfo)localObject1).feedContent);
      paramd.OY.setCompoundDrawables(null, null, null, null);
      if (((ExtensionInfo)localObject1).feedType != 2) {
        break label294;
      }
      paramd.wV.setVisibility(0);
      if (TextUtils.isEmpty(((ExtensionInfo)localObject1).feedPhotoUrl)) {
        break label275;
      }
      aqex.a(paramd.wV, ((ExtensionInfo)localObject1).feedPhotoUrl, getResources().getDrawable(2130851273));
    }
    for (;;)
    {
      paramd.wW.setVisibility(8);
      paramd.wX.setVisibility(8);
      paramd.OY.setText(paramFriends);
      return paramFriends;
      i = 0;
      break;
      label257:
      bool = false;
      break label86;
      label263:
      j = 0;
      break label108;
      label269:
      k = 0;
      break label126;
      label275:
      paramd.wV.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851273));
    }
    label294:
    paramd.wW.setVisibility(0);
    localObject2 = paramd.wW;
    if (((ExtensionInfo)localObject1).feedType == 1)
    {
      i = 2130850439;
      label321:
      ((ImageView)localObject2).setBackgroundResource(i);
      localObject2 = paramd.wX;
      if (!((ExtensionInfo)localObject1).feedHasPhoto) {
        break label376;
      }
    }
    label376:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject2).setVisibility(i);
      paramd.wV.setVisibility(8);
      paramd.wV.setImageDrawable(null);
      break;
      i = 2130850437;
      break label321;
    }
    label382:
    if (k != 0)
    {
      localObject1 = this.jdField_a_of_type_Amhj.i(paramFriends.actionId, 200);
      localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
      i = this.aTM;
      ((Drawable)localObject1).setBounds(0, 0, Math.round(((Drawable)localObject1).getIntrinsicWidth() * 1.0F / ((Drawable)localObject1).getIntrinsicHeight() * i), i);
      paramd.OY.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    for (;;)
    {
      paramFriends = paramFriends.toSpannableString(null);
      paramd.wW.setVisibility(8);
      paramd.wX.setVisibility(8);
      paramd.wV.setVisibility(8);
      paramd.wV.setImageDrawable(null);
      break;
      if (j == 0)
      {
        paramFriends = RichStatus.getEmptyStatus();
        paramd.OY.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  void bh(int paramInt, boolean paramBoolean)
  {
    getPreferences(0).edit().putBoolean("enterSpecailCare" + this.app.getCurrentAccountUin() + "_" + paramInt, paramBoolean).commit();
  }
  
  void bkI()
  {
    if (this.nn != null) {
      return;
    }
    anot.a(this.app, "CliOper", "", "", "0X80050DA", "0X80050DA", 0, 0, "", "", "", "");
    this.nn = LayoutInflater.from(this).inflate(2131561711, null);
    Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject1).setMargins(0, wja.dp2px(75.0F, getResources()), 0, 0);
    this.nn.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.nn.setOnClickListener(new abbu(this));
    this.fy = ((Button)this.nn.findViewById(2131362165));
    this.fy.setOnClickListener(this);
    this.d = ((ActivateFriendGrid)this.nn.findViewById(2131368143));
    this.d.setGridCallBack(this);
    localObject1 = new ArrayList();
    Iterator localIterator = this.sA.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (a)localIterator.next();
      if ((this.jdField_b_of_type_Acff != null) && (!this.jdField_b_of_type_Acff.isFriend(((a)localObject2).uin)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, ((a)localObject2).uin + " is not friend.. ");
        }
      }
      else
      {
        localObject2 = new ActivateFriendItem(1, Long.valueOf(((a)localObject2).uin).longValue(), ((a)localObject2).nickname);
        if (i >= 6) {
          break label423;
        }
        ((ArrayList)localObject1).add(localObject2);
        i += 1;
      }
    }
    label403:
    label423:
    for (;;)
    {
      break;
      anot.a(this.app, "CliOper", "", "", "0X80050DC", "0X80050DC", 0, 0, String.valueOf(i), "", "", "");
      this.d.setData(this.app, (ArrayList)localObject1);
      if (this.nn.getParent() == null)
      {
        if (Build.VERSION.SDK_INT >= 14) {
          break label403;
        }
        ((ViewGroup)this.ja.getParent().getParent()).addView(this.nn);
      }
      for (;;)
      {
        setRightButton(2131701410, this);
        return;
        ((FrameLayout)getWindow().getDecorView()).addView(this.nn);
      }
    }
  }
  
  public void cAQ()
  {
    long l1 = System.currentTimeMillis();
    this.sB.clear();
    List localList = this.jdField_b_of_type_Acff.dV();
    if ((localList == null) || (localList.size() <= 0))
    {
      cAR();
      this.leftView.setVisibility(0);
      this.bBO = false;
      this.rightViewText.setVisibility(4);
      this.ie.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos: empty...");
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "refreshSpecialCareData cost time = " + (l2 - l1));
      }
      return;
      this.rightViewText.setVisibility(0);
      if (this.bBO)
      {
        this.rightViewText.setText(bfk);
        this.ie.setVisibility(8);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos return size:" + localList.size());
        }
        int i = 0;
        while (i < localList.size())
        {
          Object localObject = (SpecialCareInfo)localList.get(i);
          localObject = this.jdField_b_of_type_Acff.b(((SpecialCareInfo)localObject).uin);
          if (localObject != null) {
            this.sB.add(localObject);
          }
          i += 1;
        }
        this.rightViewText.setText(bfj);
        this.ie.setVisibility(0);
      }
      ThreadManager.post(new SpecailCareListActivity.5(this), 8, null, true);
    }
  }
  
  void cAR()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$b.getEmptyView() != null)) {
      return;
    }
    if (((acff)this.app.getManager(51)).As() > 0) {
      anot.a(this.app, "CliOper", "", "", "0X80050E0", "0X80050E0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      View localView = getLayoutInflater().inflate(2131561708, null);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$b == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$b.setEmptyView(localView);
      return;
      anot.a(this.app, "CliOper", "", "", "0X80050DF", "0X80050DF", 0, 0, "", "", "", "");
    }
  }
  
  public void cAS()
  {
    if ((this.nn != null) && (this.nn.getParent() != null))
    {
      if (Build.VERSION.SDK_INT >= 14) {
        break label80;
      }
      ((ViewGroup)this.ja.getParent().getParent()).removeView(this.nn);
      this.nn = null;
      if (this.d != null)
      {
        this.d.destroy();
        this.d = null;
      }
    }
    for (;;)
    {
      this.rightViewText.setVisibility(4);
      return;
      label80:
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 2, -1.0F);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setAnimationListener(new abbv(this));
      this.nn.startAnimation(localTranslateAnimation);
    }
  }
  
  void cAT()
  {
    if ((this.xf != null) && (this.xf.getParent() != null))
    {
      ((FrameLayout)getWindow().getDecorView()).removeView(this.xf);
      this.xf = null;
    }
  }
  
  void cAU()
  {
    this.rightViewText.setClickable(false);
    int j = this.mListView.getChildCount();
    Object localObject1 = this.rightViewText.getText().toString();
    if (bfj.equals(localObject1))
    {
      if (this.As.getVisibility() == 0)
      {
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new abbw(this));
        this.As.startAnimation((Animation)localObject1);
      }
      int i = 0;
      while (i < j)
      {
        Object localObject2 = this.mListView.getChildAt(i);
        localObject1 = ((View)localObject2).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof d)))
        {
          localObject1 = (d)localObject1;
          int k = a((View)localObject2, (d)localObject1, true);
          localObject2 = new TranslateAnimation(-(this.mDensity * 34.0F), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setStartOffset(120L);
          ((AlphaAnimation)localObject3).setDuration(180L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          ((d)localObject1).wU.setVisibility(0);
          ((TranslateAnimation)localObject2).setAnimationListener(new abbx(this, (d)localObject1));
          ((d)localObject1).wU.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new abbi(this, (d)localObject1));
          ((d)localObject1).wS.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new abbj(this, (d)localObject1, k));
          ((d)localObject1).ib.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, -12.0F * this.mDensity);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setAnimationListener(new abbk(this, (d)localObject1));
          ((d)localObject1).At.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, 28.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(240L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          ((d)localObject1).b.startAnimation(localAnimationSet);
          localObject2 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((d)localObject1).arrow.setVisibility(0);
          ((d)localObject1).arrow.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new abbl(this));
          this.leftView.startAnimation((Animation)localObject1);
          this.ie.startAnimation((Animation)localObject1);
        }
        i += 1;
      }
    }
    if (bfk.equals(localObject1)) {
      cAV();
    }
  }
  
  void cAV()
  {
    int i = this.mListView.getLastVisiblePosition();
    int j = this.ie.getBottom();
    int k = this.mListView.getBottom();
    if (i == this.mListView.getCount() - 1) {
      if ((j > this.bnr) && (k >= j - this.bnr)) {
        this.As.setVisibility(8);
      }
    }
    for (;;)
    {
      j = this.mListView.getChildCount();
      i = 0;
      while (i < j)
      {
        Object localObject2 = this.mListView.getChildAt(i);
        Object localObject1 = ((View)localObject2).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof d)))
        {
          localObject1 = (d)localObject1;
          k = a((View)localObject2, (d)localObject1, false);
          localObject2 = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(180L);
          Object localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((TranslateAnimation)localObject2).setAnimationListener(new abbm(this, (d)localObject1));
          ((d)localObject1).wU.startAnimation((Animation)localObject4);
          localObject2 = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new abbn(this, (d)localObject1));
          ((d)localObject1).wS.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, -34.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((AnimationSet)localObject4).setFillAfter(true);
          ((AnimationSet)localObject4).setAnimationListener(new abbo(this, (d)localObject1, k));
          ((d)localObject1).ib.startAnimation((Animation)localObject4);
          localObject2 = new TranslateAnimation(0.0F, -34.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localObject4 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject4).setDuration(300L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.addAnimation((Animation)localObject4);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new abbp(this, (d)localObject1));
          ((d)localObject1).At.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(24.0F * this.mDensity, 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setFillAfter(true);
          localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setStartOffset(60L);
          ((AlphaAnimation)localObject3).setDuration(240L);
          localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((AnimationSet)localObject4).setFillAfter(true);
          ((d)localObject1).b.startAnimation((Animation)localObject4);
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((d)localObject1).arrow.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new abbq(this));
          this.leftView.startAnimation((Animation)localObject1);
          this.ie.startAnimation((Animation)localObject1);
        }
        i += 1;
      }
      this.As.setVisibility(0);
      continue;
      this.As.setVisibility(0);
    }
  }
  
  void ckm()
  {
    if (this.xf != null) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
      } while (this.nn != null);
      anot.a(this.app, "CliOper", "", "", "0X80050DB", "0X80050DB", 0, 0, "", "", "", "");
      localFrameLayout = (FrameLayout)getWindow().getDecorView();
      this.xf = LayoutInflater.from(this).inflate(2131561709, null);
      Button localButton = (Button)this.xf.findViewById(2131370089);
      this.xf.findViewById(2131374942).setOnClickListener(this);
      localButton.setOnClickListener(this);
    } while (this.xf.getParent() != null);
    localFrameLayout.addView(this.xf);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2131561710);
    super.setTitle(2131717467);
    super.setRightButton(2131695655, this);
    this.app.addObserver(this.p);
    this.aTN = ((int)aqho.convertDpToPixel(this, 9.0F));
    this.aTM = ((int)aqho.convertDpToPixel(this, 12.0F));
    this.bnr = ((int)aqho.convertDpToPixel(this, 20.0F));
    this.ja = ((RelativeLayout)super.findViewById(2131377408));
    this.mListView = ((XListView)super.findViewById(2131370573));
    this.As = super.findViewById(2131367143);
    this.As.setOnClickListener(this);
    this.ie = ((LinearLayout)getLayoutInflater().inflate(2131561707, null));
    this.ie.setOnClickListener(this);
    this.mListView.addFooterView(this.ie);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$b = new b();
    this.mListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$b);
    this.g = ((PullRefreshHeader)getLayoutInflater().inflate(2131560167, this.mListView, false));
    this.mListView.setOverScrollHeader(this.g);
    this.mListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131299308));
    this.mListView.setOverScrollListener(this.jdField_b_of_type_Auuo);
    this.mListView.setOnScrollListener(this);
    this.mListView.setContentBackground(2130838900);
    this.ee = getResources().getDrawable(2130845851);
    this.jdField_a_of_type_Aqdf = new aqdf(this, this.app);
    this.jdField_a_of_type_Aqdf.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(1));
    this.jdField_b_of_type_Acff = ((acff)this.app.getManager(51));
    this.jdField_a_of_type_Amhj = ((amhj)this.app.getManager(15));
    this.jdField_a_of_type_Amhj.addListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$c);
    cAQ();
    if ((this.sB.size() <= 0) && (hK(1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.EQ(true);
      FriendListHandler.cvh = 2;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.cm();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label699;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList() return size:" + paramBundle.size());
      }
      this.sA.clear();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        oidb_0x7df.FriendScore localFriendScore = (oidb_0x7df.FriendScore)paramBundle.next();
        a locala = new a();
        locala.uin = String.valueOf(localFriendScore.uint64_friend_uin.get());
        Friends localFriends = this.jdField_b_of_type_Acff.b(locala.uin);
        if (localFriends != null) {
          locala.nickname = aqgv.c(localFriends);
        }
        if ((TextUtils.isEmpty(locala.nickname)) && (localFriendScore.bytes_nick != null) && (localFriendScore.bytes_nick.get() != null)) {
          locala.nickname = localFriendScore.bytes_nick.get().toStringUtf8();
        }
        this.sA.add(locala);
      }
      bkI();
    }
    for (;;)
    {
      bh(1, true);
      bh(2, true);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "doOnCreate cost time = " + (l2 - l1));
      }
      if (AppSetting.enableTalkBack)
      {
        this.leftView.setContentDescription(acfp.m(2131714687));
        this.As.setContentDescription(acfp.m(2131714688));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.e(this.app.getCurrentAccountUin(), (byte)3);
      return true;
      label699:
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList(): empty...");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    this.app.removeObserver(this.p);
    this.jdField_a_of_type_Amhj.removeListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$c);
    hideProgressDialog();
    if (this.d != null)
    {
      this.d.destroy();
      this.d = null;
    }
  }
  
  boolean hK(int paramInt)
  {
    boolean bool = false;
    if (!getPreferences(0).getBoolean("enterSpecailCare" + this.app.getCurrentAccountUin() + "_" + paramInt, false)) {
      bool = true;
    }
    return bool;
  }
  
  public void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing()))
    {
      this.jdField_a_of_type_Arhz.dismiss();
      this.jdField_a_of_type_Arhz = null;
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.bBO)
    {
      this.bBO = false;
      cAV();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (((paramView instanceof ImageView)) && (paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      localObject1 = (String)paramView.getTag();
      if (!aqmr.isEmpty((String)localObject1))
      {
        anot.a(this.app, "CliOper", "", "", "0X80050E1", "0X80050E1", 0, 0, "", "", "", "");
        if (!aqiw.isNetSupport(this)) {
          break label143;
        }
        localObject2 = (FriendListHandler)this.app.getBusinessHandler(1);
        this.jdField_do = new String[] { localObject1 };
        ((FriendListHandler)localObject2).b(1, this.jdField_do, new boolean[] { false });
        this.mHandler.sendEmptyMessage(2002);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label143:
      QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
      continue;
      switch (paramView.getId())
      {
      case 2131374942: 
      default: 
        localObject1 = paramView.getTag();
        if ((localObject1 == null) || (!(localObject1 instanceof d)))
        {
          anot.a(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
          localObject1 = new Intent(this, ForwardFriendListActivity.class);
          ((Intent)localObject1).putExtra("extra_choose_friend", 1);
          ((Intent)localObject1).putExtra("extra_add_special_friend", 2);
          startActivity((Intent)localObject1);
          overridePendingTransition(2130771991, 2130771989);
        }
        break;
      case 2131369612: 
        if (this.nn != null)
        {
          cAS();
          anot.a(this.app, "CliOper", "", "", "0X80050DE", "0X80050DE", 0, 0, "", "", "", "");
        }
        else
        {
          cAU();
        }
        break;
      case 2131362165: 
        if (!aqiw.isNetSupport(this))
        {
          QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
          if (QLog.isColorLevel()) {
            QLog.i("SpecailCareListActivity", 2, "No Network!");
          }
        }
        else
        {
          localObject1 = this.d.h();
          localObject2 = new boolean[localObject1.length];
          String[] arrayOfString = new String[localObject1.length];
          this.jdField_do = new String[arrayOfString.length];
          int i = 0;
          while (i < localObject1.length)
          {
            localObject2[i] = 1;
            arrayOfString[i] = String.valueOf(localObject1[i]);
            this.jdField_do[i] = arrayOfString[i];
            i += 1;
          }
          showProgressDialog();
          if (QLog.isColorLevel()) {
            QLog.d("SpecailCareListActivity", 2, "setSpecialCareSwitch  start...");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(1, arrayOfString, (boolean[])localObject2);
          anot.a(this.app, "CliOper", "", "", "0X80050DD", "0X80050DD", 0, 0, String.valueOf(localObject1.length), "", "", "");
        }
        break;
      case 2131370089: 
        cAT();
        break;
      case 2131366399: 
        anot.a(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
        localObject1 = new Intent(this, ForwardFriendListActivity.class);
        ((Intent)localObject1).putExtra("extra_choose_friend", 1);
        ((Intent)localObject1).putExtra("extra_add_special_friend", 2);
        startActivity((Intent)localObject1);
        overridePendingTransition(2130771991, 2130771989);
        continue;
        localObject1 = (d)localObject1;
        localObject2 = ((d)localObject1).f;
        localObject2 = new Intent(this, QQSpecialCareSettingActivity.class);
        ((Intent)localObject2).putExtra("key_friend_uin", ((d)localObject1).uin);
        ((Intent)localObject2).putExtra("key_start_from", 5);
        startActivity((Intent)localObject2);
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Aqdf.isPausing())) {}
    for (;;)
    {
      return;
      if (this.mScrollState != 0)
      {
        this.bBN = true;
        return;
      }
      paramInt2 = this.mListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.mListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (d)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((d)localObject).f.uin)))
          {
            ((d)localObject).wS.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.sB.size() <= 0) || (paramAbsListView == null)) {
      return;
    }
    if (this.bBO)
    {
      this.As.setVisibility(8);
      return;
    }
    int i = this.ie.getBottom();
    int j = paramAbsListView.getBottom();
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onScroll.firstVisibleItem=" + paramInt1 + ", visibleItemCount=" + paramInt2 + ",totalItemCount=" + paramInt3 + ",addBtnBottom=" + i + ",listviewBottom=" + j + ",mBottomBtnBottomMargin=" + this.bnr);
    }
    if (paramInt1 + paramInt2 == paramInt3)
    {
      if ((i > this.bnr) && (j >= i - this.bnr))
      {
        this.As.setVisibility(8);
        return;
      }
      this.As.setVisibility(0);
      return;
    }
    this.As.setVisibility(0);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mScrollState = paramInt;
    if ((this.bBN) && (paramInt == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$b.notifyDataSetChanged();
      this.bBN = false;
    }
    for (;;)
    {
      return;
      if (paramInt == 0)
      {
        int i = this.mListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          paramAbsListView = (d)this.mListView.getChildAt(paramInt).getTag();
          if ((paramAbsListView != null) && (paramAbsListView.uin != null) && (paramAbsListView.uin.length() > 0)) {
            a(paramAbsListView.f, paramAbsListView);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  void showProgressDialog()
  {
    if (this.jdField_a_of_type_Arhz == null)
    {
      this.jdField_a_of_type_Arhz = new arhz(this);
      this.jdField_a_of_type_Arhz.setOffsetY(getTitleBarHeight());
    }
    this.jdField_a_of_type_Arhz.setMessage(2131689930);
    if (!this.jdField_a_of_type_Arhz.isShowing()) {
      this.jdField_a_of_type_Arhz.show();
    }
  }
  
  static class a
  {
    public String nickname;
    public String uin;
  }
  
  public class b
    extends BaseAdapter
  {
    View mEmptyView;
    LayoutInflater mInflater = (LayoutInflater)SpecailCareListActivity.this.getSystemService("layout_inflater");
    
    public b() {}
    
    public int getCount()
    {
      int i = SpecailCareListActivity.this.sB.size();
      if (i > 0) {
        return i;
      }
      return 1;
    }
    
    public View getEmptyView()
    {
      return this.mEmptyView;
    }
    
    public Object getItem(int paramInt)
    {
      if (paramInt < SpecailCareListActivity.this.sB.size()) {
        return SpecailCareListActivity.this.sB.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (SpecailCareListActivity.this.sB.size() == 0) {
        return 1;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      int i;
      Object localObject2;
      Object localObject3;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = this.mInflater.inflate(2131561708, paramViewGroup, false);
          paramView = ((View)localObject1).getLayoutParams();
          if (paramView != null)
          {
            paramView.height = SpecailCareListActivity.this.mListView.getHeight();
            paramView.width = SpecailCareListActivity.this.mListView.getWidth();
            ((View)localObject1).setLayoutParams(paramView);
          }
        }
        else
        {
          i = ((acff)SpecailCareListActivity.this.app.getManager(51)).As();
          paramView = (Button)((View)localObject1).findViewById(2131366399);
          if (QLog.isColorLevel()) {
            QLog.d("SpecialCare", 2, "getView  friends count = " + i);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(2131370461);
          localObject3 = (TextView)((View)localObject1).findViewById(2131370462);
          if (i > 0) {
            break label229;
          }
          ((TextView)localObject3).setVisibility(8);
          paramView.setVisibility(8);
        }
        for (;;)
        {
          paramView = (View)localObject1;
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localObject1;
          paramView = new ViewGroup.LayoutParams(SpecailCareListActivity.this.mListView.getWidth(), SpecailCareListActivity.this.mListView.getHeight());
          break;
          label229:
          ((TextView)localObject3).setVisibility(0);
          paramView.setVisibility(0);
          ((TextView)localObject2).setText(2131720410);
          paramView.setOnClickListener(SpecailCareListActivity.this);
        }
      }
      if (paramView != null)
      {
        localObject1 = (SpecailCareListActivity.d)paramView.getTag();
        label271:
        if (localObject1 != null) {
          break label1794;
        }
        localObject1 = this.mInflater.inflate(2131561712, paramViewGroup, false);
        localObject2 = new SpecailCareListActivity.d();
        ((View)localObject1).setTag(localObject2);
        ((SpecailCareListActivity.d)localObject2).wS = ((ImageView)((View)localObject1).findViewById(2131368698));
        ((SpecailCareListActivity.d)localObject2).ib = ((TextView)((View)localObject1).findViewById(2131379402));
        ((SpecailCareListActivity.d)localObject2).OZ = ((TextView)((View)localObject1).findViewById(2131380833));
        ((SpecailCareListActivity.d)localObject2).OY = ((TextView)((View)localObject1).findViewById(2131379404));
        ((SpecailCareListActivity.d)localObject2).wT = ((ImageView)((View)localObject1).findViewById(2131369920));
        ((SpecailCareListActivity.d)localObject2).wU = ((ImageView)((View)localObject1).findViewById(2131371856));
        ((SpecailCareListActivity.d)localObject2).arrow = ((ImageView)((View)localObject1).findViewById(2131362981));
        ((SpecailCareListActivity.d)localObject2).wV = ((ImageView)((View)localObject1).findViewById(2131369910));
        ((SpecailCareListActivity.d)localObject2).wW = ((ImageView)((View)localObject1).findViewById(2131369862));
        ((SpecailCareListActivity.d)localObject2).wX = ((ImageView)((View)localObject1).findViewById(2131369864));
        ((SpecailCareListActivity.d)localObject2).At = ((View)localObject1).findViewById(2131377880);
        ((SpecailCareListActivity.d)localObject2).b = ((MutualMarkIconsView)((View)localObject1).findViewById(2131372138));
        ((SpecailCareListActivity.d)localObject2).a = ((OnlineStatusView)((View)localObject1).findViewById(2131366592));
        ((SpecailCareListActivity.d)localObject2).a.setViewStyle(2);
        ((SpecailCareListActivity.d)localObject2).a.setTextSize(aqnm.dip2px(14.0F));
        ((View)localObject1).setOnClickListener(SpecailCareListActivity.this);
      }
      for (;;)
      {
        localObject3 = (Friends)SpecailCareListActivity.this.sB.get(paramInt);
        ((SpecailCareListActivity.d)localObject2).f = ((Friends)localObject3);
        ((SpecailCareListActivity.d)localObject2).uin = ((Friends)localObject3).uin;
        ((SpecailCareListActivity.d)localObject2).wU.setTag(((Friends)localObject3).uin);
        ((SpecailCareListActivity.d)localObject2).wU.setOnClickListener(SpecailCareListActivity.this);
        if (AppSetting.enableTalkBack) {
          ((SpecailCareListActivity.d)localObject2).wU.setContentDescription(acfp.m(2131714689));
        }
        paramView = SpecailCareListActivity.this.a.a(1, ((Friends)localObject3).uin, 0);
        if (paramView == null)
        {
          if (!SpecailCareListActivity.this.a.isPausing()) {
            SpecailCareListActivity.this.a.i(((Friends)localObject3).uin, 1, true);
          }
          ((SpecailCareListActivity.d)localObject2).wS.setBackgroundDrawable((BitmapDrawable)aqhu.aU());
          label673:
          i = aqgv.aU(((Friends)localObject3).detalStatusFlag, ((Friends)localObject3).iTermType);
          paramView = (FriendListHandler)SpecailCareListActivity.this.app.getBusinessHandler(1);
          switch (i)
          {
          case 5: 
          default: 
            paramView = paramView.bj(((Friends)localObject3).getLastLoginType());
            if (paramView == null) {
              paramView = SpecailCareListActivity.this.getString(2131720455);
            }
            break;
          }
        }
        for (;;)
        {
          label777:
          label792:
          label831:
          int j;
          boolean bool;
          label937:
          label982:
          String str;
          int k;
          Object localObject4;
          RelativeLayout.LayoutParams localLayoutParams1;
          RelativeLayout.LayoutParams localLayoutParams2;
          if ((i == 0) || (i == 6))
          {
            i = 1;
            if (!((SpecailCareListActivity.d)localObject2).a.a(SpecailCareListActivity.this.app, (Friends)localObject3)) {
              break label1544;
            }
            ((SpecailCareListActivity.d)localObject2).a.setVisibility(0);
            ((SpecailCareListActivity.d)localObject2).OZ.setVisibility(8);
            SpecailCareListActivity.this.a((Friends)localObject3, (SpecailCareListActivity.d)localObject2);
            ((SpecailCareListActivity.d)localObject2).wT.setVisibility(8);
            j = 0;
            if (i == 0) {
              j = ((Friends)localObject3).netTypeIconId;
            }
            bool = anlm.ayn();
            if ((i != 0) || (bool) || ((!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
              break label1600;
            }
            ((SpecailCareListActivity.d)localObject2).ib.setTextColor(SpecailCareListActivity.this.getResources().getColorStateList(2131167439));
            if ((bool) || (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))) {
              break label1624;
            }
            ((SpecailCareListActivity.d)localObject2).ib.setCompoundDrawablePadding(SpecailCareListActivity.this.aTN);
            ((SpecailCareListActivity.d)localObject2).ib.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130851502, 0);
            str = aqgv.c((Friends)localObject3);
            ((SpecailCareListActivity.d)localObject2).ib.setText(str);
            ((SpecailCareListActivity.d)localObject2).b.z(SpecailCareListActivity.this.app, ((Friends)localObject3).uin, 4);
            k = SpecailCareListActivity.this.a((View)localObject1, (SpecailCareListActivity.d)localObject2, SpecailCareListActivity.this.bBO);
            localObject4 = new RelativeLayout.LayoutParams((int)(50.0F * SpecailCareListActivity.k(SpecailCareListActivity.this)), (int)(50.0F * SpecailCareListActivity.l(SpecailCareListActivity.this)));
            ((RelativeLayout.LayoutParams)localObject4).addRule(15);
            localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams1.addRule(1, 2131368698);
            localLayoutParams1.addRule(10);
            localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams2.addRule(1, 2131368698);
            if (!SpecailCareListActivity.this.bBO) {
              break label1687;
            }
            ((SpecailCareListActivity.d)localObject2).wU.setVisibility(0);
            ((SpecailCareListActivity.d)localObject2).At.setVisibility(4);
            ((SpecailCareListActivity.d)localObject2).arrow.setVisibility(0);
            ((RelativeLayout.LayoutParams)localObject4).setMargins((int)(46.0F * SpecailCareListActivity.m(SpecailCareListActivity.this)), 0, (int)(10.0F * SpecailCareListActivity.n(SpecailCareListActivity.this)), 0);
            int m = (int)(22.0F * SpecailCareListActivity.o(SpecailCareListActivity.this));
            float f = SpecailCareListActivity.p(SpecailCareListActivity.this);
            localLayoutParams1.setMargins(0, m, (int)(k + 23.0F * f), 0);
            localLayoutParams2.setMargins(0, (int)(24.0F * SpecailCareListActivity.q(SpecailCareListActivity.this)), 0, 0);
          }
          for (;;)
          {
            ((SpecailCareListActivity.d)localObject2).wS.setLayoutParams((ViewGroup.LayoutParams)localObject4);
            ((SpecailCareListActivity.d)localObject2).ib.setLayoutParams(localLayoutParams1);
            if (AppSetting.enableTalkBack)
            {
              localObject4 = new StringBuilder(24);
              ((StringBuilder)localObject4).append(str).append(".").append(paramView).append(".");
              if ((((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
                ((StringBuilder)localObject4).append("QQ会员").append(".");
              }
              ((StringBuilder)localObject4).append(((SpecailCareListActivity.d)localObject2).OY.getText()).append(".");
              if (i == 0) {
                ((StringBuilder)localObject4).append(aqgv.gf(j));
              }
              if (!TextUtils.isEmpty(((SpecailCareListActivity.d)localObject2).b.Q)) {
                ((StringBuilder)localObject4).append(((SpecailCareListActivity.d)localObject2).b.Q.toString());
              }
              ((View)localObject1).setContentDescription((CharSequence)localObject4);
            }
            paramView = (View)localObject1;
            break;
            localObject1 = null;
            break label271;
            ((SpecailCareListActivity.d)localObject2).wS.setBackgroundDrawable(new BitmapDrawable(paramView));
            break label673;
            paramView = SpecailCareListActivity.this.getString(2131720439);
            break label777;
            paramView = SpecailCareListActivity.this.getString(2131720443);
            break label777;
            paramView = SpecailCareListActivity.this.getString(2131720449);
            break label777;
            paramView = SpecailCareListActivity.this.getString(2131720457);
            break label777;
            paramView = "";
            break label777;
            paramView = aqgv.ge(((Friends)localObject3).netTypeIconId);
            break label777;
            i = 0;
            break label792;
            label1544:
            ((SpecailCareListActivity.d)localObject2).a.setVisibility(8);
            ((SpecailCareListActivity.d)localObject2).OZ.setVisibility(0);
            ((SpecailCareListActivity.d)localObject2).OZ.setText("[" + paramView + "]");
            break label831;
            label1600:
            ((SpecailCareListActivity.d)localObject2).ib.setTextColor(SpecailCareListActivity.this.getResources().getColorStateList(2131167304));
            break label937;
            label1624:
            if ((!bool) && (((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
            {
              ((SpecailCareListActivity.d)localObject2).ib.setCompoundDrawablePadding(SpecailCareListActivity.this.aTN);
              ((SpecailCareListActivity.d)localObject2).ib.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130851889, 0);
              break label982;
            }
            ((SpecailCareListActivity.d)localObject2).ib.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            break label982;
            label1687:
            ((SpecailCareListActivity.d)localObject2).wU.setVisibility(8);
            ((SpecailCareListActivity.d)localObject2).At.setVisibility(0);
            ((SpecailCareListActivity.d)localObject2).arrow.setVisibility(8);
            ((RelativeLayout.LayoutParams)localObject4).setMargins((int)(12.0F * SpecailCareListActivity.r(SpecailCareListActivity.this)), 0, (int)(10.0F * SpecailCareListActivity.s(SpecailCareListActivity.this)), 0);
            localLayoutParams1.setMargins(0, (int)(10.0F * SpecailCareListActivity.t(SpecailCareListActivity.this)), k, 0);
            localLayoutParams2.setMargins(0, (int)(36.0F * SpecailCareListActivity.u(SpecailCareListActivity.this)), 0, 0);
          }
        }
        label1794:
        localObject2 = localObject1;
        localObject1 = paramView;
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public void setEmptyView(View paramView)
    {
      this.mEmptyView = paramView;
    }
  }
  
  public class c
    implements amfh
  {
    private c() {}
    
    public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
    {
      if ((paramBitmap != null) && (paramInt2 == 200))
      {
        if (SpecailCareListActivity.this.mScrollState != 0) {
          SpecailCareListActivity.this.bBN = true;
        }
      }
      else {
        return;
      }
      SpecailCareListActivity.this.a.notifyDataSetChanged();
    }
  }
  
  public static class d
  {
    public View At;
    public TextView OY;
    public TextView OZ;
    public OnlineStatusView a;
    public ImageView arrow;
    public MutualMarkIconsView b;
    public Friends f;
    public TextView ib;
    public String uin;
    public ImageView wS;
    public ImageView wT;
    public ImageView wU;
    public ImageView wV;
    public ImageView wW;
    public ImageView wX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity
 * JD-Core Version:    0.7.0.1
 */