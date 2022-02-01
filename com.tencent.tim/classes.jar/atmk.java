import android.os.Handler;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileManager.1;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileManager.2;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileManager.3;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileManager.4;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileManager.5;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider;
import com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class atmk
{
  private List<atmk.a> KE = new ArrayList();
  private List<String> KF = new ArrayList();
  RecentHistoryFileProvider.a a = new atmm(this);
  private LinkedHashMap<String, atmk.a> al = new LinkedHashMap();
  private Handler cQ;
  private QQAppInterface mAppInterface;
  
  public atmk(QQAppInterface paramQQAppInterface)
  {
    this.mAppInterface = paramQQAppInterface;
    this.cQ = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private void YQ(String paramString)
  {
    this.cQ.post(new RecentHistoryFileManager.2(this, paramString));
  }
  
  private void YR(String paramString)
  {
    this.al.remove(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("RecentHistoryFileManager", 2, "removeLoadingTask : MapLoadingTask currentSize[" + this.al.size() + "]");
    }
  }
  
  private void YS(String paramString)
  {
    if (!this.KF.remove(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.i("RecentHistoryFileManager", 2, "removeLoadingList : ListLoadTask remove task fail, taskID[" + paramString + "]");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("RecentHistoryFileManager", 2, "removeLoadingList : ListLoadTask currentSize[" + this.KF.size() + "]");
  }
  
  private void a(atmk.a parama)
  {
    if (parama == null) {}
    do
    {
      return;
      this.al.put(parama.cHr, parama);
    } while (!QLog.isColorLevel());
    QLog.i("RecentHistoryFileManager", 2, "addLoadingTask : MapLoadingTask currentSize[" + this.al.size() + "]");
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3)
  {
    atmk.a locala = new atmk.a(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3);
    this.KF.add(locala.cHr);
    this.KE.add(locala);
    if (QLog.isColorLevel()) {
      QLog.e("RecentHistoryFileManager", 1, "waterchen registe loadDB task. taskID[" + locala.cHr + "] fileType[" + paramInt1 + "] operateType[" + paramInt3 + "] hisID[" + paramLong1 + "] time[" + paramLong2 + "] seq[" + paramLong3 + "]");
    }
    return true;
  }
  
  private void b(atmk.a parama)
  {
    if (parama == null) {
      return;
    }
    parama.eud();
  }
  
  private void b(String paramString1, List<CloudHistoryInfo> paramList, boolean paramBoolean, int paramInt, String paramString2)
  {
    this.cQ.post(new RecentHistoryFileManager.4(this, paramString1, paramList, paramInt, paramString2, paramBoolean));
  }
  
  private void b(String paramString, boolean paramBoolean, long paramLong, CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    this.cQ.post(new RecentHistoryFileManager.5(this, paramString, paramLong, paramObject));
  }
  
  private void dif()
  {
    this.cQ.post(new RecentHistoryFileManager.3(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3)
  {
    this.cQ.post(new RecentHistoryFileManager.1(this, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3));
  }
  
  public class a
  {
    public List<CloudHistoryInfo> KH;
    public List<atkw> KI;
    public RecentHistoryFileProvider a;
    long ayq;
    long ayr;
    public String cHr = audx.d() + "";
    public int eqs = 0;
    public int errorCode;
    public String errorMessage;
    public int fileType;
    long fromTime;
    public boolean hasMore;
    int limit;
    public int operateType;
    
    a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3)
    {
      this.fileType = paramInt1;
      this.limit = paramInt2;
      this.operateType = paramInt3;
      this.ayq = paramLong1;
      this.fromTime = paramLong2;
      this.ayr = paramLong3;
      this.KH = new ArrayList();
      this.KI = new ArrayList();
      this.a = new RecentHistoryFileProvider(atmk.a(atmk.this), this.cHr, atmk.this.a);
    }
    
    void eud()
    {
      this.a.b(this.fileType, this.limit, this.operateType, this.ayq, this.fromTime, this.ayr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmk
 * JD-Core Version:    0.7.0.1
 */