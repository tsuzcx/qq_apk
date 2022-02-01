package com.tencent.open.agent;

import acfp;
import ahkr;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import anot;
import aprb.a;
import aprc;
import apuh;
import aqju;
import arhz;
import aroi;
import arpu;
import arpv;
import arpw;
import arpx;
import artp;
import artp.a;
import aruh;
import arwt;
import arxh;
import arxh.a;
import arxo;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import swe;

public class BindGroupConfirmActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, View.OnClickListener, artp.a, arxh.a
{
  protected TextView Bi;
  protected TextView GS;
  protected ImageView Gd;
  private final arxh.a a = new arpu(this);
  public aqju aH;
  String aMm;
  String aMn;
  String aMo;
  String aMp;
  String aMq;
  protected Button aX;
  protected TextView acH;
  protected String cBw;
  public String cBx;
  protected String cBy;
  public swe e;
  aprb.a g = new arpx(this);
  protected String groupName;
  public Runnable ic = new BindGroupConfirmActivity.5(this);
  public Resources j;
  public ImageView mAppIcon;
  public String mAppId;
  protected TextView mAppName;
  String mGameName;
  public final Handler mHandler = new arpv(this);
  protected Bundle mParams;
  protected String mPkgName;
  public arhz mProgress;
  protected TextView mRightBtn;
  protected TextView mTitleView;
  protected TextView zt;
  
  private void initUI()
  {
    Object localObject = findViewById(2131377565);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows((View)localObject, true);
    }
    this.Bi = ((TextView)super.findViewById(2131369579));
    this.GS = ((TextView)super.findViewById(2131369581));
    this.mRightBtn = ((TextView)super.findViewById(2131369612));
    this.mTitleView = ((TextView)super.findViewById(2131369627));
    this.aX = ((Button)super.findViewById(2131365223));
    this.aX.setOnClickListener(this);
    this.acH = ((TextView)super.findViewById(2131379063));
    this.Gd = ((ImageView)super.findViewById(2131380296));
    if (!TextUtils.isEmpty(this.cBw))
    {
      localObject = artp.a().Q(this.cBw);
      if (localObject != null) {
        this.Gd.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      this.zt = ((TextView)super.findViewById(2131380362));
      if (!TextUtils.isEmpty(this.groupName)) {
        break label270;
      }
      this.zt.setText("QQ群");
    }
    for (;;)
    {
      this.mAppIcon = ((ImageView)super.findViewById(2131362847));
      ThreadManager.executeOnSubThread(new BindGroupConfirmActivity.3(this));
      this.mAppName = ((TextView)super.findViewById(2131362859));
      this.mAppName.setText(this.cBy);
      if (!TextUtils.isEmpty(this.mAppId)) {
        mp(Long.valueOf(this.mAppId).longValue());
      }
      return;
      artp.a().a(this.cBw, this);
      break;
      label270:
      this.zt.setText(this.groupName);
    }
  }
  
  private void uV(String paramString)
  {
    getActivity().runOnUiThread(new BindGroupConfirmActivity.8(this, paramString));
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    arwt.d("BindGroupConfirmActivity", "-->onImageLoaded() url = " + paramString1);
    this.mHandler.post(new BindGroupConfirmActivity.4(this, paramBitmap));
  }
  
  public void ai(JSONObject paramJSONObject)
  {
    StringBuffer localStringBuffer;
    try
    {
      if (paramJSONObject.getInt("ret") != 0) {
        break label226;
      }
      paramJSONObject = paramJSONObject.getJSONArray("list");
      int k = paramJSONObject.length();
      localStringBuffer = new StringBuffer();
      int i = 0;
      for (;;)
      {
        if (i >= k) {
          break label208;
        }
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          if (!localJSONObject.getString("id").equals("0")) {
            localStringBuffer.append(localJSONObject.getString("id") + "、");
          }
          localStringBuffer.append(localJSONObject.getString("desc") + "\n");
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!" + localJSONException.getMessage());
            }
          }
        }
        i += 1;
      }
      while (localStringBuffer.length() == 0) {}
    }
    catch (Exception paramJSONObject)
    {
      if (this.acH != null) {
        this.acH.setText(this.j.getString(2131690865));
      }
      onException(paramJSONObject);
      return;
    }
    label208:
    this.acH.setText(localStringBuffer);
    return;
    label226:
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!");
    }
    if (this.acH != null) {
      this.acH.setText(this.j.getString(2131690865));
    }
    QQToast.a(this, paramJSONObject.getString("msg"), 0).create(getTitleBarHeight()).show();
  }
  
  public void ela()
  {
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi");
    Object localObject1 = this.app.getCurrentAccountUin();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("o");
    if (((String)localObject1).length() < 10)
    {
      int i = 0;
      while (i < 10 - ((String)localObject1).length())
      {
        ((StringBuilder)localObject2).append("0");
        i += 1;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (;;)
    {
      TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
      localBundle.putString("Cookie", "uin=" + localObject2 + "; skey=" + localTicketManager.getSkey((String)localObject1));
      localBundle.putString("Host", "info.gamecenter.qq.com");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("appid", this.mAppId);
      ((Bundle)localObject1).putString("guild_id", this.aMn);
      ((Bundle)localObject1).putString("zone_id", this.aMo);
      ((Bundle)localObject1).putString("guild_name", this.mGameName);
      ((Bundle)localObject1).putString("gc", this.aMq);
      ((Bundle)localObject1).putString("platid", "2");
      ((Bundle)localObject1).putString("roleid", this.aMp);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("module", "gc_bind_group_svr");
      ((Bundle)localObject2).putString("method", "bind_existing_group");
      localObject1 = apuh.a((Bundle)localObject1, (Bundle)localObject2);
      localBundle.putString("param", (String)localObject1);
      localBundle.putString("signature", apuh.encrypt((String)localObject1 + "ea779693bfa42c986ad85cda9bdfce45").toUpperCase());
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("BUNDLE", localBundle);
      ((HashMap)localObject1).put("CONTEXT", getApplicationContext());
      if (QLog.isColorLevel()) {
        QLog.i("BindGroupConfirmActivity", 2, "bindGroup params = " + localBundle);
      }
      new aprc(localStringBuilder.toString(), "GET", this.g, 0, null).J((HashMap)localObject1);
      return;
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
  }
  
  public void f(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupConfirmActivity", 2, "HttpAsyncTaskCallback exception." + paramException.getMessage());
    }
    if ((paramException instanceof ConnectTimeoutException)) {
      paramException = arxo.cCU;
    }
    for (;;)
    {
      QQToast.a(this, paramException, 0).create(getTitleBarHeight()).show();
      return;
      if ((paramException instanceof SocketTimeoutException)) {
        paramException = arxo.cCV;
      } else if ((paramException instanceof MalformedURLException)) {
        paramException = "访问url有误!";
      } else if ((paramException instanceof HttpBaseUtil.HttpStatusException)) {
        paramException = "Http返回码异常!";
      } else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException)) {
        paramException = arxo.cCW;
      } else if ((paramException instanceof JSONException)) {
        paramException = arxo.cCS;
      } else if ((paramException instanceof IOException)) {
        paramException = arxo.cCR;
      } else {
        paramException = arxo.cCT;
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772000, 2130772001);
  }
  
  protected void mp(long paramLong)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong);
    localGetAppinfoRequest.sdkp.set("android");
    if (Build.VERSION.RELEASE == null) {}
    for (Object localObject = "";; localObject = Build.VERSION.RELEASE)
    {
      localGetAppinfoRequest.os.set((String)localObject);
      localGetAppinfoRequest.qqv.set(aroi.a().getVersionName());
      localGetAppinfoRequest.setHasFlag(true);
      if (!TextUtils.isEmpty(this.mPkgName)) {
        localGetAppinfoRequest.appUniqueIdentifier.set(this.mPkgName);
      }
      localGetAppinfoRequest.referer.set(6);
      localObject = new NewIntent(this, aruh.class);
      ((NewIntent)localObject).setWithouLogin(true);
      ((NewIntent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
      ((NewIntent)localObject).putExtra("data", localGetAppinfoRequest.toByteArray());
      ((NewIntent)localObject).putExtra("cmd", "ConnAuthSvr.get_app_info");
      ((NewIntent)localObject).setObserver(new arpw(this));
      super.getAppRuntime().startServlet((NewIntent)localObject);
      this.mHandler.removeCallbacks(this.ic);
      this.mHandler.postDelayed(this.ic, 30000L);
      return;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.e == paramDialogInterface) {
      if (paramInt != 0) {}
    }
    while (this.aH != paramDialogInterface)
    {
      do
      {
        try
        {
          ahkr.a(this, true, "action_game_bind_group", Long.valueOf(this.mAppId).longValue(), 0, "");
          super.setResult(-1);
          super.finish();
          return;
        }
        catch (Exception paramDialogInterface)
        {
          for (;;)
          {
            QLog.e("BindGroupConfirmActivity", 1, "showAlertDlg error = " + paramDialogInterface);
          }
        }
      } while (paramInt != 1);
      paramDialogInterface = new Intent(this, SplashActivity.class);
      paramDialogInterface.addFlags(67108864);
      paramDialogInterface.addFlags(268435456);
      super.startActivity(paramDialogInterface);
      super.finish();
      return;
    }
    paramDialogInterface.dismiss();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131365223: 
        if ("true".equals(this.aMm))
        {
          ela();
        }
        else
        {
          new arxh("https://fusionbase.qq.com/cgi-bin/appstage/mb_bind_qqgroup", "POST", this.a, true).dL(this.mParams);
          this.mProgress.show();
        }
        break;
      case 2131369579: 
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
    super.setTheme(2131755343);
    super.setContentView(2131560151);
    this.j = super.getResources();
    this.mProgress = new arhz(this, getTitleBarHeight());
    this.mProgress.setMessage(acfp.m(2131703204));
    this.mParams = super.getIntent().getBundleExtra("key_params");
    if (this.mParams == null)
    {
      arwt.e("BindGroupConfirmActivity", "initParams() mParams is null!");
      return;
    }
    this.cBy = this.mParams.getString("union_name");
    this.cBx = this.mParams.getString("app_name");
    this.groupName = this.mParams.getString("group_name");
    this.cBw = this.mParams.getString("group_avatar_url");
    this.mPkgName = this.mParams.getString("pkg_name");
    this.mAppId = this.mParams.getString("appid");
    this.aMm = this.mParams.getString("is_from_game");
    if ("true".equals(this.aMm))
    {
      this.aMn = this.mParams.getString("unionid");
      this.aMo = this.mParams.getString("zoneid");
      this.aMp = this.mParams.getString("role_id");
      this.aMq = this.mParams.getString("group_code");
      this.mGameName = this.cBy;
      if (QLog.isColorLevel()) {
        QLog.d("BindGroupConfirmActivity", 2, "bindGroup appid =  guild id = " + this.aMn + "zone_id = " + this.aMo + " role id = " + this.aMp + "  group code= " + this.aMq + " guild name = " + this.mGameName);
      }
      anot.a(this.app, "CliOper", "", "", "0x80084B0", "0x80084B0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      new arxh("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_qqgroup_description", "POST", this, true).dL(this.mParams);
      initUI();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BindGroupConfirmActivity", 2, " bindGroup is from game = false");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BindGroupActivity.isBack = true;
  }
  
  public void onException(Exception paramException)
  {
    f(paramException);
  }
  
  public void onStart()
  {
    super.onStart();
    this.Bi.setVisibility(0);
    this.Bi.setText(this.j.getString(2131691769));
    this.Bi.setOnClickListener(this);
    this.GS.setVisibility(4);
    this.mRightBtn.setVisibility(4);
    this.mTitleView.setText(this.j.getString(2131690861));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity
 * JD-Core Version:    0.7.0.1
 */