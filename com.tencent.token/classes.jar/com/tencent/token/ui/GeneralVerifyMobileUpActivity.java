package com.tencent.token.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.rv;
import com.tencent.token.rv.a;
import com.tencent.token.sb;
import com.tencent.token.ta;
import com.tencent.token.wz;
import com.tencent.token.xb;
import com.tencent.token.yk;

public class GeneralVerifyMobileUpActivity
  extends BaseActivity
  implements Runnable
{
  private boolean isCurrentMobile = true;
  private boolean isFirstFactor = false;
  private String mCountryCode = "+86";
  private TextView mCountry_name;
  private TextView mCountry_number;
  private Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (GeneralVerifyMobileUpActivity.this.isFinishing()) {
        return;
      }
      int i = paramAnonymousMessage.what;
      if (i != 15)
      {
        if (i != 3003)
        {
          Object localObject;
          if (i != 3068)
          {
            if (i != 4004)
            {
              switch (i)
              {
              default: 
                return;
              case 4: 
                paramAnonymousMessage = GeneralVerifyMobileUpActivity.this;
                paramAnonymousMessage.showUserDialog(2131492986, paramAnonymousMessage.getResources().getString(2131493735), 2131493040, null);
                return;
              }
              GeneralVerifyMobileUpActivity.access$302(GeneralVerifyMobileUpActivity.this, 0);
              paramAnonymousMessage = GeneralVerifyMobileUpActivity.this;
              paramAnonymousMessage.showProDialogWithoutShutDown(paramAnonymousMessage, paramAnonymousMessage.getString(2131492930));
              postDelayed(GeneralVerifyMobileUpActivity.this.mVrySMSRunnable, 10000L);
              return;
            }
            if (paramAnonymousMessage.arg1 == 0)
            {
              GeneralVerifyMobileUpActivity.this.setActiveSucc();
              return;
            }
            paramAnonymousMessage = (wz)paramAnonymousMessage.obj;
            wz.a(GeneralVerifyMobileUpActivity.this.getResources(), paramAnonymousMessage);
            localObject = new StringBuilder("query up flow failed:");
            ((StringBuilder)localObject).append(paramAnonymousMessage.a);
            ((StringBuilder)localObject).append("-");
            ((StringBuilder)localObject).append(paramAnonymousMessage.b);
            ((StringBuilder)localObject).append("-");
            ((StringBuilder)localObject).append(paramAnonymousMessage.c);
            xb.c(((StringBuilder)localObject).toString());
            GeneralVerifyMobileUpActivity.this.showBindFailDialog(paramAnonymousMessage.c);
            return;
          }
          if (paramAnonymousMessage.arg1 == 0)
          {
            if (!GeneralVerifyMobileUpActivity.this.mVerifyType.a(Integer.valueOf(GeneralVerifyMobileUpActivity.this.mVerifyFactorId)))
            {
              paramAnonymousMessage = yk.a();
              localObject = GeneralVerifyMobileUpActivity.this;
              paramAnonymousMessage.a((Activity)localObject, ((GeneralVerifyMobileUpActivity)localObject).mVerifyResult, GeneralVerifyMobileUpActivity.this.mVerifyType, GeneralVerifyMobileUpActivity.this.mVerifyType.a(GeneralVerifyMobileUpActivity.this.mVerifyFactorId), false, GeneralVerifyMobileUpActivity.this.mHandler);
              return;
            }
            if (GeneralVerifyMobileUpActivity.this.mVerifyResult.b())
            {
              sb.a().b(GeneralVerifyMobileUpActivity.this.mUser.mRealUin, GeneralVerifyMobileUpActivity.this.mVerifyType.verifyTypeId, GeneralVerifyMobileUpActivity.this.mMobile, GeneralVerifyMobileUpActivity.this.mCountryCode, GeneralVerifyMobileUpActivity.this.mHandler);
              return;
            }
            GeneralVerifyMobileUpActivity.this.dismissDialog();
            paramAnonymousMessage = new Intent(GeneralVerifyMobileUpActivity.this, NetActiveSetDirBySeqActivity.class);
            paramAnonymousMessage.putExtra("intent.qquser", GeneralVerifyMobileUpActivity.this.mUser);
            paramAnonymousMessage.putExtra("intent.determin_factors_result", GeneralVerifyMobileUpActivity.this.mVerifyResult);
            paramAnonymousMessage.putExtra("intent.determin_verify_type", GeneralVerifyMobileUpActivity.this.mVerifyType);
            paramAnonymousMessage.putExtra("intent.determin_verify_factor_id", 3);
            GeneralVerifyMobileUpActivity.this.startActivity(paramAnonymousMessage);
            return;
          }
          paramAnonymousMessage = (wz)paramAnonymousMessage.obj;
          wz.a(GeneralVerifyMobileUpActivity.this.getResources(), paramAnonymousMessage);
          if ((paramAnonymousMessage.a == 146) && (GeneralVerifyMobileUpActivity.this.mRetryTimes < 4))
          {
            postDelayed(GeneralVerifyMobileUpActivity.this.mVrySMSRunnable, 10000L);
            return;
          }
          GeneralVerifyMobileUpActivity.this.showUserDialog(2131492986, paramAnonymousMessage.c, 2131493040, null);
          return;
        }
        GeneralVerifyMobileUpActivity.this.dismissDialog();
        paramAnonymousMessage = new Intent(GeneralVerifyMobileUpActivity.this, VerifySuccActivity.class);
        paramAnonymousMessage.putExtra("mRealUin", GeneralVerifyMobileUpActivity.this.mUser.mRealUin);
        if ((GeneralVerifyMobileUpActivity.this.mVerifyResult != null) && (GeneralVerifyMobileUpActivity.this.mVerifyResult.mScene == 2)) {
          paramAnonymousMessage.putExtra("mSourceId", 1);
        }
        GeneralVerifyMobileUpActivity.this.startActivity(paramAnonymousMessage);
        GeneralVerifyMobileUpActivity.this.finish();
        return;
      }
      GeneralVerifyMobileUpActivity.this.dismissDialog();
      GeneralVerifyMobileUpActivity.this.removeTimeTask();
      paramAnonymousMessage = GeneralVerifyMobileUpActivity.this.getString(2131493107);
      GeneralVerifyMobileUpActivity.this.showFailDialog(paramAnonymousMessage);
    }
  };
  private boolean mIsActiveSuccess = false;
  private boolean mIsModSetSucc = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private String mMobile = "";
  private EditText mMobileText;
  private int mRetryTimes = 0;
  private String mSMSChannel;
  private Button mStep2BindBtn;
  private long mTimeConter;
  private String mTitle = "身份验证";
  private QQUser mUser;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  Runnable mVrySMSRunnable = new Runnable()
  {
    public final void run()
    {
      int i;
      if (GeneralVerifyMobileUpActivity.this.mVerifyType != null) {
        i = GeneralVerifyMobileUpActivity.this.mVerifyType.verifyTypeId;
      } else {
        i = 0;
      }
      sb.a().a(0L, GeneralVerifyMobileUpActivity.this.mUser.mRealUin, 1007, i, GeneralVerifyMobileUpActivity.this.mHandler);
      GeneralVerifyMobileUpActivity.access$308(GeneralVerifyMobileUpActivity.this);
    }
  };
  private View mcountry;
  
  private void setActiveSucc()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mUser.mRealUin);
    localObject = ((StringBuilder)localObject).toString();
    ta.a().f(Long.parseLong((String)localObject));
    rv.a.a().c(this.mHandler);
  }
  
  private void showBindFailDialog(String paramString)
  {
    showUserDialog(2131492922, paramString, 2131493040, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131493656, paramString, 2131493040, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      if ((this.mIsModSetSucc) && (paramKeyEvent.getAction() == 0)) {
        if (paramKeyEvent.getKeyCode() == 4) {
          break label110;
        }
      }
      if ((this.isFirstFactor) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
      {
        startActivity(yk.a().a(this));
        return true;
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder("dispatchKeyEvent exception ");
      localStringBuilder.append(this);
      localStringBuilder.append(paramKeyEvent.toString());
      xb.c(localStringBuilder.toString());
      return true;
    }
    label110:
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      this.mHandler.sendEmptyMessage(3);
      startTimeTask();
      xb.b("startTimeTask onActivityResult");
      return;
    }
    if (paramInt2 == 0) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("name");
    this.mCountryCode = "+".concat(String.valueOf(paramInt2));
    this.mCountry_name.setText(paramIntent);
    this.mCountry_number.setText(this.mCountryCode);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras() == null)
    {
      finish();
      return;
    }
    if (getIntent().getBooleanExtra("intent.determin_from_list", false)) {
      overridePendingTransition(0, 0);
    }
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
    this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
    this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
    this.isFirstFactor = getIntent().getBooleanExtra("intent.determin_first_verify_factor", false);
    if (this.mUser != null)
    {
      paramBundle = this.mVerifyResult;
      if ((paramBundle != null) && (this.mVerifyType != null))
      {
        if ((paramBundle != null) && (paramBundle.mScene == 2)) {
          setNeverShowLockVerifyView();
        }
        setContentView(2131296352);
        this.mMobile = this.mVerifyResult.mMobileMask;
        findViewById(2131165773).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            paramAnonymousView = GeneralVerifyMobileUpActivity.this;
            paramAnonymousView.sendUpSmsBySMSAPP(paramAnonymousView.mVerifyResult.mSMSChannel, GeneralVerifyMobileUpActivity.this.mVerifyResult.mSMSContent);
            GeneralVerifyMobileUpActivity.this.showProgressDialog();
          }
        });
        findViewById(2131165355).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new Intent(GeneralVerifyMobileUpActivity.this, SmsContentTipActivity.class);
            paramAnonymousView.putExtra("intent.qquser", GeneralVerifyMobileUpActivity.this.mUser);
            paramAnonymousView.putExtra("intent.determin_factors_result", GeneralVerifyMobileUpActivity.this.mVerifyResult);
            paramAnonymousView.putExtra("intent.determin_verify_type", GeneralVerifyMobileUpActivity.this.mVerifyType);
            paramAnonymousView.putExtra("up_sms_scene_id", 8);
            paramAnonymousView.putExtra("intent.determin_verify_factor_id", GeneralVerifyMobileUpActivity.this.mVerifyFactorId);
            GeneralVerifyMobileUpActivity.this.startActivity(paramAnonymousView);
          }
        });
        ((TextView)findViewById(2131165740)).setText(this.mVerifyResult.mMobileMask);
        ((TextView)findViewById(2131165375)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new Intent(GeneralVerifyMobileUpActivity.this, NetActiveVryOtherListActivity.class);
            paramAnonymousView.putExtra("intent.qquser", GeneralVerifyMobileUpActivity.this.mUser);
            paramAnonymousView.putExtra("intent.determin_factors_result", GeneralVerifyMobileUpActivity.this.mVerifyResult);
            paramAnonymousView.putExtra("intent.determin_verify_type", GeneralVerifyMobileUpActivity.this.mVerifyType);
            GeneralVerifyMobileUpActivity.this.startActivity(paramAnonymousView);
          }
        });
        new Thread(this).start();
        return;
      }
    }
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
    yk.b();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void removeTimeTask()
  {
    this.mIsTimeTask = false;
  }
  
  public void run()
  {
    while (this.mIsRunning) {
      if ((this.mIsTimeTask) && (System.currentTimeMillis() - this.mTimeConter > 60000L)) {
        try
        {
          xb.c("removeTimeTask removeTimeTask");
          removeTimeTask();
          Message localMessage = new Message();
          localMessage.what = 15;
          this.mHandler.sendMessage(localMessage);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void sendUpSmsBySMSAPP(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:".concat(String.valueOf(paramString1))));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      xb.b(paramString1.toString());
    }
  }
  
  protected void setDefaultBackArrow()
  {
    super.setDefaultBackArrow();
    if (this.isFirstFactor) {
      this.mBackArrow.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = yk.a().a(GeneralVerifyMobileUpActivity.this);
          GeneralVerifyMobileUpActivity.this.startActivity(paramAnonymousView);
        }
      });
    }
  }
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131493804, 2131492947, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        xb.c("removeTimeTask showProgressDialog");
        GeneralVerifyMobileUpActivity.this.removeTimeTask();
      }
    });
  }
  
  public void startTimeTask()
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.GeneralVerifyMobileUpActivity
 * JD-Core Version:    0.7.0.1
 */