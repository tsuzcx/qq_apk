package com.tencent.biz.viewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import jpa;
import ssj;

public class ViewPluginManager$3
  implements Runnable
{
  public ViewPluginManager$3(ssj paramssj) {}
  
  public void run()
  {
    String str = "https://" + this.this$0.mPluginName + "?_bid=" + this.this$0.mBid;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "checkOfflineUpNotCallback.");
    }
    jpa.b(str, this.this$0.mActivity.getAppRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager.3
 * JD-Core Version:    0.7.0.1
 */