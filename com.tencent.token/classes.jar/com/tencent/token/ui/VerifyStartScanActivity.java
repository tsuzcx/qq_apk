package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qbardemo.MainActivity;
import com.tencent.token.global.j;
import com.tencent.token.ui.base.CameraPrepareDialog;
import com.tencent.token.ui.base.dk;

public class VerifyStartScanActivity
  extends BaseActivity
{
  private CameraPrepareDialog mCameraDialog;
  private dk mScanTipView;
  private int mSource;
  
  private void gotoScan()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      afc localafc = new afc(this);
      requestRuntimePermissions(new String[] { "android.permission.CAMERA" }, localafc);
      return;
    }
    gotonext();
  }
  
  private void gotonext()
  {
    this.mCameraDialog = new CameraPrepareDialog(this, 2131362182);
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
    if (!j.a(this.mSource))
    {
      gotoScan();
      setRightTitleImage(2130838011, new afa(this));
      return;
    }
    this.mScanTipView = new dk(this, this.mSource);
    this.mScanTipView.setViewListener(new afb(this));
    addContentView(this.mScanTipView);
    if (this.mSource == 0)
    {
      this.mTitleBar.setBackgroundColor(getResources().getColor(2131493039));
      this.mTitleDivider.setBackgroundColor(getResources().getColor(2131493053));
    }
    for (;;)
    {
      this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837617));
      this.mTitleText.setTextColor(getResources().getColor(2131493027));
      return;
      setTitle(getResources().getString(2131231396));
      this.mTitleBar.setBackgroundColor(getResources().getColor(2131493050));
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