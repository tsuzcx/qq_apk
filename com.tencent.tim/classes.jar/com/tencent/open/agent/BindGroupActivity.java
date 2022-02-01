package com.tencent.open.agent;

import acfp;
import aeie;
import aemk;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import apbc;
import aprb.a;
import apuh;
import aqha;
import aqju;
import arhz;
import arpq;
import arpr;
import artj;
import artp;
import artp.a;
import arxh;
import arxh.a;
import arxo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import jqk;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BindGroupActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, View.OnClickListener, artp.a, arxh.a, AdapterView.c
{
  public static boolean isBack;
  protected TextView Bi;
  protected TextView GS;
  protected View JQ;
  protected View JR;
  protected boolean Tq;
  public arhz a;
  protected b a;
  protected jqk a;
  public boolean aRg;
  protected TextView acF;
  public Handler bJ;
  public String cBu;
  protected String cBv;
  aprb.a f = new arpr(this);
  protected SlideDetectListView h;
  protected Resources j;
  protected String mAppId;
  protected String mAppName;
  protected LayoutInflater mLayoutInflater;
  public String mOpenId;
  protected Bundle mParams;
  protected arhz mProgress;
  protected TextView mRightBtn;
  protected TextView mTitleView;
  protected List<a> nP;
  public aqju x;
  
  public BindGroupActivity()
  {
    this.jdField_a_of_type_Jqk = new arpq(this);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onImageLoaded() url = " + paramString1);
    }
    runOnUiThread(new BindGroupActivity.1(this, paramString1, paramBitmap));
  }
  
  public void ai(JSONObject paramJSONObject)
  {
    if ((this.mProgress != null) && (this.mProgress.isShowing())) {
      this.mProgress.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onResult, result: " + paramJSONObject);
    }
    try
    {
      if (paramJSONObject.getInt("ret") != 0) {
        break label266;
      }
      paramJSONObject = paramJSONObject.getJSONArray("list");
      int k = paramJSONObject.length();
      this.nP.clear();
      int i = 0;
      for (;;)
      {
        if (i < k)
        {
          a locala = new a();
          try
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            locala.uin = localJSONObject.getString("group_code");
            locala.label = localJSONObject.getString("name");
            locala.avatarUrl = (localJSONObject.getString("face") + "640");
            this.nP.add(locala);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("BindGroupActivity", 2, "The JSONObject has error!" + localJSONException.getMessage());
              }
            }
          }
        }
      }
      if (this.nP.size() <= 0) {
        break label248;
      }
    }
    catch (Exception paramJSONObject)
    {
      onException(paramJSONObject);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$b.notifyDataSetChanged();
    return;
    label248:
    this.JQ.setVisibility(8);
    this.JR.setVisibility(0);
    return;
    label266:
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "The JSONObject has error!");
    }
    QQToast.a(this, paramJSONObject.getString("msg"), 0).create(super.getTitleBarHeight()).show();
  }
  
  protected void bFE()
  {
    if (this.jdField_a_of_type_Arhz == null)
    {
      this.jdField_a_of_type_Arhz = new arhz(this, super.getTitleBarHeight());
      this.jdField_a_of_type_Arhz.setMessage(acfp.m(2131703202));
    }
    OpenID localOpenID = this.app.a().a(this.mAppId);
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID))) {
      this.cBu = localOpenID.openID;
    }
    this.mParams.putString("uin", this.app.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->checkAccountDiff, mOpenid: " + this.mOpenId);
    }
    if (!TextUtils.isEmpty(this.mOpenId))
    {
      if ((localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)))
      {
        this.jdField_a_of_type_Arhz.setMessage(2131694339);
        this.jdField_a_of_type_Arhz.show();
        this.bJ = new Handler();
        this.bJ.postDelayed(new BindGroupActivity.3(this), 3000L);
        this.app.addObserver(this.jdField_a_of_type_Jqk);
        this.app.a().Eo(this.mAppId);
        return;
      }
      if (!this.mOpenId.equals(localOpenID.openID))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BindGroupActivity", 2, "-->checkAccountDiff, !mOpenId.equals(openId.openID)");
        }
        bFG();
        return;
      }
      this.Tq = true;
      return;
    }
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
    {
      this.cBu = localOpenID.openID;
      this.mParams.putString("openid", this.cBu);
    }
    this.Tq = true;
  }
  
  public void bFG()
  {
    if ((this.x != null) && (!this.x.isShowing()))
    {
      this.x.show();
      return;
    }
    this.x = aqha.a(this, 230);
    this.x.setMessage(2131697425);
    this.x.setTitle(2131693317);
    this.x.setNegativeButton(2131721058, this);
    this.x.setPositiveButton(2131697395, this);
    this.x.show();
  }
  
  public void ekZ()
  {
    if ((this.cBu != null) && (this.mParams != null)) {
      this.mParams.putString("openid", this.cBu);
    }
    this.mProgress.show();
    new arxh("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this, true).dL(this.mParams);
    this.Tq = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    super.finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.x == paramDialogInterface)
    {
      if (paramInt != 1) {
        break label91;
      }
      paramDialogInterface = new Intent(this, LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("if_check_account_same", true);
      paramDialogInterface.putExtras(this.mParams);
      paramDialogInterface.putExtra("key_action", BindGroupActivity.class.getSimpleName());
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      super.startActivity(paramDialogInterface);
      super.finish();
    }
    label91:
    while (paramInt != 0) {
      return;
    }
    super.setResult(0);
    super.finish();
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
      case 2131365518: 
        apbc localapbc = (apbc)this.app.getManager(32);
        if (localapbc != null) {
          localapbc.d(this, 0);
        }
        break;
      case 2131369579: 
        super.finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.setTheme(2131755343);
    super.onCreate(paramBundle);
    super.setContentView(2131560150);
    paramBundle = findViewById(2131377546);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows(paramBundle, true);
    }
    this.j = super.getResources();
    this.mLayoutInflater = super.getLayoutInflater();
    this.mParams = super.getIntent().getBundleExtra("key_params");
    if (this.mParams == null) {
      return;
    }
    this.mOpenId = this.mParams.getString("openid");
    if ((this.mOpenId == null) && (QLog.isColorLevel())) {
      QLog.d("BindGroupActivity", 2, "mOpenId is null");
    }
    paramBundle = super.getSharedPreferences("openid_encrytoken", 4);
    this.mParams.putString("encrytoken", paramBundle.getString(this.mOpenId, ""));
    this.mAppId = this.mParams.getString("appid");
    if ((this.mAppId == null) && (QLog.isColorLevel())) {
      QLog.d("BindGroupActivity", 2, "mAppId is null");
    }
    if ((this.mAppId == null) || (this.mOpenId == null))
    {
      super.setResult(0);
      super.finish();
      return;
    }
    this.cBv = this.mParams.getString("is_from_game");
    try
    {
      paramBundle = aeie.a(BaseApplicationImpl.getApplication());
      if ((("true".equals(this.cBv)) || (paramBundle.ahl())) && (!TextUtils.isEmpty(this.mAppId)))
      {
        apuh.a(this.app, getApplicationContext(), this.mAppId, this.f, 1001, null);
        if (QLog.isColorLevel()) {
          QLog.d("BindGroupActivity", 2, "bindGroup enableCheckPermission = " + paramBundle.ahl());
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (("true".equals(this.cBv)) && (!TextUtils.isEmpty(this.mAppId))) {
          apuh.a(this.app, getApplicationContext(), this.mAppId, this.f, 1001, null);
        }
        QLog.d("BindGroupActivity", 1, "bindGroup loadConfig exception = " + paramBundle);
      }
    }
    this.mProgress = new arhz(this, super.getTitleBarHeight());
    this.mProgress.setMessage(acfp.m(2131703197));
    this.nP = new ArrayList();
    this.mAppName = this.mParams.getString("app_name");
    this.mParams.putString("skey", super.getIntent().getStringExtra("skey"));
    this.mParams.putString("uin", super.getIntent().getStringExtra("uin"));
    bFE();
    this.Bi = ((TextView)super.findViewById(2131369579));
    this.GS = ((TextView)super.findViewById(2131369581));
    this.mRightBtn = ((TextView)super.findViewById(2131369612));
    this.mTitleView = ((TextView)super.findViewById(2131369627));
    this.JQ = super.findViewById(2131372495);
    this.h = ((SlideDetectListView)super.findViewById(2131382384));
    this.h.setOnItemClickListener(this);
    if (this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$b == null) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$b = new b();
    }
    this.h.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$b);
    this.JR = super.findViewById(2131372423);
    this.JR.setVisibility(8);
    this.acF = ((TextView)super.findViewById(2131365518));
    this.acF.setOnClickListener(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    isBack = false;
  }
  
  public void onException(Exception paramException)
  {
    if ((this.mProgress != null) && (this.mProgress.isShowing())) {
      this.mProgress.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.e("BindGroupActivity", 2, "-->onException", paramException);
    }
    if ((paramException instanceof ConnectTimeoutException)) {
      paramException = arxo.cCU;
    }
    for (;;)
    {
      QQToast.a(this, paramException, 0).create(super.getTitleBarHeight()).show();
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
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (a)this.nP.get(paramInt);
    if (paramAdapterView != null)
    {
      paramView = new Intent(this, BindGroupConfirmActivity.class);
      if (this.mParams != null)
      {
        this.mParams.putString("group_code", paramAdapterView.uin);
        this.mParams.putString("group_name", paramAdapterView.label);
        this.mParams.putString("group_avatar_url", paramAdapterView.avatarUrl);
      }
      paramView.putExtra("key_params", this.mParams);
      super.startActivityForResult(paramView, 1000);
      overridePendingTransition(2130772004, 2130772005);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.Bi.setVisibility(0);
    this.Bi.setText(this.mAppName);
    this.Bi.setOnClickListener(this);
    this.GS.setVisibility(4);
    this.mRightBtn.setVisibility(4);
    this.mTitleView.setText(this.j.getString(2131690860));
    if ((this.mParams != null) && (this.Tq))
    {
      if (!isBack) {
        this.mProgress.show();
      }
      new arxh("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this, true).dL(this.mParams);
      if (QLog.isColorLevel()) {
        QLog.d("BindGroupActivity", 2, "-->onStart, start load group list.");
      }
    }
  }
  
  public static class a
  {
    public String avatarUrl;
    public String label;
    public String uin;
  }
  
  public class b
    extends artj
  {
    protected b() {}
    
    public int getCount()
    {
      return BindGroupActivity.this.nP.size();
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      View localView;
      if ((paramView != null) && (paramView.getTag() != null))
      {
        localObject = (BindGroupActivity.c)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        localObject = (BindGroupActivity.a)BindGroupActivity.this.nP.get(paramInt);
        paramView.Ps.setText(((BindGroupActivity.a)localObject).label);
        paramView.avatar = ((BindGroupActivity.a)localObject).avatarUrl;
        Bitmap localBitmap = artp.a().Q(((BindGroupActivity.a)localObject).avatarUrl);
        if (localBitmap == null) {
          break label171;
        }
        paramView.pQ.setImageBitmap(localBitmap);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localView = BindGroupActivity.this.mLayoutInflater.inflate(2131563062, paramViewGroup, false);
        paramView = new BindGroupActivity.c();
        paramView.pQ = ((ImageView)localView.findViewById(2131366624));
        paramView.Ps = ((TextView)localView.findViewById(2131380362));
        localView.setTag(paramView);
        break;
        label171:
        paramView.pQ.setImageResource(2130841275);
        artp.a().a(((BindGroupActivity.a)localObject).avatarUrl, BindGroupActivity.this);
      }
    }
  }
  
  public static class c
  {
    public TextView Ps;
    public String avatar;
    public ImageView pQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity
 * JD-Core Version:    0.7.0.1
 */