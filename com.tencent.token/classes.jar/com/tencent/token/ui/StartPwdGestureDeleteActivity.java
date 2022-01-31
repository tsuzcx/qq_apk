package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.LockPatternVerifyView;
import com.tencent.token.ui.base.bz;
import com.tencent.token.utils.s;

public class StartPwdGestureDeleteActivity
  extends BaseActivity
{
  private Handler mHandler = new aaz(this);
  private bz mListener = new aba(this);
  
  private void showNobindingAlert(Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131361808, getString(paramInt1), paramInt2, 2131361804, new abe(this, paramContext), null);
    }
  }
  
  public void finish()
  {
    super.finish();
    s.a(this, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    e.c("verify gesture: resultCode=" + paramInt2 + ", requestCode=" + paramInt1);
    if ((paramInt1 == 256) && (paramInt2 == 257))
    {
      setResult(35);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130903203);
    ((ViewStub)findViewById(2131297157)).inflate();
    paramBundle = (LockPatternVerifyView)findViewById(2131297301);
    paramBundle.a(this.mListener);
    paramBundle.a(2);
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131165236));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2131165298));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837537));
    this.mTitleText.setTextColor(getResources().getColor(2131165297));
  }
  
  public void pwdIsDelete()
  {
    setResult(257);
    new Handler().post(new abd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureDeleteActivity
 * JD-Core Version:    0.7.0.1
 */