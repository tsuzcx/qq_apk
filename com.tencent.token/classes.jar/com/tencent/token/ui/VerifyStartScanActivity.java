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
import com.tencent.token.global.h;
import com.tencent.token.ui.base.CameraPrepareDialog;
import com.tencent.token.ui.base.m;
import com.tencent.token.ui.base.m.a;
import com.tencent.token.utils.l;
import java.util.List;

public class VerifyStartScanActivity
  extends BaseActivity
{
  private CameraPrepareDialog mCameraDialog;
  private m mScanTipView;
  private int mSource;
  
  private void gotoScan()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      f local3 = new f()
      {
        public void a()
        {
          VerifyStartScanActivity.this.gotonext();
        }
        
        public void a(List<String> paramAnonymousList)
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
    this.mCameraDialog = new CameraPrepareDialog(this, 2131558791);
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
    if (!h.a(this.mSource))
    {
      gotoScan();
      setRightTitleImage(2131100160, new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = VerifyStartScanActivity.this;
          l.b(paramAnonymousView, paramAnonymousView.getString(2131493429));
        }
      });
      return;
    }
    this.mScanTipView = new m(this, this.mSource);
    this.mScanTipView.setViewListener(new m.a()
    {
      public void a()
      {
        VerifyStartScanActivity.this.gotoScan();
      }
    });
    addContentView(this.mScanTipView);
    if (this.mSource == 0)
    {
      this.mTitleBar.setBackgroundColor(getResources().getColor(2130968773));
      this.mTitleDivider.setBackgroundColor(getResources().getColor(2130968789));
    }
    else
    {
      setTitle(getResources().getString(2131493539));
      this.mTitleBar.setBackgroundColor(getResources().getColor(2130968786));
      this.mTitleDivider.setVisibility(8);
    }
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2131099762));
    this.mTitleText.setTextColor(getResources().getColor(2130968761));
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