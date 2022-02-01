package cooperation.liveroom;

import android.os.Bundle;
import aquz;
import aqva;
import aqvc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class LiveRoomDownloadManager
{
  private static LiveRoomDownloadManager instance;
  
  public static LiveRoomDownloadManager getInstance()
  {
    if (instance == null) {
      instance = new LiveRoomDownloadManager();
    }
    return instance;
  }
  
  public void download(List<String> paramList, Map<String, File> paramMap, boolean paramBoolean, DownloadCallback paramDownloadCallback)
  {
    aqvc localaqvc = ((aqva)((BrowserAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web")).getManager(47)).a(1);
    if (localaqvc != null)
    {
      Bundle localBundle = new Bundle();
      paramDownloadCallback = new LiveRoomDownloadManager.1(this, paramDownloadCallback);
      if (paramBoolean)
      {
        paramList = paramMap.keySet().iterator();
        while (paramList.hasNext())
        {
          Object localObject = (String)paramList.next();
          localObject = new aquz((String)localObject, (File)paramMap.get(localObject));
          ((aquz)localObject).cWs = true;
          ((aquz)localObject).cWy = false;
          localaqvc.a((aquz)localObject, paramDownloadCallback, localBundle);
        }
      }
      paramList = new aquz(paramList, paramMap, "LiveRoomDownloadManager");
      paramList.cWs = true;
      paramList.cWy = false;
      localaqvc.a(paramList, paramDownloadCallback, localBundle);
    }
  }
  
  public static abstract interface DownloadCallback
  {
    public abstract void onFailure(int paramInt, Map<String, File> paramMap);
    
    public abstract void onSuccess(int paramInt, Map<String, File> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager
 * JD-Core Version:    0.7.0.1
 */