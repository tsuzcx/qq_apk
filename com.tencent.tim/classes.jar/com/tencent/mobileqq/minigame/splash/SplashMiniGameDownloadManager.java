package com.tencent.mobileqq.minigame.splash;

import android.text.TextUtils;
import aolm.b;
import aomg;
import aomh;
import aopo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jqp;

public class SplashMiniGameDownloadManager
{
  public static final int RES_TYPE_PIC = 0;
  public static final int RES_TYPE_VIDEO = 1;
  public static final String TAG = "SplashMiniGameDownloadMgr";
  
  public static void downloadRes(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    for (;;)
    {
      try
      {
        aopo localaopo = (aopo)paramQQAppInterface.getManager(193);
        if (localaopo.isEnable())
        {
          String str = "minigame_splash_png";
          if (paramInt == 1)
          {
            str = "minigame_splash_video";
            i = 10087;
            QLog.i("SplashMiniGameDownloadMgr", 1, "downloadPicAGifAVideoRes request appid" + paramString1);
            localaopo.a(i, "prd", paramString2, 0, paramString2, paramString3, 2, 0, false, new SplashMiniGameDownloadManager.1(paramQQAppInterface, str, paramString1, paramInt, paramString3, paramString2));
          }
        }
        else
        {
          QLog.i("SplashMiniGameDownloadMgr", 1, "ctrl.isEnable() = false");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      int i = 10086;
    }
  }
  
  public static class DownLoadNetEngine
    implements aolm.b
  {
    QQAppInterface app;
    String appid;
    String downloadurl;
    String resPath;
    int type;
    
    public DownLoadNetEngine(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3)
    {
      this.app = paramQQAppInterface;
      this.appid = paramString1;
      this.type = paramInt;
      this.downloadurl = paramString3;
      this.resPath = paramString2;
    }
    
    public void onResp(aomh paramaomh)
    {
      try
      {
        if (paramaomh.mResult == 0)
        {
          QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile has download!");
          if (!TextUtils.isEmpty(this.resPath))
          {
            paramaomh = new File(this.resPath);
            if (paramaomh.exists())
            {
              long l = paramaomh.length();
              aopo localaopo = (aopo)this.app.getManager(193);
              if (localaopo.isEnable())
              {
                QLog.i("SplashMiniGameDownloadMgr", 1, "preDownloadSuccess");
                localaopo.be(this.downloadurl, l);
              }
              if (this.type == 0)
              {
                jqp.b(paramaomh, paramaomh.getParent() + File.separator);
                this.resPath = (paramaomh.getParent() + File.separator + "splash.png");
              }
              SplashMiniGameUtil.downloadSuccess(this.appid, this.type, this.resPath);
              return;
            }
            QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile check not exist");
          }
        }
        else if (paramaomh.mResult == 1)
        {
          QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile dowload faield");
        }
        return;
      }
      catch (Exception paramaomh) {}
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager
 * JD-Core Version:    0.7.0.1
 */