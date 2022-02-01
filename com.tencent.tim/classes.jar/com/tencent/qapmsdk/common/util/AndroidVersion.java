package com.tencent.qapmsdk.common.util;

import android.os.Build.VERSION;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/AndroidVersion;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class AndroidVersion
{
  public static final Companion Companion = new Companion(null);
  
  @JvmStatic
  public static final boolean isIceScreamSandwich()
  {
    return Companion.isIceScreamSandwich();
  }
  
  @JvmStatic
  public static final boolean isJellyBean()
  {
    return Companion.isJellyBean();
  }
  
  @JvmStatic
  public static final boolean isJellyBeanMr1()
  {
    return Companion.isJellyBeanMr1();
  }
  
  @JvmStatic
  public static final boolean isKitKat()
  {
    return Companion.isKitKat();
  }
  
  @JvmStatic
  public static final boolean isKitKatWatch()
  {
    return Companion.isKitKatWatch();
  }
  
  @JvmStatic
  public static final boolean isL()
  {
    return Companion.isL();
  }
  
  @JvmStatic
  public static final boolean isM()
  {
    return Companion.isM();
  }
  
  @JvmStatic
  public static final boolean isN()
  {
    return Companion.isN();
  }
  
  @JvmStatic
  public static final boolean isO()
  {
    return Companion.isO();
  }
  
  @JvmStatic
  public static final boolean isP()
  {
    return Companion.isP();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/AndroidVersion$Companion;", "", "()V", "isIceScreamSandwich", "", "isJellyBean", "isJellyBeanMr1", "isKitKat", "isKitKatWatch", "isL", "isM", "isN", "isO", "isP", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @JvmStatic
    public final boolean isIceScreamSandwich()
    {
      return Build.VERSION.SDK_INT >= 14;
    }
    
    @JvmStatic
    public final boolean isJellyBean()
    {
      return Build.VERSION.SDK_INT >= 16;
    }
    
    @JvmStatic
    public final boolean isJellyBeanMr1()
    {
      return Build.VERSION.SDK_INT >= 17;
    }
    
    @JvmStatic
    public final boolean isKitKat()
    {
      return Build.VERSION.SDK_INT >= 19;
    }
    
    @JvmStatic
    public final boolean isKitKatWatch()
    {
      return Build.VERSION.SDK_INT >= 20;
    }
    
    @JvmStatic
    public final boolean isL()
    {
      return Build.VERSION.SDK_INT >= 21;
    }
    
    @JvmStatic
    public final boolean isM()
    {
      return Build.VERSION.SDK_INT >= 23;
    }
    
    @JvmStatic
    public final boolean isN()
    {
      return Build.VERSION.SDK_INT >= 24;
    }
    
    @JvmStatic
    public final boolean isO()
    {
      return Build.VERSION.SDK_INT >= 26;
    }
    
    @JvmStatic
    public final boolean isP()
    {
      return Build.VERSION.SDK_INT >= 27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.AndroidVersion
 * JD-Core Version:    0.7.0.1
 */