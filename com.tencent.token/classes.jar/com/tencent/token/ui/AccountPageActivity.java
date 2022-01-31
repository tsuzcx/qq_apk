package com.tencent.token.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.captchasdk.TCaptchaPopupActivity;
import com.tencent.service.update.e;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.EvalAccountResult.RecommendItem;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.core.bean.d;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ds;
import com.tencent.token.du;
import com.tencent.token.er;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.GuideQQPimSecureTipsView;
import com.tencent.token.ui.base.PullToRefreshLinearLayout;
import com.tencent.token.ui.base.RecommendView;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.ui.base.ba;
import com.tencent.token.ui.base.bi;
import com.tencent.token.ui.base.ce;
import com.tencent.token.ui.qqpim.a;
import com.tencent.token.utils.k;
import com.tencent.token.utils.w;
import com.tmsdk.TMSDKContext;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class AccountPageActivity
  extends BaseActivity
  implements ce
{
  public static final String ACTION_ACCOUNT_OPR_MSG = "com.tencent.token.account_opr_msg";
  public static final int K_EVAL_RESULT_NO_URGENT = 0;
  private static final int VERIFYREQESTCODE = 1001;
  public static boolean mNeedRefreshEval = true;
  public static boolean mNeedShowIpcMsg = false;
  private final int NOTIFY_TO_DISPLAY_SUB_ITEM = 1000;
  private int[] color;
  private DisplayMetrics dm;
  private ba drawable;
  private int getNewMsgCount = 0;
  boolean isCurrentLoginResult = false;
  boolean isLastLoginResult = false;
  private boolean isLoading = false;
  private int itemCount = 3;
  private HashMap itemObjectMap = new HashMap();
  private View ll_eval_head;
  private bi loading;
  LocalBroadcastManager localBroadcastManager;
  private TranslateAnimation mAnimComeIn;
  private boolean mBingNotify = false;
  private View mBottomMarginView;
  private Button mDelSafeModeBtn;
  private TextView mDetailMsg;
  private View.OnClickListener mErrorAction = new ac(this);
  private ErrorView mErrorView;
  private View.OnClickListener mEvalClickListener = new y(this);
  private TextView mEvalLevel;
  private EvalAccountResult mEvalResult;
  private boolean mFromMBMobileLoseProtect = false;
  private GuideQQPimSecureTipsView mGuideQQPimSecureTipsView;
  public Handler mHandler = new ad(this);
  private ImageView mLoading;
  private ImageView mLoadingResult;
  private int mLoginDegree = 0;
  private TextView mLoginHistoryDesc;
  private ImageView mLoginHistoryPic;
  private ImageView mLoginHistoryPicArray;
  private er mLoginMsgCache = ds.a().f;
  private View.OnClickListener mMbDefaultListener = new ab(this);
  private TextView mMbDesc;
  private RelativeLayout mMbLayout;
  private ImageView mMbPic;
  private ImageView mMbPicArray;
  private TextView mMbTitle;
  private ImageView mMsgUnread;
  private TextView mNotVerify;
  private RelativeLayout mPermissionGuideLayout;
  private View.OnClickListener mPswDefaultListener = new aa(this);
  private TextView mPswDesc;
  private RelativeLayout mPswLayout;
  private ImageView mPswPic;
  private ImageView mPswPicArray;
  private TextView mPswTitle;
  private PullToRefreshLinearLayout mPullToRefreshLayout;
  private RoundImageView mQQFace;
  private ImageView mQQFaceBorder;
  private ImageView mQQFaceCircle;
  private TextView mQQNick;
  private RelativeLayout mQQPimProtectLayout;
  private ImageView mQQpimArray;
  private ImageView mQQpimPic;
  private TextView mQQpimProtectDesc;
  private TextView mQQpimProtectTitle;
  private Dialog mQryBindNotifyMsgDialog;
  private BroadcastReceiver mReceiver = new l(this);
  private View mRootLayout;
  private ImageView mSafeMsgBox;
  private er mSafeMsgCache = du.a().f;
  private ScrollView mScrollView;
  private String mSkey = "";
  private cw mTokenCore = cw.a();
  private QQUser mUser;
  private Button mZzbDelSafeModeBtn;
  private TextView mZzbDetailMsg;
  private TextView mZzbEvalLevel;
  private ImageView mZzbLoadingImg;
  private ImageView mZzbLoadingImgResult;
  private RecommendView mZzbRecomView;
  private boolean needgotologobyprotect;
  private int newMsgCount = 0;
  protected QueryCaptchaResult queryCaptchaResult;
  private RelativeLayout rl_eval;
  private RelativeLayout rl_eval_zzb;
  private View rl_login;
  
  private void displayItemOneByOne(EvalAccountResult paramEvalAccountResult)
  {
    if (paramEvalAccountResult == null) {
      return;
    }
    int k = 0;
    int j = 0;
    int i = 0;
    EvalAccountResult.RecommendItem localRecommendItem;
    int m;
    d locald;
    if (k < paramEvalAccountResult.mRecommends.size())
    {
      localRecommendItem = (EvalAccountResult.RecommendItem)paramEvalAccountResult.mRecommends.get(k);
      m = localRecommendItem.mRecommendId;
      if (m == 2)
      {
        locald = (d)this.itemObjectMap.get(Integer.valueOf(m));
        locald.a(localRecommendItem);
        locald.a(new al(this, localRecommendItem));
        m = 1;
        j = i;
        i = m;
      }
    }
    for (;;)
    {
      k += 1;
      m = j;
      j = i;
      i = m;
      break;
      if (m == 4)
      {
        locald = (d)this.itemObjectMap.get(Integer.valueOf(m));
        locald.a(localRecommendItem);
        locald.a(new am(this, localRecommendItem));
        i = j;
        j = 1;
        continue;
        if (i == 0)
        {
          this.mMbLayout.setVisibility(8);
          if (j != 0) {
            break label219;
          }
          this.mPswLayout.setVisibility(8);
        }
        for (;;)
        {
          this.mHandler.sendEmptyMessageDelayed(1000, 30L);
          return;
          this.mMbLayout.setVisibility(0);
          break;
          label219:
          this.mPswLayout.setVisibility(0);
        }
      }
      else
      {
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  private void gotoQuickLoginWb(boolean paramBoolean)
  {
    this.mFromMBMobileLoseProtect = paramBoolean;
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void gotologobyprotect()
  {
    if (do.a().e() == null) {
      return;
    }
    gotoQuickLoginWb(true);
  }
  
  private void hideSafeMode()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ll_eval_head.getLayoutParams();
    localLayoutParams.height = ((int)(250.0F * IndexActivity.S_DENSITY));
    this.ll_eval_head.setLayoutParams(localLayoutParams);
    this.ll_eval_head.postInvalidate();
    this.mZzbDetailMsg.setVisibility(8);
    this.mZzbDelSafeModeBtn.setVisibility(8);
    this.mDetailMsg.setVisibility(8);
    this.mDelSafeModeBtn.setVisibility(8);
  }
  
  private void initItemDataObject()
  {
    d locald = new d(this, this.mPswLayout, this.mPswTitle, this.mPswDesc, this.mPswPic, null, this.mPswPicArray);
    locald.a(2);
    locald.a(this.mPswDefaultListener);
    this.itemObjectMap.put(Integer.valueOf(2), locald);
    locald = new d(this, this.mMbLayout, this.mMbTitle, this.mMbDesc, this.mMbPic, null, this.mMbPicArray);
    locald.a(4);
    locald.a(this.mMbDefaultListener);
    this.itemObjectMap.put(Integer.valueOf(4), locald);
  }
  
  private void initView()
  {
    setContentView(2130968607);
    this.mRootLayout = findViewById(2131558585);
    this.mPullToRefreshLayout = ((PullToRefreshLinearLayout)findViewById(2131558594));
    this.mPullToRefreshLayout.setRefreshListener(this);
    this.mBottomMarginView = findViewById(2131558642);
    this.ll_eval_head = findViewById(2131558596);
    this.mRootLayout.setBackgroundDrawable(this.drawable);
    this.mZzbRecomView = ((RecommendView)findViewById(2131558611));
    this.mGuideQQPimSecureTipsView = ((GuideQQPimSecureTipsView)findViewById(2131558612));
    this.mGuideQQPimSecureTipsView.a();
    this.mScrollView = ((ScrollView)findViewById(2131558595));
    this.rl_eval = ((RelativeLayout)findViewById(2131558597));
    this.rl_eval.setEnabled(false);
    this.rl_eval.setOnClickListener(this.mEvalClickListener);
    this.rl_eval_zzb = ((RelativeLayout)findViewById(2131558604));
    this.rl_eval_zzb.setVisibility(4);
    this.rl_eval_zzb.setEnabled(false);
    this.rl_eval_zzb.setOnClickListener(this.mEvalClickListener);
    this.rl_login = findViewById(2131558613);
    this.rl_login.setOnClickListener(new r(this));
    this.mQQFace = ((RoundImageView)findViewById(2131558587));
    this.mQQFace.setOnClickListener(new s(this));
    this.mLoading = ((ImageView)findViewById(2131558599));
    this.mLoadingResult = ((ImageView)findViewById(2131558600));
    this.mZzbLoadingImg = ((ImageView)findViewById(2131558607));
    this.mZzbLoadingImgResult = ((ImageView)findViewById(2131558606));
    this.mQQNick = ((TextView)findViewById(2131558591));
    this.mQQFaceCircle = ((ImageView)findViewById(2131558588));
    this.mQQFaceBorder = ((ImageView)findViewById(2131558589));
    this.mSafeMsgBox = ((ImageView)findViewById(2131558592));
    this.mSafeMsgBox.setOnClickListener(new t(this));
    this.mMsgUnread = ((ImageView)findViewById(2131558593));
    this.mLoginHistoryDesc = ((TextView)findViewById(2131558616));
    this.mLoginHistoryPic = ((ImageView)findViewById(2131558618));
    this.mLoginHistoryPicArray = ((ImageView)findViewById(2131558617));
    this.mNotVerify = ((TextView)findViewById(2131558590));
    this.mEvalLevel = ((TextView)findViewById(2131558601));
    this.mZzbEvalLevel = ((TextView)findViewById(2131558608));
    this.mDetailMsg = ((TextView)findViewById(2131558602));
    this.mZzbDetailMsg = ((TextView)findViewById(2131558609));
    this.mDelSafeModeBtn = ((Button)findViewById(2131558603));
    this.mZzbDelSafeModeBtn = ((Button)findViewById(2131558610));
    this.mUser = do.a().e();
    if (this.mUser == null)
    {
      this.mMsgUnread.setVisibility(4);
      this.rl_eval.setVisibility(0);
      this.rl_eval.setEnabled(true);
      this.ll_eval_head.setClickable(true);
      this.mEvalLevel.setText(2131230760);
      this.rl_eval_zzb.setVisibility(8);
    }
    for (;;)
    {
      this.mPswLayout = ((RelativeLayout)findViewById(2131558625));
      this.mMbLayout = ((RelativeLayout)findViewById(2131558619));
      this.mPermissionGuideLayout = ((RelativeLayout)findViewById(2131558637));
      this.mQQPimProtectLayout = ((RelativeLayout)findViewById(2131558631));
      this.mQQpimProtectTitle = ((TextView)findViewById(2131558633));
      this.mQQpimProtectDesc = ((TextView)findViewById(2131558634));
      this.mQQpimPic = ((ImageView)findViewById(2131558636));
      this.mQQpimArray = ((ImageView)findViewById(2131558635));
      this.mPswTitle = ((TextView)findViewById(2131558627));
      this.mMbTitle = ((TextView)findViewById(2131558621));
      this.mPswDesc = ((TextView)findViewById(2131558628));
      this.mMbDesc = ((TextView)findViewById(2131558622));
      this.mPswPic = ((ImageView)findViewById(2131558630));
      this.mMbPic = ((ImageView)findViewById(2131558624));
      this.mPswPicArray = ((ImageView)findViewById(2131558629));
      this.mMbPicArray = ((ImageView)findViewById(2131558623));
      tryShowGuideTipsAsync();
      return;
      if (this.mUser.mIsZzb)
      {
        this.rl_eval.setVisibility(8);
        this.rl_eval_zzb.setVisibility(0);
        this.mZzbEvalLevel.setText(2131231132);
      }
      else
      {
        this.rl_eval.setVisibility(0);
        this.rl_eval_zzb.setVisibility(8);
        this.mEvalLevel.setText(2131231132);
      }
    }
  }
  
  private void judgeNextStep()
  {
    if (this.mFromMBMobileLoseProtect)
    {
      com.tencent.token.core.protocolcenter.c.a = 1;
      return;
    }
    ds.a().a(ds.e, this.mSkey, this.mHandler);
  }
  
  private void loadLastLoginLocation()
  {
    QQUser localQQUser = do.a().e();
    if (localQQUser == null)
    {
      resetItemStatus();
      return;
    }
    refreshLoginLocation(getResources().getString(2131231158));
    this.newMsgCount = 0;
    byte[] arrayOfByte = cp.a(RqdApplication.l()).b(do.a().e().mRealUin);
    if (arrayOfByte != null)
    {
      this.mSkey = w.a(arrayOfByte);
      ds.a().a(ds.e, this.mSkey, this.mHandler);
      return;
    }
    cp.a(RqdApplication.l()).a("" + localQQUser.mRealUin, this.mHandler, 523005419L, 64);
  }
  
  private void loadNewSafeMsg()
  {
    do localdo = do.a();
    QQUser localQQUser = localdo.e();
    if ((!localdo.o()) || (localQQUser == null)) {
      return;
    }
    du.a().a(this.mHandler);
  }
  
  private void refreshEvalView()
  {
    h.b("refreshEvalView() ");
    this.mUser = do.a().e();
    if (this.mUser == null) {
      return;
    }
    int i;
    Object localObject2;
    Object localObject1;
    if (this.mEvalResult.mDegree >= this.mLoginDegree)
    {
      i = this.mEvalResult.mDegree;
      localObject2 = this.mEvalResult.mTitle;
      localObject1 = localObject2;
      if (this.mEvalResult.mDegree == 0)
      {
        localObject1 = localObject2;
        if (this.mLoginDegree == 1) {
          localObject1 = getResources().getString(2131230761);
        }
      }
      if (!this.mUser.mIsZzb) {
        break label396;
      }
      LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
      localObject2 = new Intent("com.tencent.token.refresh_statusbar");
      ((Intent)localObject2).putExtra("color", 2131492882);
      LocalBroadcastManager.getInstance(this).sendBroadcast((Intent)localObject2);
      h.c("send action amend color = " + this.color);
      this.mZzbLoadingImg.setVisibility(4);
      this.mZzbLoadingImgResult.setVisibility(0);
      this.rl_eval_zzb.setEnabled(true);
      this.ll_eval_head.setEnabled(true);
      this.mZzbEvalLevel.setVisibility(0);
      this.mZzbEvalLevel.setText((CharSequence)localObject1);
      if (i != 0) {
        break label349;
      }
      this.mZzbLoadingImgResult.setImageResource(2130837889);
      this.drawable.a(20, this.color[6], this.color[7]);
      label257:
      if ((this.mEvalResult.mDesc == null) || (this.mEvalResult.mDesc.length() <= 0) || (this.mEvalResult.mStatus == 4)) {
        break label389;
      }
    }
    label389:
    for (RqdApplication.e = this.mEvalResult.mDesc;; RqdApplication.e = null)
    {
      this.mPullToRefreshLayout.b();
      this.mRootLayout.invalidate();
      this.mRootLayout.postInvalidate();
      LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
      return;
      i = this.mLoginDegree;
      break;
      label349:
      this.mZzbLoadingImgResult.setImageResource(2130837883);
      this.drawable.a(20, this.color[(i * 2)], this.color[(i * 2 + 1)]);
      break label257;
    }
    label396:
    this.mLoading.setVisibility(4);
    this.mLoadingResult.setVisibility(0);
    if (this.mEvalResult.mDegree == 2)
    {
      this.mLoadingResult.setImageResource(2130837888);
      LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
      localObject2 = new Intent("com.tencent.token.refresh_statusbar");
      ((Intent)localObject2).putExtra("color", 2131492877);
      LocalBroadcastManager.getInstance(this).sendBroadcast((Intent)localObject2);
      h.c("send action amend color = " + this.color);
      label508:
      this.rl_eval.setEnabled(true);
      this.ll_eval_head.setEnabled(true);
      this.mEvalLevel.setVisibility(0);
      this.mEvalLevel.setText((CharSequence)localObject1);
      if ((this.mEvalResult.mDesc == null) || (this.mEvalResult.mDesc.length() <= 0) || (this.mEvalResult.mStatus == 4)) {
        break label801;
      }
    }
    label801:
    for (RqdApplication.e = this.mEvalResult.mDesc;; RqdApplication.e = null)
    {
      this.drawable.a(20, this.color[(i * 2)], this.color[(i * 2 + 1)]);
      break;
      if (this.mEvalResult.mDegree == 1)
      {
        this.mLoadingResult.setImageResource(2130837882);
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
        localObject2 = new Intent("com.tencent.token.refresh_statusbar");
        ((Intent)localObject2).putExtra("color", 2131492880);
        LocalBroadcastManager.getInstance(this).sendBroadcast((Intent)localObject2);
        h.c("send action amend color = " + this.color);
        break label508;
      }
      this.mLoadingResult.setImageResource(2130837886);
      LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
      localObject2 = new Intent("com.tencent.token.refresh_statusbar");
      ((Intent)localObject2).putExtra("color", 2131492875);
      LocalBroadcastManager.getInstance(this).sendBroadcast((Intent)localObject2);
      h.c("send action amend color = " + this.color);
      break label508;
    }
  }
  
  private void refreshUinPanel()
  {
    QQUser localQQUser = do.a().e();
    if (localQQUser != null)
    {
      this.mQQNick.setText(localQQUser.mNickName);
      h.c("account page bindview nick=" + localQQUser.mNickName + ", uin=" + localQQUser.mUin);
      this.mQQFace.setImageDrawable(k.a(localQQUser.b() + "", localQQUser.mUin + ""));
      if (localQQUser.mIsBinded) {
        this.mNotVerify.setVisibility(4);
      }
      while (localQQUser.mIsZzb)
      {
        this.mQQFaceCircle.setImageDrawable(getResources().getDrawable(2130838076));
        this.mQQFaceCircle.setVisibility(0);
        this.mQQFaceBorder.setVisibility(0);
        return;
        this.mNotVerify.setVisibility(0);
      }
      this.mQQFaceCircle.setImageDrawable(getResources().getDrawable(2130837599));
      this.mQQFaceCircle.setVisibility(0);
      this.mQQFaceBorder.setVisibility(4);
      return;
    }
    this.mMsgUnread.setVisibility(4);
    this.rl_eval.setVisibility(0);
    this.rl_eval.setEnabled(true);
    this.rl_eval_zzb.setVisibility(8);
    this.mQQNick.setText(getResources().getString(2131231267));
    this.mQQFaceCircle.setVisibility(4);
    this.mQQFaceBorder.setVisibility(4);
    this.mQQFace.setImageResource(2130837842);
    this.mNotVerify.setVisibility(4);
    this.mEvalLevel.setText(getResources().getString(2131230760));
    this.mLoading.setVisibility(4);
    this.mLoadingResult.setVisibility(0);
    this.mLoadingResult.setImageResource(2130837885);
  }
  
  private void resetItemStatus()
  {
    this.mLoginHistoryPic.setVisibility(4);
    if (do.a().e() != null) {
      this.mLoginHistoryPicArray.setVisibility(4);
    }
    for (;;)
    {
      this.mLoginHistoryDesc.setTextColor(getResources().getColor(2131493051));
      this.mLoginHistoryDesc.setText(getResources().getString(2131231251));
      this.itemCount = 3;
      if ((this.itemObjectMap != null) && (this.itemObjectMap.size() != 0))
      {
        if (this.itemObjectMap.get(Integer.valueOf(2)) != null) {
          ((d)this.itemObjectMap.get(Integer.valueOf(2))).b(this.mPswDefaultListener);
        }
        if (this.itemObjectMap.get(Integer.valueOf(4)) != null) {
          ((d)this.itemObjectMap.get(Integer.valueOf(4))).b(this.mMbDefaultListener);
        }
      }
      if (this.mHandler != null) {
        this.mHandler.removeMessages(1000);
      }
      return;
      this.mLoginHistoryPicArray.setVisibility(0);
    }
  }
  
  private void selectView(f paramf, Message paramMessage)
  {
    if ((paramf != null) && (paramMessage != null) && (paramMessage.arg1 != 110) && (paramMessage.arg1 != 111))
    {
      h.c("----result.mErrCode: " + paramf.a);
      h.c("----result.mErrDebug: " + paramf.b);
      if (this.mErrorView == null)
      {
        this.mErrorView = new ErrorView(this);
        this.mErrorView.setAction(this.mErrorAction);
        addContentView(this.mErrorView);
      }
      this.mErrorView.setErrorType(paramf.a);
      this.mErrorView.setTag(Integer.valueOf(paramMessage.what));
      this.mErrorView.a();
      bringChildToFront(this.mErrorView);
      setRightTitleImageHide();
      return;
    }
    this.mUser = do.a().e();
    if ((this.mUser == null) || ((paramMessage != null) && ((paramMessage.arg1 == 110) || (paramMessage.arg1 == 111))))
    {
      do.a().k = false;
      mNeedRefreshEval = true;
      return;
    }
    if (this.mErrorView != null) {
      this.mErrorView.b();
    }
    setLoadingOn();
    loadLastLoginLocation();
  }
  
  private void setLoadingOn()
  {
    this.isLoading = true;
    this.mUser = do.a().e();
    if (this.mUser == null) {
      return;
    }
    Intent localIntent;
    if (this.mUser.mIsZzb)
    {
      this.loading = new bi(this, true);
      this.drawable.a(this.color[6], this.color[7]);
      localIntent = new Intent("com.tencent.token.refresh_statusbar");
      localIntent.putExtra("color", 2131492882);
      LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
      h.c("send action amend color = " + this.color);
      this.loading.setBounds(this.mLoading.getLeft(), this.mLoading.getTop(), this.mLoading.getRight(), this.mLoading.getBottom());
      if (!this.mUser.mIsZzb) {
        break label386;
      }
      this.rl_eval.setVisibility(4);
      this.rl_eval_zzb.setVisibility(0);
      this.mZzbLoadingImg.setImageDrawable(this.loading);
      this.mZzbLoadingImg.setVisibility(0);
      this.mZzbLoadingImgResult.setVisibility(4);
      this.mZzbEvalLevel.setVisibility(0);
      this.mZzbEvalLevel.setText(2131231132);
    }
    for (;;)
    {
      this.mLoginHistoryDesc.setText(getResources().getString(2131231130));
      this.rl_login.setEnabled(false);
      ((d)this.itemObjectMap.get(Integer.valueOf(2))).a(1, null);
      ((d)this.itemObjectMap.get(Integer.valueOf(4))).a(1, null);
      return;
      this.loading = new bi(this, false);
      this.drawable.a(this.color[0], this.color[1]);
      localIntent = new Intent("com.tencent.token.refresh_statusbar");
      localIntent.putExtra("color", 2131492875);
      LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
      h.c("send action amend color = " + this.color);
      break;
      label386:
      this.rl_eval.setVisibility(0);
      this.rl_eval_zzb.setVisibility(4);
      this.mLoading.setImageDrawable(this.loading);
      this.mLoading.setVisibility(0);
      this.mLoadingResult.setVisibility(4);
      this.mEvalLevel.setText(2131231132);
    }
  }
  
  private void showQQPimProtectView()
  {
    boolean bool = a.b(this, "com.tencent.qqpim");
    long l = e.a().b();
    if ((!bool) && (System.currentTimeMillis() - l > 604800000L))
    {
      TMSDKContext.saveActionData(170019);
      this.mQQPimProtectLayout.setVisibility(0);
      e.a().a(System.currentTimeMillis());
      this.mQQPimProtectLayout.setOnClickListener(new ak(this));
    }
  }
  
  private boolean showSafeMode(EvalAccountResult paramEvalAccountResult)
  {
    if (paramEvalAccountResult == null) {
      return false;
    }
    QQUser localQQUser = do.a().e();
    if ((localQQUser != null) && (paramEvalAccountResult.mStatus == 4) && ((paramEvalAccountResult.mSubStatus == 0) || (paramEvalAccountResult.mSubStatus == 1)))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ll_eval_head.getLayoutParams();
      localLayoutParams.height = (this.mPullToRefreshLayout.getHeight() + this.mBottomMarginView.getHeight());
      this.ll_eval_head.setLayoutParams(localLayoutParams);
      this.ll_eval_head.postInvalidate();
      this.mScrollView.pageScroll(33);
      this.mScrollView.setOnTouchListener(new o(this));
      if (localQQUser.mIsZzb)
      {
        this.mZzbDetailMsg.setVisibility(0);
        this.mZzbDelSafeModeBtn.setVisibility(0);
        this.mZzbDetailMsg.setText(paramEvalAccountResult.mDesc);
        if (paramEvalAccountResult.mSubStatus == 0) {
          this.mZzbDelSafeModeBtn.setText(getResources().getString(2131230924));
        }
        for (;;)
        {
          this.mZzbDelSafeModeBtn.setOnClickListener(new p(this, paramEvalAccountResult));
          return true;
          this.mZzbDelSafeModeBtn.setText(getResources().getString(2131231385));
        }
      }
      this.mDetailMsg.setVisibility(0);
      this.mDelSafeModeBtn.setVisibility(0);
      this.mDetailMsg.setText(paramEvalAccountResult.mDesc);
      if (paramEvalAccountResult.mSubStatus == 0) {
        this.mDelSafeModeBtn.setText(getResources().getString(2131230924));
      }
      for (;;)
      {
        this.mDelSafeModeBtn.setOnClickListener(new q(this, paramEvalAccountResult));
        break;
        this.mDelSafeModeBtn.setText(getResources().getString(2131231385));
      }
    }
    return false;
  }
  
  private void showZzbRecommendView()
  {
    this.mZzbRecomView.setEnabled(true);
    this.mZzbRecomView.setOnClickListener(new an(this));
    this.dm = getResources().getDisplayMetrics();
    int i = this.dm.widthPixels;
    this.mZzbRecomView.layout(i, this.mZzbRecomView.getTop(), (int)this.mZzbRecomView.getViewWidth() + i, this.mZzbRecomView.getBottom());
    h.c("w_screen---" + i + "\nmZzbRecomView.getViewWidth()---" + this.mZzbRecomView.getViewWidth());
    this.mAnimComeIn = new TranslateAnimation((int)this.mZzbRecomView.getViewWidth(), 0.0F, 0.0F, 0.0F);
    this.mAnimComeIn.setDuration(500L);
    this.mAnimComeIn.setFillAfter(true);
    this.mZzbRecomView.setShowBink(false);
    this.mZzbRecomView.postDelayed(new m(this, i), 100L);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((c.f()) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
      mNeedRefreshEval = true;
      exitToken();
      return true;
    }
  }
  
  protected void gotoVerifyActivity(QueryCaptchaResult paramQueryCaptchaResult)
  {
    this.queryCaptchaResult = paramQueryCaptchaResult;
    Intent localIntent = new Intent(this, TCaptchaPopupActivity.class);
    if (paramQueryCaptchaResult != null) {
      localIntent.putExtra("appid", paramQueryCaptchaResult.mAppid);
    }
    startActivityForResult(localIntent, 1001);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    label114:
    label126:
    do
    {
      for (;;)
      {
        return;
        if (paramInt1 != 1001) {
          break label126;
        }
        if (paramInt2 != -1) {
          break label114;
        }
        try
        {
          paramIntent = new JSONObject(paramIntent.getStringExtra("retJson"));
          if (paramIntent.getInt("ret") == 0)
          {
            if (this.queryCaptchaResult == null) {
              continue;
            }
            cw.a().d(this.queryCaptchaResult.mRealUin, this.queryCaptchaResult.mSceneId, paramIntent.getString("ticket"), paramIntent.getString("randstr"), this.mHandler);
          }
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      Toast.makeText(this, "未验证成功", 0).show();
      return;
      Toast.makeText(this, "未验证成功", 0).show();
      return;
      if ((paramInt1 == 1201) || (paramInt1 == 1202))
      {
        cp.a(getApplicationContext()).a(paramIntent);
        return;
      }
      paramIntent = (EvalAccountResult)paramIntent.getSerializableExtra("eval_result");
    } while (paramIntent == null);
    this.mEvalResult = paramIntent;
    refreshEvalView();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    if (cx.c().g()) {
      cw.a().a(this.mHandler);
    }
    this.color = new int[] { getResources().getColor(2131492875), getResources().getColor(2131492874), getResources().getColor(2131492880), getResources().getColor(2131492879), getResources().getColor(2131492877), getResources().getColor(2131492876), getResources().getColor(2131492882), getResources().getColor(2131492881) };
    this.mUser = do.a().e();
    if ((this.mUser != null) && (this.mUser.mIsZzb))
    {
      this.drawable = new ba(GradientDrawable.Orientation.LEFT_RIGHT, this.color[6], this.color[7]);
      initView();
      hideTitle();
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.token.account_opr_msg");
      this.localBroadcastManager = LocalBroadcastManager.getInstance(this);
      this.localBroadcastManager.registerReceiver(this.mReceiver, paramBundle);
      initItemDataObject();
      if (RqdApplication.f)
      {
        RqdApplication.f = false;
        if (do.a().e() != null) {
          break label309;
        }
        showNoAccountTipDialog(this, 20, 0);
      }
    }
    for (;;)
    {
      TMSDKContext.SaveStringData(1150057, "");
      return;
      this.drawable = new ba(GradientDrawable.Orientation.LEFT_RIGHT, this.color[0], this.color[1]);
      break;
      label309:
      if (!do.a().e().mIsBinded) {
        showNoAccountTipDialog(this, 20, 1);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    mNeedRefreshEval = true;
    do.a().k = false;
    if (this.localBroadcastManager != null) {
      this.localBroadcastManager.unregisterReceiver(this.mReceiver);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  public void onRefresh(PullToRefreshLinearLayout paramPullToRefreshLinearLayout)
  {
    this.mZzbRecomView.setVisibility(4);
    if (do.a().e() != null)
    {
      mNeedRefreshEval = true;
      onResume();
      this.mHandler.postDelayed(new z(this), 6000L);
      return;
    }
    this.mPullToRefreshLayout.b();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.mGuideQQPimSecureTipsView != null) {
      this.mGuideQQPimSecureTipsView.a();
    }
    h.a("mmdb1 seed=" + cx.c().j());
    QQUser localQQUser = do.a().e();
    LoginMsgActivity.setShowNewMsgCnt(false, 0);
    if ((!RqdApplication.b) && (this.needgotologobyprotect))
    {
      gotologobyprotect();
      this.needgotologobyprotect = false;
      return;
    }
    if ((mNeedRefreshEval) || (do.a().i()))
    {
      if ((this.mErrorView != null) && (this.mErrorView.getVisibility() == 0)) {
        this.mErrorView.b();
      }
      this.mZzbRecomView.setVisibility(4);
      if ((this.mZzbDelSafeModeBtn.getVisibility() != 8) || (this.mDelSafeModeBtn.getVisibility() != 8)) {
        hideSafeMode();
      }
      this.mScrollView.setOnTouchListener(null);
      if (localQQUser == null) {
        break label262;
      }
      refreshLoginLocation(getResources().getString(2131231158));
      if (!localQQUser.mIsZzb) {
        break label240;
      }
      this.drawable.a(this.color[6], this.color[7]);
      resetItemStatus();
      refreshUinPanel();
      setLoadingOn();
      if (!do.a().k) {
        break label309;
      }
      loadLastLoginLocation();
    }
    for (;;)
    {
      refreshUinPanel();
      return;
      label240:
      this.drawable.a(this.color[0], this.color[1]);
      break;
      label262:
      this.mLoginHistoryDesc.setText(getResources().getString(2131231251));
      this.mMsgUnread.setVisibility(4);
      this.drawable.a(this.color[0], this.color[1]);
      break;
      label309:
      if (!cx.c().g()) {
        this.mTokenCore.b(this.mHandler);
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  public void refreshLoginLocation()
  {
    Object localObject = this.mLoginMsgCache.a();
    if (localObject != null)
    {
      localObject = ((SafeMsgItem)localObject).d();
      this.isLastLoginResult = true;
      this.isCurrentLoginResult = true;
    }
    for (;;)
    {
      refreshLoginLocation((String)localObject);
      return;
      localObject = null;
    }
  }
  
  public void refreshLoginLocation(String paramString)
  {
    String str;
    if (paramString == null)
    {
      str = getResources().getString(2131231160);
      this.isLastLoginResult = true;
      this.mLoginDegree = 0;
      if (!mNeedShowIpcMsg) {
        break label166;
      }
      str = getResources().getString(2131231157);
      this.mLoginDegree = 1;
      label47:
      if ((paramString == null) || (!paramString.equals(getResources().getString(2131231158)))) {
        break label196;
      }
      paramString = getResources().getString(2131230772);
      if ((!this.isLastLoginResult) || (!this.isCurrentLoginResult)) {
        break label304;
      }
      this.mLoginHistoryDesc.setText(paramString + " " + str);
    }
    for (;;)
    {
      this.isLastLoginResult = false;
      this.isCurrentLoginResult = false;
      return;
      str = getResources().getString(2131231159) + paramString;
      break;
      label166:
      int i = str.indexOf('|');
      if (i != -1)
      {
        str = str.substring(0, i);
        this.isLastLoginResult = true;
        break label47;
      }
      break label47;
      label196:
      if ((ds.a().b != null) && (ds.a().b.mDevicesList != null) && (ds.a().b.mDevicesList.size() > 0)) {}
      for (paramString = String.format(getResources().getString(2131230771), new Object[] { Integer.valueOf(ds.a().b.mDevicesList.size()) });; paramString = String.format(getResources().getString(2131230771), new Object[] { Integer.valueOf(0) }))
      {
        this.isCurrentLoginResult = true;
        break;
      }
      label304:
      this.mLoginHistoryDesc.setText(getResources().getString(2131231130));
    }
  }
  
  void tryShowGuideTipsAsync()
  {
    new Thread(new u(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AccountPageActivity
 * JD-Core Version:    0.7.0.1
 */