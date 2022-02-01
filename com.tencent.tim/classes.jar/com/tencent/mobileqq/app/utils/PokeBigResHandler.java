package com.tencent.mobileqq.app.utils;

import acbn;
import accg;
import acci;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import aolm.b;
import aomg;
import aomh;
import aqhq;
import aqul;
import aszr;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PokeBigResHandler
  extends accg
{
  private static final String DOWNLOAD_PATH = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "/bigPoke");
  public static boolean bKF;
  private static String brq = "";
  private static String brr = "";
  public static final String brs = aqul.getSDKPrivatePath(acbn.bmy);
  public static final String brt = brs + "/poke_egg";
  public static final String bru = brs + "/poke_normal";
  public static final String brv = bru + "/dazhao/dazhao_move.png";
  private static final String[] cG = { "/666receive_motion", "/666send_motion", "/bixin_motion", "/chuo_motion", "/dazhao", "/xinsui_motion", "/zan_motion" };
  private static boolean cj;
  private static final String[] ep = { "/666_caidan", "/chuo_caidan", "/dazhao_caidan", "/xinsui_caidan" };
  private static final int[] kq = { 57, 57, 67, 6, 0, 50, 20 };
  private static final int[] kr = { 2, 10, 37, 55 };
  private a a = new a();
  
  public PokeBigResHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static boolean adj()
  {
    Object localObject = new File(brs);
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).list();
      if ((localObject != null) && (localObject.length == 2))
      {
        int i = 0;
        while (i < 4)
        {
          if (!s(i, brt))
          {
            bKF = false;
            return false;
          }
          i += 1;
        }
        i = 0;
        while (i < 7)
        {
          if (!t(i, bru))
          {
            bKF = false;
            return false;
          }
          i += 1;
        }
        bKF = true;
        return true;
      }
    }
    bKF = false;
    return false;
  }
  
  private static boolean adk()
  {
    File localFile = new File(brs);
    return (localFile.exists()) && (localFile.list() != null);
  }
  
  private static boolean kN(String paramString)
  {
    Object localObject = null;
    String str = brq;
    File localFile = new File(paramString);
    if (localFile.exists()) {
      try
      {
        paramString = HexUtil.bytes2HexStr(MD5.getFileMd5(localFile.getAbsolutePath()));
        if ((paramString != null) && (str != null) && (paramString.toLowerCase().equals(str.toLowerCase())))
        {
          sv(localFile.getAbsolutePath());
          return adj();
        }
      }
      catch (UnsatisfiedLinkError paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("BigResDown", 2, new Object[] { "doOnServerResp, fStorage, UnsatisfiedLinkError, e.message=", paramString.getMessage() });
            paramString.printStackTrace();
          }
          try
          {
            paramString = aszr.getFileMD5String(localFile);
          }
          catch (Exception paramString)
          {
            paramString = localObject;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("BigResDown", 2, "verifyResource() get file md5 failed:" + localFile.getAbsolutePath());
            paramString = localObject;
          }
        }
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("BigResDown", 2, new Object[] { "doOnServerResp, fStorage, OutOfMemoryError, oom.message=", paramString.getMessage() });
            paramString.printStackTrace();
          }
          try
          {
            paramString = aszr.getFileMD5String(localFile);
          }
          catch (Exception paramString)
          {
            paramString = localObject;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("BigResDown", 2, "verifyResource() get file md5 failed:" + localFile.getAbsolutePath());
            paramString = localObject;
          }
        }
        localFile.delete();
      }
    }
    return false;
  }
  
  public static boolean s(int paramInt, String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString + ep[paramInt]);
    paramInt = kr[paramInt];
    boolean bool1 = bool2;
    try
    {
      if (paramString.exists())
      {
        bool1 = bool2;
        if (paramString.isDirectory())
        {
          paramString = paramString.list();
          bool1 = bool2;
          if (paramString != null)
          {
            bool1 = bool2;
            if (paramString.length > 0)
            {
              int i = paramString.length;
              bool1 = bool2;
              if (i == paramInt) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    catch (NullPointerException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("PokeBigResHandler", 2, paramString, new Object[0]);
    }
    return bool1;
    return false;
  }
  
  private static void sv(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BigResDown", 2, "start compress");
    }
    long l1 = System.currentTimeMillis();
    if (!new File(paramString).exists()) {}
    for (;;)
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(aqul.getSDKPrivatePath(DOWNLOAD_PATH)))
        {
          aqhq.delete(aqul.getSDKPrivatePath(brs), false);
          aqhq.W(paramString, aqul.getSDKPrivatePath(brs), false);
        }
        aqhq.delete(paramString, false);
        long l2 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BigResDown", 2, "end compress ,cost " + (l2 - l1));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static boolean t(int paramInt, String paramString)
  {
    boolean bool = true;
    paramString = paramString + cG[paramInt];
    int i = kq[paramInt];
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = paramString.listFiles();
      if (paramString != null) {
        break label58;
      }
    }
    label58:
    label68:
    String[] arrayOfString1;
    do
    {
      return false;
      if (paramInt != 4) {
        break label177;
      }
      i = paramString.length;
      paramInt = 0;
      if (paramInt >= i) {
        break;
      }
      arrayOfString1 = paramString[paramInt];
    } while (arrayOfString1 == null);
    if (arrayOfString1.getName().contains("dazhao_move")) {}
    for (;;)
    {
      paramInt += 1;
      break label68;
      if (arrayOfString1.getName().contains("daozhao_motion"))
      {
        String[] arrayOfString2 = arrayOfString1.list();
        if (arrayOfString2 == null) {
          break;
        }
        if (arrayOfString2.length == 29) {
          continue;
        }
      }
      if (!arrayOfString1.getName().contains("dazhao2_motion")) {
        break;
      }
      arrayOfString1 = arrayOfString1.list();
      if ((arrayOfString1 == null) || (arrayOfString1.length != 23)) {
        break;
      }
    }
    return true;
    label177:
    if (paramString.length == i) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void FO(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = adk();
        if (paramBoolean) {
          return;
        }
        if (!cj)
        {
          PokeBigResHandler.1 local1 = new PokeBigResHandler.1(this);
          if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManager.post(local1, 10, null, false);
          } else {
            localObject.run();
          }
        }
      }
      finally {}
    }
  }
  
  public Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public class BigResRunnable
    implements Runnable
  {
    public void run() {}
  }
  
  public static class a
    implements aolm.b
  {
    public void onResp(aomh paramaomh)
    {
      if (paramaomh.mResult == 0) {
        ThreadManagerV2.excute(new PokeBigResHandler.NetEngine.1(this, paramaomh.b.atY), 64, null, true);
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
    {
      Log.e("Ron", "req:[" + paramaomg.toString() + "\n curOffset" + paramLong1 + "\n totalLen" + paramLong2 + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler
 * JD-Core Version:    0.7.0.1
 */