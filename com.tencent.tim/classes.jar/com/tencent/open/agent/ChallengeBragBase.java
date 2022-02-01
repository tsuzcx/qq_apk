package com.tencent.open.agent;

import acfp;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import arwt;
import arwx;
import arxh;
import arxh.a;
import arxo;
import arxt;
import asbg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ChallengeBragBase
  extends BaseActivity
  implements View.OnClickListener
{
  protected TextView acN;
  protected TextView acO;
  protected EditText bD;
  protected String cBD;
  protected String cBE;
  protected String cBF;
  protected String cBG;
  protected String cBH;
  protected String cBI;
  protected String cBJ;
  protected ProgressDialog i;
  protected String mAction;
  protected String mAppId;
  protected String mImageUrl;
  protected Bundle mParams;
  protected String mPf;
  protected String mPlatform;
  protected TextView mTitle;
  protected String mToken;
  protected String mTokenType;
  
  protected boolean QP()
  {
    try
    {
      this.mParams = super.getIntent().getBundleExtra("key_params");
      this.mAction = super.getIntent().getStringExtra("key_action");
      if ((this.mParams != null) && (this.mParams.containsKey("appid")) && (this.mParams.containsKey("hopenid")) && (this.mParams.containsKey("keystr")) && (this.mParams.containsKey("keytype")) && (this.mParams.containsKey("platform")) && (this.mParams.containsKey("img")) && (this.mParams.containsKey("receiver")) && (this.mParams.containsKey("encrytoken")))
      {
        this.mAppId = this.mParams.getString("appid");
        this.cBD = this.mParams.getString("hopenid");
        this.mToken = this.mParams.getString("keystr");
        this.mTokenType = this.mParams.getString("keytype");
        this.mPlatform = this.mParams.getString("platform");
        this.mImageUrl = this.mParams.getString("img");
        this.cBE = this.mParams.getString("receiver");
        this.cBF = this.mParams.getString("msg");
        this.cBH = this.mParams.getString("encrytoken");
        if (("".equals(this.mAppId.trim())) || ("".equals(this.cBD.trim())) || ("".equals(this.mToken.trim())) || ("".equals(this.mTokenType.trim())) || ("".equals(this.mPlatform.trim())) || ("".equals(this.mImageUrl.trim())) || ("".equals(this.cBE.trim())))
        {
          ele();
          return false;
        }
      }
      else
      {
        ele();
        return false;
      }
    }
    catch (Exception localException)
    {
      arwt.e("qqBaseActivity", "initParams exception." + localException.getMessage(), localException);
      ele();
      return false;
    }
    if (this.mParams.containsKey("pf")) {
      this.mPf = this.mParams.getString("pf");
    }
    if (this.mParams.containsKey("source")) {
      this.cBG = this.mParams.getString("source");
    }
    this.cBI = asbg.a().qP("https://fusion.qq.com/cgi-bin/qzapps/mapp_getuserinfo.cgi");
    this.cBJ = asbg.a().qP("https://appic.qq.com/cgi-bin/appstage/mapp_sendbragging.cgi");
    return true;
  }
  
  protected void WS(String paramString)
  {
    this.i = ProgressDialog.show(this, "", super.getResources().getString(2131691795), true);
    this.i.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.mAppId);
    localBundle.putString("hopenid", this.cBD);
    localBundle.putString("keystr", this.mToken);
    localBundle.putString("keytype", this.mTokenType);
    localBundle.putString("encrytoken", this.cBH);
    localBundle.putString("platform", this.mPlatform);
    paramString = TextUtils.split(paramString, ",");
    if ((paramString == null) || (paramString.length == 0)) {
      ele();
    }
    do
    {
      return;
      localBundle.putString("fopenids", paramString[0]);
      if (this.mPf != null) {
        localBundle.putString("pf", this.mPf);
      }
      localBundle.putString("appid_for_getting_config", this.mAppId);
    } while (this.cBI == null);
    new arxh(this.cBI, "GET", new a(), true).dL(localBundle);
  }
  
  protected void dismissProgressDialog()
  {
    if ((this.i != null) && (this.i.isShowing())) {
      this.i.dismiss();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "GetPKFriendInfoSwitch_AGENT:" + SystemClock.elapsedRealtime());
    }
  }
  
  protected void ele()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", arxo.MSG_PARAM_ERROR);
    arwt.e("qqBaseActivity", "initParams:error code:-5; error msg:" + arxo.MSG_PARAM_ERROR);
    if (this.mParams != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.mParams.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + ": " + this.mParams.get(str).toString() + " ");
      }
      arwt.e("qqBaseActivity", "params=" + localStringBuilder.toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    Bundle localBundle;
    int j;
    if (paramView == this.acN)
    {
      localBundle = new Bundle();
      localBundle.putString("appid", this.mAppId);
      localBundle.putString("hopenid", this.cBD);
      localBundle.putString("keystr", this.mToken);
      localBundle.putString("keytype", this.mTokenType);
      localBundle.putString("encrytoken", this.cBH);
      localBundle.putString("platform", this.mPlatform);
      localBundle.putString("sendmsg", this.bD.getText().toString());
      localBundle.putString("imgurl", this.mImageUrl);
      localBundle.putString("receiver", this.cBE);
      j = 2131691814;
      if ("action_brag".equals(this.mAction))
      {
        localBundle.putString("typeid", "52");
        localBundle.putString("appid_for_getting_config", this.mAppId);
        if (this.cBG != null) {
          localBundle.putString("app_custom", this.cBG);
        }
        if (this.mPf != null) {
          localBundle.putString("pf", this.mPf);
        }
        this.i = ProgressDialog.show(this, "", super.getResources().getString(j), true);
        new arxh(this.cBJ, "POST", new b(), true).dL(localBundle);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!"action_challenge".equals(this.mAction)) {
        break;
      }
      localBundle.putString("typeid", "53");
      j = 2131691815;
      break;
      if (paramView == this.acO)
      {
        super.setResult(0);
        super.finish();
      }
    }
  }
  
  public class a
    implements arxh.a
  {
    protected a() {}
    
    public void ai(JSONObject paramJSONObject)
    {
      try
      {
        ChallengeBragBase.this.dismissProgressDialog();
        int i = paramJSONObject.getInt("ret");
        String str = paramJSONObject.getString("msg");
        if (i != 0)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_error_code", i);
          localIntent.putExtra("key_error_msg", str);
          localIntent.putExtra("key_response", paramJSONObject.toString());
          dX(localIntent);
          return;
        }
        paramJSONObject = paramJSONObject.getJSONArray("data");
        if (paramJSONObject.length() == 0)
        {
          paramJSONObject = new Intent();
          paramJSONObject.putExtra("key_error_code", -5);
          paramJSONObject.putExtra("key_error_msg", arxo.MSG_PARAM_ERROR);
          paramJSONObject.putExtra("key_error_detail", acfp.m(2131703561));
          dX(paramJSONObject);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        arwt.e("qqBaseActivity", "GetNickNameCallback exception." + paramJSONObject.getMessage(), paramJSONObject);
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", -4);
        paramJSONObject.putExtra("key_error_msg", arxo.cCS);
        dX(paramJSONObject);
        return;
        paramJSONObject = arwx.d(arwx.qA(paramJSONObject.getJSONObject(0).getString("nick")), 12, true, true);
        if ("action_brag".equals(ChallengeBragBase.this.mAction))
        {
          ChallengeBragBase.this.mTitle.setText(ChallengeBragBase.this.getString(2131690081, new Object[] { paramJSONObject }));
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        onException(paramJSONObject);
        return;
      }
      if ("action_challenge".equals(ChallengeBragBase.this.mAction)) {
        ChallengeBragBase.this.mTitle.setText(ChallengeBragBase.this.getString(2131690085, new Object[] { paramJSONObject }));
      }
    }
    
    protected void dX(Intent paramIntent)
    {
      int i = paramIntent.getIntExtra("key_error_code", -6);
      if (i != 0)
      {
        Toast.makeText(ChallengeBragBase.this, paramIntent.getStringExtra("key_error_msg"), 0).show();
        arwt.e("qqBaseActivity", "onGetNickNameError{KEY_ERROR_CODE:" + i + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
      }
      ChallengeBragBase.this.setResult(-1, paramIntent);
      ChallengeBragBase.this.finish();
    }
    
    public void onException(Exception paramException)
    {
      ChallengeBragBase.this.dismissProgressDialog();
      arwt.e("qqBaseActivity", "GetNickNameCallback exception." + paramException.getMessage(), paramException);
      Intent localIntent = new Intent();
      if ((paramException instanceof ConnectTimeoutException))
      {
        localIntent.putExtra("key_error_code", -7);
        localIntent.putExtra("key_error_msg", arxo.cCU);
      }
      for (;;)
      {
        dX(localIntent);
        return;
        if ((paramException instanceof SocketTimeoutException))
        {
          localIntent.putExtra("key_error_code", -8);
          localIntent.putExtra("key_error_msg", arxo.cCV);
        }
        else if ((paramException instanceof MalformedURLException))
        {
          localIntent.putExtra("key_error_code", -3);
          localIntent.putExtra("key_error_msg", "访问url有误!");
        }
        else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
        {
          localIntent.putExtra("key_error_code", -10);
          localIntent.putExtra("key_error_msg", "Http返回码异常!");
        }
        else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
        {
          localIntent.putExtra("key_error_code", -9);
          localIntent.putExtra("key_error_msg", arxo.cCW);
        }
        else if ((paramException instanceof IOException))
        {
          localIntent.putExtra("key_error_code", -2);
          localIntent.putExtra("key_error_msg", arxo.cCR);
        }
        else
        {
          localIntent.putExtra("key_error_code", -6);
          localIntent.putExtra("key_error_msg", arxo.cCT);
        }
      }
    }
  }
  
  public class b
    implements arxh.a
  {
    protected b() {}
    
    public void ai(JSONObject paramJSONObject)
    {
      int i = 0;
      try
      {
        ChallengeBragBase.this.dismissProgressDialog();
        int j = paramJSONObject.getInt("ret");
        String str = paramJSONObject.getString("msg");
        Object localObject;
        if (j == 0)
        {
          localObject = null;
          if (!"action_brag".equals(ChallengeBragBase.this.mAction)) {
            break label132;
          }
          localObject = "ANDROIDQQ.BRAG.ASSISTANT";
          i = 2131691806;
        }
        for (;;)
        {
          if (localObject != null)
          {
            arxt.m("400", (String)localObject, ChallengeBragBase.this.mAppId, true);
            Toast.makeText(ChallengeBragBase.this, i, 0).show();
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_error_code", j);
          ((Intent)localObject).putExtra("key_error_msg", str);
          ((Intent)localObject).putExtra("key_response", paramJSONObject.toString());
          dY((Intent)localObject);
          return;
          label132:
          if ("action_challenge".equals(ChallengeBragBase.this.mAction))
          {
            localObject = "ANDROIDQQ.PK.ASSISTANT";
            i = 2131691807;
          }
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        arwt.e("qqBaseActivity", "SendChallenge exception." + paramJSONObject.getMessage(), paramJSONObject);
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", -4);
        paramJSONObject.putExtra("key_error_msg", arxo.cCS);
        dY(paramJSONObject);
        return;
      }
      catch (Exception paramJSONObject)
      {
        onException(paramJSONObject);
      }
    }
    
    protected void dY(Intent paramIntent)
    {
      int i = paramIntent.getIntExtra("key_error_code", -6);
      if (i != 0)
      {
        Toast.makeText(ChallengeBragBase.this, paramIntent.getStringExtra("key_error_msg"), 0).show();
        arwt.e("qqBaseActivity", "onSendChallengeComplete error:{KEY_ERROR_CODE:" + i + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
      }
      ChallengeBragBase.this.setResult(-1, paramIntent);
      ChallengeBragBase.this.finish();
    }
    
    public void onException(Exception paramException)
    {
      ChallengeBragBase.this.dismissProgressDialog();
      arwt.e("qqBaseActivity", "SendChallenge exception." + paramException.getMessage(), paramException);
      Intent localIntent = new Intent();
      if ((paramException instanceof ConnectTimeoutException))
      {
        localIntent.putExtra("key_error_code", -7);
        localIntent.putExtra("key_error_msg", arxo.cCU);
      }
      for (;;)
      {
        dY(localIntent);
        return;
        if ((paramException instanceof SocketTimeoutException))
        {
          localIntent.putExtra("key_error_code", -8);
          localIntent.putExtra("key_error_msg", arxo.cCV);
        }
        else if ((paramException instanceof MalformedURLException))
        {
          localIntent.putExtra("key_error_code", -3);
          localIntent.putExtra("key_error_msg", "访问url有误!");
        }
        else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
        {
          localIntent.putExtra("key_error_code", -10);
          localIntent.putExtra("key_error_msg", "Http返回码异常!");
        }
        else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
        {
          localIntent.putExtra("key_error_code", -9);
          localIntent.putExtra("key_error_msg", arxo.cCW);
        }
        else if ((paramException instanceof IOException))
        {
          localIntent.putExtra("key_error_code", -2);
          localIntent.putExtra("key_error_msg", arxo.cCR);
        }
        else
        {
          localIntent.putExtra("key_error_code", -6);
          localIntent.putExtra("key_error_msg", arxo.cCT);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeBragBase
 * JD-Core Version:    0.7.0.1
 */