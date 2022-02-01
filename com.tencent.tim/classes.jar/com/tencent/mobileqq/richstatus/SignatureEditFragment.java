package com.tencent.mobileqq.richstatus;

import acfp;
import amga;
import amgb;
import amgc;
import amgd;
import amge;
import amgf;
import amgg;
import amgh;
import amhd;
import amif;
import amif.a;
import amig;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqha;
import aqju;
import aqqs;
import aqzl;
import arbs;
import arcd;
import arju;
import awdo;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import jll;
import kx;
import ld;
import org.json.JSONException;
import org.json.JSONObject;
import rpq;

public class SignatureEditFragment
  extends WebViewFragment
  implements amif.a, Handler.Callback
{
  private ImageView Dl;
  private View GB;
  private View GC;
  private View GD;
  private TextView Yh;
  private TextView Yi;
  private TextView Yj;
  private TextView Yk;
  private amig a;
  public RichStatus c = new RichStatus(null);
  private boolean cCv;
  private boolean cCw = true;
  public boolean cCx;
  public boolean cCy;
  private int dBK;
  private Observer h = new amgf(this);
  public RichStatus i = new RichStatus(null);
  private int isDefault;
  private Handler mUIHandler;
  
  private void Pd(boolean paramBoolean)
  {
    if (this.i == null) {
      return;
    }
    SignTextEditFragment.a(getActivity(), this.i, null, null, 16);
    if (paramBoolean) {}
    for (String str = "0X800A63B";; str = "0X800A63A")
    {
      anot.a(null, "dc00898", "", "", str, str, 0, 0, "0", "0", "", "");
      return;
    }
  }
  
  private void Us(int paramInt)
  {
    this.dBK = paramInt;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    localEditor.putInt(this.mApp.getCurrentAccountUin() + "_sign_edit_red_dot_key", paramInt);
    localEditor.apply();
  }
  
  public static SignatureEditFragment a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new SignatureEditFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  private void dNe()
  {
    this.cCy = false;
    if (this.cCv) {
      if (this.c.mStickerInfos == null) {
        this.c.mStickerInfos = new ArrayList();
      }
    }
    for (;;)
    {
      Object localObject = amhd.a().a(this.c.tplId);
      if ((localObject != null) && (((aqqs)localObject).a != null))
      {
        this.c.plainText.set(0, ((aqqs)localObject).cwe);
        this.c.actionId = 0;
        this.c.locationText = "";
        this.c.actionText = null;
        this.c.dataId = 0;
        this.c.dataText = null;
        this.c.topics.clear();
        this.c.topicsPos.clear();
      }
      localObject = new Bundle();
      ((Bundle)localObject).putSerializable("my_signature", this.c);
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", ld.eA, (Bundle)localObject, amhd.a().f);
      return;
      this.c.mStickerInfos.clear();
      continue;
      this.c.mStickerInfos = null;
    }
  }
  
  private void dNi()
  {
    boolean bool2 = true;
    if (getActivity() != null)
    {
      bool1 = bool2;
      if (this.c != null)
      {
        bool1 = bool2;
        if (this.c.tplId != 1) {
          if (this.c.tplId != 0) {
            break label56;
          }
        }
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ImmersiveUtils.setStatusTextColor(bool1, getActivity().getWindow());
      return;
    }
  }
  
  private void dNk()
  {
    Object localObject = amhd.a().a(this.c.tplId);
    if (this.mApp == null) {
      this.mApp = getActivity().getAppInterface();
    }
    if ((localObject != null) && (((aqqs)localObject).materialVersion < 2) && ("signature_chouti".equals(getActivity().getIntent().getStringExtra("via"))))
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if (((SharedPreferences)localObject).getBoolean(this.mApp.getCurrentAccountUin() + "new_signature_version_826", true))
      {
        ((SharedPreferences)localObject).edit().putBoolean(this.mApp.getCurrentAccountUin() + "new_signature_version_826", false).apply();
        aqha.a(getActivity(), 230, acfp.m(2131714591), getActivity().getResources().getString(2131693035), acfp.m(2131714785), getActivity().getResources().getString(2131693014), new amgc(this), new amgd(this)).show();
        VasWebviewUtil.reportCommercialDrainage("signature_update", "show", "", 0, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
      }
    }
  }
  
  private void dNl()
  {
    Object localObject = amhd.a().a(this.c.tplId);
    if (this.mApp == null) {
      this.mApp = getActivity().getAppInterface();
    }
    if ((localObject != null) && (((aqqs)localObject).materialVersion < 2) && (Integer.parseInt(((aqqs)localObject).id) > 0) && (this.cCw))
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if ((((SharedPreferences)localObject).getBoolean(this.mApp.getCurrentAccountUin() + "edit_signature_version_826", false)) && (((SharedPreferences)localObject).getBoolean(this.mApp.getCurrentAccountUin() + "new_signature_version_826", true)))
      {
        ((SharedPreferences)localObject).edit().putBoolean(this.mApp.getCurrentAccountUin() + "new_signature_version_826", false).apply();
        aqha.a(getActivity(), 230, acfp.m(2131714591), getActivity().getResources().getString(2131693035), null, acfp.m(2131716836), new amge(this), null).show();
        VasWebviewUtil.reportCommercialDrainage("signature_update", "show", "", 0, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
      }
    }
  }
  
  private void dNm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "initSignatureView start");
    }
    if (this.c == null) {
      return;
    }
    if (this.jdField_a_of_type_Amig == null)
    {
      if (this.mApp == null) {
        this.mApp = getActivity().getAppInterface();
      }
      this.jdField_a_of_type_Amig = new amig(getActivity(), this.mApp, this.GB, this.mApp.getCurrentAccountUin());
      this.jdField_a_of_type_Amig.a(this);
    }
    this.jdField_a_of_type_Amig.a(this.c);
    this.GB.invalidate();
    Ur(this.c.tplId);
    dNi();
  }
  
  private void dNn()
  {
    Object localObject;
    if ((getWebView() != null) && (this.c != null) && (TextUtils.isEmpty(this.c.getPlainText()))) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("result", 0);
      localObject = WebViewPlugin.toJsScript("gxh.sign.setToDefault", (JSONObject)localObject, null);
      getWebView().callJs((String)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private static int getStatusBarHeight(Context paramContext)
  {
    int j = 0;
    int k = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (k > 0) {
      j = paramContext.getResources().getDimensionPixelSize(k);
    }
    return j;
  }
  
  private void initData()
  {
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", ld.ez, null, amhd.a().f);
  }
  
  public int IG()
  {
    if (this.dBK < 2)
    {
      Us(2);
      return 1;
    }
    return 0;
  }
  
  public void Pe(boolean paramBoolean)
  {
    this.cCw = paramBoolean;
  }
  
  public void Ur(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = -2611;
    int[] tmp11_5 = tmp5_4;
    tmp11_5[1] = -1046;
    tmp11_5;
    Object localObject = arrayOfInt;
    if (paramInt > 1)
    {
      aqqs localaqqs = amhd.a().a(this.c.tplId);
      localObject = arrayOfInt;
      if (localaqqs != null)
      {
        localObject = arrayOfInt;
        if (!TextUtils.isEmpty(localaqqs.backgroundColor))
        {
          paramInt = Color.parseColor(localaqqs.backgroundColor);
          localObject = new int[2];
          localObject[0] = iZ(paramInt);
          localObject[1] = iY(paramInt);
        }
      }
    }
    localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, (int[])localObject);
    this.Dl.setImageDrawable((Drawable)localObject);
    this.Dl.setBackgroundColor(-1);
  }
  
  public int a(Bundle paramBundle)
  {
    int j = super.a(paramBundle);
    this.jdField_a_of_type_Aqzl.aK.setVisibility(8);
    if (this.Js != null) {
      this.Js.setVisibility(8);
    }
    paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    this.dBK = paramBundle.getInt(this.mApp.getCurrentAccountUin() + "_sign_edit_red_dot_key", 0);
    if (this.dBK > 0) {
      this.GD.setVisibility(4);
    }
    this.jdField_a_of_type_Arcd.mProgressBarController.xW(false);
    this.jdField_a_of_type_Arbs.dp("web_view_long_click", false);
    dNo();
    paramBundle.edit().putBoolean(this.mApp.getCurrentAccountUin() + "_has_history_sig_del_key", false).apply();
    return j;
  }
  
  public void a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      onBack();
    }
    super.a(paramInt, paramKeyEvent);
  }
  
  public void a(View paramView, int paramInt, amif paramamif)
  {
    QLog.d("Signature.Fragment", 1, new Object[] { "onClick viewType=", paramView });
    if ((paramInt == 2) || (paramInt == 1))
    {
      Pd(false);
      VasWebviewUtil.reportCommercialDrainage("signature_store", "click_signature", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "handleRenderSignature tplId = " + paramInt1 + " fontId = " + paramInt2 + " fontType = " + paramInt3 + " actionId = " + paramInt4 + " actionText = " + paramString + " isDefault=" + paramInt5);
    }
    if (this.c != null)
    {
      this.isDefault = paramInt5;
      if ((TextUtils.isEmpty(this.c.actionText)) || (TextUtils.isEmpty(paramString)) || (paramString.equals(this.c.actionText))) {
        break label321;
      }
    }
    label321:
    for (int j = 1;; j = 0)
    {
      if (((paramInt1 != this.c.tplId) || (paramInt2 != this.c.fontId) || (paramInt3 != this.c.fontType) || (paramInt4 != this.c.actionId) || (j != 0)) && (paramInt5 == 0)) {
        this.cCx = true;
      }
      this.c.tplId = paramInt1;
      this.c.fontId = paramInt2;
      this.c.fontType = paramInt3;
      this.c.actionId = paramInt4;
      if ((this.cCy) || (TextUtils.isEmpty(this.c.getPlainText())))
      {
        this.cCy = true;
        this.c.plainText.set(0, paramString);
      }
      this.c.dataId = 0;
      this.c.dataText = "";
      if (paramInt5 == 0) {
        amhd.a().g(this.c);
      }
      if (this.mUIHandler != null) {
        this.mUIHandler.sendEmptyMessage(257);
      }
      return;
    }
  }
  
  public void dNj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 1, "publishRichStatus");
    }
    int j = this.c.getTotalLenForShow();
    if (j > 80)
    {
      localObject = new Message();
      ((Message)localObject).what = 258;
      this.mUIHandler.sendMessage((Message)localObject);
      return;
    }
    anot.a(null, "dc00898", "", "", "0X800A63D", "0X800A63D", 0, 0, "0", "0", "", "");
    if (this.c.bOnlyHasTopic())
    {
      this.mUIHandler.sendEmptyMessage(260);
      return;
    }
    Object localObject = amhd.a().a(this.c.tplId);
    if ((j == 0) && (((aqqs)localObject).a == null))
    {
      aqha.a(getActivity(), 230, acfp.m(2131714550), acfp.m(2131714553), acfp.m(2131714563), acfp.m(2131714548), new amga(this), new amgb(this)).show();
      return;
    }
    dNe();
  }
  
  public void dNo() {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("publish_ever", false)));
    if (QLog.isColorLevel()) {
      QLog.i("Signature.Fragment", 2, "doOnActivityResult refetch");
    }
    amhd.a().j = null;
    amhd.a().k = null;
    initData();
    dNo();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    dNi();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 257: 
      dNm();
      return true;
    case 258: 
      QQToast.a(getActivity(), 1, acfp.m(2131714541), 1).show();
      return true;
    case 261: 
      QQToast.a(getActivity(), 1, acfp.m(2131714543), 1).show();
      return true;
    case 260: 
      QQToast.a(getActivity(), 1, acfp.m(2131714554), 1).show();
      return true;
    case 259: 
      dispatchPluginEvent(8589934617L, (HashMap)paramMessage.obj);
      return true;
    }
    if (paramMessage.arg1 >= 0)
    {
      this.Yj.setVisibility(0);
      this.Yj.setText(String.format(getString(2131720321), new Object[] { Integer.valueOf(paramMessage.arg1) }));
      return true;
    }
    this.Yj.setVisibility(8);
    return true;
  }
  
  public int iY(int paramInt)
  {
    return paramInt + -2147483648;
  }
  
  public int iZ(int paramInt)
  {
    return paramInt + 1291845632;
  }
  
  public void onBack()
  {
    if ((this.cCx) && (!this.cCw))
    {
      aqha.a(getActivity(), 230, acfp.m(2131714570), acfp.m(2131714564), acfp.m(2131714569), acfp.m(2131714555), new amgg(this), new amgh(this)).show();
      return;
    }
    getActivity().finish();
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
      if (this.dBK < 1)
      {
        Us(1);
        this.GD.setVisibility(4);
      }
      dispatchPluginEvent(8589934616L, null);
      Object localObject = "signature_4";
      if (this.cCv) {
        localObject = "signature_7";
      }
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "signature", (String)localObject, "", 1, 0, 0, "", "", "");
      continue;
      Pd(true);
      VasWebviewUtil.reportCommercialDrainage("signature_store", "click_edit", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      continue;
      if ((this.cCx) && (this.isDefault == 0)) {
        amhd.a().g(this.c);
      }
      for (;;)
      {
        localObject = new Intent(getActivity(), PublicFragmentActivity.class);
        ((Intent)localObject).putExtra("key_uin", this.mApp.getCurrentAccountUin());
        ((Intent)localObject).putExtra("key_uin_name", this.mApp.getCurrentNickname());
        ((Intent)localObject).putExtra("key_open_via", "history-geqian");
        PublicFragmentActivity.b.start(getActivity(), (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
        anot.a(null, "dc00898", "", "", "0X800A63C", "0X800A63C", 0, 0, "0", "0", "", "");
        VasWebviewUtil.reportCommercialDrainage("signature_store", "history_enter", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        break;
        this.c = new RichStatus(null);
        this.c.setEmptyStatus(true);
      }
      onBack();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    kx.a().addObserver(this.h);
    amhd.a().addObserver(this.h);
    this.cCv = getIntent().getBooleanExtra("open_diy", false);
    dNk();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "onCreateView");
    }
    ApngImage.playByTag(17);
    SoftInputDetectView localSoftInputDetectView = (SoftInputDetectView)paramLayoutInflater.inflate(2131562248, null);
    this.GB = localSoftInputDetectView.findViewById(2131378400);
    Object localObject = localSoftInputDetectView.findViewById(2131378422).getLayoutParams();
    int j = awdo.a(getActivity(), getActivity());
    if (j > ((ViewGroup.LayoutParams)localObject).height)
    {
      ((ViewGroup.LayoutParams)localObject).height = j;
      localSoftInputDetectView.findViewById(2131378419).setOnClickListener(this);
      if (this.cCv) {
        ((TextView)localSoftInputDetectView.findViewById(2131378423)).setText("DIY签名");
      }
      this.GB.setOnClickListener(this);
      this.GC = localSoftInputDetectView.findViewById(2131378420);
      this.GC.setOnTouchListener(jll.a);
      this.GC.setOnClickListener(this);
      this.Yk = ((TextView)localSoftInputDetectView.findViewById(2131378426));
      this.Yk.setOnClickListener(this);
      this.Yk.setOnTouchListener(jll.a);
      this.Yj = ((TextView)localSoftInputDetectView.findViewById(2131378427));
      this.Yh = ((TextView)localSoftInputDetectView.findViewById(2131378418));
      this.Yh.setOnClickListener(this);
      this.Yi = ((TextView)localSoftInputDetectView.findViewById(2131378416));
      this.Yi.setOnClickListener(this);
      rpq.h(this.Yi, 0, 0, 0, rpq.dip2px(getActivity(), 10.0F));
      this.GD = localSoftInputDetectView.findViewById(2131378421);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        break label433;
      }
    }
    label433:
    for (boolean bool = true;; bool = false)
    {
      localSoftInputDetectView.setExcludeStatusBar(bool);
      localObject = (RelativeLayout)localSoftInputDetectView.findViewById(2131378425);
      this.Dl = ((ImageView)localSoftInputDetectView.findViewById(2131378417));
      ((RelativeLayout)localObject).addView(super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle), new RelativeLayout.LayoutParams(-1, -1));
      dNm();
      initData();
      VasWebviewUtil.reportCommercialDrainage("signature_store", "head_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      V4FragmentCollector.onV4FragmentViewCreated(this, localSoftInputDetectView);
      return localSoftInputDetectView;
      j = getStatusBarHeight(getActivity());
      if (j <= ((ViewGroup.LayoutParams)localObject).height) {
        break;
      }
      ((ViewGroup.LayoutParams)localObject).height = j;
      break;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Amig != null) {
      this.jdField_a_of_type_Amig.destroy();
    }
    kx.a().deleteObserver(this.h);
    amhd.a().deleteObserver(this.h);
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
    amhd.a().j = null;
    amhd.a().k = null;
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.c == null) {
      return;
    }
    Object localObject;
    if (this.c.isEmptyStatus())
    {
      this.c.setEmptyStatus(false);
      initData();
      if ((this.mApp != null) && (!TextUtils.isEmpty(this.mApp.getCurrentAccountUin())))
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        if (((SharedPreferences)localObject).getBoolean(this.mApp.getCurrentAccountUin() + "_has_history_sig_del_key", false))
        {
          dNo();
          ((SharedPreferences)localObject).edit().putBoolean(this.mApp.getCurrentAccountUin() + "_has_history_sig_del_key", false).apply();
        }
      }
    }
    for (;;)
    {
      dNl();
      return;
      localObject = amhd.a().j;
      if ((localObject != null) && (this.isDefault == 0))
      {
        this.c.copyFrom((RichStatus)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.i("Signature.Fragment", 2, String.format("onResume %s", new Object[] { ((RichStatus)localObject).getPlainText() }));
        }
        dNm();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment
 * JD-Core Version:    0.7.0.1
 */