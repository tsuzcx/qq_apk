package com.tencent.qqmail.activity.qrcode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Selection;
import android.view.GestureDetector;
import android.view.View;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.QMTopBar;

public class QrCodeInfoActivity
  extends BaseActivityEx
{
  private static final String KEY_INFO = "info";
  private String mInfo;
  private View mScrollView;
  private QrTextView mTextView;
  
  @SuppressLint({"NewApi"})
  private void copy()
  {
    int i = Selection.getSelectionStart(this.mTextView.getText());
    int j = Selection.getSelectionEnd(this.mTextView.getText());
    if ((i > j) || (i < 0) || (j > this.mInfo.length())) {
      return;
    }
    if ((i == 0) && (j == 0)) {}
    String str2;
    for (String str1 = this.mInfo;; str2 = this.mInfo.substring(i, j)) {
      try
      {
        CommUtils.copyText(str1);
        getTips().showSuccess(2131717174);
        return;
      }
      catch (Exception localException)
      {
        getTips().showError(2131717173);
        return;
      }
    }
  }
  
  public static Intent createIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), QrCodeInfoActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("info", paramString);
    return localIntent;
  }
  
  public void finish()
  {
    this.mScrollView.setOnTouchListener(null);
    super.finish();
  }
  
  public void initDataSource()
  {
    this.mInfo = getIntent().getStringExtra("info");
    this.mTextView.setText(this.mInfo);
  }
  
  public void initDom()
  {
    GestureDetector localGestureDetector = new GestureDetector(this, new QrCodeInfoActivity.2(this));
    this.mScrollView.setOnTouchListener(new QrCodeInfoActivity.3(this, localGestureDetector));
  }
  
  public void initUI()
  {
    setContentView(2131558507);
    this.mScrollView = findViewById(2131377753);
    QMTopBar localQMTopBar = (QMTopBar)findViewById(2131374722);
    localQMTopBar.setTitle(2131717215);
    localQMTopBar.setButtonLeftIcon(2130841088);
    localQMTopBar.getButtonLeft().setOnClickListener(new QrCodeInfoActivity.1(this));
    this.mTextView = ((QrTextView)findViewById(2131369154));
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onOverridePendingTransition()
  {
    overridePendingTransition(2130772401, 2130772430);
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    overridePendingTransition(0, 2130772402);
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.qrcode.QrCodeInfoActivity
 * JD-Core Version:    0.7.0.1
 */