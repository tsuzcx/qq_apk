import android.os.Bundle;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.cmgame.OnGameStartCheckListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ypb
  extends DownloadListener
{
  public ypb(CmGameStartChecker paramCmGameStartChecker) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = (CmGameStartChecker.StartCheckParam)paramDownloadTask.a().getSerializable("download_param");
    if (paramDownloadTask.a() != 3)
    {
      CmGameStartChecker.a(this.a, localStartCheckParam);
      QLog.e("apollo_cmGame_CmGameStartChecker", 1, "downLoad game res fail retCode: " + paramDownloadTask.a());
      return;
    }
    this.a.c(localStartCheckParam);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    CmGameStartChecker.StartCheckParam localStartCheckParam = (CmGameStartChecker.StartCheckParam)paramDownloadTask.a().getSerializable("download_param");
    int i = (int)paramDownloadTask.a;
    if (CmGameStartChecker.a(this.a) != null)
    {
      paramDownloadTask = (OnGameStartCheckListener)CmGameStartChecker.a(this.a).get();
      if (paramDownloadTask != null)
      {
        QLog.d("apollo_cmGame_CmGameStartChecker", 2, "gameCheckListener.onDownloadGameResProgress startCheckParam:" + localStartCheckParam);
        paramDownloadTask.onDownloadGameResProgress(localStartCheckParam, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypb
 * JD-Core Version:    0.7.0.1
 */