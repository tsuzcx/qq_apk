package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.token.af;

public class SettingSubmitCommentActivity
  extends BaseActivity
{
  private String comment = "";
  private EditText mCommentEdit;
  private Handler mHandler = new zz(this);
  private Button mMenuBarBtn;
  private af mTokenCore = af.a();
  
  public void cancelRequest()
  {
    this.mTokenCore.a(getClass().getName());
  }
  
  public void checkMenuBtnEnable()
  {
    if ((this.mCommentEdit.getText().toString() == null) || (this.mCommentEdit.getText().toString().length() == 0))
    {
      this.mMenuBarBtn.setClickable(false);
      this.mMenuBarBtn.setTextColor(getResources().getColor(2131165214));
      return;
    }
    this.mMenuBarBtn.setClickable(true);
    this.mMenuBarBtn.setTextColor(getResources().getColor(2131165223));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903196);
    this.mCommentEdit = ((EditText)findViewById(2131297088));
    if (this.mCommentEdit != null) {
      this.mCommentEdit.clearFocus();
    }
    this.mMenuBarBtn = ((Button)findViewById(2131297148));
    this.mMenuBarBtn.setVisibility(0);
    this.mMenuBarBtn.setText(getResources().getString(2131361807));
    this.mMenuBarBtn.setOnClickListener(new aaa(this));
    this.mCommentEdit.addTextChangedListener(new aab(this));
    checkMenuBtnEnable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SettingSubmitCommentActivity
 * JD-Core Version:    0.7.0.1
 */