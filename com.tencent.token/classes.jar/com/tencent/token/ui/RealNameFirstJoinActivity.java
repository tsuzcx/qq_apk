package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.RealNameStatusResult;

public class RealNameFirstJoinActivity
  extends Activity
{
  RealNameStatusResult mResult;
  
  private void initView()
  {
    setContentView(2131296349);
    Button localButton = (Button)findViewById(2131165519);
    TextView localTextView1 = (TextView)findViewById(2131165517);
    Object localObject = this.mResult;
    if (localObject != null)
    {
      localTextView1.setText(String.valueOf(((RealNameStatusResult)localObject).reg_rank));
    }
    else
    {
      localObject = (TextView)findViewById(2131166120);
      TextView localTextView2 = (TextView)findViewById(2131166121);
      ((TextView)localObject).setText(2131492928);
      localTextView2.setVisibility(8);
      localTextView1.setVisibility(8);
    }
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        RealNameFirstJoinActivity.this.setResult(1);
        RealNameFirstJoinActivity.this.finish();
      }
    });
    ((ImageView)findViewById(2131165396)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        RealNameFirstJoinActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTheme(2131558673);
    this.mResult = ((RealNameStatusResult)getIntent().getSerializableExtra("result"));
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameFirstJoinActivity
 * JD-Core Version:    0.7.0.1
 */