package com.tencent.mobileqq.ocr;

import acfp;
import adld;
import ahbj;
import ahqt;
import ahqt.a;
import ahqw;
import ahqy;
import aklu;
import aklv;
import aklw;
import aklx;
import akly;
import aklz;
import aklz.a;
import akoq;
import akor;
import akor.a;
import akpm;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anot;
import aofz;
import aqcl;
import aqhu;
import auru;
import ausj;
import axol;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.view.EyeButton;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;
import wja;

public class OCRPerformFragment
  extends PublicBaseFragment
  implements aklz.a, akor.a, Handler.Callback, View.OnClickListener
{
  BroadcastReceiver A = null;
  private ImageView BO;
  private ImageView BP;
  private View Ft;
  private WeakReference<QQAppInterface> K;
  private TextView Wl;
  private ahqy jdField_a_of_type_Ahqy;
  private BubbleLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout;
  private OcrImageTextView jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
  private GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private LinearLayout aV;
  private long adU = -1L;
  private ahqw jdField_b_of_type_Ahqw = new akly(this);
  private ScanSuccessView jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView;
  private String bTJ;
  private RelativeLayout bt;
  int businessType;
  private boolean csM;
  private boolean csN;
  private boolean csO;
  private boolean csP;
  private boolean csQ;
  private int dnA;
  public final auru e = new auru(Looper.getMainLooper(), this);
  private RelativeLayout et;
  private String lS;
  private RelativeLayout lt;
  private ausj mActionSheet;
  private BaseActivity mActivity;
  
  private void Nx(String paramString)
  {
    aklz.o(n());
    Intent localIntent = new Intent(this.mActivity, OCRResultFragmentNew.class);
    localIntent.putExtra("param_ocr_path", paramString);
    PublicFragmentActivity.start(this.mActivity, localIntent, OCRResultFragmentNew.class);
    this.mActivity.overridePendingTransition(0, 0);
  }
  
  private void a(boolean paramBoolean, String paramString, ArrayList<String> paramArrayList, ahqy paramahqy)
  {
    this.aV.setVisibility(0);
    this.aV.bringToFront();
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "updateOcrResult, 更新OCR结果，主线程调用, succ:" + paramBoolean);
    }
    this.adU = (System.currentTimeMillis() - this.adU);
    if ((paramBoolean) && (paramahqy.wZ != null) && (!paramahqy.wZ.isEmpty()))
    {
      int i = aqhu.getExifOrientation(this.lS);
      aklz.n(aklz.a(paramahqy.wZ));
      aklz.b(paramString, paramArrayList, paramahqy.lf);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(paramahqy.wZ, paramahqy.daN, paramahqy.daO, paramahqy.mMd5, i);
      aqcl.changeAccessibilityForView(this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView, aklz.o(), null);
      if (aklz.d != null)
      {
        aklz.d.bLp = paramahqy.mLanguage;
        aklz.d.chatType = this.businessType;
        aklz.d.bLq = paramahqy.mMd5;
        aklz.d.imagePath = this.lS;
        aklz.d.bLs = paramahqy.url;
        aklz.d.daK = paramahqy.reqWidth;
        aklz.d.daL = paramahqy.reqHeight;
        aklz.d.fileSize = paramahqy.fileSize;
        aklz.d.bLr = paramahqy.bLt;
      }
      if (this.adU > 0L) {
        aklz.cN("0X800AD16", (int)this.adU);
      }
      if (this.dnA <= 1) {
        aklz.cN("0X800AD17", 0);
      }
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701455, 0).show();
    aklz.cN("0X800AD18", 0);
    onBackEvent();
  }
  
  private void b(ahqt.a parama)
  {
    if (!ahbj.isFileExists(parama.imagePath))
    {
      QLog.d("OCRPerformFragment", 1, "requestOcr, file not exist, picPath:" + parama.imagePath);
      QQToast.a(this.mActivity, 1, 2131701454, 0).show();
      return;
    }
    if (this.csN)
    {
      QLog.d("OCRPerformFragment", 1, "requestOcr, in ocr request, " + parama.imagePath);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "requestOcr:" + parama.imagePath);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.MX(true);
    dBL();
    this.csN = true;
    this.adU = System.currentTimeMillis();
    ((ahqt)((QQAppInterface)this.K.get()).getManager(353)).a(parama, this.jdField_b_of_type_Ahqw);
    this.dnA += 1;
  }
  
  public static void b(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, OCRPerformFragment.class);
    localIntent.putExtra("param_ocr_path", paramString1);
    localIntent.putExtra("PARAM_FROM", paramInt1);
    localIntent.addFlags(67108864);
    localIntent.putExtra("param_ocr_md5", paramString2);
    localIntent.putExtra("param_business_type", paramInt2);
    PublicFragmentActivity.start(paramActivity, localIntent, OCRPerformFragment.class);
    paramActivity.overridePendingTransition(0, 0);
    aklz.cN("0X80082C7", 0);
  }
  
  private void bBS()
  {
    this.mActionSheet = ausj.b(this.mActivity);
    this.mActionSheet.addButton(this.bTJ);
    this.mActionSheet.addButton(2131701439);
    this.mActionSheet.addCancelButton(2131721058);
    this.mActionSheet.a(new aklw(this));
    this.mActionSheet.show();
  }
  
  private void dBH()
  {
    SharedPreferences localSharedPreferences = ((QQAppInterface)this.K.get()).getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_guide_" + ((QQAppInterface)this.K.get()).getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.BP.setImageResource(2130842279);
      this.Wl.setText(2131701484);
      this.lt.setVisibility(0);
      localSharedPreferences.edit().putBoolean(str, false).commit();
      return;
    }
    this.lt.setVisibility(8);
  }
  
  private void dBI()
  {
    SharedPreferences localSharedPreferences = ((QQAppInterface)this.K.get()).getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_select_guide_" + ((QQAppInterface)this.K.get()).getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.lt.setVisibility(0);
      this.BP.setImageResource(2130842280);
      this.Wl.setText(2131701485);
      localSharedPreferences.edit().putBoolean(str, false).commit();
      return;
    }
    this.lt.setVisibility(8);
  }
  
  private void dBJ()
  {
    SharedPreferences localSharedPreferences = ((QQAppInterface)this.K.get()).getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_fullText_guide_" + ((QQAppInterface)this.K.get()).getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(0);
      localSharedPreferences.edit().putBoolean(str, false).commit();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
  }
  
  private void dBK()
  {
    String str1 = getResources().getString(2131701483);
    String str2 = getResources().getString(2131701486);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.asf())
    {
      OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.Ft.findViewById(2131372600);
      String str3 = String.valueOf(localOCRBottomTabView.A());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.Ft.findViewById(2131372603);
      str3 = String.valueOf(localOCRBottomTabView.A());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.Ft.findViewById(2131372604);
      str3 = String.valueOf(localOCRBottomTabView.A());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.Ft.findViewById(2131372602);
      str3 = String.valueOf(localOCRBottomTabView.A());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3.replace(str1, str2));
      }
      this.bTJ = this.bTJ.replace(str1, str2);
      return;
    }
    ((OCRBottomTabView)this.Ft.findViewById(2131372600)).setTabText(getResources().getString(2131701480));
    ((OCRBottomTabView)this.Ft.findViewById(2131372603)).setTabText(getResources().getString(2131693966));
    ((OCRBottomTabView)this.Ft.findViewById(2131372604)).setTabText(getResources().getString(2131701474));
    ((OCRBottomTabView)this.Ft.findViewById(2131372602)).setTabText(getResources().getString(2131701481));
    this.bTJ = getResources().getString(2131701440);
  }
  
  private void dBL()
  {
    this.bt.setVisibility(8);
    this.aV.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this.mActivity);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setShowProgress(false);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ankt.SCREEN_WIDTH);
      this.et.addView(this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(acfp.m(2131709344));
    }
    if (this.BO == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.BO = new ImageView(this.mActivity);
      this.BO.setImageResource(2130844107);
      localLayoutParams.leftMargin = wja.dp2px(12.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label225;
      }
    }
    label225:
    for (localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(this.mActivity) + wja.dp2px(12.0F, getResources()));; localLayoutParams.topMargin = wja.dp2px(12.0F, getResources()))
    {
      this.et.addView(this.BO, localLayoutParams);
      this.BO.setOnClickListener(new aklx(this));
      this.BO.bringToFront();
      return;
    }
  }
  
  private void dBM()
  {
    if (this.BO != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "hideInRecoViewAnimation, mRecognizeBackBtn");
      }
      this.BO.setVisibility(8);
      this.et.removeView(this.BO);
      this.BO = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "hideInRecoViewAnimation, mRecognizeView");
      }
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setVisibility(8);
      this.et.removeView(this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView = null;
    }
    this.bt.setVisibility(0);
    this.aV.setVisibility(0);
  }
  
  private void hx(View paramView)
  {
    Object localObject = (OCRBottomTabView)paramView.findViewById(2131372603);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.enableTalkBack) && (((OCRBottomTabView)localObject).isEnabled())) {
      aqcl.speak((View)localObject, String.valueOf(((OCRBottomTabView)localObject).A()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372602);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.enableTalkBack) && (((OCRBottomTabView)localObject).isEnabled())) {
      aqcl.speak((View)localObject, String.valueOf(((OCRBottomTabView)localObject).A()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372601);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.enableTalkBack) && (((OCRBottomTabView)localObject).isEnabled())) {
      aqcl.speak((View)localObject, String.valueOf(((OCRBottomTabView)localObject).A()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372600);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.enableTalkBack) && (((OCRBottomTabView)localObject).isEnabled())) {
      aqcl.speak((View)localObject, String.valueOf(((OCRBottomTabView)localObject).A()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372604);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.enableTalkBack) && (((OCRBottomTabView)localObject).isEnabled())) {
      aqcl.speak((View)localObject, String.valueOf(((OCRBottomTabView)localObject).A()).trim());
    }
    this.bTJ = getResources().getString(2131701440);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView = ((OcrImageTextView)paramView.findViewById(2131372594));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setHideAnimLisnter(this);
    this.et = ((RelativeLayout)paramView.findViewById(2131372596));
    localObject = (ImageButton)paramView.findViewById(2131372598);
    ((ImageButton)localObject).setOnClickListener(this);
    aqcl.changeAccessibilityForView((View)localObject, getResources().getString(2131691039), null);
    this.lt = ((RelativeLayout)paramView.findViewById(2131372595));
    this.lt.setOnClickListener(this);
    this.BP = ((ImageView)paramView.findViewById(2131372590));
    this.Wl = ((TextView)paramView.findViewById(2131372591));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)paramView.findViewById(2131372586));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    localObject = (EyeButton)paramView.findViewById(2131372599);
    aqcl.changeAccessibilityForView((View)localObject, getResources().getString(2131701479), null);
    ((EyeButton)localObject).setLonTouchListener(new aklv(this));
    this.bt = ((RelativeLayout)paramView.findViewById(2131372597));
    this.bt.bringToFront();
    adld.l(this.mActivity, this.bt);
    this.aV = ((LinearLayout)paramView.findViewById(2131372593));
    this.aV.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramView.findViewById(2131367962));
  }
  
  private void lI(List<akoq> paramList)
  {
    paramList = new akor(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout, paramList, this, this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(paramList);
  }
  
  private CharSequence n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.asf())) {}
    for (CharSequence localCharSequence = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.p();; localCharSequence = aklz.o())
    {
      aklz.o(localCharSequence);
      return localCharSequence;
    }
  }
  
  public boolean arX()
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a().getZoom();
    boolean bool;
    if (f > 1.0F) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, new Object[] { "checkImageFitView, zoom:", Float.valueOf(f), " result:", Boolean.valueOf(bool) });
      }
      return bool;
      if (f == 1.0F)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.kK(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.getHeight())) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public void dBN()
  {
    dBK();
  }
  
  public void dBO()
  {
    if (!this.csO)
    {
      this.csO = true;
      dBI();
    }
    do
    {
      return;
      if ((!this.csP) && (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.kK(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.getHeight())))
      {
        this.csP = true;
        dBH();
        return;
      }
    } while (this.csQ);
    this.csQ = true;
    dBJ();
  }
  
  public void dbE()
  {
    if (!this.csP)
    {
      this.csP = true;
      dBH();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OCRPerformFragment", 2, "what:" + paramMessage.what);
    }
    if (paramMessage.what == 100)
    {
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setImageBitmap(paramMessage);
        this.csM = true;
        if (this.jdField_a_of_type_Ahqy != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("OCRPerformFragment", 2, "onUpdate useLocalResult！");
          }
          this.jdField_b_of_type_Ahqw.onUpdate(100, true, this.jdField_a_of_type_Ahqy);
        }
      }
    }
    do
    {
      do
      {
        return true;
        QQToast.a(this.mActivity, 1, 2131701445, 0).show();
        onBackEvent();
        return true;
        if (paramMessage.what == 101)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701455, 0).show();
          onBackEvent();
          return true;
        }
      } while (paramMessage.what != 102);
      paramMessage = (ahqy)paramMessage.obj;
    } while (paramMessage == null);
    if (this.csM)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OCRPerformFragment", 2, "onUpdate useRspCache！");
      }
      this.jdField_b_of_type_Ahqw.onUpdate(100, true, paramMessage);
      return true;
    }
    this.jdField_a_of_type_Ahqy = paramMessage;
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771991, 2130771989);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(5);
      paramActivity.getWindow().addFlags(134217728);
    }
  }
  
  public void lJ(List<akoq> paramList)
  {
    if (paramList != null) {
      lI(paramList);
    }
    dBM();
    dBO();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = ((BaseActivity)paramActivity);
  }
  
  public boolean onBackEvent()
  {
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = 2;
    int j = 1;
    boolean bool = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aklz.cN("0X800AAE0", 0);
      onBackEvent();
      continue;
      OcrImageTextView localOcrImageTextView = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
      if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.ase()) {}
      for (;;)
      {
        localOcrImageTextView.setShowTextMask(bool);
        break;
        bool = false;
      }
      aklz.I(this.mActivity, this.lS);
      aklz.cN("0X800AAE2", 0);
      continue;
      aofz.hG(String.valueOf(n()), "OCRPerformFragment");
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.asf()) {
        i = 2;
      }
      aklz.cN("0X800AAE7", i);
      continue;
      TranslateFragment.d(this.mActivity, String.valueOf(n()));
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.asf()) {}
      for (;;)
      {
        aklz.cN("0X800AAEB", i);
        break;
        i = 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.asf()) {}
      for (;;)
      {
        aklz.cN("0X800AAE8", i);
        bBS();
        break;
        i = 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout != null) && (this.aV.getVisibility() != 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
      }
      Nx(this.lS);
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.asf()) {}
      for (;;)
      {
        aklz.cN("0X800AAEC", i);
        break;
        i = 1;
      }
      aofz.hG(String.valueOf(n()), "OCRPerformFragment");
      aklz.cN("0X800AAEF", 0);
      continue;
      aklz.H(this.mActivity, String.valueOf(n()));
      aklz.cN("0X800AAF0", 0);
      continue;
      TranslateFragment.d(this.mActivity, String.valueOf(n()));
      aklz.cN("0X800AB91", 0);
      continue;
      this.lt.setVisibility(8);
      dBO();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    this.lS = paramBundle.getStringExtra("param_ocr_path");
    if (QLog.isColorLevel()) {
      QLog.e("OCRPerformFragment", 2, "mPicPath=" + this.lS);
    }
    int i = paramBundle.getIntExtra("param_business_type", -1);
    paramBundle = paramBundle.getStringExtra("param_ocr_md5");
    if (aklz.d == null)
    {
      aklz.d = new ahqt.a();
      aklz.d.bLp = "";
      aklz.d.aIG = false;
    }
    aklz.d.chatType = i;
    aklz.d.bLq = paramBundle;
    aklz.d.imagePath = this.lS;
    this.A = new aklu(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      getActivity().registerReceiver(this.A, paramBundle);
      this.K = new WeakReference((QQAppInterface)axol.getAppInterface());
      if (this.K.get() != null) {
        ((QQAppInterface)this.K.get()).addObserver(this.jdField_b_of_type_Ahqw);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561515, paramViewGroup, false);
    hx(paramLayoutInflater);
    ThreadManager.excute(new OCRPerformFragment.2(this), 16, null, true);
    b(aklz.d);
    this.Ft = paramLayoutInflater;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "onDestroy!");
    }
    if (this.A != null)
    {
      this.mActivity.unregisterReceiver(this.A);
      this.A = null;
    }
    ((QQAppInterface)this.K.get()).removeObserver(this.jdField_b_of_type_Ahqw);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.clear();
    }
    aklz.releaseCache();
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getIntExtra("sub_business_id", -1) == 103))
    {
      if (!this.mActivity.isInMultiWindow()) {
        break label81;
      }
      QQToast.a(this.mActivity, 2131697437, 0).show();
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
      return;
      label81:
      this.lS = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setImageURI(Uri.fromFile(new File(this.lS)));
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().resetState();
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setShowTextMask(false);
      aklz.d.reset();
      aklz.d.setPath(this.lS);
      aklz.d.Kw(true);
      b(aklz.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment
 * JD-Core Version:    0.7.0.1
 */