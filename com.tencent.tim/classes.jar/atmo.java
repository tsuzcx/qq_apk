import com.tencent.cloudfile.CloudFileCallback;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider.FetchRecentFileTask;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider.a;
import java.util.List;

public class atmo
  extends CloudFileCallback
{
  public atmo(RecentHistoryFileProvider.FetchRecentFileTask paramFetchRecentFileTask, int paramInt) {}
  
  public void onFetchRecentHistoryCallback(List<CloudHistoryInfo> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    super.onFetchRecentHistoryCallback(paramList, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.e("RecentHistoryFileProvider", 1, "waterchen onFetchRecentHistoryCallback. fileType[" + this.eqt + "]　errCode[" + paramInt + "] errMsg[" + paramString + "]");
    }
    if (RecentHistoryFileProvider.a(this.a.this$0) != null) {
      RecentHistoryFileProvider.a(this.a.this$0).a(RecentHistoryFileProvider.a(this.a.this$0), paramList, paramBoolean, paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmo
 * JD-Core Version:    0.7.0.1
 */