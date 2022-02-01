package com.tencent.open.agent;

import acfp;
import ahlw;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;
import anpc;
import aqha;
import aqhs;
import aqiw;
import aqju;
import arhz;
import aroi;
import arot;
import arou;
import arov;
import arow;
import arox;
import aroz;
import arpa;
import arpb;
import arsg;
import arts;
import artv.a.a;
import artw;
import aruh;
import arwt;
import arxc;
import arxi.a;
import aryn;
import asav;
import asaw;
import asbf;
import asbh;
import asbp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.util.HandlerPlus;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorityActivity
  extends BaseActivity
  implements View.OnClickListener, arxi.a
{
  public static String cBq;
  protected static boolean dcA = true;
  private TextView GY;
  protected View JO;
  private artv.a.a jdField_a_of_type_Artv$a$a = new artv.a.a();
  public asav a;
  public CardContainer a;
  private MaxHeightScrollView jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView;
  public SdkAuthorize.AuthorizeResponse a;
  public OpenSDKAppInterface a;
  protected WtloginManager a;
  public String aIE;
  public long abu;
  protected SharedPreferences ac;
  protected SharedPreferences ad;
  protected SharedPreferences ae;
  public long awf;
  public long awg;
  public long awh;
  public long awi;
  public long awj;
  public long awk;
  public long awl;
  private artv.a.a b;
  public HandlerPlus b;
  private artv.a.a c;
  public SSOAccountObserver c;
  public String cBo;
  public String cBp;
  protected String cBr;
  private String cBs;
  protected String cBt = "";
  private artv.a.a d = new artv.a.a();
  public boolean dcB;
  public boolean dcC;
  protected boolean dcD;
  public boolean dcE;
  public boolean dcF;
  private boolean dcG;
  public boolean dcH;
  public boolean dcI;
  public boolean dcJ;
  public boolean dcK;
  private boolean dcL;
  private boolean dcM;
  private boolean dcN;
  protected float density;
  private ImmersiveTitleBar2 e;
  protected int ekF;
  public int ekG;
  public int ekH;
  public int ekI;
  private int ekJ = -1;
  private TextView ey;
  public Button hA;
  public Runnable ic = new AuthorityActivity.5(this);
  protected long iu;
  protected Handler.Callback k = new arpb(this);
  protected String mAppName;
  public Bundle mParams;
  protected arhz mProgress;
  protected View mRoot;
  protected TextView mTip;
  private TextView mTitleView;
  protected List<String> qg;
  
  public AuthorityActivity()
  {
    this.jdField_b_of_type_Artv$a$a = new artv.a.a();
    this.jdField_c_of_type_Artv$a$a = new artv.a.a();
    this.jdField_c_of_type_MqqObserverSSOAccountObserver = new arot(this);
    this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.k);
  }
  
  private void D(String paramString, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_RETRY_COUNT", Integer.toString(paramInt));
    ahlw.a(paramString, this.jdField_a_of_type_Asav, localHashMap, paramBoolean);
  }
  
  public static Bitmap P(String paramString)
  {
    try
    {
      Object localObject = (HttpURLConnection)new URL(paramString).openConnection();
      ((HttpURLConnection)localObject).setDoInput(true);
      ((HttpURLConnection)localObject).connect();
      localObject = ((HttpURLConnection)localObject).getInputStream();
      Bitmap localBitmap = SafeBitmapFactory.decodeStream((InputStream)localObject);
      ((InputStream)localObject).close();
      return localBitmap;
    }
    catch (IOException localIOException)
    {
      QLog.e("AuthorityActivity", 1, new Object[] { "-->getbitmap IOException, url = ", paramString, ", exception message : ", localIOException.getMessage() });
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("AuthorityActivity", 1, new Object[] { "-->getbitmap decodeStream oom, url = ", paramString });
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("AuthorityActivity", 1, new Object[] { "-->getbitmap Exception, url = ", paramString, ", exception message : ", localException.getMessage() });
    }
    return null;
  }
  
  private void ekO()
  {
    Object localObject = this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a;
    TextView localTextView;
    String str;
    if (localObject != null)
    {
      localTextView = ((AuthorityAccountView)localObject).acC;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      ((TextView)((AuthorityAccountView)localObject).findViewById(2131361880)).setVisibility(0);
      localTextView = (TextView)((AuthorityAccountView)localObject).findViewById(2131361879);
      str = this.mParams.getString("sdkp");
      localObject = acfp.m(2131702929);
      if (!"web".equals(str)) {
        break label93;
      }
      localObject = acfp.m(2131702924);
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return;
      label93:
      if ("android".equals(str)) {
        localObject = acfp.m(2131702930);
      }
    }
  }
  
  private void ekP()
  {
    this.e = ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131379866));
    this.ey = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369579));
    this.mTitleView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369627));
    this.GY = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369612));
    this.GY.setText(2131721058);
    this.ey.setOnClickListener(this);
    this.GY.setOnClickListener(this);
    this.e.abu(0);
  }
  
  public void E(String paramString, Bitmap paramBitmap)
  {
    arwt.d("AuthorityActivity", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_Asav != null) && (paramString.equals(this.jdField_a_of_type_Asav.uin)) && (paramBitmap != null)) {
      runOnUiThread(new AuthorityActivity.9(this, paramBitmap));
    }
  }
  
  protected void SZ()
  {
    arxc.a().a(this, this.jdField_a_of_type_Asav.uin, this.jdField_a_of_type_Asav.key, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ri(this.jdField_a_of_type_Asav.uin), this);
  }
  
  protected void Ud(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->changeAccountActivity--isFirstLogin = " + paramBoolean);
    }
    int i = 0;
    if (this.qg != null) {
      i = this.qg.size();
    }
    Intent localIntent2;
    Intent localIntent1;
    if (i > 1)
    {
      localIntent2 = new Intent(this, SwitchAccountActivity.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent2.putExtra("third_app_id", cBq);
      localIntent1 = localIntent2;
      if (this.aIE != null)
      {
        localIntent2.putExtra("param_uin", this.aIE);
        localIntent1 = localIntent2;
      }
    }
    for (;;)
    {
      super.startActivityForResult(localIntent1, 1);
      return;
      localIntent2 = new Intent(this, Login.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent2.putExtra("appid", cBq);
      localIntent1 = localIntent2;
      if (paramBoolean)
      {
        localIntent2.putExtra("is_first_login", true);
        localIntent1 = localIntent2;
      }
    }
  }
  
  protected void WM(String paramString)
  {
    if ((this.dcM) || (TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    Object localObject2 = new String(localWloginSimpleInfo._nick);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString;
    }
    this.aIE = Long.toString(localWloginSimpleInfo._uin);
    paramString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(paramString, (int)(58.0F * this.density), true);
    if (paramString != null)
    {
      localObject2 = artw.a(this, paramString, 63, 63);
      paramString.recycle();
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.aIE, (String)localObject1, (Bitmap)localObject2, false);
      return;
    }
    ThreadManager.executeOnSubThread(new AuthorityActivity.2(this, (String)localObject1));
  }
  
  public void WN(String paramString)
  {
    SharedPreferences.Editor localEditor = this.ad.edit();
    localEditor.putString(paramString, this.jdField_a_of_type_Asav.uin);
    if ((TextUtils.isEmpty(cBq)) || (TextUtils.isEmpty(this.jdField_a_of_type_Asav.uin))) {
      return;
    }
    localEditor.putString(cBq + ":" + this.jdField_a_of_type_Asav.uin, paramString);
    localEditor.commit();
  }
  
  public void WO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->showLoginActivity--uin = *" + artw.qx(this.aIE));
    }
    Intent localIntent = new Intent(this, Login.class);
    localIntent.putExtra("appid", cBq);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    super.startActivityForResult(localIntent, 1);
  }
  
  protected void WP(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->LocalAccountCache--userAccount = *" + artw.qx(paramString));
    }
    SharedPreferences.Editor localEditor = this.ac.edit();
    localEditor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    if (this.ac.getString("accList", null) != null) {}
    for (Object localObject1 = this.ac.getString("accList", null).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          ((ArrayList)localObject2).add(localObject1[i]);
          i += 1;
        }
      }
      while (((ArrayList)localObject2).contains("")) {
        ((ArrayList)localObject2).remove("");
      }
      if (!((ArrayList)localObject2).contains(paramString)) {
        ((ArrayList)localObject2).add(paramString);
      }
      for (;;)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        for (paramString = ""; ((Iterator)localObject1).hasNext(); paramString = paramString + "," + (String)localObject2) {
          localObject2 = (String)((Iterator)localObject1).next();
        }
        ((ArrayList)localObject2).remove(paramString);
        ((ArrayList)localObject2).add(paramString);
      }
      localEditor.putString("accList", paramString);
      localEditor.commit();
      return;
    }
  }
  
  public void a(SdkAuthorize.GetAuthApiListRequest paramGetAuthApiListRequest)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    }
    NewIntent localNewIntent = new NewIntent(this, aruh.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("uin", this.jdField_a_of_type_Asav.uin);
    String str = artw.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_Asav, paramGetAuthApiListRequest.login_sig, "ConnAuthSvr.get_auth_api_list", "ConnAuthSvr.get_auth_api_list_emp");
    boolean bool = "ConnAuthSvr.get_auth_api_list_emp".equals(str);
    byte[] arrayOfByte = paramGetAuthApiListRequest.toByteArray();
    paramGetAuthApiListRequest = arrayOfByte;
    if (bool)
    {
      if ((this.jdField_a_of_type_Asav.hr == null) || (this.jdField_a_of_type_Asav.hr.length == 0))
      {
        paramGetAuthApiListRequest = this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        paramGetAuthApiListRequest.what = 6;
        paramGetAuthApiListRequest.arg1 = 3000;
        paramGetAuthApiListRequest.obj = getResources().getString(2131696654);
        this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramGetAuthApiListRequest);
        return;
      }
      paramGetAuthApiListRequest = asbp.a(arrayOfByte, this.jdField_a_of_type_Asav);
    }
    localNewIntent.putExtra("data", paramGetAuthApiListRequest);
    localNewIntent.putExtra("cmd", str);
    this.ekF = 0;
    localNewIntent.setObserver(new arox(this, bool, str));
    if (this.ekH == 0) {
      ahlw.Kj("KEY_GET_AUTH_API_LIST_REQUEST");
    }
    super.getAppRuntime().startServlet(localNewIntent);
    this.jdField_b_of_type_Artv$a$a.timeCost = System.currentTimeMillis();
    this.jdField_b_of_type_Artv$a$a.clW = str;
    this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
    this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.ic, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + str + " | uin : *" + artw.qx(this.jdField_a_of_type_Asav.uin));
  }
  
  protected boolean ag(Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null) {
      localObject = paramIntent.getStringExtra("result_data");
    }
    try
    {
      localObject = HttpBaseUtil.D((String)localObject);
      asav localasav = new asav();
      localasav.uin = ((JSONObject)localObject).getString("uin");
      localasav.key = ((JSONObject)localObject).getString("skey");
      localasav.hr = paramIntent.getByteArrayExtra("st_temp");
      localasav.hs = paramIntent.getByteArrayExtra("st_temp_key");
      if ((localasav.uin != null) && (localasav.key != null)) {
        this.jdField_a_of_type_Asav = localasav;
      }
      if (this.jdField_a_of_type_Asav != null) {
        return true;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        ef(3005, paramIntent.getMessage());
      }
    }
    return false;
  }
  
  public void bFf()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "doAuthorize");
    }
    this.awf = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentCardContainer.gN();
    Object localObject3 = new Bundle(this.mParams);
    ((Bundle)localObject3).putString("openapi", "");
    ((Bundle)localObject3).putBoolean("doAuthorize", true);
    ((Bundle)localObject3).putString("need_pay", "1");
    ((Bundle)localObject3).putString("appid_for_getting_config", ((Bundle)localObject3).getString("client_id") + "");
    this.mProgress.setMessage(getResources().getString(2131696662));
    if ((!super.isFinishing()) && (!this.mProgress.isShowing())) {
      this.mProgress.show();
    }
    if (this.dcG) {
      arsg.a().c((Bundle)localObject3, true);
    }
    label355:
    do
    {
      return;
      long l = Long.parseLong(cBq);
      SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
      localAuthorizeRequest.client_id.set(l);
      localAuthorizeRequest.need_pay.set(1);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CardContainer.a)((Iterator)localObject1).next();
        if (((CardContainer.a)localObject2).flag > 0) {
          localAuthorizeRequest.openapi.add(Integer.valueOf(((CardContainer.a)localObject2).id));
        }
      }
      String str;
      if (Build.VERSION.RELEASE == null)
      {
        localObject1 = "";
        localAuthorizeRequest.os.set((String)localObject1);
        localAuthorizeRequest.qqv.set(aroi.a().getVersionName());
        localObject2 = ((Bundle)localObject3).getString("pf");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "openmobile_android";
        }
        localAuthorizeRequest.pf.set((String)localObject1);
        localObject1 = ((Bundle)localObject3).getString("sdkp");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label655;
        }
        localAuthorizeRequest.sdkp.set("android");
        localObject1 = ((Bundle)localObject3).getString("sdkv");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label668;
        }
        localAuthorizeRequest.sdkv.set("1.5.9");
        localAuthorizeRequest.response_type.set("token");
        localObject1 = artw.i(this);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label681;
        }
        localAuthorizeRequest.appUniqueIdentifier.set((String)localObject1);
        localObject2 = ((Bundle)localObject3).getString("sign");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label693;
        }
        localAuthorizeRequest.sign.set((String)localObject2);
        localObject1 = ((Bundle)localObject3).getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l = Long.parseLong((String)localObject1);
          localAuthorizeRequest.time.set(l);
        }
        localObject1 = ((Bundle)localObject3).keySet();
        ((Set)localObject1).remove("sdkp");
        ((Set)localObject1).remove("sign");
        ((Set)localObject1).remove("sdkv");
        ((Set)localObject1).remove("sign");
        ((Set)localObject1).remove("time");
        localObject2 = new StringBuffer();
        localObject4 = ((Set)localObject1).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label785;
        }
        str = (String)((Iterator)localObject4).next();
        localObject1 = ((Bundle)localObject3).get(str);
        if (localObject1 == null) {
          break label778;
        }
      }
      for (localObject1 = localObject1.toString();; localObject1 = "")
      {
        ((StringBuffer)localObject2).append(str + "=" + URLEncoder.encode((String)localObject1) + "&");
        break label560;
        localObject1 = Build.VERSION.RELEASE;
        break;
        localAuthorizeRequest.sdkp.set((String)localObject1);
        break label355;
        localAuthorizeRequest.sdkv.set((String)localObject1);
        break label384;
        QLog.d("AuthorityActivity", 1, "doAuthorize.appUniqueIdentifier is null");
        break label419;
        localObject2 = asbp.a(this, (String)localObject1);
        localObject1 = localObject2[1];
        localObject2 = localObject2[2];
        QLog.d("AuthorityActivity", 1, "doAuthorize.getAuthorizeSign again");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.d("AuthorityActivity", 1, "doAuthorize.getAuthorizeSign sign is null");
          break label480;
        }
        localAuthorizeRequest.sign.set((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label480;
        }
        l = Long.parseLong((String)localObject2);
        localAuthorizeRequest.time.set(l);
        break label480;
      }
      if (((StringBuffer)localObject2).length() > 0)
      {
        ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
        localAuthorizeRequest.passData.set(((StringBuffer)localObject2).toString());
      }
      localAuthorizeRequest.skey.set(this.jdField_a_of_type_Asav.key);
      artw.a(localAuthorizeRequest.url_encoded_data, true);
      this.ekF = 1;
      localObject3 = new NewIntent(this, aruh.class);
      ((NewIntent)localObject3).setWithouLogin(true);
      ((NewIntent)localObject3).putExtra("uin", this.jdField_a_of_type_Asav.uin);
      Object localObject4 = artw.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_Asav, localAuthorizeRequest.login_sig, "ConnAuthSvr.sdk_auth_api", "ConnAuthSvr.sdk_auth_api_emp");
      boolean bool = "ConnAuthSvr.sdk_auth_api_emp".equals(localObject4);
      Object localObject2 = localAuthorizeRequest.toByteArray();
      localObject1 = localObject2;
      if (bool) {
        localObject1 = asbp.a((byte[])localObject2, this.jdField_a_of_type_Asav);
      }
      ((NewIntent)localObject3).putExtra("data", (byte[])localObject1);
      ((NewIntent)localObject3).putExtra("cmd", (String)localObject4);
      ((NewIntent)localObject3).setObserver(new arpa(this, bool, (String)localObject4));
      if (this.ekI == 0) {
        ahlw.Kj("KEY_AUTHORIZE_REQUEST");
      }
      super.getAppRuntime().startServlet((NewIntent)localObject3);
      this.d.timeCost = System.currentTimeMillis();
      this.d.clW = ((String)localObject4);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.ic, 30000L);
      QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject4 + " | uin : *" + artw.qx(this.jdField_a_of_type_Asav.uin));
    } while (!QLog.isColorLevel());
    label384:
    label419:
    label480:
    QLog.d("SDKQQAgentPref", 2, "AuthorSwitch_AGENT:" + SystemClock.elapsedRealtime());
    label560:
    label693:
    return;
  }
  
  public void d(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->loginSuccess--userAccount = *" + artw.qx(paramString1));
    }
    if (!this.dcM) {
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
    }
    this.hA.setEnabled(true);
    paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    asav localasav = new asav();
    localasav.uin = paramString1;
    localasav.key = paramString2;
    if (paramBundle != null)
    {
      localasav.hr = paramBundle.getByteArray("st_temp");
      localasav.hs = paramBundle.getByteArray("st_temp_key");
    }
    this.jdField_a_of_type_Asav = localasav;
    this.aIE = paramString1;
    ahlw.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", this.jdField_a_of_type_Asav);
    ahlw.a("KEY_LOGIN_STAGE_1_TOTAL", paramString1, this.abu, null, true);
    if (this.ekJ == 1)
    {
      bFf();
      return;
    }
    ekT();
  }
  
  public void ddP()
  {
    if ((this.mTip != null) && (this.mAppName != null))
    {
      localObject = this.mAppName;
      if (this.mAppName.length() > 12) {
        localObject = this.mAppName.substring(0, 12) + "...";
      }
      this.mTip.setText(String.format(getResources().getString(2131696644), new Object[] { localObject }));
    }
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_Asav.uin, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_Asav.uin;
    }
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_a_of_type_Asav.uin, (String)localObject, null, false);
    SZ();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->doOnCreate--");
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    String str = Build.MANUFACTURER + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
    }
    if ((str != null) && ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C")))) {
      ImmersiveUtils.clearCoverForStatus(getWindow(), true);
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
      return;
      ImmersiveUtils.l(getActivity().getWindow());
    }
  }
  
  public void dt(String paramString, boolean paramBoolean)
  {
    if (artw.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString))
    {
      QLog.d("AuthorityActivity", 1, "changeAccountLogin IsNeedLoginWithPasswd | uin : *" + artw.qx(paramString));
      WO(paramString);
    }
    for (;;)
    {
      this.dcB = paramBoolean;
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
      QLog.d("AuthorityActivity", 1, "changeAccountLogin send | cmd: g_t_n_p | uin : *" + artw.qx(paramString));
      ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      asaw.a().a(paramString, this.jdField_c_of_type_MqqObserverSSOAccountObserver, cBq, 1);
      artw.l(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString);
    }
  }
  
  public void du(String paramString, boolean paramBoolean)
  {
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("qapp_login_" + paramString, 0).edit();
    paramString.putBoolean("qapp_login_flag", paramBoolean);
    paramString.commit();
  }
  
  @TargetApi(17)
  public void e(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (!isFinishing())
    {
      if (Build.VERSION.SDK_INT < 17) {
        break label54;
      }
      if (!isDestroyed()) {
        aqha.b(this, 230).setMessageWithUrl(paramString).setTitle(super.getString(2131719009)).setPositiveButton(17039370, paramOnClickListener).show();
      }
    }
    return;
    label54:
    aqha.b(this, 230).setMessageWithUrl(paramString).setTitle(super.getString(2131719009)).setPositiveButton(17039370, paramOnClickListener).show();
  }
  
  public void ef(int paramInt, String paramString)
  {
    Message localMessage = this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 6;
    localMessage.arg1 = 3004;
    localMessage.obj = paramString;
    this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  public void eg(int paramInt, String paramString)
  {
    jf();
    if (TextUtils.isEmpty(paramString)) {
      e(String.format(super.getString(2131696651), new Object[] { Integer.valueOf(paramInt) }), new arou(this));
    }
    this.hA.setEnabled(true);
    this.hA.setText(2131696659);
    this.hA.setTag(Integer.valueOf(2131696654));
    ei(paramInt, paramString);
  }
  
  public void eh(int paramInt, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ret", paramInt);
    localJSONObject.put("msg", paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = String.format(super.getString(2131696651), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131698727), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      e(paramString, new arov(this, paramInt, localJSONObject));
      return;
    }
  }
  
  public void ei(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", cBq);
    localHashMap.put("errorcode", paramInt + "");
    localHashMap.put("errormsg", paramString);
    paramString = AppNetConnInfo.getRecentNetworkInfo();
    if (paramString != null)
    {
      if (paramString.getType() != 1) {
        break label103;
      }
      localHashMap.put("network", "wifi");
    }
    for (;;)
    {
      anpc.a(this).collectPerformance(this.aIE, "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
      return;
      label103:
      if (paramString.getType() == 0) {
        switch (paramString.getSubtype())
        {
        case 7: 
        default: 
          localHashMap.put("network", "2G");
          break;
        case 1: 
        case 2: 
        case 4: 
          localHashMap.put("network", "2G");
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
          localHashMap.put("network", "3G");
        }
      }
    }
  }
  
  protected void ekN()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", cBq);
    if (this.dcE)
    {
      str = "notlogged";
      localHashMap.put("p1", str);
      if (!this.dcF) {
        break label87;
      }
    }
    label87:
    for (String str = "auth";; str = "uauth")
    {
      localHashMap.put("p2", str);
      anpc.a(this).collectPerformance(this.aIE, "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
      return;
      str = "logged";
      break;
    }
  }
  
  protected void ekQ()
  {
    if (!ag(null)) {
      ekR();
    }
  }
  
  protected void ekR()
  {
    QLog.d("AuthorityActivity", 1, "-->startAccountActivity--");
    if (!aryn.aHk())
    {
      Ud(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", cBq);
      localHashMap.put("p1", "notlogged");
      localHashMap.put("p2", "uauth");
      anpc.a(this).collectPerformance(this.aIE, "connect_sso_pageview", false, System.currentTimeMillis() - this.abu, 0L, localHashMap, "");
      return;
    }
    login();
  }
  
  protected void ekS()
  {
    QLog.d("AuthorityActivity", 1, "-->loginSSO--");
    this.mProgress.setMessage(super.getString(2131696662));
    if ((!super.isFinishing()) && (!this.mProgress.isShowing())) {}
    try
    {
      this.mProgress.show();
      if (this.aIE != null) {
        if (artw.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE))
        {
          WO(this.aIE);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "-->loginSSO(), mProgress.show();", localException);
        }
      }
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin :*" + artw.qx(this.aIE));
      ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      asaw.a().a(this.aIE, this.jdField_c_of_type_MqqObserverSSOAccountObserver, cBq, 1);
      this.jdField_a_of_type_Artv$a$a.timeCost = System.currentTimeMillis();
      WM("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE));
      return;
    }
    Ud(true);
    this.dcE = true;
    report("wtl_notlogged", "0");
  }
  
  public void ekT()
  {
    QLog.d("AuthorityActivity", 1, "-->queryAuthority");
    this.awi = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_Asav == null)
    {
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.ic, 30000L);
      return;
    }
    this.mParams = super.getIntent().getBundleExtra("key_params");
    SdkAuthorize.GetAuthApiListRequest localGetAuthApiListRequest = new SdkAuthorize.GetAuthApiListRequest();
    Object localObject = this.mParams.getString("client_id") + "";
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong((String)localObject);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label113:
      String str;
      break label113;
    }
    localGetAuthApiListRequest.client_id.set(l1);
    if (Build.VERSION.RELEASE == null)
    {
      localObject = "";
      localGetAuthApiListRequest.os.set((String)localObject);
      localGetAuthApiListRequest.qqv.set(aroi.a().getVersionName());
      localGetAuthApiListRequest.app_type.set(2);
      str = this.mParams.getString("pf");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localGetAuthApiListRequest.pf.set((String)localObject);
      str = this.mParams.getString("scope");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localGetAuthApiListRequest.scope.set((String)localObject);
      localObject = this.mParams.getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label457;
      }
      localGetAuthApiListRequest.sdkp.set("android");
      label266:
      if (this.dcG) {
        localGetAuthApiListRequest.referer.set(4);
      }
      localObject = this.mParams.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label470;
      }
      localGetAuthApiListRequest.sdkv.set("1.5.9");
    }
    for (;;)
    {
      localObject = this.mParams.getString("sign");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localGetAuthApiListRequest.sign.set((String)localObject);
        localObject = this.mParams.getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          l1 = Long.parseLong((String)localObject);
          localGetAuthApiListRequest.time.set(l1);
        }
      }
      localGetAuthApiListRequest.need_pay.set(1);
      if (this.jdField_a_of_type_Asav != null) {
        localGetAuthApiListRequest.skey.set(this.jdField_a_of_type_Asav.key);
      }
      localObject = artw.i(this);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localGetAuthApiListRequest.appUniqueIdentifier.set((String)localObject);
      }
      artw.a(localGetAuthApiListRequest.url_encoded_data, true);
      a(localGetAuthApiListRequest);
      return;
      localObject = Build.VERSION.RELEASE;
      break;
      label457:
      localGetAuthApiListRequest.sdkp.set((String)localObject);
      break label266;
      label470:
      localGetAuthApiListRequest.sdkv.set((String)localObject);
    }
  }
  
  public void ekU()
  {
    int i = getResources().getColor(2131166195);
    ColorStateList localColorStateList = getResources().getColorStateList(2131166195);
    if (this.mTitleView != null)
    {
      this.mTitleView.setTextColor(i);
      this.mTitleView.setText("");
    }
    if (this.GY != null) {
      this.GY.setTextColor(localColorStateList);
    }
  }
  
  public void iE(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      SharedPreferences.Editor localEditor = this.ae.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  protected void initViews()
  {
    this.mRoot = findViewById(2131377546);
    this.JO = findViewById(2131363832);
    this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView = ((MaxHeightScrollView)findViewById(2131364331));
    this.cBo = ((String)super.getText(2131696659));
    this.cBp = ((String)super.getText(2131696646));
    this.hA = ((Button)super.findViewById(2131372662));
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131364330));
    if (this.dcM) {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setTag(Boolean.valueOf(this.dcM));
    }
    ekP();
    this.mTitleView.setText(2131696643);
    if (this.dcM)
    {
      this.cBp = ((String)super.getText(2131696648));
      this.cBo = this.cBp;
      this.hA.setText(2131696659);
      this.hA.setTag(this.cBp);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131372365).setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setVisibility(4);
    }
    this.hA.setOnClickListener(this);
    this.hA.setEnabled(false);
    this.density = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new arow(this));
  }
  
  public void jf()
  {
    if ((!super.isFinishing()) && (this.mProgress != null) && (this.mProgress.isShowing())) {}
    try
    {
      this.mProgress.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void k(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    paramString3 = new Bundle();
    paramString3.putInt("error", paramInt);
    paramString3.putString("response", paramString1);
    paramString3.putString("msg", null);
    paramString3.putString("detail", null);
    paramString2.setData(paramString3);
    paramString2.what = 7;
    this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessageDelayed(paramString2, 1000L);
  }
  
  public void l(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ForwardUtils.a(paramInt, this.jdField_a_of_type_Asav);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->setSdkResult--error = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
    int i;
    if (paramInt != 110405)
    {
      i = paramInt;
      if (paramInt != 110513) {}
    }
    else
    {
      i = 0;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", i);
    localIntent.putExtra("key_error_msg", paramString2);
    localIntent.putExtra("key_error_detail", paramString3);
    localIntent.putExtra("key_response", paramString1);
    super.setResult(-1, localIntent);
    super.finish();
    if (!this.dcL) {
      jf();
    }
    if (i != 0)
    {
      paramString1 = new HashMap();
      paramString1.put("appid", cBq);
      paramString1.put("errorcode", i + "");
      paramString1.put("errormsg", paramString2);
      paramString1.put("errordetail", paramString3);
      paramString2 = AppNetConnInfo.getRecentNetworkInfo();
      if (paramString2 != null)
      {
        if (paramString2.getType() != 1) {
          break label367;
        }
        paramString1.put("network", "wifi");
      }
    }
    for (;;)
    {
      anpc.a(this).collectPerformance(this.aIE, "connect_sso_authfail", false, 0L, 0L, paramString1, "");
      paramString1 = "0";
      if (i != 0) {
        paramString1 = "1";
      }
      ForwardUtils.p(i, cBq, this.aIE);
      if (this.dcL) {}
      try
      {
        for (;;)
        {
          arts.a().a(this.aIE, "", cBq, "1", "9", paramString1, true, true);
          try
          {
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.aIE.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
              arts.a().a(this.aIE, "", cBq, "1", "10", paramString1, true, true);
            }
            return;
          }
          catch (Exception paramString1)
          {
            label367:
            paramString1.printStackTrace();
          }
          if (paramString2.getType() != 0) {
            break;
          }
          switch (paramString2.getSubtype())
          {
          case 7: 
          default: 
            paramString1.put("network", "2G");
            break;
          case 1: 
          case 2: 
          case 4: 
            paramString1.put("network", "2G");
            break;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
            paramString1.put("network", "3G");
            break;
            try
            {
              arts.a().a(this.aIE, "", cBq, "1", "6", "0", false, true);
            }
            catch (Exception paramString1)
            {
              paramString1.printStackTrace();
            }
          }
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
  }
  
  public void login()
  {
    QLog.d("AuthorityActivity", 1, "-->login--");
    this.awg = SystemClock.elapsedRealtime();
    this.hA.setEnabled(true);
    if (!aqiw.isNetworkAvailable(this))
    {
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.post(this.ic);
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
    {
      Ud(false);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin())
    {
      ekS();
      return;
    }
    if (this.cBr != null) {
      this.aIE = this.cBr;
    }
    if (!artw.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE))
    {
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin : *" + artw.qx(this.aIE));
      ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      asaw.a().a(this.aIE, this.jdField_c_of_type_MqqObserverSSOAccountObserver, cBq, 1);
      this.jdField_a_of_type_Artv$a$a.timeCost = System.currentTimeMillis();
      this.mProgress.setMessage(getResources().getString(2131696655));
      if ((!super.isFinishing()) && (!this.mProgress.isShowing())) {}
      try
      {
        this.mProgress.show();
        WM("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorityActivity", 2, "-->login(), mProgress.show();", localException);
          }
        }
      }
    }
    ekS();
  }
  
  public void mp(long paramLong)
  {
    Object localObject2 = new GetAppInfoProto.GetAppinfoRequest();
    this.ekF = 2;
    ((GetAppInfoProto.GetAppinfoRequest)localObject2).client_id.set(paramLong);
    Object localObject1 = this.mParams.getString("sdkp");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).sdkp.set("android");
      if (Build.VERSION.RELEASE != null) {
        break label385;
      }
    }
    label385:
    for (localObject1 = "";; localObject1 = Build.VERSION.RELEASE)
    {
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).os.set((String)localObject1);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).qqv.set(aroi.a().getVersionName());
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).app_type.set(2);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).setHasFlag(true);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).need_ads.set(1);
      localObject1 = artw.i(this);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((GetAppInfoProto.GetAppinfoRequest)localObject2).appUniqueIdentifier.set((String)localObject1);
      }
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).referer.set(1);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).skey.set(this.jdField_a_of_type_Asav.key);
      String str = artw.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_Asav, ((GetAppInfoProto.GetAppinfoRequest)localObject2).login_sig, "ConnAuthSvr.get_app_info", "ConnAuthSvr.get_app_info_emp");
      boolean bool = "ConnAuthSvr.get_app_info_emp".equals(str);
      NewIntent localNewIntent = new NewIntent(this, aruh.class);
      localNewIntent.setWithouLogin(true);
      localNewIntent.putExtra("uin", this.jdField_a_of_type_Asav.uin);
      localObject2 = ((GetAppInfoProto.GetAppinfoRequest)localObject2).toByteArray();
      localObject1 = localObject2;
      if (bool) {
        localObject1 = asbp.a((byte[])localObject2, this.jdField_a_of_type_Asav);
      }
      localNewIntent.putExtra("data", (byte[])localObject1);
      localNewIntent.putExtra("cmd", str);
      QLog.d("AuthorityActivity", 1, new Object[] { "getAppInfo cmd=", str });
      localNewIntent.setObserver(new aroz(this, bool));
      ahlw.Kj("KEY_GET_APP_INFO_REQUEST");
      super.getAppRuntime().startServlet(localNewIntent);
      this.jdField_c_of_type_Artv$a$a.timeCost = System.currentTimeMillis();
      this.jdField_c_of_type_Artv$a$a.clW = str;
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.ic, 30000L);
      return;
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).sdkp.set((String)localObject1);
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "--onActivityResult, requestCode: " + paramInt1 + " | resultCode:" + paramInt2 + " | data: " + paramIntent);
    }
    if (paramInt1 == 100) {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.cBr = paramIntent.getStringExtra("uin");
        }
        ekQ();
      }
    }
    for (;;)
    {
      return;
      super.setResult(0);
      super.finish();
      ekN();
      return;
      jf();
      if (paramInt2 == 0)
      {
        if (TextUtils.isEmpty(this.aIE))
        {
          super.setResult(0, paramIntent);
          super.finish();
          ekN();
        }
        this.awh = SystemClock.elapsedRealtime();
        arwt.d("Authority_TimeCost", "<TimeStamp> login cost : " + (this.awh - this.awg));
        return;
      }
      if (-1 != paramInt2) {
        continue;
      }
      this.awh = SystemClock.elapsedRealtime();
      arwt.d("Authority_TimeCost", "<TimeStamp> login cost : " + (this.awh - this.awg));
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      this.dcC = ag(paramIntent);
      try
      {
        mp(Long.parseLong(cBq));
        if (!dcA) {
          continue;
        }
        this.aIE = paramIntent.getStringExtra("last_account");
        boolean bool = paramIntent.getBooleanExtra("isLogin", false);
        Object localObject = new WloginSimpleInfo();
        if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
        {
          this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.aIE, (WloginSimpleInfo)localObject);
          this.aIE = Long.toString(((WloginSimpleInfo)localObject)._uin);
        }
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.xU(1);
        WM(this.aIE);
        if (bool)
        {
          WP(this.aIE);
          artw.l(getAppRuntime(), this.aIE);
        }
        localObject = paramIntent.getBundleExtra("ssobundle");
        if (localObject != null)
        {
          paramIntent = ((Bundle)localObject).getByteArray("st_temp");
          localObject = ((Bundle)localObject).getByteArray("st_temp_key");
          if ((paramIntent != null) && (localObject != null))
          {
            this.jdField_a_of_type_Asav.hr = paramIntent;
            this.jdField_a_of_type_Asav.hs = ((byte[])localObject);
          }
        }
        this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(5);
        this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(11);
        this.dcB = true;
        this.hA.setEnabled(false);
        this.dcJ = false;
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().XB(this.aIE);
        ekT();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          arwt.e("AuthorityActivity", "mAuthAppId " + cBq + " can not cast to long ");
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if ((this.dcD) && (this.jdField_a_of_type_Asav != null)) {}
    super.setResult(0);
    super.finish();
    ekN();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.GY)
    {
      super.setResult(0);
      super.finish();
      ekN();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.hA)
      {
        QLog.d("AuthorityActivity", 1, new Object[] { "<user:>authorize btn is clicked. mGetTicketFailed=", Boolean.valueOf(this.dcJ) });
        long l = System.currentTimeMillis();
        try
        {
          if (l - this.iu < 500L) {
            continue;
          }
          this.iu = l;
          if (!aqiw.isNetworkAvailable(this))
          {
            this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
            this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.post(this.ic);
            continue;
          }
        }
        finally {}
        this.hA.setEnabled(false);
        if ((this.dcJ) || (this.jdField_a_of_type_Asav == null))
        {
          login();
        }
        else if (this.ekF == 0)
        {
          this.mProgress.setMessage(super.getString(2131696655));
          if ((!super.isFinishing()) && (!this.mProgress.isShowing())) {
            this.mProgress.show();
          }
          ekT();
        }
        else if (this.hA.getTag().equals(super.getString(2131696654)))
        {
          login();
        }
        else
        {
          ahlw.a("KEY_LOGIN_STAGE_2_OLD_TOTAL", this.jdField_a_of_type_Asav);
          ahlw.Kj("KEY_LOGIN_STAGE_3_TOTAL");
          if (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SDKQQAgentPref", 2, "ClickAuthButton: " + SystemClock.elapsedRealtime());
            }
            Message localMessage = this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
            localMessage.what = 1;
            localMessage.obj = this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
            this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
            this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
          }
          for (;;)
          {
            arts.a().a(this.aIE, "", cBq, "1", "2", "0", false, true);
            break;
            if (QLog.isColorLevel()) {
              QLog.d("SDKQQAgentPref", 2, "ClickAuthButton -- doAuthorize(): " + SystemClock.elapsedRealtime());
            }
            bFf();
          }
        }
      }
      else
      {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131363101: 
          WO(this.aIE);
          if (this.jdField_a_of_type_ComTencentOpenAgentCardContainer != null) {
            this.jdField_a_of_type_ComTencentOpenAgentCardContainer.ekJ();
          }
          break;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onCreate--");
    }
    this.abu = System.currentTimeMillis();
    ahlw.Kj("KEY_LOGIN_STAGE_2_OLD_TOTAL");
    if (!(super.getAppRuntime() instanceof OpenSDKAppInterface)) {
      return;
    }
    super.setContentView(2131559871);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    this.mParams = super.getIntent().getBundleExtra("key_params");
    if (this.mParams == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityActivity", 2, "Params are null, finish activity");
      }
      l(-5, "params is null", "params is null", "params is null");
      return;
    }
    this.dcG = this.mParams.getBoolean("key_login_by_qr_scan", false);
    cBq = this.mParams.getString("client_id");
    this.dcM = super.getIntent().getBooleanExtra("internal_authority", false);
    this.dcL = getIntent().getBooleanExtra("authority_start_qq_login", false);
    QLog.d("AuthorityActivity", 1, new Object[] { "-->AuthorityActivity onCreateView mIsInternalAuthority=", Boolean.valueOf(this.dcM), ", mFromSdkLoginAuthority=", Boolean.valueOf(this.dcL) });
    String str2;
    String str1;
    if (this.dcM)
    {
      this.aIE = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
      str2 = System.currentTimeMillis() / 1000L + "";
      str1 = this.mParams.getString("package_name");
      paramBundle = this.mParams.getString("sign");
      str1 = str1 + "_" + paramBundle.replace(":", "").toLowerCase() + "_" + str2;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(str1.getBytes());
      str1 = aqhs.bytes2HexStr(localMessageDigest.digest());
      paramBundle = str1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localNoSuchAlgorithmException.printStackTrace();
        continue;
        if (isChild()) {}
        for (paramBundle = getParent();; paramBundle = this)
        {
          this.mProgress = new arhz(paramBundle, super.getTitleBarHeight());
          break;
        }
        label801:
        i = 0;
      }
      label806:
      if (Build.VERSION.SDK_INT < 17) {
        break label859;
      }
      int i = Settings.Global.getInt(getContentResolver(), "always_finish_activities", 0);
      if (TextUtils.isEmpty(this.aIE)) {
        break label859;
      }
      boolean bool = sm(this.aIE);
      if ((i != 1) || (!bool)) {
        break label859;
      }
      this.dcN = true;
      label859:
      if (!this.dcN) {
        break label988;
      }
    }
    this.mParams.putString("sign", paramBundle);
    this.mParams.putString("time", str2);
    asaw.a().emz();
    this.qg = aryn.eh();
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
      this.aIE = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
    }
    if ((this.aIE == null) && (this.qg != null)) {
      this.aIE = ((String)this.qg.get(0));
    }
    this.cBs = getIntent().getStringExtra("login_success_uin");
    if ((!TextUtils.isEmpty(this.cBs)) && (!this.cBs.equals(this.aIE))) {
      this.aIE = this.cBs;
    }
    initViews();
    this.mAppName = this.mParams.getString("oauth_app_name");
    this.cBt = this.mParams.getString("sdkv");
    this.ad = asbf.getGlobalPreference(this, "uin_openid_store");
    this.ae = asbf.getGlobalPreference(this, "openid_encrytoken");
    if (this.dcL)
    {
      this.mProgress = new arhz(this, 0, 2131561631, 17);
      this.mProgress.setHeightParams(-1);
      if (this.mAppName != null) {
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.F(this.mAppName, null);
      }
      if (Build.VERSION.SDK_INT <= 10) {
        break label801;
      }
      i = 4;
      this.ac = super.getSharedPreferences("accountList", i);
      paramBundle = super.getIntent().getStringExtra("key_action");
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      if ((!this.dcM) && (!"action_login".equals(paramBundle))) {
        break label930;
      }
      dcA = true;
      this.dcB = false;
      paramBundle = super.getAppRuntime().getAccount();
      if ((this.dcM) || (!GesturePWDUtils.getJumpLock(this, paramBundle)) || (GesturePWDUtils.getAppForground(this))) {
        break label806;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityActivity", 2, "-->onCreate--has gesture password, will start unlock activity");
      }
      this.cBr = paramBundle;
      paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
      paramBundle.putExtra("key_gesture_from_authority", true);
      super.startActivityForResult(paramBundle, 100);
    }
    if (!TextUtils.isEmpty(this.aIE)) {
      WM("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE));
    }
    this.hA.setEnabled(true);
    du(this.aIE, false);
    for (;;)
    {
      label930:
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.xU(1);
      arts.a().a(this.aIE, "", cBq, "1", "1", "0", false, true);
      if (this.dcL) {
        this.dcB = true;
      }
      if (!this.dcG) {
        break;
      }
      ekO();
      return;
      label988:
      ekQ();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jf();
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onDestroy--");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.abu = 0L;
  }
  
  public void onResume()
  {
    super.onResume();
    this.dcK = false;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onResume-- SDKQQAgentPref|FirstLaunch_AGENT:" + SystemClock.elapsedRealtime());
    }
    if (this.abu == 0L) {
      this.abu = System.currentTimeMillis();
    }
  }
  
  public void report(String paramString1, String paramString2)
  {
    anpc.a(BaseApplication.getContext()).b(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, cBq + "|" + paramString2 + "|" + this.cBt);
  }
  
  public boolean sm(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qapp_login_" + paramString, 0).getBoolean("qapp_login_flag", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity
 * JD-Core Version:    0.7.0.1
 */