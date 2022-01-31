package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class SuitUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "SuitUIPlugin";
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.activity.I = decodeUrl(this.activity.I);
    if (QLog.isColorLevel()) {
      QLog.d("SuitUIPlugin", 2, this.activity.I);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 262144L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin
 * JD-Core Version:    0.7.0.1
 */