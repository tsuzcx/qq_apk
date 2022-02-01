package com.tencent.qqmail.account.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmail.account.helper.Helper;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.LoginUser;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.utilities.qmnetwork.qmuser.QMVerify;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateHelper;

public class LoginVerifyCodeView
  extends LinearLayout
{
  private EditText editTextVerifyCodeInput;
  private ImageView verifyImage;
  private View verifyLoading;
  private ImageButton verifyRefreshBtn;
  private TextView verifyReloadTips;
  
  public LoginVerifyCodeView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public LoginVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public LoginVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    inflate(paramContext, initLayout(), this);
    initViews();
  }
  
  private int initLayout()
  {
    return 2131563306;
  }
  
  private void initViews()
  {
    this.editTextVerifyCodeInput = ((EditText)findViewById(2131381494));
    this.verifyImage = ((ImageView)findViewById(2131381493));
    this.verifyReloadTips = ((TextView)findViewById(2131381509));
    this.verifyLoading = findViewById(2131381499);
    this.verifyRefreshBtn = ((ImageButton)findViewById(2131381508));
    Helper.initEditTextAndClearButton(this.editTextVerifyCodeInput, findViewById(2131364665));
  }
  
  public EditText getEditTextVerifyCodeInput()
  {
    return this.editTextVerifyCodeInput;
  }
  
  public void getVerifyCode(Account paramAccount)
  {
    ValidateHelper.notNull(paramAccount);
    paramAccount = (QQMailAccount)paramAccount;
    QMVerify localQMVerify = paramAccount.getLoginUser().getLastVerify();
    if ((localQMVerify == null) || (localQMVerify.getVurl() == null) || (localQMVerify.getVurl().length() == 0)) {
      return;
    }
    Threads.runInBackground(new LoginVerifyCodeView.1(this, localQMVerify, paramAccount));
  }
  
  public void setChangeVerifyImgListener(View.OnClickListener paramOnClickListener)
  {
    this.verifyReloadTips.setOnClickListener(paramOnClickListener);
    this.verifyRefreshBtn.setOnClickListener(paramOnClickListener);
    this.verifyImage.setOnClickListener(paramOnClickListener);
  }
  
  public void setVerifyError()
  {
    this.verifyRefreshBtn.setVisibility(0);
    this.verifyLoading.setVisibility(8);
    this.verifyReloadTips.setVisibility(0);
    this.verifyImage.setImageBitmap(null);
  }
  
  public void setVerifyImg(Bitmap paramBitmap)
  {
    this.verifyRefreshBtn.setVisibility(0);
    this.verifyLoading.setVisibility(8);
    this.verifyReloadTips.setVisibility(8);
    this.verifyImage.setImageBitmap(paramBitmap);
  }
  
  public void setVerifyLoading()
  {
    this.verifyRefreshBtn.setVisibility(8);
    this.verifyLoading.setVisibility(0);
    this.verifyReloadTips.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.view.LoginVerifyCodeView
 * JD-Core Version:    0.7.0.1
 */