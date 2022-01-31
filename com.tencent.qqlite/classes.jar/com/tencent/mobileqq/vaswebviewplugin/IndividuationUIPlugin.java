package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class IndividuationUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "SuitUIPlugin";
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.activity.K = super.decodeUrl(this.activity.K, false);
    if (QLog.isColorLevel()) {
      QLog.d("SuitUIPlugin", 2, this.activity.K);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 1048576L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.IndividuationUIPlugin
 * JD-Core Version:    0.7.0.1
 */