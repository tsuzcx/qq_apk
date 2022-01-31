package com.tencent.mobileqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class OpenIdInfoObserver
  implements BusinessObserver
{
  protected void onOpenIdInfoReceive(boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = "";
    String str2 = "";
    Bundle localBundle = null;
    if (paramBundle.containsKey("openid")) {
      str1 = paramBundle.getString("openid");
    }
    if (paramBundle.containsKey("openkey")) {
      str2 = paramBundle.getString("openkey");
    }
    if (QLog.isColorLevel()) {
      QLog.d("OpenIdInfoObserver", 2, "onReceive:--openid=" + str1 + " openkey=" + str2);
    }
    if (paramBundle.containsKey("callbackdata")) {
      localBundle = paramBundle.getBundle("callbackdata");
    }
    onOpenIdInfoReceive(paramBoolean, str1, str2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.observer.OpenIdInfoObserver
 * JD-Core Version:    0.7.0.1
 */