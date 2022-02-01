package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.by;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cl;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetSMSChannel;
import com.tencent.token.cq;
import com.tencent.token.cs;
import com.tencent.token.cu;
import com.tencent.token.di;
import com.tencent.token.dj;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

public class SmsContentTipActivity
  extends BaseActivity
  implements Runnable
{
  private View btnLayout;
  private TextView errorTip;
  private boolean isReadyModSetMB = false;
  private String mA2 = "";
  private int mBindRetryTimes = 0;
  Runnable mBindRunnable = new Runnable()
  {
    public void run()
    {
      if (!SmsContentTipActivity.this.mIsTimeTask) {
        return;
      }
      g.a("send bind seq request:" + SmsContentTipActivity.this.mBindRetryTimes);
      cb.c().n();
      int i = 0;
      if (SmsContentTipActivity.this.mVerifyType != null) {
        i = SmsContentTipActivity.this.mVerifyType.a();
      }
      ca.a().a(0L, Long.parseLong(SmsContentTipActivity.this.mUin), SmsContentTipActivity.this.mSceneId, i, SmsContentTipActivity.this.mHandler);
      SmsContentTipActivity.access$108(SmsContentTipActivity.this);
    }
  };
  private String mCountryCode;
  private DialogInterface.OnCancelListener mDialogCancelListener = new DialogInterface.OnCancelListener()
  {
    public void onCancel(DialogInterface paramAnonymousDialogInterface)
    {
      SmsContentTipActivity.this.unbindResult();
    }
  };
  private DialogInterface.OnClickListener mDialogFinishListener = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      SmsContentTipActivity.this.dismissDialog();
    }
  };
  Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      try
      {
        if (SmsContentTipActivity.this == null) {
          break label2219;
        }
        if ((SmsContentTipActivity.this != null) && (SmsContentTipActivity.this.isFinishing())) {
          return;
        }
        g.c("msg what=" + paramAnonymousMessage.what + "starttime=" + SmsContentTipActivity.this.mIsTimeTask);
        switch (paramAnonymousMessage.what)
        {
        case 3: 
          if (!SmsContentTipActivity.this.mIsTimeTask) {
            break label2219;
          }
          if ((SmsContentTipActivity.this.upSmsSceneId == 0) || (SmsContentTipActivity.this.upSmsSceneId == 7))
          {
            SmsContentTipActivity.access$102(SmsContentTipActivity.this, 0);
            postDelayed(SmsContentTipActivity.this.mBindRunnable, 10000L);
            return;
          }
          break;
        }
      }
      catch (Exception paramAnonymousMessage)
      {
        paramAnonymousMessage.printStackTrace();
        return;
      }
      Object localObject1;
      if ((SmsContentTipActivity.this.upSmsSceneId == 3) || (SmsContentTipActivity.this.upSmsSceneId == 4))
      {
        paramAnonymousMessage = by.a(RqdApplication.l());
        localObject1 = paramAnonymousMessage.b(Long.parseLong(SmsContentTipActivity.this.mUin));
        g.a("mailprotect data=" + localObject1);
        if ((localObject1 != null) && (localObject1.length > 0) && (!paramAnonymousMessage.b("" + SmsContentTipActivity.this.mUin, 523005419L)))
        {
          SmsContentTipActivity.access$802(SmsContentTipActivity.this, l.a((byte[])localObject1));
          SmsContentTipActivity.this.gotoSetMobile();
          return;
        }
        by.a(RqdApplication.l()).a("" + SmsContentTipActivity.this.mUin, SmsContentTipActivity.this.mHandler, 523005419L, 64);
        return;
      }
      if (SmsContentTipActivity.this.upSmsSceneId == 6)
      {
        SmsContentTipActivity.access$1002(SmsContentTipActivity.this, 0);
        postDelayed(SmsContentTipActivity.this.mUnBindRunnable, 10000L);
        return;
      }
      if (SmsContentTipActivity.this.upSmsSceneId == 8)
      {
        SmsContentTipActivity.access$102(SmsContentTipActivity.this, 0);
        postDelayed(SmsContentTipActivity.this.mBindRunnable, 10000L);
        return;
        if (SmsContentTipActivity.this.mIsTimeTask)
        {
          g.c("removeTimeTask SendSmsFail");
          SmsContentTipActivity.this.removeTimeTask();
          return;
          SmsContentTipActivity.this.dismissDialog();
          g.c("removeTimeTask BindUinToSeqSuccess");
          SmsContentTipActivity.this.removeTimeTask();
          SmsContentTipActivity.this.displaySucc();
          return;
          if (SmsContentTipActivity.this.mIsTimeTask)
          {
            paramAnonymousMessage = paramAnonymousMessage.getData();
            int i = paramAnonymousMessage.getInt("errCode");
            paramAnonymousMessage = paramAnonymousMessage.getString("error");
            if ((1 == i) && (SmsContentTipActivity.this.mBindRetryTimes < 4))
            {
              postDelayed(SmsContentTipActivity.this.mBindRunnable, 10000L);
              return;
            }
            SmsContentTipActivity.this.dismissDialog();
            g.c("removeTimeTask BindUinToSeqFail");
            SmsContentTipActivity.this.removeTimeTask();
            SmsContentTipActivity.this.errorTip.setVisibility(0);
            SmsContentTipActivity.this.errorTip.setText(paramAnonymousMessage);
            SmsContentTipActivity.this.resetBtn();
            return;
            SmsContentTipActivity.this.dismissDialog();
            g.c("removeTimeTask HttpError");
            SmsContentTipActivity.this.removeTimeTask();
            SmsContentTipActivity.this.errorTip.setVisibility(0);
            SmsContentTipActivity.this.errorTip.setText(SmsContentTipActivity.this.getString(2131231451));
            SmsContentTipActivity.this.resetBtn();
            return;
            i = paramAnonymousMessage.getData().getInt("serTime");
            long l = System.currentTimeMillis();
            l = i * 1000L - l;
            cb.c().a(l);
            g.b("set time plus: " + l);
            return;
            if (paramAnonymousMessage.arg1 == 0)
            {
              if (SmsContentTipActivity.this.upSmsSceneId == 0)
              {
                ca.a().c(Long.parseLong(SmsContentTipActivity.this.mUin), SmsContentTipActivity.this.mUpDetermin.f(), "", "", SmsContentTipActivity.this.mHandler);
                return;
              }
              if (SmsContentTipActivity.this.upSmsSceneId == 6)
              {
                ca.a().a(SmsContentTipActivity.this.mUserToUnbind.mUin, SmsContentTipActivity.this.mUserToUnbind.mRealUin, 1, SmsContentTipActivity.this.mHandler);
                return;
              }
              if (SmsContentTipActivity.this.upSmsSceneId == 7)
              {
                paramAnonymousMessage = new Intent(SmsContentTipActivity.this, VryMobileForStrategyActivity.class);
                paramAnonymousMessage.putExtra("succ", true);
                paramAnonymousMessage.setFlags(67108864);
                SmsContentTipActivity.this.startActivity(paramAnonymousMessage);
                SmsContentTipActivity.this.finish();
                return;
              }
              if (SmsContentTipActivity.this.upSmsSceneId == 8)
              {
                if (!SmsContentTipActivity.this.mVerifyType.a(Integer.valueOf(SmsContentTipActivity.this.mVerifyFactorId)))
                {
                  u.a().a(SmsContentTipActivity.this, SmsContentTipActivity.this.mVerifyResult, SmsContentTipActivity.this.mVerifyType, SmsContentTipActivity.this.mVerifyType.a(SmsContentTipActivity.this.mVerifyFactorId), false, SmsContentTipActivity.this.mHandler);
                  return;
                }
                if (SmsContentTipActivity.this.mVerifyResult.b())
                {
                  ca.a().b(SmsContentTipActivity.this.mUser.mRealUin, SmsContentTipActivity.this.mVerifyType.a(), SmsContentTipActivity.this.mMobile, SmsContentTipActivity.this.mCountryCode, SmsContentTipActivity.this.mHandler);
                  return;
                }
                SmsContentTipActivity.this.dismissDialog();
              }
            }
            else
            {
              paramAnonymousMessage = (e)paramAnonymousMessage.obj;
              e.a(SmsContentTipActivity.this.getResources(), paramAnonymousMessage);
              if (((SmsContentTipActivity.this.upSmsSceneId == 0) || (SmsContentTipActivity.this.upSmsSceneId == 8)) && (paramAnonymousMessage.a == 146) && (SmsContentTipActivity.this.mBindRetryTimes < 4))
              {
                postDelayed(SmsContentTipActivity.this.mBindRunnable, 10000L);
                return;
              }
              if ((SmsContentTipActivity.this.upSmsSceneId == 6) && (paramAnonymousMessage.a == 146) && (SmsContentTipActivity.this.mUnBindRetryTimes < 4))
              {
                postDelayed(SmsContentTipActivity.this.mUnBindRunnable, 10000L);
                return;
              }
              SmsContentTipActivity.this.removeTimeTask();
              SmsContentTipActivity.this.errorTip.setVisibility(0);
              SmsContentTipActivity.this.errorTip.setText(paramAnonymousMessage.c);
              SmsContentTipActivity.this.resetBtn();
              return;
              SmsContentTipActivity.this.dismissDialog();
              SmsContentTipActivity.this.removeTimeTask();
              SmsContentTipActivity.this.resetBtn();
              if (paramAnonymousMessage.arg1 == 0)
              {
                SmsContentTipActivity.access$2102(SmsContentTipActivity.this, true);
                cq.a().b(SmsContentTipActivity.this.mUserToUnbind);
                cq.a().n();
                cq.a().b();
                cu.a().f.a(SmsContentTipActivity.this.mUserToUnbind.mUin);
                cs.a().f.a(SmsContentTipActivity.this.mUserToUnbind.mUin);
                AccountPageActivity.mNeedRefreshEval = true;
                SmsContentTipActivity.this.showUserDialog(0, SmsContentTipActivity.this.getString(2131230763) + Long.toString(SmsContentTipActivity.this.mUserToUnbind.mRealUin) + SmsContentTipActivity.this.getString(2131231511), 2131230897, SmsContentTipActivity.this.mDialogFinishListener, SmsContentTipActivity.this.mDialogCancelListener);
                return;
              }
              paramAnonymousMessage = (e)paramAnonymousMessage.obj;
              e.a(SmsContentTipActivity.this.getResources(), paramAnonymousMessage);
              SmsContentTipActivity.this.showFailDialog(paramAnonymousMessage.c);
              return;
              SmsContentTipActivity.this.dismissDialog();
              SmsContentTipActivity.this.removeTimeTask();
              if (paramAnonymousMessage.arg1 == 0)
              {
                SmsContentTipActivity.this.displaySucc();
                return;
              }
              paramAnonymousMessage = (e)paramAnonymousMessage.obj;
              e.a(SmsContentTipActivity.this.getResources(), paramAnonymousMessage);
              g.c("query up flow failed:" + paramAnonymousMessage.a + "-" + paramAnonymousMessage.b + "-" + paramAnonymousMessage.c);
              SmsContentTipActivity.this.errorTip.setVisibility(0);
              SmsContentTipActivity.this.errorTip.setText(paramAnonymousMessage.c);
              SmsContentTipActivity.this.resetBtn();
              return;
              SmsContentTipActivity.this.removeTimeTask();
              SmsContentTipActivity.access$2502(SmsContentTipActivity.this, false);
              Object localObject4;
              if (paramAnonymousMessage.arg1 == 0)
              {
                SmsContentTipActivity.this.dismissDialog();
                SmsContentTipActivity.this.setContentView(2130968810);
                SmsContentTipActivity.this.mBackArrow.setVisibility(4);
                SmsContentTipActivity.access$2602(SmsContentTipActivity.this, true);
                if ((SmsContentTipActivity.this.mTitle != null) && (SmsContentTipActivity.this.mTitle.length() > 0)) {
                  SmsContentTipActivity.this.setTitle(SmsContentTipActivity.this.mTitle);
                }
                Object localObject5 = (JSONObject)paramAnonymousMessage.obj;
                localObject1 = null;
                localObject4 = null;
                paramAnonymousMessage = (Message)localObject4;
                try
                {
                  localObject2 = ((JSONObject)localObject5).getString("info");
                  paramAnonymousMessage = (Message)localObject4;
                  localObject1 = localObject2;
                  localObject4 = ((JSONObject)localObject5).getString("time1");
                  paramAnonymousMessage = (Message)localObject4;
                  localObject1 = localObject2;
                  localObject5 = ((JSONObject)localObject5).getString("time2");
                  localObject1 = localObject4;
                  paramAnonymousMessage = (Message)localObject5;
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    Object localObject2;
                    localJSONException.printStackTrace();
                    localObject4 = paramAnonymousMessage;
                    paramAnonymousMessage = null;
                    Object localObject3 = localObject1;
                    localObject1 = localObject4;
                    continue;
                    ((TextView)SmsContentTipActivity.this.findViewById(2131559422)).setText(2131231584);
                    if ((localObject1 != null) && (paramAnonymousMessage != null) && (((String)localObject1).length() > 0) && (paramAnonymousMessage.length() > 0))
                    {
                      ((View)localObject3).setVisibility(0);
                      localObject3 = (TextView)SmsContentTipActivity.this.findViewById(2131559426);
                      localObject4 = (TextView)SmsContentTipActivity.this.findViewById(2131559428);
                      ((TextView)localObject3).setText((CharSequence)localObject1);
                      ((TextView)localObject4).setText(paramAnonymousMessage);
                    }
                    else
                    {
                      ((View)localObject3).setVisibility(8);
                    }
                  }
                }
                if ((localObject2 != null) && (((String)localObject2).length() > 0))
                {
                  localObject4 = (TextView)SmsContentTipActivity.this.findViewById(2131559423);
                  ((TextView)localObject4).setText((CharSequence)localObject2);
                  ((TextView)localObject4).setVisibility(0);
                }
                SmsContentTipActivity.this.findViewById(2131559429).setOnClickListener(new View.OnClickListener()
                {
                  public void onClick(View paramAnonymous2View)
                  {
                    if (SmsContentTipActivity.this.mOpType == 3)
                    {
                      paramAnonymous2View = new Intent(SmsContentTipActivity.this, MyMbSubPageActivity.class);
                      paramAnonymous2View.addFlags(67108864);
                      SmsContentTipActivity.this.startActivity(paramAnonymous2View);
                    }
                    for (;;)
                    {
                      SmsContentTipActivity.this.finish();
                      return;
                      if (SmsContentTipActivity.this.mPageId == 10)
                      {
                        paramAnonymous2View = new Intent(SmsContentTipActivity.this, IndexActivity.class);
                        paramAnonymous2View.putExtra("index_from", 16);
                        SmsContentTipActivity.this.startActivity(paramAnonymous2View);
                      }
                      else if (SmsContentTipActivity.this.mPageId == 14)
                      {
                        paramAnonymous2View = new Intent(SmsContentTipActivity.this, MyMbSubPageActivity.class);
                        paramAnonymous2View.putExtra("page_id", SmsContentTipActivity.this.mPageId);
                        paramAnonymous2View.addFlags(67108864);
                        SmsContentTipActivity.this.startActivity(paramAnonymous2View);
                      }
                      else if (SmsContentTipActivity.this.mPageId == 17)
                      {
                        paramAnonymous2View = new Intent(SmsContentTipActivity.this, MyMbSubPageActivity.class);
                        paramAnonymous2View.putExtra("page_id", SmsContentTipActivity.this.mPageId);
                        paramAnonymous2View.addFlags(67108864);
                        SmsContentTipActivity.this.startActivity(paramAnonymous2View);
                      }
                      else
                      {
                        paramAnonymous2View = new Intent(SmsContentTipActivity.this, IndexActivity.class);
                        SmsContentTipActivity.this.startActivity(paramAnonymous2View);
                      }
                    }
                  }
                });
                localObject2 = SmsContentTipActivity.this.findViewById(2131559424);
                if (SmsContentTipActivity.this.mOpType == 1)
                {
                  ((TextView)SmsContentTipActivity.this.findViewById(2131559422)).setText(2131231590);
                  ((View)localObject2).setVisibility(8);
                  SmsContentTipActivity.this.findViewById(2131559423).setVisibility(8);
                  di.a().b();
                  AccountPageActivity.mNeedRefreshEval = true;
                  return;
                }
              }
              paramAnonymousMessage = (e)paramAnonymousMessage.obj;
              if ((paramAnonymousMessage.c == null) || (paramAnonymousMessage.c.length() == 0)) {
                e.a(SmsContentTipActivity.this.getResources(), paramAnonymousMessage);
              }
              if ((paramAnonymousMessage.a == 146) && (SmsContentTipActivity.this.mSetRetryTimes < 4))
              {
                postDelayed(SmsContentTipActivity.this.mSetModMobileRunnable, 10000L);
                SmsContentTipActivity.access$2502(SmsContentTipActivity.this, true);
                return;
              }
              SmsContentTipActivity.this.errorTip.setVisibility(0);
              SmsContentTipActivity.this.errorTip.setText(paramAnonymousMessage.c);
              SmsContentTipActivity.this.resetBtn();
              return;
              localObject1 = (byte[])paramAnonymousMessage.obj;
              if ((paramAnonymousMessage.arg1 == 0) && (localObject1 != null) && (localObject1.length > 0)) {
                SmsContentTipActivity.access$802(SmsContentTipActivity.this, l.a((byte[])localObject1));
              }
              SmsContentTipActivity.this.gotoSetMobile();
              return;
              SmsContentTipActivity.this.gotoSetMobile();
            }
          }
        }
      }
      label2219:
      return;
    }
  };
  private boolean mIsActiveSuccess = false;
  private boolean mIsModSetSucc = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private boolean mIsUnbindSuccess = false;
  private String mMobile;
  private int mOpType;
  private int mPageId;
  private ProgressBar mPb;
  private int mSceneId;
  Runnable mSetModMobileRunnable = new Runnable()
  {
    public void run()
    {
      g.c("send mod set mbmobile");
      ca.a().a(0L, SmsContentTipActivity.this.mOpType, SmsContentTipActivity.this.mMobile, SmsContentTipActivity.this.mCountryCode, SmsContentTipActivity.this.mA2, SmsContentTipActivity.this.mHandler);
      SmsContentTipActivity.access$908(SmsContentTipActivity.this);
    }
  };
  private int mSetRetryTimes = 0;
  private String mSmsPort;
  private long mTimeConter;
  private String mTitle;
  private String mUin;
  private int mUnBindRetryTimes = 0;
  Runnable mUnBindRunnable = new Runnable()
  {
    public void run()
    {
      g.a("send unbind seq request:" + SmsContentTipActivity.this.mUnBindRetryTimes);
      if (!SmsContentTipActivity.this.mIsTimeTask) {
        return;
      }
      cb.c().n();
      ca.a().a(SmsContentTipActivity.this.mUserToUnbind.mUin, SmsContentTipActivity.this.mUserToUnbind.mRealUin, 1005, 0, SmsContentTipActivity.this.mHandler);
      SmsContentTipActivity.access$1008(SmsContentTipActivity.this);
    }
  };
  private UpgradeDeterminResult mUpDetermin = null;
  private QQUser mUser = null;
  private QQUser mUserToUnbind = null;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  private TextView mobileNum;
  private TextView okText;
  private TextView smsContent;
  private int upSmsSceneId;
  private TextView useTip;
  private String useTipContent;
  
  private void displaySucc()
  {
    resetBtn();
    dismissDialog();
    Object localObject = cq.a().d(this.mUser.mRealUin);
    if (localObject != null) {
      cq.a().b((QQUser)localObject);
    }
    cb.c().n();
    localObject = new Intent(this, VerifySuccActivity.class);
    ((Intent)localObject).putExtra("mRealUin", this.mUser.mRealUin);
    if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
      ((Intent)localObject).putExtra("mSourceId", 1);
    }
    startActivity((Intent)localObject);
    finish();
  }
  
  private void gotoSetMobile()
  {
    this.mSetRetryTimes = 0;
    this.mHandler.postDelayed(this.mSetModMobileRunnable, 10000L);
    this.isReadyModSetMB = true;
  }
  
  private void initView()
  {
    this.useTip = ((TextView)findViewById(2131559271));
    this.smsContent = ((TextView)findViewById(2131559274));
    this.mobileNum = ((TextView)findViewById(2131559277));
    this.errorTip = ((TextView)findViewById(2131559155));
    this.okText = ((TextView)findViewById(2131559278));
    this.btnLayout = findViewById(2131558721);
    this.mPb = ((ProgressBar)findViewById(2131559154));
    if ((this.upSmsSceneId == 0) || (this.upSmsSceneId == 7))
    {
      String str = this.mUpDetermin.b();
      if ((str == null) || (str.length() == 0))
      {
        finish();
        return;
      }
      this.useTipContent = String.format(getString(2131231525), new Object[] { this.mUpDetermin.b() });
      if (this.upSmsSceneId != 8) {
        break label348;
      }
      this.mobileNum.setText(this.mVerifyResult.e());
      this.smsContent.setText(this.mVerifyResult.d());
    }
    for (;;)
    {
      this.useTip.setText(this.useTipContent);
      this.btnLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SmsContentTipActivity.this.mPb.setVisibility(0);
          SmsContentTipActivity.this.okText.setText(SmsContentTipActivity.this.getResources().getString(2131231129));
          SmsContentTipActivity.this.btnLayout.setClickable(false);
          SmsContentTipActivity.this.errorTip.setVisibility(4);
          if ((SmsContentTipActivity.this.upSmsSceneId == 0) || (SmsContentTipActivity.this.upSmsSceneId == 7))
          {
            SmsContentTipActivity.access$3202(SmsContentTipActivity.this, false);
            SmsContentTipActivity.access$302(SmsContentTipActivity.this, SmsContentTipActivity.this.mUser.mRealUin + "");
          }
          SmsContentTipActivity.this.startTimeTask();
          SmsContentTipActivity.this.mHandler.sendEmptyMessage(3);
        }
      });
      return;
      if ((this.upSmsSceneId == 3) || (this.upSmsSceneId == 4))
      {
        this.useTipContent = String.format(getString(2131231525), new Object[] { this.mMobile });
        break;
      }
      if (this.upSmsSceneId == 6)
      {
        this.useTipContent = String.format(getString(2131231525), new Object[] { this.mUserToUnbind.mMobileMask });
        break;
      }
      if (this.upSmsSceneId != 8) {
        break;
      }
      this.useTipContent = String.format(getString(2131231525), new Object[] { this.mMobile });
      break;
      label348:
      this.mobileNum.setText(ProtoGetSMSChannel.d);
      this.smsContent.setText(ProtoGetSMSChannel.e);
    }
  }
  
  private void resetBtn()
  {
    this.mPb.setVisibility(4);
    this.okText.setText(getResources().getString(2131231121));
    this.btnLayout.setClickable(true);
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131231509, paramString, 2131230897, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (((this.mIsModSetSucc) || (this.mIsUnbindSuccess) || (this.mIsActiveSuccess)) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          if (this.isReadyModSetMB)
          {
            g.c(this + "---isReadyModSetMB:" + this.isReadyModSetMB + "\n----removeCallbacks(mSetModMobileRunnable)");
            this.mHandler.removeCallbacks(this.mSetModMobileRunnable);
            this.isReadyModSetMB = false;
          }
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        g.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.upSmsSceneId = getIntent().getIntExtra("up_sms_scene_id", -1);
    if ((this.upSmsSceneId == 0) || (this.upSmsSceneId == 7))
    {
      this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
      this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
      this.mSceneId = getIntent().getIntExtra("scene_id", 1004);
      if ((this.mUser == null) || (this.mUpDetermin == null)) {
        finish();
      }
    }
    else
    {
      if ((this.upSmsSceneId != 3) && (this.upSmsSceneId != 4)) {
        break label331;
      }
      this.mMobile = getIntent().getStringExtra("mobile");
      this.mSmsPort = getIntent().getStringExtra("sms_port");
      this.mCountryCode = getIntent().getStringExtra("area_code");
      this.mOpType = getIntent().getIntExtra("op_type", 1);
      this.mPageId = getIntent().getIntExtra("page_id", 10);
      this.mUser = cq.a().e();
      if (this.mUser == null)
      {
        finish();
        return;
      }
      this.mUin = (this.mUser.mRealUin + "");
    }
    for (;;)
    {
      setContentView(2130968764);
      initView();
      new Thread(this).start();
      if ((getIntent() == null) || (getIntent().getStringExtra("title") == null) || (getIntent().getStringExtra("title").length() <= 0)) {
        break;
      }
      this.mTitle = getIntent().getStringExtra("title");
      setTitle(this.mTitle);
      return;
      label331:
      if (this.upSmsSceneId == 6)
      {
        this.mUserToUnbind = ((QQUser)getIntent().getSerializableExtra("user_to_unbind"));
        if (this.mUserToUnbind == null) {
          finish();
        }
      }
      else if (this.upSmsSceneId == 8)
      {
        this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
        this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
        this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
        this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
        if ((this.mUser == null) || (this.mVerifyResult == null))
        {
          finish();
          return;
        }
        if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
          setNeverShowLockVerifyView();
        }
        this.mSceneId = 1007;
        this.mMobile = this.mVerifyResult.g();
        this.mUin = (this.mUser.mRealUin + "");
        this.mSmsPort = this.mVerifyResult.e();
        this.mCountryCode = "+86";
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
    u.c();
  }
  
  protected void onResume()
  {
    super.onResume();
    cb.c().a.a(this.mHandler);
  }
  
  protected void onStop()
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
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131231657, 2131230804, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        g.c("removeTimeTask showProgressDialog");
        SmsContentTipActivity.this.removeTimeTask();
      }
    });
  }
  
  public void startTimeTask()
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
  
  void unbindResult()
  {
    finish();
    AccountPageActivity.mNeedRefreshEval = true;
    cq.a().b();
    cq.a().k = false;
    Intent localIntent = new Intent(this, IndexActivity.class);
    localIntent.putExtra("index_from", 16);
    localIntent.putExtra("snap", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SmsContentTipActivity
 * JD-Core Version:    0.7.0.1
 */