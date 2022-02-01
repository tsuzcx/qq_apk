package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class AccessibilityServiceInfoCompat
{
  public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
  public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
  public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
  public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
  public static final int FEEDBACK_ALL_MASK = -1;
  public static final int FEEDBACK_BRAILLE = 32;
  public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
  public static final int FLAG_REPORT_VIEW_IDS = 16;
  public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
  public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
  public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
  
  @NonNull
  public static String capabilityToString(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 8)
      {
        switch (paramInt)
        {
        default: 
          return "UNKNOWN";
        case 2: 
          return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
        }
        return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
      }
      return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
    }
    return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
  }
  
  @NonNull
  public static String feedbackTypeToString(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    while (paramInt > 0)
    {
      int i = 1 << Integer.numberOfTrailingZeros(paramInt);
      paramInt &= (i ^ 0xFFFFFFFF);
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append(", ");
      }
      if (i != 4)
      {
        if (i != 8)
        {
          if (i != 16) {
            switch (i)
            {
            default: 
              break;
            case 2: 
              localStringBuilder.append("FEEDBACK_HAPTIC");
              break;
            case 1: 
              localStringBuilder.append("FEEDBACK_SPOKEN");
              break;
            }
          } else {
            localStringBuilder.append("FEEDBACK_GENERIC");
          }
        }
        else {
          localStringBuilder.append("FEEDBACK_VISUAL");
        }
      }
      else {
        localStringBuilder.append("FEEDBACK_AUDIBLE");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  @Nullable
  public static String flagToString(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 8)
      {
        if (paramInt != 16)
        {
          if (paramInt != 32)
          {
            switch (paramInt)
            {
            default: 
              return null;
            case 2: 
              return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            }
            return "DEFAULT";
          }
          return "FLAG_REQUEST_FILTER_KEY_EVENTS";
        }
        return "FLAG_REPORT_VIEW_IDS";
      }
      return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    }
    return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
  }
  
  public static int getCapabilities(@NonNull AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramAccessibilityServiceInfo.getCapabilities();
    }
    if (paramAccessibilityServiceInfo.getCanRetrieveWindowContent()) {
      return 1;
    }
    return 0;
  }
  
  @Nullable
  public static String loadDescription(@NonNull AccessibilityServiceInfo paramAccessibilityServiceInfo, @NonNull PackageManager paramPackageManager)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramAccessibilityServiceInfo.loadDescription(paramPackageManager);
    }
    return paramAccessibilityServiceInfo.getDescription();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat
 * JD-Core Version:    0.7.0.1
 */