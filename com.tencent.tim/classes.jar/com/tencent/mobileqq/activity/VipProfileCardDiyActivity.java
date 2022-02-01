package com.tencent.mobileqq.activity;

import accn;
import acff;
import acfp;
import ahxo;
import ahxp;
import ahxs;
import alco;
import alcs;
import aldy;
import aldz;
import alft;
import alfx;
import alfy;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import aofy;
import aqep;
import aqha;
import aqju;
import aqrc;
import aqrf;
import arhz;
import aurd;
import auru;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.view.HScrollView;
import com.tencent.mobileqq.profile.view.HScrollView.a;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.profile.view.SingleTouchLayout.b;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.a;
import com.tencent.mobileqq.profile.view.VerticalSeekBar;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jqc;
import wfo;
import wfp;
import wfq;
import wfr;
import wfs;
import wft;
import wfu;
import wfv;
import wfw;
import wfx;
import wfy;
import wja;

public class VipProfileCardDiyActivity
  extends BaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, SeekBar.OnSeekBarChangeListener, HScrollView.a, SingleTouchLayout.b, SoftInputDetectView.a
{
  public static final String aRO = acfp.m(2131716794);
  String AH;
  DialogInterface.OnClickListener D = new wft(this);
  DialogInterface.OnClickListener E = new wfu(this);
  DialogInterface.OnClickListener F = new wfx(this);
  DialogInterface.OnClickListener jdField_G_of_type_AndroidContentDialogInterface$OnClickListener = new wfp(this);
  arhz jdField_G_of_type_Arhz;
  TextView GY;
  TextView GZ;
  TextView Ha;
  TextView Hb;
  TextView Hc;
  TextView Hd;
  public long Hy;
  aqju N;
  aqju O;
  int WAIT_TIME = 30000;
  accn jdField_a_of_type_Accn = new wfs(this);
  public auru a;
  DiyDefaultTextView jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView;
  HiBoomTemplateView jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
  a jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$a = new wfr(this);
  HScrollView jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView;
  VerticalSeekBar jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar;
  public VasQuickUpdateManager a;
  VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  EditText aK;
  public String aRP;
  public String aRQ;
  String aRR;
  public String aRS;
  public String aRT;
  ahxs jdField_b_of_type_Ahxs;
  HiBoomTemplateView jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
  Card jdField_b_of_type_ComTencentMobileqqDataCard;
  DiyTextView jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView;
  public SingleTouchLayout b;
  SoftInputDetectView jdField_b_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  VasQuickUpdateManager.CallBacker jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new wfo(this);
  AtomicBoolean bE = new AtomicBoolean(false);
  public AtomicBoolean bF = new AtomicBoolean(false);
  int bMH;
  int bMI;
  int bMJ = -1;
  int bMK;
  int bML;
  public int bMM;
  int bMN;
  public int bMO = 2;
  public boolean bbV;
  boolean bbW;
  boolean bbX = false;
  AvatarLayout c;
  PopupWindow d;
  Drawable dE;
  Button dL;
  Bitmap ds;
  Bitmap dt;
  ImmersiveTitleBar2 e;
  TextView ey;
  public HashMap<String, String> gF = new HashMap();
  LinearLayout gO;
  RelativeLayout hl;
  View iX;
  SharedPreferences k;
  volatile boolean mDestroy = false;
  int mFrom;
  public int mMaxSize;
  int mMode = 1;
  Resources mResources;
  int mScreenHeight;
  int mScreenWidth;
  float pn;
  float po;
  float pp;
  float pq;
  arhz r;
  ImageView rB;
  ImageView rC;
  ImageView rD;
  DialogInterface.OnClickListener v = new wfw(this);
  View vP;
  DialogInterface.OnClickListener w = new wfv(this);
  
  public static boolean b(long paramLong, String paramString, int paramInt)
  {
    if ((5L == paramLong) && (paramString.startsWith("font.diycard.android."))) {
      return String.valueOf(paramInt).equals(paramString.substring("font.diycard.android.".length(), paramString.length()));
    }
    return false;
  }
  
  public static boolean gn(int paramInt)
  {
    File localFile = new File(aldy.bVX + paramInt);
    if ((localFile.exists()) && (localFile.isDirectory())) {}
    for (String[] arrayOfString = localFile.list(); (localFile.exists()) && (arrayOfString != null) && (arrayOfString.length > 0); arrayOfString = null) {
      return true;
    }
    return false;
  }
  
  public void BS(int paramInt)
  {
    if (paramInt == 2)
    {
      aqrf.a(this.app, this, "mvip.g.a.mp_wz", 3, "1450000516", "CJCLUBT", getString(2131720669), "svipdiyCardH5Pay");
      return;
    }
    aqrf.a(this.app, this, "mvip.g.a.mp_wz", 3, "1450000515", "LTMCLUB", getString(2131697263), "vipdiyCardH5Pay");
  }
  
  boolean QV()
  {
    return true;
  }
  
  public void a(String paramString, UpsImageUploadResult paramUpsImageUploadResult, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipProfileCardDiyActivity", 2, "url from UPS:" + paramUpsImageUploadResult.url);
    }
    this.gF.put(paramString, paramUpsImageUploadResult.url);
    r(paramString, paramUpsImageUploadResult.url, paramBoolean);
  }
  
  boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    acff localacff = (acff)this.app.getManager(51);
    Card localCard = localacff.b(this.app.getCurrentAccountUin());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localacff.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("VipProfileCardDiyActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public void aV(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VipProfileCardDiyActivity", 1, "uploadBackgroundToUps filePath is empty");
      return;
    }
    wfq localwfq = new wfq(this, Long.parseLong(this.app.getCurrentAccountUin()), paramString, alft.a(this.app), "qqprofile", paramString, paramBoolean);
    localwfq.fe = alft.a(this.app);
    localwfq.fileId = alft.c(this.app, paramString);
    bPq();
    paramString = (alfy)this.app.getManager(90);
    paramString.a(this.app, null);
    localwfq.a();
    paramString.a(this.app, localwfq, null);
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void aq(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.aK.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.aK.getLayoutParams();
      localLayoutParams.bottomMargin = paramInt;
      this.aK.setLayoutParams(localLayoutParams);
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008112", "", 1, 0, 0, "", "", "");
      return;
    }
    this.aK.setVisibility(8);
  }
  
  public void bF()
  {
    if ((this.jdField_G_of_type_Arhz != null) && (this.jdField_G_of_type_Arhz.isShowing())) {}
    try
    {
      this.jdField_G_of_type_Arhz.dismiss();
      label24:
      this.jdField_G_of_type_Arhz = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void bPq()
  {
    try
    {
      if (!isFinishing())
      {
        this.r = new arhz(this, getTitleBarHeight());
        this.r.setCancelable(false);
        this.r.setMessage(2131691470);
        this.r.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void bPr()
  {
    if ((this.r != null) && (this.r.isShowing())) {}
    try
    {
      this.r.dismiss();
      label24:
      this.r = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  void bXJ()
  {
    if (this.bbX)
    {
      this.GZ.setVisibility(8);
      this.bbX = false;
    }
  }
  
  void bXK()
  {
    int j = 0;
    Object localObject1;
    Object localObject2;
    if (TextUtils.isEmpty(this.aRQ))
    {
      localObject1 = alco.a(this, alcs.agq, this.Hy);
      localObject2 = new File((String)localObject1);
      if ((!((File)localObject2).isFile()) || (!((File)localObject2).exists())) {
        break label577;
      }
      xe((String)localObject1);
    }
    label391:
    label523:
    label576:
    label577:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject2 = ((aqrc)this.app.getManager(235)).b;
        this.aRT = ((String)localObject1);
        ((alco)localObject2).av(this.app, "card." + this.Hy);
      }
      localObject1 = new LinearLayout.LayoutParams(wja.dp2px(86.0F, this.mResources), wja.dp2px(123.0F, this.mResources));
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, wja.dp2px(12.0F, this.mResources), wja.dp2px(5.0F, this.mResources), wja.dp2px(10.0F, this.mResources));
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      SparseArray localSparseArray = aldz.di;
      if (localSparseArray == null)
      {
        aldz.k(this.app);
        this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.S(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView);
        bXM();
      }
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        this.bMJ = this.bMK;
        if ((this.bMJ <= 0) || (localSparseArray.indexOfKey(this.bMJ) < 0)) {
          this.bMJ = localSparseArray.keyAt(0);
        }
        Object localObject3 = (String)localSparseArray.get(this.bMJ);
        boolean bool = gn(this.bMJ);
        this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView = new HiBoomTemplateView(this, this.bMJ, bool);
        localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject2);
        this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setImageDrawable((Drawable)localObject3);
        if ((this.Hy == 0L) || ((TextUtils.isEmpty(this.aRR)) && (this.mFrom == 1)))
        {
          this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
          this.bbV = true;
          bXL();
          label376:
          this.gO.addView(this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView, (ViewGroup.LayoutParams)localObject1);
          i = j;
          if (i >= localSparseArray.size()) {
            break label576;
          }
          j = localSparseArray.keyAt(i);
          if (j != this.bMJ) {
            break label523;
          }
        }
        for (;;)
        {
          i += 1;
          break label391;
          xe(this.aRQ);
          break;
          this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(true);
          this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView = this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
          this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.bMJ, 1, ahxs.c);
          if (!bool) {}
          for (bool = true;; bool = false)
          {
            this.bbW = bool;
            if (this.bbW) {
              this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.bMP = 1;
            }
            if (TextUtils.isEmpty(this.aRR)) {
              break label516;
            }
            xc(this.aRR);
            break;
          }
          bXL();
          break label376;
          localObject3 = (String)localSparseArray.get(j);
          HiBoomTemplateView localHiBoomTemplateView = new HiBoomTemplateView(this, j, gn(j));
          localHiBoomTemplateView.setImageDrawable(URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject2));
          this.gO.addView(localHiBoomTemplateView, (ViewGroup.LayoutParams)localObject1);
        }
      }
      return;
    }
  }
  
  public void bXL()
  {
    if ((this.Hy == 0L) || (this.Hy == 160L) || (this.Hy == 1600L)) {
      xc(aldz.bVY);
    }
    while (TextUtils.isEmpty(this.AH)) {
      return;
    }
    xc(this.AH);
  }
  
  public void bXM()
  {
    this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.atC();
    this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.invalidate();
  }
  
  void bXN()
  {
    if (this.bF.get()) {}
    long l;
    String str;
    do
    {
      do
      {
        return;
        l = alcs.agj;
        if (this.Hy != 0L) {
          break;
        }
      } while (!QV());
      str = (String)this.gF.get(this.aRQ);
      if (!TextUtils.isEmpty(str))
      {
        r(this.aRQ, str, true);
        return;
      }
      aV(this.aRQ, true);
      return;
      if ((this.Hy != 160L) && (this.Hy != 1600L)) {
        break;
      }
    } while ((!QV()) || (TextUtils.isEmpty(this.aRP)));
    r(alco.a(this, alcs.agq, this.Hy), this.aRP, true);
    return;
    if (TextUtils.isEmpty(getCurrentText()))
    {
      bXR();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView == null) {}
      for (str = "";; str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.mFontId))
      {
        VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C2", "", 1, 0, 0, "", "1", str);
        return;
      }
    }
    g(l, this.Hy, true);
  }
  
  public void bXO()
  {
    if (this.N != null)
    {
      this.N.dismiss();
      this.N = null;
    }
  }
  
  void bXP()
  {
    bXQ();
    int i;
    int j;
    if (!TextUtils.isEmpty(getCurrentText()))
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      j = 2131697221;
      label24:
      str = getString(j);
      if (i == 0) {
        break label112;
      }
      j = 2131697215;
      label38:
      this.O = aqha.a(this, str, j, 2131697208, this.jdField_G_of_type_AndroidContentDialogInterface$OnClickListener, this.F);
      this.O.show();
      if (i == 0) {
        break label119;
      }
    }
    label105:
    label112:
    label119:
    for (String str = "1";; str = "0")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C9", "", 1, 0, 0, jqc.hS(), str, "");
      return;
      i = 0;
      break;
      j = 2131697211;
      break label24;
      j = 2131697210;
      break label38;
    }
  }
  
  public void bXQ()
  {
    if (this.O != null)
    {
      this.O.dismiss();
      this.O = null;
    }
  }
  
  void bXR()
  {
    bXQ();
    this.O = aqha.a(this, getString(2131697214), 2131697205, 2131697222, this.E, this.D);
    this.O.show();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C9", "", 1, 0, 0, jqc.hS(), "2", "");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int n = j;
    if (paramInt1 != 0)
    {
      n = j;
      if (paramInt2 != 0)
      {
        n = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          n = j;
        }
      }
    }
    label43:
    int m;
    label55:
    do
    {
      do
      {
        return n;
        j = paramOptions.outHeight;
        m = paramOptions.outWidth;
        n = i;
      } while (j <= paramInt2);
      n = i;
    } while (m <= paramInt1);
    int i1 = Math.round(j / paramInt2);
    n = Math.round(m / paramInt1);
    if (i1 > n) {}
    for (;;)
    {
      n = i;
      if (i1 < 2) {
        break;
      }
      m /= 2;
      j /= 2;
      i *= 2;
      break label55;
      i1 = n;
    }
  }
  
  public void doOnBackPressed()
  {
    onClick(this.ey);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131561556);
    this.k = getSharedPreferences("vip_profile_diy_card", 0);
    this.jdField_b_of_type_ComTencentMobileqqDataCard = aqep.a(this.app, this.app.getCurrentAccountUin());
    this.mResources = super.getResources();
    paramBundle = this.mResources.getDisplayMetrics();
    this.mScreenWidth = paramBundle.widthPixels;
    this.mScreenHeight = paramBundle.heightPixels;
    this.bMH = wja.dp2px(130.0F, this.mResources);
    parseIntent();
    this.bMI = wja.dp2px(5.0F, this.mResources);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager = ((VasQuickUpdateManager)this.app.getManager(184));
    this.jdField_b_of_type_Ahxs = ((ahxs)this.app.getManager(219));
    this.jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
    addObserver(this.jdField_a_of_type_Accn);
    initViews();
    ((VasQuickUpdateManager)this.app.getManager(184)).addCallBacker(this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    bXK();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800810D", "", 1, 0, 0, jqc.hS(), "", String.valueOf(this.Hy));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mDestroy = true;
    this.jdField_a_of_type_Auru.removeCallbacks(null);
    removeObserver(this.jdField_a_of_type_Accn);
    bF();
    bPr();
    ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
  
  @TargetApi(9)
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      if (this.k.getBoolean("vip_diy_card_guide_shown", false)) {
        break label179;
      }
      if (this.d == null)
      {
        localView = getLayoutInflater().inflate(2131561555, null);
        localButton = (Button)localView.findViewById(2131363900);
        this.rC = ((ImageView)localView.findViewById(2131368252));
        this.rD = ((ImageView)localView.findViewById(2131368239));
        localButton.setOnClickListener(this);
        this.d = new PopupWindow(localView, -1, -1);
        this.d.setFocusable(true);
        this.d.setBackgroundDrawable(new BitmapDrawable());
      }
      if (!this.bE.get())
      {
        if ((this.ds != null) && (this.dt != null)) {
          break label168;
        }
        this.bE.set(true);
        ThreadManager.executeOnFileThread(new VipProfileCardDiyActivity.2(this));
      }
    }
    label168:
    label179:
    while (this.k.getBoolean("vip_diy_card_edit_guide_shown", false))
    {
      View localView;
      Button localButton;
      return;
      this.jdField_a_of_type_Auru.sendEmptyMessage(9);
      return;
    }
  }
  
  @TargetApi(11)
  public void e(View paramView)
  {
    if (this.mMode == 2) {
      return;
    }
    this.aK.setVisibility(0);
    this.aK.setFocusable(true);
    this.aK.setFocusableInTouchMode(true);
    this.aK.requestFocus();
    aurd.aO(this.aK);
    bXJ();
  }
  
  public void f(View paramView)
  {
    this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
    this.bbV = true;
    xc("");
    bXJ();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800810F", "", 1, 0, 0, jqc.hS(), "", "");
  }
  
  public void f(View paramView, float paramFloat1, float paramFloat2)
  {
    bXJ();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008110", "", 1, 0, 0, jqc.hS(), "", "");
  }
  
  public void g(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    bF();
    showProgressDialog();
    if ((!this.mDestroy) && (!isFinishing()))
    {
      this.bF.set(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (paramBoolean)) {
        break label91;
      }
      aqep.c(this.app, paramLong1, paramLong2);
      this.aRS = getCurrentText();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
        break label267;
      }
    }
    label267:
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.mFontId)
    {
      this.bMM = i;
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(6, this.WAIT_TIME);
      return;
      label91:
      i = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.mFontId;
      String str = getCurrentText();
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.d();
      localObject = String.format("%s_%s_%s_%s", new Object[] { Float.valueOf(((PointF)localObject).x / this.mScreenWidth), Float.valueOf(((PointF)localObject).y / this.mScreenHeight), Float.valueOf(this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.dtG / this.mScreenWidth), Float.valueOf(this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.dtH / this.mScreenHeight) });
      float f1 = this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.bp();
      float f2 = this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.bq();
      float f3 = (this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.getProgress() - 77) / 255.0F;
      aqep.a(this.app, paramLong1, paramLong2, null, 0L, null, i, str, (String)localObject, f1, f2, f3, "", 0L);
      break;
    }
  }
  
  public String getCurrentText()
  {
    if (this.bbV) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.getText().toString();
  }
  
  @TargetApi(9)
  public boolean handleMessage(Message paramMessage)
  {
    if ((isFinishing()) || (this.mDestroy)) {}
    do
    {
      do
      {
        return false;
        switch (paramMessage.what)
        {
        default: 
          return false;
        case 0: 
          paramMessage = new Intent(this, FriendProfileCardActivity.class);
          if (this.mFrom == 1) {
            setResult(-1, paramMessage);
          }
        case 3: 
          for (;;)
          {
            finish();
            return false;
            this.rB.setImageDrawable(this.dE);
            return false;
            paramMessage.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0));
            paramMessage.putExtra("diyTextEditResult", true);
            startActivity(paramMessage);
          }
        case 1: 
          if (!TextUtils.isEmpty((String)paramMessage.obj))
          {
            QQToast.a(this, (String)paramMessage.obj, 0).show();
            return false;
          }
          QQToast.a(this, 2131697224, 0).show();
          return false;
        case 2: 
          xd((String)paramMessage.obj);
          return false;
        case 4: 
          localObject = (View)paramMessage.obj;
        }
      } while (localObject == null);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = paramMessage.arg1;
      ((View)localObject).setLayoutParams(localLayoutParams);
      return false;
      localObject = (View)paramMessage.obj;
      if (paramMessage.arg1 != 0) {
        break;
      }
    } while (localObject == null);
    ((View)localObject).setVisibility(8);
    return false;
    if (localObject != null)
    {
      paramMessage = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      paramMessage.bottomMargin = 0;
      ((View)localObject).setLayoutParams(paramMessage);
    }
    QQToast.a(this, 1, 2131697212, 0).show();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.mFontId != this.bMJ) || (!this.bbW)) {
        break label396;
      }
      if (this.bMK != -1) {
        break label385;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
      f(null);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.g(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView, this.bMH);
      return false;
      label385:
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
      continue;
      label396:
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
    }
    bF();
    bPr();
    return false;
    Object localObject = getString(2131697213);
    paramMessage = (String)paramMessage.obj;
    if (!TextUtils.isEmpty(paramMessage)) {}
    for (;;)
    {
      QQToast.a(this, 1, paramMessage, 0).show();
      return false;
      localObject = String.format(getString(2131697227), new Object[] { Integer.valueOf(aldz.dsB) });
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage)) {}
      for (;;)
      {
        QQToast.a(this, 1, paramMessage, 0).show();
        return false;
        if ((this.ds == null) || (this.dt == null) || (this.rC == null) || (this.rD == null) || (this.d == null)) {
          break;
        }
        this.rC.setImageBitmap(this.ds);
        this.rD.setImageBitmap(this.dt);
        this.d.showAtLocation(this.jdField_b_of_type_ComTencentMobileqqProfileViewSoftInputDetectView, 80, 0, 0);
        this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
        this.k.edit().putBoolean("vip_diy_card_guide_shown", true).apply();
        return false;
        paramMessage = (Message)localObject;
      }
      paramMessage = (Message)localObject;
    }
  }
  
  public void i(View paramView, float paramFloat)
  {
    bXJ();
    String str = jqc.hS();
    if (paramFloat > 1.0F) {}
    for (paramView = "0";; paramView = "1")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008111", "", 1, 0, 0, str, paramView, "");
      return;
    }
  }
  
  @TargetApi(11)
  void initViews()
  {
    this.jdField_b_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)findViewById(2131377546));
    this.e = ((ImmersiveTitleBar2)findViewById(2131379866));
    this.ey = ((TextView)findViewById(2131369579));
    this.GY = ((TextView)findViewById(2131369612));
    this.rB = ((ImageView)findViewById(2131373635));
    this.gO = ((LinearLayout)findViewById(2131379321));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView = ((HScrollView)findViewById(2131379319));
    this.hl = ((RelativeLayout)findViewById(2131366138));
    this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout = ((SingleTouchLayout)findViewById(2131366139));
    this.aK = ((EditText)findViewById(2131366133));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar = ((VerticalSeekBar)findViewById(2131370432));
    this.iX = findViewById(2131371159);
    this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView = new DiyTextView(this);
    this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView.setBackgroundColor(0);
    this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.S(this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView);
    int i = wja.dp2px(10.0F, this.mResources);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView = new DiyDefaultTextView(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setTextSize(18.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setPadding(i, i, i, i);
    this.dL = ((Button)findViewById(2131378093));
    this.GZ = ((TextView)findViewById(2131366132));
    this.vP = findViewById(2131373573);
    this.c = ((AvatarLayout)findViewById(2131369165));
    this.Ha = ((TextView)findViewById(2131369183));
    this.Hb = ((TextView)findViewById(2131369177));
    this.Hc = ((TextView)findViewById(2131369175));
    this.Hd = ((TextView)findViewById(2131369176));
    this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)findViewById(2131382077));
    this.c.c(0, this.c.findViewById(2131363324), false);
    this.e.abu(0);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setMaxProgress(154);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setProgress(this.bML);
    this.ey.setOnClickListener(this);
    this.GY.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a = this;
    this.hl.setOnClickListener(this);
    this.aK.addTextChangedListener(this);
    this.aK.setFilters(new InputFilter[] { new InputFilter.LengthFilter(aldz.dsB) });
    this.dL.setOnClickListener(this);
    this.hl.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView.setOnMeasuredListener(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$a);
    SoftInputDetectView localSoftInputDetectView = this.jdField_b_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
    if (ImmersiveUtils.isSupporImmersive() != 1) {}
    for (boolean bool = true;; bool = false)
    {
      localSoftInputDetectView.setExcludeStatusBar(bool);
      this.jdField_b_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
      if ((this.pn > 1.4E-45F) && (this.po > 1.4E-45F)) {
        this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setCenterPoint(this.pn, this.po);
      }
      this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageScale(this.pp);
      this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageDegree(this.pq);
      return;
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
      if (this.mMode == 2)
      {
        this.mMode = 1;
        if (!this.bbV)
        {
          this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(true);
        }
        this.GY.setVisibility(0);
        this.gO.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setVisibility(0);
        this.vP.setVisibility(8);
        this.ey.setText(2131691040);
        VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800820F", "", 1, 0, 0, "", "", "");
      }
      else
      {
        bXP();
        VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800810E", "", 1, 0, 0, "", "", "");
        continue;
        this.mMode = 2;
        this.ey.setText(2131697206);
        label241:
        Object localObject1;
        if (TextUtils.isEmpty(getCurrentText()))
        {
          this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
          this.GY.setVisibility(8);
          this.gO.setVisibility(8);
          this.aK.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setVisibility(8);
          aurd.cE(this);
          this.vP.setVisibility(0);
          if (TextUtils.isEmpty(this.Ha.getText()))
          {
            this.c.setFaceDrawable(this.app, 1, this.app.getCurrentAccountUin(), 200, true, true, true, false, 3);
            this.Ha.setText(this.jdField_b_of_type_ComTencentMobileqqDataCard.strNick);
            this.Hc.setText(String.format("%s岁", new Object[] { Byte.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataCard.age) }));
            if (this.jdField_b_of_type_ComTencentMobileqqDataCard.shGender != 1) {
              break label727;
            }
            localObject1 = acfp.m(2131716793);
            label392:
            this.Hb.setText((CharSequence)localObject1);
            localObject2 = "";
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataCard.strCountry))
            {
              localObject1 = localObject2;
              if (!acfp.m(2131716792).equals(this.jdField_b_of_type_ComTencentMobileqqDataCard.strCountry)) {
                localObject1 = "" + this.jdField_b_of_type_ComTencentMobileqqDataCard.strCountry;
              }
            }
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataCard.strProvince))
            {
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject2 = (String)localObject1 + "，";
              }
              localObject2 = (String)localObject2 + this.jdField_b_of_type_ComTencentMobileqqDataCard.strProvince;
            }
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataCard.strCity))
            {
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = (String)localObject2 + "，";
              }
              localObject1 = (String)localObject1 + this.jdField_b_of_type_ComTencentMobileqqDataCard.strCity;
            }
            this.Hd.setText((CharSequence)localObject1);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
            if (this.jdField_b_of_type_ComTencentMobileqqDataCard.bVoted != 1) {
              break label756;
            }
          }
        }
        label727:
        label756:
        for (boolean bool = true;; bool = false)
        {
          ((VoteView)localObject1).a(true, bool, (int)this.jdField_b_of_type_ComTencentMobileqqDataCard.lVoteCount, this.jdField_b_of_type_ComTencentMobileqqDataCard.iVoteIncrement, null, false);
          VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CB", "", 1, 0, 0, jqc.hS(), "", "");
          break;
          this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(false);
          break label241;
          if (this.jdField_b_of_type_ComTencentMobileqqDataCard.shGender == 0)
          {
            localObject1 = acfp.m(2131716798);
            break label392;
          }
          localObject1 = "";
          break label392;
        }
        if ((this.bbV) && (this.mMode == 1))
        {
          if ((this.Hy == 0L) || (this.Hy == 160L) || (this.Hy == 1600L)) {
            xc(aldz.bVY);
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView == null) && (this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null)) {
              this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.performClick();
            }
            this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
            bXM();
            this.bbV = false;
            if ((this.bMK == -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.mFontId == this.bMJ) && (this.bbW) && (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.bMP == 0))
            {
              this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.mFontId, 1, ahxs.c);
              this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.bMP = 1;
            }
            VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008113", "", 1, 0, 0, jqc.hS(), "", "");
            break;
            xc(this.AH);
          }
        }
        this.aK.setVisibility(8);
        if (this.mMode != 2) {
          this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(true);
        }
        aurd.cE(this);
        continue;
        bXN();
        int i;
        label1012:
        int j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null)
        {
          i = 1;
          if (TextUtils.isEmpty(getCurrentText())) {
            break label1086;
          }
          j = 1;
          label1024:
          if (i == 0) {
            break label1099;
          }
          if (j == 0) {
            break label1091;
          }
          localObject1 = "2";
          label1037:
          if (i == 0) {
            break label1119;
          }
        }
        label1086:
        label1091:
        label1099:
        label1119:
        for (Object localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.mFontId);; localObject2 = "")
        {
          VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008116", "", 1, 0, 0, jqc.hS(), (String)localObject1, (String)localObject2);
          break;
          i = 0;
          break label1012;
          j = 0;
          break label1024;
          localObject1 = "1";
          break label1037;
          if (j != 0)
          {
            localObject1 = "";
            break label1037;
          }
          localObject1 = "0";
          break label1037;
        }
        if (this.d != null)
        {
          this.d.dismiss();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
            this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
          }
        }
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if (this.mMaxSize <= 0)
    {
      this.mMaxSize = (this.hl.getWidth() * 2 / 3);
      this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView.setMaxSize(this.mMaxSize);
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    paramSeekBar = this.iX;
    if (paramInt > 77) {}
    for (int i = -16777216;; i = -1)
    {
      paramSeekBar.setBackgroundColor(i);
      this.iX.getBackground().setAlpha(Math.abs(paramInt - 77));
      this.bML = paramInt;
      return;
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.bMN = this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.getProgress();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.getProgress() - this.bMN > 0) {}
    for (String str = "1";; str = "0")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CC", "", 1, 0, 0, "", str, "");
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = aofy.of(paramCharSequence.toString());
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView.setText(paramCharSequence);
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setText(paramCharSequence);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView == null) {}
      for (boolean bool = this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.g(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView, this.bMH);; bool = this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.S(this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView))
      {
        if (bool) {
          bXM();
        }
        return;
      }
    }
    if (!this.bbV) {}
    this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView.setText(" ");
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setText("");
  }
  
  void parseIntent()
  {
    Intent localIntent = getIntent();
    this.mFrom = localIntent.getIntExtra("extra_from", -1);
    this.Hy = localIntent.getLongExtra("extra_card_id", -1L);
    if (this.Hy == -1L) {
      finish();
    }
    this.aRP = localIntent.getStringExtra("extra_card_url");
    this.AH = localIntent.getStringExtra("extra_card_default_text");
    if (TextUtils.isEmpty(this.AH)) {
      this.AH = aRO;
    }
    this.aRQ = localIntent.getStringExtra("extra_card_path");
    label141:
    int i;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataCard.diyText))
    {
      this.aRR = this.jdField_b_of_type_ComTencentMobileqqDataCard.diyText;
      if (this.jdField_b_of_type_ComTencentMobileqqDataCard.diyTextFontId <= 0) {
        break label297;
      }
      this.bMK = this.jdField_b_of_type_ComTencentMobileqqDataCard.diyTextFontId;
      if ((this.Hy == 0L) || (this.Hy != this.jdField_b_of_type_ComTencentMobileqqDataCard.lCurrentBgId)) {
        break label312;
      }
      i = 1;
      label167:
      if ((i == 0) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataCard.diyText))) {
        break label317;
      }
      this.pn = (this.jdField_b_of_type_ComTencentMobileqqDataCard.diyTextLocX * this.mScreenWidth);
      this.po = (this.jdField_b_of_type_ComTencentMobileqqDataCard.diyTextLocY * this.mScreenHeight);
      this.pp = this.jdField_b_of_type_ComTencentMobileqqDataCard.diyTextScale;
      this.pq = this.jdField_b_of_type_ComTencentMobileqqDataCard.diyTextDegree;
      this.bML = ((int)(this.jdField_b_of_type_ComTencentMobileqqDataCard.diyTextTransparency * 255.0F));
      label256:
      if (this.bML >= -77) {
        break label389;
      }
      this.bML = -77;
    }
    for (;;)
    {
      this.bML += 77;
      return;
      this.aRR = localIntent.getStringExtra("extra_card_text");
      break;
      label297:
      this.bMK = localIntent.getIntExtra("extra_card_font", -1);
      break label141;
      label312:
      i = 0;
      break label167;
      label317:
      this.pn = localIntent.getFloatExtra("extra_card_x", 1.4E-45F);
      this.po = localIntent.getFloatExtra("extra_card_y", 1.4E-45F);
      this.pp = localIntent.getFloatExtra("extra_card_scale", 1.0F);
      this.pq = localIntent.getFloatExtra("extra_card_rotation", 0.0F);
      this.bML = ((int)(localIntent.getFloatExtra("extra_card_transparency", 0.0F) * 255.0F));
      break label256;
      label389:
      if (this.bML > 77) {
        this.bML = 77;
      }
    }
  }
  
  public void r(String paramString1, String paramString2, boolean paramBoolean)
  {
    showProgressDialog();
    long l = alcs.agj;
    if ((!this.mDestroy) && (!isFinishing()))
    {
      this.bF.set(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (paramBoolean)) {
        break label86;
      }
      aqep.a(this.app, l, 160L, paramString2, aqep.fb(paramString1), null);
      this.aRS = getCurrentText();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
        break label295;
      }
    }
    label295:
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.mFontId)
    {
      this.bMM = i;
      return;
      label86:
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.mFontId;
      String str = getCurrentText();
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.d();
      localObject = String.format("%s_%s_%s_%s", new Object[] { Float.valueOf(((PointF)localObject).x / this.mScreenWidth), Float.valueOf(((PointF)localObject).y / this.mScreenHeight), Float.valueOf(this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.dtG / this.mScreenWidth), Float.valueOf(this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.dtH / this.mScreenHeight) });
      float f1 = this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.bp();
      float f2 = this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.bq();
      float f3 = (this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.getProgress() - 77) / 255.0F;
      if ((TextUtils.isEmpty(str)) || (j == 0)) {}
      for (i = 160;; i = 1600)
      {
        aqep.a(this.app, l, i, paramString2, aqep.fb(paramString1), null, j, str, (String)localObject, f1, f2, f3, "", 0L);
        break;
      }
    }
  }
  
  void showProgressDialog()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_G_of_type_Arhz = new arhz(this, getTitleBarHeight());
        this.jdField_G_of_type_Arhz.setCancelable(false);
        this.jdField_G_of_type_Arhz.setMessage(2131697313);
        this.jdField_G_of_type_Arhz.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void xc(String paramString)
  {
    this.aK.setText(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      this.aK.setSelection(paramString.length());
    }
  }
  
  void xd(String paramString)
  {
    bXO();
    int j;
    boolean bool;
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (!TextUtils.isEmpty(getCurrentText())))
    {
      j = 1;
      bool = VipUtils.ce(this.app);
      str = getString(2131697204);
      if (!TextUtils.isEmpty(paramString)) {
        break label312;
      }
      if ((this.Hy != 0L) && (this.Hy != 160L) && (this.Hy != 1600L)) {
        break label239;
      }
      if (j == 0) {
        break label228;
      }
      if (!bool) {
        break label217;
      }
      paramString = getString(2131697202);
    }
    label143:
    label274:
    label281:
    label305:
    label312:
    for (;;)
    {
      label96:
      int m;
      label126:
      int i;
      if (((this.Hy == 0L) || (this.Hy == 160L)) && (bool))
      {
        m = 2131697223;
        if (this.bMO != 2) {
          break label281;
        }
        if (!bool) {
          break label274;
        }
        i = 2131697219;
        this.N = aqha.a(this, 0, str, paramString, m, i, this.v, this.w);
        this.N.show();
        if (j != 0) {
          if (!bool) {
            break label305;
          }
        }
      }
      for (paramString = "4";; paramString = "3")
      {
        VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C9", "", 1, 0, 0, jqc.hS(), paramString, "");
        return;
        j = 0;
        break;
        label217:
        paramString = getString(2131697200);
        break label96;
        label228:
        paramString = getString(2131697201);
        break label96;
        label239:
        if (bool)
        {
          paramString = getString(2131697203);
          break label96;
        }
        paramString = getString(2131697200);
        break label96;
        m = 2131721058;
        break label126;
        i = 2131697216;
        break label143;
        if (VipUtils.cf(this.app))
        {
          i = 2131697220;
          break label143;
        }
        i = 2131697217;
        break label143;
      }
    }
  }
  
  public void xe(String paramString)
  {
    ThreadManager.executeOnFileThread(new VipProfileCardDiyActivity.11(this, paramString));
  }
  
  public void yL(int paramInt)
  {
    if (paramInt == 1) {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008115", "", 1, 0, 0, jqc.hS(), "", "");
    }
  }
  
  public class DiyDefaultTextView
    extends TextView
  {
    public DiyDefaultTextView(Context paramContext)
    {
      super();
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      paramInt1 = getMeasuredWidth();
      paramInt2 = getMeasuredHeight();
      VipProfileCardDiyActivity.this.a.fb(paramInt1, paramInt2);
    }
  }
  
  public class HiBoomTemplateView
    extends RelativeLayout
    implements View.OnClickListener
  {
    VasQuickUpdateManager.CallBacker b;
    public int bMP;
    public int mFontId;
    ImageView ny;
    ImageView rE;
    View vQ;
    public View vR;
    
    public HiBoomTemplateView(Context paramContext, int paramInt, boolean paramBoolean)
    {
      super();
      paramContext = VipProfileCardDiyActivity.this.getLayoutInflater().inflate(2131561558, this, true);
      this.ny = ((ImageView)paramContext.findViewById(2131379312));
      this.rE = ((ImageView)paramContext.findViewById(2131377966));
      this.vQ = paramContext.findViewById(2131368914);
      this.vR = paramContext.findViewById(2131373684);
      this.mFontId = paramInt;
      if (paramBoolean)
      {
        this.bMP = 2;
        ahxo.a().b(paramInt, 1, ahxs.c);
      }
      for (;;)
      {
        setOnClickListener(this);
        return;
        this.bMP = 0;
        this.vR.setVisibility(0);
        this.b = new wfy(this, VipProfileCardDiyActivity.this);
        VipProfileCardDiyActivity.this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager.addCallBacker(this.b);
      }
    }
    
    public void onClick(View paramView)
    {
      if (VipProfileCardDiyActivity.this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
        VipProfileCardDiyActivity.this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
      }
      setChecked(true);
      VipProfileCardDiyActivity.this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView = this;
      VipProfileCardDiyActivity.this.jdField_b_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.mFontId, 1, ahxs.c);
      ahxp localahxp = ahxo.a().b(this.mFontId, 1, ahxs.c);
      if (this.bMP == 0)
      {
        if (!localahxp.cY.get()) {
          break label212;
        }
        this.bMP = 1;
      }
      for (;;)
      {
        VipProfileCardDiyActivity.this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setCenterPoint(VipProfileCardDiyActivity.this.hl.getWidth() / 2, VipProfileCardDiyActivity.this.hl.getHeight() / 2);
        if (VipProfileCardDiyActivity.this.bbV)
        {
          VipProfileCardDiyActivity.this.bbV = false;
          VipProfileCardDiyActivity.this.jdField_b_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
          VipProfileCardDiyActivity.this.bXL();
        }
        VipProfileCardDiyActivity.this.onTextChanged(VipProfileCardDiyActivity.this.getCurrentText(), 0, 0, 0);
        VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008114", "", 1, 0, 0, jqc.hS(), "", String.valueOf(this.mFontId));
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label212:
        if (!localahxp.cX.get())
        {
          this.bMP = 1;
          localahxp.KE(true);
        }
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (VipProfileCardDiyActivity.this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager != null) {
        VipProfileCardDiyActivity.this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager.removeCallBacker(this.b);
      }
    }
    
    public void setChecked(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.vQ.setBackgroundColor(VipProfileCardDiyActivity.this.mResources.getColor(2131166183));
        this.rE.setVisibility(0);
        return;
      }
      this.vQ.setBackgroundColor(0);
      this.rE.setVisibility(8);
    }
    
    public void setImageDrawable(Drawable paramDrawable)
    {
      this.ny.setImageDrawable(paramDrawable);
    }
  }
  
  public static abstract interface a
  {
    public abstract void fb(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity
 * JD-Core Version:    0.7.0.1
 */