package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.az;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.x;

public class ScanLoginBindActivity
  extends BaseActivity
{
  private final long mAppid = 523005425L;
  private byte[] mAqSig;
  ImageView mBindIcon;
  TextView mBindInfo;
  Button mCompleteBtn;
  public Handler mHandler = new yu(this);
  String mQQUin;
  x mScanLoginManager;
  private final int mType = 2;
  Button mVerifyBtn;
  private View.OnClickListener mVerifyListener = new ys(this);
  
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
  
  private void initUI()
  {
    az localaz = ax.a().c(this.mQQUin);
    setContentView(2130903188);
    this.mBindInfo = ((TextView)findViewById(2131297025));
    this.mCompleteBtn = ((Button)findViewById(2131297028));
    this.mVerifyBtn = ((Button)findViewById(2131297027));
    this.mBindIcon = ((ImageView)findViewById(2131297024));
    if ((localaz != null) && (localaz.d))
    {
      this.mBindInfo.setText(2131362451);
      this.mBindIcon.setImageResource(2130837570);
    }
    for (;;)
    {
      this.mCompleteBtn.setOnClickListener(new yw(this));
      this.mVerifyBtn.setOnClickListener(this.mVerifyListener);
      return;
      if ((localaz != null) && (localaz.c))
      {
        this.mBindInfo.setText(2131362086);
        this.mBindIcon.setImageResource(2130837570);
      }
    }
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
      findViewById(2131296458).setOnClickListener(new yx(this, localQQUser, paramUpgradeDeterminResult));
      findViewById(2131296459).setOnClickListener(new yy(this, paramUpgradeDeterminResult, localQQUser));
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
      localIntent.putExtra("ish5zzb", true);
      localIntent.putExtra("real_uin", localQQUser.mRealUin);
      localIntent.putExtra("realname_mobile", paramUpgradeDeterminResult.mMobileMask);
      localIntent.putExtra("scene_id", 1002);
      startActivity(localIntent);
      return;
    }
    showShensuDialog();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mScanLoginManager = x.a(RqdApplication.i());
    this.mQQUin = getIntent().getStringExtra("qquin");
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ScanLoginBindActivity
 * JD-Core Version:    0.7.0.1
 */