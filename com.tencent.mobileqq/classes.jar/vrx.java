import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.1;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.2;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.3;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.4;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.5;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class vrx
  extends vrw
{
  public static String a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "QCircleFeedPicPreloadScroller";
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.type.get() == 2) {
      c(paramStFeed);
    }
    while (paramStFeed.type.get() != 3) {
      return;
    }
    b(paramStFeed);
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getDataList();
      if ((localObject != null) && (((List)localObject).size() > paramInt2))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "feeds size" + ((List)localObject).size());
        localObject = ((List)localObject).subList(paramInt1, ((List)localObject).size()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((Iterator)localObject).next();
          if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 11) {
            a(localStFeed);
          } else if (localStFeed.type.get() == 2) {
            d(localStFeed);
          } else if (localStFeed.type.get() == 3) {
            e(localStFeed);
          }
        }
      }
    }
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleFeedPicPreloadScroller.1(this, paramStFeed));
  }
  
  private void c(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleFeedPicPreloadScroller.2(this, paramStFeed));
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleFeedPicPreloadScroller.3(this, paramStFeed));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleFeedPicPreloadScroller.5(this));
  }
  
  private void e(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleFeedPicPreloadScroller.4(this, paramStFeed));
  }
  
  public void a()
  {
    e();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramBoolean, paramInt1, paramInt2);
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    super.a(paramRecyclerView);
    if ((paramRecyclerView.getAdapter() instanceof zxo))
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QCircleFeedPicPreloadScroller", -2);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((paramInt1 == 0) && (paramBoolean)) {
      a(paramBoolean, paramInt2, paramInt3);
    }
  }
  
  public void c()
  {
    e();
  }
  
  public void d()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onDestroy");
    e();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrx
 * JD-Core Version:    0.7.0.1
 */