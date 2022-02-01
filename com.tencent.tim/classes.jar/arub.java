import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.common.NetworkState.NetworkStateListener;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class arub
  implements artz.a, NetworkState.NetworkStateListener
{
  private static arub jdField_a_of_type_Arub;
  private artz jdField_a_of_type_Artz = new artz();
  private long awA = 1800000L;
  private SparseArray<ArrayList<StatItem>> dR = new SparseArray();
  private Map<Integer, ArrayList<String>> mPostCache = new ConcurrentHashMap();
  private Handler mPostHandler;
  private SparseArray<ArrayList<StatItem>> mTimelyStatListCache = new SparseArray();
  
  private arub()
  {
    this.jdField_a_of_type_Artz.a(this);
    initHandler();
  }
  
  public static arub a()
  {
    try
    {
      if (jdField_a_of_type_Arub == null) {
        jdField_a_of_type_Arub = new arub();
      }
      arub localarub = jdField_a_of_type_Arub;
      return localarub;
    }
    finally {}
  }
  
  private void initHandler()
  {
    HandlerThread localHandlerThread = new HandlerThread("thread_report");
    localHandlerThread.start();
    this.mPostHandler = new aruc(this, localHandlerThread.getLooper());
    this.mPostHandler.sendEmptyMessage(2);
  }
  
  public void a(int paramInt, DownloadInfo paramDownloadInfo)
  {
    if (BaseApplicationImpl.sProcessId == 7) {}
    for (int i = 1; (paramDownloadInfo == null) || (i == 0); i = 0) {
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    postReport(9, l + "|" + paramDownloadInfo.appId + "|" + paramDownloadInfo.versionCode + "|" + paramDownloadInfo.packageName + "|" + paramDownloadInfo.downloadType + "|" + paramInt + "|" + paramDownloadInfo.awN + "|" + paramDownloadInfo.via);
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.mPostHandler.hasMessages(2)) {
        this.mPostHandler.sendEmptyMessage(2);
      }
    }
    while (!this.mPostHandler.hasMessages(2)) {
      return;
    }
    this.mPostHandler.removeMessages(2);
  }
  
  public void onStatReportFinish(int paramInt1, StatReportRequest paramStatReportRequest, StatReportResponse paramStatReportResponse, int paramInt2)
  {
    Log.i("selfupdeReport", "circleTest reportLog onReportFinish errorCode = " + paramInt2);
    paramStatReportRequest = (ArrayList)this.mTimelyStatListCache.get(paramInt1);
    if (paramStatReportRequest == null) {
      paramStatReportRequest = (ArrayList)this.dR.get(paramInt1);
    }
    for (int i = 1;; i = 0)
    {
      if (paramInt2 != 0)
      {
        if ((paramStatReportRequest != null) && (paramStatReportRequest.size() > 0) && (i == 0))
        {
          SparseArray localSparseArray = new SparseArray();
          Iterator localIterator = paramStatReportRequest.iterator();
          while (localIterator.hasNext())
          {
            StatItem localStatItem = (StatItem)localIterator.next();
            paramStatReportResponse = (List)localSparseArray.get(localStatItem.type);
            paramStatReportRequest = paramStatReportResponse;
            if (paramStatReportResponse == null)
            {
              paramStatReportRequest = new ArrayList();
              localSparseArray.put(localStatItem.type, paramStatReportRequest);
            }
            paramStatReportRequest.addAll(localStatItem.records);
          }
          i = localSparseArray.size();
          paramInt2 = 0;
          while (paramInt2 < i)
          {
            int j = localSparseArray.keyAt(paramInt2);
            paramStatReportResponse = (List)localSparseArray.get(j);
            paramStatReportRequest = new ArrayList();
            paramStatReportResponse = paramStatReportResponse.iterator();
            while (paramStatReportResponse.hasNext()) {
              paramStatReportRequest.add((String)paramStatReportResponse.next());
            }
            paramStatReportResponse = artu.a().bh(String.valueOf(j));
            if (paramStatReportResponse != null) {
              paramStatReportRequest.addAll(paramStatReportResponse);
            }
            artu.a().U(String.valueOf(j), paramStatReportRequest);
            paramInt2 += 1;
          }
        }
      }
      else if ((i != 0) && (paramStatReportRequest != null) && (paramStatReportRequest.size() > 0))
      {
        paramStatReportRequest = paramStatReportRequest.iterator();
        while (paramStatReportRequest.hasNext())
        {
          paramStatReportResponse = (StatItem)paramStatReportRequest.next();
          artu.a().Xd(String.valueOf(paramStatReportResponse.type));
        }
      }
      this.mTimelyStatListCache.delete(paramInt1);
      this.dR.delete(paramInt1);
      return;
    }
  }
  
  public void postReport(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (!TextUtils.isEmpty(paramString)))
    {
      ArrayList localArrayList2 = (ArrayList)this.mPostCache.get(Integer.valueOf(paramInt));
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.mPostCache.put(Integer.valueOf(paramInt), localArrayList1);
      }
      localArrayList1.add(paramString);
      this.mPostHandler.removeMessages(1);
      this.mPostHandler.sendEmptyMessageDelayed(1, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arub
 * JD-Core Version:    0.7.0.1
 */