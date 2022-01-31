package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.push.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;
import com.tencent.token.x;

public class CommonVerifyActivity
  extends BaseActivity
{
  private Button btn;
  private String functionName;
  private byte[] mAqSig;
  private View.OnClickListener mCompleteButtonListener = new ch(this);
  private Handler mHandler = new cc(this);
  private boolean mIsActiveSuccess = false;
  private long mUin;
  private UpgradeDeterminResult mUpDetermin;
  private TextView tv_content;
  private TextView tv_title;
  
  private void goToWtLoginAccountInput()
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null) {
      return;
    }
    Intent localIntent = new Intent(this, WtLoginAccountInput.class);
    localIntent.putExtra("page_id", 7);
    localIntent.putExtra("intent.uin", localQQUser.mRealUin);
    startActivity(localIntent);
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    ag localag = ag.c();
    localag.i();
    localag.n();
    this.mIsActiveSuccess = true;
    setContentView(2130903050);
    setBackArrowHide();
    setTitle(2131361842);
    ax.a().f(this.mUin);
    ((Button)findViewById(2131296398)).setOnClickListener(this.mCompleteButtonListener);
    ((ImageView)findViewById(2131296395)).setImageDrawable(k.a(this.mUin + "", s.f(this.mUin) + " "));
    a.a().a(8);
  }
  
  private void showShensuDialog()
  {
    Intent localIntent = new Intent(this, WtloginFinishNoMibaoActivity.class);
    localIntent.putExtra("uin", ax.a().e().mRealUin);
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
        localIntent.putExtra("page_id", 7);
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
            break label193;
          }
          i = 1;
          label122:
          if (i == 0) {
            if (paramUpgradeDeterminResult.mHaveMobile != 1) {
              break label198;
            }
          }
        }
      }
      label193:
      label198:
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label203;
        }
        localIntent = new Intent(this, NetActiveVryOtherListActivity.class);
        localIntent.putExtra("intent.qquser", localQQUser);
        localIntent.putExtra("page_id", 7);
        localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
        startActivity(localIntent);
        return;
        i = 0;
        break;
        i = 0;
        break label122;
      }
      label203:
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
      findViewById(2131296458).setOnClickListener(new cf(this, localQQUser, paramUpgradeDeterminResult));
      findViewById(2131296459).setOnClickListener(new cg(this, paramUpgradeDeterminResult, localQQUser));
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
      localIntent.putExtra("source_id", 3);
      localIntent.putExtra("real_uin", localQQUser.mRealUin);
      localIntent.putExtra("realname_mobile", paramUpgradeDeterminResult.mMobileMask);
      localIntent.putExtra("scene_id", 1002);
      startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 9)
    {
      localIntent = new Intent(this, RealNameStep0VerifyMobileActivity.class);
      localIntent.putExtra("source_id", 3);
      localIntent.putExtra("ish5zzb", true);
      localIntent.putExtra("real_uin", localQQUser.mRealUin);
      localIntent.putExtra("realname_mobile", paramUpgradeDeterminResult.mMobileMask);
      localIntent.putExtra("scene_id", 1002);
      startActivity(localIntent);
      return;
    }
    showShensuDialog();
  }
  
  private void verfifyQQ()
  {
    Object localObject = ax.a().e();
    if (localObject == null) {
      return;
    }
    localObject = "" + ((QQUser)localObject).mRealUin;
    x localx = x.a(RqdApplication.i());
    if (!localx.b((String)localObject, 523005425L))
    {
      localx.a((String)localObject, this.mHandler, 523005425L);
      showProDialog(this, 2131361808, 2131361817, null);
      return;
    }
    showUserDialog(2131362364, getResources().getString(2131362365), 2131361800, new ce(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ax.a().e();
    setContentView(2130903066);
    if (paramBundle != null) {
      this.mUin = paramBundle.mRealUin;
    }
    this.functionName = getIntent().getStringExtra("name");
    if (TextUtils.isEmpty(this.functionName))
    {
      finish();
      return;
    }
    this.tv_title = ((TextView)findViewById(2131296474));
    paramBundle = String.format(getString(2131362191), new Object[] { this.functionName });
    this.tv_title.setText(paramBundle);
    this.tv_content = ((TextView)findViewById(2131296475));
    paramBundle = String.format(getString(2131362192), new Object[] { this.functionName });
    this.tv_content.setText(paramBundle);
    this.btn = ((Button)findViewById(2131296476));
    this.btn.setOnClickListener(new cb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.CommonVerifyActivity
 * JD-Core Version:    0.7.0.1
 */