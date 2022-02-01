package com.tencent.open.filedownload;

import acfp;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqai;
import aqiw;
import arvv;
import arwk;
import arwl;
import arwm;
import arwn;
import arwt;
import arxa;
import asaj;
import asak;
import asal;
import asam;
import asan;
import asap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.filedownload.ui.NormalDownloadButton;
import com.tencent.open.filedownload.ui.SafeDownloadButton;
import com.tencent.open.filedownload.ui.WhiteListDownloadButton;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;
import org.json.JSONException;
import org.json.JSONObject;

public class ApkFileDownloadFragment
  extends IphoneTitleBarFragment
{
  private ImageView Gb;
  private asap jdField_a_of_type_Asap;
  private a jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private TextView add;
  private TextView ade;
  private TextView adf;
  private asap b;
  private boolean ddI;
  private FragmentActivity mActivity;
  private String mSource;
  
  private void Uq(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.cD(paramBoolean, true);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.resetUI();
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(8);
    this.adf.setVisibility(4);
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Asap.name == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Asap.name)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private void a(asap paramasap)
  {
    asan.o(this.Gb, paramasap.iconUrl);
    this.add.setText(paramasap.name);
    if (paramasap.length <= 0L)
    {
      DownloadInfo localDownloadInfo = arvv.a().e(paramasap.url);
      if (localDownloadInfo != null) {
        paramasap.length = localDownloadInfo.awN;
      }
    }
    if (paramasap.length > 0L)
    {
      this.ade.setVisibility(0);
      this.ade.setText(aqai.a((float)paramasap.length, true, 2));
      return;
    }
    this.ade.setVisibility(8);
  }
  
  private boolean aHD()
  {
    if (this.ddI) {}
    while (this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  private void emp()
  {
    arwt.i("ApkFileDownloadFragment_", ">specialCode " + this.ddI + "|" + this.jdField_a_of_type_Asap.packageName + "|" + aqiw.isNetworkAvailable(getActivity()) + "|" + aqiw.isWifiConnected(getActivity()));
    if ((this.ddI) && (TextUtils.equals(this.jdField_a_of_type_Asap.packageName, "com.tencent.weishi")) && (aqiw.isNetworkAvailable(getActivity())) && (aqiw.isWifiConnected(getActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.cD(true, true);
    }
  }
  
  private void emq()
  {
    arwk.a(arwl.a().k(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a.pageId).j("0").l("0").m(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a.via).a(this.jdField_a_of_type_Asap.name).b(this.jdField_a_of_type_Asap.packageName).g(this.jdField_a_of_type_Asap.url));
    if (this.ddI)
    {
      localQQAppInterface = getActivity().app;
      if (this.jdField_a_of_type_Asap.name == null) {}
      for (str = "";; str = this.jdField_a_of_type_Asap.name)
      {
        anot.a(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Asap.name == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Asap.name)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private <T extends View> T findViewById(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void initData()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.mSource);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.mSource);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.mSource);
    if (this.ddI)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Asap.kx = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(this.jdField_a_of_type_Asap);
      this.adf.setVisibility(8);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Asap);
      return;
      this.b = asap.a(this.jdField_a_of_type_Asap);
      this.b.url = "https://a.app.qq.com/o/myapp-down?g_f=1005234";
      this.b.packageName = "com.tencent.android.qqdownloader";
      this.b.name = acfp.m(2131702417);
      this.b.length = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(8);
      this.jdField_a_of_type_Asap.kx = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(this.jdField_a_of_type_Asap);
      this.b.kx = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(this.b);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new asak(this));
      this.jdField_a_of_type_Asap.kx = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(this.jdField_a_of_type_Asap);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new asal(this));
      this.adf.setText(acfp.m(2131702426));
      this.adf.setOnClickListener(new asam(this));
    }
  }
  
  private void initView()
  {
    this.leftView.setText(acfp.m(2131702421));
    this.leftView.setOnClickListener(new asaj(this));
    setTitle(acfp.m(2131702425));
    this.Gb = ((ImageView)findViewById(2131368814));
    this.add = ((TextView)findViewById(2131381131));
    this.ade = ((TextView)findViewById(2131381130));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)findViewById(2131363925));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)findViewById(2131363977));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)findViewById(2131364043));
    this.adf = ((TextView)findViewById(2131381147));
  }
  
  private void parseIntent()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      arxa.a().showToast(acfp.m(2131702423));
      this.mActivity.finish();
      return;
    }
    this.ddI = localBundle.getBoolean("param_in_white_list", false);
    if (this.ddI) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a = a.b;
    }
    for (;;)
    {
      Object localObject = localBundle.getString("param_ext_info");
      this.jdField_a_of_type_Asap = new asap();
      this.jdField_a_of_type_Asap.pageId = this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a.pageId;
      this.jdField_a_of_type_Asap.via = this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a.via;
      this.jdField_a_of_type_Asap.url = localBundle.getString("param_url");
      arwt.i("ApkFileDownloadFragment_", "RealUrl:" + this.jdField_a_of_type_Asap.url);
      this.jdField_a_of_type_Asap.length = localBundle.getLong("_filesize");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          arwt.i("ApkFileDownloadFragment_", "appInfoJson:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Asap.url)) {
            this.jdField_a_of_type_Asap.url = ((JSONObject)localObject).optString("url");
          }
          this.jdField_a_of_type_Asap.iconUrl = ((JSONObject)localObject).optString("app_icon");
          this.jdField_a_of_type_Asap.name = ((JSONObject)localObject).optString("app_name");
          if (this.jdField_a_of_type_Asap.length <= 0L) {
            this.jdField_a_of_type_Asap.length = ((JSONObject)localObject).optLong("app_filesize");
          }
          this.jdField_a_of_type_Asap.packageName = ((JSONObject)localObject).optString("packagename");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Asap.name)) {
          break label394;
        }
        this.jdField_a_of_type_Asap.name = asan.qL(this.jdField_a_of_type_Asap.url);
        this.mSource = localBundle.getString("big_brother_source_key");
        arwt.i("ApkFileDownloadFragment_", "mPageType:" + this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a + "\nTaskInfo:" + this.jdField_a_of_type_Asap + "\nmSource:" + this.mSource);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Asap.url)) {
        break;
      }
      arxa.a().showToast(acfp.m(2131702420));
      this.mActivity.finish();
      return;
      if (asan.akW()) {
        this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a = a.c;
      } else {
        this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a = a.d;
      }
    }
    label394:
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mActivity = getActivity();
    QAppCenterPluginProxyActivityTools.cG(this.mActivity);
    parseIntent();
    initView();
    initData();
    emq();
    emp();
  }
  
  public int getContentLayoutId()
  {
    return 2131559853;
  }
  
  public boolean onBackEvent()
  {
    if (aHD())
    {
      arwk.b(arwm.a().a("301").k(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a.pageId).j("2").l("0").m(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a.via).a(this.jdField_a_of_type_Asap.name).b(this.jdField_a_of_type_Asap.packageName).g(this.jdField_a_of_type_Asap.url));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.cE(false, true);
      return true;
    }
    arwk.b(arwm.a().a("200").k(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a.pageId).j("2").l("0").m(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$a.via).a(this.jdField_a_of_type_Asap.name).b(this.jdField_a_of_type_Asap.packageName).g(this.jdField_a_of_type_Asap.url));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    arwt.i("ApkFileDownloadFragment_", "[onDestroy]");
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton != null) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.destroy();
    }
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton != null) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.destroy();
    }
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton != null) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.destroy();
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    arwt.i("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.onResume();
    super.onResume();
  }
  
  public static class a
  {
    static final a b = new a("ANDROID.QQ.WLISTAPK", "7003");
    static final a c = new a("ANDROID.QQ.YYBAPK", "7002");
    static final a d = new a("ANDROID.QQ.NEWYYBAPK", "7001");
    public String pageId;
    public String via;
    
    a(String paramString1, String paramString2)
    {
      this.via = paramString1;
      this.pageId = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */