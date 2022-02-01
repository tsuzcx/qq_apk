package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.LibLoadUtil;
import java.lang.reflect.Method;

public class StarTrailHelper
{
  private static boolean bLoadSucc = false;
  
  public static boolean loadso(Context paramContext)
  {
    if (!bLoadSucc) {
      bLoadSucc = LibLoadUtil.loadso(paramContext, "poxy");
    }
    return bLoadSucc;
  }
  
  public static byte[] stGetSign(Context paramContext, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getClassLoader().loadClass("com.tencent.secprotocol.ByteData");
        Object localObject = paramContext.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        paramContext = (byte[])paramContext.getMethod("getSign", new Class[] { String.class, String.class, [B.class }).invoke(localObject, new Object[] { paramString1, paramString2, paramArrayOfByte });
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static int stInitUp(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramContext != null) {
      try
      {
        Class localClass = paramContext.getClassLoader().loadClass("com.tencent.secprotocol.ByteData");
        Object localObject = localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        localClass.getMethod("init", new Class[] { Context.class, String.class, String.class, String.class, String.class, String.class }).invoke(localObject, new Object[] { paramContext, paramString1, paramString2, paramString3, paramString4, paramString5 });
        return 0;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.StarTrailHelper
 * JD-Core Version:    0.7.0.1
 */