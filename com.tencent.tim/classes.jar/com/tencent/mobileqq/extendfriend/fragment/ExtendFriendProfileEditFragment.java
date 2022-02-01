package com.tencent.mobileqq.extendfriend.fragment;

import afsi;
import afsi.a;
import afua;
import afvc;
import afvd;
import afve;
import afvf;
import afvg;
import afvi;
import afvj;
import afvk;
import afxm;
import afxn;
import alfl;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anlm;
import anot;
import aofk;
import aozw;
import aqdj;
import aqep;
import aqoj;
import arwv;
import aurd;
import awif;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import jnm;
import jnm.d;
import wja;

public class ExtendFriendProfileEditFragment
  extends ReportV4Fragment
  implements View.OnClickListener
{
  public static final ColorDrawable k = new ColorDrawable(-657931);
  public View Ce;
  private View Cf;
  private View Cg;
  private View Ch;
  private View Ci;
  private Switch E;
  private int Hc;
  private TextView RH;
  private TextView RI;
  private TextView RM;
  private TextView RN;
  private TextView RO;
  private aozw a;
  private boolean aEH;
  private ExtendFriendEditFragment b;
  public String bFI;
  public ExtendFriendInfo c;
  public ExtendFriendVoiceView c;
  public int cUI = 20;
  private int cUJ;
  public boolean cbd;
  public boolean cbe;
  private boolean cbf;
  private boolean cbg;
  public boolean cbh;
  private QQToast e;
  private Drawable eO;
  private Drawable eP;
  public XEditTextEx g;
  public ETTextView i;
  public LinearLayout iM;
  private RelativeLayout kd;
  private RelativeLayout ke;
  private View mRoot;
  TextWatcher mTextWatcher = new afvc(this);
  private int mVoiceDuration;
  private ImageView qP;
  public String url = "";
  private CompoundButton.OnCheckedChangeListener y = new afvg(this);
  private ImageView zb;
  private ImageView zc;
  public ImageView zi;
  private ImageView zj;
  private ImageView zk;
  
  private void Nt(int paramInt)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      ((ExtendFriendEditFragment)localFragment).Nq(paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, jnm.d paramd)
  {
    for (int j = 1;; j = 0) {
      try
      {
        long l = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
        byte[] arrayOfByte = new byte[13];
        aqoj.DWord2Byte(arrayOfByte, 0, l);
        arrayOfByte[4] = 0;
        aqoj.Word2Byte(arrayOfByte, 5, (short)1);
        aqoj.q(arrayOfByte, 7, 42276);
        aqoj.Word2Byte(arrayOfByte, 9, (short)2);
        if (paramBoolean)
        {
          aqoj.Word2Byte(arrayOfByte, 11, (short)j);
          jnm.a(paramQQAppInterface, paramd, arrayOfByte, "OidbSvc.0x4ff_9", 1279, 9);
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandler", 2, "setShowVipIconSwitch: " + paramBoolean);
          }
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.w("ExtendFriendHandler", 1, "setShowVipIconSwitch error", paramQQAppInterface);
        return;
      }
    }
  }
  
  private void bindData()
  {
    Object localObject = ((afsi)getActivity().app.getManager(264)).a();
    if (localObject != null)
    {
      this.g.setHint(((afsi.a)localObject).bFm);
      this.cUI = ((afsi.a)localObject).cTW;
    }
    localObject = getActivity().app;
    String str = ((QQAppInterface)localObject).getCurrentUin();
    this.zb.setImageDrawable(aqdj.a((AppInterface)localObject, 1, str));
  }
  
  private void bqe()
  {
    this.cbd = true;
    this.g.setSelection(this.g.getText().length());
    dcO();
    dcS();
    this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
    this.Cg.setVisibility(8);
  }
  
  private void bqf()
  {
    this.cbd = false;
    dcP();
    if (!TextUtils.isEmpty(this.url)) {
      this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
    }
    for (;;)
    {
      if (this.b != null)
      {
        int j = this.b.mCurrentState;
        ExtendFriendEditFragment localExtendFriendEditFragment = this.b;
        if (j == 0) {
          this.b.dcz();
        }
      }
      return;
      this.Cg.setVisibility(0);
    }
  }
  
  private void dcO()
  {
    int j = getResources().getDisplayMetrics().heightPixels;
    int m = this.Hc;
    int n = ImmersiveUtils.getStatusBarHeight(getActivity());
    int i1 = this.RN.getHeight();
    int i2 = wja.dp2px(96.0F, getResources());
    this.g.setMaxHeight(j - m - n - i1 - i2);
  }
  
  private void dcP()
  {
    this.g.setMaxHeight(2147483647);
  }
  
  private void dcQ()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      ((ExtendFriendEditFragment)localFragment).dcw();
    }
  }
  
  private void dcR()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      ((ExtendFriendEditFragment)localFragment).dcx();
    }
  }
  
  private void dcS()
  {
    Nt(wja.dp2px(114.0F, getResources()) - ImmersiveUtils.getStatusBarHeight(getActivity()));
  }
  
  private void dcT()
  {
    if (this.aEH)
    {
      this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
      this.Cg.setVisibility(8);
    }
  }
  
  private void dcU()
  {
    if (this.aEH)
    {
      this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
      this.Cg.setVisibility(0);
    }
  }
  
  private void initViews()
  {
    this.g = ((XEditTextEx)this.mRoot.findViewById(2131366534));
    this.g.setVisibility(8);
    this.ke = ((RelativeLayout)this.mRoot.findViewById(2131377459));
    this.zj = ((ImageView)this.mRoot.findViewById(2131363887));
    this.RN = ((TextView)this.mRoot.findViewById(2131379876));
    this.Cg = this.mRoot.findViewById(2131367206);
    this.Cf = this.mRoot.findViewById(2131371165);
    this.eO = new BitmapDrawable(afxm.a(wja.dp2px(27.0F, getResources()), -15550475, 1.0F));
    this.eP = new BitmapDrawable(afxm.a(wja.dp2px(27.0F, getResources()), -16777216, 0.08F));
    this.zj.setBackgroundDrawable(this.eO);
    this.Ch = this.mRoot.findViewById(2131379875);
    this.Ci = this.mRoot.findViewById(2131382031);
    this.zb = ((ImageView)this.mRoot.findViewById(2131369031));
    this.RH = ((TextView)this.mRoot.findViewById(2131381101));
    this.zk = ((ImageView)this.mRoot.findViewById(2131369023));
    this.RO = ((TextView)this.mRoot.findViewById(2131381104));
    this.E = ((Switch)this.mRoot.findViewById(2131382022));
    this.qP = ((ImageView)this.mRoot.findViewById(2131382021));
    this.i = ((ETTextView)this.mRoot.findViewById(2131366551));
    this.i.setOnClickListener(this);
    this.i.setVisibility(0);
    this.i.setTextColor(-16777216);
    this.Ce = this.mRoot.findViewById(2131381452);
    this.g.setOnClickListener(this);
    this.g.addTextChangedListener(this.mTextWatcher);
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      this.g.setOnTouchListener((ExtendFriendEditFragment)localFragment);
    }
    this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)this.mRoot.findViewById(2131369082));
    this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity(getActivity());
    this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setDeleteIconEnable(true, new afvd(this));
    this.g.setBackgroundDrawable(k);
    this.ke.setBackgroundDrawable(k);
    this.i.setBackgroundDrawable(k);
    this.Cf.setBackgroundDrawable(this.eP);
    this.zj.setOnTouchListener(new afve(this));
    this.zj.setOnClickListener(this);
    this.iM = ((LinearLayout)this.mRoot.findViewById(2131370626));
    this.kd = ((RelativeLayout)this.mRoot.findViewById(2131377477));
    this.zi = ((ImageView)this.mRoot.findViewById(2131369652));
    this.zc = ((ImageView)this.mRoot.findViewById(2131369664));
    this.RI = ((TextView)this.mRoot.findViewById(2131380909));
    this.RM = ((TextView)this.mRoot.findViewById(2131380561));
    this.iM.setBackgroundDrawable(k);
    this.kd.setBackgroundDrawable(k);
    this.mRoot.getViewTreeObserver().addOnGlobalLayoutListener(new afvf(this));
    this.aEH = true;
    if (this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo != null) {
      c(this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
    }
    this.E.setOnCheckedChangeListener(this.y);
  }
  
  private String kI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int m = paramString.length();
    int j = m - 1;
    while (j >= 0)
    {
      int n = paramString.charAt(j);
      if ((n != 32) && (n != 10)) {
        break;
      }
      m -= 1;
      j -= 1;
    }
    return paramString.substring(0, m);
  }
  
  public void Io(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.url = paramString;
    }
  }
  
  public void Iz(boolean paramBoolean)
  {
    if (this.RM == null) {
      return;
    }
    if (paramBoolean)
    {
      this.RM.setTextColor(-11692801);
      this.RM.setOnClickListener(this);
      this.RM.setClickable(true);
      return;
    }
    this.RM.setTextColor(-3355444);
    this.RM.setOnClickListener(null);
    this.RM.setClickable(false);
  }
  
  public ExtendFriendInfo a()
  {
    ExtendFriendInfo localExtendFriendInfo = new ExtendFriendInfo();
    localExtendFriendInfo.url = this.url;
    localExtendFriendInfo.bFK = kI(this.g.getText().toString());
    if ((this.a != null) && ((this.a instanceof AudioInfo)))
    {
      localExtendFriendInfo.duration = (((AudioInfo)this.a).duration / 1000);
      return localExtendFriendInfo;
    }
    localExtendFriendInfo.duration = this.mVoiceDuration;
    return localExtendFriendInfo;
  }
  
  public void a(QQAppInterface paramQQAppInterface, afua paramafua)
  {
    Object localObject;
    boolean bool;
    if ((VipUtils.aFg()) && (VipUtils.ce(paramQQAppInterface)))
    {
      this.E.setOnCheckedChangeListener(null);
      localObject = this.E;
      if (paramafua.mVipHide) {
        break label164;
      }
      bool = true;
      ((Switch)localObject).setChecked(bool);
      this.E.setOnCheckedChangeListener(this.y);
      this.RH.setText(paramafua.mNickName);
      this.RO.setText(String.valueOf(paramafua.mPopularity));
      localObject = this.zk;
      if (paramafua.mGender != 2) {
        break label170;
      }
    }
    label164:
    label170:
    for (int j = 2130846011;; j = 2130846012)
    {
      ((ImageView)localObject).setImageResource(j);
      VipUtils.a(paramafua, this.qP);
      this.qP.setTag(paramafua);
      this.Ci.setVisibility(0);
      this.Ch.setVisibility(0);
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009F0E", "0X8009F0E", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
    }
  }
  
  public void a(ExtendFriendEditFragment paramExtendFriendEditFragment)
  {
    this.b = paramExtendFriendEditFragment;
  }
  
  public void a(AudioInfo paramAudioInfo)
  {
    this.a = paramAudioInfo;
    if (!TextUtils.isEmpty(paramAudioInfo.path))
    {
      this.url = paramAudioInfo.path;
      this.mVoiceDuration = paramAudioInfo.duration;
      dcT();
      this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(this.mVoiceDuration / 1000);
      this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.url);
      if (this.url.indexOf("file_md5=") <= 0) {
        this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceFileMD5(arwv.encodeFileHexStr(this.url));
      }
      this.cbg = true;
      dcQ();
    }
  }
  
  public void aRx()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView != null) && (this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.isPlaying())) {
      this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.aRx();
    }
  }
  
  public boolean akr()
  {
    String str2 = this.g.getText().toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return ((this.bFI != null) && (!this.bFI.equals(str1))) || (this.cbg);
  }
  
  public boolean aks()
  {
    if (this.g == null) {}
    int j;
    int m;
    do
    {
      return false;
      j = this.g.getScrollY();
      m = this.g.getLayout().getHeight() - (this.g.getHeight() - this.g.getCompoundPaddingTop() - this.g.getCompoundPaddingBottom());
    } while ((m == 0) || ((j <= 0) && (j >= m - 1)));
    return true;
  }
  
  public void c(ExtendFriendInfo paramExtendFriendInfo)
  {
    if (this.aEH)
    {
      int j;
      if (!TextUtils.isEmpty(paramExtendFriendInfo.bFK))
      {
        this.bFI = paramExtendFriendInfo.bFK;
        this.g.setText(paramExtendFriendInfo.bFK);
        this.i.setText(new aofk(awif.sj(paramExtendFriendInfo.bFK), 3, 24));
        if (paramExtendFriendInfo.bFK != null) {
          break label380;
        }
        j = 0;
        label69:
        this.g.setSelection(j);
        hideSoftInput();
        if (TextUtils.isEmpty(paramExtendFriendInfo.url)) {
          break label391;
        }
        dcT();
        this.url = paramExtendFriendInfo.url;
        this.mVoiceDuration = paramExtendFriendInfo.duration;
        this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(this.mVoiceDuration);
        this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.url);
        if (this.url.indexOf("file_md5=") <= 0) {
          this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceFileMD5(arwv.encodeFileHexStr(this.url));
        }
      }
      for (this.cbf = true;; this.cbf = false)
      {
        d(paramExtendFriendInfo);
        if (!anlm.ayn())
        {
          if ((this.b != null) && (this.b.a() != null) && (this.b.a().a() != null))
          {
            j = paramExtendFriendInfo.fontId;
            if (paramExtendFriendInfo.cUM != 0) {
              j = paramExtendFriendInfo.cUM;
            }
            this.b.a().setUsingItem(j);
            this.b.a().a().SM(j);
            this.b.mCurrentState = 3;
          }
          if ((this.b != null) && (this.b.b() != null) && (this.b.b().a() != null))
          {
            j = paramExtendFriendInfo.clothesId;
            if (paramExtendFriendInfo.cUN != 0) {
              j = paramExtendFriendInfo.cUN;
            }
            this.b.b().setUsingItem(j);
            this.b.b().a().SM(j);
            this.b.mCurrentState = 2;
          }
        }
        this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = paramExtendFriendInfo;
        if ((paramExtendFriendInfo.cbj) || (paramExtendFriendInfo.cbi)) {
          this.i.performClick();
        }
        return;
        this.bFI = "";
        paramExtendFriendInfo.bFK = "";
        break;
        label380:
        j = paramExtendFriendInfo.bFK.length();
        break label69;
        label391:
        dcU();
      }
    }
    this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = paramExtendFriendInfo;
  }
  
  public void d(ExtendFriendInfo paramExtendFriendInfo)
  {
    if ((getActivity() == null) || (paramExtendFriendInfo == null)) {
      return;
    }
    if ((TextUtils.isEmpty(paramExtendFriendInfo.schoolId)) || (TextUtils.isEmpty(paramExtendFriendInfo.schoolName)))
    {
      this.RM.setVisibility(8);
      this.kd.setVisibility(8);
      this.iM.setVisibility(0);
      this.zi.setImageResource(2130846006);
      this.zi.setOnClickListener(new afvi(this));
      this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = paramExtendFriendInfo;
      return;
    }
    this.kd.setVisibility(0);
    this.iM.setVisibility(8);
    TextView localTextView = this.RI;
    String str = paramExtendFriendInfo.schoolName;
    int j;
    if (paramExtendFriendInfo.authState == 2L)
    {
      j = 2130846054;
      label132:
      localTextView.setText(aqep.a(str, false, j, 2131298794, 2131298793, getActivity(), getActivity().app, null));
      if (paramExtendFriendInfo.authState != 2L) {
        break label224;
      }
      this.RM.setVisibility(8);
    }
    for (;;)
    {
      this.kd.post(new ExtendFriendProfileEditFragment.7(this, paramExtendFriendInfo));
      this.kd.setOnClickListener(new afvj(this, paramExtendFriendInfo));
      break;
      j = 2130846055;
      break label132;
      label224:
      if (paramExtendFriendInfo.authState == 0L)
      {
        this.RM.setVisibility(0);
        this.RM.setText(2131701094);
        Iz(true);
      }
      else if (paramExtendFriendInfo.authState == 1L)
      {
        this.RM.setVisibility(0);
        this.RM.setText(2131701095);
        Iz(false);
      }
      else
      {
        this.RM.setVisibility(0);
        this.RM.setText(2131701094);
        Iz(true);
      }
    }
  }
  
  public void dcV()
  {
    Object localObject = ((afsi)getActivity().app.getManager(264)).a();
    if (localObject == null) {}
    for (int j = 11000;; j = ((afsi.a)localObject).cTT * 1000)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("audio_max_length", j);
      ((Intent)localObject).putExtra("auto_start", true);
      ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
      PublicFragmentActivity.b.startForResult(getActivity(), (Intent)localObject, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
      this.cbh = true;
      return;
    }
  }
  
  public void hideSoftInput()
  {
    if ((this.cbd) && (this.g != null)) {
      aurd.hide(this.g);
    }
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
      this.i.setVisibility(8);
      this.g.setVisibility(0);
      this.cbe = true;
      this.g.setFocusableInTouchMode(true);
      this.g.setFocusable(true);
      this.g.requestFocus();
      aurd.aO(this.g);
      if ((this.b != null) && (this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo != null) && (!this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.cbi) && (!this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.cbj))
      {
        this.b.changeState(0);
        continue;
        dcV();
        continue;
        if (this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.isPlaying())
        {
          this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.aRx();
        }
        else
        {
          this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.ddV();
          continue;
          if ((getActivity() != null) && (this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo != null)) {
            afxn.b(getActivity(), this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.idx, this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.schoolName, this.jdField_c_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.schoolId);
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mRoot = paramLayoutInflater.inflate(2131561322, paramViewGroup, false);
    initViews();
    bindData();
    if ((getActivity() != null) && (afxn.az(getActivity().app)))
    {
      afxn.G(getActivity().app, false);
      getActivity().setResult(8193);
    }
    paramLayoutInflater = this.mRoot;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView != null) && (this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.isPlaying())) {
      this.jdField_c_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.aRx();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.cUJ = this.g.getLineCount();
  }
  
  public static class ExtendFriendInfo
    implements Parcelable, Cloneable
  {
    public static final Parcelable.Creator<ExtendFriendInfo> CREATOR = new afvk();
    public long authState;
    public String bFK;
    public int cUL;
    public int cUM;
    public int cUN;
    public int category;
    public boolean cbi;
    public boolean cbj;
    public int clothesId;
    public int duration;
    public int fontId;
    public int idx;
    public boolean isShowCard;
    public String schoolId;
    public String schoolName;
    public String url;
    
    public ExtendFriendInfo() {}
    
    public ExtendFriendInfo(Parcel paramParcel)
    {
      this.bFK = paramParcel.readString();
      this.cUL = paramParcel.readInt();
      this.url = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.isShowCard = bool1;
        this.duration = paramParcel.readInt();
        this.fontId = paramParcel.readInt();
        this.clothesId = paramParcel.readInt();
        this.cUM = paramParcel.readInt();
        this.cUN = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label158;
        }
        bool1 = true;
        label93:
        this.cbi = bool1;
        if (paramParcel.readByte() == 0) {
          break label163;
        }
      }
      label158:
      label163:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.cbj = bool1;
        this.schoolId = paramParcel.readString();
        this.schoolName = paramParcel.readString();
        this.authState = paramParcel.readLong();
        this.idx = paramParcel.readInt();
        this.category = paramParcel.readInt();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label93;
      }
    }
    
    public ExtendFriendInfo(Card paramCard)
    {
      this.bFK = paramCard.declaration;
      this.cUL = paramCard.popularity;
      this.url = paramCard.voiceUrl;
      this.isShowCard = paramCard.isShowCard;
      this.duration = paramCard.extendFriendVoiceDuration;
      this.fontId = paramCard.fontId;
      this.clothesId = paramCard.clothesId;
      this.schoolId = paramCard.schoolId;
      this.schoolName = paramCard.schoolName;
      this.authState = paramCard.authState;
      this.idx = paramCard.idx;
      this.category = paramCard.category;
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      return super.clone();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean isValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      paramParcel.writeString(this.bFK);
      paramParcel.writeInt(this.cUL);
      paramParcel.writeString(this.url);
      if (this.isShowCard)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.duration);
        paramParcel.writeInt(this.fontId);
        paramParcel.writeInt(this.clothesId);
        paramParcel.writeInt(this.cUM);
        paramParcel.writeInt(this.cUN);
        if (!this.cbi) {
          break label156;
        }
        b1 = 1;
        label90:
        paramParcel.writeByte(b1);
        if (!this.cbj) {
          break label161;
        }
      }
      label156:
      label161:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        paramParcel.writeString(this.schoolId);
        paramParcel.writeString(this.schoolName);
        paramParcel.writeLong(this.authState);
        paramParcel.writeInt(this.idx);
        paramParcel.writeInt(this.category);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label90;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment
 * JD-Core Version:    0.7.0.1
 */