package com.tencent.qqmail.utilities.ui;

import android.content.Intent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.QMSpreadAPPInfo;

public class QMOpenFileActivity
  extends BaseActivityEx
{
  private static final String ARG_IS_TYPE_SUPPORT_QQBROWSER = "arg_is_type_support_qqbrowser";
  private static final String ARG_TITLE = "arg_title";
  private static final String ARG_TYPE = "arg_type";
  private static final String ARG_URL = "arg_url";
  private static final String TAG = "QMOpenFileActivity";
  public static QMOpenFileDialogHelper openFileDialog;
  
  public static Intent createIntent(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), QMOpenFileActivity.class);
    localIntent.putExtra("arg_title", paramString1);
    localIntent.putExtra("arg_url", paramString2);
    localIntent.putExtra("arg_type", paramString3);
    localIntent.putExtra("arg_is_type_support_qqbrowser", paramBoolean);
    return localIntent;
  }
  
  public void finish()
  {
    super.finish();
    if (openFileDialog != null)
    {
      openFileDialog.dismiss();
      openFileDialog = null;
    }
    overridePendingTransition(0, 0);
  }
  
  public void initDataSource()
  {
    Intent localIntent = getIntent();
    openFileDialog = new QMOpenFileDialogHelper(this, localIntent.getStringExtra("arg_title"), localIntent.getStringExtra("arg_url"), localIntent.getStringExtra("arg_type"), localIntent.getBooleanExtra("arg_is_type_support_qqbrowser", false));
    openFileDialog.show();
    QMSpreadAPPInfo.registerDownLoadReceiver();
  }
  
  public void initDom()
  {
    overridePendingTransition(0, 0);
  }
  
  public void initUI()
  {
    setTheme(2131755679);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onPause()
  {
    setFadeBackground();
    super.onPause();
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMOpenFileActivity
 * JD-Core Version:    0.7.0.1
 */