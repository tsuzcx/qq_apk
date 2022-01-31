package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.af;

public class LoginMsgIpShareActivity
  extends BaseActivity
{
  public Handler mHandler = new oj(this);
  private Button mIpShareBtn;
  private TextView mIpShareDesc;
  private TextView mIpShareTitle;
  private int mPosition;
  
  private void init()
  {
    this.mPosition = getIntent().getExtras().getInt("position");
    this.mIpShareTitle = ((TextView)findViewById(2131296777));
    this.mIpShareDesc = ((TextView)findViewById(2131296778));
    this.mIpShareBtn = ((Button)findViewById(2131296779));
    this.mIpShareBtn.setOnClickListener(new ok(this));
    af.a().c(this.mHandler);
  }
  
  public void cancelRequest()
  {
    af.a().a(getClass().getName());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903124);
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.LoginMsgIpShareActivity
 * JD-Core Version:    0.7.0.1
 */