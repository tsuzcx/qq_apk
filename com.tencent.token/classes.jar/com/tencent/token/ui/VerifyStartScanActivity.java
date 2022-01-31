package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qbardemo.MainActivity;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.CameraPrepareDialog;
import com.tencent.token.ui.base.dt;

public class VerifyStartScanActivity
  extends BaseActivity
{
  private CameraPrepareDialog mCameraDialog;
  private dt mScanTipView;
  private int mSource;
  
  private void gotoScan()
  {
    this.mCameraDialog = new CameraPrepareDialog(this);
    this.mCameraDialog.show();
    Intent localIntent = new Intent(this, MainActivity.class);
    localIntent.putExtra("source_from", this.mSource);
    startActivity(localIntent);
    finish();
  }
  
  private void initView()
  {
    View localView = new View(this);
    localView.setBackgroundColor(-16777216);
    setContentView(localView);
    if (!g.a(this.mSource))
    {
      gotoScan();
      setRightTitleImage(2130837951, new agm(this));
      return;
    }
    this.mScanTipView = new dt(this, this.mSource);
    this.mScanTipView.a(new agn(this));
    addContentView(this.mScanTipView);
    if (this.mSource == 0)
    {
      this.mTitleBar.setBackgroundColor(getResources().getColor(2131165236));
      this.mTitleDivider.setBackgroundColor(getResources().getColor(2131165298));
    }
    for (;;)
    {
      this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837538));
      this.mTitleText.setTextColor(getResources().getColor(2131165297));
      return;
      setTitle(getResources().getString(2131362756));
      this.mTitleBar.setBackgroundColor(getResources().getColor(2131165336));
      this.mTitleDivider.setVisibility(8);
    }
  }
  
  protected void dismissCameraDialog()
  {
    if (this.mCameraDialog != null)
    {
      this.mCameraDialog.dismiss();
      this.mCameraDialog = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mSource = getIntent().getIntExtra("source_from", 0);
    initView();
  }
  
  public void onPause()
  {
    super.onPause();
    dismissCameraDialog();
  }
  
  protected void onResume()
  {
    super.onResume();
    dismissCameraDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.VerifyStartScanActivity
 * JD-Core Version:    0.7.0.1
 */