package com.tencent.viola.module;

import android.text.TextUtils;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;

public class BackAndroidModule
  extends BaseModule
{
  public static final String MODULE_NAME = "backAndroid";
  private String mCallBackId;
  private boolean mConsumeBack = false;
  
  @JSMethod(uiThread=false)
  public void addListener(String paramString)
  {
    this.mConsumeBack = true;
    this.mCallBackId = paramString;
  }
  
  public boolean onActivityBack()
  {
    if ((this.mConsumeBack) && (!TextUtils.isEmpty(this.mCallBackId)) && (ViolaBridgeManager.getInstance() != null)) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "backAndroid", "callback", this.mCallBackId, null, true);
    }
    return this.mConsumeBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.module.BackAndroidModule
 * JD-Core Version:    0.7.0.1
 */