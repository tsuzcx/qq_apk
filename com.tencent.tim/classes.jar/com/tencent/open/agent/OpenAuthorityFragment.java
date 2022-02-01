package com.tencent.open.agent;

import ahgf;
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
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import anot;
import anpc;
import aqha;
import aqhs;
import aqiw;
import aqju;
import arhz;
import aroe;
import arre;
import arrf;
import arrg;
import arrh;
import arri;
import arrj;
import arrk;
import arrl;
import arrm;
import arrn;
import arrp;
import arrq;
import arsg;
import artd;
import arts;
import artv.a.a;
import artw;
import arwt;
import arxc;
import arxi.a;
import aryn;
import asav;
import asaw;
import asbf;
import asbh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.util.HandlerPlus;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenAuthorityFragment
  extends PublicBaseFragment
  implements View.OnClickListener, arxi.a
{
  private TextView GY;
  private artv.a.a jdField_a_of_type_Artv$a$a = new artv.a.a();
  private asav jdField_a_of_type_Asav;
  private asbh jdField_a_of_type_Asbh;
  public OpenCardContainer.b a;
  private OpenCardContainer jdField_a_of_type_ComTencentOpenAgentOpenCardContainer;
  private SdkAuthorize.AuthorizeResponse jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
  private preAuth.PreAuthResponse jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthResponse;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager;
  private String aIE;
  private long abu;
  private SharedPreferences ac;
  private TextView acS;
  private SharedPreferences ad;
  private SharedPreferences ae;
  private long awf;
  private long awg;
  private long awh;
  private long awi;
  private long awj;
  private long awk;
  private long awl;
  private long awm;
  private long awo;
  public artd b;
  public HandlerPlus b;
  public SSOAccountObserver c = new arre(this);
  private String cBO;
  private String cBo;
  private String cBp;
  private String cBq;
  private String cBr;
  protected String cBt = "";
  private final int dXy = 1000;
  private boolean dcB;
  private boolean dcE;
  private boolean dcF;
  private boolean dcG;
  private boolean dcH;
  private boolean dcJ;
  private boolean dcL;
  private boolean dcM;
  private boolean dcN;
  private boolean dcS;
  private boolean dcT;
  private float density;
  private int ekF;
  private int ekG;
  private int ekJ = -1;
  private int ekO;
  private Button hA;
  public Runnable ic = new OpenAuthorityFragment.6(this);
  private long iu;
  protected Handler.Callback k = new arrq(this);
  private Bundle mParams;
  private arhz mProgress;
  private TextView mTitleView;
  private List<String> qg;
  
  public OpenAuthorityFragment()
  {
    this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.k);
    this.jdField_b_of_type_Artd = new arrh(this);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$b = new arrk(this);
  }
  
  private String Dd()
  {
    return this.cBq;
  }
  
  private String De()
  {
    return this.cBO;
  }
  
  private String Df()
  {
    if (TextUtils.isEmpty(this.cBO)) {
      return this.cBq;
    }
    return this.cBO;
  }
  
  private boolean ME()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
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
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->getbitmap exception, url=", paramString, localIOException });
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->getbitmap decodeStream oom, url = " + paramString);
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void Zl(int paramInt)
  {
    Object localObject = Df();
    localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a((String)localObject);
    this.jdField_a_of_type_Asbh.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, ((asav)localObject).uin, Df(), 3, new arri(this, paramInt));
  }
  
  private boolean aGZ()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity != null) && (!localFragmentActivity.isFinishing());
  }
  
  private boolean bx(int paramInt1, int paramInt2)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "handle110509 mIn110537Retry=", Boolean.valueOf(this.dcT), ", errorCode=", Integer.valueOf(paramInt1), ", triggerReason=", Integer.valueOf(paramInt2), "mAccount=", this.jdField_a_of_type_Asav });
    if ((paramInt1 != 110509) || (this.jdField_a_of_type_Asav == null)) {
      return false;
    }
    if (this.dcT)
    {
      this.dcT = false;
      WO(this.jdField_a_of_type_Asav.uin);
      return true;
    }
    this.dcT = true;
    Zl(paramInt2);
    return true;
  }
  
  private void dZ(Intent paramIntent)
  {
    boolean bool = false;
    if (paramIntent == null) {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updateAccount");
    }
    for (;;)
    {
      return;
      Object localObject = paramIntent.getStringExtra("result_data");
      try
      {
        JSONObject localJSONObject = HttpBaseUtil.D((String)localObject);
        localObject = new asav();
        ((asav)localObject).uin = localJSONObject.getString("uin");
        ((asav)localObject).key = localJSONObject.getString("skey");
        ((asav)localObject).hr = paramIntent.getByteArrayExtra("st_temp");
        ((asav)localObject).hs = paramIntent.getByteArrayExtra("st_temp_key");
        paramIntent = artw.qx(((asav)localObject).uin);
        if (((asav)localObject).key != null) {
          bool = true;
        }
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "uin", paramIntent, "key valid=", Boolean.valueOf(bool) });
        if ((((asav)localObject).uin != null) && (((asav)localObject).key != null))
        {
          this.jdField_a_of_type_Asav = ((asav)localObject);
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "JSONException", paramIntent);
        ef(3005, paramIntent.getMessage());
      }
    }
  }
  
  private void dv(String paramString, boolean paramBoolean)
  {
    if (isInvalid())
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "showToast activity is null");
      return;
    }
    getActivity().runOnUiThread(new OpenAuthorityFragment.16(this, paramBoolean, paramString));
  }
  
  private void eg(int paramInt, String paramString)
  {
    jf();
    if (TextUtils.isEmpty(paramString)) {
      e(String.format(super.getString(2131696651), new Object[] { Integer.valueOf(paramInt) }), new arrf(this));
    }
    this.hA.setEnabled(true);
    this.hA.setTag(getString(2131696654));
    ei(paramInt, paramString);
  }
  
  private void eh(int paramInt, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ret", paramInt);
    localJSONObject.put("msg", paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = String.format(super.getString(2131696651), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131698727), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      e(paramString, new arrg(this, paramInt, localJSONObject));
      return;
    }
  }
  
  private void ei(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", Df());
    localHashMap.put("errorcode", paramInt + "");
    localHashMap.put("errormsg", paramString);
    paramString = AppNetConnInfo.getRecentNetworkInfo();
    if (paramString != null)
    {
      if (paramString.getType() != 1) {
        break label106;
      }
      localHashMap.put("network", "wifi");
    }
    for (;;)
    {
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.aIE, "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
      return;
      label106:
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
  
  private void ekP()
  {
    ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131379866)).abu(0);
    this.mTitleView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131369627));
    this.GY = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131369612));
    this.GY.setText(2131721058);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131369579).setOnClickListener(this);
    this.GY.setOnClickListener(this);
  }
  
  private void elj()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->queryAuthorityUseCache");
    this.awi = SystemClock.elapsedRealtime();
    if (getActivity() == null)
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "queryAuthorityUseCache activity is null");
      return;
    }
    if (this.jdField_a_of_type_Asav == null)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "queryAuthorityUseCache mAccount is null");
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.ic, 30000L);
      return;
    }
    this.mParams = getActivity().getIntent().getBundleExtra("key_params");
    preAuth.PreAuthResponse localPreAuthResponse = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Df());
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->queryAuthorityUseCache use cache preAuth.PreAuthResponse");
    if (localPreAuthResponse == null)
    {
      this.dcS = false;
      this.dcT = false;
      elk();
      return;
    }
    Message localMessage = this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 0;
    localMessage.obj = localPreAuthResponse;
    this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  private void elk()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updatePreAuthFromServer--");
    if (!aGZ())
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer for activity is finished");
      return;
    }
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updatePreAuthFromServer isNetworkAvailable false--");
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.post(this.ic);
      return;
    }
    if (this.jdField_a_of_type_Asav == null)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updatePreAuthFromServer mAccount == null");
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.ic, 30000L);
      return;
    }
    this.mParams = getActivity().getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    }
    if ((this.jdField_a_of_type_Asav.hr == null) || (this.jdField_a_of_type_Asav.hr.length == 0))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->updatePreAuthFromServer mAccount.st == null || mAccount.st.length == 0");
      Message localMessage = this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      localMessage.what = 6;
      localMessage.arg1 = 3000;
      localMessage.obj = getResources().getString(2131696654);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
      return;
    }
    this.ekF = 2;
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Dd(), Df(), getActivity(), artw.i(getActivity()), this.mParams, new arrp(this));
  }
  
  private void ell()
  {
    if (!aGZ())
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "getAppInfo return for activity is finished");
      return;
    }
    this.ekF = 2;
    ahgf localahgf = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Df());
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "getAppInfo use cached appid=", Df(), ", appInfo=", localahgf.toString() });
    Message localMessage = this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 3;
    localMessage.obj = localahgf;
    this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  private List<CardContainer.a> gO()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().bl(Df());
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CardContainer.a locala1 = (CardContainer.a)((Iterator)localObject).next();
        CardContainer.a locala2 = new CardContainer.a();
        locala2.api = locala1.api;
        locala2.flag = locala1.flag;
        locala2.id = locala1.id;
        locala2.isNew = locala1.isNew;
        locala2.title = locala1.title;
        locala2.isChecked = true;
        localArrayList.add(locala2);
      }
    }
    return localArrayList;
  }
  
  private boolean isInvalid()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity == null) || (localFragmentActivity.isFinishing());
  }
  
  private boolean u(int paramInt, boolean paramBoolean)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "handle110537 mIn110537Retry=", Boolean.valueOf(this.dcS), ", errorCode=", Integer.valueOf(paramInt), ", isGetVirtualList=", Boolean.valueOf(paramBoolean), "mAccount=", this.jdField_a_of_type_Asav });
    if ((paramInt != 110537) || (this.jdField_a_of_type_Asav == null)) {
      return false;
    }
    aroe.WG(this.jdField_a_of_type_Asav.uin);
    if ((this.dcS) || (artw.a(this.jdField_a_of_type_Asav.uin, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, false) == null))
    {
      this.dcS = false;
      WO(this.jdField_a_of_type_Asav.uin);
      return true;
    }
    if (paramBoolean)
    {
      this.dcS = true;
      eln();
      return true;
    }
    this.dcS = true;
    elk();
    return true;
  }
  
  public void E(String paramString, Bitmap paramBitmap)
  {
    arwt.d("SDK_LOGIN.OpenAuthorityFragment", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_Asav != null) && (paramString.equals(this.jdField_a_of_type_Asav.uin)))
    {
      if (getActivity() != null) {
        break label73;
      }
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "onTaskCompleted activity is null");
    }
    label73:
    while (paramBitmap == null) {
      return;
    }
    getActivity().runOnUiThread(new OpenAuthorityFragment.9(this, paramBitmap));
  }
  
  protected void SZ()
  {
    arxc.a().a(getActivity(), this.jdField_a_of_type_Asav.uin, this.jdField_a_of_type_Asav.key, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ri(this.jdField_a_of_type_Asav.uin), this);
  }
  
  protected void Ud(boolean paramBoolean)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->changeAccountActivity--isFirstLogin = " + paramBoolean);
    int i = 0;
    if (this.qg != null) {
      i = this.qg.size();
    }
    Intent localIntent2;
    Intent localIntent1;
    if (i > 1)
    {
      localIntent2 = new Intent(getActivity(), SwitchAccountActivity.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent2.putExtra("third_app_id", Df());
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
      localIntent2 = new Intent(getActivity(), Login.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent2.putExtra("appid", Df());
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
      localObject2 = artw.a(getActivity(), paramString, 63, 63);
      paramString.recycle();
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(this.aIE, (String)localObject1, (Bitmap)localObject2, false);
      return;
    }
    ThreadManager.executeOnSubThread(new OpenAuthorityFragment.2(this, (String)localObject1));
  }
  
  public void WN(String paramString)
  {
    if ((TextUtils.isEmpty(Df())) || (TextUtils.isEmpty(this.jdField_a_of_type_Asav.uin)))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "updateUinOpenIDStore realAppId=", Df(), ", mAccount.uin=", this.jdField_a_of_type_Asav.uin });
      return;
    }
    SharedPreferences.Editor localEditor = this.ad.edit();
    localEditor.putString(paramString, this.jdField_a_of_type_Asav.uin);
    localEditor.putString(Df() + ":" + this.jdField_a_of_type_Asav.uin, paramString);
    localEditor.commit();
  }
  
  public void WO(String paramString)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->showLoginActivity--uin = *" + artw.qx(this.aIE));
    if (getActivity() != null)
    {
      Intent localIntent = new Intent(getActivity(), Login.class);
      if (paramString != null) {
        localIntent.putExtra("param_uin", paramString);
      }
      localIntent.putExtra("appid", Df());
      super.startActivityForResult(localIntent, 1);
      return;
    }
    QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "showLoginActivity activity is null");
  }
  
  protected void WP(String paramString)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->LocalAccountCache--userAccount = *" + artw.qx(paramString));
    SharedPreferences.Editor localEditor = this.ac.edit();
    localEditor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    Object localObject1 = this.ac.getString("accList", null);
    if (localObject1 != null) {}
    for (localObject1 = ((String)localObject1).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject1[i];
          if (!TextUtils.isEmpty(localCharSequence)) {
            ((ArrayList)localObject2).add(localCharSequence);
          }
          i += 1;
        }
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
  
  protected void cG(View paramView)
  {
    this.cBo = ((String)super.getText(2131696659));
    this.cBp = ((String)super.getText(2131696646));
    this.hA = ((Button)paramView.findViewById(2131372662));
    this.acS = ((TextView)paramView.findViewById(2131364418));
    this.acS.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer = ((OpenCardContainer)paramView.findViewById(2131364330));
    if (this.dcM) {
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setTag(Boolean.valueOf(this.dcM));
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOnUpdateStatusBarListener(new arrl(this));
    ekP();
    if (this.dcM)
    {
      this.cBp = ((String)super.getText(2131696648));
      this.cBo = this.cBp;
      this.hA.setTag(this.cBp);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131372365).setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setVisibility(4);
    }
    this.hA.setOnClickListener(this);
    this.hA.setEnabled(false);
    this.density = super.getResources().getDisplayMetrics().density;
    paramView = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Df());
    if (paramView != null)
    {
      Object localObject = paramView.list;
      long l = paramView.awU;
      if (localObject != null)
      {
        paramView = new LinkedList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          VirtualInfo localVirtualInfo = (VirtualInfo)((Iterator)localObject).next();
          OpenCardContainer.f localf = new OpenCardContainer.f(localVirtualInfo.awT, localVirtualInfo.nickName, localVirtualInfo.avatarUrl);
          if (localVirtualInfo.awT == l) {
            localf.dcU = true;
          }
          paramView.add(localf);
        }
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e.setData(paramView, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
      }
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setCreateVirtualListner(new arrm(this));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOndeleteVirtualListener(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$b);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOnAccountEventListener(new arrn(this));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setCurrentAppid(Df());
    if (this.dcG) {
      this.acS.setVisibility(4);
    }
  }
  
  public void d(String paramString1, String paramString2, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->loginSuccess--userAccount = *", artw.qx(paramString1) });
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
    ahlw.a("KEY_LOGIN_STAGE_1_TOTAL", paramString1, this.abu, null, true);
    ahlw.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", this.jdField_a_of_type_Asav);
    paramString1 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Df());
    if ((paramString1 == null) || (!paramString1.uin.equals(localasav.uin))) {
      if (paramString1 != null) {
        break label328;
      }
    }
    label328:
    for (paramString1 = "null";; paramString1 = artw.qx(paramString1.uin))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "--loginSuccess, changeAccount old uin=", paramString1, ", new uin=", artw.qx(localasav.uin) });
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().b(Df(), this.jdField_a_of_type_Asav);
      elm();
      if (this.ekJ != 1) {
        break;
      }
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "loginSuccess============= mSKeyErrorStep == AUTHORIZE_DONE");
      this.jdField_a_of_type_Asbh.a(this.dcG, Dd(), De(), new ArrayList(), this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.ia(), this.jdField_b_of_type_Artd, artw.i(getActivity()), getActivity());
      return;
    }
    elj();
  }
  
  public void ddP()
  {
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_Asav.uin, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_Asav.uin;
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(this.jdField_a_of_type_Asav.uin, (String)localObject, null, false);
    SZ();
  }
  
  public void dt(String paramString, boolean paramBoolean)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "changeAccountLogin account=", artw.qx(paramString), ", canAutoLogin=", Boolean.valueOf(paramBoolean) });
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.post(this.ic);
      return;
    }
    if (artw.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString)) {
      WO(paramString);
    }
    for (;;)
    {
      this.dcB = paramBoolean;
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin : *" + artw.qx(paramString));
      ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      asaw.a().a(paramString, this.c, Df(), 1);
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
    if (!getActivity().isFinishing())
    {
      if (Build.VERSION.SDK_INT < 17) {
        break label63;
      }
      if (!getActivity().isDestroyed()) {
        aqha.b(getActivity(), 230).setMessageWithUrl(paramString).setTitle(super.getString(2131719009)).setPositiveButton(17039370, paramOnClickListener).show();
      }
    }
    return;
    label63:
    aqha.b(getActivity(), 230).setMessageWithUrl(paramString).setTitle(super.getString(2131719009)).setPositiveButton(17039370, paramOnClickListener).show();
  }
  
  public void ef(int paramInt, String paramString)
  {
    Message localMessage = this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    localMessage.what = 6;
    localMessage.arg1 = 3004;
    localMessage.obj = paramString;
    this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
  }
  
  protected void ekN()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", Df());
    if (this.dcE)
    {
      str = "notlogged";
      localHashMap.put("p1", str);
      if (!this.dcF) {
        break label90;
      }
    }
    label90:
    for (String str = "auth";; str = "uauth")
    {
      localHashMap.put("p2", str);
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.aIE, "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
      return;
      str = "logged";
      break;
    }
  }
  
  protected void ekQ()
  {
    if (this.jdField_a_of_type_Asav == null) {
      ekR();
    }
  }
  
  protected void ekR()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->startAccountActivity--");
    if (!aryn.aHk())
    {
      Ud(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", Df());
      localHashMap.put("p1", "notlogged");
      localHashMap.put("p2", "uauth");
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.aIE, "connect_sso_pageview", false, System.currentTimeMillis() - this.abu, 0L, localHashMap, "");
      return;
    }
    login();
  }
  
  protected void ekS()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->loginSSO--");
    this.mProgress.setMessage(super.getString(2131696662));
    if ((!getActivity().isFinishing()) && (!this.mProgress.isShowing())) {}
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
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->loginSSO(), mProgress.show();", localException);
      }
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin :*" + artw.qx(this.aIE));
      ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      asaw.a().a(this.aIE, this.c, Df(), 1);
      this.jdField_a_of_type_Artv$a$a.timeCost = System.currentTimeMillis();
      WM("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE));
      return;
    }
    Ud(true);
    this.dcE = true;
    report("wtl_notlogged", "0");
  }
  
  public void ekU()
  {
    if (getActivity() != null)
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
      return;
    }
    QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updateTitleColor activity is null");
  }
  
  public void elm()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->getVirtualList");
    this.dcS = false;
    this.dcT = false;
    eln();
  }
  
  public void eln()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->getVirtualListFromServer");
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->getVirtualList isNetworkAvailable false");
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
      this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.post(this.ic);
      return;
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(Dd(), Df(), getActivity(), artw.i(getActivity()), this.mParams, new arrj(this));
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
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void jf()
  {
    if (getActivity() == null) {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, " dismissDialogProgress activity is null");
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
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 2, "-->setSdkResult--error = " + paramInt);
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
    if (getActivity() != null)
    {
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
    }
    if (!this.dcL) {
      jf();
    }
    if (i != 0)
    {
      paramString1 = new HashMap();
      paramString1.put("appid", Df());
      paramString1.put("errorcode", i + "");
      paramString1.put("errormsg", paramString2);
      paramString1.put("errordetail", paramString3);
      paramString2 = AppNetConnInfo.getRecentNetworkInfo();
      if (paramString2 != null)
      {
        if (paramString2.getType() == 1) {
          paramString1.put("network", "wifi");
        }
      }
      else
      {
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.aIE, "connect_sso_authfail", false, 0L, 0L, paramString1, "");
        label272:
        if (i != 0) {
          break label512;
        }
      }
    }
    label512:
    for (paramString1 = "0";; paramString1 = "1")
    {
      ForwardUtils.p(i, Df(), this.aIE);
      if (this.dcL) {
        artw.a(this.aIE, "", Df(), "1", "9", paramString1, true);
      }
      if ((this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface != null) && (this.aIE != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.aIE.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
        artw.a(this.aIE, "", Df(), "1", "10", paramString1, true);
      }
      return;
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
        artw.a(this.aIE, "", Df(), "1", "6", "0", false);
        break label272;
      }
    }
  }
  
  public void login()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->login--");
    this.awg = SystemClock.elapsedRealtime();
    this.hA.setEnabled(true);
    if (!aqiw.isNetworkAvailable(getActivity()))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "login isNetworkAvailable false");
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
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "send | cmd: g_t_n_p | uin : *" + artw.qx(this.aIE));
      ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      asaw.a().a(this.aIE, this.c, Df(), 1);
      this.jdField_a_of_type_Artv$a$a.timeCost = System.currentTimeMillis();
      this.mProgress.setMessage(getResources().getString(2131696655));
      if ((!getActivity().isFinishing()) && (!this.mProgress.isShowing())) {}
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
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->login(), mProgress.show();", localException);
        }
      }
    }
    ekS();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onActivityCreated--");
    super.onActivityCreated(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "--onActivityResult, requestCode: " + paramInt1 + " | resultCode:" + paramInt2 + " | data: " + paramIntent);
    if ((paramInt1 == 101) && (paramIntent != null))
    {
      paramInt1 = paramIntent.getIntExtra("createVirtualAccount", 0);
      if (paramInt1 == 1)
      {
        this.awo = paramIntent.getLongExtra("createVirtualVid", 0L);
        elm();
      }
    }
    label201:
    label498:
    label500:
    do
    {
      do
      {
        break label201;
        break label201;
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "--onActivityResult, CreateVirtualAccount code = " + this.aIE);
        do
        {
          for (;;)
          {
            jf();
            if (paramInt2 != 0) {
              break label558;
            }
            if (TextUtils.isEmpty(this.aIE))
            {
              if (getActivity() != null)
              {
                getActivity().setResult(0, paramIntent);
                getActivity().finish();
              }
              ekN();
            }
            this.awh = SystemClock.elapsedRealtime();
            QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "<TimeStamp> login cost : " + (this.awh - this.awg));
            return;
            if (paramInt1 != 2) {
              break;
            }
            WO(this.aIE);
            break;
            if ((paramInt1 != 102) || (paramIntent == null)) {
              break label500;
            }
            paramInt1 = paramIntent.getIntExtra("key_cancel_auth", 0);
            int i = paramIntent.getIntExtra("key_error_code", 0);
            if (paramIntent.getIntExtra("key_need_login", 0) == 1)
            {
              QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "OpenVirtual.onActivityResult  REQUEST_CODE_SELECT_PERMISSION needLogin ");
              WO(this.aIE);
              return;
            }
            if (paramInt1 == 1) {
              if (getActivity() != null) {
                getActivity().setResult(0);
              }
            }
            for (;;)
            {
              if (getActivity() == null) {
                break label498;
              }
              getActivity().finish();
              break;
              if ((i == 0) && (this.dcG))
              {
                arsg.a().c(this.mParams, true);
              }
              else
              {
                localObject = paramIntent.getStringExtra("key_error_msg");
                String str1 = paramIntent.getStringExtra("key_error_detail");
                String str2 = paramIntent.getStringExtra("key_response");
                QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "OpenVirtual.onActivityResult, error: ", Integer.valueOf(i), ", msg:", localObject, ", detail:", str1, ", response=", str2 });
                Intent localIntent = new Intent();
                localIntent.putExtra("key_error_code", i);
                localIntent.putExtra("key_error_msg", (String)localObject);
                localIntent.putExtra("key_error_detail", str1);
                localIntent.putExtra("key_response", str2);
                if (getActivity() != null) {
                  getActivity().setResult(-1, localIntent);
                }
              }
            }
          }
        } while (paramInt1 != 100);
        if (paramInt2 == -1)
        {
          if (paramIntent != null) {
            this.cBr = paramIntent.getStringExtra("uin");
          }
          ekQ();
          return;
        }
        if (getActivity() != null)
        {
          getActivity().setResult(0);
          getActivity().finish();
        }
        ekN();
        return;
      } while (-1 != paramInt2);
      this.awh = SystemClock.elapsedRealtime();
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "<TimeStamp> login cost : " + (this.awh - this.awg));
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      dZ(paramIntent);
    } while (paramIntent == null);
    label558:
    this.aIE = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
    {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.aIE, (WloginSimpleInfo)localObject);
      this.aIE = Long.toString(((WloginSimpleInfo)localObject)._uin);
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.xU(1);
    WM(this.aIE);
    if (bool)
    {
      WP(this.aIE);
      artw.l(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.aIE);
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
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e.setData(null, this.aIE);
    this.jdField_a_of_type_Asbh.b(Df(), this.jdField_a_of_type_Asav);
    this.dcS = false;
    this.dcT = false;
    if ((bool) || (this.dcJ))
    {
      this.dcJ = false;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "hasQQD2=", Boolean.valueOf(artw.a(this.aIE, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface)) });
      this.jdField_a_of_type_Asbh.XB(this.aIE);
    }
    elk();
  }
  
  public void onBackPressed()
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onBackPressed");
    getActivity().setResult(0);
    getActivity().finish();
    if (getActivity() != null)
    {
      getActivity().setResult(0);
      getActivity().finish();
    }
    ekN();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.GY)
    {
      if (getActivity() != null)
      {
        getActivity().setResult(0);
        getActivity().finish();
      }
      ekN();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.hA)
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "<user:>authorize btn is clicked");
        long l = System.currentTimeMillis();
        try
        {
          if (l - this.iu < 500L)
          {
            QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick btn repeat click");
            continue;
          }
        }
        finally {}
        this.iu = l;
        if (!aqiw.isNetworkAvailable(getActivity()))
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick isNetworkAvailable false");
          this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.ic);
          this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.post(this.ic);
        }
        else if ((this.dcJ) || (this.jdField_a_of_type_Asav == null))
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick mGetTicketFailed || mAccount == null");
          login();
        }
        else if (this.ekF == 0)
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick mSsoRequest == 0");
          this.mProgress.setMessage(super.getString(2131696655));
          if ((!getActivity().isFinishing()) && (!this.mProgress.isShowing())) {
            this.mProgress.show();
          }
          elj();
        }
        else if (this.hA.getTag().equals(super.getString(2131696654)))
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick get auth_api_list again");
          login();
        }
        else
        {
          ahlw.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL", this.jdField_a_of_type_Asav);
          Object localObject2;
          if (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
          {
            ahlw.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", this.jdField_a_of_type_Asav);
            ahlw.Kj("KEY_LOGIN_STAGE_3_TOTAL");
            QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick null != mAuthResponse");
            localObject2 = this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
            ((Message)localObject2).what = 1;
            ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
            this.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
            this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
            arts.a().a(this.aIE, "", Df(), "1", "2", "0", false, true);
          }
          else
          {
            int j = 0;
            localObject2 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().bl(Df());
            Object localObject3 = new ArrayList();
            int i = j;
            if (localObject2 != null)
            {
              i = j;
              if (!((List)localObject2).isEmpty())
              {
                localObject2 = ((List)localObject2).iterator();
                i = 0;
                while (((Iterator)localObject2).hasNext())
                {
                  CardContainer.a locala1 = (CardContainer.a)((Iterator)localObject2).next();
                  CardContainer.a locala2 = new CardContainer.a();
                  locala2.api = locala1.api;
                  locala2.flag = locala1.flag;
                  if ((locala2.flag == 2) || (locala2.flag == 3)) {
                    i = 1;
                  }
                  locala2.id = locala1.id;
                  locala2.isNew = locala1.isNew;
                  locala2.title = locala1.title;
                  locala2.isChecked = true;
                  ((List)localObject3).add(locala2);
                }
              }
            }
            this.jdField_a_of_type_Asbh.b(Df(), this.jdField_a_of_type_Asav);
            this.jdField_a_of_type_Asbh.K(Df(), this.mParams);
            if (i != 0)
            {
              QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick to OpenSelectPermissionFragment");
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("appId", Dd());
              ((Intent)localObject2).putExtra("key_proxy_appid", De());
              ((Intent)localObject2).putExtra("vid", this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.ia());
              ((Intent)localObject2).putExtra("appName", this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthResponse.app_name.get());
              ((Intent)localObject2).putExtra("hasIcon", this.dcH);
              ((Intent)localObject2).putExtra("login_cost", this.awh - this.awg);
              if (this.awk != 0L) {}
              for (l = this.awk;; l = SystemClock.elapsedRealtime())
              {
                ((Intent)localObject2).putExtra("authStartTime", l);
                ((Intent)localObject2).putExtra("authListCostTime", this.awj - this.awi);
                ((Intent)localObject2).putExtra("is_from_qr_login", this.dcG);
                ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
                localObject3 = artw.i(getActivity());
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  ((Intent)localObject2).putExtra("pkg_name", (String)localObject3);
                }
                ahlw.Kj("KEY_LOGIN_STAGE_2_2_NEW_TOTAL");
                PublicFragmentActivity.b.startForResult(getActivity(), (Intent)localObject2, PublicFragmentActivityForOpenSDK.class, OpenSelectPermissionFragment.class, 102);
                break;
              }
            }
            QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick doAuthorize");
            if (this.dcG)
            {
              i = 2;
              label863:
              l = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.ia();
              if (l != 0L) {
                break label982;
              }
            }
            label982:
            for (localObject2 = "0X800A117";; localObject2 = "0X800A116")
            {
              anot.a(null, "dc00898", "", "", (String)localObject2, (String)localObject2, i, 0, "", "", "", "");
              ahlw.Kj("KEY_AUTHORIZE_REQUEST");
              ahlw.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", this.jdField_a_of_type_Asav);
              ahlw.Kj("KEY_LOGIN_STAGE_3_TOTAL");
              this.ekO = 0;
              this.jdField_a_of_type_Asbh.a(this.dcG, Dd(), De(), (List)localObject3, l, this.jdField_b_of_type_Artd, artw.i(getActivity()), getActivity());
              break;
              i = 1;
              break label863;
            }
          }
        }
      }
      else if (paramView == this.acS)
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onClick showAccountSheet");
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.eli();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559872, paramViewGroup, false);
    this.abu = System.currentTimeMillis();
    ahlw.Kj("KEY_LOGIN_STAGE_2_NEW_TOTAL");
    ahlw.Kj("KEY_LOGIN_STAGE_2_1_NEW_TOTAL");
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onCreateView");
    if (!(getActivity().getAppRuntime() instanceof OpenSDKAppInterface)) {}
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
      return paramViewGroup;
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getActivity().getAppRuntime());
      this.mParams = getActivity().getIntent().getBundleExtra("key_params");
      String str;
      if (this.mParams == null)
      {
        l(-5, "params is null", "params is null", "params is null");
      }
      else
      {
        this.jdField_a_of_type_Asbh = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
        this.dcG = this.mParams.getBoolean("key_login_by_qr_scan", false);
        this.cBq = this.mParams.getString("client_id");
        this.cBO = this.mParams.getString("key_proxy_appid");
        this.dcM = getActivity().getIntent().getBooleanExtra("internal_authority", false);
        this.dcL = getActivity().getIntent().getBooleanExtra("authority_start_qq_login", false);
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onCreateView mIsInternalAuthority=", Boolean.valueOf(this.dcM), ", mFromSdkLoginAuthority=", Boolean.valueOf(this.dcL), ", mAuthAppId=", this.cBq, ", mProxyAuthAppId=", this.cBO });
        if (this.dcM)
        {
          this.aIE = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
          str = System.currentTimeMillis() / 1000L + "";
          paramBundle = this.mParams.getString("package_name");
          paramLayoutInflater = this.mParams.getString("sign");
          paramBundle = paramBundle + "_" + paramLayoutInflater.replace(":", "").toLowerCase() + "_" + str;
        }
      }
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramBundle.getBytes());
        paramBundle = aqhs.bytes2HexStr(localMessageDigest.digest());
        paramLayoutInflater = paramBundle;
      }
      catch (NoSuchAlgorithmException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          if (getActivity().isChild()) {}
          for (paramLayoutInflater = getActivity().getParent();; paramLayoutInflater = getActivity())
          {
            this.mProgress = new arhz(paramLayoutInflater, getActivity().getTitleBarHeight());
            break;
          }
          i = 0;
        }
        if (Build.VERSION.SDK_INT < 17) {
          break label940;
        }
        i = Settings.Global.getInt(getActivity().getContentResolver(), "always_finish_activities", 0);
        if (TextUtils.isEmpty(this.aIE)) {
          break label940;
        }
        boolean bool = sm(this.aIE);
        if ((i != 1) || (!bool)) {
          break label940;
        }
        this.dcN = true;
        if (!this.dcN) {
          break label1102;
        }
      }
      this.mParams.putString("sign", paramLayoutInflater);
      this.mParams.putString("time", str);
      asaw.a().emz();
      this.qg = aryn.eh();
      if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
        this.aIE = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
      }
      if ((this.aIE == null) && (this.qg != null)) {
        this.aIE = ((String)this.qg.get(0));
      }
      paramLayoutInflater = getActivity().getIntent().getStringExtra("login_success_uin");
      if ((!TextUtils.isEmpty(paramLayoutInflater)) && (!paramLayoutInflater.equals(this.aIE))) {
        this.aIE = paramLayoutInflater;
      }
      cG(paramViewGroup);
      paramBundle = this.mParams.getString("oauth_app_name");
      this.cBt = this.mParams.getString("sdkv");
      this.ad = asbf.getGlobalPreference(BaseApplicationImpl.getApplication(), "uin_openid_store");
      this.ae = asbf.getGlobalPreference(BaseApplicationImpl.getApplication(), "openid_encrytoken");
      if (!this.dcL) {
        break;
      }
      this.mProgress = new arhz(getActivity(), 0, 2131561631, 17);
      this.mProgress.setHeightParams(-1);
      if (paramBundle != null) {
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.F(paramBundle, null);
      }
      paramLayoutInflater = getActivity();
      if (Build.VERSION.SDK_INT <= 10) {
        break label874;
      }
      i = 4;
      this.ac = paramLayoutInflater.getSharedPreferences("accountList", i);
      paramLayoutInflater = getActivity().getIntent().getStringExtra("key_action");
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      if ((!this.dcM) && (!"action_login".equals(paramLayoutInflater))) {
        break label1011;
      }
      this.dcB = false;
      paramLayoutInflater = getActivity().getAppRuntime().getAccount();
      if ((this.dcM) || (!GesturePWDUtils.getJumpLock(BaseApplicationImpl.getApplication(), paramLayoutInflater)) || (GesturePWDUtils.getAppForground(BaseApplicationImpl.getApplication()))) {
        break label880;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 2, "-->onCreate--has gesture password, will start unlock activity");
      }
      this.cBr = paramLayoutInflater;
      paramLayoutInflater = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      paramLayoutInflater.putExtra("key_gesture_from_authority", true);
      super.startActivityForResult(paramLayoutInflater, 100);
    }
    label874:
    label880:
    if (!TextUtils.isEmpty(this.aIE)) {
      WM("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE));
    }
    label940:
    this.hA.setEnabled(true);
    du(this.aIE, false);
    label1011:
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.xU(1);
    artw.a(this.aIE, "", Df(), "1", "1", "0", false);
    if (this.dcG) {}
    for (int i = 2;; i = 1)
    {
      anot.a(null, "dc00898", "", "", "0X800A115", "0X800A115", i, 0, "", "", "", "");
      if (this.dcL)
      {
        this.dcB = true;
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.ekI();
      }
      break;
      label1102:
      ekQ();
      break label1011;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jf();
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onDestroy--");
  }
  
  public void onPause()
  {
    super.onPause();
    this.abu = 0L;
  }
  
  public void onResume()
  {
    super.onResume();
    ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void report(String paramString1, String paramString2)
  {
    anpc.a(BaseApplication.getContext()).b(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, Df() + "|" + paramString2 + "|" + this.cBt);
  }
  
  public boolean sm(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qapp_login_" + paramString, 0).getBoolean("qapp_login_flag", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment
 * JD-Core Version:    0.7.0.1
 */