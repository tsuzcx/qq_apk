package com.tencent.qqconnect.wtlogin;

import aelp;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import anpc;
import aqha;
import aqju;
import arhz;
import arod;
import artw;
import asru;
import asrv;
import asrw;
import asrx;
import asry;
import asrz;
import assa;
import assb;
import assc;
import assd;
import asse;
import assf;
import assg;
import assh;
import ausj;
import auss;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import java.util.HashMap;
import java.util.List;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class Login
  extends BaseActivity
{
  public static String cFK = "";
  public static String cFL = "";
  public static boolean dgu;
  public View Ar;
  TextWatcher B = new asse(this);
  TextWatcher C = new assf(this);
  protected List<WloginLoginInfo> Kb;
  public View Kj;
  public MqqHandler Q = new assg(this);
  protected WtloginManager a;
  private boolean aRb;
  private boolean ach;
  public TextView aeu;
  public TextView aev;
  public BroadcastReceiver at = new assh(this);
  public long awg;
  public long axH;
  public HandlerPlus b = new HandlerPlus(this.k);
  public EditText bG;
  public EditText bH;
  public int bIi = 1;
  private BroadcastReceiver bQ = new assa(this);
  public OpenSDKAppInterface c;
  protected SSOAccountObserver c;
  public boolean dgv = true;
  protected View.OnClickListener di = new asrw(this);
  View.OnFocusChangeListener f = new assc(this);
  public Button hF;
  boolean isClick = false;
  protected Handler.Callback k = new asrv(this);
  public TextView leftView;
  private ausj mActionSheet;
  private String mAppId;
  protected arhz mProgress;
  View.OnTouchListener onTouchListener = new assd(this);
  
  public Login()
  {
    this.jdField_c_of_type_MqqObserverSSOAccountObserver = new asru(this);
  }
  
  private Bundle B()
  {
    Bundle localBundle = new Bundle();
    if (aelp.ahj()) {
      localBundle.putInt("puzzle_verify_code", 130);
    }
    localBundle.putByteArray("connect_data", artw.ah(this.mAppId));
    return localBundle;
  }
  
  public static String cf(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("uin:'").append(paramString1).append("',");
    localStringBuilder.append("skey:'");
    if (paramString2 != null) {
      localStringBuilder.append(paramString2);
    }
    localStringBuilder.append("'}");
    return localStringBuilder.toString();
  }
  
  private void je(String paramString1, String paramString2)
  {
    QLog.d("Login", 1, new Object[] { "ssoLogin | cmd: s_s_o_l | uin : *", artw.qx(paramString1) });
    this.jdField_c_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin(paramString1, paramString2, 4096, this.jdField_c_of_type_MqqObserverSSOAccountObserver, B());
  }
  
  public void Qq()
  {
    if (this.mActionSheet == null)
    {
      this.mActionSheet = ((ausj)auss.a(this, null));
      this.mActionSheet.addButton(2131693739);
      this.mActionSheet.addButton(2131720366);
      this.mActionSheet.addCancelButton(2131721058);
      this.mActionSheet.setOnDismissListener(new asry(this));
      this.mActionSheet.a(new asrz(this));
    }
    if (!this.mActionSheet.isShowing())
    {
      this.ach = false;
      this.mActionSheet.show();
    }
  }
  
  public void doLogin()
  {
    boolean bool = false;
    if ("".equals(this.bG.getText().toString().trim()))
    {
      showDialog(String.format(getResources().getString(2131698727), new Object[] { getResources().getString(2131696496), Integer.valueOf(3103) }));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("error", "3103");
      anpc.a(this).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject1, "");
      return;
    }
    if ("".equals(this.bH.getText().toString().trim()))
    {
      showDialog(String.format(getResources().getString(2131698727), new Object[] { getResources().getString(2131696732), Integer.valueOf(3104) }));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("error", "3104");
      anpc.a(this).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject1, "");
      return;
    }
    Object localObject1 = this.bG.getText().toString();
    Object localObject2 = this.bH.getText().toString();
    this.axH = (((String)localObject1).length() + ((String)localObject2).length());
    if (QLog.isColorLevel()) {
      QLog.d("Login", 2, "-->doLogin--account = *" + artw.qx((String)localObject1) + "mReqSrc = " + this.bIi);
    }
    if ((this.bIi == 2) || (this.bIi == 3))
    {
      if (this.bIi == 2) {
        bool = artw.b(this.a, (String)localObject1);
      }
      while (bool) {
        if (this.dgv)
        {
          QLog.d("Q.quicklogin.Login", 1, "has aone");
          e((String)localObject1, null, null);
          return;
          if (!artw.a(this.a, (String)localObject1)) {
            bool = true;
          }
        }
        else
        {
          je((String)localObject1, (String)localObject2);
          elC();
          return;
        }
      }
      je((String)localObject1, (String)localObject2);
      elC();
      return;
    }
    if (artw.a(this.a, (String)localObject1)) {
      je((String)localObject1, (String)localObject2);
    }
    for (;;)
    {
      elC();
      return;
      if (this.dgv)
      {
        QLog.d("Login", 1, "send | cmd: g_t_n_p | uin : *" + artw.qx((String)localObject1));
        localObject2 = B();
        ((Bundle)localObject2).putLong("dwSrcAppid", 1600001540L);
        ((Bundle)localObject2).putLong("dwDstAppid", 1600001540L);
        this.jdField_c_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd((String)localObject1, 4096, this.jdField_c_of_type_MqqObserverSSOAccountObserver, (Bundle)localObject2);
      }
      else
      {
        je((String)localObject1, (String)localObject2);
      }
    }
  }
  
  public void e(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.Login", 2, "-->loginSucess--mReqSrc = " + this.bIi + ", userAccount = *" + artw.qx(paramString1));
    }
    arod.a().WE(paramString1);
    if ((this.bIi == 2) || (this.bIi == 3))
    {
      paramString2 = "" + this.jdField_c_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a, paramString1);
      paramString1 = new Intent();
      paramString1.putExtra("last_account", paramString2);
      paramString1.putExtra("isLogin", true);
      if (paramBundle != null)
      {
        paramString2 = paramBundle.getByteArray("st_temp");
        localObject1 = paramBundle.getByteArray("st_temp_key");
        paramString1.putExtra("st_temp", paramString2);
        paramString1.putExtra("st_temp_key", (byte[])localObject1);
      }
      paramString1.putExtra("ssobundle", paramBundle);
      setResult(-1, paramString1);
      finish();
      return;
    }
    Object localObject2 = new WloginSimpleInfo();
    this.a.GetBasicUserInfo(paramString1, (WloginSimpleInfo)localObject2);
    String str = "" + ((WloginSimpleInfo)localObject2)._uin;
    Object localObject1 = new Intent();
    localObject2 = new String(((WloginSimpleInfo)localObject2)._nick);
    if (paramString2 != null) {}
    for (paramString1 = new String(paramString2);; paramString1 = null)
    {
      ((Intent)localObject1).putExtra("result_data", cf(str, paramString1));
      ((Intent)localObject1).putExtra("last_account", str);
      ((Intent)localObject1).putExtra("isLogin", true);
      ((Intent)localObject1).putExtra("nick", (String)localObject2);
      if (paramBundle != null)
      {
        paramString1 = paramBundle.getByteArray("st_temp");
        paramString2 = paramBundle.getByteArray("st_temp_key");
        ((Intent)localObject1).putExtra("st_temp", paramString1);
        ((Intent)localObject1).putExtra("st_temp_key", paramString2);
      }
      setResult(-1, (Intent)localObject1);
      break;
    }
  }
  
  public void elC()
  {
    QLog.d("Login", 1, "showLoginTip");
    this.mProgress.setMessage(getResources().getString(2131696662));
    if (!this.mProgress.isShowing()) {
      this.mProgress.show();
    }
  }
  
  public void elD()
  {
    QLog.d("Login", 1, "hideLoginTip");
    if (this.mProgress == null) {}
    while (!this.mProgress.isShowing()) {
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
  
  protected void init()
  {
    this.jdField_c_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.a = ((WtloginManager)this.jdField_c_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    this.Kb = this.a.GetAllLoginInfo();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Login", 2, "-->onActivityResult--reqCode = " + paramInt1 + ", resCode = " + paramInt2);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100) {
      if (paramInt2 == -1) {
        if (paramIntent != null) {}
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          Message localMessage = new Message();
          paramIntent = paramIntent.getExtras();
          localMessage.what = 6;
          localMessage.setData(paramIntent);
          this.Q.sendMessage(localMessage);
          return;
        } while (paramInt2 != 0);
        elD();
        return;
      } while (paramInt1 != 10000);
      if (paramInt2 == -1)
      {
        e(paramIntent.getStringExtra("last_account"), paramIntent.getStringExtra("wtTicket"), paramIntent.getBundleExtra("ssobundle"));
        return;
      }
    } while (paramInt2 != 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.d("Login", 1, "onCreate");
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    getWindow().addFlags(1024);
    this.awg = SystemClock.elapsedRealtime();
    if (getIntent().getExtras() != null) {
      this.bIi = getIntent().getExtras().getInt("key_req_src", 1);
    }
    this.mAppId = getIntent().getStringExtra("appid");
    QLog.d("Q.quicklogin.Login", 1, "oncreate mReqSrc:" + this.bIi + ", mAppId=" + this.mAppId);
    setContentView(2131563107);
    this.leftView = ((TextView)findViewById(2131364121));
    if (getIntent().getBooleanExtra("is_first_login", false))
    {
      setTitle(2131696645);
      this.leftView.setText(2131691039);
    }
    for (;;)
    {
      this.leftView.setOnClickListener(this.di);
      this.Ar = findViewById(2131365716);
      this.Kj = findViewById(2131365688);
      this.aeu = ((TextView)findViewById(2131381054));
      this.aev = ((TextView)findViewById(2131381228));
      this.aev.setOnClickListener(this.di);
      this.Ar.setOnClickListener(this.di);
      this.Kj.setOnClickListener(this.di);
      this.aeu.setOnClickListener(this.di);
      this.bG = ((EditText)findViewById(2131361874));
      this.bH = ((EditText)findViewById(2131372885));
      this.hF = ((Button)findViewById(2131372662));
      this.hF.setOnClickListener(this.di);
      this.mProgress = new arhz(this, getTitleBarHeight());
      findViewById(2131367359).requestFocus();
      this.bG.setOnFocusChangeListener(this.f);
      this.bG.setOnTouchListener(this.onTouchListener);
      this.bH.setOnTouchListener(this.onTouchListener);
      this.bH.setOnFocusChangeListener(this.f);
      this.bH.setOnEditorActionListener(new assb(this));
      this.bG.addTextChangedListener(this.B);
      this.bH.addTextChangedListener(this.C);
      init();
      this.jdField_c_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.setHandler(Login.class, this.Q);
      if (this.at != null)
      {
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
        registerReceiver(this.at, paramBundle);
      }
      registerReceiver(this.bQ, new IntentFilter("mqq.opensdk.intent.action.PUZZLEVERIFYCODE"));
      return;
      setTitle(2131696667);
    }
  }
  
  public void onDestroy()
  {
    QLog.d("Login", 1, "onDestroy");
    super.onDestroy();
    elD();
    this.bG.removeTextChangedListener(this.B);
    this.bH.removeTextChangedListener(this.C);
    this.jdField_c_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.removeHandler(Login.class);
    if (this.at != null) {
      unregisterReceiver(this.at);
    }
    unregisterReceiver(this.bQ);
  }
  
  public void onResume()
  {
    super.onResume();
    if (dgu == true)
    {
      dgu = false;
      this.bG.setText(cFK);
      this.bH.setText(cFL);
    }
    if (this.aRb)
    {
      QLog.d("Login", 1, "mShouldAutoLogin: true, then login");
      this.aRb = false;
      if (this.hF != null) {
        this.hF.performClick();
      }
    }
  }
  
  public void showDialog(String paramString)
  {
    if (!isFinishing()) {
      aqha.b(this, 230).setMessageWithUrl(paramString).setTitle(getString(2131719009)).setPositiveButton(17039370, new asrx(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login
 * JD-Core Version:    0.7.0.1
 */