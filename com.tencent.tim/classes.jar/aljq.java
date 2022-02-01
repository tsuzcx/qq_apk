import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class aljq
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    for (;;)
    {
      try
      {
        aopo localaopo = (aopo)paramQQAppInterface.getManager(193);
        if (localaopo.isEnable())
        {
          int i = 2;
          String str = "qboss_splash_ad_res_png";
          if (paramInt == 2)
          {
            i = 1;
            str = "qboss_splash_ad_res_video";
            j = 10082;
            QLog.i("QSplash@QbossSplashUtil", 1, "downloadPicAGifAVideoRes request adid" + paramString1);
            HashMap localHashMap = new HashMap();
            localHashMap.put("qbossSplashresAppid", paramString1);
            m("qbossSplashrequest", localHashMap);
            localaopo.a(j, "vas", paramString2, 0, paramString2, paramString3 + ".splashtemp", i, 0, true, new aljr(paramQQAppInterface, str, paramString1, paramString3, paramInt, paramString4, paramString2));
          }
        }
        else
        {
          QLog.i("QSplash@QbossSplashUtil", 1, "ctrl.isEnable() = false");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      int j = 10081;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Collection<aljt> paramCollection)
  {
    for (;;)
    {
      aljt localaljt;
      try
      {
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext()) {
          break label156;
        }
        localaljt = (aljt)paramCollection.next();
        if (!localaljt.atI())
        {
          QLog.i("QSplash@QbossSplashDownloadManager", 1, "adEntry should not requestRes");
          continue;
        }
        switch (localaljt.mContentType)
        {
        }
      }
      finally {}
      a(paramQQAppInterface, localaljt.bWM, localaljt.mDownloadUrl, localaljt.mResPath, 0, localaljt.bWS);
      continue;
      a(paramQQAppInterface, localaljt.bWM, localaljt.mDownloadUrl, localaljt.mResPath, 2, localaljt.bWS);
      continue;
      a(paramQQAppInterface, localaljt.bWM, localaljt.mDownloadUrl, localaljt.mResPath, 1, localaljt.bWS);
      continue;
      label156:
      return;
    }
  }
  
  private static void a(String paramString1, AppInterface paramAppInterface, String paramString2)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      paramAppInterface = (aopo)paramAppInterface.getManager(193);
      if (paramAppInterface.isEnable()) {
        paramAppInterface.be(paramString1, -1L);
      }
      paramString1 = new HashMap();
      paramString1.put("qbossSplashresAppid", paramString2);
      m("qbossSplashDownloadFailed", paramString1);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void ha(String paramString1, String paramString2)
  {
    Object localObject = aljp.a(BaseApplicationImpl.getContext(), paramString1);
    paramString1 = ((SharedPreferences)localObject).edit();
    QLog.i("QSplash@QbossSplashDownloadManager", 1, "pic or gif download succ! MD5 checkok");
    boolean bool = ((SharedPreferences)localObject).getBoolean("qboss_exposure_is_low_device_limit_", false);
    QLog.i("QSplash@QbossSplashDownloadManager", 1, "isLowerDeviceLimit = " + bool);
    if (!bool)
    {
      paramString1.putBoolean("qboss_splash_ad_is_limited_" + paramString2, true);
      localObject = aljs.mx;
      if ((localObject != null) && (((HashMap)localObject).containsKey(paramString2))) {
        ((aljt)((HashMap)localObject).get(paramString2)).bPM = true;
      }
    }
    paramString1.apply();
  }
  
  public static void m(String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null) && (!TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())))
      {
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString, true, 0L, 0L, paramHashMap, null, false);
        if (QLog.isColorLevel()) {
          QLog.i("QSplash@QbossSplashDownloadManager", 2, "reportqbossSplashBeacon, tagName  " + paramString);
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static class a
    implements aolm.b
  {
    QQAppInterface app;
    String bWK;
    String downloadurl;
    String resPath;
    String tT;
    int type;
    
    public a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.app = paramQQAppInterface;
      this.bWK = paramString1;
      this.type = paramInt;
      this.downloadurl = paramString4;
      this.resPath = paramString2;
      this.tT = paramString3;
    }
    
    public void onResp(aomh paramaomh)
    {
      try
      {
        if (paramaomh.mResult == 0)
        {
          QLog.i("QSplash@QbossSplashDownloadManager", 1, "ResFile has download!");
          if (!TextUtils.isEmpty(this.resPath))
          {
            if (aljt.H(this.resPath, false))
            {
              paramaomh = new File(this.resPath);
              paramaomh.renameTo(new File(this.resPath.substring(0, this.resPath.lastIndexOf("."))));
              long l = paramaomh.length();
              paramaomh = (aopo)this.app.getManager(193);
              if (paramaomh.isEnable())
              {
                QLog.i("QSplash@QbossSplashUtil", 1, "preDownloadSuccess");
                paramaomh.be(this.downloadurl, l);
              }
              aljq.ha(this.app.getAccount(), this.bWK);
              return;
            }
            aljq.b(this.downloadurl, this.app, this.bWK);
            QLog.i("QSplash@QbossSplashUtil", 1, "ResFile check not exist");
          }
        }
        else if (paramaomh.mResult == 1)
        {
          aljq.b(this.downloadurl, this.app, this.bWK);
          QLog.i("QSplash@QbossSplashUtil", 1, "ResFile dowload faield");
        }
        return;
      }
      catch (Exception paramaomh) {}
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljq
 * JD-Core Version:    0.7.0.1
 */