package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.view.View;
import com.tencent.token.af;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.s;
import com.tencent.token.x;

public class FaceChangePwdIndexActivity
  extends BaseActivity
{
  private String A2;
  private Handler.Callback callback = new dw(this);
  private View changepsw;
  private Handler handler = new dx(this);
  private View mDivider;
  private View mDivider2;
  private boolean mIsChecked = false;
  private SwitchButton mSwitchVerifySet;
  private boolean on;
  private int scene_id;
  private boolean verify_psw;
  
  private void initView()
  {
    this.mDivider = findViewById(2131296550);
    this.mDivider2 = findViewById(2131296555);
    this.mSwitchVerifySet = ((SwitchButton)findViewById(2131296548));
    this.changepsw = findViewById(2131296551);
    this.changepsw.setOnClickListener(new dr(this));
    e.a("mIsChecked" + this.mIsChecked);
    SwitchButton localSwitchButton = this.mSwitchVerifySet;
    boolean bool;
    if (!this.mIsChecked)
    {
      bool = true;
      localSwitchButton.a(bool, false);
      this.mSwitchVerifySet.postInvalidate();
      this.mSwitchVerifySet.setOnCheckedChangeListener(new ds(this));
      if (!this.mIsChecked) {
        break label189;
      }
      this.changepsw.setVisibility(0);
      this.mDivider.setVisibility(0);
      this.mDivider2.setVisibility(0);
    }
    for (;;)
    {
      if (this.verify_psw)
      {
        showProDialog(this, 2131361808, 2131362485, null);
        this.scene_id = 2;
        setOnOf(false);
      }
      return;
      bool = false;
      break;
      label189:
      this.changepsw.setVisibility(4);
      this.mDivider.setVisibility(4);
      this.mDivider2.setVisibility(4);
    }
  }
  
  private void setOnOf(boolean paramBoolean)
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null) {}
    do
    {
      return;
      this.on = paramBoolean;
      this.mUin = localQQUser.mRealUin;
      if ((this.A2 != null) && (this.A2.length() > 0))
      {
        af.a().a(0L, this.scene_id, paramBoolean, this.A2, this.handler);
        return;
      }
    } while (localQQUser == null);
    byte[] arrayOfByte = x.a(RqdApplication.i()).a(localQQUser.mRealUin);
    if (arrayOfByte != null)
    {
      this.A2 = s.a(arrayOfByte);
      af.a().a(0L, this.scene_id, paramBoolean, this.A2, this.handler);
      return;
    }
    x.a(RqdApplication.i()).a(this, "" + localQQUser.mRealUin, this.fHandler, true);
  }
  
  private void showGesturePwdDialog()
  {
    if (!ah.a().c()) {
      showUserDialog(2131362130, getString(2131362131), 2131362132, 2131362133, new dy(this), null);
    }
  }
  
  public void getA2Succ()
  {
    this.A2 = s.a(this.mAqSig);
    setOnOf(this.on);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      showProDialog(this, 2131361808, 2131362485, null);
      this.scene_id = 1;
      setOnOf(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mIsChecked = getIntent().getBooleanExtra("open_switch", false);
    this.verify_psw = getIntent().getBooleanExtra("verify_psw", false);
    setContentView(2130903080);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceChangePwdIndexActivity
 * JD-Core Version:    0.7.0.1
 */