package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ah;

public class StartPwdUpdateInfoActivity
  extends BaseActivity
{
  private Button mButtonCreate;
  private Button mButtonSkip;
  
  private void initUI()
  {
    this.mButtonCreate.setOnClickListener(new acg(this));
    this.mButtonSkip.setVisibility(4);
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131165236));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2131165298));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837537));
    this.mTitleText.setTextColor(getResources().getColor(2131165297));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 258) && ((paramInt2 == 259) || (ah.a().d())))
    {
      showOrangeToast(2131362153, 2130837966);
      setResult(259);
      startActivity(new Intent(this, StartPwdGestureSelActivity.class));
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130903209);
    this.mButtonCreate = ((Button)findViewById(2131297134));
    this.mButtonSkip = ((Button)findViewById(2131297135));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdUpdateInfoActivity
 * JD-Core Version:    0.7.0.1
 */