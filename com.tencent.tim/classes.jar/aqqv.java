import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLDrawableHandler.Adapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class aqqv
  extends QIPCModule
  implements ApngSoLoader
{
  private static aqqv a;
  public static String cwk = "action_download_apng_so";
  private CopyOnWriteArrayList<URLDrawableHandler> ar = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<Integer> callbacks = new CopyOnWriteArrayList();
  private boolean isLoaded;
  
  private aqqv(String paramString)
  {
    super(paramString);
  }
  
  private void XM(int paramInt)
  {
    callbackResult(paramInt, EIPCResult.createResult(0, null));
  }
  
  public static aqqv a()
  {
    try
    {
      if (a == null) {
        a = new aqqv("VasApngIPCModule");
      }
      aqqv localaqqv = a;
      return localaqqv;
    }
    finally {}
  }
  
  private boolean cp(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(184);
    if (paramQQAppInterface != null)
    {
      QLog.e("VasApngUtil.IPCModule", 1, "start download so");
      paramQQAppInterface.downloadItem(1004L, "libAPNG_813", "VasApngUtil.IPCModule");
      return true;
    }
    QLog.d("VasApngUtil.IPCModule", 1, "load fail no manager");
    return false;
  }
  
  public boolean Qu()
  {
    String str = aqnl.getSoDir();
    return (!TextUtils.isEmpty(str)) && (new File(str + "libAPNG_release_813.so").exists());
  }
  
  public void XL(int paramInt)
  {
    QLog.d("VasApngUtil.IPCModule", 1, "onDownloadCompleted: errCode=" + paramInt);
    String str1;
    String str2;
    if (paramInt == 0)
    {
      str1 = aqnl.getSoDir();
      str2 = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "apng.zip";
      if (aqnl.B(str2, str1, "libAPNG_release_813.so"))
      {
        QLog.d("VasApngUtil.IPCModule", 1, "unzip apng zip success");
        aF();
        VasQuickUpdateEngine.safeDeleteFile(new File(str2));
      }
    }
    for (;;)
    {
      efd();
      return;
      QLog.e("VasApngUtil.IPCModule", 1, new Object[] { "unzip error, libDir=" + str1, " zipPath=" + str2 });
      continue;
      QLog.e("VasApngUtil.IPCModule", 1, "apng download error: " + paramInt);
    }
  }
  
  public void a(URLDrawableHandler paramURLDrawableHandler, boolean paramBoolean)
  {
    if (this.isLoaded)
    {
      QLog.e("VasApngUtil.IPCModule", 1, "load by others");
      paramURLDrawableHandler.onFileDownloadSucceed(0L);
    }
    Object localObject;
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication();
      if (localObject == null)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "load fail null application");
        paramURLDrawableHandler.onFileDownloadFailed(10000);
        return;
      }
      if (aF())
      {
        QLog.e("VasApngUtil.IPCModule", 1, "load exists so success");
        paramURLDrawableHandler.onFileDownloadSucceed(0L);
        return;
      }
      if (!paramBoolean)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "second try so not exists");
        paramURLDrawableHandler.onFileDownloadFailed(10001);
        return;
      }
      if (FlatBuffersParser.yl())
      {
        QLog.e("VasApngUtil.IPCModule", 1, "isX86 can't download apng.so");
        paramURLDrawableHandler.onFileDownloadFailed(10004);
        return;
      }
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject == null)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "load fail null runtime");
        paramURLDrawableHandler.onFileDownloadFailed(10002);
        return;
      }
      if (!(localObject instanceof QQAppInterface)) {
        break;
      }
      this.ar.add(paramURLDrawableHandler);
    } while (cp((QQAppInterface)localObject));
    this.ar.remove(paramURLDrawableHandler);
    paramURLDrawableHandler.onFileDownloadFailed(10003);
    return;
    QLog.e("VasApngUtil.IPCModule", 1, "child progress callServer to load");
    QIPCClientHelper.getInstance().callServer("VasApngIPCModule", cwk, null, new aqqw(this, paramURLDrawableHandler));
  }
  
  public boolean aF()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (this.isLoaded)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("VasApngUtil.IPCModule", 2, "loadSoLib: already loaded");
            bool1 = bool2;
          }
          return bool1;
        }
        String str = aqnl.getSoDir();
        if (!TextUtils.isEmpty(str))
        {
          str = str + "libAPNG_release_813.so";
          if (new File(str).exists())
          {
            QLog.d("VasApngUtil.IPCModule", 1, "loadSoLib: libAPNG_release_813.so");
            try
            {
              System.load(str);
              this.isLoaded = true;
              QLog.d("VasApngUtil.IPCModule", 1, "libAPNG.so load success.");
              bool1 = bool2;
            }
            catch (Throwable localThrowable)
            {
              QLog.d("VasApngUtil.IPCModule", 1, "libAPNG.so load failed. :", localThrowable);
              VasQuickUpdateEngine.safeDeleteFile(new File(str));
              anot.a(null, "CliOper", "", "", "Font_Mall", "0X80073FE", 0, 0, "101", "", "", "");
              break label202;
            }
          }
          QLog.e("VasApngUtil.IPCModule", 1, "loadSoLib not exists: " + str);
        }
      }
      finally {}
      label202:
      boolean bool1 = false;
    }
  }
  
  public void download()
  {
    a(new URLDrawableHandler.Adapter(), true);
  }
  
  void efd()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ar.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (URLDrawableHandler)localIterator.next();
      a((URLDrawableHandler)localObject, false);
      localArrayList.add(localObject);
    }
    this.ar.removeAll(localArrayList);
    localArrayList = new ArrayList();
    localIterator = this.callbacks.iterator();
    while (localIterator.hasNext())
    {
      localObject = (Integer)localIterator.next();
      XM(((Integer)localObject).intValue());
      localArrayList.add(localObject);
    }
    this.callbacks.removeAll(localArrayList);
  }
  
  public boolean isLoaded()
  {
    return this.isLoaded;
  }
  
  public void load(URLDrawableHandler paramURLDrawableHandler)
  {
    a(paramURLDrawableHandler, true);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasApngUtil.IPCModule", 2, "onCall action = " + paramString);
    }
    if (cwk.equals(paramString))
    {
      this.callbacks.add(Integer.valueOf(paramInt));
      paramBundle = BaseApplicationImpl.getApplication();
      if (paramBundle == null)
      {
        paramString = null;
        if ((paramBundle == null) || (!(paramString instanceof QQAppInterface)) || (!cp((QQAppInterface)paramString))) {
          break label96;
        }
      }
    }
    label96:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return null;
        paramString = paramBundle.getRuntime();
      }
      QLog.e("VasApngUtil.IPCModule", 1, "download fail to start, application:" + paramBundle + " runtime:" + paramString);
      XM(paramInt);
      try
      {
        this.callbacks.remove(paramInt);
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "callbacks.remove error : " + paramString.getMessage());
        return null;
      }
    }
    QLog.d("VasApngUtil.IPCModule", 2, "onCall action = " + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqv
 * JD-Core Version:    0.7.0.1
 */