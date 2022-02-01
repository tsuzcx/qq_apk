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
import com.tencent.token.co;
import com.tencent.token.cs;
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
    DualMsgShowDialog localDualMsgShowDialog = this.mDualMsgShowDialog;
    if (localDualMsgShowDialog != null)
    {
      if (localDualMsgShowDialog.isShowing()) {
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
        if (!cs.a().o())
        {
          localObject = cs.a().q();
          paramAnonymousVarArgs = (String[])localObject;
          if (!((e)localObject).b()) {
            return localObject;
          }
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("barcode user: ");
        ((StringBuilder)localObject).append(cs.a().d());
        g.c(((StringBuilder)localObject).toString());
        if (cs.a().d() > 0) {
          return co.a().a(GetBarcodeVerifyMsgActivity.this.mAqVerifyBarcodeContent);
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
          if (co.a().b() > 0)
          {
            GetBarcodeVerifyMsgActivity.this.dismissDualDialog();
            paramAnonymouse = GetBarcodeVerifyMsgActivity.this;
            GetBarcodeVerifyMsgActivity.access$502(paramAnonymouse, new DualMsgShowDialog(paramAnonymouse, 2131558764, 1));
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
        if ((110 != paramAnonymouse.a) && (111 != paramAnonymouse.a))
        {
          if (10029 == paramAnonymouse.a)
          {
            paramAnonymouse = GetBarcodeVerifyMsgActivity.this;
            paramAnonymouse.showUserDialog(2131492986, paramAnonymouse.getString(2131493762), 2131493803, 2131493029, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
          GetBarcodeVerifyMsgActivity.this.showUserDialog(2131492986, paramAnonymouse.c, 2131493040, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GetBarcodeVerifyMsgActivity.this.finish();
            }
          });
          return;
        }
        paramAnonymouse = GetBarcodeVerifyMsgActivity.this;
        paramAnonymouse.showUserDialog(2131492986, paramAnonymouse.getResources().getString(2131493538), 2131493029, 2131492920, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      }
    };
    this.mGetDualMsgTask.c(new String[] { "" });
  }
  
  private void showDualMsgExpireDlg()
  {
    showUserDialog(2131492986, getString(2131493092), 2131493040, new DialogInterface.OnClickListener()
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
    setContentView(2131296352);
    this.mPreparePro = ((ProgressBar)findViewById(2131165810));
    this.mPrepareText = ((TextView)findViewById(2131165811));
    this.mPrepareText.setText(2131493096);
    if ((getIntent() != null) && (getIntent().getBundleExtra("com.tencent.input_param") != null))
    {
      this.mAqVerifyBarcodeContent = getIntent().getBundleExtra("com.tencent.input_param").getString("barcode_result");
      paramBundle = new StringBuilder();
      paramBundle.append(", aq verify: ");
      paramBundle.append(this.mAqVerifyBarcodeContent);
      g.a(paramBundle.toString());
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
      localDualMsgShowDialog.b();
      this.mDualMsgShowDialog = null;
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    UserTask localUserTask = this.mGetDualMsgTask;
    if ((localUserTask != null) && (localUserTask.b() != UserTask.Status.FINISHED)) {
      this.mGetDualMsgTask.a(true);
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