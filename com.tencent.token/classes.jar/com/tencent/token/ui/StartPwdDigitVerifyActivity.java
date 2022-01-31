package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.token.cy;
import com.tencent.token.global.h;

public class StartPwdDigitVerifyActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int VERIFY_REASON_DEL_PWD = 3;
  public static final int VERIFY_REASON_DUALMSG = 5;
  public static final int VERIFY_REASON_MODIFY_PWD = 2;
  public static final int VERIFY_REASON_SAFEMSG = 4;
  public static final int VERIFY_REASON_WELCOME = 1;
  int mEnterType = 1;
  EditText mTokenPwdInpuText = null;
  private long mUin = 0L;
  
  private void hideKeyBoard()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
  }
  
  protected int getBtnStringId()
  {
    if (1 == this.mEnterType) {
      return 2131231490;
    }
    return 2131230897;
  }
  
  public void onClick(View paramView)
  {
    if (this.mTokenPwdInpuText != null) {
      this.mTokenPwdInpuText.clearFocus();
    }
    if (cy.a().a(this.mTokenPwdInpuText.getText().toString()))
    {
      hideKeyBoard();
      h.a("verify_token_pwd: " + this.mEnterType);
      setResult(257);
      finish();
      return;
    }
    showToast(2131231494);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getBundleExtra("com.tencent.input_param");
    if (paramBundle != null)
    {
      this.mEnterType = paramBundle.getInt("enter_type");
      this.mUin = paramBundle.getLong("uin");
    }
    setContentView(2130968816);
    paramBundle = findViewById(2131559451);
    paramBundle.setOnClickListener(this);
    ((Button)paramBundle).setText(getBtnStringId());
    setBtnWidth(paramBundle.getLayoutParams());
    this.mTokenPwdInpuText = ((EditText)findViewById(2131559450));
    if (this.mTokenPwdInpuText != null) {
      this.mTokenPwdInpuText.clearFocus();
    }
    h.a("verify_token_pwd: " + this.mEnterType + ", uin: " + this.mUin);
  }
  
  protected void setBtnWidth(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (1 == this.mEnterType) {
      paramLayoutParams.width = ((int)getResources().getDimension(2131296365));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdDigitVerifyActivity
 * JD-Core Version:    0.7.0.1
 */