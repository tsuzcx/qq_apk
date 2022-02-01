package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.sc;

public class StartPwdUpdateInfoActivity
  extends BaseActivity
{
  public static int SOURCE_FROM_PSW_MANAGER = 0;
  public static String SOURCE_TO_START_PSW = "source_to_start_psw";
  private Button mButtonCreate;
  private Button mButtonSkip;
  private Button mTitleButton;
  private int source = -1;
  
  private void initUI()
  {
    this.mButtonCreate.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(StartPwdUpdateInfoActivity.this, StartPwdGestureModifyActivity.class);
        if (StartPwdUpdateInfoActivity.this.source == StartPwdUpdateInfoActivity.SOURCE_FROM_PSW_MANAGER) {
          paramAnonymousView.putExtra(StartPwdUpdateInfoActivity.SOURCE_TO_START_PSW, StartPwdUpdateInfoActivity.SOURCE_FROM_PSW_MANAGER);
        }
        StartPwdUpdateInfoActivity.this.startActivityForResult(paramAnonymousView, 258);
        if (StartPwdUpdateInfoActivity.this.source == StartPwdUpdateInfoActivity.SOURCE_FROM_PSW_MANAGER) {
          StartPwdUpdateInfoActivity.this.finish();
        }
      }
    });
    this.mButtonSkip.setVisibility(4);
    this.mTitleBar.setBackgroundColor(getResources().getColor(2130968773));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2130968789));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2131099762));
    this.mTitleText.setTextColor(getResources().getColor(2130968761));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 258) && ((paramInt2 == 259) || (sc.a().d())))
    {
      showOrangeToast(2131493236, 2131100170);
      setResult(259);
      startActivity(new Intent(this, StartPwdGestureSelActivity.class));
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2131296453);
    this.source = getIntent().getIntExtra(SOURCE_TO_START_PSW, -1);
    this.mButtonCreate = ((Button)findViewById(2131166207));
    this.mButtonSkip = ((Button)findViewById(2131166211));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdUpdateInfoActivity
 * JD-Core Version:    0.7.0.1
 */