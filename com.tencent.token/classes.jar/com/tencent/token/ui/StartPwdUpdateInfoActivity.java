package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.cy;

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
    this.mButtonCreate.setOnClickListener(new aaq(this));
    this.mButtonSkip.setVisibility(4);
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131493039));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2131493053));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837617));
    this.mTitleText.setTextColor(getResources().getColor(2131493027));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 258) && ((paramInt2 == 259) || (cy.a().d())))
    {
      showOrangeToast(2131231093, 2130838018);
      setResult(259);
      startActivity(new Intent(this, StartPwdGestureSelActivity.class));
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130968771);
    this.source = getIntent().getIntExtra(SOURCE_TO_START_PSW, -1);
    this.mButtonCreate = ((Button)findViewById(2131559295));
    this.mButtonSkip = ((Button)findViewById(2131559296));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdUpdateInfoActivity
 * JD-Core Version:    0.7.0.1
 */