import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.1;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.2;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.3;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class pda
  extends pcz
{
  public static String TAG = "QCircleFeedPicPreloadScroller";
  private ovg b;
  private ConcurrentHashMap<String, Boolean> bP = new ConcurrentHashMap();
  private HandlerThread mHandlerThread;
  private Handler mThreadHandler;
  
  private void cancel()
  {
    this.mThreadHandler.post(new QCircleFeedPicPreloadScroller.3(this));
  }
  
  private void i(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mThreadHandler.post(new QCircleFeedPicPreloadScroller.1(this, paramStFeed));
  }
  
  private void j(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mThreadHandler.post(new QCircleFeedPicPreloadScroller.2(this, paramStFeed));
  }
  
  private void k(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1)
    {
      Object localObject = this.b.getDataList();
      if ((localObject != null) && (((List)localObject).size() > paramInt2))
      {
        QLog.d(TAG, 4, "feeds size" + ((List)localObject).size());
        localObject = ((List)localObject).subList(paramInt1, ((List)localObject).size()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((Iterator)localObject).next();
          if (localStFeed.type.get() == 2) {
            i(localStFeed);
          } else if (localStFeed.type.get() == 3) {
            j(localStFeed);
          }
        }
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, rxy paramrxy, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((paramInt1 == 0) && (paramBoolean)) {
      k(paramBoolean, paramInt2, paramInt3);
    }
  }
  
  public void bhT()
  {
    cancel();
  }
  
  public void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramBoolean) {
      k(paramBoolean, paramInt1, paramInt2);
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getAdapter() instanceof rxn))
    {
      paramRecyclerView = ((rxn)paramRecyclerView.getAdapter()).getDataList().iterator();
      while (paramRecyclerView.hasNext())
      {
        rxq localrxq = (rxq)paramRecyclerView.next();
        if ((localrxq instanceof ovg))
        {
          this.b = ((ovg)localrxq);
          QLog.d(TAG, 4, "fetch adapter success" + this.b.hashCode());
        }
      }
      this.mHandlerThread = new HandlerThread("QCircleFeedPicPreloadScroller", -2);
      this.mHandlerThread.start();
      this.mThreadHandler = new Handler(this.mHandlerThread.getLooper());
    }
  }
  
  public void onDestroy()
  {
    cancel();
    this.bP.clear();
  }
  
  public void onPause()
  {
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pda
 * JD-Core Version:    0.7.0.1
 */