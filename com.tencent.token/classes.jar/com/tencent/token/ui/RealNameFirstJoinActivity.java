package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.core.bean.RealNameStatusResult;

public class RealNameFirstJoinActivity
  extends Activity
{
  RealNameStatusResult mResult;
  
  private void initView()
  {
    setContentView(2130903101);
    Button localButton = (Button)findViewById(2131296633);
    TextView localTextView1 = (TextView)findViewById(2131296631);
    if (this.mResult != null) {
      localTextView1.setText(String.valueOf(this.mResult.reg_rank));
    }
    for (;;)
    {
      localButton.setOnClickListener(new vl(this));
      return;
      TextView localTextView2 = (TextView)findViewById(2131296630);
      TextView localTextView3 = (TextView)findViewById(2131296632);
      localTextView2.setText(2131362801);
      localTextView3.setVisibility(8);
      localTextView1.setVisibility(8);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mResult = ((RealNameStatusResult)getIntent().getSerializableExtra("result"));
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameFirstJoinActivity
 * JD-Core Version:    0.7.0.1
 */