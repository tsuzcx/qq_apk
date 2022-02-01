import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.1;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.2;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.3;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.4;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.6;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.7;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;

public class vuj
  extends vui
{
  public static String a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "QCircleFeedPicPreloadScroller";
  }
  
  private void a(FeedCloudMeta.StDittoFeed paramStDittoFeed)
  {
    int i = 0;
    QQCircleDitto.StItemContainer localStItemContainer = new QQCircleDitto.StItemContainer();
    try
    {
      localStItemContainer.mergeFrom(paramStDittoFeed.dittoData.get().toByteArray());
      paramStDittoFeed = vwk.b(localStItemContainer.items.get());
      int j = Math.min(paramStDittoFeed.size(), 2);
      for (;;)
      {
        if (i < j)
        {
          boolean bool = a(paramStDittoFeed, 0, i);
          if (!bool) {}
        }
        else
        {
          return;
        }
        i += 1;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStDittoFeed)
    {
      paramStDittoFeed.printStackTrace();
      QLog.d(jdField_a_of_type_JavaLangString, 1, " error " + paramStDittoFeed.toString());
    }
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
    if (!a()) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramInt2 > paramInt1)
      {
        Object localObject = this.jdField_a_of_type_Vbl.getDataList();
        if ((localObject == null) || (((List)localObject).size() <= paramInt2)) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 4, "feeds size" + ((List)localObject).size());
        localObject = ((List)localObject).subList(paramInt1, ((List)localObject).size()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((Iterator)localObject).next();
          if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 11) {
            a(localStFeed);
          } else if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7) || (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 12) || (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 13)) {
            d(localStFeed);
          } else if (localStFeed.type.get() == 2) {
            e(localStFeed);
          } else if (localStFeed.type.get() == 3) {
            f(localStFeed);
          } else if (localStFeed.dittoFeed.dittoId.get() == 1) {
            b((FeedCloudMeta.StDittoFeed)localStFeed.dittoFeed.get());
          } else if (localStFeed.dittoFeed.dittoId.get() == 6) {
            a((FeedCloudMeta.StDittoFeed)localStFeed.dittoFeed.get());
          }
        }
      }
    }
  }
  
  private boolean a(List<QQCircleDitto.StItemInfo> paramList, int paramInt1, int paramInt2)
  {
    Pair localPair2 = vwk.b(0);
    Pair localPair3 = vwk.b(1);
    if ((((Integer)localPair2.first).intValue() == 0) || (((Integer)localPair2.second).intValue() == 0) || (((Integer)localPair3.first).intValue() == 0) || (((Integer)localPair3.second).intValue() == 0)) {
      return true;
    }
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    if (paramInt1 < 3)
    {
      String str = ((FeedCloudMeta.StImage)((QQCircleDitto.StItemInfo)paramList.get(paramInt2)).images.get().get(paramInt1)).picUrl.get();
      if (paramInt1 == 0) {}
      for (Pair localPair1 = localPair2;; localPair1 = localPair3)
      {
        i = a(i, true, str, localPair1);
        paramInt1 += 1;
        break;
      }
    }
    return false;
  }
  
  private void b(FeedCloudMeta.StDittoFeed paramStDittoFeed)
  {
    int i = 0;
    Object localObject = new QQCircleDitto.StItemContainer();
    try
    {
      ((QQCircleDitto.StItemContainer)localObject).mergeFrom(paramStDittoFeed.dittoData.get().toByteArray());
      paramStDittoFeed = vwk.a(((QQCircleDitto.StItemContainer)localObject).styleType.get());
      if (((Integer)paramStDittoFeed.first).intValue() != 0)
      {
        if (((Integer)paramStDittoFeed.second).intValue() == 0) {
          return;
        }
        localObject = vwk.a(((QQCircleDitto.StItemContainer)localObject).items.get());
        int k = Math.min(((List)localObject).size(), 2);
        int j = 0;
        while (i < k)
        {
          j = a(j, true, ((FeedCloudMeta.StImage)((QQCircleDitto.StItemInfo)((List)localObject).get(i)).images.get().get(0)).picUrl.get(), paramStDittoFeed);
          i += 1;
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStDittoFeed)
    {
      paramStDittoFeed.printStackTrace();
      QLog.d(jdField_a_of_type_JavaLangString, 1, " error " + paramStDittoFeed.toString());
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
  
  private void e(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleFeedPicPreloadScroller.4(this, paramStFeed));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleFeedPicPreloadScroller.7(this));
  }
  
  private void f(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleFeedPicPreloadScroller.6(this, paramStFeed));
  }
  
  public int a(int paramInt, boolean paramBoolean, String paramString, Pair<Integer, Integer> paramPair)
  {
    paramString = new vrd().b(true).a(paramBoolean).a(paramString).c(((Integer)paramPair.first).intValue()).b(((Integer)paramPair.second).intValue()).d(vrd.b + paramInt);
    paramPair = QCircleFeedPicLoader.a().a(paramString);
    int i = paramInt;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramPair))
    {
      QCircleFeedPicLoader.a().a(paramString, new vun(this));
      i = paramInt + 1;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramPair, Boolean.valueOf(false));
    }
    return i;
  }
  
  public void a()
  {
    f();
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
    if ((paramRecyclerView.getAdapter() instanceof aabj))
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
    f();
  }
  
  public void e()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onDestroy");
    f();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuj
 * JD-Core Version:    0.7.0.1
 */