package com.tencent.mobileqq.vip.lianghao.fragment;

import acfp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Window;
import aqiw;
import aqwb;
import aqwc;
import aqwl;
import aqwm;
import aqwn;
import aqwo;
import aqwr;
import arhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class LiangHaoBuyFragment
  extends PublicBaseFragment
{
  private Dialog aD;
  private Intent ao;
  private aqwl b;
  private boolean cWJ;
  private int edn = 1;
  private int edo = 1;
  private boolean isFinish;
  private arhz progressDialog;
  
  private void D(String paramString, byte[] paramArrayOfByte)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    this.cWJ = true;
    if ((this.aD != null) && (this.aD.isShowing())) {
      this.aD.dismiss();
    }
    String str;
    if (this.edo != 2)
    {
      str = "mvip.p.a.lianghao_tj";
      if (paramArrayOfByte == null) {
        break label292;
      }
    }
    label292:
    for (paramArrayOfByte = SecUtil.toHexString(paramArrayOfByte);; paramArrayOfByte = "")
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("unit", acfp.m(2131707659));
        localJSONObject.put("userId", paramString);
        localJSONObject.put("openMonth", "1");
        localJSONObject.put("offerId", "1450000833");
        localJSONObject.put("aid", str);
        localJSONObject.put("ticketValue", paramArrayOfByte);
        localJSONObject.put("ticketName", "vask_27");
        localJSONObject.put("isCanChange", false);
        localJSONObject.put("serviceCode", "CJCLUBT");
        localJSONObject.put("serviceName", "QQ超级会员");
        if (QLog.isDevelopLevel()) {
          QLog.i("LiangHaoBuyFragment", 4, "jumpToPay " + localJSONObject.toString());
        }
        paramString = new Intent(localFragmentActivity, PayBridgeActivity.class);
        paramArrayOfByte = new Bundle();
        paramArrayOfByte.putString("json", localJSONObject.toString());
        paramArrayOfByte.putString("callbackSn", "lhPaySn");
        paramString.putExtras(paramArrayOfByte);
        paramString.putExtra("payparmas_from_is_login_state", false);
        paramString.putExtra("pay_requestcode", 4);
        localFragmentActivity.startActivityForResult(paramString, this.edo);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        egd();
        return;
      }
      str = "mvip.p.a.lianghao_gd";
      break;
    }
  }
  
  private void VM(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 1, paramString, 0).show();
      return;
    }
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.sApplication))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 1, 2131695267, 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.sApplication, 1, 2131695259, 0).show();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, aqwl paramaqwl)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("lh_request_code", 2);
    localIntent.putExtra("lh_uin", paramaqwl.uin);
    localIntent.putExtra("lh_light", paramaqwl.cyo);
    PublicFragmentActivity.b.startForResult(paramActivity, localIntent, PublicTransFragmentActivity.class, LiangHaoBuyFragment.class, 2);
  }
  
  public static void a(Context paramContext, Intent paramIntent, aqwl paramaqwl)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("lh_request_code", 1);
    localIntent.putExtra("lh_uin", paramaqwl.uin);
    localIntent.putExtra("lh_light", paramaqwl.cyo);
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicTransFragmentActivity.class, LiangHaoBuyFragment.class);
  }
  
  public static void b(Context paramContext, Intent paramIntent, aqwl paramaqwl)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("lh_request_code", 3);
    localIntent.putExtra("lh_uin", paramaqwl.uin);
    localIntent.putExtra("lh_light", paramaqwl.cyo);
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicTransFragmentActivity.class, LiangHaoBuyFragment.class);
  }
  
  private void efZ()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    this.aD = new aqwr().a(localFragmentActivity, this.b, new aqwm(this));
    this.aD.setOnDismissListener(new aqwn(this));
    this.aD.show();
  }
  
  private void ega()
  {
    if (getActivity() == null) {
      return;
    }
    if ((this.progressDialog != null) && (this.progressDialog.isShowing())) {
      this.progressDialog.dismiss();
    }
    this.progressDialog = new arhz(getActivity(), getActivity().getTitleBarHeight());
    this.progressDialog.setMessage(2131696693);
    this.progressDialog.show();
  }
  
  private void egb()
  {
    if (this.progressDialog != null) {
      this.progressDialog.dismiss();
    }
  }
  
  private void egc()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LiangHaoBuyFragment", 4, "lockLiangHao uin=" + this.b.uin);
    }
    ega();
    new aqwb(localFragmentActivity.app).a(localFragmentActivity.getIntent(), this.b.uin, new aqwo(this));
  }
  
  private void egd()
  {
    if (this.isFinish) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      this.isFinish = true;
      if ((this.aD != null) && (this.aD.isShowing())) {
        this.aD.dismiss();
      }
      localFragmentActivity = getActivity();
    } while (localFragmentActivity == null);
    if (this.edo == 2) {}
    Intent localIntent1;
    switch (this.edn)
    {
    default: 
      Intent localIntent2 = this.ao;
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = localFragmentActivity.getIntent();
      }
      switch (this.edn)
      {
      }
      break;
    }
    for (;;)
    {
      localFragmentActivity.finish();
      return;
      localFragmentActivity.setResult(4660);
      break;
      aqwc.a(localFragmentActivity, true, this.b.uin, this.b.cyo, localIntent1);
      continue;
      aqwc.a(localFragmentActivity, false, this.b.uin, this.b.cyo, localIntent1);
    }
  }
  
  public static int g(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiangHaoBuyFragment", 2, "onActivityResult data=null");
      }
      return -1;
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getString("result");; paramIntent = "{}")
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiangHaoBuyFragment", 2, "onActivityResult data=" + paramIntent);
      }
      try
      {
        int i = new JSONObject(paramIntent).optInt("resultCode", -1);
        return i;
      }
      catch (JSONException paramIntent)
      {
        if (!QLog.isColorLevel()) {
          break label128;
        }
        QLog.e("LiangHaoBuyFragment", 2, "getPayResultCode " + paramIntent);
      }
    }
    label128:
    return -1;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.getIntent();
    this.edo = paramBundle.getIntExtra("lh_request_code", 1);
    this.b = new aqwl(paramBundle.getStringExtra("lh_uin"), paramBundle.getStringExtra("lh_light"));
    if (QLog.isDevelopLevel()) {
      QLog.i("LiangHaoBuyFragment", 4, "onActivityCreated from=" + this.edo + ",lh=" + this.b.toString());
    }
    switch (this.edo)
    {
    default: 
      return;
    case 1: 
    case 2: 
      efZ();
      return;
    }
    D(this.b.uin, paramBundle.getByteArrayExtra("key_register_lhsig"));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.edo != paramInt1)
    {
      egd();
      return;
    }
    if (g(paramIntent) == 0) {}
    for (this.edn = 2;; this.edn = 3)
    {
      egd();
      return;
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment
 * JD-Core Version:    0.7.0.1
 */