package com.tencent.qqmail.account.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.qqmail.account.helper.Helper;
import com.tencent.qqmail.account.helper.VerifyCountDownTimer;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import mqq.manager.VerifyDevLockManager;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;

public class LoginVerifyFragment
  extends LoginBaseFragment
{
  private static final String TAG = "LoginVerifyFragment";
  private QMBaseView baseView;
  private Button confirmBtn;
  private final String lockPhone;
  private final VerifyDevLockManager.VerifyDevLockObserver mVerifyObserver = new LoginVerifyFragment.6(this);
  private TextView phoneText;
  private Button resendBtn;
  private final int seq;
  private EditText smsEditText;
  private final int timeLimit;
  private VerifyCountDownTimer timer;
  private QMTopBar topBar;
  
  public LoginVerifyFragment(String paramString, int paramInt1, int paramInt2)
  {
    this.lockPhone = paramString;
    this.seq = paramInt1;
    this.timeLimit = paramInt2;
  }
  
  private void initPhoneView()
  {
    this.phoneText = ((TextView)this.baseView.findViewById(2131373057));
    this.phoneText.setText(String.format(getString(2131689632), new Object[] { this.lockPhone }));
  }
  
  private void initSmsEditView()
  {
    this.smsEditText = ((EditText)this.baseView.findViewById(2131378520));
    this.smsEditText.setInputType(2);
    QMUIHelper.setFocusable(this.smsEditText, true, true, new View[0]);
    Helper.initEditTextAndClearButton(this.smsEditText, this.baseView.findViewById(2131364656));
  }
  
  private void initTopBar()
  {
    this.topBar = getTopBar();
    this.topBar.setTitle(getString(2131689627));
    this.topBar.setButtonLeftBack();
    this.topBar.setButtonLeftOnclickListener(new LoginVerifyFragment.1(this));
    this.topBar.setButtonRightBlue(2131691246);
    this.topBar.getButtonRight().setOnClickListener(new LoginVerifyFragment.2(this));
  }
  
  private void initVerifyView()
  {
    this.resendBtn = ((Button)this.baseView.findViewById(2131377183));
    this.resendBtn.setOnClickListener(new LoginVerifyFragment.3(this));
    this.confirmBtn = ((Button)this.baseView.findViewById(2131365219));
    this.confirmBtn.setOnClickListener(new LoginVerifyFragment.4(this));
    startTimer();
  }
  
  private void startTimer()
  {
    if (this.timer != null) {
      this.timer.cancel();
    }
    this.timer = new VerifyCountDownTimer(this.timeLimit * 1000L, 1000L);
    this.timer.setCountDownAction(new LoginVerifyFragment.5(this));
    this.timer.start();
  }
  
  private void stopTimer()
  {
    if (this.timer != null) {
      this.timer.cancel();
    }
    this.resendBtn.setText(getString(2131689629));
    this.resendBtn.setEnabled(true);
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    initPhoneView();
    initSmsEditView();
    initVerifyView();
    this.mVerifyObserver.setSeq(this.seq);
    ((VerifyDevLockManager)QMAppInterface.sharedInstance().getManager(7)).refreshDevLockSms(this.mVerifyObserver);
    startTimer();
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = super.initUI(paramViewHolder);
    this.baseView.initScrollView();
    this.baseView.setBackgroundColor(getResources().getColor(2131167681));
    this.baseView.addContentView(View.inflate(getActivity(), 2131559510, null));
    return this.baseView;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease()
  {
    stopTimer();
  }
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginVerifyFragment
 * JD-Core Version:    0.7.0.1
 */