package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.ch;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.dw;
import com.tencent.token.es;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.ui.base.dd;
import com.tencent.token.utils.k;
import com.tencent.token.utils.x;
import com.tencent.token.widget.InputMethodRelativeLayout;

public class ModifyQQPwdActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int S_SOURCE_ID_FREEZE = 1;
  boolean autoStartModPwdActivity = false;
  private boolean isOrangeToastShowing = false;
  private Button mCompleteBtn;
  private boolean mGoToLoginMsgList = false;
  Handler mHandler = new ot(this);
  private Button mModifyBtn;
  private dd mNeedVerifyView;
  private Button mNoSetTokenPwdBtn;
  String mPwdText = null;
  EditText mPwdTextView = null;
  InputMethodRelativeLayout mRootLayout;
  View mScrollAreaLayout;
  private Button mSetTokenPwdBtn;
  private TextView mSetTokenPwdTipText;
  private int mSourceId;
  private TextView mTextAccount;
  private RelativeLayout orange_toast;
  private ImageView toast_image;
  private TextView toast_text;
  boolean vrySucc = false;
  boolean vrypswSucc = false;
  
  private void init()
  {
    Object localObject = do.a().e();
    this.mPwdTextView = ((EditText)findViewById(2131559018));
    if (this.mPwdTextView != null) {
      this.mPwdTextView.clearFocus();
    }
    this.mModifyBtn = ((Button)findViewById(2131559020));
    this.mModifyBtn.setOnClickListener(this);
    this.mTextAccount = ((TextView)findViewById(2131559017));
    this.orange_toast = ((RelativeLayout)findViewById(2131558958));
    this.toast_text = ((TextView)findViewById(2131558987));
    this.toast_image = ((ImageView)findViewById(2131558986));
    if ((localObject != null) && (((QQUser)localObject).mNickName != null)) {
      this.mTextAccount.setText(getResources().getString(2131230776) + "： " + ((QQUser)localObject).mNickName);
    }
    for (;;)
    {
      this.mRootLayout = ((InputMethodRelativeLayout)findViewById(2131559014));
      this.mScrollAreaLayout = findViewById(2131559015);
      this.mRootLayout.setOnSizeChangedListenner(new pb(this));
      localObject = getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getInt("page_id") == 2)) {
        this.mGoToLoginMsgList = true;
      }
      return;
      this.mTextAccount.setText(getResources().getString(2131230776) + "： ");
    }
  }
  
  private void initView(QQUser paramQQUser)
  {
    Object localObject = null;
    if (getIntent().getIntExtra("index_from", 0) == 25)
    {
      this.autoStartModPwdActivity = true;
      if ((paramQQUser == null) || (paramQQUser.mIsBinded)) {
        break label218;
      }
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, 8);
      }
      setContentView(this.mNeedVerifyView);
      label62:
      this.mRightOptionImage = null;
      setRightTitleImage(2130838011, new pc(this));
      this.vrySucc = getIntent().getBooleanExtra("face_vry_succ", false);
      this.vrypswSucc = getIntent().getBooleanExtra("verify_psw", false);
      if ((paramQQUser != null) && (do.a().j()) && (!this.isOrangeToastShowing))
      {
        this.orange_toast.setVisibility(0);
        this.isOrangeToastShowing = true;
        if (!this.vrySucc) {
          break label246;
        }
        if (!paramQQUser.mIsZzb) {
          break label232;
        }
        paramQQUser = getResources().getString(2131231670);
      }
    }
    for (;;)
    {
      this.toast_text.setText(paramQQUser);
      this.toast_image.setImageDrawable(getResources().getDrawable(2130838018));
      this.toast_text.postDelayed(new pd(this), 3000L);
      return;
      this.autoStartModPwdActivity = false;
      break;
      label218:
      setContentView(2130968691);
      init();
      break label62;
      label232:
      paramQQUser = getResources().getString(2131231003);
      continue;
      label246:
      if (this.autoStartModPwdActivity)
      {
        this.autoStartModPwdActivity = false;
        this.orange_toast.setVisibility(8);
        paramQQUser = localObject;
      }
      else
      {
        this.orange_toast.setVisibility(8);
        this.isOrangeToastShowing = false;
        paramQQUser = localObject;
      }
    }
  }
  
  private void showErrorDialog(String paramString)
  {
    showUserDialog(2131230843, paramString, 2131230897, new oz(this), new pa(this));
  }
  
  public void onClick(View paramView)
  {
    boolean bool;
    QQUser localQQUser;
    if (paramView.getId() == 2131559020)
    {
      bool = true;
      h.a(bool);
      localQQUser = do.a().e();
    }
    switch (paramView.getId())
    {
    default: 
    case 2131559020: 
      do
      {
        return;
        bool = false;
        break;
        if (this.mPwdTextView != null) {
          this.mPwdTextView.clearFocus();
        }
        this.mPwdText = this.mPwdTextView.getText().toString();
        if ((this.mPwdText == null) || (this.mPwdText.length() < 8))
        {
          showUserDialog(2131231464, getResources().getString(2131231242), 2131230897, null);
          return;
        }
        x.a(this);
      } while (localQQUser == null);
      if ((localQQUser.mIsZzb) && (this.vrySucc))
      {
        showUserDialog(2131230843, getResources().getString(2131230941) + this.mPwdText, 2131230897, 2131230886, new pe(this), null);
        return;
      }
      dw.a().a(1, this.mHandler);
      showProDialog(this, 2131230843, 2131230942, null);
      return;
    case 2131559023: 
      ch.a().a(System.currentTimeMillis(), 14);
      startActivity(new Intent(this, StartPwdUpdateInfoActivity.class));
      finish();
      return;
    case 2131559022: 
      if (this.mGoToLoginMsgList) {
        startActivity(new Intent(this, OpMsgDisplayActivity.class));
      }
      finish();
      return;
    case 2131558924: 
      paramView = new Intent(this, IndexActivity.class);
      paramView.addFlags(67108864);
      paramView.putExtra("index_from", 16);
      startActivity(paramView);
      finish();
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {
      this.mSourceId = getIntent().getIntExtra("source_id", 0);
    }
    h.a("sourceid=" + this.mSourceId);
    this.autoStartModPwdActivity = false;
    if (0 == 0)
    {
      cw.a().b(this.mHandler);
      showProDialog(this, 2131230843, 2131231298, null);
    }
    initView(null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cancelRequest();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    dr.a().h.a("modify_pwd").a();
  }
  
  public void showSuccessView()
  {
    RoundImageView localRoundImageView;
    if (this.mSourceId == 1)
    {
      setContentView(2130968664);
      setBackArrowHide();
      setRightTitleImageHide();
      setTitle(2131231518);
      QQUser localQQUser = do.a().e();
      localRoundImageView = (RoundImageView)findViewById(2131558923);
      if (localQQUser != null)
      {
        localRoundImageView.setImageDrawable(k.a(localQQUser.b() + "", localQQUser.mUin + ""));
        ((Button)findViewById(2131558924)).setOnClickListener(this);
      }
    }
    for (;;)
    {
      AccountPageActivity.mNeedRefreshEval = true;
      return;
      localRoundImageView.setImageDrawable(getResources().getDrawable(2130837666));
      break;
      setContentView(2130968692);
      setBackArrowHide();
      setRightTitleImageHide();
      this.mCompleteBtn = ((Button)findViewById(2131559022));
      this.mSetTokenPwdBtn = ((Button)findViewById(2131559023));
      this.mNoSetTokenPwdBtn = ((Button)findViewById(2131559024));
      this.mSetTokenPwdTipText = ((TextView)findViewById(2131559021));
      this.mSetTokenPwdBtn.setOnClickListener(this);
      this.mNoSetTokenPwdBtn.setOnClickListener(this);
      this.mCompleteBtn.setOnClickListener(this);
      if ((cy.a().c()) || (this.mGoToLoginMsgList))
      {
        this.mCompleteBtn.setVisibility(0);
        this.mSetTokenPwdBtn.setVisibility(8);
        this.mNoSetTokenPwdBtn.setVisibility(8);
        this.mSetTokenPwdTipText.setVisibility(8);
      }
      else
      {
        this.mCompleteBtn.setVisibility(8);
        this.mSetTokenPwdBtn.setVisibility(0);
        this.mNoSetTokenPwdBtn.setVisibility(0);
        this.mSetTokenPwdTipText.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ModifyQQPwdActivity
 * JD-Core Version:    0.7.0.1
 */