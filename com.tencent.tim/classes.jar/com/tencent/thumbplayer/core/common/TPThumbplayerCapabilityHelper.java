package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.HashMap;

public class TPThumbplayerCapabilityHelper
{
  public static boolean addACodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPACodecPropertyRange paramTPACodecPropertyRange)
    throws TPNativeLibraryException
  {
    return TPPlayerDecoderCapability.addACodecBlacklist(paramInt1, paramInt2, paramTPACodecPropertyRange);
  }
  
  public static boolean addACodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPACodecPropertyRange paramTPACodecPropertyRange)
    throws TPNativeLibraryException
  {
    return TPPlayerDecoderCapability.addACodecWhitelist(paramInt1, paramInt2, paramTPACodecPropertyRange);
  }
  
  public static boolean addDRMLevel1Blacklist(int paramInt)
  {
    return TPPlayerDecoderCapability.addDRMLevel1Blacklist(paramInt);
  }
  
  public static boolean addHDRBlackList(int paramInt, TPCodecCapability.TPHdrSupportVersionRange paramTPHdrSupportVersionRange)
  {
    return TPPlayerDecoderCapability.addHDRBlackList(paramInt, paramTPHdrSupportVersionRange);
  }
  
  public static boolean addHDRWhiteList(int paramInt, TPCodecCapability.TPHdrSupportVersionRange paramTPHdrSupportVersionRange)
  {
    return TPPlayerDecoderCapability.addHDRWhiteList(paramInt, paramTPHdrSupportVersionRange);
  }
  
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
    throws TPNativeLibraryException
  {
    return TPPlayerDecoderCapability.addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
    throws TPNativeLibraryException
  {
    return TPPlayerDecoderCapability.addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
  }
  
  public static int[] getDRMCapabilities()
    throws TPNativeLibraryException
  {
    return TPDrm.getDRMCapabilities();
  }
  
  public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
    throws TPNativeLibraryException
  {
    return TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(paramInt);
  }
  
  public static TPCodecCapability.TPCodecMaxCapability getVCodecMaxCapability(int paramInt)
    throws TPNativeLibraryException
  {
    TPCodecCapability.TPCodecMaxCapability localTPCodecMaxCapability2 = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    HashMap localHashMap1 = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(102);
    HashMap localHashMap2 = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(101);
    TPCodecCapability.TPCodecMaxCapability localTPCodecMaxCapability1;
    if ((localHashMap1 != null) && (localHashMap2 != null))
    {
      localTPCodecMaxCapability1 = localTPCodecMaxCapability2;
      if (localHashMap1.containsKey(Integer.valueOf(paramInt)))
      {
        localTPCodecMaxCapability1 = localTPCodecMaxCapability2;
        if (localHashMap2.containsKey(Integer.valueOf(paramInt)))
        {
          if (((TPCodecCapability.TPCodecMaxCapability)localHashMap1.get(Integer.valueOf(paramInt))).maxLumaSamples < ((TPCodecCapability.TPCodecMaxCapability)localHashMap2.get(Integer.valueOf(paramInt))).maxLumaSamples) {
            break label108;
          }
          localTPCodecMaxCapability1 = (TPCodecCapability.TPCodecMaxCapability)localHashMap1.get(Integer.valueOf(paramInt));
        }
      }
    }
    label108:
    do
    {
      do
      {
        do
        {
          return localTPCodecMaxCapability1;
          return (TPCodecCapability.TPCodecMaxCapability)localHashMap2.get(Integer.valueOf(paramInt));
          if (localHashMap1 == null) {
            break;
          }
          localTPCodecMaxCapability1 = localTPCodecMaxCapability2;
        } while (!localHashMap1.containsKey(Integer.valueOf(paramInt)));
        return (TPCodecCapability.TPCodecMaxCapability)localHashMap1.get(Integer.valueOf(paramInt));
        localTPCodecMaxCapability1 = localTPCodecMaxCapability2;
      } while (localHashMap2 == null);
      localTPCodecMaxCapability1 = localTPCodecMaxCapability2;
    } while (!localHashMap2.containsKey(Integer.valueOf(paramInt)));
    return (TPCodecCapability.TPCodecMaxCapability)localHashMap2.get(Integer.valueOf(paramInt));
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      TPPlayerDecoderCapability.init(paramContext, paramBoolean);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean isACodecCapabilityCanSupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws TPNativeLibraryException
  {
    if (isACodecCapabilitySupport(1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6)) {
      return true;
    }
    return isACodecCapabilitySupport(102, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public static boolean isACodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws TPNativeLibraryException
  {
    return TPPlayerDecoderCapability.isACodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public static boolean isDDPlusSupported()
  {
    return TPPlayerDecoderCapability.isDDPlusSupported();
  }
  
  public static boolean isDDSupported()
  {
    return TPPlayerDecoderCapability.isDDPlusSupported();
  }
  
  public static boolean isDRMsupport(int paramInt)
    throws TPNativeLibraryException
  {
    int[] arrayOfInt = getDRMCapabilities();
    if (arrayOfInt.length == 0) {}
    for (;;)
    {
      return false;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isDolbyDSSupported()
  {
    return TPPlayerDecoderCapability.isDolbyDSSupported();
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    return TPPlayerDecoderCapability.isHDRsupport(paramInt1, paramInt2, paramInt3);
  }
  
  public static boolean isSupportMediaCodecRotateInternal()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isSupportNativeMediaCodec()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isSupportSetOutputSurfaceApi()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  @Deprecated
  public static boolean isVCodecCapabilityCanSupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    throws TPNativeLibraryException
  {
    return isVCodecCapabilityCanSupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 30);
  }
  
  public static boolean isVCodecCapabilityCanSupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws TPNativeLibraryException
  {
    if (isVCodecCapabilitySupport(101, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6)) {
      return true;
    }
    return isVCodecCapabilitySupport(102, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  @Deprecated
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws TPNativeLibraryException
  {
    return isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 30);
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws TPNativeLibraryException
  {
    return TPPlayerDecoderCapability.isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper
 * JD-Core Version:    0.7.0.1
 */