package com.tencent.mobileqq.ocr;

import aavp;
import acfp;
import adld;
import ahbj;
import ahgq;
import aklr;
import aklt;
import akma;
import akmb;
import akmc;
import akmd;
import akme;
import akmf;
import akmg;
import akmh;
import akmi;
import akmj;
import akmk;
import akml;
import akmm;
import akmn;
import akmo;
import akne;
import akne.a;
import akoy;
import akoz;
import akoz.b;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anot;
import aobw;
import aobx;
import aobz;
import aofk;
import aoga;
import aogb;
import aqbn;
import aqcl;
import aqgz;
import aqiw;
import arhz;
import ausj;
import auvy;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu.ProgressView;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import wja;

public class OCRResultActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener
{
  private static final int HIGH_LIGHT_COLOR = Color.parseColor("#12B7F5");
  public static final String[] fL = { "M3X", "U20", "ZTE C2016", "Lenovo K900", "HUAWEI MT7-CL00", "HUAWEI G7-TL00", "PE-CL00", "Moto X Pro", "X907", "ASUS_Z00ADB", "HUAWEI P7-L07", "XT1581", "M821", "R7c" };
  ImageView BO;
  ImageView BQ;
  ImageView BR;
  ImageView BS;
  private List<String> Ee;
  public TextView Wm;
  public TextView Wn;
  public TextView Wo;
  private aklt jdField_a_of_type_Aklt = new akmo(this);
  private akne.a jdField_a_of_type_Akne$a = new akmc(this);
  private akne jdField_a_of_type_Akne;
  private akoy jdField_a_of_type_Akoy;
  public akoz a;
  private aobz jdField_a_of_type_Aobz = new akmb(this, this);
  private aogb jdField_a_of_type_Aogb = new akmn(this);
  arhz jdField_a_of_type_Arhz;
  protected TextPreviewMenu.ProgressView a;
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private OcrRecogResult jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult;
  OCRBottomTabView jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  public ParticipleView a;
  private ausj aj;
  public akoz b;
  ScanSuccessView jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView;
  private OcrConfig jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig;
  private TranslateResult jdField_b_of_type_ComTencentMobileqqOcrDataTranslateResult;
  OCRBottomTabView jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  ParticipleBottomMenuView jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView;
  private int bRH = -1;
  private String bTN;
  private String bTO;
  private String bTP;
  public EditText bv;
  public OCRBottomTabView c;
  private boolean csR;
  private boolean csS;
  private boolean csT;
  private boolean csU;
  private boolean csV;
  public OCRBottomTabView d;
  ImageView dr;
  ViewGroup ek;
  ViewGroup el;
  public ViewGroup em;
  private View.OnTouchListener f = new akmf(this);
  protected Dialog g;
  View hY;
  private int mBusiType = -1;
  View mContentView;
  private int mFrom = -1;
  private String mImagePath;
  private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new akmg(this);
  View mRoot;
  public RelativeLayout mRootView;
  private MqqHandler mUIHandler;
  public ImageView mx;
  private int oR = -1;
  ViewGroup r;
  private List<String> rh;
  private List<String> ri;
  
  private void MQ(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.aJW())) {
      ImmersiveUtils.setStatusTextColor(paramBoolean, getWindow());
    }
  }
  
  private void MR(boolean paramBoolean)
  {
    if (!aqiw.isNetworkAvailable(getApplicationContext())) {
      QQToast.a(this, 1, 2131693404, 0).show();
    }
    String str;
    do
    {
      do
      {
        return;
        if (this.csT)
        {
          QLog.d("OCRResultActivity", 1, "requestTranslate, in translate request,");
          return;
        }
        str = this.bv.getText().toString();
      } while (TextUtils.isEmpty(str.trim()));
      if ((paramBoolean) || (this.jdField_b_of_type_ComTencentMobileqqOcrDataTranslateResult == null) || (this.mBusiType != 0) || (this.jdField_b_of_type_ComTencentMobileqqOcrDataTranslateResult.t(str, this.bTN, this.bTO))) {
        break;
      }
      dBW();
      a(this.jdField_b_of_type_ComTencentMobileqqOcrDataTranslateResult);
    } while (!QLog.isColorLevel());
    QLog.d("OCRResultActivity", 2, "requestTranslate, use cache");
    return;
    this.csT = true;
    if (paramBoolean)
    {
      this.csU = true;
      dBS();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultActivity", 2, String.format("requestTranslate, srcLang: %s, dstLang: %s", new Object[] { this.bTN, this.bTO }));
      }
      if (this.mBusiType != 0) {
        break label220;
      }
      if (TextUtils.isEmpty(str)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.aL(str, this.bTN, this.bTO);
      return;
      am(2131701478);
    }
    label220:
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.j(this.mImagePath, this.bTN, this.bTO, true);
  }
  
  private void NA(String paramString)
  {
    anot.a(null, "dc00898", "", "", "0X800A161", "0X800A161", 0, 0, "", "0", "0", "");
    if (!aqiw.isNetworkAvailable(getApplicationContext()))
    {
      QLog.d("OCRResultActivity", 1, "requestExport, network error");
      QQToast.a(this, 1, 2131693404, 0).show();
      return;
    }
    if (!ahbj.isFileExists(paramString))
    {
      QLog.d("OCRResultActivity", 1, "requestExport, file not exist, picPath:" + paramString);
      QQToast.a(this, 1, 2131701454, 0).show();
      return;
    }
    if (this.csV)
    {
      QLog.d("OCRResultActivity", 1, "requestExport, in export request, " + paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultActivity", 2, String.format("requestExport: %s", new Object[] { this.mImagePath }));
    }
    this.csV = true;
    this.mImagePath = paramString;
    ((aobx)this.app.getBusinessHandler(157)).RK(this.mImagePath);
  }
  
  private void NB(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    while (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("OCRResultActivity", 2, "ShareToFriend error, content is empty");
      }
      return;
      if (this.oR == 0)
      {
        paramString = this.bv.getText().toString();
      }
      else if (this.oR == 2)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.CS();
      }
      else
      {
        if (this.jdField_b_of_type_ComTencentMobileqqOcrDataTranslateResult == null) {}
        for (paramString = "";; paramString = this.jdField_b_of_type_ComTencentMobileqqOcrDataTranslateResult.getText()) {
          break;
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    paramString = new Intent();
    paramString.putExtra("isFromShare", true);
    if (this.mBusiType == 0) {
      paramString.putExtra("KEY_FROM_OCR", true);
    }
    for (;;)
    {
      paramString.putExtras(localBundle);
      ahgq.f(this, paramString, 21);
      if (this.mBusiType != 0) {
        break;
      }
      anot.a(null, "dc00898", "", "", "0X80082EB", "0X80082EB", 0, 0, "", "", "", "");
      return;
      paramString.putExtra("KEY_FROM_TRANSLATE", true);
    }
    anot.a(null, "dc00898", "", "", "0X8009C84", "0X8009C84", 0, 0, "", "", "", "");
  }
  
  private void NC(String paramString)
  {
    Intent localIntent = EditPicActivity.a(this, paramString, false, false, false, true, false, 2, 99, 9);
    localIntent.putExtra("babyq_ability", 2L);
    localIntent.putExtra("sub_business_id", 103);
    startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultActivity", 2, String.format("enterCropPage, path: %s", new Object[] { paramString }));
    }
    anot.a(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
  }
  
  private void a(OcrRecogResult paramOcrRecogResult)
  {
    if (paramOcrRecogResult == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult = paramOcrRecogResult;
      if (TextUtils.isEmpty(paramOcrRecogResult.language)) {}
      for (Object localObject = "";; localObject = paramOcrRecogResult.language.toLowerCase())
      {
        this.bTP = ((String)localObject);
        wG(this.bTP);
        if ((this.ri != null) && (this.ri.size() > 0)) {
          wH((String)this.ri.get(0));
        }
        localObject = paramOcrRecogResult.ocr_languages;
        if (this.Ee == null) {
          this.Ee = new ArrayList();
        }
        if (localObject == null) {
          break;
        }
        this.Ee.clear();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(hj(str)))) {
            this.Ee.add(str.toLowerCase());
          }
        }
      }
      this.Ee.clear();
      if (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent))
      {
        this.bv.setText(new aofk(paramOcrRecogResult.ocrContent, 8, 16));
        this.mx.setEnabled(true);
        this.c.setEnabled(true);
        this.d.setEnabled(true);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("OCRResultActivity", 2, String.format("updateOcrResult, ocrLanguage: %s, srcTranslateLang: %s, dstTranslateLang: %s", new Object[] { this.bTP, this.bTN, this.bTO }));
        return;
        this.bv.setText("");
        this.mx.setEnabled(false);
        this.c.setEnabled(false);
        this.d.setEnabled(false);
      }
    }
  }
  
  private void a(TranslateResult paramTranslateResult)
  {
    this.jdField_b_of_type_ComTencentMobileqqOcrDataTranslateResult = paramTranslateResult;
    if (paramTranslateResult != null)
    {
      CharSequence localCharSequence = paramTranslateResult.s();
      if (TextUtils.isEmpty(localCharSequence)) {
        break label90;
      }
      this.Wo.setText(localCharSequence);
      this.mx.setEnabled(true);
    }
    for (;;)
    {
      wH(paramTranslateResult.btb);
      wG(paramTranslateResult.bta);
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultActivity", 2, String.format("translateResult, srcTranslateLang: %s, dstTranslateLang: %s", new Object[] { this.bTN, this.bTO }));
      }
      return;
      label90:
      this.Wo.setText("");
      this.mx.setEnabled(false);
    }
  }
  
  private List<String> aa(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
      return this.jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig.getTranslateSupportLanguages(paramString);
    }
    return OcrConfig.getDefaultSupportLanguages(paramString);
  }
  
  private void am(int paramInt)
  {
    if ((isFinishing()) || ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing()))) {
      return;
    }
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this, 0, 2131561627, 48);
    }
    this.jdField_a_of_type_Arhz.setMessage(paramInt);
    this.jdField_a_of_type_Arhz.setBackAndSearchFilter(false);
    this.jdField_a_of_type_Arhz.show();
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
        QLog.d("OCRResultActivity", 2, "isSupportAddContextMenu mode:" + str + ",isSupport: " + bool);
      }
      return bool;
      i += 1;
      break;
      bool = true;
    }
  }
  
  private String b(TextView paramTextView)
  {
    String str1 = null;
    if (paramTextView == null) {
      paramTextView = str1;
    }
    do
    {
      int i;
      int j;
      String str2;
      do
      {
        do
        {
          do
          {
            do
            {
              return paramTextView;
              i = paramTextView.getSelectionStart();
              j = paramTextView.getSelectionEnd();
              str2 = paramTextView.getText().toString();
              paramTextView = str1;
            } while (TextUtils.isEmpty(str2));
            paramTextView = str1;
          } while (i >= j);
          paramTextView = str1;
        } while (i < 0);
        paramTextView = str1;
      } while (j > str2.length());
      str1 = str2.substring(i, j);
      paramTextView = str1;
    } while (!QLog.isColorLevel());
    QLog.d("OCRResultActivity", 2, "getSelectedWord " + str1);
    return str1;
  }
  
  private void bWk()
  {
    if ((this.jdField_a_of_type_Akoz != null) && (this.jdField_a_of_type_Akoz.isShowing())) {
      this.jdField_a_of_type_Akoz.dismiss();
    }
    if ((this.jdField_b_of_type_Akoz != null) && (this.jdField_b_of_type_Akoz.isShowing())) {
      this.jdField_b_of_type_Akoz.dismiss();
    }
    do
    {
      do
      {
        return;
      } while ((this.rh == null) || (this.rh.size() == 0));
      ArrayList localArrayList = new ArrayList();
      i = 0;
      j = 0;
      if (i < this.rh.size())
      {
        String str = (String)this.rh.get(i);
        if (str.equals(this.bTO)) {}
        for (;;)
        {
          i += 1;
          break;
          akoz.b localb = new akoz.b();
          localb.languageCode = str;
          localb.bUe = hj(str);
          if (str.equalsIgnoreCase(this.bTN)) {
            j = i;
          }
          localArrayList.add(localb);
        }
      }
      this.jdField_b_of_type_Akoz = akoz.a(this, localArrayList, j, new akmj(this));
    } while (this.jdField_b_of_type_Akoz == null);
    this.jdField_b_of_type_Akoz.setOnDismissListener(new akmk(this));
    int i = this.Wm.getMeasuredWidth() / 2;
    int j = wja.dp2px(75.0F, getResources());
    this.Wm.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Akoz.showAsDropDown(this.Wm, i - j, 0);
  }
  
  private void bWl()
  {
    if ((this.jdField_b_of_type_Akoz != null) && (this.jdField_b_of_type_Akoz.isShowing())) {
      this.jdField_b_of_type_Akoz.dismiss();
    }
    if ((this.jdField_a_of_type_Akoz != null) && (this.jdField_a_of_type_Akoz.isShowing())) {
      this.jdField_a_of_type_Akoz.dismiss();
    }
    do
    {
      do
      {
        return;
      } while ((this.ri == null) || (this.ri.size() == 0));
      ArrayList localArrayList = new ArrayList();
      i = 0;
      j = 0;
      if (i < this.ri.size())
      {
        String str = (String)this.ri.get(i);
        if (str.equals(this.bTN)) {}
        for (;;)
        {
          i += 1;
          break;
          akoz.b localb = new akoz.b();
          localb.languageCode = str;
          localb.bUe = hj(str);
          if (str.equalsIgnoreCase(this.bTO)) {
            j = i;
          }
          localArrayList.add(localb);
        }
      }
      this.jdField_a_of_type_Akoz = akoz.a(this, localArrayList, j, new akml(this));
    } while (this.jdField_a_of_type_Akoz == null);
    this.jdField_a_of_type_Akoz.setOnDismissListener(new akmm(this));
    int i = this.Wn.getMeasuredWidth() / 2;
    int j = wja.dp2px(75.0F, getResources());
    this.Wn.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Akoz.showAsDropDown(this.Wn, i - j, 0);
  }
  
  private void czA()
  {
    aavp localaavp = aavp.a();
    if ((localaavp.isSelected()) && (localaavp.Xy())) {
      localaavp.detach();
    }
  }
  
  private void dBR()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView);
    this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setOnMenuClickListener(new akma(this));
  }
  
  private void dBS()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.BS == null)
    {
      this.BS = new ImageView(this);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.BS.setBackgroundColor(-16777216);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File(this.mImagePath), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).downloadImediatly();
      this.BS.setImageDrawable((Drawable)localObject);
      this.mRootView.addView(this.BS, localLayoutParams);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setShowProgress(false);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ankt.SCREEN_WIDTH);
      this.mRootView.addView(this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      if (this.oR == 0) {
        this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(acfp.m(2131709344));
      }
    }
    else if (this.BO == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.BO = new ImageView(this);
      this.BO.setImageResource(2130844107);
      localLayoutParams.leftMargin = wja.dp2px(12.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label304;
      }
    }
    label304:
    for (localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(this) + wja.dp2px(12.0F, getResources()));; localLayoutParams.topMargin = wja.dp2px(12.0F, getResources()))
    {
      this.mRootView.addView(this.BO, localLayoutParams);
      this.BO.setOnClickListener(new akmh(this));
      this.BO.bringToFront();
      return;
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(acfp.m(2131709347));
      break;
    }
  }
  
  private void dBT()
  {
    if (this.BS != null)
    {
      this.mRootView.removeView(this.BS);
      this.BS = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView != null)
    {
      this.mRootView.removeView(this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView = null;
    }
    if (this.BO != null)
    {
      this.mRootView.removeView(this.BO);
      this.BO = null;
    }
  }
  
  private void dBU()
  {
    czA();
    if (this.oR != 0)
    {
      this.bRH = this.oR;
      this.oR = 0;
      this.mRoot.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166705)));
      this.ek.setVisibility(0);
      this.el.setVisibility(8);
      this.r.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      this.bv.setVisibility(0);
      this.Wo.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      MQ(false);
      this.hY.setVisibility(0);
      adld.l(this, this.hY);
    }
  }
  
  private void dBV()
  {
    czA();
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.bv.getWindowToken(), 0);
    if (this.oR != 2)
    {
      this.bRH = this.oR;
      this.oR = 2;
      this.ek.setVisibility(8);
      this.el.setVisibility(8);
      this.r.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.eig();
      this.bv.setVisibility(8);
      this.Wo.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(0);
      MQ(true);
      this.hY.setVisibility(8);
      this.mRoot.setBackgroundDrawable(getResources().getDrawable(2130838415));
      adld.l(this, this.mContentView);
    }
  }
  
  private void dBW()
  {
    czA();
    if (this.oR != 1)
    {
      this.bRH = this.oR;
      this.oR = 1;
      this.ek.setVisibility(8);
      this.el.setVisibility(0);
      this.r.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      this.bv.setVisibility(8);
      this.Wo.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      MQ(false);
      this.hY.setVisibility(0);
      this.mRoot.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166705)));
      adld.l(this, this.hY);
    }
  }
  
  private void dBX()
  {
    NB("");
  }
  
  private void dBY()
  {
    if ((this.Ee == null) || (this.Ee.size() == 0)) {
      return;
    }
    this.aj = ausj.b(this);
    this.aj.setMainTitle(2131701460);
    Iterator localIterator = this.Ee.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.aj.addRadioButton(hj(str), str.equalsIgnoreCase(this.bTP));
    }
    this.aj.addCancelButton(2131721058);
    this.aj.a(new akmi(this));
    try
    {
      this.aj.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void dBZ()
  {
    String str = this.bv.getText().toString();
    if (!aqiw.isNetSupport(this))
    {
      QQToast.a(getApplicationContext(), acfp.m(2131709348), 0).show(getResources().getDimensionPixelSize(2131299627));
      return;
    }
    dCa();
    ((aoga)this.app.getBusinessHandler(161)).aO(this.app, str);
    anot.a(this.app, "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
  }
  
  private void dCa()
  {
    if (this.g == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView = new TextPreviewMenu.ProgressView(this);
      this.g = new ReportDialog(this);
      if (this.g.getWindow() != null) {
        this.g.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      this.g.setCanceledOnTouchOutside(false);
      this.g.requestWindowFeature(1);
      this.g.setContentView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView);
      this.g.setOnCancelListener(new TextPreviewMenu.a(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(acfp.m(2131709350));
      this.g.show();
      return;
      this.g.dismiss();
    }
  }
  
  private void dCb()
  {
    if (this.g != null)
    {
      this.g.setOnCancelListener(null);
      this.g.dismiss();
    }
  }
  
  private void f(EditText paramEditText)
  {
    paramEditText.setLinkTextColor(HIGH_LIGHT_COLOR);
    if (AppSetting.enableTalkBack) {
      paramEditText.setAutoLinkMask(7);
    }
    for (;;)
    {
      paramEditText.setOnTouchListener(this.f);
      paramEditText.addTextChangedListener(new akmd(this));
      if (arY()) {
        paramEditText.setCustomSelectionActionModeCallback(new akme(this, paramEditText));
      }
      this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
      return;
      paramEditText.setAutoLinkMask(0);
    }
  }
  
  private void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  private String hj(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
      return this.jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig.getTranslateLanguageName(paramString);
    }
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  private void i(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!aqiw.isNetworkAvailable(getApplicationContext()))
    {
      QLog.d("OCRResultActivity", 1, "requestOcr, network error");
      QQToast.a(this, 1, 2131693404, 0).show();
      return;
    }
    if (!ahbj.isFileExists(paramString1))
    {
      QLog.d("OCRResultActivity", 1, "requestOcr, file not exist, picPath:" + paramString1);
      QQToast.a(this, 1, 2131701454, 0).show();
      return;
    }
    if (this.csR)
    {
      QLog.d("OCRResultActivity", 1, "requestOcr, in ocr request, " + paramString1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultActivity", 2, String.format("requestOcr: %s, language: %s, isFirst: %s, needCompress: %s", new Object[] { this.mImagePath, paramString2, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    this.csR = true;
    this.mImagePath = paramString1;
    if (paramBoolean1)
    {
      dBS();
      this.csU = true;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Akne == null)
      {
        this.jdField_a_of_type_Akne = new akne(this.app, this.jdField_a_of_type_Akne$a, 5);
        this.jdField_a_of_type_Akne.start();
      }
      this.jdField_a_of_type_Akne.h(this.mImagePath, paramBoolean2, paramString2);
      return;
      am(2131701457);
    }
  }
  
  public static final void n(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, OCRResultActivity.class);
    localIntent.putExtra("PARAM_BUSI", 0);
    localIntent.putExtra("PARAM_FROM", paramInt);
    localIntent.putExtra("param_ocr_path", paramString);
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void wG(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equalsIgnoreCase(this.bTN))) {}
    for (;;)
    {
      return;
      this.bTN = paramString.toLowerCase();
      this.Wm.setText(hj(this.bTN));
      this.ri = aa(this.bTN);
      if ((this.ri == null) || (this.ri.size() <= 1))
      {
        this.Wn.setClickable(false);
        this.Wn.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      while (AppSetting.enableTalkBack)
      {
        aqcl.changeAccessibilityForView(this.Wm, this.bTN, getString(2131701477));
        return;
        this.Wn.setClickable(true);
        paramString = getResources().getDrawable(2130846541);
        this.Wn.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
      }
    }
  }
  
  private void wH(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equalsIgnoreCase(this.bTO))) {}
    for (;;)
    {
      return;
      this.bTO = paramString.toLowerCase();
      this.Wn.setText(hj(this.bTO));
      this.rh = aa(paramString);
      if ((this.rh == null) || (this.rh.size() <= 1))
      {
        this.Wm.setClickable(false);
        this.Wm.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      while (AppSetting.enableTalkBack)
      {
        aqcl.changeAccessibilityForView(this.Wn, this.bTO, getString(2131701477));
        return;
        this.Wm.setClickable(true);
        paramString = getResources().getDrawable(2130846541);
        this.Wm.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
      }
    }
  }
  
  protected void ND(String paramString)
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), QQBrowserActivity.class);
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://docs.qq.com/desktop/m/index.html?_from=1";
      }
      paramString = aobw.bD(str, "s_qq_ocr_save");
      localIntent.putExtra("tdsourcetag", "s_qq_ocr_save");
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
      localIntent.putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
      if (!TeamWorkDocEditBrowserActivity.g(this, paramString, localIntent.getStringExtra("tdsourcetag"))) {
        startActivity(localIntent.putExtra("url", paramString));
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.i("OCRResultActivity", 1, paramString.toString());
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && (paramIntent.getIntExtra("PARAM_FROM", -1) == 1)) {
      this.csS = false;
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_b_of_type_Akoz != null) && (this.jdField_b_of_type_Akoz.isShowing())) {
      this.jdField_b_of_type_Akoz.dismiss();
    }
    if ((this.jdField_a_of_type_Akoz != null) && (this.jdField_a_of_type_Akoz.isShowing())) {
      this.jdField_a_of_type_Akoz.dismiss();
    }
    if (((this.oR == 1) || (this.oR == 2)) && (this.mBusiType == 0))
    {
      dBU();
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2131561516);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      auvy.bN(this);
    }
    this.mRootView = ((RelativeLayout)findViewById(2131377565));
    this.hY = findViewById(2131379873);
    this.dr = ((ImageView)findViewById(2131363226));
    this.mx = ((ImageView)findViewById(2131378178));
    this.ek = ((ViewGroup)findViewById(2131372610));
    this.BQ = ((ImageView)findViewById(2131372589));
    this.el = ((ViewGroup)findViewById(2131380161));
    this.Wm = ((TextView)findViewById(2131380156));
    this.Wn = ((TextView)findViewById(2131380149));
    this.BR = ((ImageView)findViewById(2131380157));
    this.bv = ((EditText)findViewById(2131372606));
    this.Wo = ((TextView)findViewById(2131380154));
    this.r = ((ViewGroup)findViewById(2131363700));
    this.em = ((ViewGroup)findViewById(2131363704));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)findViewById(2131373865));
    this.jdField_b_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)findViewById(2131372867));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)findViewById(2131365530));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)findViewById(2131372868));
    this.c = ((OCRBottomTabView)findViewById(2131380148));
    this.d = ((OCRBottomTabView)findViewById(2131366587));
    this.BS = ((ImageView)findViewById(2131373571));
    this.mContentView = findViewById(2131365396);
    this.mRoot = findViewById(2131377546);
    adld.l(this, this.hY);
    adld.a(this, this.em, true, 0);
    f(this.bv);
    dBR();
    this.dr.setOnClickListener(this);
    this.mx.setOnClickListener(this);
    this.BQ.setOnClickListener(this);
    this.Wm.setOnClickListener(this);
    this.Wn.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.BR.setOnClickListener(this);
    this.mBusiType = getIntent().getIntExtra("PARAM_BUSI", 0);
    this.mFrom = getIntent().getIntExtra("PARAM_FROM", -1);
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController(this.app);
    if (this.mBusiType == 1)
    {
      this.mImagePath = getIntent().getStringExtra("param_ocr_path");
      paramBundle = (TranslateResult)getIntent().getParcelableExtra("param_translate_result");
      dBW();
      if (paramBundle != null) {
        a(paramBundle);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqOcrDataOcrConfig = ((aklr)this.app.getManager(228)).a(false);
      addObserver(this.jdField_a_of_type_Aklt);
      this.mUIHandler = new MqqHandler(Looper.getMainLooper(), this);
      addObserver(this.jdField_a_of_type_Aobz);
      this.jdField_a_of_type_Akoy = new akoy(this);
      anot.a(null, "dc00898", "", "", "0X800A160", "0X800A160", 0, 0, "", "0", "0", "");
      addObserver(this.jdField_a_of_type_Aogb);
      return true;
      MR(true);
      continue;
      paramBundle = (OcrRecogResult)getIntent().getParcelableExtra("param_ocr_result");
      this.mImagePath = getIntent().getStringExtra("param_ocr_path");
      dBU();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = wja.dp2px(24.0F, getResources());
      localURLDrawableOptions.mRequestHeight = wja.dp2px(24.0F, getResources());
      URLDrawable localURLDrawable = URLDrawable.getDrawable(new File(this.mImagePath), localURLDrawableOptions);
      localURLDrawable.setTag(aqbn.d(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, wja.dp2px(3.0F, getResources())));
      localURLDrawable.setDecodeHandler(aqbn.a);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(localURLDrawable);
      if (paramBundle != null) {
        a(paramBundle);
      }
      for (;;)
      {
        anot.a(null, "dc00898", "", "", "0X80082CE", "0X80082CE", 0, 0, "", "", "", "");
        if (this.mFrom != 2) {
          break label881;
        }
        anot.a(null, "dc00898", "", "", "0X8009C87", "0X8009C87", 2, 0, "", "", "", "");
        break;
        i(this.mImagePath, null, true, true);
      }
      label881:
      if (this.mFrom == 1) {
        anot.a(null, "dc00898", "", "", "0X8009C87", "0X8009C87", 1, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Aklt);
    removeObserver(this.jdField_a_of_type_Aogb);
    removeObserver(this.jdField_a_of_type_Aobz);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.release();
    }
    dCb();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getIntExtra("sub_business_id", -1) == 103))
    {
      if (!isInMultiWindow()) {
        break label75;
      }
      QQToast.a(this, 2131697437, 0).show();
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
      return;
      label75:
      i(paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"), this.bTP, true, false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
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
      doOnBackPressed();
      continue;
      dBX();
      continue;
      dBY();
      continue;
      bWk();
      continue;
      bWl();
      continue;
      NC(this.mImagePath);
      continue;
      dBZ();
      continue;
      MR(false);
      anot.a(null, "dc00898", "", "", "0X80082D3", "0X80082D3", 0, 0, "", "", "", "");
      continue;
      String str = this.bTN;
      wG(this.bTO);
      wH(str);
      MR(false);
      if ((this.jdField_b_of_type_Akoz != null) && (this.jdField_b_of_type_Akoz.isShowing())) {
        this.jdField_b_of_type_Akoz.dismiss();
      }
      if ((this.jdField_a_of_type_Akoz != null) && (this.jdField_a_of_type_Akoz.isShowing()))
      {
        this.jdField_a_of_type_Akoz.dismiss();
        continue;
        NA(this.mImagePath);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity
 * JD-Core Version:    0.7.0.1
 */