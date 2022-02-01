package com.tencent.qqmail.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class SettingSignatureActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNT_ID = "arg_account_id";
  private static final String TAG = "SettingSignatureActivity";
  private int accountId;
  private EditText mNicknameEditText;
  private QMBaseView mSettingView;
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingSignatureActivity.class);
    localIntent.putExtra("arg_account_id", paramInt);
    return localIntent;
  }
  
  public static EditText getMutilinEditText(Context paramContext)
  {
    EditText localEditText = new EditText(paramContext);
    localEditText.setBackgroundResource(2130841255);
    localEditText.setPadding(paramContext.getResources().getDimensionPixelSize(2131299392), paramContext.getResources().getDimensionPixelSize(2131299402), paramContext.getResources().getDimensionPixelSize(2131299392), paramContext.getResources().getDimensionPixelSize(2131299402));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, paramContext.getResources().getDimensionPixelSize(2131299376), 0, paramContext.getResources().getDimensionPixelSize(2131299375));
    localEditText.setLayoutParams(localLayoutParams);
    localEditText.setGravity(48);
    localEditText.setHintTextColor(paramContext.getResources().getColor(2131167534));
    localEditText.setTextColor(paramContext.getResources().getColor(2131165381));
    localEditText.setLines(6);
    return localEditText;
  }
  
  private void hideKB(View paramView)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719961);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void saveSignature()
  {
    QMSettingManager.sharedInstance().setAccountSignature(this.accountId, this.mNicknameEditText.getText().toString());
    QMMailManager.sharedInstance().setPersonalizedSignature(this.accountId, this.mNicknameEditText.getText().toString());
    DataCollector.logEvent("DetailEvent_ModifySign");
  }
  
  public void initDataSource()
  {
    this.accountId = getIntent().getIntExtra("arg_account_id", 0);
  }
  
  public void initDom()
  {
    initTopBar();
    this.mNicknameEditText = getMutilinEditText(this);
    this.mNicknameEditText.setHint(2131719961);
    this.mSettingView.addContentView(this.mNicknameEditText);
    String str = QMSettingManager.sharedInstance().getAccountSignature(this.accountId);
    if ((str != null) && (!str.equals("")))
    {
      this.mNicknameEditText.setText(str);
      this.mNicknameEditText.setSelection(str.length());
    }
    KeyBoardHelper.showSoftInputDelay(this.mNicknameEditText, 800L);
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBackPressed()
  {
    saveSignature();
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    hideKB(this.mNicknameEditText);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onButtonBackClick()
  {
    saveSignature();
    super.onButtonBackClick();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSignatureActivity
 * JD-Core Version:    0.7.0.1
 */