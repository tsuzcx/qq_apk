package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.captchasdk.TCaptchaPopupActivity;
import com.tencent.token.ch;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tmsdk.TMSDKContext;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import org.json.JSONObject;

public class WtLoginAccountInput
  extends BaseActivity
{
  private static final int VERIFYREQESTCODE = 1001;
  private boolean isCurrentPageChooseWay = true;
  private boolean isQuickLogin = false;
  private boolean isshowing;
  private do mAgent;
  private byte[] mAqSig;
  private View.OnClickListener mFindPwdListener = new afx(this);
  private Handler mHandler = new afr(this);
  boolean mIsActiveSuccess = false;
  private cp mLoginManager;
  private int mPageId;
  private Button mQuickLoginBtn;
  private Intent mQuickLoginIntenData;
  private View.OnClickListener mQuickLoginListener = new afw(this);
  private String mQuickLoginUin;
  private byte[] mScanCode;
  private cw mTokenCore;
  private long mUin;
  private QQUser mUser;
  private TextView mfindPwdText;
  private boolean parseqqsucc;
  protected QueryCaptchaResult queryCaptchaResult;
  
  private void gotoScanLogin()
  {
    Intent localIntent = new Intent(this, ScanLoginAccountListActivity.class);
    localIntent.putExtra("qquin", this.mUin + "");
    localIntent.putExtra("scancode", this.mScanCode);
    startActivity(localIntent);
    finish();
  }
  
  private void initViewChooseWayToLogin()
  {
    setContentView(2130968627);
    this.isCurrentPageChooseWay = true;
    this.mQuickLoginBtn = ((Button)findViewById(2131558750));
    this.mfindPwdText = ((TextView)findViewById(2131558751));
    this.mfindPwdText.setOnClickListener(new afy(this));
    this.mfindPwdText.setOnClickListener(this.mFindPwdListener);
    this.mQuickLoginBtn.setOnClickListener(this.mQuickLoginListener);
  }
  
  private void judgeNextStep()
  {
    this.mQuickLoginIntenData = null;
    this.mAgent.b(this.mUin);
    do.a().f(this.mUin);
    this.mUser = this.mAgent.d(this.mUin);
    if (this.mScanCode != null)
    {
      gotoScanLogin();
      return;
    }
    if (this.mUser == null)
    {
      dismissDialog();
      return;
    }
    cw.a().a(this.mUser.mRealUin, this.mAqSig, this.mHandler, 1, 1);
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = cx.c();
    ((cx)localObject).i();
    ((cx)localObject).n();
    localObject = new Intent(this, VerifySuccActivity.class);
    ((Intent)localObject).putExtra("mRealUin", this.mUser.mRealUin);
    startActivity((Intent)localObject);
    finish();
  }
  
  private void syncst()
  {
    QQUser localQQUser;
    if (this.mAqSig != null)
    {
      localQQUser = new QQUser();
      if (this.mLoginManager == null) {
        this.mLoginManager = cp.a(RqdApplication.l());
      }
      if (!this.isQuickLogin) {
        break label185;
      }
    }
    label185:
    for (WloginSimpleInfo localWloginSimpleInfo = this.mLoginManager.c(this.mQuickLoginUin);; localWloginSimpleInfo = this.mLoginManager.c(this.mUin + ""))
    {
      this.mUin = localWloginSimpleInfo._uin;
      h.c("wtlogin info real: real=" + this.mUin);
      h.c("mAqSig=" + this.mAqSig);
      ch.a().a(System.currentTimeMillis(), 206);
      TMSDKContext.saveActionData(1150087);
      if ((do.a().d(Long.valueOf(this.mQuickLoginUin).longValue()) == null) || (this.mPageId == 7)) {
        break;
      }
      h.a("uinhasbind");
      showUserDialog(2131230935, getResources().getString(2131230876), 2131230897, null);
      return;
    }
    localQQUser.mRealUin = this.mUin;
    localQQUser.mIsBinded = false;
    if (localWloginSimpleInfo != null) {
      localQQUser.mNickName = new String(localWloginSimpleInfo._nick);
    }
    this.mAgent.a(localQQUser);
    this.mTokenCore.a(this.mUin, this.mAqSig, this.mHandler, 1);
    this.parseqqsucc = false;
  }
  
  public void cancelRequest()
  {
    this.mTokenCore.a(getClass().getName());
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if (((this.mIsActiveSuccess) || (!this.isCurrentPageChooseWay)) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
      if ((!this.isCurrentPageChooseWay) && (this.mPageId != 7))
      {
        initViewChooseWayToLogin();
        return true;
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
  }
  
  protected void gotoVerifyActivity(QueryCaptchaResult paramQueryCaptchaResult)
  {
    this.queryCaptchaResult = paramQueryCaptchaResult;
    Intent localIntent = new Intent(this, TCaptchaPopupActivity.class);
    if (paramQueryCaptchaResult != null) {
      localIntent.putExtra("appid", paramQueryCaptchaResult.mAppid);
    }
    startActivityForResult(localIntent, 1001);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    label131:
    label143:
    do
    {
      for (;;)
      {
        return;
        if (paramInt1 != 1001) {
          break label143;
        }
        if (paramInt2 != -1) {
          break label131;
        }
        try
        {
          paramIntent = paramIntent.getStringExtra("retJson");
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            paramIntent = new JSONObject(paramIntent);
            if (paramIntent != null) {
              if (paramIntent.getInt("ret") == 0)
              {
                if (this.queryCaptchaResult == null) {
                  continue;
                }
                cw.a().d(this.queryCaptchaResult.mRealUin, this.queryCaptchaResult.mSceneId, paramIntent.getString("ticket"), paramIntent.getString("randstr"), this.mHandler);
              }
            }
          }
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      Toast.makeText(this, "未验证成功", 0).show();
      return;
      Toast.makeText(this, "未验证成功", 0).show();
      return;
    } while ((paramInt1 != 1201) && (paramInt1 != 1202));
    cp.a(getApplicationContext()).a(paramIntent);
    this.mQuickLoginIntenData = paramIntent;
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mLoginManager = cp.a(RqdApplication.l());
    this.mTokenCore = cw.a();
    this.mAgent = do.a();
    paramBundle = getIntent();
    this.mUin = paramBundle.getLongExtra("intent.uin", 0L);
    this.mScanCode = paramBundle.getByteArrayExtra("scancode");
    String str = paramBundle.getStringExtra("qquin");
    if ((this.mUin <= 0L) && (str != null) && (Long.parseLong(str) > 0L)) {
      this.mUin = Long.parseLong(str);
    }
    this.mPageId = paramBundle.getIntExtra("page_id", 0);
    initViewChooseWayToLogin();
    TMSDKContext.saveActionData(1150086);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    abi.c();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.isshowing = false;
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.isshowing = true;
    this.mHandler.postDelayed(new afz(this), 100L);
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new afv(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.WtLoginAccountInput
 * JD-Core Version:    0.7.0.1
 */