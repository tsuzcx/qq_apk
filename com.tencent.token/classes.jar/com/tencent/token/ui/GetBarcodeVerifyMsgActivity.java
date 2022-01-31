package com.tencent.token.ui;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;

public class GetBarcodeVerifyMsgActivity
  extends BaseActivity
{
  private String mAqVerifyBarcodeContent;
  private DialogInterface.OnDismissListener mDismissListener = new lj(this);
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
    this.mGetDualMsgTask = new lc(this);
    this.mGetDualMsgTask.a(new String[] { "" });
  }
  
  private void showDualMsgExpireDlg()
  {
    showUserDialog(2131361808, getString(2131362098), 2131361800, new lk(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903102);
    this.mPreparePro = ((ProgressBar)findViewById(2131296636));
    this.mPrepareText = ((TextView)findViewById(2131296635));
    this.mPrepareText.setText(2131362117);
    this.mAqVerifyBarcodeContent = getIntent().getBundleExtra("com.tencent.input_param").getString("barcode_result");
    e.a(", aq verify: " + this.mAqVerifyBarcodeContent);
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
    if ((this.mGetDualMsgTask != null) && (this.mGetDualMsgTask.c() != UserTask.Status.FINISHED)) {
      this.mGetDualMsgTask.d();
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