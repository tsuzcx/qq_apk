package com.tencent.token.ui;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.cw;

public class LoginMsgChangePwdActivity
  extends BaseActivity
{
  private Button mChangePwdBtn;
  private TextView mChangePwdDesc;
  private TextView mChangePwdTitle;
  public Handler mHandler = new nk(this);
  
  private void init()
  {
    this.mChangePwdTitle = ((TextView)findViewById(2131558977));
    this.mChangePwdDesc = ((TextView)findViewById(2131558978));
    this.mChangePwdBtn = ((Button)findViewById(2131558979));
    this.mChangePwdBtn.setOnClickListener(new nl(this));
    cw.a().c(this.mHandler);
  }
  
  public void cancelRequest()
  {
    cw.a().a(getClass().getName());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968680);
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.LoginMsgChangePwdActivity
 * JD-Core Version:    0.7.0.1
 */