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
import com.tencent.token.af;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.bf;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.fp;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.ui.base.dk;
import com.tencent.token.utils.t;
import com.tencent.token.widget.InputMethodRelativeLayout;

public class ModifyQQPwdActivity
  extends BaseActivity
  implements View.OnClickListener
{
  boolean autoStartModPwdActivity = false;
  private boolean isOrangeToastShowing = false;
  private Button mCompleteBtn;
  private boolean mGoToLoginMsgList = false;
  Handler mHandler = new pi(this);
  private Button mModifyBtn;
  private dk mNeedVerifyView;
  private Button mNoSetTokenPwdBtn;
  String mPwdText = null;
  EditText mPwdTextView = null;
  InputMethodRelativeLayout mRootLayout;
  View mScrollAreaLayout;
  private Button mSetTokenPwdBtn;
  private TextView mSetTokenPwdTipText;
  private TextView mTextAccount;
  private RelativeLayout orange_toast;
  private ImageView toast_image;
  private TextView toast_text;
  boolean vrySucc = false;
  boolean vrypswSucc = false;
  
  private void init()
  {
    Object localObject = ax.a().e();
    this.mPwdTextView = ((EditText)findViewById(2131296820));
    if (this.mPwdTextView != null) {
      this.mPwdTextView.clearFocus();
    }
    this.mModifyBtn = ((Button)findViewById(2131296822));
    this.mModifyBtn.setOnClickListener(this);
    this.mTextAccount = ((TextView)findViewById(2131296819));
    this.orange_toast = ((RelativeLayout)findViewById(2131296817));
    this.toast_text = ((TextView)findViewById(2131296784));
    this.toast_image = ((ImageView)findViewById(2131296783));
    if ((localObject != null) && (((QQUser)localObject).mNickName != null)) {
      this.mTextAccount.setText(getResources().getString(2131362296) + "： " + ((QQUser)localObject).mNickName);
    }
    for (;;)
    {
      this.mRootLayout = ((InputMethodRelativeLayout)findViewById(2131296814));
      this.mScrollAreaLayout = findViewById(2131296815);
      this.mRootLayout.a = new pq(this);
      localObject = getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getInt("page_id") == 2)) {
        this.mGoToLoginMsgList = true;
      }
      return;
      this.mTextAccount.setText(getResources().getString(2131362296) + "： ");
    }
  }
  
  private void initView(QQUser paramQQUser)
  {
    label60:
    Object localObject;
    if (getIntent().getIntExtra("index_from", 0) == 25)
    {
      this.autoStartModPwdActivity = true;
      if ((paramQQUser == null) || (paramQQUser.mIsBinded)) {
        break label213;
      }
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, 6);
      }
      setContentView(this.mNeedVerifyView);
      setRightTitleImage(2130837951, new pr(this));
      this.vrySucc = getIntent().getBooleanExtra("face_vry_succ", false);
      this.vrypswSucc = getIntent().getBooleanExtra("verify_psw", false);
      if ((paramQQUser != null) && (ax.a().j()) && (!this.isOrangeToastShowing))
      {
        this.orange_toast.setVisibility(0);
        this.isOrangeToastShowing = true;
        localObject = null;
        if (!this.vrySucc) {
          break label241;
        }
        if (!paramQQUser.mIsZzb) {
          break label227;
        }
        paramQQUser = getResources().getString(2131362627);
      }
    }
    for (;;)
    {
      this.toast_text.setText(paramQQUser);
      this.toast_image.setImageDrawable(getResources().getDrawable(2130837966));
      this.toast_text.postDelayed(new ps(this), 3000L);
      return;
      this.autoStartModPwdActivity = false;
      break;
      label213:
      setContentView(2130903135);
      init();
      break label60;
      label227:
      paramQQUser = getResources().getString(2131362811);
      continue;
      label241:
      if (this.autoStartModPwdActivity)
      {
        this.autoStartModPwdActivity = false;
        paramQQUser = getResources().getString(2131362624);
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
    showUserDialog(2131361808, paramString, 2131361800, new po(this), new pp(this));
  }
  
  public void onClick(View paramView)
  {
    boolean bool;
    QQUser localQQUser;
    if (paramView.getId() == 2131296822)
    {
      bool = true;
      e.a(bool);
      localQQUser = ax.a().e();
    }
    switch (paramView.getId())
    {
    case 2131296823: 
    default: 
    case 2131296822: 
      do
      {
        do
        {
          return;
          bool = false;
          break;
          this.mPwdText = this.mPwdTextView.getText().toString();
        } while ((this.mPwdText == null) || (this.mPwdText.length() <= 0));
        t.a(this);
      } while (localQQUser == null);
      if ((localQQUser.mIsZzb) && (this.vrySucc))
      {
        showUserDialog(2131361808, getResources().getString(2131361930) + this.mPwdText, 2131361800, 2131361804, new pt(this), null);
        return;
      }
      bf.a().a(1, this.mHandler);
      showProDialog(this, 2131361808, 2131361931, null);
      return;
    case 2131296825: 
      p.a().a(System.currentTimeMillis(), 14);
      startActivity(new Intent(this, StartPwdUpdateInfoActivity.class));
    case 2131296826: 
      finish();
      return;
    }
    if (this.mGoToLoginMsgList) {
      startActivity(new Intent(this, OpMsgDisplayActivity.class));
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.autoStartModPwdActivity = false;
    ax.a().e();
    af.a().b(this.mHandler);
    showProDialog(this, 2131361808, 2131361817, null);
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
    ba.a().h.a("modify_pwd").a();
  }
  
  public void showSuccessView()
  {
    setBackArrowHide();
    setRightTitleImageHide();
    setContentView(2130903136);
    this.mCompleteBtn = ((Button)findViewById(2131296824));
    this.mSetTokenPwdBtn = ((Button)findViewById(2131296825));
    this.mNoSetTokenPwdBtn = ((Button)findViewById(2131296826));
    this.mSetTokenPwdTipText = ((TextView)findViewById(2131296823));
    this.mSetTokenPwdBtn.setOnClickListener(this);
    this.mNoSetTokenPwdBtn.setOnClickListener(this);
    this.mCompleteBtn.setOnClickListener(this);
    if ((ah.a().c()) || (this.mGoToLoginMsgList))
    {
      this.mCompleteBtn.setVisibility(0);
      this.mSetTokenPwdBtn.setVisibility(8);
      this.mNoSetTokenPwdBtn.setVisibility(8);
      this.mSetTokenPwdTipText.setVisibility(8);
    }
    for (;;)
    {
      AccountPageActivity.mNeedRefreshEval = true;
      return;
      this.mCompleteBtn.setVisibility(8);
      this.mSetTokenPwdBtn.setVisibility(0);
      this.mNoSetTokenPwdBtn.setVisibility(0);
      this.mSetTokenPwdTipText.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ModifyQQPwdActivity
 * JD-Core Version:    0.7.0.1
 */