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
import com.tencent.token.sw;
import com.tencent.token.xv;

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
      return 2131493645;
    }
    return 2131493041;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.mTokenPwdInpuText;
    if (paramView != null) {
      paramView.clearFocus();
    }
    if (sw.a().a(this.mTokenPwdInpuText.getText().toString()))
    {
      hideKeyBoard();
      paramView = new StringBuilder("verify_token_pwd: ");
      paramView.append(this.mEnterType);
      xv.a(paramView.toString());
      setResult(257);
      finish();
      return;
    }
    showToast(2131493649);
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
    setContentView(2131296511);
    paramBundle = findViewById(2131165343);
    paramBundle.setOnClickListener(this);
    ((Button)paramBundle).setText(getBtnStringId());
    setBtnWidth(paramBundle.getLayoutParams());
    this.mTokenPwdInpuText = ((EditText)findViewById(2131166119));
    paramBundle = this.mTokenPwdInpuText;
    if (paramBundle != null) {
      paramBundle.clearFocus();
    }
    paramBundle = new StringBuilder("verify_token_pwd: ");
    paramBundle.append(this.mEnterType);
    paramBundle.append(", uin: ");
    paramBundle.append(this.mUin);
    xv.a(paramBundle.toString());
  }
  
  protected void setBtnWidth(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (1 == this.mEnterType) {
      paramLayoutParams.width = ((int)getResources().getDimension(2131034192));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdDigitVerifyActivity
 * JD-Core Version:    0.7.0.1
 */