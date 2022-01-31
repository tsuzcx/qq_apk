package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItemDetail;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.core.bean.SafeMsgItem.MsgAction;
import com.tencent.token.do;
import com.tencent.token.ds;
import com.tencent.token.du;
import com.tencent.token.eq;
import com.tencent.token.er;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class OpMsgDisplayActivity
  extends BaseActivity
{
  public static final int MC_RECOMM_OP_ID_CHPWD = 3;
  public static final int MC_RECOMM_OP_ID_DEL_MB_MBK = 9;
  public static final int MC_RECOMM_OP_ID_DEL_MB_QUES = 8;
  public static final int MC_RECOMM_OP_ID_GAME_PROTECT = 5;
  public static final int MC_RECOMM_OP_ID_GOTO_ABNORMAL_LOGIN = 18;
  public static final int MC_RECOMM_OP_ID_GOTO_ACCOUNT_PAGE = 11;
  public static final int MC_RECOMM_OP_ID_GOTO_DATA = 19;
  public static final int MC_RECOMM_OP_ID_GOTO_FACE_SET = 24;
  public static final int MC_RECOMM_OP_ID_GOTO_GAME_LOCK = 14;
  public static final int MC_RECOMM_OP_ID_GOTO_LOGIN_MSG = 15;
  public static final int MC_RECOMM_OP_ID_GOTO_LOGIN_PROTECT = 20;
  public static final int MC_RECOMM_OP_ID_GOTO_MAIL_PROTECT = 22;
  public static final int MC_RECOMM_OP_ID_GOTO_MBINFO = 13;
  public static final int MC_RECOMM_OP_ID_GOTO_MB_QQTOKEN = 12;
  public static final int MC_RECOMM_OP_ID_GOTO_PHONE_CALL = 17;
  public static final int MC_RECOMM_OP_ID_GOTO_QQ_LOGIN_PROTECT = 21;
  public static final int MC_RECOMM_OP_ID_GOTO_REALNAME = 23;
  public static final int MC_RECOMM_OP_ID_GOTO_SAFE_MSG = 16;
  public static final int MC_RECOMM_OP_ID_GOTO_URL = 6;
  public static final int MC_RECOMM_OP_ID_GOTO_VERIFY_PAGE = 10;
  public static final int MC_RECOMM_OP_ID_LOCK_ACCOUNT = 4;
  public static final int MC_RECOMM_OP_ID_NOOP = 0;
  public static final int MC_RECOMM_OP_ID_SET_MB_MOBILE = 7;
  public static final int MC_RECOMM_OP_ID_SET_QB_PROTTECT = 2;
  private static final int MC_RECOMM_OP_ID_UNKNOW = 99;
  public static final int MC_RECOMM_OP_ID_UPDATE_LOCATION = 1;
  private View.OnClickListener mAbnormalModifyQQPwdListener = new sj(this);
  private View.OnClickListener mAccountLockListener = new sg(this);
  Button mActionButton;
  er mCache;
  private View.OnClickListener mDelMBMBKListener = new sb(this);
  private View.OnClickListener mDelMBQuesListener = new sa(this);
  Button mFeedbackButton;
  private View.OnClickListener mGameLockListener = new rp(this);
  private View.OnClickListener mGameProtectListener = new sh(this);
  private View.OnClickListener mGotoAccountPageListener = new sd(this);
  private View.OnClickListener mGotoQQTokenListener = new se(this);
  private View.OnClickListener mGotoUrlListener = new rs(this);
  private View.OnClickListener mGotoVerifyPageListener = new sc(this);
  private Handler mHandler = new ro(this);
  private boolean mIpcMsg;
  private boolean mIpcMsgButConfirm;
  SafeMsgItem mItem;
  private View.OnClickListener mLoginMsgListener = new rq(this);
  private View.OnClickListener mLoginProtectListener = new ru(this);
  private int mMBItemID;
  private View.OnClickListener mMailProtectListener = new rw(this);
  private View.OnClickListener mMibaoInfoListener = new sl(this);
  private View.OnClickListener mModifyQQPwdListener = new si(this);
  private ImageView mMsgIcon;
  TextView mMsgTips;
  TextView mMsgTitle;
  private int mMsgType;
  private View.OnClickListener mPhoneCallListener = new rt(this);
  private int mPosition;
  private View.OnClickListener mQQLoginProtectListener = new rv(this);
  private View.OnClickListener mQbQdProtectListener = new sk(this);
  private View.OnClickListener mRealNameListener = new rx(this);
  private View.OnClickListener mSafeMsgListener = new rr(this);
  private View.OnClickListener mSetMBMobileListener = new ry(this);
  Button mSureButton;
  private View.OnClickListener mSureListener = new sf(this);
  TextView mTextAfterTable;
  View mViewAfterTable;
  
  private View createTableCol(String paramString1, String paramString2)
  {
    View localView = getLayoutInflater().inflate(2130968714, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131559115);
    TextView localTextView2 = (TextView)localView.findViewById(2131559116);
    localTextView1.setText(paramString1);
    localTextView2.setText(Html.fromHtml(paramString2));
    return localView;
  }
  
  private void gotoMbItemActivity(int paramInt)
  {
    Object localObject = do.a().e();
    if ((localObject != null) && (((QQUser)localObject).mIsBinded) && (eq.a().c() != null) && (eq.a().c().mMbInfoItems != null))
    {
      int i = eq.a().a(paramInt);
      if ((i < 0) || (i >= eq.a().c().mMbInfoItems.size())) {
        return;
      }
      localObject = (MbInfoResult.MbInfoItem)eq.a().c().mMbInfoItems.get(i);
      if ((paramInt == 51) && (((MbInfoResult.MbInfoItem)localObject).mId == 51) && (((MbInfoResult.MbInfoItem)localObject).mDetail.mBtnType == 1))
      {
        Intent localIntent = new Intent(this, UtilsModSetMobileStep1Activity.class);
        localIntent.putExtra("title", getResources().getString(2131231428) + ((MbInfoResult.MbInfoItem)localObject).mName);
        localIntent.putExtra("op_type", 1);
        localIntent.putExtra("position", i);
        startActivityForResult(localIntent, 0);
        return;
      }
      localObject = new Intent(this, UtilsMbInfoItemActivity.class);
      ((Intent)localObject).putExtra("position", i);
      startActivityForResult((Intent)localObject, 0);
      return;
    }
    startActivity(new Intent(this, UtilsMbInfoActivity.class));
  }
  
  private void initUI()
  {
    if (this.mItem != null)
    {
      setRightTitleImage(2130838011, new rz(this));
      if ((this.mItem.mTextAfterTable != null) && (this.mItem.mTextAfterTable.length() > 0))
      {
        this.mTextAfterTable.setText(Html.fromHtml(this.mItem.mTextAfterTable));
        this.mTextAfterTable.setVisibility(0);
      }
      for (;;)
      {
        insertTableRows((LinearLayout)findViewById(2131559110));
        setActionButton();
        setFeedbackButton();
        h.b("Action: " + this.mItem.mAction);
        return;
        this.mTextAfterTable.setVisibility(8);
      }
    }
    finish();
  }
  
  private void insertTableRows(LinearLayout paramLinearLayout)
  {
    if ("5".equals(this.mItem.o())) {}
    for (;;)
    {
      JSONArray localJSONArray;
      String str2;
      Object localObject;
      int j;
      try
      {
        localJSONArray = new JSONArray(this.mItem.i());
        String str1 = "";
        str2 = "";
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONArray(i);
          j = 0;
          if (j < ((JSONArray)localObject).length()) {
            if (j == 0)
            {
              str1 = ((JSONArray)localObject).getString(j);
              h.b("temp1 = " + str1);
            }
            else
            {
              str2 = ((JSONArray)localObject).getString(j);
              h.b("temp2 = " + str2);
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0)
        {
          paramLinearLayout.addView(createTableCol(getResources().getString(2131231459), w.a(this.mItem.e() * 1000L, '-')));
          paramLinearLayout.addView(createTableCol(getResources().getString(2131231460), this.mItem.d()));
        }
        return;
        paramLinearLayout.addView(createTableCol(localJSONException, str2));
        if (i != localJSONArray.length() - 1)
        {
          localObject = new ImageView(this);
          ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, 2));
          ((ImageView)localObject).setBackgroundResource(2130837787);
          paramLinearLayout.addView((View)localObject);
        }
        i += 1;
        break;
      }
      j += 1;
    }
  }
  
  private void setActionButton()
  {
    h.c("action op: " + this.mItem.mAction);
    String str = getResources().getString(2131231393);
    if (this.mItem.mAction != null) {
      h.c("action op: " + this.mItem.mAction.mActionType + ", url=" + this.mItem.mAction.mTargetUrl);
    }
    try
    {
      int i = Integer.parseInt(this.mItem.mAction.mActionType);
      this.mActionButton.setVisibility(0);
      if ((this.mItem.mAction.mButtonText == null) || (this.mItem.mAction.mButtonText.length() == 0)) {
        this.mActionButton.setText(str);
      }
      for (;;)
      {
        switch (i)
        {
        case 18: 
        default: 
          this.mActionButton.setVisibility(4);
        case 1: 
        case 19: 
          return;
          this.mActionButton.setText(Html.fromHtml(this.mItem.mAction.mButtonText));
        }
      }
      if (this.mItem.mTypea == 1)
      {
        this.mActionButton.setOnClickListener(this.mAbnormalModifyQQPwdListener);
        return;
      }
      this.mActionButton.setOnClickListener(this.mModifyQQPwdListener);
      return;
      this.mActionButton.setOnClickListener(this.mAccountLockListener);
      return;
      this.mActionButton.setOnClickListener(this.mGameProtectListener);
      return;
      this.mActionButton.setOnClickListener(this.mQbQdProtectListener);
      return;
      this.mActionButton.setTag(this.mItem.mAction.mTargetUrl);
      this.mActionButton.setOnClickListener(this.mGotoUrlListener);
      return;
      this.mActionButton.setOnClickListener(this.mSetMBMobileListener);
      return;
      this.mActionButton.setOnClickListener(this.mDelMBQuesListener);
      return;
      this.mActionButton.setOnClickListener(this.mDelMBMBKListener);
      return;
      this.mActionButton.setOnClickListener(this.mGotoVerifyPageListener);
      return;
      this.mActionButton.setOnClickListener(this.mGotoAccountPageListener);
      return;
      this.mActionButton.setOnClickListener(this.mGotoQQTokenListener);
      return;
      this.mActionButton.setOnClickListener(this.mMibaoInfoListener);
      return;
      this.mActionButton.setOnClickListener(this.mGameLockListener);
      return;
      this.mActionButton.setOnClickListener(this.mLoginMsgListener);
      return;
      this.mActionButton.setOnClickListener(this.mSafeMsgListener);
      return;
      this.mActionButton.setOnClickListener(this.mPhoneCallListener);
      return;
      this.mActionButton.setOnClickListener(this.mLoginProtectListener);
      return;
      this.mActionButton.setOnClickListener(this.mQQLoginProtectListener);
      return;
      this.mActionButton.setOnClickListener(this.mMailProtectListener);
      return;
      this.mActionButton.setOnClickListener(this.mRealNameListener);
      return;
      if (do.a().j())
      {
        startActivity(new Intent(this, FaceRecognitionDefaultActivity.class));
        return;
      }
      startActivity(new Intent(this, FaceRecognitionCreateActivity.class));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void setFeedbackButton()
  {
    if (this.mItem.mFeedBack != null) {}
    try
    {
      int i = Integer.parseInt(this.mItem.mFeedBack.mActionType);
      switch (i)
      {
      default: 
        this.mFeedbackButton.setVisibility(4);
        return;
      }
      if (this.mActionButton.getVisibility() != 0)
      {
        this.mFeedbackButton = this.mActionButton;
        this.mFeedbackButton.setBackgroundResource(2130837728);
        this.mFeedbackButton.setTextColor(getResources().getColor(2131492925));
      }
      this.mFeedbackButton.setVisibility(0);
      h.c("test feed back: " + i + "|" + this.mItem.mFeedBack.mButtonText + "|" + this.mItem.mFeedBack);
      if ((this.mItem.mFeedBack.mButtonText == null) || (this.mItem.mFeedBack.mButtonText.length() == 0)) {
        this.mFeedbackButton.setText(2131231394);
      }
      for (;;)
      {
        this.mFeedbackButton.setOnClickListener(new sm(this));
        return;
        this.mFeedbackButton.setText(Html.fromHtml(this.mItem.mFeedBack.mButtonText));
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968713);
    this.mTextAfterTable = ((TextView)findViewById(2131559111));
    this.mActionButton = ((Button)findViewById(2131559112));
    this.mSureButton = ((Button)findViewById(2131559113));
    this.mMsgTitle = ((TextView)findViewById(2131558815));
    this.mMsgTips = ((TextView)findViewById(2131559109));
    this.mMsgIcon = ((ImageView)findViewById(2131559035));
    this.mFeedbackButton = ((Button)findViewById(2131559114));
    this.mActionButton.setVisibility(4);
    this.mFeedbackButton.setVisibility(4);
    if (getIntent().getExtras() == null)
    {
      finish();
      return;
    }
    this.mPosition = getIntent().getExtras().getInt("position");
    this.mMsgType = getIntent().getExtras().getInt("type");
    this.mIpcMsg = getIntent().getExtras().getBoolean("ipcmsg");
    if (this.mMsgType == 1) {
      setTitle(2131231167);
    }
    for (this.mCache = ds.a().f;; this.mCache = du.a().f)
    {
      this.mItem = this.mCache.b(this.mPosition);
      if (this.mItem != null) {
        break;
      }
      finish();
      return;
      setTitle(2131231280);
    }
    if ((this.mItem != null) && (this.mItem.mTitle != null) && (this.mItem.mTitle.length() > 0))
    {
      this.mMsgTitle.setVisibility(0);
      this.mMsgTitle.setText(this.mItem.mTitle);
      if (this.mMsgType != 1) {
        break label592;
      }
      if (this.mItem.mTypeb == 1) {
        this.mMsgTitle.setCompoundDrawablesWithIntrinsicBounds(2130837827, 0, 0, 0);
      }
    }
    else
    {
      this.mIpcMsgButConfirm = this.mItem.r();
      if (!this.mIpcMsg) {
        break label656;
      }
      if (this.mIpcMsgButConfirm) {
        break label636;
      }
      this.mSureButton.setVisibility(0);
      this.mMsgTips.setVisibility(8);
      this.mSureButton.setOnClickListener(this.mSureListener);
    }
    for (;;)
    {
      paramBundle = "";
      int i = this.mItem.mContent.indexOf('|');
      if (i != -1) {
        paramBundle = this.mItem.mContent.substring(i + 1);
      }
      if ((this.mItem.s()) && (paramBundle.length() > 0))
      {
        this.mMsgTips.setVisibility(0);
        this.mSureButton.setVisibility(8);
        this.mMsgTips.setText(getResources().getString(2131231180) + paramBundle);
      }
      initUI();
      return;
      if (this.mItem.mTypeb == 2)
      {
        this.mMsgTitle.setCompoundDrawablesWithIntrinsicBounds(2130837828, 0, 0, 0);
        break;
      }
      if (this.mItem.mTypeb == 3)
      {
        this.mMsgTitle.setCompoundDrawablesWithIntrinsicBounds(2130837825, 0, 0, 0);
        break;
      }
      if (this.mItem.mTypeb != 11) {
        break;
      }
      this.mMsgTitle.setCompoundDrawablesWithIntrinsicBounds(2130837826, 0, 0, 0);
      break;
      label592:
      this.mMsgIcon.setVisibility(0);
      if (this.mItem.p())
      {
        this.mMsgIcon.setBackgroundResource(2130837652);
        break;
      }
      this.mMsgIcon.setBackgroundResource(2130837654);
      break;
      label636:
      this.mSureButton.setVisibility(8);
      this.mMsgTips.setVisibility(0);
      continue;
      label656:
      this.mSureButton.setVisibility(8);
      this.mMsgTips.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.OpMsgDisplayActivity
 * JD-Core Version:    0.7.0.1
 */