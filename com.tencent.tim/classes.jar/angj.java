import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class angj
  implements angp.a
{
  private static String TAG = "ShortVideoResDownload_";
  private static AtomicInteger bN = new AtomicInteger(0);
  private static ConcurrentHashMap<Integer, angj> ip = new ConcurrentHashMap(5);
  private angj.a a;
  boolean cFs;
  public boolean cFt;
  private QQAppInterface mApp;
  public int sessionID;
  
  private angj(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.mApp = paramQQAppInterface;
    this.sessionID = bN.getAndIncrement();
    TAG += this.sessionID;
    this.a = new angj.a(TAG, this);
    this.cFs = paramBoolean;
  }
  
  private static void a(angj paramangj)
  {
    if (paramangj != null) {
      ip.remove(Integer.valueOf(paramangj.sessionID));
    }
  }
  
  private void a(@Nullable angp.b paramb)
  {
    axiy.i(TAG, "[startDownload215ConfigWithoutLoginInternal] - BEGIN -");
    ShortVideoResourceManager.b(this.mApp, new angl(this, paramb));
    axiy.i(TAG, "[startDownload215ConfigWithoutLoginInternal] - END -");
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, @Nullable angp.b paramb)
  {
    axiy.i(TAG, "[startDownload215ConfigWithoutLogin] - BEGIN -");
    boolean bool = VideoEnvironment.p(paramQQAppInterface);
    if (!bool)
    {
      ip.clear();
      if (paramb != null) {
        paramb.jy(-1, -6);
      }
      axiy.i(TAG, "[startDownload215ConfigWithoutLogin] - END -, supportShortVideo=" + bool);
      return;
    }
    if (ip.size() >= 3)
    {
      if (paramb != null) {
        paramb.jy(-1, -1);
      }
      axiy.i(TAG, "[startDownload215ConfigWithoutLogin] - END -, reach to max session size=" + ip.size());
      return;
    }
    paramQQAppInterface = new angj(paramQQAppInterface, true);
    paramQQAppInterface.cFt = false;
    ip.put(Integer.valueOf(paramQQAppInterface.sessionID), paramQQAppInterface);
    paramQQAppInterface.a(paramb);
    axiy.i(TAG, "[startDownload215ConfigWithoutLogin] - END -");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (!VideoEnvironment.p(paramQQAppInterface))
        {
          ip.clear();
          paramBoolean1 = bool;
          return paramBoolean1;
        }
        if (ip.size() >= 3)
        {
          VideoEnvironment.k("ShortVideoResDownload", "reach to max session size=" + ip.size(), null);
          paramBoolean1 = bool;
          continue;
        }
        paramQQAppInterface = new angj(paramQQAppInterface, paramBoolean1);
      }
      finally {}
      paramQQAppInterface.cFt = paramBoolean2;
      ip.put(Integer.valueOf(paramQQAppInterface.sessionID), paramQQAppInterface);
      bool = paramQQAppInterface.awG();
      if (!bool) {
        ip.remove(Integer.valueOf(paramQQAppInterface.sessionID));
      }
      paramBoolean1 = bool;
      if (paramBoolean2)
      {
        axce.a().a(axcd.d, null, false);
        paramBoolean1 = bool;
      }
    }
  }
  
  private boolean awG()
  {
    boolean bool = aqiw.isNetworkAvailable(null);
    if (bool)
    {
      VideoEnvironment.k(TAG, acfp.m(2131714527), null);
      ShortVideoResourceManager.b(this.mApp, this);
      return bool;
    }
    VideoEnvironment.k(TAG, acfp.m(2131714466), null);
    return bool;
  }
  
  private boolean awH()
  {
    QLog.d(TAG, 1, "startDownloadConfigNoLogin");
    boolean bool = aqiw.isNetworkAvailable(null);
    if (bool)
    {
      VideoEnvironment.k(TAG, acfp.m(2131714527), null);
      ShortVideoResourceManager.b(this.mApp, new angk(this));
      return bool;
    }
    VideoEnvironment.k(TAG, acfp.m(2131714466), null);
    return bool;
  }
  
  public static boolean bB(QQAppInterface paramQQAppInterface)
  {
    return g(paramQQAppInterface, true);
  }
  
  public static boolean bC(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    if (!VideoEnvironment.p(paramQQAppInterface)) {
      ip.clear();
    }
    boolean bool2;
    do
    {
      return bool1;
      if (ip.size() >= 3)
      {
        VideoEnvironment.k("startDownloadResourceNoLogin", "reach to max session size=" + ip.size(), null);
        return false;
      }
      paramQQAppInterface = new angj(paramQQAppInterface, true);
      paramQQAppInterface.cFt = false;
      ip.put(Integer.valueOf(paramQQAppInterface.sessionID), paramQQAppInterface);
      bool2 = paramQQAppInterface.awH();
      bool1 = bool2;
    } while (bool2);
    ip.remove(Integer.valueOf(paramQQAppInterface.sessionID));
    return bool2;
  }
  
  public static void destory()
  {
    if (ip != null) {
      ip.clear();
    }
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    try
    {
      paramBoolean = a(paramQQAppInterface, paramBoolean, false);
      return paramBoolean;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k(TAG, "onConfigResult | result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.k(TAG, "onConfigResult| uncompress config error=" + paramInt2, null);
        a(this);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.mApp, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.k(TAG, "onConfigResult| check config success...", null);
        this.a.cFu = false;
        ShortVideoResourceManager.a(this.mApp, localArrayList, this.a);
        VideoEnvironment.k(TAG, "onConfigResult| mDownloadFilterSo=false", null);
        if (this.cFs)
        {
          if (ankq.aB(VideoEnvironment.getContext()) == 0) {
            break label235;
          }
          ShortVideoResourceManager.b(this.mApp, localArrayList, this.a);
          this.a.cFv = false;
        }
        for (;;)
        {
          if (ankq.ayb())
          {
            this.a.cFw = false;
            ShortVideoResourceManager.c(this.mApp, localArrayList, this.a);
          }
          if (ankq.ayd())
          {
            this.a.cFy = false;
            ShortVideoResourceManager.d(this.mApp, localArrayList, this.a);
          }
          this.a.dPn();
          return;
          label235:
          VideoEnvironment.k(TAG, "onConfigResult| getFilterSoState != 2", null);
        }
      }
      VideoEnvironment.k(TAG, "onConfigResult| check config error=" + paramInt1, null);
      a(this);
      return;
    }
    VideoEnvironment.k(TAG, "onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
    a(this);
  }
  
  static class a
    implements ShortVideoResourceManager.c
  {
    private String TAG;
    angj b;
    boolean cFu = true;
    boolean cFv = true;
    boolean cFw = true;
    boolean cFx = true;
    boolean cFy = true;
    
    public a(String paramString, angj paramangj)
    {
      this.TAG = paramString;
      this.b = paramangj;
    }
    
    public void aFW()
    {
      VideoEnvironment.k(this.TAG, "onNetWorkNone...", null);
    }
    
    public void dPn()
    {
      if ((this.cFu) && (this.cFv) && (this.cFw) && (this.cFy)) {
        angj.b(this.b);
      }
    }
    
    public void f(String paramString, long paramLong1, long paramLong2)
    {
      int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      VideoEnvironment.k(this.TAG, "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
    }
    
    public void o(String paramString1, int paramInt, String paramString2)
    {
      VideoEnvironment.k(this.TAG, "onDownloadFinish| name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      if (paramString1.startsWith("new_qq_android_native_short_video_")) {
        this.cFu = true;
      }
      for (;;)
      {
        dPn();
        return;
        if (paramString1.startsWith("new_qq_android_native_short_filter_"))
        {
          this.cFv = true;
          paramString1 = new Intent();
          paramString1.setAction("new_qq_android_native_short_filter_");
          paramString1.setPackage(BaseApplicationImpl.getContext().getPackageName());
          BaseApplicationImpl.getContext().sendBroadcast(paramString1);
        }
        else if (paramString1.startsWith("new_qq_android_native_art_filter_"))
        {
          this.cFw = true;
        }
        else if (paramString1.startsWith("new_qq_android_native_portrait_filter_"))
        {
          this.cFx = true;
        }
        else if (paramString1.startsWith("new_qq_android_native_object_tracking_"))
        {
          this.cFy = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angj
 * JD-Core Version:    0.7.0.1
 */