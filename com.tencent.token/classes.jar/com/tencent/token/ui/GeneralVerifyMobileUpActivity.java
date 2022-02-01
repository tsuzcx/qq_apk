package com.tencent.token.ui;

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
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cl;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cq;
import com.tencent.token.global.e;
import com.tencent.token.global.g;

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
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (GeneralVerifyMobileUpActivity.this.isFinishing()) {
        return;
      }
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 3: 
        GeneralVerifyMobileUpActivity.access$302(GeneralVerifyMobileUpActivity.this, 0);
        GeneralVerifyMobileUpActivity.this.showProDialogWithoutShutDown(GeneralVerifyMobileUpActivity.this, GeneralVerifyMobileUpActivity.this.getString(2131230787));
        postDelayed(GeneralVerifyMobileUpActivity.this.mVrySMSRunnable, 10000L);
        return;
      case 4: 
        GeneralVerifyMobileUpActivity.this.showUserDialog(2131230843, GeneralVerifyMobileUpActivity.this.getResources().getString(2131231588), 2131230897, null);
        return;
      case 15: 
        GeneralVerifyMobileUpActivity.this.dismissDialog();
        GeneralVerifyMobileUpActivity.this.removeTimeTask();
        paramAnonymousMessage = GeneralVerifyMobileUpActivity.this.getString(2131230964);
        GeneralVerifyMobileUpActivity.this.showFailDialog(paramAnonymousMessage);
        return;
      case 3003: 
        GeneralVerifyMobileUpActivity.this.dismissDialog();
        paramAnonymousMessage = new Intent(GeneralVerifyMobileUpActivity.this, VerifySuccActivity.class);
        paramAnonymousMessage.putExtra("mRealUin", GeneralVerifyMobileUpActivity.this.mUser.mRealUin);
        if ((GeneralVerifyMobileUpActivity.this.mVerifyResult != null) && (GeneralVerifyMobileUpActivity.this.mVerifyResult.c() == 2)) {
          paramAnonymousMessage.putExtra("mSourceId", 1);
        }
        GeneralVerifyMobileUpActivity.this.startActivity(paramAnonymousMessage);
        GeneralVerifyMobileUpActivity.this.finish();
        return;
      case 4004: 
        if (paramAnonymousMessage.arg1 == 0)
        {
          GeneralVerifyMobileUpActivity.this.setActiveSucc();
          return;
        }
        paramAnonymousMessage = (e)paramAnonymousMessage.obj;
        e.a(GeneralVerifyMobileUpActivity.this.getResources(), paramAnonymousMessage);
        g.c("query up flow failed:" + paramAnonymousMessage.a + "-" + paramAnonymousMessage.b + "-" + paramAnonymousMessage.c);
        GeneralVerifyMobileUpActivity.this.showBindFailDialog(paramAnonymousMessage.c);
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        if (!GeneralVerifyMobileUpActivity.this.mVerifyType.a(Integer.valueOf(GeneralVerifyMobileUpActivity.this.mVerifyFactorId)))
        {
          u.a().a(GeneralVerifyMobileUpActivity.this, GeneralVerifyMobileUpActivity.this.mVerifyResult, GeneralVerifyMobileUpActivity.this.mVerifyType, GeneralVerifyMobileUpActivity.this.mVerifyType.a(GeneralVerifyMobileUpActivity.this.mVerifyFactorId), false, GeneralVerifyMobileUpActivity.this.mHandler);
          return;
        }
        if (GeneralVerifyMobileUpActivity.this.mVerifyResult.b())
        {
          ca.a().b(GeneralVerifyMobileUpActivity.this.mUser.mRealUin, GeneralVerifyMobileUpActivity.this.mVerifyType.a(), GeneralVerifyMobileUpActivity.this.mMobile, GeneralVerifyMobileUpActivity.this.mCountryCode, GeneralVerifyMobileUpActivity.this.mHandler);
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
      paramAnonymousMessage = (e)paramAnonymousMessage.obj;
      e.a(GeneralVerifyMobileUpActivity.this.getResources(), paramAnonymousMessage);
      if ((paramAnonymousMessage.a == 146) && (GeneralVerifyMobileUpActivity.this.mRetryTimes < 4))
      {
        postDelayed(GeneralVerifyMobileUpActivity.this.mVrySMSRunnable, 10000L);
        return;
      }
      GeneralVerifyMobileUpActivity.this.showUserDialog(2131230843, paramAnonymousMessage.c, 2131230897, null);
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
    public void run()
    {
      int i = 0;
      if (GeneralVerifyMobileUpActivity.this.mVerifyType != null) {
        i = GeneralVerifyMobileUpActivity.this.mVerifyType.a();
      }
      ca.a().a(0L, GeneralVerifyMobileUpActivity.this.mUser.mRealUin, 1007, i, GeneralVerifyMobileUpActivity.this.mHandler);
      GeneralVerifyMobileUpActivity.access$308(GeneralVerifyMobileUpActivity.this);
    }
  };
  private View mcountry;
  
  private void setActiveSucc()
  {
    Object localObject = cb.c();
    ((cb)localObject).i();
    ((cb)localObject).n();
    localObject = this.mUser.mRealUin + "";
    cq.a().f(Long.parseLong((String)localObject));
    ca.a().b(this.mHandler);
  }
  
  private void showBindFailDialog(String paramString)
  {
    showUserDialog(2131230779, paramString, 2131230897, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131231509, paramString, 2131230897, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((this.mIsModSetSucc) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        default: 
          if ((this.isFirstFactor) && (paramKeyEvent.getAction() == 0)) {}
          switch (paramKeyEvent.getKeyCode())
          {
          case 4: 
            return super.dispatchKeyEvent(paramKeyEvent);
          }
          break;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        g.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      startActivity(u.a().a(this));
      return true;
    }
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      this.mHandler.sendEmptyMessage(3);
      startTimeTask();
      g.b("startTimeTask onActivityResult");
    }
    while (paramInt2 == 0) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("name");
    this.mCountryCode = ("+" + paramInt2);
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
    if ((this.mUser == null) || (this.mVerifyResult == null) || (this.mVerifyType == null))
    {
      finish();
      return;
    }
    if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
      setNeverShowLockVerifyView();
    }
    setContentView(2130968671);
    this.mMobile = this.mVerifyResult.g();
    findViewById(2131558731).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        GeneralVerifyMobileUpActivity.this.sendUpSmsBySMSAPP(GeneralVerifyMobileUpActivity.this.mVerifyResult.e(), GeneralVerifyMobileUpActivity.this.mVerifyResult.d());
        GeneralVerifyMobileUpActivity.this.showProgressDialog();
      }
    });
    findViewById(2131558732).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
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
    ((TextView)findViewById(2131558729)).setText(this.mVerifyResult.g());
    ((TextView)findViewById(2131558741)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(GeneralVerifyMobileUpActivity.this, NetActiveVryOtherListActivity.class);
        paramAnonymousView.putExtra("intent.qquser", GeneralVerifyMobileUpActivity.this.mUser);
        paramAnonymousView.putExtra("intent.determin_factors_result", GeneralVerifyMobileUpActivity.this.mVerifyResult);
        paramAnonymousView.putExtra("intent.determin_verify_type", GeneralVerifyMobileUpActivity.this.mVerifyType);
        GeneralVerifyMobileUpActivity.this.startActivity(paramAnonymousView);
      }
    });
    new Thread(this).start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
    u.c();
  }
  
  public void onResume()
  {
    super.onResume();
    cb.c().a.a(this.mHandler);
  }
  
  public void onStop()
  {
    super.onStop();
    cb.c().a.a(null);
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
          g.c("removeTimeTask removeTimeTask");
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
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString1));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      g.b(paramString1.toString());
    }
  }
  
  protected void setDefaultBackArrow()
  {
    super.setDefaultBackArrow();
    if (this.isFirstFactor) {
      this.mBackArrow.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = u.a().a(GeneralVerifyMobileUpActivity.this);
          GeneralVerifyMobileUpActivity.this.startActivity(paramAnonymousView);
        }
      });
    }
  }
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131231657, 2131230804, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        g.c("removeTimeTask showProgressDialog");
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