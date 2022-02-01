import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.downloadnew.DownloaderGetCodeClient.1;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class arzg
{
  private static volatile arzg b;
  private EIPCResultCallback g = new arzh(this);
  private ConcurrentHashMap<String, List<aryo>> jo = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> jp = new ConcurrentHashMap();
  private Map<String, Boolean> oP = new ConcurrentHashMap();
  
  public static arzg a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new arzg();
      }
      return b;
    }
    finally {}
  }
  
  private void a(String paramString, aryo paramaryo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramaryo == null)) {}
    List localList1;
    do
    {
      return;
      List localList2 = (List)this.jo.get(paramString);
      localList1 = localList2;
      if (localList2 == null) {
        localList1 = Collections.synchronizedList(new ArrayList());
      }
    } while (localList1.contains(paramaryo));
    localList1.add(paramaryo);
    this.jo.put(paramString, localList1);
  }
  
  private String u(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  public void a(String paramString, int paramInt, aryo paramaryo)
  {
    a(u(paramString, paramInt), paramaryo);
    paramaryo = new Bundle();
    paramaryo.putString("PackageName", paramString);
    paramaryo.putInt("VersionCode", paramInt);
    arwt.d("DownloaderGetCodeClient", paramString + "_" + paramInt + " begin getApkCode ......");
    this.oP.put(u(paramString, paramInt), Boolean.valueOf(true));
    QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", paramaryo, this.g);
    ThreadManager.getSubThreadHandler().postDelayed(new DownloaderGetCodeClient.1(this, paramString, paramInt, paramaryo), 3000L);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, aryo paramaryo)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.jp.put(u(paramString2, paramInt), paramString1);
    }
    a(paramString2, paramInt, paramaryo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzg
 * JD-Core Version:    0.7.0.1
 */