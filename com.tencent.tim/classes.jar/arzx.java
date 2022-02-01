import android.content.Context;
import android.os.Environment;
import com.tencent.apkupdate.ApkUpdateListener;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.ApkUpdateSDK;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.UpdateManager.1;
import com.tencent.open.downloadnew.UpdateManager.2;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class arzx
  implements ApkUpdateListener
{
  public static final String TAG = arzx.class.getName();
  protected static arzx a;
  protected ConcurrentLinkedQueue<arzx.a> listeners = new ConcurrentLinkedQueue();
  
  protected arzx()
  {
    ApkUpdateSDK.getInstance().init(aroi.a().getContext());
    ApkUpdateSDK.getInstance().addListener(this);
  }
  
  /* Error */
  public static boolean PN()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 61	arzx:a	Larzx;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localarzx	arzx
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public static arzx a()
  {
    try
    {
      if (a == null) {
        a = new arzx();
      }
      arzx localarzx = a;
      return localarzx;
    }
    finally {}
  }
  
  public void a(arzx.a parama)
  {
    try
    {
      this.listeners.add(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void b(arzx.a parama)
  {
    try
    {
      this.listeners.remove(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void checkUpdate(List<String> paramList)
  {
    arwt.i(TAG, "checkUpdate>>> list size:" + paramList.size());
    ApkUpdateSDK.getInstance().checkUpdate(paramList);
  }
  
  public void destroy()
  {
    try
    {
      ApkUpdateSDK.getInstance().removeListener(this);
      ApkUpdateSDK.getInstance().destory();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException = localException;
        arwt.d(TAG, "onDestroy>>>", localException);
      }
    }
    finally {}
  }
  
  public void i(DownloadInfo paramDownloadInfo)
  {
    String str2 = paramDownloadInfo.packageName;
    String str3 = paramDownloadInfo.filePath;
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    int i;
    for (String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + aryy.DOWNLOAD_PATH + "newApkDir";; str1 = aroi.a().getContext().getFilesDir().getAbsolutePath())
    {
      File localFile = new File(str1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      str1 = str1 + "/" + str2 + ".newGen.apk";
      arwt.i(TAG, "patchNewApk>>>>>packageName=" + str2 + ", patchPath=" + str3 + ", newApkPath=" + str1);
      i = ApkUpdateSDK.getInstance().patchNewApk(str2, str3, str1);
      if (i != 0) {
        break label422;
      }
      arwt.i(TAG, acfp.m(2131716252));
      paramDownloadInfo.filePath = str1;
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.packageName)) && (accy.ad((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.isAutoInstall = false;
      }
      if ((!"com.tencent.mobileqq".equals(paramDownloadInfo.packageName)) || (!aryy.a().isMainProcess())) {
        break label404;
      }
      paramDownloadInfo.elm = aryy.a().b(paramDownloadInfo);
      if (paramDownloadInfo.elm == 0) {
        break;
      }
      arwt.w(TAG, "updateManager patchNewApk write code fail......");
      paramDownloadInfo.setState(-2);
      aryy.a().j(paramDownloadInfo);
      aryy.a().a(paramDownloadInfo, paramDownloadInfo.elm, null);
      return;
    }
    paramDownloadInfo.setState(4);
    aryy.a().j(paramDownloadInfo);
    arwt.d(TAG, "info.path = " + paramDownloadInfo.filePath);
    aryy.a().b(4, paramDownloadInfo);
    if (paramDownloadInfo.isAutoInstall) {
      aryy.a().y(paramDownloadInfo);
    }
    arxt.X("300", paramDownloadInfo.via, paramDownloadInfo.appId, paramDownloadInfo.extraData);
    ThreadManager.getSubThreadHandler().post(new UpdateManager.1(this, str1, paramDownloadInfo));
    return;
    label404:
    ThreadManager.getSubThreadHandler().post(new UpdateManager.2(this, str1, paramDownloadInfo));
    return;
    label422:
    arwt.e(TAG, acfp.m(2131716253) + i);
    aryy.a().b(-24, paramDownloadInfo);
  }
  
  public void no(List<ApkUpdateParam> paramList)
  {
    arwt.i(TAG, "checkUpdate>>> list size:" + paramList.size());
    ApkUpdateSDK.getInstance().checkUpdateList(paramList);
  }
  
  public void onCheckUpdateFailed(String paramString)
  {
    arwt.d(TAG, "onCheckUpdateFailed>>>errMsg=" + paramString);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((arzx.a)localIterator.next()).Ui(paramString);
    }
  }
  
  public void onCheckUpdateSucceed(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        ((arzx.a)localIterator.next()).onResult(paramArrayList);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Ui(String paramString);
    
    public abstract void onResult(ArrayList<ApkUpdateDetail> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzx
 * JD-Core Version:    0.7.0.1
 */