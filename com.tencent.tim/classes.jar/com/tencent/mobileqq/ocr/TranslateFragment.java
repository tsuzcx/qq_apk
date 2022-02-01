package com.tencent.mobileqq.ocr;

import aklt;
import aklz;
import aklz.b;
import akni;
import aknj;
import aknk;
import aknl;
import aknm;
import akoz;
import akoz.b;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import aofz;
import aqiw;
import arhz;
import axol;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;
import wja;

public class TranslateFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private TextView FT;
  private TextView FU;
  private WeakReference<QQAppInterface> K;
  private TextView Wq;
  private TextView Wr;
  private arhz jdField_a_of_type_Arhz;
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private TranslateResult b;
  private ImageView bG;
  private String bTV;
  private aklt jdField_c_of_type_Aklt = new akni(this);
  private akoz jdField_c_of_type_Akoz;
  private boolean ctf;
  private akoz jdField_d_of_type_Akoz;
  private ScrollView jdField_d_of_type_ComTencentWidgetScrollView;
  private int dnM = 2;
  private OCRBottomTabView jdField_e_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private ScrollView jdField_e_of_type_ComTencentWidgetScrollView;
  private OCRBottomTabView f;
  private OCRBottomTabView g;
  private OCRBottomTabView h;
  private BaseActivity mActivity;
  
  private void Sc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      if (this.b != null) {
        a(1, this.b);
      }
      for (;;)
      {
        aklz.cN("0X800AB95", 2);
        return;
        c(aklz.a);
      }
    }
    a(2, this.b);
    aklz.cN("0X800AB95", 1);
  }
  
  private CharSequence a(int paramInt, TranslateResult paramTranslateResult)
  {
    if (paramInt == 1) {
      return paramTranslateResult.s();
    }
    if (paramInt == 2) {
      return paramTranslateResult.r();
    }
    return "";
  }
  
  private void a(int paramInt, TranslateResult paramTranslateResult)
  {
    int k = 2131711990;
    int j = -1;
    this.dnM = paramInt;
    String str;
    int i;
    if ((this.jdField_e_of_type_ComTencentMobileqqWidgetOCRBottomTabView != null) && (this.jdField_e_of_type_ComTencentMobileqqWidgetOCRBottomTabView.getVisibility() == 0))
    {
      str = "#000000";
      if (paramInt != 1) {
        break label299;
      }
      i = 2130842275;
      str = "#00CAFC";
      j = 2131711990;
    }
    for (;;)
    {
      if (paramInt == 2)
      {
        j = 2130842274;
        str = "#000000";
        i = k;
      }
      for (;;)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(getResources().getDrawable(j));
        this.jdField_e_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabText(getResources().getString(i));
        this.jdField_e_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabTextColor(Color.parseColor(str));
        if (paramTranslateResult != null)
        {
          if (paramInt == 2)
          {
            this.jdField_d_of_type_ComTencentWidgetScrollView.setVisibility(0);
            this.jdField_e_of_type_ComTencentWidgetScrollView.setVisibility(0);
            this.Wq.setText(this.bTV);
            this.Wr.setText(a(paramInt, paramTranslateResult));
          }
          if (paramInt == 1)
          {
            this.jdField_e_of_type_ComTencentWidgetScrollView.setVisibility(0);
            this.jdField_d_of_type_ComTencentWidgetScrollView.setVisibility(8);
            this.Wr.setText(a(paramInt, paramTranslateResult));
          }
          if (aklz.a != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TranslateFragment", 2, "src:" + paramTranslateResult.bta + ", dst:" + paramTranslateResult.btb + ", OCRLanHolder:" + aklz.a.tc());
            }
            aklz.a.Ny(paramTranslateResult.bta);
            aklz.a.Nz(paramTranslateResult.btb);
            b(aklz.a);
          }
        }
        return;
        k = i;
        i = j;
        j = k;
      }
      label299:
      i = -1;
    }
  }
  
  private void am(int paramInt)
  {
    if (this.jdField_a_of_type_Arhz == null)
    {
      this.jdField_a_of_type_Arhz = new arhz(this.mActivity, getResources().getDimensionPixelSize(2131299627));
      this.jdField_a_of_type_Arhz.setMessage(paramInt);
    }
    if (!getActivity().isFinishing()) {
      this.jdField_a_of_type_Arhz.show();
    }
  }
  
  private void b(aklz.b paramb)
  {
    if (paramb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder:" + paramb.tc());
    }
    this.FT.setText(paramb.my(paramb.bTL));
    this.FU.setText(paramb.my(paramb.bTM));
    if ((paramb.Ec == null) || (paramb.Ec.size() <= 1))
    {
      this.FT.setClickable(false);
      this.FT.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    while ((paramb.Ed == null) || (paramb.Ed.size() <= 1))
    {
      this.FU.setClickable(false);
      this.FU.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
      this.FT.setClickable(true);
      Drawable localDrawable = getResources().getDrawable(2130847054);
      this.FT.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
    this.FU.setClickable(true);
    paramb = getResources().getDrawable(2130847054);
    this.FU.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramb);
  }
  
  private void c(aklz.b paramb)
  {
    if (paramb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "requestTranslate, lanHolder:" + paramb.tc());
    }
    gR(paramb.bTL, paramb.bTM);
  }
  
  private void d(aklz.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "showTranslateSrcLanOptions, lanHolder:" + paramb.tc());
    }
    if ((this.jdField_c_of_type_Akoz != null) && (this.jdField_c_of_type_Akoz.isShowing())) {
      this.jdField_c_of_type_Akoz.dismiss();
    }
    if ((this.jdField_d_of_type_Akoz != null) && (this.jdField_d_of_type_Akoz.isShowing())) {
      this.jdField_d_of_type_Akoz.dismiss();
    }
    while ((paramb.Ec == null) || (paramb.Ec.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    while (i < paramb.Ec.size())
    {
      String str = (String)paramb.Ec.get(i);
      if (str.equalsIgnoreCase(paramb.bTL)) {
        j = i;
      }
      akoz.b localb = new akoz.b();
      localb.languageCode = str;
      localb.bUe = aklz.mx(str);
      localArrayList.add(localb);
      i += 1;
    }
    this.jdField_d_of_type_Akoz = akoz.a(this.mActivity, localArrayList, j, new aknj(this, paramb));
    i = this.FT.getMeasuredWidth() / 2;
    j = wja.dp2px(75.0F, getResources());
    this.FT.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_d_of_type_Akoz.showAsDropDown(this.FT, i - j, 0);
    this.jdField_d_of_type_Akoz.setOnDismissListener(new aknk(this, paramb));
  }
  
  public static void d(BaseActivity paramBaseActivity, String paramString)
  {
    Intent localIntent = new Intent(paramBaseActivity, TranslateFragment.class);
    localIntent.putExtra("TranslateText", paramString);
    PublicFragmentActivity.start(paramBaseActivity, localIntent, TranslateFragment.class);
  }
  
  private void e(aklz.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "showTranslateDstLanOptions, lanHolder:" + paramb.tc());
    }
    if ((this.jdField_d_of_type_Akoz != null) && (this.jdField_d_of_type_Akoz.isShowing())) {
      this.jdField_d_of_type_Akoz.dismiss();
    }
    if ((this.jdField_c_of_type_Akoz != null) && (this.jdField_c_of_type_Akoz.isShowing())) {
      this.jdField_c_of_type_Akoz.dismiss();
    }
    while ((paramb.Ed == null) || (paramb.Ed.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < paramb.Ed.size())
    {
      String str = (String)paramb.Ed.get(i);
      if (str.equalsIgnoreCase(paramb.bTL)) {}
      for (;;)
      {
        i += 1;
        break;
        if (str.equalsIgnoreCase(paramb.bTM)) {
          j = i;
        }
        akoz.b localb = new akoz.b();
        localb.languageCode = str;
        localb.bUe = aklz.mx(str);
        localArrayList.add(localb);
      }
    }
    this.jdField_c_of_type_Akoz = akoz.a(this.mActivity, localArrayList, j, new aknl(this, paramb));
    i = this.FU.getMeasuredWidth() / 2;
    j = wja.dp2px(75.0F, getResources());
    this.FU.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_c_of_type_Akoz.showAsDropDown(this.FU, i - j, 0);
    this.jdField_c_of_type_Akoz.setOnDismissListener(new aknm(this, paramb));
  }
  
  private void gR(String paramString1, String paramString2)
  {
    if (!aqiw.isNetworkAvailable(this.mActivity))
    {
      QQToast.a(this.mActivity, 1, 2131693404, 0).show();
      return;
    }
    if (TextUtils.isEmpty(this.bTV))
    {
      QLog.d("TranslateFragment", 1, "requestTranslate, mInputTransText null");
      return;
    }
    if (this.ctf)
    {
      QLog.d("TranslateFragment", 1, "requestTranslate, in translate request,");
      return;
    }
    am(2131701478);
    this.ctf = true;
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "requestTranslate, srcLan:" + paramString1 + ", dstLan:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.aL(this.bTV, paramString1, paramString2);
  }
  
  private void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771991, 2130771989);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(1);
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(134217728);
    }
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      d(aklz.a);
      continue;
      e(aklz.a);
      continue;
      this.mActivity.finish();
      continue;
      aofz.c(this.mActivity, (QQAppInterface)this.K.get(), String.valueOf(this.Wr.getText()));
      aklz.cN("0X800AB94", 0);
      continue;
      aklz.H(this.mActivity, String.valueOf(this.Wr.getText()));
      aklz.cN("0X800AB93", 0);
      continue;
      aofz.hG(String.valueOf(this.Wr.getText()), "TranslateFragment");
      aklz.cN("0X800AB92", 0);
      continue;
      Sc(this.dnM);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.bTV = getActivity().getIntent().getStringExtra("TranslateText");
    this.K = new WeakReference((QQAppInterface)axol.getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController((QQAppInterface)this.K.get());
    this.mActivity.addObserver(this.jdField_c_of_type_Aklt);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561735, paramViewGroup, false);
    this.FT = ((TextView)paramLayoutInflater.findViewById(2131380134));
    this.FU = ((TextView)paramLayoutInflater.findViewById(2131380130));
    this.bG = ((ImageView)paramLayoutInflater.findViewById(2131380129));
    this.jdField_d_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131380153));
    this.Wq = ((TextView)paramLayoutInflater.findViewById(2131380158));
    this.jdField_e_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131380155));
    this.Wr = ((TextView)paramLayoutInflater.findViewById(2131380160));
    this.jdField_e_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365403));
    this.h = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366734));
    this.g = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131367525));
    this.f = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365454));
    this.FT.setOnClickListener(this);
    this.FU.setOnClickListener(this);
    this.bG.setOnClickListener(this);
    this.jdField_e_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.FT.setTextColor(Color.parseColor("#03081A"));
    this.FU.setTextColor(Color.parseColor("#03081A"));
    this.jdField_e_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabTextColor(-16777216);
    this.h.setTabTextColor(-16777216);
    this.g.setTabTextColor(-16777216);
    this.f.setTabTextColor(-16777216);
    this.Wq.setText(this.bTV);
    this.Wr.setText("");
    paramViewGroup = getResources().getDrawable(2130847052);
    this.bG.setImageDrawable(paramViewGroup);
    b(aklz.a);
    c(aklz.a);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131372611);
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
    this.mActivity.removeObserver(this.jdField_c_of_type_Aklt);
    this.mActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment
 * JD-Core Version:    0.7.0.1
 */