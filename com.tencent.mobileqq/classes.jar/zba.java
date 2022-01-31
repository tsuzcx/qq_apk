import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class zba
  extends DownloadListener
{
  public zba(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    try
    {
      ??? = paramDownloadTask.a().getString("path");
      String str = paramDownloadTask.a().getString("url");
      paramDownloadTask = this.a.a((String)???);
      str = MD5Utils.d(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, paramDownloadTask);
        return;
      }
      return;
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zba
 * JD-Core Version:    0.7.0.1
 */