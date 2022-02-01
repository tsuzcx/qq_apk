import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class vsh
  extends vrw
{
  private static String jdField_a_of_type_JavaLangString = "QCircleFeedVideoPreloadScroller";
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private zws jdField_a_of_type_Zws;
  
  private zws a()
  {
    if (this.jdField_a_of_type_Zws == null) {
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        break label33;
      }
    }
    label33:
    for (int i = 0;; i = this.jdField_a_of_type_AndroidContentContext.hashCode())
    {
      this.jdField_a_of_type_Zws = new zws(i);
      return this.jdField_a_of_type_Zws;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if (paramInt2 > paramInt1)
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getDataList();
        if ((localObject == null) || (((List)localObject).size() <= paramInt2)) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 4, "feeds size" + ((List)localObject).size());
        localObject = ((List)localObject).subList(paramInt1, ((List)localObject).size()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((Iterator)localObject).next();
          if ((localStFeed.type.get() == 3) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localStFeed.id.get())))
          {
            paramInt1 = a().a(localStFeed.video.fileId.get(), localStFeed.video.playUrl.get(), localStFeed.video.duration.get());
            this.jdField_a_of_type_JavaUtilHashMap.put(localStFeed.id.get(), Integer.valueOf(paramInt1));
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (paramInt1 == 0) {
      a(paramBoolean, paramInt2, paramInt3);
    }
  }
  
  public void d()
  {
    super.d();
    a().a();
    a().b();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsh
 * JD-Core Version:    0.7.0.1
 */