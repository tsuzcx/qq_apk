package com.tencent.tav;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tav.decoder.logger.Logger;

public class ResourceLoadUtil
{
  public static final String TAG = ResourceLoadUtil.class.getSimpleName();
  private static boolean success = false;
  
  public static boolean isLoaded()
  {
    return success;
  }
  
  public static boolean loadSoSync(@NonNull String paramString)
  {
    if (!success)
    {
      if (TextUtils.isEmpty(paramString))
      {
        success = false;
        Logger.e(TAG, "load so path is empty.");
        return success;
      }
      try
      {
        System.load(paramString);
        success = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        success = false;
        Logger.e(TAG, localUnsatisfiedLinkError.getMessage());
      }
      catch (RuntimeException localRuntimeException)
      {
        success = false;
        Logger.e(TAG, localRuntimeException.getMessage());
      }
      catch (Exception localException)
      {
        success = false;
        Logger.e(TAG, localException.getMessage());
      }
      finally
      {
        Logger.d(TAG, "load " + paramString + ": " + success);
        return success;
      }
    }
    return success;
  }
  
  public static void setLoaded(boolean paramBoolean)
  {
    success = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.tav.ResourceLoadUtil
 * JD-Core Version:    0.7.0.1
 */