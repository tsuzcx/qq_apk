package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.view.View;
import com.tencent.token.ch;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItemDetail;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.w;

public class FaceChangeMobileActivity
  extends BaseActivity
{
  private String A2;
  private Handler.Callback callback = new ep(this);
  private View changepsw;
  private Handler handler = new eq(this);
  private View mDivider;
  private View mDivider2;
  private boolean mIsChecked = false;
  private SwitchButton mSwitchVerifySet;
  private boolean on;
  private int scene_id;
  private boolean verify_psw;
  
  private void goToDifferentMbActivity(MbInfoResult.MbInfoItem paramMbInfoItem, int paramInt)
  {
    if (paramMbInfoItem.mId == 51)
    {
      if ((paramMbInfoItem.mDetail.mBtnType == 3) && (paramMbInfoItem.mDetail.mBtnStatus == 1))
      {
        ch.a().a(System.currentTimeMillis(), 200);
        Intent localIntent = new Intent(this, UtilsModSetMobileStep1Activity.class);
        localIntent.putExtra("title", getResources().getString(2131231428) + paramMbInfoItem.mName);
        localIntent.putExtra("op_type", 3);
        localIntent.putExtra("position", paramInt);
        pg.a().b(this, localIntent, 0);
      }
    }
    else {
      return;
    }
    paramMbInfoItem = new Intent(this, UtilsMbInfoItemActivity.class);
    paramMbInfoItem.putExtra("position", paramInt);
    startActivityForResult(paramMbInfoItem, 0);
  }
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.handler, "" + localQQUser.b());
  }
  
  private void initView()
  {
    this.mDivider = findViewById(2131558836);
    this.mDivider2 = findViewById(2131558841);
    this.mSwitchVerifySet = ((SwitchButton)findViewById(2131558834));
    this.changepsw = findViewById(2131558837);
    this.changepsw.setOnClickListener(new ek(this));
    h.a("mIsChecked" + this.mIsChecked);
    SwitchButton localSwitchButton = this.mSwitchVerifySet;
    boolean bool;
    if (!this.mIsChecked)
    {
      bool = true;
      localSwitchButton.a(bool, false);
      this.mSwitchVerifySet.postInvalidate();
      this.mSwitchVerifySet.setOnCheckedChangeListener(new el(this));
      if (!this.mIsChecked) {
        break label191;
      }
      this.changepsw.setVisibility(0);
      this.mDivider.setVisibility(0);
      this.mDivider2.setVisibility(0);
    }
    for (;;)
    {
      if (this.verify_psw)
      {
        showProDialog(this, 2131230843, 2131231030, null);
        this.scene_id = 5;
        setOnOf(false);
      }
      return;
      bool = false;
      break;
      label191:
      this.changepsw.setVisibility(4);
      this.mDivider.setVisibility(4);
      this.mDivider2.setVisibility(4);
    }
  }
  
  private void judgeNextStep() {}
  
  private void setOnOf(boolean paramBoolean)
  {
    QQUser localQQUser = do.a().e();
    if (localQQUser == null) {}
    do
    {
      return;
      this.on = paramBoolean;
      this.mUin = localQQUser.mRealUin;
      if ((this.A2 != null) && (this.A2.length() > 0))
      {
        cw.a().a(0L, this.scene_id, paramBoolean, this.A2, this.handler);
        return;
      }
    } while (localQQUser == null);
    byte[] arrayOfByte = cp.a(RqdApplication.l()).b(localQQUser.mRealUin);
    if (arrayOfByte != null)
    {
      this.A2 = w.a(arrayOfByte);
      cw.a().a(0L, this.scene_id, paramBoolean, this.A2, this.handler);
      return;
    }
    cp.a(RqdApplication.l()).a("" + localQQUser.mRealUin, this.handler, 523005419L, 64);
  }
  
  private void showGesturePwdDialog()
  {
    if (!cy.a().c()) {
      showUserDialog(2131230994, getString(2131230991), 2131230993, 2131230992, new es(this), null);
    }
  }
  
  public void getA2Succ()
  {
    this.A2 = w.a(this.mAqSig);
    setOnOf(this.on);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 0) {
      if (paramInt2 == -1)
      {
        showProDialog(this, 2131230843, 2131231030, null);
        this.scene_id = 4;
        setOnOf(false);
      }
    }
    while ((paramInt1 != 1201) && (paramInt1 != 1202)) {
      return;
    }
    cp.a(getApplicationContext()).a(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mIsChecked = getIntent().getBooleanExtra("open_switch", false);
    this.verify_psw = getIntent().getBooleanExtra("verify_psw", false);
    setContentView(2130968645);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceChangeMobileActivity
 * JD-Core Version:    0.7.0.1
 */