package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.ui.base.DualMsgView;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;
import com.tencent.token.wz;
import com.tencent.token.xb;

public class GetBarcodeVerifyMsgActivity
  extends BaseActivity
{
  private String mAqVerifyBarcodeContent;
  private DialogInterface.OnDismissListener mDismissListener = new DialogInterface.OnDismissListener()
  {
    public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
    {
      GetBarcodeVerifyMsgActivity.this.finish();
    }
  };
  private DualMsgShowDialog mDualMsgShowDialog = null;
  private UserTask<String, String, wz> mGetDualMsgTask = null;
  private ProgressBar mPreparePro;
  private TextView mPrepareText;
  private boolean mQueryingDualMsg = false;
  
  private void dismissDualDialog()
  {
    DualMsgShowDialog localDualMsgShowDialog = this.mDualMsgShowDialog;
    if (localDualMsgShowDialog != null)
    {
      if (localDualMsgShowDialog.isShowing()) {
        this.mDualMsgShowDialog.cancel();
      }
      this.mDualMsgShowDialog.a.a();
      this.mDualMsgShowDialog = null;
    }
  }
  
  private void queryDualMsg()
  {
    if (this.mQueryingDualMsg) {
      return;
    }
    this.mQueryingDualMsg = true;
    this.mGetDualMsgTask = new UserTask()
    {
      public final void a()
      {
        super.a();
        GetBarcodeVerifyMsgActivity.access$102(GetBarcodeVerifyMsgActivity.this, false);
      }
    };
    this.mGetDualMsgTask.a(new String[] { "" });
  }
  
  private void showDualMsgExpireDlg()
  {
    showUserDialog(2131492986, getString(2131493092), 2131493040, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GetBarcodeVerifyMsgActivity.this.finish();
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296353);
    this.mPreparePro = ((ProgressBar)findViewById(2131165814));
    this.mPrepareText = ((TextView)findViewById(2131165815));
    this.mPrepareText.setText(2131493096);
    if ((getIntent() != null) && (getIntent().getBundleExtra("com.tencent.input_param") != null))
    {
      this.mAqVerifyBarcodeContent = getIntent().getBundleExtra("com.tencent.input_param").getString("barcode_result");
      paramBundle = new StringBuilder(", aq verify: ");
      paramBundle.append(this.mAqVerifyBarcodeContent);
      xb.a(paramBundle.toString());
      hideTitle();
      return;
    }
    finish();
  }
  
  protected void onDestroy()
  {
    DualMsgShowDialog localDualMsgShowDialog = this.mDualMsgShowDialog;
    if (localDualMsgShowDialog != null)
    {
      localDualMsgShowDialog.a.a();
      this.mDualMsgShowDialog = null;
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    UserTask localUserTask = this.mGetDualMsgTask;
    if ((localUserTask != null) && (localUserTask.e != UserTask.Status.FINISHED)) {
      this.mGetDualMsgTask.c();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    DualMsgShowDialog localDualMsgShowDialog = this.mDualMsgShowDialog;
    if ((localDualMsgShowDialog != null) && (localDualMsgShowDialog.isShowing())) {
      return;
    }
    queryDualMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.GetBarcodeVerifyMsgActivity
 * JD-Core Version:    0.7.0.1
 */