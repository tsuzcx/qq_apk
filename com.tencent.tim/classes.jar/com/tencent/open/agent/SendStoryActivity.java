package com.tencent.open.agent;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import aroi;
import arsr;
import arss;
import arws;
import arwt;
import arwx;
import arxh;
import arxh.a;
import arxi;
import arxi.a;
import arxo;
import arxt;
import asbg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.widget.CursorEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class SendStoryActivity
  extends BaseActivity
  implements TextWatcher, View.OnClickListener, arxh.a, arxi.a
{
  protected TextView Bi;
  protected TextView GS;
  protected ImageView Go;
  protected CursorEditText a;
  protected TextView acW;
  protected TextView acX;
  protected InputFilter[] b;
  protected String cBW;
  protected String cBX;
  protected Button hD;
  protected ProgressDialog i;
  protected LinearLayout lH;
  protected LinearLayout lI;
  protected String mAppId;
  protected String mComment;
  protected RelativeLayout mH;
  protected Bundle mParams;
  protected TextView mRightBtn;
  protected String mSummary;
  protected String mTitle;
  protected View mTitleBar;
  protected TextView mTitleView;
  protected String mToken;
  
  public void E(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.Go.setImageBitmap(paramBitmap);
    }
  }
  
  protected boolean QP()
  {
    try
    {
      this.mParams = super.getIntent().getBundleExtra("key_params");
      if ((this.mParams != null) && (this.mParams.containsKey("appid")) && (this.mParams.containsKey("hopenid")) && (this.mParams.containsKey("keystr")) && (this.mParams.containsKey("keytype")) && (this.mParams.containsKey("platform")) && (this.mParams.containsKey("title")) && (this.mParams.containsKey("pics")) && (this.mParams.containsKey("encrytoken")))
      {
        this.mAppId = this.mParams.getString("appid");
        this.mToken = this.mParams.getString("keystr");
        this.cBW = this.mParams.getString("pics");
        this.mTitle = arwx.d(this.mParams.getString("title"), 72, true, false);
        String str1 = this.mParams.getString("hopenid");
        String str2 = this.mParams.getString("keytype");
        String str3 = this.mParams.getString("platform");
        String str4 = this.mParams.getString("encrytoken");
        if (("".equals(this.mAppId.trim())) || ("".equals(str1.trim())) || ("".equals(this.mToken.trim())) || ("".equals(str2.trim())) || ("".equals(str3.trim())) || ("".equals(this.mTitle.trim())) || ("".equals(this.cBW.trim())) || ("".equals(str4.trim())))
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
      if (this.mParams.containsKey("description")) {
        this.mComment = arwx.d(this.mParams.getString("description"), 80, false, false);
      }
      if (this.mParams.containsKey("summary")) {
        this.mSummary = arwx.d(this.mParams.getString("summary"), 160, true, false);
      }
      this.cBX = asbg.a().qP("https://fusion.qq.com/cgi-bin/appstage/mapp_sendstory.cgi");
      return true;
    }
    catch (Exception localException)
    {
      arwt.e("SendStoryActivity", "initParams exception. " + localException.getMessage(), localException);
      ele();
    }
    return false;
  }
  
  protected String a(Friend paramFriend)
  {
    if (TextUtils.isEmpty(paramFriend.label)) {}
    for (paramFriend = paramFriend.nickName;; paramFriend = paramFriend.label)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("@").append(arwx.d(paramFriend, 12, false, false));
      localStringBuilder.append(" ");
      return localStringBuilder.toString();
    }
  }
  
  @TargetApi(14)
  protected void aDR()
  {
    this.lI = ((LinearLayout)super.findViewById(2131370733));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.lI.setFitsSystemWindows(true);
      this.lI.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.mTitleBar = super.findViewById(2131379791);
    this.mTitleView = ((TextView)super.findViewById(2131369627));
    this.Bi = ((TextView)super.findViewById(2131369579));
    this.GS = ((TextView)super.findViewById(2131369581));
    this.mRightBtn = ((TextView)super.findViewById(2131369612));
    this.Bi.setOnClickListener(this);
    this.GS.setOnClickListener(this);
    this.mRightBtn.setOnClickListener(this);
    this.a = ((CursorEditText)super.findViewById(2131366544));
    this.hD = ((Button)super.findViewById(2131363770));
    this.lH = ((LinearLayout)super.findViewById(2131370744));
    this.mH = ((RelativeLayout)super.findViewById(2131377445));
    this.acW = ((TextView)super.findViewById(2131380943));
    this.acX = ((TextView)super.findViewById(2131380942));
    this.Go = ((ImageView)super.findViewById(2131369915));
    this.hD.setOnClickListener(this);
    this.b = new InputFilter[] { new a(this.a, 80) };
    this.a.setFilters(this.b);
    this.a.addTextChangedListener(this);
    this.a.setSpannedClassToSkip(Friend.class);
    this.acW.setText(arwx.d(this.mTitle, 28, true, false));
    if ((this.mComment != null) && (this.mComment.length() > 0))
    {
      this.a.setText(this.mComment);
      this.a.setTextColor(-16777216);
    }
    if ((this.mSummary != null) && (this.mSummary.length() > 0)) {
      this.acX.setText(arwx.d(this.mSummary, 80, true, false));
    }
    new arxi(null, MsfSdkUtils.insertMtype("yingyongbao", this.cBW), null, "GET", this).execute(new Void[0]);
    this.a.setSelection(this.a.getText().toString().length());
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j = 0;
    Friend[] arrayOfFriend = (Friend[])paramEditable.getSpans(0, paramEditable.length(), Friend.class);
    int k = arrayOfFriend.length;
    while (j < k)
    {
      Friend localFriend = arrayOfFriend[j];
      int m = paramEditable.getSpanStart(localFriend);
      int n = paramEditable.getSpanEnd(localFriend);
      String str = a(localFriend);
      if (!paramEditable.subSequence(m, n).toString().equals(str))
      {
        paramEditable.removeSpan(localFriend);
        paramEditable.delete(m, n);
      }
      j += 1;
    }
  }
  
  public void ai(JSONObject paramJSONObject)
  {
    try
    {
      arxt.m("400", "ANDROIDQQ.SENDSTORY.FEED1", this.mAppId, true);
      dismissProgressDialog();
      int j = paramJSONObject.getInt("ret");
      String str = paramJSONObject.getString("msg");
      if (j == 0) {
        Toast.makeText(getApplicationContext(), 2131691811, 0).show();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_error_code", j);
      localIntent.putExtra("key_error_msg", str);
      localIntent.putExtra("key_response", paramJSONObject.toString());
      ec(localIntent);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      arwt.e("SendStoryActivity", "SendStory exception. " + paramJSONObject.getMessage(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", arxo.cCS);
      ec(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      onException(paramJSONObject);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void dismissProgressDialog()
  {
    if ((this.i != null) && (this.i.isShowing())) {
      this.i.dismiss();
    }
  }
  
  protected void ec(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("key_error_code", -6);
    if (j != 0)
    {
      Toast.makeText(getApplicationContext(), paramIntent.getStringExtra("key_error_msg"), 0).show();
      arwt.e("SendStoryActivity", "onSendStoryComplete error:{KEY_ERROR_CODE:" + j + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  protected void ele()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", arxo.MSG_PARAM_ERROR);
    arwt.e("SendStoryActivity", "initParams:error code:-5; error msg:" + arxo.MSG_PARAM_ERROR);
    if (this.mParams != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.mParams.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + ": " + this.mParams.get(str).toString() + " ");
      }
      arwt.e("SendStoryActivity", "params=" + localStringBuilder.toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    for (;;)
    {
      try
      {
        Object localObject1 = paramIntent.getExtras();
        if (localObject1 == null) {
          break label418;
        }
        if (((Bundle)localObject1).getInt("key_error_code", -6) != 0) {
          return;
        }
        this.a.setFilters(new InputFilter[0]);
        paramIntent = this.a.getEditableText();
        localObject1 = ((Bundle)localObject1).getParcelableArray("RESULT_BUDDIES_SELECTED");
        if (localObject1 == null) {
          break label418;
        }
        paramInt1 = this.a.getSelectionStart();
        paramIntent.delete(paramInt1, this.a.getSelectionEnd());
        Friend[] arrayOfFriend = (Friend[])paramIntent.getSpans(0, paramIntent.length(), Friend.class);
        int k = localObject1.length;
        paramInt2 = 0;
        Object localObject2;
        Object localObject3;
        if (paramInt2 < k)
        {
          localObject2 = localObject1[paramInt2];
          localObject3 = new Friend((Friend)localObject2);
          int m = arrayOfFriend.length;
          j = 0;
          if (j >= m) {
            break label412;
          }
          if (!arrayOfFriend[j].openId.equals(((Friend)localObject3).openId)) {
            break label426;
          }
          j = 0;
          if (j == 0) {
            break label409;
          }
          localObject3 = a((Friend)localObject3);
          paramIntent.insert(paramInt1, (CharSequence)localObject3);
          paramIntent.setSpan(localObject2, paramInt1, ((String)localObject3).length() + paramInt1, 33);
          paramInt1 = ((String)localObject3).length() + paramInt1;
          break label419;
        }
        arrayOfFriend = (Friend[])paramIntent.getSpans(0, paramIntent.length(), Friend.class);
        j = arrayOfFriend.length;
        paramInt1 = 0;
        if (paramInt1 < j)
        {
          localObject2 = arrayOfFriend[paramInt1];
          k = localObject1.length;
          paramInt2 = 0;
          if (paramInt2 < k)
          {
            localObject3 = localObject1[paramInt2];
            if (!((Friend)localObject2).openId.equals(((Friend)localObject3).openId)) {
              break label442;
            }
            paramInt2 = 0;
            if (paramInt2 == 0) {
              break label435;
            }
            paramInt2 = paramIntent.getSpanStart(localObject2);
            k = paramIntent.getSpanEnd(localObject2);
            paramIntent.removeSpan(localObject2);
            paramIntent.delete(paramInt2, k);
            break label435;
          }
        }
        else
        {
          this.a.setFilters(this.b);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        arwt.e("SendStoryActivity", "onActivityResult error:" + paramIntent.getMessage(), paramIntent);
        super.setResult(0);
        super.finish();
        return;
      }
      paramInt2 = 1;
      continue;
      label409:
      break label419;
      label412:
      int j = 1;
      continue;
      label418:
      return;
      label419:
      paramInt2 += 1;
      continue;
      label426:
      j += 1;
      continue;
      label435:
      paramInt1 += 1;
      continue;
      label442:
      paramInt2 += 1;
    }
  }
  
  public boolean onBackEvent()
  {
    super.setResult(0);
    super.finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.Bi)
    {
      super.setResult(0);
      super.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      int j;
      if (paramView == this.hD)
      {
        localObject1 = new Intent();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("appid", this.mAppId);
        ((Bundle)localObject2).putString("hopenid", this.mParams.getString("hopenid"));
        ((Bundle)localObject2).putString("keystr", this.mToken);
        ((Bundle)localObject2).putString("keytype", this.mParams.getString("keytype"));
        ((Bundle)localObject2).putString("encrytoken", this.mParams.getString("encrytoken"));
        ((Bundle)localObject2).putString("platform", this.mParams.getString("platform"));
        if (this.mParams.containsKey("sdkv")) {
          ((Bundle)localObject2).putString("sdkv", this.mParams.getString("sdkv"));
        }
        if (this.mParams.containsKey("sdkp")) {
          ((Bundle)localObject2).putString("sdkp", this.mParams.getString("sdkp"));
        }
        ((Bundle)localObject2).putString("key_action", "action_story");
        localObject3 = (Friend[])this.a.getEditableText().getSpans(0, this.a.length(), Friend.class);
        localObject4 = new String[localObject3.length];
        j = 0;
        while (j < localObject3.length)
        {
          localObject4[j] = localObject3[j].openId;
          j += 1;
        }
        ((Bundle)localObject2).putStringArray("BuddiesSelected", (String[])localObject4);
        ((Intent)localObject1).setClass(this, SocialFriendChooser.class);
        ((Intent)localObject1).putExtra("key_action", "action_story");
        ((Intent)localObject1).putExtra("key_params", (Bundle)localObject2);
        super.startActivityForResult((Intent)localObject1, 0);
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPref", 2, "GetShareFriendSwitchStart:" + SystemClock.elapsedRealtime());
        }
      }
      else if (paramView == this.GS)
      {
        onBackEvent();
      }
      else if (paramView == this.mRightBtn)
      {
        localObject2 = new StringBuilder();
        localObject3 = this.a.getEditableText();
        localObject4 = (Friend[])((Editable)localObject3).getSpans(0, ((Editable)localObject3).length(), Friend.class);
        Arrays.sort((Object[])localObject4, new arsr(this, (Editable)localObject3));
        HashSet localHashSet = new HashSet();
        int n = localObject4.length;
        j = 0;
        int k = 0;
        if (k < n)
        {
          Object localObject5 = localObject4[k];
          int i1 = ((Editable)localObject3).getSpanStart(localObject5);
          int m = ((Editable)localObject3).getSpanEnd(localObject5);
          ((StringBuilder)localObject2).append(((Editable)localObject3).subSequence(j, i1));
          if (localObject5.nickName == null) {}
          for (localObject1 = localObject5.label;; localObject1 = localObject5.nickName)
          {
            localObject1 = arwx.qB((String)localObject1);
            ((StringBuilder)localObject2).append(String.format("@{openid:%s,nick:%s}", new Object[] { localObject5.openId, localObject1 }));
            localHashSet.add(localObject5.openId);
            k += 1;
            j = m;
            break;
          }
        }
        if (j != ((Editable)localObject3).length()) {
          ((StringBuilder)localObject2).append(((Editable)localObject3).subSequence(j, ((Editable)localObject3).length()));
        }
        if (localHashSet.size() > 10)
        {
          Toast.makeText(getApplicationContext(), super.getString(2131691810, new Object[] { Integer.valueOf(10) }), 0).show();
        }
        else
        {
          localObject1 = new Bundle(this.mParams);
          ((Bundle)localObject1).putString("summary", this.mSummary);
          ((Bundle)localObject1).putString("title", this.mTitle);
          ((Bundle)localObject1).putString("description", ((StringBuilder)localObject2).toString());
          ((Bundle)localObject1).putString("appid_for_getting_config", this.mAppId);
          ((Bundle)localObject1).putString("agentversion", aroi.a().getAgentVersion());
          this.i = ProgressDialog.show(this, "", super.getString(2131691816), true);
          this.i.setCancelable(true);
          new arxh(this.cBX, "POST", this, true).dL((Bundle)localObject1);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
    super.setTheme(2131755343);
    super.setContentView(2131559883);
    QP();
    aDR();
    arxt.m("100", "ANDROIDQQ.SENDSTORY.FS", this.mAppId, true);
  }
  
  public void onException(Exception paramException)
  {
    dismissProgressDialog();
    arwt.e("SendStoryActivity", "SendStory exception. " + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", arxo.cCU);
    }
    for (;;)
    {
      ec(localIntent);
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
  
  public void onStart()
  {
    super.onStart();
    this.Bi.setVisibility(4);
    this.GS.setVisibility(0);
    this.GS.setText(2131721058);
    this.mRightBtn.setVisibility(0);
    this.mRightBtn.setText(2131691818);
    this.mTitleView.setText(2131691812);
    this.GS.setOnClickListener(this);
    this.mRightBtn.setOnClickListener(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public class a
    extends arws
  {
    public a(EditText paramEditText, int paramInt)
    {
      super(paramInt);
    }
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      paramInt3 = 0;
      paramSpanned = this.mEditText.getEditableText();
      StringBuilder localStringBuilder = new StringBuilder(paramSpanned.toString());
      Friend[] arrayOfFriend = (Friend[])paramSpanned.getSpans(0, paramSpanned.length(), Friend.class);
      Arrays.sort(arrayOfFriend, new arss(this, paramSpanned));
      paramInt4 = arrayOfFriend.length;
      while (paramInt3 < paramInt4)
      {
        Friend localFriend = arrayOfFriend[paramInt3];
        localStringBuilder.delete(paramSpanned.getSpanStart(localFriend), paramSpanned.getSpanEnd(localFriend));
        paramInt3 += 1;
      }
      paramInt4 = this.mMaxBytes - arwx.fz(localStringBuilder.toString());
      paramInt3 = arwx.fz(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
      if (paramInt4 <= 0) {
        return "";
      }
      if (paramInt4 >= paramInt3) {
        return null;
      }
      paramInt3 = paramInt1;
      if (paramInt3 < paramInt2)
      {
        int j;
        if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3))) {
          j = arwx.fz(paramCharSequence.subSequence(paramInt3, paramInt3 + 2).toString());
        }
        for (int i = 2;; i = 1)
        {
          paramInt4 -= j;
          if (paramInt4 < 0) {
            break label257;
          }
          paramInt3 = i + paramInt3;
          break;
          j = arwx.fz(String.valueOf(paramCharSequence.charAt(paramInt3)));
        }
      }
      label257:
      if (paramInt3 == paramInt1) {
        return "";
      }
      return paramCharSequence.subSequence(paramInt1, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.SendStoryActivity
 * JD-Core Version:    0.7.0.1
 */