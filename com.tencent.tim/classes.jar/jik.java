import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class jik
{
  public static String Sk;
  public static int aAd = -1;
  public static int aAe;
  
  public static Bitmap a(Resources paramResources, String paramString)
  {
    return i(paramString, 320, paramResources.getDisplayMetrics().densityDpi);
  }
  
  public static jht a(VideoAppInterface paramVideoAppInterface)
  {
    return (jht)paramVideoAppInterface.a(7);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt, Intent paramIntent)
  {
    a(paramVideoAppInterface).q(paramInt, paramIntent);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    a(paramVideoAppInterface).c(paramAVActivity);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putInt("uinType", paramInt);
    localBundle.putString("wording", paramString2);
    try
    {
      QLog.w("AVRedBag", 1, "notifyWriteGrayMsg, peerUin[" + paramString1 + "], wording[" + paramString2 + "]");
      paramVideoAppInterface.a(1, 0, 0, localBundle, null);
      return;
    }
    catch (Exception paramVideoAppInterface)
    {
      QLog.w("AVRedBag", 1, "notifyWriteGrayMsg, Exception[" + paramVideoAppInterface.getMessage() + "]");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = paramBundle.getString("uin");
        int i = paramBundle.getInt("uinType");
        paramBundle = paramBundle.getString("wording");
        QLog.w("AVRedBag", 1, "writeGrayMsg_in_QQ, peerUin[" + (String)localObject + "], wording[" + paramBundle + "]");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramBundle = new ahwa((String)localObject, paramQQAppInterface.getCurrentAccountUin(), paramBundle, i, -5040, 65560, 0L);
          localObject = new MessageForUniteGrayTip();
          ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramBundle);
          ahwb.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.w("AVRedBag", 1, "writeGrayMsg_in_QQ, Exception[" + paramQQAppInterface.getClass().getName() + "]", paramQQAppInterface);
      }
    }
  }
  
  public static String ay()
  {
    iiv localiiv = VideoController.a().b();
    if (localiiv != null) {
      return localiiv.peerUin;
    }
    return null;
  }
  
  public static long b(VideoAppInterface paramVideoAppInterface)
  {
    try
    {
      long l = Long.valueOf(paramVideoAppInterface.getCurrentAccountUin()).longValue();
      return l;
    }
    catch (Exception paramVideoAppInterface) {}
    return 0L;
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface, int paramInt, Intent paramIntent)
  {
    a(paramVideoAppInterface).p(paramInt, paramIntent);
  }
  
  public static boolean b(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if (isDeviceSupport())
    {
      paramVideoAppInterface = a(paramVideoAppInterface);
      if ((paramVideoAppInterface != null) && (paramVideoAppInterface.wI()) && (!paramVideoAppInterface.xs()))
      {
        QLog.w("AVRedBag", 1, "isSelfNeedBigView[" + paramString + "], 打开摄像头，设置为大画面");
        return true;
      }
    }
    return false;
  }
  
  public static Bitmap e(String paramString, boolean paramBoolean)
  {
    Object localObject1 = getResPath();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    do
    {
      for (;;)
      {
        return null;
        localObject1 = (String)localObject1 + paramString;
        try
        {
          Object localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inPurgeable = true;
          ((BitmapFactory.Options)localObject2).inInputShareable = true;
          ((BitmapFactory.Options)localObject2).inSampleSize = 1;
          ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
          ((BitmapFactory.Options)localObject2).inDither = paramBoolean;
          localObject2 = BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
          return localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AVRedBag", 2, "getGameResBitmap sample1 OOM|url:" + paramString);
          }
          try
          {
            BitmapFactory.Options localOptions = new BitmapFactory.Options();
            localOptions.inSampleSize = 4;
            localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
            localObject1 = BitmapFactory.decodeFile((String)localObject1, localOptions);
            return localObject1;
          }
          catch (OutOfMemoryError localOutOfMemoryError1) {}
          if (QLog.isColorLevel())
          {
            QLog.w("AVRedBag", 2, "getGameResBitmap sample4 OOM|url:" + paramString);
            return null;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.w("AVRedBag", 2, "getGameResBitmap Exception:" + paramString.toString() + ",filePath:" + localOutOfMemoryError1);
    return null;
  }
  
  public static String getResPath()
  {
    return Sk;
  }
  
  public static String ho()
  {
    return getResPath() + "qav_redpacket_guide.mp4";
  }
  
  public static Bitmap i(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = paramInt1;
    if (paramInt2 >= 0) {
      localOptions.inTargetDensity = paramInt2;
    }
    localOptions.inScaled = true;
    Bitmap localBitmap = aqcu.decodeFile(paramString, localOptions);
    if (localBitmap == null) {
      QLog.w("AVRedBag", 1, "decodeFileWithxhdpi, 加载失败, path[" + paramString + "]");
    }
    while (!AudioHelper.isDev()) {
      return localBitmap;
    }
    QLog.w("AVRedBag", 1, "decodeFileWithxhdpi, bitmap[" + localBitmap.getWidth() + ", " + localBitmap.getHeight() + "], Density[" + localBitmap.getDensity() + "], path[" + paramString + "], _density[" + paramInt1 + "], _inTargetDensity[" + paramInt2 + "], outWidth[" + localOptions.outWidth + "], outHeight[" + localOptions.outHeight + "], inDensity[" + localOptions.inDensity + "], inSampleSize[" + localOptions.inSampleSize + "], inScreenDensity[" + localOptions.inScreenDensity + "], inTargetDensity[" + localOptions.inTargetDensity + "], bitmapSize[" + localBitmap.getWidth() + ", " + localBitmap.getHeight() + "]");
    return localBitmap;
  }
  
  public static boolean isDeviceSupport()
  {
    if (aAd != -1) {
      return aAd == 1;
    }
    aAd = 0;
    if ((!iow.k(4, 1800000L)) && (!iow.k(8, 1400000L))) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("AVRedBag", 1, "isDeviceSupport, sIsSupportRedbag[" + aAd + "]");
      }
      if (aAd == 1) {
        break;
      }
      return false;
      ioj localioj = ioj.a();
      if ((localioj != null) && (!localioj.uD()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVRedBag", 2, "isSupportAVRedbag false");
        }
      }
      else {
        aAd = 1;
      }
    }
  }
  
  public static boolean j(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = paramVideoAppInterface.b().b();
    if (paramVideoAppInterface != null) {
      return paramVideoAppInterface.PY;
    }
    return false;
  }
  
  public static boolean k(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = jll.a(paramVideoAppInterface).getBoolean("qav_userguide_for_recever", true);
    if (QLog.isColorLevel()) {
      QLog.w("AVRedBag", 2, "isShowUserGuideForReceiver, reslut=" + bool);
    }
    return bool;
  }
  
  public static boolean l(VideoAppInterface paramVideoAppInterface)
  {
    return a(paramVideoAppInterface).xt();
  }
  
  public static void nC(int paramInt)
  {
    QLog.w("AVRedBag", 1, "setDensityDpi, dpi[" + aAe + "->" + paramInt + "]");
    aAe = paramInt;
  }
  
  public static void s(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = jll.a(paramVideoAppInterface).edit();
    paramVideoAppInterface.putBoolean("qav_userguide_for_recever", false);
    paramVideoAppInterface.commit();
  }
  
  public static void setResPath(String paramString)
  {
    Sk = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jik
 * JD-Core Version:    0.7.0.1
 */