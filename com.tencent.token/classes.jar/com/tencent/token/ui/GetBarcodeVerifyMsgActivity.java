package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.cn;
import com.tencent.token.cr;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;

public class GetBarcodeVerifyMsgActivity
  extends BaseActivity
{
  private String mAqVerifyBarcodeContent;
  private DialogInterface.OnDismissListener mDismissListener = new DialogInterface.OnDismissListener()
  {
    public void onDismiss(DialogInterface paramAnonymousDialogInterface)
    {
      GetBarcodeVerifyMsgActivity.this.finish();
    }
  };
  private DualMsgShowDialog mDualMsgShowDialog = null;
  private UserTask<String, String, e> mGetDualMsgTask = null;
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
    this.mGetDualMsgTask = new UserTask()
    {
      public e a(String... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = new e();
        if (!cr.a().o())
        {
          e locale = cr.a().q();
          paramAnonymousVarArgs = locale;
          if (!locale.b()) {
            return locale;
          }
        }
        g.c("barcode user: " + cr.a().d());
        if (cr.a().d() > 0) {
          return cn.a().a(GetBarcodeVerifyMsgActivity.this.mAqVerifyBarcodeContent);
        }
        paramAnonymousVarArgs.b(110);
        return paramAnonymousVarArgs;
      }
      
      public void a()
      {
        super.a();
        GetBarcodeVerifyMsgActivity.access$102(GetBarcodeVerifyMsgActivity.this, false);
      }
      
      public void a(e paramAnonymouse)
      {
        GetBarcodeVerifyMsgActivity.access$102(GetBarcodeVerifyMsgActivity.this, false);
        if (GetBarcodeVerifyMsgActivity.this.isFinishing()) {
          return;
        }
        GetBarcodeVerifyMsgActivity.this.mPrepareText.setText("");
        GetBarcodeVerifyMsgActivity.this.mPreparePro.setVisibility(4);
        if (paramAnonymouse.b())
        {
          if (cn.a().b() > 0)
          {
            GetBarcodeVerifyMsgActivity.this.dismissDualDialog();
            GetBarcodeVerifyMsgActivity.access$502(GetBarcodeVerifyMsgActivity.this, new DualMsgShowDialog(GetBarcodeVerifyMsgActivity.this, 2131362156, 1));
            GetBarcodeVerifyMsgActivity.this.mDualMsgShowDialog.show();
            GetBarcodeVerifyMsgActivity.this.mDualMsgShowDialog.setOnDismissListener(GetBarcodeVerifyMsgActivity.this.mDismissListener);
            return;
          }
          GetBarcodeVerifyMsgActivity.this.showDualMsgExpireDlg();
          return;
        }
        if (10023 == paramAnonymouse.a)
        {
          GetBarcodeVerifyMsgActivity.this.showDualMsgExpireDlg();
          return;
        }
        if ((110 == paramAnonymouse.a) || (111 == paramAnonymouse.a))
        {
          GetBarcodeVerifyMsgActivity.this.showUserDialog(2131230843, GetBarcodeVerifyMsgActivity.this.getResources().getString(2131231395), 2131230886, 2131230777, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GetBarcodeVerifyMsgActivity.this.dismissDialog();
            }
          }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GetBarcodeVerifyMsgActivity.this.dismissDialog();
              paramAnonymous2DialogInterface = new Intent(GetBarcodeVerifyMsgActivity.this, WtLoginAccountInput.class);
              paramAnonymous2DialogInterface.putExtra("page_id", 4);
              GetBarcodeVerifyMsgActivity.this.startActivity(paramAnonymous2DialogInterface);
            }
          }, new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              GetBarcodeVerifyMsgActivity.this.finish();
            }
          });
          return;
        }
        if (10029 == paramAnonymouse.a)
        {
          GetBarcodeVerifyMsgActivity.this.showUserDialog(2131230843, GetBarcodeVerifyMsgActivity.this.getString(2131231617), 2131231658, 2131230886, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GetBarcodeVerifyMsgActivity.this.gotoVerify(GetBarcodeVerifyMsgActivity.this);
            }
          }, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GetBarcodeVerifyMsgActivity.this.finish();
            }
          });
          return;
        }
        e.a(GetBarcodeVerifyMsgActivity.this.getResources(), paramAnonymouse);
        GetBarcodeVerifyMsgActivity.this.showUserDialog(2131230843, paramAnonymouse.c, 2131230897, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            GetBarcodeVerifyMsgActivity.this.finish();
          }
        });
      }
    };
    this.mGetDualMsgTask.c(new String[] { "" });
  }
  
  private void showDualMsgExpireDlg()
  {
    showUserDialog(2131230843, getString(2131230949), 2131230897, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GetBarcodeVerifyMsgActivity.this.finish();
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968672);
    this.mPreparePro = ((ProgressBar)findViewById(2131558942));
    this.mPrepareText = ((TextView)findViewById(2131558941));
    this.mPrepareText.setText(2131230953);
    if ((getIntent() == null) || (getIntent().getBundleExtra("com.tencent.input_param") == null))
    {
      finish();
      return;
    }
    this.mAqVerifyBarcodeContent = getIntent().getBundleExtra("com.tencent.input_param").getString("barcode_result");
    g.a(", aq verify: " + this.mAqVerifyBarcodeContent);
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