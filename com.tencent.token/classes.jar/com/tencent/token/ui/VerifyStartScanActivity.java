package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qbardemo.MainActivity;
import com.tencent.token.aay;
import com.tencent.token.ui.base.CameraPrepareDialog;
import com.tencent.token.xy;
import com.tencent.token.yt;
import com.tencent.token.zv;
import com.tencent.token.zv.a;

public class VerifyStartScanActivity
  extends BaseActivity
{
  private CameraPrepareDialog mCameraDialog;
  private zv mScanTipView;
  private int mSource;
  
  private void gotoScan()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      yt local3 = new yt()
      {
        public final void a()
        {
          VerifyStartScanActivity.this.gotonext();
        }
        
        public final void b()
        {
          VerifyStartScanActivity.this.gotonext();
        }
      };
      requestRuntimePermissions(new String[] { "android.permission.CAMERA" }, local3);
      return;
    }
    gotonext();
  }
  
  private void gotonext()
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
    if (!xy.a(this.mSource))
    {
      gotoScan();
      setRightTitleImage(2131100169, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = VerifyStartScanActivity.this;
          aay.b(paramAnonymousView, paramAnonymousView.getString(2131493432));
        }
      });
      return;
    }
    this.mScanTipView = new zv(this, this.mSource);
    this.mScanTipView.setViewListener(new zv.a()
    {
      public final void a()
      {
        VerifyStartScanActivity.this.gotoScan();
      }
    });
    addContentView(this.mScanTipView);
    if (this.mSource == 0)
    {
      this.mTitleBar.setBackgroundColor(getResources().getColor(2130968774));
      this.mTitleDivider.setBackgroundColor(getResources().getColor(2130968790));
    }
    else
    {
      setTitle(getResources().getString(2131493548));
      this.mTitleBar.setBackgroundColor(getResources().getColor(2130968787));
      this.mTitleDivider.setVisibility(8);
    }
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2131099762));
    this.mTitleText.setTextColor(getResources().getColor(2130968762));
  }
  
  protected void dismissCameraDialog()
  {
    CameraPrepareDialog localCameraPrepareDialog = this.mCameraDialog;
    if (localCameraPrepareDialog != null)
    {
      localCameraPrepareDialog.dismiss();
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