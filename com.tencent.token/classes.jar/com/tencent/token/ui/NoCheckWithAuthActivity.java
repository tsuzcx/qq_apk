package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.push.a;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;

public class NoCheckWithAuthActivity
  extends BaseActivity
{
  private boolean bindMobileSucc;
  private boolean bindTokenSucc = false;
  private View.OnClickListener mCompleteButtonListener = new si(this);
  private Handler mHandler = new sf(this);
  private boolean mIsActiveSuccess = false;
  private UpgradeDeterminResult mUpDetermin = null;
  private QQUser mUser = null;
  
  private void init()
  {
    findViewById(2131296458).setOnClickListener(new sg(this));
    findViewById(2131296459).setOnClickListener(new sh(this));
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
    ax.a().f(this.mUser.mRealUin);
    ((Button)findViewById(2131296398)).setOnClickListener(this.mCompleteButtonListener);
    ((ImageView)findViewById(2131296395)).setImageDrawable(k.a(this.mUser.mRealUin + "", s.f(this.mUser.mRealUin) + " "));
    a.a().a(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.bindTokenSucc = getIntent().getBooleanExtra("bindTokenSucc", false);
    this.bindMobileSucc = getIntent().getBooleanExtra("bindMobileSucc", false);
    if (this.bindTokenSucc)
    {
      setActiveSucc(this.bindMobileSucc);
      return;
    }
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
    if ((this.mUser == null) || (this.mUpDetermin == null))
    {
      finish();
      return;
    }
    setContentView(2130903061);
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NoCheckWithAuthActivity
 * JD-Core Version:    0.7.0.1
 */