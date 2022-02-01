package com.tencent.mobileqq.extendfriend.fragment;

import QC.SuixintieCheckItem;
import acfp;
import afsg;
import afsr;
import afum;
import afun;
import afuo;
import afup;
import afuq;
import afur;
import afus;
import afut;
import afuu;
import afuv;
import afuw;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import anot;
import aofk;
import aomd;
import aooi;
import aook;
import aool;
import aqha;
import aqju;
import aqrn;
import aqro;
import aqry;
import aqsa;
import arhz;
import aurd;
import awif;
import com.etrump.mixlayout.ETTextView;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.a;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.a;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.c;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.XEditTextEx;
import jll;
import mqq.app.AppRuntime;

public class ExtendFriendEditFragment
  extends PublicBaseFragment
  implements View.OnClickListener, View.OnTouchListener, StickyNoteShopLayout.a, SoftInputDetectView.a
{
  private arhz H;
  public ExtendFriendProfileEditFragment.ExtendFriendInfo a;
  public ExtendFriendProfileEditFragment a;
  private StickyNoteShopLayout a;
  public AudioInfo a;
  private StickyNoteShopLayout b;
  private String bFH;
  private FrameLayout bz;
  SoftInputDetectView c;
  private int cUE;
  private boolean caW = true;
  public boolean caX;
  private boolean caY;
  afsr g = new afuo(this);
  private GestureDetector gestureDetector;
  BounceScrollView h;
  public LinearLayout iL;
  private aook j = new afup(this);
  private FragmentActivity mActivity;
  private SuixintieCheckItem mClothesItem = new SuixintieCheckItem();
  public int mCurrentState = 0;
  private SuixintieCheckItem mFontItem = new SuixintieCheckItem();
  private FragmentManager mFragmentManager;
  private GestureDetector.OnGestureListener mGestureListener = new afum(this);
  TextView mRightBtn;
  private aqrn mVasRes;
  private ImageView zg;
  private ImageView zh;
  
  private void In(String paramString)
  {
    aool localaool = new aool();
    localaool.cNy = true;
    localaool.dQ = paramString;
    localaool.mUniseq = System.currentTimeMillis();
    localaool.mFileType = 23;
    this.mActivity.app.a().a(localaool);
  }
  
  private void a(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.aRx();
    }
    this.H.show();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path)))
    {
      In(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
      return;
    }
    b(paramExtendFriendInfo);
  }
  
  private void b(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    int k = 1;
    afsg localafsg = (afsg)this.mActivity.app.getBusinessHandler(127);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.cUI;
      if ((!TextUtils.isEmpty(paramExtendFriendInfo.bFK)) && (paramExtendFriendInfo.bFK.length() < i)) {
        break label189;
      }
      if ((!TextUtils.isEmpty(paramExtendFriendInfo.bFK)) || (TextUtils.isEmpty(paramExtendFriendInfo.url))) {
        break label162;
      }
      i = 2;
    }
    for (;;)
    {
      anot.a(this.mActivity.app, "dc00898", "", "", "0X80092DF", "0X80092DF", i, 0, "", "", "", "");
      localafsg.a(this.mActivity.app.getCurrentAccountUin(), paramExtendFriendInfo.bFK, paramExtendFriendInfo.url, paramExtendFriendInfo.duration, this.mFontItem.itemId, this.mFontItem.fontType, this.mClothesItem.itemId);
      return;
      i = 20;
      break;
      label162:
      if (!TextUtils.isEmpty(paramExtendFriendInfo.bFK))
      {
        i = k;
        if (TextUtils.isEmpty(paramExtendFriendInfo.url)) {}
      }
      else
      {
        i = 3;
      }
    }
    label189:
    QQToast.a(getActivity(), String.format(acfp.m(2131705997), new Object[] { Integer.valueOf(i) }), 0).show();
    this.H.dismiss();
  }
  
  private void dcv()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment = new ExtendFriendProfileEditFragment();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(this);
    this.mFragmentManager.beginTransaction().add(2131365382, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment).commit();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = ((ExtendFriendProfileEditFragment.ExtendFriendInfo)this.mActivity.getIntent().getParcelableExtra("key_extend_friend_info"));
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo == null)
    {
      ((afsg)this.mActivity.app.getBusinessHandler(127)).k(this.mActivity.app.getCurrentAccountUin(), false);
      this.H.show();
      return;
    }
    ((afsg)this.mActivity.app.getBusinessHandler(127)).k(this.mActivity.app.getCurrentAccountUin(), true);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.isValid()) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
    }
    if (!NetworkState.isNetworkConnected(this.mActivity.app.getApp())) {
      QQToast.a(this.mActivity.app.getApp(), 1, 2131696270, 0).show();
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.bFK)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.url)))
    {
      this.caY = true;
      return;
    }
    this.caY = false;
  }
  
  private void gz(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131369579);
    localTextView.setOnClickListener(this);
    this.mRightBtn = ((TextView)paramView.findViewById(2131369612));
    if (ThemeUtil.isInNightMode(getActivity().app)) {
      localTextView.setBackgroundDrawable(getResources().getDrawable(2130846567));
    }
    this.H = new arhz(getActivity(), getActivity().getTitleBarHeight());
    this.H.setBackAndSearchFilter(true);
    this.h = ((BounceScrollView)paramView.findViewById(2131365382));
    this.gestureDetector = new GestureDetector(getActivity(), this.mGestureListener);
    this.iL = ((LinearLayout)paramView.findViewById(2131370634));
    this.c = ((SoftInputDetectView)paramView.findViewById(2131369291));
    this.c.setExcludeStatusBar(false);
    this.c.setOnImStateChangedListener(this);
    this.bz = ((FrameLayout)paramView.findViewById(2131367185));
    this.bz.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)paramView.findViewById(2131363409));
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(9);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(2);
    this.b = ((StickyNoteShopLayout)paramView.findViewById(2131367441));
    this.b.setShopCallback(this);
    this.b.setAppId(5);
    this.b.setUseId(2);
    this.zg = ((ImageView)paramView.findViewById(2131369947));
    this.zg.setOnTouchListener(jll.a);
    this.zg.setOnClickListener(this);
    this.zh = ((ImageView)paramView.findViewById(2131369948));
    this.zh.setOnTouchListener(jll.a);
    this.zh.setOnClickListener(this);
    this.h.setOnTouchListener(this);
  }
  
  public void Ix(boolean paramBoolean)
  {
    FrameLayout localFrameLayout;
    if (this.bz != null)
    {
      localFrameLayout = this.bz;
      if ((!paramBoolean) || (anlm.ayn())) {
        break label74;
      }
    }
    label74:
    for (int i = 0;; i = 8)
    {
      localFrameLayout.setVisibility(i);
      if (this.bz.getVisibility() == 0)
      {
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_show", "", 0, "", "1");
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_show", "", 0, "", "2");
      }
      return;
    }
  }
  
  public void Nq(int paramInt)
  {
    this.h.smoothScrollTo(0, paramInt);
  }
  
  public void Nr(int paramInt)
  {
    ((RelativeLayout.LayoutParams)this.iL.getLayoutParams()).bottomMargin = paramInt;
  }
  
  public StickyNoteShopLayout a()
  {
    return this.b;
  }
  
  public void a(StickyNoteShopLayout paramStickyNoteShopLayout)
  {
    if (!anlm.ayn())
    {
      gA(paramStickyNoteShopLayout);
      Nr(paramStickyNoteShopLayout.iG(this.cUE));
      this.iL.setVisibility(0);
      paramStickyNoteShopLayout.show(0);
    }
  }
  
  public boolean akp()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.cbh) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g == null) {
      return false;
    }
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.getText() == null)
    {
      str1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c.bFK != null) {
        break label92;
      }
    }
    label92:
    for (String str2 = "";; str2 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c.bFK)
    {
      if (!str1.equals(str2)) {
        break label106;
      }
      return false;
      str1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.getText().toString();
      break;
    }
    label106:
    return true;
  }
  
  public void aq(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c == null)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        this.caW = true;
        this.cUE = paramInt;
        if (!anlm.ayn()) {
          this.iL.setVisibility(0);
        }
        Ix(false);
        Nr(0);
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c.cbi)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c.cbi = false;
          dcy();
          this.mCurrentState = 3;
          changeState(3);
          return;
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c.cbj);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c.cbj = false;
      dcy();
      this.mCurrentState = 2;
      changeState(2);
      return;
      this.caW = false;
      if (this.mCurrentState == 1)
      {
        Ix(true);
        return;
      }
      if (this.mCurrentState == 0)
      {
        this.iL.setVisibility(8);
        Ix(false);
        return;
      }
      if (this.mCurrentState == 2)
      {
        changeState(2);
        return;
      }
    } while (this.mCurrentState != 3);
    changeState(3);
  }
  
  public StickyNoteShopLayout b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  }
  
  public void changeState(int paramInt)
  {
    this.mCurrentState = paramInt;
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      Ix(false);
      aurd.aO(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g);
      dcy();
      return;
    case 2: 
      if (this.caW) {
        aurd.hide(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g);
      }
      for (;;)
      {
        dcz();
        return;
        Ix(true);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
        this.zg.setImageResource(2130851306);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_show", "", 0, "", "1");
      }
    }
    if (this.caW) {
      aurd.hide(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g);
    }
    for (;;)
    {
      dcz();
      return;
      Ix(true);
      a(this.b);
      this.zh.setImageResource(2130851308);
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_show", "", 0, "", "2");
    }
  }
  
  public void dcw()
  {
    if ((!akp()) && (!hasContent())) {
      dcx();
    }
    do
    {
      return;
      if ((!akp()) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c.fontId == this.mFontItem.itemId) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c.clothesId == this.mClothesItem.itemId))
      {
        dcx();
        return;
      }
    } while ((!isAdded()) && (!this.caX));
    this.mRightBtn.setTextColor(-16777216);
    this.mRightBtn.setOnClickListener(this);
    this.mRightBtn.setClickable(true);
  }
  
  public void dcx()
  {
    this.mRightBtn.setTextColor(-3355444);
    this.mRightBtn.setOnClickListener(null);
    this.mRightBtn.setClickable(false);
  }
  
  public void dcy()
  {
    this.zh.setImageResource(2130851307);
    this.zg.setImageResource(2130851305);
  }
  
  public void dcz()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.getText() == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.getText().toString())
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.setTextMsg(new aofk(awif.sj(str), 3, 24));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.setVisibility(0);
      return;
    }
  }
  
  public void gA(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != paramView) {
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.hide();
    }
    if (this.b != paramView) {
      this.b.hide();
    }
  }
  
  public void hU(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (getActivity() == null)) {
      return;
    }
    if (paramInt1 > 10000)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.Ce.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.Ce.getBackground() instanceof VasResDrawable))
      {
        ((VasResDrawable)this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.Ce.getBackground()).update(paramInt1);
        this.mClothesItem.itemId = paramInt1;
        this.caX = true;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.setBackgroundColor(Color.alpha(0));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.setBackgroundColor(Color.alpha(0));
      }
    }
    for (;;)
    {
      this.mClothesItem.appid = 9;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.mMsgId = System.currentTimeMillis();
      if (paramInt2 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.setTextColor(paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.setTextColor(paramInt2);
      }
      dcw();
      return;
      Object localObject1 = new VasResDrawable(getActivity().app, paramInt1);
      Object localObject2 = new aqry((VasResDrawable)localObject1, getActivity().app, 2130847025);
      ((aqry)localObject2).SR(true);
      ((VasResDrawable)localObject1).a((VasResDrawable.c)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.Ce.setBackgroundDrawable((Drawable)localObject1);
      break;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.Ce.setBackgroundColor(Color.alpha(0));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment;
      ((XEditTextEx)localObject1).setBackgroundDrawable(ExtendFriendProfileEditFragment.k);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment;
      ((ETTextView)localObject1).setBackgroundDrawable(ExtendFriendProfileEditFragment.k);
      this.mClothesItem.itemId = 0;
      this.caX = true;
    }
  }
  
  public boolean hasContent()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.getText() == null) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.getText().toString()));
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (this.b != null) {
      this.b.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == 0) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramIntent.getSerializableExtra("audio_info"));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
    } while (!QLog.isColorLevel());
    QLog.i("ExtendFriendProfileEdit", 2, "onActivityResult audio_back path: " + this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
  }
  
  public boolean onBackEvent()
  {
    if (this.mActivity != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.akr()))
      {
        aqju localaqju = aqha.a(this.mActivity, 0, null, acfp.m(2131705973), acfp.m(2131705994), acfp.m(2131705989), new afuq(this), new afur(this));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.aRx();
        localaqju.show();
        return true;
      }
      return super.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.mActivity != null)
      {
        anot.a(this.mActivity.app, "dc00898", "", "", "0X80092E0", "0X80092E0", 0, 0, "", "", "", "");
        Object localObject;
        if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.akr()))
        {
          localObject = aqha.a(this.mActivity, 0, null, acfp.m(2131705998), acfp.m(2131705978), acfp.m(2131706012), new afus(this), new afut(this));
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.aRx();
          ((aqju)localObject).show();
        }
        else
        {
          this.mActivity.doOnBackPressed();
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a();
            if ((this.caY) && (TextUtils.isEmpty(((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).bFK)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path)))
            {
              QQToast.a(this.mActivity, 0, "校园扩列宣言还没有填写哦", 0).show();
            }
            else if ((TextUtils.isEmpty(((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).bFK)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.bFI)))
            {
              localObject = aqha.a(this.mActivity, 0, null, acfp.m(2131705985), acfp.m(2131705976), acfp.m(2131705977), new afuu(this), new afuv(this, (ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject));
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.aRx();
              ((aqju)localObject).show();
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.getLineCount() > 30)
            {
              QQToast.a(getActivity(), "输入文字不要超过30行", 0).show();
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.iM != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.iM.getVisibility() == 0))
            {
              localObject = aqha.a(this.mActivity, 0, null, getString(2131701167), getString(2131701168), getString(2131701169), new afuw(this), new afun(this, (ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject));
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.aRx();
              ((aqju)localObject).show();
            }
            else
            {
              a((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject);
              continue;
              dcy();
              changeState(2);
              VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_click", "", 0, "", "1");
              continue;
              dcy();
              changeState(3);
              VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_click", "", 0, "", "2");
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity = getActivity();
    this.mFragmentManager = getChildFragmentManager();
    paramBundle = this.mActivity.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
      paramBundle.setSoftInputMode(16);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561321, null);
    this.mActivity.app.addObserver(this.g);
    gz(paramLayoutInflater);
    dcv();
    this.j.addFilter(new Class[] { aomd.class });
    this.mActivity.app.a().a(this.j);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mActivity.app.removeObserver(this.g);
    this.mActivity.app.a().b(this.j);
    this.g = null;
    if (this.mVasRes != null) {
      this.mVasRes.recycle();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131366534) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.aks()))
    {
      this.h.requestDisallowInterceptTouchEvent(true);
      if (paramMotionEvent.getAction() == 1) {
        this.h.requestDisallowInterceptTouchEvent(false);
      }
      return false;
    }
    this.gestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (ThemeUtil.isInNightMode(getActivity().app))
    {
      paramView = (FrameLayout)paramView;
      paramBundle = new View(getActivity());
      paramBundle.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      paramBundle.setBackgroundColor(1056964608);
      paramView.addView(paramBundle);
    }
  }
  
  public void setFont(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    while (getActivity() == null) {
      return;
    }
    this.caX = true;
    this.mFontItem.itemId = paramInt1;
    this.mFontItem.fontType = paramInt2;
    this.mFontItem.appid = 5;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.setText(new aofk(awif.sj(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.getText().toString()), 3, 24));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.g.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.setFont(0, System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.mMsgId = System.currentTimeMillis();
    if (this.mVasRes == null)
    {
      Object localObject = getActivity().app;
      this.mVasRes = new aqrn((AppRuntime)localObject, paramInt1);
      localObject = new aqsa(this.mVasRes, (AppRuntime)localObject, paramInt2);
      ((aqsa)localObject).a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.getTextSize(), true);
      this.mVasRes.a((aqro)localObject);
      ((aqsa)localObject).XS(-1);
    }
    for (;;)
    {
      dcw();
      return;
      ((aqsa)this.mVasRes.a()).a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.i.getTextSize(), true);
      ((aqsa)this.mVasRes.a()).update(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment
 * JD-Core Version:    0.7.0.1
 */