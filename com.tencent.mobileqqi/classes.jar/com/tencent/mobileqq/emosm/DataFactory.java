package com.tencent.mobileqq.emosm;

import android.os.Bundle;

public final class DataFactory
{
  public static final int FAIL_CODE_SUC = 1000;
  public static final int FAIL_CODE_TIMEOUT = 1001;
  public static final int FAIL_CODE_UNBIND = 1002;
  public static final int FAIL_CODE_UNKNOWN = 1003;
  public static final String KEY_CALLBACKID = "callbackid";
  public static final String KEY_CMD = "cmd";
  public static final String KEY_FAIL_CODE = "failcode";
  public static final String KEY_REQUEST_BUNDLE = "request";
  public static final String KEY_RESPONSE_BUNDLE = "response";
  public static final String KEY_RESPONSE_KEY = "respkey";
  
  public static Bundle makeIPCRequestPacket(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putString("callbackid", paramString2);
    localBundle.putInt("respkey", paramInt);
    localBundle.putBundle("request", paramBundle);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.DataFactory
 * JD-Core Version:    0.7.0.1
 */