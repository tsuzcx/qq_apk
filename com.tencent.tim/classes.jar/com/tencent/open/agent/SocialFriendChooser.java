package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import aroi;
import arsc;
import arsc.c;
import arst;
import artl;
import arto;
import arwt;
import arwx;
import arxa;
import arxh;
import arxh.a;
import arxo;
import arxt;
import asbg;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class SocialFriendChooser
  extends FriendChooser
  implements arsc.c, arxh.a
{
  protected String action;
  public arxh b;
  protected String cBD;
  protected String cBH;
  protected String cBY;
  protected String cBZ;
  protected String cCa;
  protected String cCb;
  protected ProgressDialog d;
  protected String img;
  protected String[] iq;
  protected String mAppId;
  protected Handler mHandler = new arst(this);
  public Bundle mParams;
  protected String mPf;
  protected String mPlatform;
  protected String mToken;
  protected String mTokenType;
  protected String msg;
  protected String source;
  protected String title;
  protected String type;
  
  protected boolean QP()
  {
    for (;;)
    {
      try
      {
        this.mParams = super.getIntent().getBundleExtra("key_params");
        this.action = super.getIntent().getStringExtra("key_action");
        arwt.d("SocialFriendChooser", "-->action = " + this.action + " -- mParms = " + this.mParams);
        if ((this.mParams != null) && (this.mParams.containsKey("appid")) && (this.mParams.containsKey("hopenid")) && (this.mParams.containsKey("keystr")) && (this.mParams.containsKey("keytype")) && (this.mParams.containsKey("platform")) && (this.mParams.containsKey("encrytoken")))
        {
          this.mAppId = this.mParams.getString("appid");
          this.mToken = this.mParams.getString("keystr");
          this.cBD = this.mParams.getString("hopenid");
          this.mTokenType = this.mParams.getString("keytype");
          this.mPlatform = this.mParams.getString("platform");
          this.cBH = this.mParams.getString("encrytoken");
          if (("".equals(this.mAppId.trim())) || ("".equals(this.cBD.trim())) || ("".equals(this.mToken.trim())) || ("".equals(this.mPlatform.trim())) || ("".equals(this.mTokenType.trim())) || ("".equals(this.cBH.trim())))
          {
            ele();
            return false;
          }
          if (("action_gift".equals(this.action)) || ("action_ask".equals(this.action)) || ("action_reactive".equals(this.action)))
          {
            this.type = this.mParams.getString("type");
            this.title = arwx.d(this.mParams.getString("title"), 12, true, false);
            this.msg = arwx.d(this.mParams.getString("msg"), 70, true, false);
            if (!"action_ask".equals(this.action)) {
              break label798;
            }
            String str1 = "50";
            this.cBY = str1;
            if (("".equals(this.type.trim())) || ("".equals(this.title.trim())) || ("".equals(this.msg.trim())))
            {
              ele();
              return false;
            }
            if ("action_reactive".equals(this.action))
            {
              this.cBY = "51";
              if ((!this.mParams.containsKey("recImg")) || (!this.mParams.containsKey("recImgDec")) || (!this.mParams.containsKey("sendImg")))
              {
                ele();
                return false;
              }
              this.cBZ = this.mParams.getString("recImg");
              this.cCa = arwx.d(this.mParams.getString("recImgDec"), 20, true, false);
              this.cCb = this.mParams.getString("sendImg");
              if (("".equals(this.cBZ)) || ("".equals(this.cCa)) || ("".equals(this.cCb)))
              {
                ele();
                return false;
              }
            }
            arwt.d("SocialFriendChooser", "-->typeid = " + this.cBY);
          }
          if (this.mParams.containsKey("pf")) {
            this.mPf = this.mParams.getString("pf");
          }
          if (this.mParams.containsKey("img")) {
            this.img = this.mParams.getString("img");
          }
          if (this.mParams.containsKey("source")) {
            this.source = this.mParams.getString("source");
          }
          arsc.a().iG(this.mAppId, this.cBD);
          this.iq = this.mParams.getStringArray("BuddiesSelected");
          return true;
        }
      }
      catch (Exception localException)
      {
        arwt.e("SocialFriendChooser", "initParams exception." + localException.getMessage(), localException);
        ele();
        return false;
      }
      ele();
      return false;
      label798:
      String str2 = "1";
    }
  }
  
  public void a(arto paramarto)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        dismissProgressDialog();
        if (("action_gift".equals(this.action)) || ("action_ask".equals(this.action)) || ("action_invite".equals(this.action)) || ("action_reactive".equals(this.action)) || ("action_story".equals(this.action)))
        {
          this.ekM = paramarto.ekW;
          if (paramarto.ekU != -1)
          {
            if (paramarto.ekU - paramarto.ekV == 0)
            {
              this.ekM = 0;
              this.ekN = paramarto.ekU;
            }
          }
          else
          {
            if (this.ekM == 0) {
              Toast.makeText(this, super.getString(2131690083, new Object[] { Integer.valueOf(paramarto.ekU) }), 0).show();
            }
            artl localartl = artl.a();
            localartl.g(paramarto.groups, paramarto.ekR, paramarto.ekS);
            if (this.iq == null) {
              break label362;
            }
            paramarto = this.iq;
            int j = paramarto.length;
            if (i >= j) {
              break label362;
            }
            String str = paramarto[i];
            localartl.WZ(str);
            this.aQ.add(localartl.a(str));
            i += 1;
            continue;
          }
          if (paramarto.ekU - paramarto.ekV >= this.ekM) {
            continue;
          }
          this.ekM = (paramarto.ekU - paramarto.ekV);
          continue;
        }
        cz(true);
      }
      catch (Exception paramarto)
      {
        arwt.e("SocialFriendChooser", "GetBuddyList exception." + paramarto.getMessage(), paramarto);
        paramarto = new Intent();
        paramarto.putExtra("key_error_code", -6);
        paramarto.putExtra("key_error_msg", arxo.cCT);
        ea(paramarto);
        if (QLog.isColorLevel())
        {
          if (!"action_story".equals(this.action)) {
            break;
          }
          QLog.d("SDKQQAgentPref", 2, "GetShareFriendSwitchEnd:" + SystemClock.elapsedRealtime());
        }
        return;
      }
      label362:
      ((OpenFrame)this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).notifyDataSetChanged();
      this.mHandler.sendEmptyMessageDelayed(10001, 5000L);
    }
    QLog.d("SDKQQAgentPref", 2, "GetInviteFriendSwitch_AGENT:" + SystemClock.elapsedRealtime());
  }
  
  public void ai(JSONObject paramJSONObject)
  {
    int i = 2131691805;
    try
    {
      dismissProgressDialog();
      int j = paramJSONObject.getInt("ret");
      String str = paramJSONObject.getString("msg");
      if (j == 0)
      {
        if (!"action_invite".equals(this.action)) {
          break label113;
        }
        arxt.m("400", "ANDROIDQQ.INVITE.ASSISTANT", this.mAppId, true);
      }
      for (;;)
      {
        Toast.makeText(this, i, 0).show();
        Intent localIntent = new Intent();
        localIntent.putExtra("key_error_code", j);
        localIntent.putExtra("key_error_msg", str);
        localIntent.putExtra("key_response", paramJSONObject.toString());
        ed(localIntent);
        return;
        label113:
        if ("action_ask".equals(this.action))
        {
          arxt.m("400", "ANDROIDQQ.REQUEST.ASSISTANT", this.mAppId, true);
          i = 2131690091;
        }
        else if ("action_gift".equals(this.action))
        {
          arxt.m("400", "ANDROIDQQ.FREEGIFT.ASSISTANT", this.mAppId, true);
          i = 2131690089;
        }
        else if ("action_reactive".equals(this.action))
        {
          arxt.m("400", "ANDROIDQQ.REACTIVE.ASSISTANT", this.mAppId, true);
          i = 2131690090;
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      arwt.e("SocialFriendChooser", "SendAppInvitation exception." + paramJSONObject.getMessage(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", arxo.cCS);
      ed(paramJSONObject);
    }
  }
  
  protected void cjw()
  {
    if (("action_invite".equals(this.action)) || ("action_gift".equals(this.action)) || ("action_ask".equals(this.action)) || ("action_reactive".equals(this.action))) {
      ely();
    }
    while (!"action_story".equals(this.action)) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Friend[] arrayOfFriend = (Friend[])this.aQ.toArray(new Friend[this.aQ.size()]);
    localBundle.putInt("key_error_code", 0);
    localBundle.putParcelableArray("RESULT_BUDDIES_SELECTED", arrayOfFriend);
    localIntent.putExtras(localBundle);
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void dismissProgressDialog()
  {
    if ((this.d != null) && (this.d.isShowing())) {
      this.d.dismiss();
    }
  }
  
  public void ea(Intent paramIntent)
  {
    dismissProgressDialog();
    if (paramIntent.hasExtra("key_error_msg")) {
      Toast.makeText(aroi.a().getContext(), paramIntent.getStringExtra("key_error_msg"), 0).show();
    }
    int i = paramIntent.getIntExtra("key_error_code", -6);
    if (i != 0) {
      arwt.e("SocialFriendChooser", "onGetBuddyListError{KEY_ERROR_CODE:" + i + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  protected void ed(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_error_code", -6);
    if (i != 0)
    {
      Toast.makeText(this, paramIntent.getStringExtra("key_error_msg"), 0).show();
      arwt.e("SocialFriendChooser", "onSendAppInvitationComplete{KEY_ERROR_CODE:" + i + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  protected void ele()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", arxo.MSG_PARAM_ERROR);
    arwt.e("SocialFriendChooser", "initParams:error code:-5; error msg:" + arxo.MSG_PARAM_ERROR);
    Bundle localBundle = super.getIntent().getBundleExtra("key_params");
    if (localBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + ": " + localBundle.get(str).toString() + " ");
      }
      arwt.e("SocialFriendChooser", "params=" + localStringBuilder.toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void elh()
  {
    String str = null;
    if (this.ekM == 0) {
      if ("action_invite".equals(this.action)) {
        str = super.getString(2131690083, new Object[] { Integer.valueOf(this.ekN) });
      }
    }
    for (;;)
    {
      arxa.a().showToast(str, 0);
      return;
      if ("action_ask".equals(this.action))
      {
        str = super.getString(2131690088, new Object[] { Integer.valueOf(this.ekN) });
      }
      else if ("action_gift".equals(this.action))
      {
        str = super.getString(2131690082, new Object[] { Integer.valueOf(this.ekN) });
      }
      else if ("action_reactive".equals(this.action))
      {
        str = super.getString(2131690083, new Object[] { Integer.valueOf(this.ekN) });
        continue;
        str = super.getString(2131691782, new Object[] { Integer.valueOf(this.ekM) });
      }
    }
  }
  
  protected void ely()
  {
    String str1 = null;
    this.d = ProgressDialog.show(this, "", super.getString(2131691813), true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.mAppId);
    localBundle.putString("hopenid", this.cBD);
    localBundle.putString("keystr", this.mToken);
    localBundle.putString("keytype", this.mTokenType);
    localBundle.putString("platform", this.mPlatform);
    localBundle.putString("encrytoken", this.cBH);
    localBundle.putString("agentversion", aroi.a().getAgentVersion());
    localBundle.putString("appid_for_getting_config", this.mAppId);
    if (this.mParams.containsKey("desc")) {
      localBundle.putString("desc", arwx.d(this.mParams.getString("desc"), 70, true, false));
    }
    if (this.mParams.containsKey("picurl")) {
      localBundle.putString("picurl", this.mParams.getString("picurl"));
    }
    if (this.mParams.containsKey("source")) {
      localBundle.putString("source", this.mParams.getString("source"));
    }
    if (this.mParams.containsKey("pf")) {
      localBundle.putString("pf", this.mParams.getString("pf"));
    }
    if (this.mParams.containsKey("sdkv")) {
      localBundle.putString("sdkv", this.mParams.getString("pf"));
    }
    if (this.mParams.containsKey("sdkp")) {
      localBundle.putString("sdkp", this.mParams.getString("sdkp"));
    }
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.gT().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Friend localFriend = this.a.a(str2);
      if (localFriend != null) {
        if (localFriend.ekR == -1) {
          ((StringBuilder)localObject).append(str2).append(",");
        } else {
          localStringBuilder.append(str2).append("_").append(localFriend.ekR).append(",");
        }
      }
    }
    int i = ((StringBuilder)localObject).lastIndexOf(",");
    if (i != -1) {
      ((StringBuilder)localObject).deleteCharAt(i);
    }
    i = localStringBuilder.lastIndexOf(",");
    if (i != -1) {
      localStringBuilder.deleteCharAt(i);
    }
    localBundle.putString("app_rid", String.valueOf(this.a.ekR));
    localBundle.putString("app_tid", String.valueOf(this.a.ekS));
    localBundle.putString("recom_openids", localStringBuilder.toString());
    if ("action_invite".equals(this.action))
    {
      localBundle.putString("invitedopenids", ((StringBuilder)localObject).toString());
      str1 = asbg.a().qP("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_invite.cgi");
      localObject = "GET";
    }
    for (;;)
    {
      if (str1 != null)
      {
        this.jdField_b_of_type_Arxh = new arxh(str1, (String)localObject, this, true);
        this.jdField_b_of_type_Arxh.dL(localBundle);
        this.mHandler.sendEmptyMessageDelayed(10002, 45000L);
      }
      return;
      if (("action_gift".equals(this.action)) || ("action_ask".equals(this.action)) || ("action_reactive".equals(this.action)))
      {
        if ("action_reactive".equals(this.action)) {
          localBundle.putString("imgurl", this.cCb);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.title)) {
            localBundle.putString("title", this.title);
          }
          if (!TextUtils.isEmpty(this.msg)) {
            localBundle.putString("sendmsg", this.msg);
          }
          localBundle.putString("receiver", ((StringBuilder)localObject).toString());
          localBundle.putString("typeid", this.cBY);
          str1 = asbg.a().qP("https://appic.qq.com/cgi-bin/appstage/mapp_sendrequest.cgi");
          localObject = "POST";
          break;
          if (!TextUtils.isEmpty(this.img)) {
            localBundle.putString("imgurl", this.img);
          }
        }
      }
      localObject = null;
    }
  }
  
  protected void elz()
  {
    this.d = ProgressDialog.show(this, "", getResources().getString(2131691779), true);
    this.d.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.mAppId);
    localBundle.putString("hopenid", this.cBD);
    localBundle.putString("keystr", this.mToken);
    localBundle.putString("keytype", this.mTokenType);
    localBundle.putString("platform", this.mPlatform);
    localBundle.putString("encrytoken", this.cBH);
    if (this.mPf != null) {
      localBundle.putString("pf", this.mPf);
    }
    localBundle.putString("appid_for_getting_config", this.mAppId);
    if (("action_gift".equals(this.action)) || ("action_ask".equals(this.action)) || ("action_reactive".equals(this.action))) {
      localBundle.putString("typeid", this.cBY);
    }
    localBundle.putString("agentversion", aroi.a().getAgentVersion());
    localBundle.putString("appid_for_getting_config", this.mAppId);
    arsc.a().a(localBundle, this, this.action);
  }
  
  public String getAppid()
  {
    return this.mAppId;
  }
  
  protected int getLayoutId()
  {
    return 2131559879;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.yW(0);
    paramBundle = findViewById(2131372666);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows(paramBundle, true);
    }
    QP();
    elz();
    if (this.action.equals("action_invite"))
    {
      paramBundle = super.getString(2131690084);
      ((GroupListOpenFrame)this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).WU(paramBundle);
    }
    do
    {
      while ("action_invite".equals(this.action))
      {
        arxt.m("100", "ANDROIDQQ.INVITE.FS", this.mAppId, true);
        return;
        if ((this.action.equals("action_reactive")) || (this.action.equals("action_gift")) || (this.action.equals("action_ask")))
        {
          paramBundle = super.getString(2131690086);
          ((GroupListOpenFrame)this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).WU(paramBundle);
        }
      }
      if ("action_ask".equals(this.action))
      {
        arxt.m("100", "ANDROIDQQ.REQUEST.FS", this.mAppId, true);
        return;
      }
      if ("action_gift".equals(this.action))
      {
        arxt.m("100", "ANDROIDQQ.FREEGIFT.FS", this.mAppId, true);
        return;
      }
    } while (!"action_reactive".equals(this.action));
    arxt.m("100", "ANDROIDQQ.REACTIVE.FS", this.mAppId, true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mHandler.removeMessages(10001);
    arsc.a().releaseResource();
  }
  
  public void onException(Exception paramException)
  {
    dismissProgressDialog();
    arwt.e("SocialFriendChooser", "SendAppInvitation exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", arxo.cCU);
    }
    for (;;)
    {
      ed(localIntent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.SocialFriendChooser
 * JD-Core Version:    0.7.0.1
 */