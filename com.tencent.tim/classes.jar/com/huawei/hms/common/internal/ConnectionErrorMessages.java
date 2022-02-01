package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.HashMap;
import java.util.Map;

public class ConnectionErrorMessages
{
  private static final Map<String, String> a = new HashMap();
  
  public static String getErrorDialogButtonMessage(Activity paramActivity, int paramInt)
  {
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext());
    }
    switch (paramInt)
    {
    default: 
      return ResourceLoaderUtil.getString("hms_confirm");
    case 1: 
      return ResourceLoaderUtil.getString("hms_install");
    }
    return ResourceLoaderUtil.getString("hms_update");
  }
  
  public static String getErrorMessage(Activity paramActivity, int paramInt)
  {
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext());
    }
    paramActivity = ResourceLoaderUtil.getString("hms_update_title");
    switch (paramInt)
    {
    default: 
      paramActivity = null;
    }
    return paramActivity;
  }
  
  public static String getErrorTitle(Activity paramActivity, int paramInt)
  {
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext());
    }
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      HMSLog.e("HuaweiApiAvailability", "Unexpected error code " + paramInt);
      return null;
    case 1: 
      return ResourceLoaderUtil.getString("hms_install_message");
    case 2: 
      return ResourceLoaderUtil.getString("hms_update_message");
    case 3: 
      return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
    }
    HMSLog.e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.ConnectionErrorMessages
 * JD-Core Version:    0.7.0.1
 */