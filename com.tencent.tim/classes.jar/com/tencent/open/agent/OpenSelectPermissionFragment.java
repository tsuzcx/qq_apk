package com.tencent.open.agent;

import acfp;
import ahlw;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import arhz;
import arsd;
import arse;
import arsf;
import artd;
import artj;
import asav;
import asbf;
import asbh;
import aurs;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.SSOAccountObserver;

public class OpenSelectPermissionFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private View DO;
  private ImageView Gm;
  private View JW;
  private View Kd;
  private artd jdField_a_of_type_Artd = new arsd(this);
  private asbh jdField_a_of_type_Asbh;
  private a jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$a;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  protected SharedPreferences ad;
  protected SharedPreferences ae;
  private long awn;
  private long awq;
  private long awr;
  private long aws;
  private long awt;
  private String cBS;
  private SSOAccountObserver d;
  private boolean dcG;
  boolean dcR;
  private int ekO;
  protected arhz mProgress;
  SystemBarCompact mSystemBarComp;
  private long mVid;
  
  private String Dd()
  {
    return String.valueOf(this.awn);
  }
  
  private String Df()
  {
    if (this.awq == 0L) {
      return String.valueOf(this.awn);
    }
    return String.valueOf(this.awq);
  }
  
  private boolean ME()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
  }
  
  private void Ug(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    ThreadManager.executeOnFileThread(new OpenSelectPermissionFragment.1(this));
  }
  
  private void Uh(boolean paramBoolean)
  {
    ahlw.a("KEY_AUTHORIZE_REQUEST", this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Df()), paramBoolean);
  }
  
  private void Zl(int paramInt)
  {
    Object localObject = Df();
    localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a((String)localObject);
    this.jdField_a_of_type_Asbh.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, ((asav)localObject).uin, Df(), paramInt, new arse(this));
  }
  
  private void doAuth()
  {
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "doAuth");
    this.ekO = 0;
    elu();
  }
  
  private void dv(String paramString, boolean paramBoolean)
  {
    if (getActivity() == null)
    {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "showToast activity is null");
      return;
    }
    aurs.runOnUiThread(new OpenSelectPermissionFragment.2(this, paramBoolean, paramString));
  }
  
  private void elu()
  {
    asav localasav = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Df());
    ahlw.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", localasav);
    ahlw.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL", localasav);
    ahlw.Kj("KEY_LOGIN_STAGE_3_TOTAL");
    showLoading();
    ThreadManager.executeOnNetWorkThread(new OpenSelectPermissionFragment.3(this));
  }
  
  private void elv()
  {
    dv(acfp.m(2131709374), false);
    if (ME())
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "finishAndToLogin but Activity isFinishing");
      return;
    }
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "finishAndToLogin");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_need_login", 1);
    getActivity().setResult(102, localIntent);
    getActivity().finish();
  }
  
  private List<CardContainer.a> gQ()
  {
    Object localObject = this.jdField_a_of_type_Asbh.bl(Df());
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CardContainer.a locala1 = (CardContainer.a)((Iterator)localObject).next();
      CardContainer.a locala2 = new CardContainer.a();
      locala2.flag = locala1.flag;
      if ((locala2.flag == 2) || (locala2.flag == 3))
      {
        locala2.api = locala1.api;
        locala2.id = locala1.id;
        locala2.isNew = locala1.isNew;
        locala2.title = locala1.title;
        if (locala2.flag == 2) {}
        for (boolean bool = true;; bool = false)
        {
          locala2.isChecked = bool;
          localArrayList.add(locala2);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void showLoading()
  {
    if (this.mProgress == null)
    {
      this.mProgress = new arhz(getActivity(), 0, 2131561630, 17);
      this.mProgress.setHeightParams(-1);
      this.mProgress.show();
    }
    while (this.mProgress.isShowing()) {
      return;
    }
    this.mProgress.show();
  }
  
  protected void WN(String paramString)
  {
    String str = Df();
    asav localasav = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(str);
    SharedPreferences.Editor localEditor;
    if (localasav != null)
    {
      localEditor = this.ad.edit();
      localEditor.putString(paramString, localasav.uin);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(localasav.uin))) {}
    }
    else
    {
      return;
    }
    localEditor.putString(str + ":" + localasav.uin, paramString);
    localEditor.commit();
  }
  
  protected void iE(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      SharedPreferences.Editor localEditor = this.ae.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void jf()
  {
    if (getActivity() == null) {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "dismissDialogProgress activity is null");
    }
    while ((getActivity().isFinishing()) || (this.mProgress == null) || (!this.mProgress.isShowing())) {
      return;
    }
    try
    {
      this.mProgress.dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "dismissDialogProgress Exception", localException);
    }
  }
  
  protected void l(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Df());
    ForwardUtils.a(paramInt, (asav)localObject);
    String str = Df();
    if (localObject == null) {}
    for (localObject = "";; localObject = ((asav)localObject).uin)
    {
      ForwardUtils.p(paramInt, str, (String)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_cancel_auth", 0);
      ((Intent)localObject).putExtra("key_error_code", paramInt);
      ((Intent)localObject).putExtra("key_error_msg", paramString2);
      ((Intent)localObject).putExtra("key_error_detail", paramString3);
      ((Intent)localObject).putExtra("key_response", paramString1);
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, new Object[] { "OpenVirtual.setSdkResult, error: ", Integer.valueOf(paramInt), ", msg:", paramString2, ", detail:", paramString3 });
      getActivity().setResult(102, (Intent)localObject);
      getActivity().finish();
      this.mProgress.dismiss();
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.JW) {
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.DO)
      {
        doAuth();
      }
      else if (paramView == this.Kd)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_cancel_auth", 1);
        getActivity().setResult(102, localIntent);
        getActivity().finish();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559882, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getActivity().getAppRuntime());
    this.jdField_a_of_type_Asbh = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
    this.JW = paramLayoutInflater.findViewById(2131363226);
    this.Kd = paramLayoutInflater.findViewById(2131364228);
    paramLayoutInflater.findViewById(2131379866).setBackgroundColor(0);
    this.Gm = ((ImageView)paramLayoutInflater.findViewById(2131362855));
    this.JW.setOnClickListener(this);
    this.DO = paramLayoutInflater.findViewById(2131365224);
    this.DO.setOnClickListener(this);
    this.Kd.setOnClickListener(this);
    this.mProgress = new arhz(getActivity(), 0, 2131561630, 17);
    this.mProgress.setHeightParams(-1);
    this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$a = new a(null);
    paramViewGroup = getActivity().getIntent();
    this.awn = Long.parseLong(paramViewGroup.getStringExtra("appId"));
    this.awq = ForwardUtils.parseLong(paramViewGroup.getStringExtra("key_proxy_appid"));
    this.cBS = paramViewGroup.getStringExtra("pkg_name");
    this.mVid = paramViewGroup.getLongExtra("vid", 0L);
    this.awt = paramViewGroup.getLongExtra("login_cost", 0L);
    this.aws = paramViewGroup.getLongExtra("authListCostTime", 0L);
    this.awr = paramViewGroup.getLongExtra("authStartTime", SystemClock.elapsedRealtime());
    this.dcG = paramViewGroup.getBooleanExtra("is_from_qr_login", false);
    ((ListView)paramLayoutInflater.findViewById(2131372998)).setAdapter(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$a);
    this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$a.setData(gQ());
    Ug(paramViewGroup.getBooleanExtra("hasIcon", false));
    paramViewGroup = paramViewGroup.getStringExtra("appName");
    if (!TextUtils.isEmpty(paramViewGroup)) {
      ((TextView)paramLayoutInflater.findViewById(2131362857)).setText(paramViewGroup);
    }
    this.ad = asbf.getGlobalPreference(getActivity(), "uin_openid_store");
    this.ae = asbf.getGlobalPreference(getActivity(), "openid_encrytoken");
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, new Object[] { "onCreateView mCurrentAppId=", Long.valueOf(this.awn), ", mProxyCurrentAppId=", Long.valueOf(this.awq), ", appName=", paramViewGroup });
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.d = null;
    this.jdField_a_of_type_Artd = null;
    this.jdField_a_of_type_Asbh = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.dcR) {
      return;
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.mSystemBarComp = new SystemBarCompact(getActivity(), true, getResources().getColor(2131167654));
      this.mSystemBarComp.setStatusBarColor(getResources().getColor(2131167654));
      this.mSystemBarComp.init();
    }
    this.dcR = true;
    QLog.i("SDK_LOGIN.OpenSelectPermissionFragment", 1, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
    String str = Build.MANUFACTURER + Build.MODEL;
    if ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C"))) {
      ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
      return;
      ImmersiveUtils.l(getActivity().getWindow());
    }
  }
  
  public class a
    extends artj
  {
    List<CardContainer.a> JA;
    
    private a() {}
    
    public int getCount()
    {
      if (this.JA == null) {
        return 0;
      }
      return this.JA.size();
    }
    
    public List<CardContainer.a> getData()
    {
      return this.JA;
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.JA != null) && (paramInt < this.JA.size())) {
        return this.JA.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      CardContainer.a locala = (CardContainer.a)this.JA.get(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = OpenSelectPermissionFragment.this.getActivity().getLayoutInflater().inflate(2131559885, paramViewGroup, false);
        paramView = new OpenSelectPermissionFragment.b(null);
        paramView.acV = ((TextView)localView.findViewById(2131373002));
        paramView.L = ((Switch)localView.findViewById(2131373001));
        localView.setTag(paramView);
      }
      for (;;)
      {
        paramView.L.setOnCheckedChangeListener(new arsf(this, locala));
        paramView.L.setChecked(locala.isChecked);
        paramView.acV.setText(locala.title);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        OpenSelectPermissionFragment.b localb = (OpenSelectPermissionFragment.b)paramView.getTag();
        localView = paramView;
        paramView = localb;
      }
    }
    
    public void setData(List<CardContainer.a> paramList)
    {
      this.JA = paramList;
      notifyDataSetChanged();
    }
  }
  
  static class b
  {
    Switch L;
    TextView acV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment
 * JD-Core Version:    0.7.0.1
 */