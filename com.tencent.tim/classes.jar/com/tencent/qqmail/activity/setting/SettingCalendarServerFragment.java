package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.qqmail.account.helper.Helper;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.LoginType;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.app.FragmentActivity;

public class SettingCalendarServerFragment
  extends SettingCalendarBaseFragment
{
  private Button CalDAVBtn;
  private Button ExchangeBtn;
  private EditText describeEditText;
  private RelativeLayout describeLayout;
  private boolean isExchange = true;
  private CheckBox isUseSSLCheckBox;
  private RelativeLayout isUseSSLLayout;
  private boolean isVerify = false;
  private boolean isVerifySuccess = false;
  private Account mAccount;
  private QMBaseView mBaseView;
  private QMTopBar mTopBar = null;
  private EditText passwordEditText;
  private EditText serverEditText;
  private View.OnClickListener tabButton = new SettingCalendarServerFragment.1(this);
  private EditText userNameEditText;
  
  protected SettingCalendarServerFragment(Account paramAccount)
  {
    super(false);
    this.mAccount = paramAccount;
  }
  
  private QMTopBar refreshTopBar()
  {
    this.mTopBar = getTopBar();
    if (!this.isVerify)
    {
      this.mTopBar.showLoading(false);
      this.mTopBar.setTitle(2131719698);
      this.mTopBar.setButtonLeftBack();
      this.mTopBar.setButtonRightBlue(2131693745);
    }
    for (;;)
    {
      this.mTopBar.setButtonLeftOnclickListener(new SettingCalendarServerFragment.2(this));
      this.mTopBar.setButtonRightOnclickListener(new SettingCalendarServerFragment.3(this));
      return this.mTopBar;
      this.mTopBar.showLoading(true);
      this.mTopBar.setTitle(2131719699);
      this.mTopBar.setButtonLeftNormal(2131691246);
      this.mTopBar.getButtonRight().setVisibility(8);
    }
  }
  
  private void setItemViewEnable(boolean paramBoolean)
  {
    this.ExchangeBtn.setClickable(paramBoolean);
    this.CalDAVBtn.setClickable(paramBoolean);
    this.serverEditText.setEnabled(paramBoolean);
    this.userNameEditText.setEnabled(paramBoolean);
    this.passwordEditText.setEnabled(paramBoolean);
    this.describeEditText.setEnabled(paramBoolean);
    this.isUseSSLCheckBox.setEnabled(paramBoolean);
  }
  
  private void showErrorDialog(int paramInt)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131693264)).setMessage(paramInt).addAction(2131696547, new SettingCalendarServerFragment.4(this))).create().show();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (this.isVerifySuccess) {
      localIntent.putExtra("result", 1);
    }
    for (;;)
    {
      getActivity().setResult(-1, localIntent);
      popBackStack();
      return;
      localIntent.putExtra("result", 0);
    }
  }
  
  public QMTopBar getTopBar()
  {
    if (this.mTopBar == null) {
      this.mTopBar = new QMTopBar(getActivity());
    }
    return this.mTopBar;
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.ExchangeBtn = ((Button)findViewById(2131366567));
    this.CalDAVBtn = ((Button)findViewById(2131364159));
    this.serverEditText = ((EditText)findViewById(2131378054));
    this.userNameEditText = ((EditText)findViewById(2131381229));
    this.passwordEditText = ((EditText)findViewById(2131372891));
    this.describeEditText = ((EditText)findViewById(2131365746));
    Helper.initEditTextAndClearButton(this.serverEditText, findViewById(2131364655), null, null);
    Helper.initEditTextAndClearButton(this.userNameEditText, findViewById(2131364660), null, null);
    Helper.initEditTextAndClearButton(this.passwordEditText, findViewById(2131364651), null, null);
    Helper.initEditTextAndClearButton(this.describeEditText, findViewById(2131364644), null, null);
    this.isUseSSLCheckBox = ((CheckBox)findViewById(2131378678));
    this.isUseSSLLayout = ((RelativeLayout)findViewById(2131378143));
    this.describeLayout = ((RelativeLayout)findViewById(2131378123));
    this.ExchangeBtn.setOnClickListener(this.tabButton);
    this.CalDAVBtn.setOnClickListener(this.tabButton);
    if (this.mAccount != null)
    {
      this.userNameEditText.setText(this.mAccount.getEmail());
      if (!StringExtention.isNullOrEmpty(this.mAccount.getPwd()))
      {
        this.passwordEditText.setText(Aes.decode(this.mAccount.getPwd(), Aes.getPureDeviceToken()));
        if (this.passwordEditText.getText().toString().equals("")) {
          this.passwordEditText.setText("********");
        }
      }
      paramView = QMCalendarProtocolManager.getLoginType(this.mAccount, 0);
      if (paramView.getAccountType() == 2) {}
      for (this.isExchange = false;; this.isExchange = true)
      {
        if (paramView.getHost() != null) {
          this.serverEditText.setText(paramView.getHost());
        }
        if (!this.isExchange) {
          break;
        }
        this.ExchangeBtn.setSelected(true);
        this.describeLayout.setVisibility(8);
        return;
      }
      this.CalDAVBtn.setSelected(true);
      this.isUseSSLLayout.setVisibility(8);
      return;
    }
    finish();
  }
  
  public void initTopbar(View paramView)
  {
    this.mTopBar = refreshTopBar();
    this.mBaseView.addView(this.mTopBar);
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mBaseView = new QMBaseView(getActivity());
    this.mBaseView.initScrollView();
    paramViewHolder = View.inflate(getActivity(), 2131558811, null);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    paramViewHolder.setLayoutParams(localLayoutParams);
    paramViewHolder.setVerticalFadingEdgeEnabled(false);
    this.mBaseView.addContentView(paramViewHolder);
    return this.mBaseView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarServerFragment
 * JD-Core Version:    0.7.0.1
 */