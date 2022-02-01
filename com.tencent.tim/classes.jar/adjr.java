import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager.1;
import com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager.2;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adjr
{
  public static Handler sMainHandler = new Handler(Looper.getMainLooper());
  private static ArrayList<adjr.a> ui = new ArrayList(2);
  
  public static void a(adjr.a parama)
  {
    if (parama != null) {}
    try
    {
      if (!ui.contains(parama))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.ResDownloadManager", 2, "addDownloadCallback");
        }
        ui.add(parama);
      }
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramQQAppInterface = (afem)paramQQAppInterface.getManager(77);
            } while (paramQQAppInterface == null);
            if (!paramBoolean) {
              break;
            }
            paramQQAppInterface = (afez)paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
          } while ((paramQQAppInterface == null) || (!paramQQAppInterface.isSuccess()) || (adjs.aeI()));
          paramQQAppInterface.restoreState();
        } while (!QLog.isColorLevel());
        QLog.d("MiniRecog.ResDownloadManager", 2, "reset decode so download state");
        return;
        affb localaffb = (affb)paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
        if ((localaffb != null) && (localaffb.isSuccess()) && (!adju.aeI()))
        {
          localaffb.restoreState();
          if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.ResDownloadManager", 2, "reset detect so download state");
          }
        }
        paramQQAppInterface = (affa)paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
      } while ((paramQQAppInterface == null) || (!paramQQAppInterface.isSuccess()) || (adjt.aeI()));
      paramQQAppInterface.restoreState();
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.ResDownloadManager", 2, "reset model so download state");
  }
  
  private static boolean a(afeu paramafeu)
  {
    if (paramafeu == null) {}
    do
    {
      do
      {
        return false;
        paramafeu = paramafeu.b();
      } while (paramafeu == null);
      if ((!TextUtils.isEmpty(paramafeu.strPkgName)) && (!TextUtils.isEmpty(paramafeu.strResURL_big))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.ResDownloadManager", 2, "strPkgName is empty:" + TextUtils.isEmpty(paramafeu.strPkgName) + " strResURL_big is empty:" + TextUtils.isEmpty(paramafeu.strResURL_big) + " loadState :" + paramafeu.loadState);
    return false;
    return true;
  }
  
  public static boolean a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      paramQQAppInterface = (afem)paramQQAppInterface.getManager(77);
    } while (paramQQAppInterface == null);
    if (paramBoolean)
    {
      paramQQAppInterface = (afez)paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
      bool1 = a(paramQQAppInterface);
      paramBoolean = bool1;
      if (!bool1)
      {
        paramBoolean = bool1;
        if (paramQQAppInterface != null)
        {
          paramBoolean = bool1;
          if (paramQQAppInterface.isSuccess())
          {
            paramBoolean = bool1;
            if (adjs.aeI()) {
              paramBoolean = true;
            }
          }
        }
      }
      if (paramBoolean) {
        paramQQAppInterface.cYN();
      }
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, String.format("isMiniResConfigReady config exist [decode]=[%b]", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      return paramBoolean;
    }
    affb localaffb = (affb)paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
    boolean bool1 = a(localaffb);
    paramBoolean = bool1;
    if (!bool1)
    {
      paramBoolean = bool1;
      if (localaffb != null)
      {
        paramBoolean = bool1;
        if (localaffb.isSuccess())
        {
          paramBoolean = bool1;
          if (adju.aeI()) {
            paramBoolean = true;
          }
        }
      }
    }
    if (paramBoolean) {
      localaffb.cYN();
    }
    paramQQAppInterface = (affa)paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
    bool1 = a(paramQQAppInterface);
    if ((!bool1) && (paramQQAppInterface != null) && (paramQQAppInterface.isSuccess()) && (adjt.aeI())) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, String.format("isMiniResConfigReady config exist [detect,model]=[%b,%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) }));
      }
      if ((paramBoolean) && (bool1)) {}
      for (paramBoolean = bool2;; paramBoolean = false) {
        return paramBoolean;
      }
    }
  }
  
  public static void br(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = ui.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        adjr.a locala = (adjr.a)localObject[i];
        sMainHandler.post(new MiniResDownloadManager.2(locala, paramInt, paramBoolean));
        i += 1;
      }
    }
  }
  
  public static void clearCallback()
  {
    if (ui != null) {
      ui.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.ResDownloadManager", 2, "clearCallback");
    }
  }
  
  public static void f(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, "downloadFaceRes app is null");
      }
    }
    do
    {
      return;
      paramQQAppInterface = (afem)paramQQAppInterface.getManager(77);
    } while (paramQQAppInterface == null);
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
      paramQQAppInterface = null;
    }
    while (paramQQAppInterface != null)
    {
      paramInt = paramQQAppInterface.getVersion();
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, "initAr version=" + paramQQAppInterface.getVersion());
      }
      if ((bool) && (paramQQAppInterface.isSuccess()) && (paramInt > 1)) {
        break;
      }
      paramQQAppInterface.HL(true);
      return;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
      bool = adjs.aeI();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
      bool = adju.aeI();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
      bool = adjt.aeI();
    }
  }
  
  public static void hj(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = ui.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        adjr.a locala = (adjr.a)localObject[i];
        sMainHandler.post(new MiniResDownloadManager.1(locala, paramInt1, paramInt2));
        i += 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bq(int paramInt, boolean paramBoolean);
    
    public abstract void onProgress(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjr
 * JD-Core Version:    0.7.0.1
 */