package com.tencent.token.ui;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;

public class GetBarcodeVerifyMsgActivity
  extends BaseActivity
{
  private String mAqVerifyBarcodeContent;
  private DialogInterface.OnDismissListener mDismissListener = new kx(this);
  private DualMsgShowDialog mDualMsgShowDialog = null;
  private UserTask mGetDualMsgTask = null;
  private ProgressBar mPreparePro;
  private TextView mPrepareText;
  private boolean mQueryingDualMsg = false;
  
  private void dismissDualDialog()
  {
    if (this.mDualMsgShowDialog != null)
    {
      if (this.mDualMsgShowDialog.isShowing()) {
        this.mDualMsgShowDialog.cancel();
      }
      this.mDualMsgShowDialog.b();
      this.mDualMsgShowDialog = null;
    }
  }
  
  private void queryDualMsg()
  {
    if (this.mQueryingDualMsg) {
      return;
    }
    this.mQueryingDualMsg = true;
    this.mGetDualMsgTask = new kq(this);
    this.mGetDualMsgTask.c(new String[] { "" });
  }
  
  private void showDualMsgExpireDlg()
  {
    showUserDialog(2131230843, getString(2131230949), 2131230897, new ky(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968672);
    this.mPreparePro = ((ProgressBar)findViewById(2131558941));
    this.mPrepareText = ((TextView)findViewById(2131558940));
    this.mPrepareText.setText(2131230953);
    if ((getIntent() == null) || (getIntent().getBundleExtra("com.tencent.input_param") == null))
    {
      finish();
      return;
    }
    this.mAqVerifyBarcodeContent = getIntent().getBundleExtra("com.tencent.input_param").getString("barcode_result");
    h.a(", aq verify: " + this.mAqVerifyBarcodeContent);
    hideTitle();
  }
  
  protected void onDestroy()
  {
    if (this.mDualMsgShowDialog != null)
    {
      this.mDualMsgShowDialog.b();
      this.mDualMsgShowDialog = null;
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if ((this.mGetDualMsgTask != null) && (this.mGetDualMsgTask.b() != UserTask.Status.FINISHED)) {
      this.mGetDualMsgTask.a(true);
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.mDualMsgShowDialog != null) && (this.mDualMsgShowDialog.isShowing())) {
      return;
    }
    queryDualMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.GetBarcodeVerifyMsgActivity
 * JD-Core Version:    0.7.0.1
 */