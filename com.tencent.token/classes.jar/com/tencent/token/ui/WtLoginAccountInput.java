package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.push.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.p;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;
import com.tencent.token.widget.InputMethodRelativeLayout;
import com.tencent.token.x;

public class WtLoginAccountInput
  extends BaseActivity
{
  private ax mAgent;
  private long mAppid = 523005425L;
  private boolean mAppid1SigOk = false;
  private byte[] mAqSig;
  private CompoundButton.OnCheckedChangeListener mCheckListener = new ahk(this);
  private View.OnClickListener mCompleteButtonListener = new ahh(this);
  private View.OnClickListener mFindPwdListener = new ahj(this);
  private Handler mHandler = new ahb(this);
  boolean mIsActiveSuccess = false;
  private View.OnClickListener mLoginListener = new ahi(this);
  private x mLoginManager;
  private Button mOKButton;
  private int mPageId;
  private String mPasswd;
  private TextView mPasswdDisText;
  private EditText mPasswdEdit;
  private TextView mPasswdHideText;
  private ImageView mQQFace;
  InputMethodRelativeLayout mRootLayout;
  private byte[] mScanCode;
  private String mScanUin;
  View mScrollAreaLayout;
  private af mTokenCore;
  private long mUin;
  private EditText mUinEdit;
  private QQUser mUser;
  private TextView mfindPwdText;
  private long unbindUin;
  
  private void gotoScanLogin()
  {
    Intent localIntent = new Intent(this, ScanLoginAccountListActivity.class);
    this.mScanUin = (this.mUin + "");
    localIntent.putExtra("qquin", this.mScanUin);
    localIntent.putExtra("scancode", this.mScanCode);
    startActivity(localIntent);
    finish();
  }
  
  private void initView()
  {
    if (this.mPageId == 3)
    {
      setContentView(2130903258);
      hideTitle();
      this.mQQFace = ((ImageView)findViewById(2131297305));
      if (this.unbindUin != 0L) {
        showUserDialog(2131361808, getString(2131361841) + Long.toString(this.unbindUin) + getString(2131361906), 2131361800, null);
      }
    }
    Object localObject;
    RelativeLayout localRelativeLayout;
    for (;;)
    {
      if (this.mPageId == 8) {
        p.a().a(System.currentTimeMillis(), 71);
      }
      if (this.mPageId == 6) {
        p.a().a(System.currentTimeMillis(), 72);
      }
      this.mUinEdit = ((EditText)findViewById(2131297309));
      if (this.mUinEdit != null) {
        this.mUinEdit.clearFocus();
      }
      this.mPasswdEdit = ((EditText)findViewById(2131297313));
      this.mOKButton = ((Button)findViewById(2131297317));
      this.mOKButton.setOnClickListener(this.mLoginListener);
      if (this.mUin != 0L)
      {
        this.mUinEdit.setText(this.mUin + "");
        this.mUinEdit.setEnabled(false);
        setHeadImage(this.mUin);
      }
      if (this.mScanUin != null)
      {
        this.mUinEdit.setText(this.mScanUin);
        this.mUinEdit.setEnabled(false);
        setHeadImage(Long.parseLong(this.mScanUin));
      }
      this.mfindPwdText = ((TextView)findViewById(2131297318));
      this.mfindPwdText.setOnClickListener(this.mFindPwdListener);
      this.mRootLayout = ((InputMethodRelativeLayout)findViewById(2131297304));
      this.mScrollAreaLayout = findViewById(2131296815);
      this.mRootLayout.a = new ahl(this);
      localObject = (SwitchButton)findViewById(2131297314);
      ((SwitchButton)localObject).a(true, false);
      ((SwitchButton)localObject).setOnCheckedChangeListener(this.mCheckListener);
      this.mPasswdDisText = ((TextView)findViewById(2131297315));
      this.mPasswdHideText = ((TextView)findViewById(2131297316));
      return;
      setContentView(2130903259);
      localObject = (TextView)findViewById(2131297319);
      localRelativeLayout = (RelativeLayout)findViewById(2131297307);
      if ((this.mPageId != 6) && (this.mPageId != 5) && (this.mPageId != 9)) {
        break label532;
      }
      ((TextView)localObject).setVisibility(0);
      if (this.mPageId == 5)
      {
        ((TextView)localObject).setText(2131362067);
      }
      else
      {
        if (this.mPageId != 9) {
          break;
        }
        ((TextView)localObject).setText(2131362555);
        ((TextView)localObject).setTextColor(-65536);
        setTitle(2131362556);
      }
    }
    ((TextView)localObject).setText(2131362358);
    for (;;)
    {
      setTitle(2131362347);
      break;
      label532:
      ((TextView)localObject).setVisibility(8);
      ((ViewGroup.MarginLayoutParams)localRelativeLayout.getLayoutParams()).topMargin = ((int)(26.0F * IndexActivity.S_DENSITY));
      if (this.mPageId != 8) {
        if (this.mPageId != 7) {
          break;
        }
      }
    }
  }
  
  private void judgeNextStep()
  {
    this.mAgent.b(this.mUin);
    ax.a().f(this.mUin);
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
    if (this.mPageId == 8)
    {
      finish();
      return;
    }
    if (this.mPageId == 9)
    {
      com.tencent.token.bj.a = 1;
      finish();
      return;
    }
    af.a().a(this.mUser.mRealUin, this.mAqSig, this.mHandler);
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = ag.c();
    ((ag)localObject).i();
    ((ag)localObject).n();
    localObject = this.mUser.mRealUin + "";
    this.mIsActiveSuccess = true;
    setContentView(2130903050);
    this.mBackArrow.setVisibility(4);
    setTitle(2131361842);
    ax.a().f(Long.parseLong((String)localObject));
    ((Button)findViewById(2131296398)).setOnClickListener(this.mCompleteButtonListener);
    ((ImageView)findViewById(2131296395)).setImageDrawable(k.a((String)localObject, s.f(Long.parseLong((String)localObject)) + " "));
    a.a().a(8);
  }
  
  private void setHeadImage(long paramLong)
  {
    if (this.mQQFace != null)
    {
      QQUser localQQUser = ax.a().d(paramLong);
      if (localQQUser != null) {
        this.mQQFace.setImageDrawable(k.a(localQQUser.mRealUin + "", localQQUser.mUin + ""));
      }
    }
  }
  
  private void showKeyBoard(View paramView)
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(paramView, 0);
  }
  
  private void showShensuDialog()
  {
    Intent localIntent = new Intent(this, WtloginFinishNoMibaoActivity.class);
    localIntent.putExtra("uin", this.mUser.mRealUin);
    startActivity(localIntent);
  }
  
  private void showUpgradeDeterminResult(UpgradeDeterminResult paramUpgradeDeterminResult)
  {
    int j = 1;
    if (isFinishing()) {}
    QQUser localQQUser;
    do
    {
      return;
      localQQUser = ax.a().e();
    } while (localQQUser == null);
    Intent localIntent;
    if (paramUpgradeDeterminResult.a() == 1)
    {
      if (paramUpgradeDeterminResult.mMobileAppear == 1) {}
      for (int i = 1; i != 0; i = 0)
      {
        localIntent = new Intent(this, NetActiveVryMobileNoSmsActivity.class);
        localIntent.putExtra("intent.qquser", localQQUser);
        localIntent.putExtra("page_id", this.mPageId);
        localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
        startActivity(localIntent);
        return;
      }
      if (paramUpgradeDeterminResult.mQqtokenAppear == 1)
      {
        i = 1;
        if (i == 0)
        {
          if (paramUpgradeDeterminResult.mQuesAppear != 1) {
            break label205;
          }
          i = 1;
          label128:
          if (i == 0) {
            if (paramUpgradeDeterminResult.mHaveMobile != 1) {
              break label210;
            }
          }
        }
      }
      label205:
      label210:
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label215;
        }
        localIntent = new Intent(this, NetActiveVryOtherListActivity.class);
        localIntent.putExtra("intent.qquser", localQQUser);
        localIntent.putExtra("page_id", this.mPageId);
        localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
        startActivity(localIntent);
        return;
        i = 0;
        break;
        i = 0;
        break label128;
      }
      label215:
      showShensuDialog();
      return;
    }
    if ((paramUpgradeDeterminResult.a() == 2) || (paramUpgradeDeterminResult.a() == 3))
    {
      localIntent = new Intent(this, NetActiveSetDirBySeqActivity.class);
      localIntent.putExtra("intent.qquser", localQQUser);
      localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
      localIntent.putExtra("bindType", paramUpgradeDeterminResult.a());
      startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 4)
    {
      setContentView(2130903061);
      findViewById(2131296458).setOnClickListener(new ahf(this, localQQUser, paramUpgradeDeterminResult));
      findViewById(2131296459).setOnClickListener(new ahg(this, paramUpgradeDeterminResult, localQQUser));
      return;
    }
    if (paramUpgradeDeterminResult.a() == 5)
    {
      af.a().c(localQQUser.mRealUin, 5, "", "", this.mHandler);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 6)
    {
      localIntent = new Intent(this, VerifyMobilePhoneActivity.class);
      localIntent.putExtra("intent.qquser", localQQUser);
      localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
      startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 8)
    {
      localIntent = new Intent(this, RealNameStep0VerifyMobileActivity.class);
      localIntent.putExtra("source_id", 2);
      localIntent.putExtra("real_uin", localQQUser.mRealUin);
      localIntent.putExtra("realname_mobile", paramUpgradeDeterminResult.mMobileMask);
      localIntent.putExtra("scene_id", 1002);
      startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 9)
    {
      localIntent = new Intent(this, RealNameStep0VerifyMobileActivity.class);
      localIntent.putExtra("source_id", 2);
      localIntent.putExtra("real_uin", localQQUser.mRealUin);
      localIntent.putExtra("ish5zzb", true);
      localIntent.putExtra("realname_mobile", paramUpgradeDeterminResult.mMobileMask);
      localIntent.putExtra("scene_id", 1002);
      startActivity(localIntent);
      return;
    }
    showShensuDialog();
  }
  
  public void cancelRequest()
  {
    this.mTokenCore.a(getClass().getName());
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.mIsActiveSuccess) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.mPageId == 9)
    {
      exit();
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mLoginManager = x.a(RqdApplication.i());
    this.mTokenCore = af.a();
    this.mAgent = ax.a();
    paramBundle = getIntent();
    this.mUin = paramBundle.getLongExtra("intent.uin", 0L);
    this.mScanCode = paramBundle.getByteArrayExtra("scancode");
    this.mScanUin = paramBundle.getStringExtra("qquin");
    this.mPageId = paramBundle.getIntExtra("page_id", 0);
    this.unbindUin = paramBundle.getLongExtra("unbindUin", 0L);
    this.mAppid = 523005425L;
    initView();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.mAppid = 523005425L;
    this.mAppid1SigOk = false;
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new ahe(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.WtLoginAccountInput
 * JD-Core Version:    0.7.0.1
 */