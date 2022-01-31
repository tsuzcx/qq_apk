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
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.bb;
import com.tencent.token.bd;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.EvalAccountResult.RecommendItem;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.core.bean.SecurityReporterResult;
import com.tencent.token.fo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.PullToRefreshLinearLayout;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.ui.base.ba;
import com.tencent.token.ui.base.bp;
import com.tencent.token.ui.base.cp;
import com.tencent.token.utils.k;
import java.util.ArrayList;
import java.util.HashMap;

public class AccountPageActivity
  extends BaseActivity
  implements cp
{
  public static final String ACTION_ACCOUNT_OPR_MSG = "com.tencent.token.account_opr_msg";
  public static final int K_EVAL_RESULT_NO_URGENT = 0;
  public static final int K_EVAL_RESULT_STRONG_URGENT = 2;
  public static final int K_EVAL_RESULT_WEAK_URGENT = 1;
  public static boolean mNeedRefreshEval = true;
  public static boolean mNeedShowIpcMsg = false;
  private final int NOTIFY_TO_DISPLAY_SUB_ITEM = 1000;
  private int[] color;
  private ba drawable;
  private int getNewMsgCount = 0;
  private boolean isChecking = false;
  private boolean isCheckingLoginHistory = false;
  private boolean isCheckingMb = false;
  private boolean isCheckingProtection = false;
  private boolean isCheckingPwd = false;
  boolean isCurrentLoginResult = false;
  boolean isLastLoginResult = false;
  private int itemCount = 3;
  private HashMap itemObjectMap = new HashMap();
  private View ll_eval_head;
  private bp loading;
  LocalBroadcastManager localBroadcastManager;
  private boolean mBingNotify = false;
  private Button mDelSafeModeBtn;
  private TextView mDetailMsg;
  private View.OnClickListener mErrorAction = new z(this);
  private ErrorView mErrorView;
  private View.OnClickListener mEvalClickListener = new u(this);
  private TextView mEvalLevel;
  private EvalAccountResult mEvalResult;
  public Handler mHandler = new aa(this);
  private ImageView mLoading;
  private ImageView mLoadingResult;
  private int mLoginDegree = 0;
  private TextView mLoginHistoryDesc;
  private ImageView mLoginHistoryPic;
  private TextView mLoginHistoryTitle;
  private fo mLoginMsgCache = bb.a().f;
  private View.OnClickListener mMbDefaultListener = new y(this);
  private TextView mMbDesc;
  private RelativeLayout mMbLayout;
  private ImageView mMbPic;
  private TextView mMbTitle;
  private ImageView mMsgUnread;
  private TextView mNotVerify;
  private TextView mOperateMsg;
  private View.OnClickListener mProtecDefaultListener = new x(this);
  private TextView mProtectionDesc;
  private RelativeLayout mProtectionLayout;
  private ImageView mProtectionPic;
  private TextView mProtectionTitle;
  private View.OnClickListener mPswDefaultListener = new w(this);
  private TextView mPswDesc;
  private RelativeLayout mPswLayout;
  private ImageView mPswPic;
  private TextView mPswTitle;
  private PullToRefreshLinearLayout mPullToRefreshLayout;
  private RoundImageView mQQFace;
  private ImageView mQQFaceBorder;
  private ImageView mQQFaceCircle;
  private TextView mQQNick;
  private Dialog mQryBindNotifyMsgDialog;
  private boolean mQuerySecurityReporter = false;
  private BroadcastReceiver mReceiver = new n(this);
  private View mRootLayout;
  private ImageView mSafeMsgBox;
  private fo mSafeMsgCache = bd.a().f;
  private ScrollView mScrollView;
  private String mSessId;
  private String mSkey = "";
  private RelativeLayout mTitleLayout;
  private af mTokenCore = af.a();
  private long mUinHash;
  private QQUser mUser;
  private Button mZzbDelSafeModeBtn;
  private TextView mZzbDetailMsg;
  private TextView mZzbEvalLevel;
  private ImageView mZzbLoadingImg;
  private ImageView mZzbLoadingImgResult;
  private boolean needgotologobyprotect;
  private int newMsgCount = 0;
  private SecurityReporterResult result;
  private RelativeLayout rl_eval;
  private RelativeLayout rl_eval_zzb;
  private View rl_login;
  private int[] shadowColor;
  
  private void displayItemOneByOne(EvalAccountResult paramEvalAccountResult)
  {
    if (paramEvalAccountResult == null) {
      return;
    }
    int i = 0;
    if (i < paramEvalAccountResult.mRecommends.size())
    {
      EvalAccountResult.RecommendItem localRecommendItem = (EvalAccountResult.RecommendItem)paramEvalAccountResult.mRecommends.get(i);
      int j = localRecommendItem.mRecommendId;
      com.tencent.token.core.bean.d locald;
      if (j == 2)
      {
        locald = (com.tencent.token.core.bean.d)this.itemObjectMap.get(Integer.valueOf(j));
        locald.a(localRecommendItem);
        locald.a(new ah(this, localRecommendItem));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          locald = (com.tencent.token.core.bean.d)this.itemObjectMap.get(Integer.valueOf(j));
          locald.a(localRecommendItem);
          locald.a(new ai(this, localRecommendItem));
        }
        else if (j == 4)
        {
          locald = (com.tencent.token.core.bean.d)this.itemObjectMap.get(Integer.valueOf(j));
          locald.a(localRecommendItem);
          locald.a(new aj(this, localRecommendItem));
        }
      }
    }
    this.mHandler.sendEmptyMessageDelayed(1000, 30L);
  }
  
  private SpannableString getHtmlFromDesc(String paramString)
  {
    int i = paramString.indexOf(' ');
    int j = paramString.lastIndexOf(' ');
    if ((i == -1) || (j == i)) {
      return new SpannableString(paramString);
    }
    paramString = new SpannableString(paramString);
    paramString.setSpan(new AbsoluteSizeSpan(18, true), i, j, 33);
    return paramString;
  }
  
  private void gotologobyprotect()
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null) {
      return;
    }
    Intent localIntent = new Intent(this, WtLoginAccountInput.class);
    localIntent.putExtra("page_id", 9);
    localIntent.putExtra("intent.uin", localQQUser.mRealUin);
    startActivity(localIntent);
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
    com.tencent.token.core.bean.d locald = new com.tencent.token.core.bean.d(this, this.mPswLayout, this.mPswTitle, this.mPswDesc, this.mPswPic);
    locald.a(2);
    locald.a(this.mPswDefaultListener);
    this.itemObjectMap.put(Integer.valueOf(2), locald);
    locald = new com.tencent.token.core.bean.d(this, this.mProtectionLayout, this.mProtectionTitle, this.mProtectionDesc, this.mProtectionPic);
    locald.a(3);
    locald.a(this.mProtecDefaultListener);
    this.itemObjectMap.put(Integer.valueOf(3), locald);
    locald = new com.tencent.token.core.bean.d(this, this.mMbLayout, this.mMbTitle, this.mMbDesc, this.mMbPic);
    locald.a(4);
    locald.a(this.mMbDefaultListener);
    this.itemObjectMap.put(Integer.valueOf(4), locald);
  }
  
  private void initView()
  {
    setContentView(2130903047);
    this.mRootLayout = findViewById(2131296344);
    this.mTitleLayout = ((RelativeLayout)findViewById(2131296345));
    this.mPullToRefreshLayout = ((PullToRefreshLinearLayout)findViewById(2131296353));
    this.mPullToRefreshLayout.a(this);
    this.ll_eval_head = ((RelativeLayout)findViewById(2131296355));
    this.mRootLayout.setBackgroundDrawable(this.drawable);
    this.mScrollView = ((ScrollView)findViewById(2131296354));
    this.rl_eval = ((RelativeLayout)findViewById(2131296356));
    this.rl_eval.setEnabled(false);
    this.rl_eval.setOnClickListener(this.mEvalClickListener);
    this.rl_eval_zzb = ((RelativeLayout)findViewById(2131296363));
    this.rl_eval_zzb.setVisibility(4);
    this.rl_eval_zzb.setEnabled(false);
    this.rl_eval_zzb.setOnClickListener(this.mEvalClickListener);
    this.rl_login = findViewById(2131296370);
    this.rl_login.setOnClickListener(new r(this));
    this.mQQFace = ((RoundImageView)findViewById(2131296346));
    this.mQQFace.setOnClickListener(new s(this));
    this.mLoading = ((ImageView)findViewById(2131296358));
    this.mLoadingResult = ((ImageView)findViewById(2131296359));
    this.mZzbLoadingImg = ((ImageView)findViewById(2131296366));
    this.mZzbLoadingImgResult = ((ImageView)findViewById(2131296365));
    this.mQQNick = ((TextView)findViewById(2131296350));
    this.mQQFaceCircle = ((ImageView)findViewById(2131296347));
    this.mQQFaceBorder = ((ImageView)findViewById(2131296348));
    this.mSafeMsgBox = ((ImageView)findViewById(2131296351));
    this.mSafeMsgBox.setOnClickListener(new t(this));
    this.mMsgUnread = ((ImageView)findViewById(2131296352));
    this.mLoginHistoryTitle = ((TextView)findViewById(2131296372));
    this.mLoginHistoryDesc = ((TextView)findViewById(2131296373));
    this.mLoginHistoryPic = ((ImageView)findViewById(2131296374));
    this.mNotVerify = ((TextView)findViewById(2131296349));
    this.mEvalLevel = ((TextView)findViewById(2131296360));
    this.mZzbEvalLevel = ((TextView)findViewById(2131296367));
    this.mDetailMsg = ((TextView)findViewById(2131296361));
    this.mZzbDetailMsg = ((TextView)findViewById(2131296368));
    this.mDelSafeModeBtn = ((Button)findViewById(2131296362));
    this.mZzbDelSafeModeBtn = ((Button)findViewById(2131296369));
    this.mUser = ax.a().e();
    if (this.mUser == null)
    {
      this.mMsgUnread.setVisibility(4);
      this.rl_eval.setVisibility(0);
      this.rl_eval.setEnabled(true);
      this.ll_eval_head.setClickable(true);
      this.mEvalLevel.setText(2131362305);
      this.rl_eval_zzb.setVisibility(8);
    }
    for (;;)
    {
      this.mPswLayout = ((RelativeLayout)findViewById(2131296380));
      this.mProtectionLayout = ((RelativeLayout)findViewById(2131296385));
      this.mMbLayout = ((RelativeLayout)findViewById(2131296375));
      this.mPswTitle = ((TextView)findViewById(2131296382));
      this.mProtectionTitle = ((TextView)findViewById(2131296387));
      this.mMbTitle = ((TextView)findViewById(2131296377));
      this.mPswDesc = ((TextView)findViewById(2131296383));
      this.mProtectionDesc = ((TextView)findViewById(2131296388));
      this.mMbDesc = ((TextView)findViewById(2131296378));
      this.mPswPic = ((ImageView)findViewById(2131296384));
      this.mProtectionPic = ((ImageView)findViewById(2131296389));
      this.mMbPic = ((ImageView)findViewById(2131296379));
      return;
      if (this.mUser.mIsZzb)
      {
        this.rl_eval.setVisibility(8);
        this.rl_eval_zzb.setVisibility(0);
        this.mZzbEvalLevel.setText(2131362318);
      }
      else
      {
        this.rl_eval.setVisibility(0);
        this.rl_eval_zzb.setVisibility(8);
        this.mEvalLevel.setText(2131362318);
      }
    }
  }
  
  private void loadLastLoginLocation()
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null)
    {
      resetItemStatus();
      return;
    }
    refreshLoginLocation(getResources().getString(2131361923));
    this.newMsgCount = 0;
    byte[] arrayOfByte = com.tencent.token.x.a(RqdApplication.i()).a(ax.a().e().mRealUin);
    if (arrayOfByte != null)
    {
      this.mSkey = com.tencent.token.utils.s.a(arrayOfByte);
      bb.a().a(bb.e, this.mSkey, this.mHandler);
      return;
    }
    com.tencent.token.x.a(RqdApplication.i()).a(this, "" + localQQUser.mRealUin, this.mHandler, false);
  }
  
  private void loadNewSafeMsg()
  {
    ax localax = ax.a();
    QQUser localQQUser = localax.e();
    if ((!localax.o()) || (localQQUser == null)) {
      return;
    }
    bd.a().a(this.mHandler);
  }
  
  private void refreshEvalView()
  {
    e.b("refreshEvalView() ");
    this.mUser = ax.a().e();
    if (this.mUser == null) {
      return;
    }
    int i;
    String str1;
    if (this.mEvalResult.mDegree >= this.mLoginDegree)
    {
      i = this.mEvalResult.mDegree;
      String str2 = this.mEvalResult.mTitle;
      str1 = str2;
      if (this.mEvalResult.mDegree == 0)
      {
        str1 = str2;
        if (this.mLoginDegree == 1) {
          str1 = getResources().getString(2131362307);
        }
      }
      if (!this.mUser.mIsZzb) {
        break label306;
      }
      this.mZzbLoadingImg.setVisibility(4);
      this.mZzbLoadingImgResult.setVisibility(0);
      this.rl_eval_zzb.setEnabled(true);
      this.ll_eval_head.setEnabled(true);
      this.mZzbEvalLevel.setVisibility(0);
      this.mZzbEvalLevel.setText(str1);
      if (i != 0) {
        break label261;
      }
      this.mZzbLoadingImgResult.setImageResource(2130837806);
      this.drawable.a(this.color[6], this.color[7]);
      label180:
      if ((this.mEvalResult.mDesc == null) || (this.mEvalResult.mDesc.length() <= 0)) {
        break label299;
      }
    }
    label261:
    label299:
    for (RqdApplication.e = this.mEvalResult.mDesc;; RqdApplication.e = null)
    {
      this.mPullToRefreshLayout.a();
      this.mRootLayout.invalidate();
      this.mRootLayout.postInvalidate();
      LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
      return;
      i = this.mLoginDegree;
      break;
      this.mZzbLoadingImgResult.setImageResource(2130837800);
      this.drawable.a(this.color[(i * 2)], this.color[(i * 2 + 1)]);
      break label180;
    }
    label306:
    this.mLoading.setVisibility(4);
    this.mLoadingResult.setVisibility(0);
    if (this.mEvalResult.mDegree == 2)
    {
      this.mLoadingResult.setImageResource(2130837805);
      label343:
      this.rl_eval.setEnabled(true);
      this.ll_eval_head.setEnabled(true);
      this.mEvalLevel.setVisibility(0);
      this.mEvalLevel.setText(str1);
      if ((this.mEvalResult.mDesc == null) || (this.mEvalResult.mDesc.length() <= 0)) {
        break label473;
      }
    }
    label473:
    for (RqdApplication.e = this.mEvalResult.mDesc;; RqdApplication.e = null)
    {
      this.drawable.a(this.color[(i * 2)], this.color[(i * 2 + 1)]);
      break;
      if (this.mEvalResult.mDegree == 1)
      {
        this.mLoadingResult.setImageResource(2130837799);
        break label343;
      }
      this.mLoadingResult.setImageResource(2130837803);
      break label343;
    }
  }
  
  private void refreshUinPanel()
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser != null)
    {
      this.mQQNick.setText(localQQUser.mNickName);
      e.c("account page bindview nick=" + localQQUser.mNickName + ", uin=" + localQQUser.mUin);
      this.mQQFace.setImageDrawable(k.a(localQQUser.mRealUin + "", localQQUser.mUin + ""));
      if (localQQUser.mIsBinded) {
        this.mNotVerify.setVisibility(4);
      }
      while (localQQUser.mIsZzb)
      {
        this.mQQFaceCircle.setImageDrawable(getResources().getDrawable(2130838024));
        this.mQQFaceCircle.setVisibility(0);
        this.mQQFaceBorder.setVisibility(0);
        return;
        this.mNotVerify.setVisibility(0);
      }
      this.mQQFaceCircle.setImageDrawable(getResources().getDrawable(2130837522));
      this.mQQFaceCircle.setVisibility(0);
      this.mQQFaceBorder.setVisibility(4);
      return;
    }
    this.mMsgUnread.setVisibility(4);
    this.rl_eval.setVisibility(0);
    this.rl_eval.setEnabled(true);
    this.rl_eval_zzb.setVisibility(8);
    this.mQQNick.setText(getResources().getString(2131362694));
    this.mQQFaceCircle.setVisibility(4);
    this.mQQFaceBorder.setVisibility(4);
    this.mQQFace.setImageResource(2130837768);
    this.mNotVerify.setVisibility(4);
    this.mEvalLevel.setText(getResources().getString(2131362305));
    this.mLoading.setVisibility(4);
    this.mLoadingResult.setVisibility(0);
    this.mLoadingResult.setImageResource(2130837802);
  }
  
  private void resetItemStatus()
  {
    this.mLoginHistoryPic.clearAnimation();
    this.mLoginHistoryPic.setVisibility(4);
    this.mLoginHistoryDesc.setTextColor(getResources().getColor(2131165335));
    this.mLoginHistoryDesc.setText(getResources().getString(2131362309));
    this.itemCount = 3;
    if ((this.itemObjectMap != null) && (this.itemObjectMap.size() != 0))
    {
      if (this.itemObjectMap.get(Integer.valueOf(2)) != null) {
        ((com.tencent.token.core.bean.d)this.itemObjectMap.get(Integer.valueOf(2))).b(this.mPswDefaultListener);
      }
      if (this.itemObjectMap.get(Integer.valueOf(3)) != null) {
        ((com.tencent.token.core.bean.d)this.itemObjectMap.get(Integer.valueOf(3))).b(this.mProtecDefaultListener);
      }
      if (this.itemObjectMap.get(Integer.valueOf(4)) != null) {
        ((com.tencent.token.core.bean.d)this.itemObjectMap.get(Integer.valueOf(4))).b(this.mMbDefaultListener);
      }
    }
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1000);
    }
  }
  
  private void selectView(com.tencent.token.global.d paramd, Message paramMessage)
  {
    if ((paramd != null) && (paramMessage != null) && (paramMessage.arg1 != 110) && (paramMessage.arg1 != 111))
    {
      e.c("----result.mErrCode: " + paramd.a);
      e.c("----result.mErrDebug: " + paramd.b);
      if (this.mErrorView == null)
      {
        this.mErrorView = new ErrorView(this);
        this.mErrorView.a(this.mErrorAction);
        addContentView(this.mErrorView);
      }
      this.mErrorView.a(paramd.a);
      this.mErrorView.setTag(Integer.valueOf(paramMessage.what));
      this.mErrorView.setVisibility(0);
      bringChildToFront(this.mErrorView);
      setRightTitleImageHide();
      return;
    }
    this.mUser = ax.a().e();
    if ((this.mUser == null) || ((paramMessage != null) && ((paramMessage.arg1 == 110) || (paramMessage.arg1 == 111))))
    {
      ax.a().k = false;
      mNeedRefreshEval = true;
      SettingPageActivity.mNeedRefreshMbInfo = true;
      return;
    }
    if (this.mErrorView != null) {
      this.mErrorView.setVisibility(8);
    }
    setLoadingOn();
    loadLastLoginLocation();
  }
  
  private void setLoadingOn()
  {
    this.mUser = ax.a().e();
    if (this.mUser == null) {
      return;
    }
    if (this.mUser.mIsZzb)
    {
      this.loading = new bp(this, true);
      this.drawable.b(this.color[6], this.color[7]);
      this.loading.setBounds(this.mLoading.getLeft(), this.mLoading.getTop(), this.mLoading.getRight(), this.mLoading.getBottom());
      if (!this.mUser.mIsZzb) {
        break label317;
      }
      this.rl_eval.setVisibility(4);
      this.rl_eval_zzb.setVisibility(0);
      this.mZzbLoadingImg.setImageDrawable(this.loading);
      this.mZzbLoadingImg.setVisibility(0);
      this.mZzbLoadingImgResult.setVisibility(4);
      this.mZzbEvalLevel.setVisibility(0);
      this.mZzbEvalLevel.setText(2131362318);
    }
    for (;;)
    {
      this.mLoginHistoryPic.setVisibility(0);
      this.mLoginHistoryPic.setImageDrawable(getResources().getDrawable(2130837508));
      this.mLoginHistoryPic.startAnimation(AnimationUtils.loadAnimation(this, 2130968581));
      this.mLoginHistoryDesc.setText(getResources().getString(2131362322));
      ((com.tencent.token.core.bean.d)this.itemObjectMap.get(Integer.valueOf(2))).a(1, null);
      ((com.tencent.token.core.bean.d)this.itemObjectMap.get(Integer.valueOf(3))).a(1, null);
      ((com.tencent.token.core.bean.d)this.itemObjectMap.get(Integer.valueOf(4))).a(1, null);
      return;
      this.loading = new bp(this, false);
      this.drawable.b(this.color[0], this.color[1]);
      break;
      label317:
      this.rl_eval.setVisibility(0);
      this.rl_eval_zzb.setVisibility(4);
      this.mLoading.setImageDrawable(this.loading);
      this.mLoading.setVisibility(0);
      this.mLoadingResult.setVisibility(4);
      this.mEvalLevel.setText(2131362318);
    }
  }
  
  private void showSafeMode(EvalAccountResult paramEvalAccountResult)
  {
    if (paramEvalAccountResult == null) {}
    QQUser localQQUser;
    do
    {
      return;
      localQQUser = ax.a().e();
    } while ((localQQUser == null) || (paramEvalAccountResult.mStatus != 4) || ((paramEvalAccountResult.mSubStatus != 0) && (paramEvalAccountResult.mSubStatus != 1)));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ll_eval_head.getLayoutParams();
    localLayoutParams.height = this.mPullToRefreshLayout.getHeight();
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
        this.mZzbDelSafeModeBtn.setText(getResources().getString(2131362326));
      }
      for (;;)
      {
        this.mZzbDelSafeModeBtn.setOnClickListener(new p(this, paramEvalAccountResult));
        return;
        this.mZzbDelSafeModeBtn.setText(getResources().getString(2131362327));
      }
    }
    this.mDetailMsg.setVisibility(0);
    this.mDelSafeModeBtn.setVisibility(0);
    this.mDetailMsg.setText(paramEvalAccountResult.mDesc);
    if (paramEvalAccountResult.mSubStatus == 0) {
      this.mDelSafeModeBtn.setText(getResources().getString(2131362326));
    }
    for (;;)
    {
      this.mDelSafeModeBtn.setOnClickListener(new q(this, paramEvalAccountResult));
      return;
      this.mDelSafeModeBtn.setText(getResources().getString(2131362327));
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((b.d()) && (paramKeyEvent.getAction() == 0)) {}
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
      SettingPageActivity.mNeedRefreshMbInfo = true;
      exitToken();
      return true;
    }
  }
  
  public boolean isValid()
  {
    QQUser localQQUser = ax.a().e();
    if ((this.mSessId == null) || (localQQUser == null)) {}
    String str;
    do
    {
      return false;
      str = this.mSessId;
      ax.a();
    } while ((!str.equals(ax.c)) || (this.mUinHash != localQQUser.mUin) || (!this.mQuerySecurityReporter));
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent = (EvalAccountResult)paramIntent.getSerializableExtra("eval_result");
    } while (paramIntent == null);
    this.mEvalResult = paramIntent;
    refreshEvalView();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    if (ag.c().g()) {
      af.a().a(this.mHandler);
    }
    this.color = new int[] { getResources().getColor(2131165274), getResources().getColor(2131165275), getResources().getColor(2131165276), getResources().getColor(2131165277), getResources().getColor(2131165278), getResources().getColor(2131165279), getResources().getColor(2131165280), getResources().getColor(2131165281) };
    this.shadowColor = new int[] { getResources().getColor(2131165269), getResources().getColor(2131165271), getResources().getColor(2131165273) };
    this.mUser = ax.a().e();
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
        if (ax.a().e() != null) {
          break label347;
        }
        showNoAccountTipDialog(this, 20, 0);
      }
    }
    label347:
    while (ax.a().e().mIsBinded)
    {
      return;
      this.drawable = new ba(GradientDrawable.Orientation.LEFT_RIGHT, this.color[0], this.color[1]);
      break;
    }
    showNoAccountTipDialog(this, 20, 1);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    mNeedRefreshEval = true;
    ax.a().k = false;
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
    if (ax.a().e() != null)
    {
      mNeedRefreshEval = true;
      onResume();
      this.mHandler.postDelayed(new v(this), 6000L);
      return;
    }
    this.mPullToRefreshLayout.a();
  }
  
  protected void onResume()
  {
    super.onResume();
    QQUser localQQUser = ax.a().e();
    LoginMsgActivity.setShowNewMsgCnt(false, 0);
    if ((!RqdApplication.b) && (this.needgotologobyprotect))
    {
      gotologobyprotect();
      this.needgotologobyprotect = false;
      return;
    }
    e.a("account page + need=" + mNeedRefreshEval + ", query=" + ax.a().k);
    e.c("mNeedRefreshEval =" + mNeedRefreshEval + ", QQUserAgent.getInstance().getIsUserChanged()=" + ax.a().i());
    if ((mNeedRefreshEval) || (ax.a().i()))
    {
      if ((this.mErrorView != null) && (this.mErrorView.getVisibility() == 0)) {
        this.mErrorView.setVisibility(8);
      }
      if ((this.mZzbDelSafeModeBtn.getVisibility() != 8) || (this.mDelSafeModeBtn.getVisibility() != 8)) {
        hideSafeMode();
      }
      this.mScrollView.setOnTouchListener(null);
      if (localQQUser == null) {
        break label294;
      }
      refreshLoginLocation(getResources().getString(2131361923));
      if (!localQQUser.mIsZzb) {
        break label272;
      }
      this.drawable.b(this.color[6], this.color[7]);
      resetItemStatus();
      refreshUinPanel();
      setLoadingOn();
      if (!ax.a().k) {
        break label341;
      }
      loadLastLoginLocation();
    }
    for (;;)
    {
      refreshUinPanel();
      return;
      label272:
      this.drawable.b(this.color[0], this.color[1]);
      break;
      label294:
      this.mLoginHistoryDesc.setText(getResources().getString(2131362309));
      this.mMsgUnread.setVisibility(4);
      this.drawable.b(this.color[0], this.color[1]);
      break;
      label341:
      if (!ag.c().g()) {
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
      localObject = ((SafeMsgItem)localObject).mContent;
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
      str = getResources().getString(2131361924);
      this.isLastLoginResult = true;
      this.mLoginDegree = 0;
      if (!mNeedShowIpcMsg) {
        break label166;
      }
      str = getResources().getString(2131361925);
      this.mLoginDegree = 1;
      label47:
      if ((paramString == null) || (!paramString.equals(getResources().getString(2131361923)))) {
        break label196;
      }
      paramString = getResources().getString(2131362460);
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
      str = getResources().getString(2131361922) + paramString;
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
      if ((bb.a().b != null) && (bb.a().b.mDevicesList != null) && (bb.a().b.mDevicesList.size() > 0)) {}
      for (paramString = String.format(getResources().getString(2131362459), new Object[] { Integer.valueOf(bb.a().b.mDevicesList.size()) });; paramString = String.format(getResources().getString(2131362459), new Object[] { Integer.valueOf(0) }))
      {
        this.isCurrentLoginResult = true;
        break;
      }
      label304:
      this.mLoginHistoryDesc.setText(getResources().getString(2131362322));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AccountPageActivity
 * JD-Core Version:    0.7.0.1
 */