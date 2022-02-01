package com.tencent.mobileqq.utils.quic;

import acfp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import angp.a;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuicResDownload
  implements angp.a
{
  private static final String DEFAULT_QUIC_FLL_PATH = Environment.getDataDirectory() + "/data/" + BaseApplicationImpl.sApplication.getBaseContext().getPackageName() + "/app_lib/quic/";
  public static boolean cVt;
  private QQAppInterface mApp;
  
  public QuicResDownload(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public static String Cr()
  {
    return DEFAULT_QUIC_FLL_PATH;
  }
  
  public static String Cs()
  {
    return DEFAULT_QUIC_FLL_PATH + "backup" + File.separator;
  }
  
  public static boolean as(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("quic_res_config", 4).edit();
    localEditor.putString("quic_res_load_path", paramString).putInt("quic_res_version", paramInt);
    return localEditor.commit();
  }
  
  private boolean awG()
  {
    boolean bool = aqiw.isWifiConnected(null);
    if (bool)
    {
      VideoEnvironment.k("QuicResDownload", "QUIC配置下载中...", null);
      ShortVideoResourceManager.b(this.mApp, this);
      return bool;
    }
    VideoEnvironment.k("QuicResDownload", acfp.m(2131712639), null);
    return bool;
  }
  
  public static String getQuicResLoadPath()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("quic_res_config", 4).getString("quic_res_load_path", DEFAULT_QUIC_FLL_PATH);
  }
  
  public static int getQuicResVersion()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("quic_res_config", 4).getInt("quic_res_version", 0);
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("QuicResDownload", "onConfigResult | result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0) {
        VideoEnvironment.k("QuicResDownload", "onConfigResult| uncompress config error=" + paramInt2, null);
      }
      for (;;)
      {
        return;
        ArrayList localArrayList = new ArrayList(1);
        paramInt1 = ShortVideoResourceManager.a(this.mApp, localArrayList);
        if (paramInt1 != 0) {
          break;
        }
        VideoEnvironment.k("QuicResDownload", "onConfigResult| check config success...", null);
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          ShortVideoResourceManager.SVConfigItem localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
          if (localSVConfigItem.name.startsWith("msf_quic_lib"))
          {
            VideoEnvironment.k("QuicResDownload", "onConfigResult| name=" + localSVConfigItem.name + " url=" + localSVConfigItem.armv7a_url, null);
            ShortVideoResourceManager.l(this.mApp, localArrayList);
          }
        }
      }
      VideoEnvironment.k("QuicResDownload", "onConfigResult| check config error=" + paramInt1, null);
      return;
    }
    VideoEnvironment.k("QuicResDownload", "onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
  }
  
  static class MyRunnable
    implements Runnable
  {
    private WeakReference<QQAppInterface> ir;
    
    public void run()
    {
      if (this.ir != null)
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)this.ir.get();
        if (localQQAppInterface != null)
        {
          VideoEnvironment.k("QuicResDownload", "start download quic res", null);
          QuicResDownload.a(new QuicResDownload(localQQAppInterface));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.quic.QuicResDownload
 * JD-Core Version:    0.7.0.1
 */