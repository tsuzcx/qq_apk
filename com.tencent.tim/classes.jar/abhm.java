import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloManager.20.1;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class abhm
  extends aquy
{
  abhm(abhh paramabhh) {}
  
  public void onDoneFile(aquz paramaquz)
  {
    if ((paramaquz == null) || (this.this$0.mApp == null)) {}
    String str1;
    do
    {
      return;
      if (paramaquz.errCode != 0)
      {
        QLog.e("ApolloManager", 1, new Object[] { "preDownloadListener task error:", Integer.valueOf(paramaquz.getStatus()) });
        return;
      }
      str1 = paramaquz.currUrl;
      paramaquz = paramaquz.getParams();
    } while (paramaquz == null);
    ApolloPreDownloadData localApolloPreDownloadData = (ApolloPreDownloadData)paramaquz.getSerializable(str1);
    if (localApolloPreDownloadData == null)
    {
      QLog.e("ApolloManager", 1, "preDownloadListener res onDoneFile but preDownload data is null");
      return;
    }
    if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir)) {}
    for (paramaquz = ApolloUtil.dt(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.zipDir;; paramaquz = abxi.biG + localApolloPreDownloadData.resId + ".zip")
    {
      String str2 = ApolloUtil.dt(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.dir;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "preDownloadListener res zip done reportId:", localApolloPreDownloadData.reportId, ", url:", str1 });
      }
      ThreadManager.getSubThreadHandler().post(new ApolloManager.20.1(this, localApolloPreDownloadData, paramaquz, str2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhm
 * JD-Core Version:    0.7.0.1
 */