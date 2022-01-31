package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;

public class WtloginFinishNoMibaoActivity
  extends BaseActivity
{
  private TextView mShensuText;
  private Button mSkipButton;
  private long mUin;
  
  private void initView()
  {
    this.mSkipButton = ((Button)findViewById(2131297327));
    this.mShensuText = ((TextView)findViewById(2131297328));
    this.mUin = getIntent().getLongExtra("uin", 0L);
    this.mSkipButton.setOnClickListener(new ahm(this));
    SpannableString localSpannableString = new SpannableString(getResources().getString(2131362357));
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131165262)), localSpannableString.length() - 4, localSpannableString.length(), 33);
    this.mShensuText.setText(localSpannableString);
    this.mShensuText.setOnClickListener(new ahn(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903261);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.WtloginFinishNoMibaoActivity
 * JD-Core Version:    0.7.0.1
 */