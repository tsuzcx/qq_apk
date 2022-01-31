package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.cp;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;

public class CommonVerifyActivity
  extends BaseActivity
{
  private Button btn;
  private String functionName;
  private byte[] mAqSig;
  private View.OnClickListener mCompleteButtonListener = new cs(this);
  private Handler mHandler = new co(this);
  private boolean mIsActiveSuccess = false;
  private int mType = 1;
  private long mUin;
  private UpgradeDeterminResult mUpDetermin;
  private TextView tv_content;
  private TextView tv_title;
  
  private void goToWtLoginAccountInput()
  {
    if (do.a().e() == null) {
      return;
    }
    gotoQuickLoginWb();
  }
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void judgeNextStep() {}
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = cx.c();
    ((cx)localObject).i();
    ((cx)localObject).n();
    localObject = new Intent(this, VerifySuccActivity.class);
    ((Intent)localObject).putExtra("mRealUin", this.mUin);
    startActivity((Intent)localObject);
    finish();
  }
  
  private void verfifyQQ()
  {
    Object localObject = do.a().e();
    if (localObject == null) {
      return;
    }
    localObject = "" + ((QQUser)localObject).mRealUin;
    cp localcp = cp.a(RqdApplication.l());
    if (!localcp.b((String)localObject, 523005419L))
    {
      localcp.a((String)localObject, this.mHandler, 523005419L);
      showProDialog(this, 2131230843, 2131231298, null);
      this.mType = 1;
      return;
    }
    showUserDialog(2131231654, getResources().getString(2131231653), 2131230897, new cr(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    setContentView(2130968629);
    if (paramBundle != null) {
      this.mUin = paramBundle.mRealUin;
    }
    this.functionName = getIntent().getStringExtra("name");
    if (TextUtils.isEmpty(this.functionName))
    {
      finish();
      return;
    }
    this.tv_title = ((TextView)findViewById(2131558756));
    paramBundle = String.format(getString(2131230895), new Object[] { this.functionName });
    this.tv_title.setText(paramBundle);
    this.tv_content = ((TextView)findViewById(2131558757));
    paramBundle = String.format(getString(2131230894), new Object[] { this.functionName });
    this.tv_content.setText(paramBundle);
    this.btn = ((Button)findViewById(2131558758));
    this.btn.setOnClickListener(new cn(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    abi.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.CommonVerifyActivity
 * JD-Core Version:    0.7.0.1
 */