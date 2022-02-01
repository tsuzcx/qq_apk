package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;

public class AGConnectServicesConfigImpl
  extends AGConnectServicesConfig
{
  private static final char PATH_SEPARATOR = '/';
  private volatile ConfigReader mConfigReader;
  private final Object mConfigReaderLock = new Object();
  private final Context mContext;
  private LazyInputStream mLazyInput;
  
  public AGConnectServicesConfigImpl(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static String fixPath(String paramString)
  {
    int j = 0;
    int i = 0;
    if (paramString.length() > 0) {
      for (;;)
      {
        j = i;
        if (paramString.charAt(i) != '/') {
          break;
        }
        i += 1;
      }
    }
    return '/' + paramString.substring(j);
  }
  
  private static LazyInputStream newLazyInputStream(Context paramContext, InputStream paramInputStream)
  {
    return new AGConnectServicesConfigImpl.1(paramContext, paramInputStream);
  }
  
  public boolean getBoolean(String paramString)
  {
    return getBoolean(paramString, false);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return Boolean.parseBoolean(getString(paramString, String.valueOf(paramBoolean)));
  }
  
  public int getInt(String paramString)
  {
    return getInt(paramString, 0);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(getString(paramString, String.valueOf(paramInt)));
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public String getString(String paramString)
  {
    return getString(paramString, null);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new NullPointerException("path must not be null.");
    }
    if (this.mConfigReader == null) {}
    synchronized (this.mConfigReaderLock)
    {
      if (this.mConfigReader == null)
      {
        if (this.mLazyInput != null)
        {
          this.mConfigReader = new InputStreamReader(this.mLazyInput.loadInputStream());
          this.mLazyInput.close();
          this.mLazyInput = null;
        }
      }
      else
      {
        paramString1 = fixPath(paramString1);
        return this.mConfigReader.getString(paramString1, paramString2);
      }
      this.mConfigReader = new SecurityResourcesReader(this.mContext);
    }
  }
  
  public void overlayWith(LazyInputStream paramLazyInputStream)
  {
    this.mLazyInput = paramLazyInputStream;
  }
  
  public void overlayWith(InputStream paramInputStream)
  {
    overlayWith(newLazyInputStream(this.mContext, paramInputStream));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.config.impl.AGConnectServicesConfigImpl
 * JD-Core Version:    0.7.0.1
 */