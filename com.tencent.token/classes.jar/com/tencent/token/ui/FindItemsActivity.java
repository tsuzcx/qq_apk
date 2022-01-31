package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.token.core.bean.JLProtectionInfo;

public class FindItemsActivity
  extends BaseActivity
{
  private RelativeLayout jianlingLayout;
  private Handler mHandler = new kn(this);
  private JLProtectionInfo mInfo;
  private Button mTitleButton;
  
  private void initRightButton()
  {
    this.mTitleButton = getRightTitleButton();
    this.mTitleButton.setVisibility(0);
    this.mTitleButton.setText(2131362761);
    this.mTitleButton.setTextColor(getResources().getColor(2131165336));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTitleButton.getLayoutParams();
    localLayoutParams.setMargins(0, 0, (int)getResources().getDisplayMetrics().density * 20, 0);
    this.mTitleButton.setLayoutParams(localLayoutParams);
    this.mTitleButton.setOnClickListener(new kr(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903099);
    initRightButton();
    this.jianlingLayout = ((RelativeLayout)findViewById(2131296626));
    this.jianlingLayout.setOnClickListener(new kq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FindItemsActivity
 * JD-Core Version:    0.7.0.1
 */