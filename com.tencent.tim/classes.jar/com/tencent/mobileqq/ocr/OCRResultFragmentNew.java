package com.tencent.mobileqq.ocr;

import aavp;
import acfp;
import adld;
import ahbj;
import ahqs;
import ahqt.a;
import ahqw;
import aklz;
import aklz.b;
import akmp;
import akmq;
import akmr;
import akms;
import akmt;
import akmu;
import akmv;
import akmw;
import akmx;
import akmy;
import akoy;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aobw;
import aobx;
import aobz;
import aofk;
import aofz;
import aoga;
import aogb;
import aqgz;
import aqiw;
import ausj;
import axol;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu.ProgressView;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class OCRResultFragmentNew
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  public static final String[] fL = { "M3X", "U20", "ZTE C2016", "Lenovo K900", "HUAWEI MT7-CL00", "HUAWEI G7-TL00", "PE-CL00", "Moto X Pro", "X907", "ASUS_Z00ADB", "HUAWEI P7-L07", "XT1581", "M821", "R7c" };
  ImageView BT;
  private MqqHandler jdField_K_of_type_MqqOsMqqHandler;
  private WeakReference<QQAppInterface> jdField_K_of_type_MqqUtilWeakReference;
  TextView Wp;
  public ParticipleView a;
  public ausj ak;
  private Dialog ay;
  private akoy jdField_b_of_type_Akoy;
  private aobz jdField_b_of_type_Aobz = new akmw(this, this.mActivity);
  private aogb jdField_b_of_type_Aogb = new akmv(this);
  private TextPreviewMenu.ProgressView jdField_b_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView;
  GestureFrameLayout jdField_b_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  ParticipleBottomMenuView jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView;
  FrameLayout bO;
  EditText bv;
  URLImageView bz;
  private ahqw c;
  public OCRBottomTabView c;
  private boolean csN;
  private boolean csW;
  public OCRBottomTabView d;
  private int dnB = -1;
  private int dnC = -1;
  ViewGroup ek;
  public ViewGroup em;
  View hY;
  private String lS;
  private BaseActivity mActivity;
  public View mRoot;
  ViewGroup r;
  
  public OCRResultFragmentNew()
  {
    this.jdField_c_of_type_Ahqw = new akmq(this);
  }
  
  private void NE(String paramString)
  {
    if (!aqiw.isNetSupport(this.mActivity)) {
      QQToast.a(this.mActivity, acfp.m(2131709348), 0).show(getResources().getDimensionPixelSize(2131299627));
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    dCf();
    ((aoga)((QQAppInterface)this.jdField_K_of_type_MqqUtilWeakReference.get()).getBusinessHandler(161)).aO((QQAppInterface)this.jdField_K_of_type_MqqUtilWeakReference.get(), paramString);
    anot.a((QQAppInterface)this.jdField_K_of_type_MqqUtilWeakReference.get(), "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
  }
  
  private void NF(String paramString)
  {
    if (!aqiw.isNetworkAvailable(this.mActivity))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, network error");
      QQToast.a(this.mActivity, 1, 2131693404, 0).show();
      return;
    }
    if (!ahbj.isFileExists(paramString))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, file not exist, picPath:" + paramString);
      QQToast.a(this.mActivity, 1, 2131701454, 0).show();
      return;
    }
    if (this.csW)
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, in export request, " + paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultFragmentNew", 2, String.format("requestExport2Doc: %s", new Object[] { this.lS }));
    }
    this.csW = true;
    this.lS = paramString;
    ((aobx)((QQAppInterface)this.jdField_K_of_type_MqqUtilWeakReference.get()).getBusinessHandler(157)).RK(this.lS);
  }
  
  private void Sa(int paramInt)
  {
    this.dnB = paramInt;
    if (paramInt == 0)
    {
      this.hY.setVisibility(0);
      adld.l(this.mActivity, this.hY);
      this.mRoot.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166705)));
      this.ek.setVisibility(0);
      this.bv.setVisibility(0);
      this.r.setVisibility(0);
      this.bv.setText(a(aklz.p(), true));
      this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      this.a.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(getResources().getDrawable(2130842282));
      this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabText(getResources().getString(2131711993));
      w(this.mActivity);
      adld.a(this.mActivity, this.em, false, 0);
    }
    if (paramInt == 2)
    {
      w(this.mActivity);
      dCe();
      this.ek.setVisibility(8);
      this.bv.setVisibility(8);
      this.r.setVisibility(8);
      this.hY.setVisibility(8);
      this.a.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.eig();
      this.mRoot.setBackgroundDrawable(getResources().getDrawable(2130838415));
      adld.l(this.mActivity, this.a);
      adld.a(this.mActivity, this.em, false, 0);
    }
  }
  
  private CharSequence a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new aofk(paramCharSequence, 8, 16);
    }
    return String.valueOf(paramCharSequence);
  }
  
  private void a(aklz.b paramb)
  {
    if ((paramb == null) || (paramb.Eb.isEmpty())) {
      return;
    }
    this.ak = ausj.b(this.mActivity);
    this.ak.setMainTitle(2131701460);
    ArrayList localArrayList = new ArrayList(paramb.Eb.size());
    Iterator localIterator = paramb.Eb.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = paramb.f((String)localIterator.next());
      if (localPair != null)
      {
        this.ak.addRadioButton((CharSequence)localPair.second, ((String)localPair.first).equalsIgnoreCase(paramb.bTK));
        localArrayList.add(localPair.first);
      }
    }
    this.ak.addCancelButton(2131721058);
    this.ak.a(new akmy(this, localArrayList, paramb));
    try
    {
      this.ak.show();
      return;
    }
    catch (Exception paramb)
    {
      paramb.printStackTrace();
    }
  }
  
  public static boolean arY()
  {
    boolean bool = false;
    String str = aqgz.getDeviceModel();
    int i;
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = fL;
      int j = arrayOfString.length;
      i = 0;
      if (i < j) {
        if (!str.equals(arrayOfString[i])) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultFragmentNew", 2, "isSupportAddContextMenu mode:" + str + ",isSupport: " + bool);
      }
      return bool;
      i += 1;
      break;
      bool = true;
    }
  }
  
  private void b(ahqt.a parama)
  {
    if (!ahbj.isFileExists(parama.imagePath))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestOcr, file not exist, picPath:" + parama.imagePath);
      QQToast.a(this.mActivity, 1, 2131701454, 0).show();
    }
    do
    {
      return;
      if (this.csN)
      {
        QQToast.a(this.mActivity, 0, 2131701457, 0).show();
        QLog.d("OCRResultFragmentNew", 1, "requestOcr, in ocr request, " + parama.imagePath);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultFragmentNew", 2, "requestOcr:" + parama.imagePath);
      }
      this.csN = true;
      parama = (ahqs)((QQAppInterface)this.jdField_K_of_type_MqqUtilWeakReference.get()).getBusinessHandler(170);
    } while (parama == null);
    parama.a(aklz.d);
  }
  
  private void dBR()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setOnMenuClickListener(new akmx(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.a(this.a);
  }
  
  private void dCe()
  {
    aavp localaavp = aavp.a();
    if ((localaavp.isSelected()) && (localaavp.Xy())) {
      localaavp.detach();
    }
  }
  
  private void dCf()
  {
    if (this.ay == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView = new TextPreviewMenu.ProgressView(this.mActivity);
      this.ay = new ReportDialog(this.mActivity);
      if (this.ay.getWindow() != null) {
        this.ay.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      this.ay.setCanceledOnTouchOutside(false);
      this.ay.requestWindowFeature(1);
      this.ay.setContentView(this.jdField_b_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView);
      this.ay.setOnCancelListener(new TextPreviewMenu.a(this.mActivity));
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(acfp.m(2131709350));
      this.ay.show();
      return;
      this.ay.dismiss();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void f(EditText paramEditText)
  {
    paramEditText.setLinkTextColor(Color.parseColor("#12B7F5"));
    if (AppSetting.enableTalkBack) {
      paramEditText.setAutoLinkMask(7);
    }
    for (;;)
    {
      paramEditText.addTextChangedListener(new akmr(this));
      if (arY()) {
        paramEditText.setCustomSelectionActionModeCallback(new akms(this, paramEditText));
      }
      this.mRoot.getViewTreeObserver().addOnGlobalLayoutListener(new akmt(this, paramEditText));
      paramEditText.setOnTouchListener(new akmu(this));
      return;
      paramEditText.setAutoLinkMask(0);
    }
  }
  
  private void w(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity != null) {
      ((InputMethodManager)paramBaseActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.bv.getWindowToken(), 0);
    }
  }
  
  protected void ND(String paramString)
  {
    try
    {
      Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://docs.qq.com/desktop/m/index.html?_from=1";
      }
      paramString = aobw.bD(str, "s_qq_ocr_save");
      localIntent.putExtra("tdsourcetag", "s_qq_ocr_save");
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
      localIntent.putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
      if (!TeamWorkDocEditBrowserActivity.g(this.mActivity, paramString, localIntent.getStringExtra("tdsourcetag"))) {
        startActivity(localIntent.putExtra("url", paramString));
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.i("OCRResultFragmentNew", 1, paramString.toString());
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771991, 2130771989);
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(1);
    paramActivity.getWindow().setSoftInputMode(16);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultFragmentNew", 2, "doOnActivityResult:OCRResultFragmentNew");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = ((BaseActivity)paramActivity);
  }
  
  public boolean onBackEvent()
  {
    w(this.mActivity);
    if (this.dnB == 2) {
      Sa(0);
    }
    for (;;)
    {
      return true;
      this.mActivity.finish();
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
      CharSequence localCharSequence = p();
      if (TextUtils.isEmpty(localCharSequence)) {
        aklz.H(this.mActivity, q().toString());
      }
      for (;;)
      {
        aklz.cN("0X8009C84", 0);
        break;
        aklz.H(this.mActivity, localCharSequence.toString());
      }
      localCharSequence = p();
      if (TextUtils.isEmpty(localCharSequence)) {
        TranslateFragment.d(this.mActivity, String.valueOf(q()));
      }
      for (;;)
      {
        aklz.cN("0X800AAF2", 0);
        break;
        TranslateFragment.d(this.mActivity, String.valueOf(localCharSequence));
      }
      localCharSequence = p();
      if (TextUtils.isEmpty(localCharSequence)) {
        aofz.hG(q().toString(), "OCRResultFragmentNew");
      }
      for (;;)
      {
        aklz.cN("0X800AAF1", 0);
        break;
        aofz.hG(localCharSequence.toString(), "OCRResultFragmentNew");
      }
      localCharSequence = p();
      if (TextUtils.isEmpty(localCharSequence)) {
        NE(String.valueOf(q()));
      }
      for (;;)
      {
        aklz.cN("0X800A357", 2);
        break;
        NE(String.valueOf(localCharSequence));
      }
      aklz.cN("0X800A161", 0);
      NF(this.lS);
      continue;
      a(aklz.a);
      continue;
      onBackEvent();
      continue;
      if ((this.bO != null) && (this.bO.getVisibility() == 0))
      {
        this.bO.setVisibility(8);
        aklz.cN("0X800AC96", 0);
        continue;
        if ((this.lS != null) && (this.bO != null))
        {
          w(this.mActivity);
          this.bO.setVisibility(0);
        }
        aklz.cN("0X800AC95", 0);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lS = getActivity().getIntent().getStringExtra("param_ocr_path");
    this.jdField_K_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Akoy = new akoy(this.mActivity);
    this.jdField_K_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)axol.getAppInterface());
    this.mActivity.addObserver(this.jdField_b_of_type_Aogb);
    this.mActivity.addObserver(this.jdField_b_of_type_Aobz);
    this.mActivity.addObserver(this.jdField_c_of_type_Ahqw);
    aklz.cN("0X800AD1A", 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561517, paramViewGroup, false);
    this.hY = paramLayoutInflater.findViewById(2131379873);
    this.ek = ((ViewGroup)paramLayoutInflater.findViewById(2131372610));
    this.bv = ((EditText)paramLayoutInflater.findViewById(2131372606));
    this.r = ((ViewGroup)paramLayoutInflater.findViewById(2131363700));
    this.em = ((ViewGroup)paramLayoutInflater.findViewById(2131363704));
    this.a = ((ParticipleView)paramLayoutInflater.findViewById(2131373865));
    this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)paramLayoutInflater.findViewById(2131372867));
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131380148));
    this.d = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366587));
    this.mRoot = paramLayoutInflater.findViewById(2131377546);
    paramLayoutInflater.findViewById(2131367525).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131365454).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131363226).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131372589).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131372868).setOnClickListener(this);
    adld.l(this.mActivity, this.hY);
    ImmersiveUtils.setStatusTextColor(false, this.mActivity.getWindow());
    f(this.bv);
    dBR();
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramLayoutInflater.findViewById(2131367816));
    this.jdField_b_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(new akmp(this));
    this.bz = ((URLImageView)paramLayoutInflater.findViewById(2131365386));
    this.bO = ((FrameLayout)paramLayoutInflater.findViewById(2131367815));
    this.BT = ((ImageView)paramLayoutInflater.findViewById(2131372585));
    this.BT.setOnClickListener(this);
    if (this.lS != null)
    {
      paramViewGroup = getResources().getDrawable(2130851770);
      paramViewGroup = aklz.a(this.bz, paramViewGroup);
      this.bz.setImageDrawable(URLDrawable.getFileDrawable(this.lS, paramViewGroup));
    }
    this.Wp = ((TextView)paramLayoutInflater.findViewById(2131372608));
    this.Wp.setOnClickListener(this);
    Sa(0);
    w(this.mActivity);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131372605);
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      paramViewGroup.setVisibility(i);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mActivity.removeObserver(this.jdField_b_of_type_Aogb);
    this.mActivity.removeObserver(this.jdField_b_of_type_Aobz);
    this.mActivity.removeObserver(this.jdField_c_of_type_Ahqw);
    if (this.ay != null)
    {
      this.ay.setOnCancelListener(null);
      this.ay.dismiss();
    }
  }
  
  public CharSequence p()
  {
    if (this.dnB == 0) {
      return aklz.a(this.bv);
    }
    return "";
  }
  
  public CharSequence q()
  {
    if (this.dnB == 0)
    {
      if (this.bv == null) {
        return aklz.o();
      }
      return this.bv.getText();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew
 * JD-Core Version:    0.7.0.1
 */