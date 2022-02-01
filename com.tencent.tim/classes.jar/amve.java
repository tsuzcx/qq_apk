import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider.a;
import java.util.List;

class amve
  implements RecentHistoryFileProvider.a
{
  amve(amvd paramamvd, long[] paramArrayOfLong, List paramList) {}
  
  public void a(String paramString1, List<CloudHistoryInfo> paramList, boolean paramBoolean, int paramInt, String paramString2)
  {
    if ((paramInt != 0) && (paramList.size() > 0)) {
      QLog.i("CloudRecentSearchEngine", 1, "");
    }
  }
  
  public void a(String arg1, boolean paramBoolean, long paramLong, CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    ??? = audx.a(paramCloudHistoryInfo, paramObject);
    paramCloudHistoryInfo = this.au;
    paramCloudHistoryInfo[0] -= 1L;
    if (??? != null) {
      this.Gk.add(???);
    }
    for (;;)
    {
      if (this.au[0] == 0L) {
        this.a.Gj.addAll(this.Gk);
      }
      synchronized (this.a.val$object)
      {
        this.a.val$object.notifyAll();
        return;
        atgi.a().a(paramLong, new amvf(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amve
 * JD-Core Version:    0.7.0.1
 */