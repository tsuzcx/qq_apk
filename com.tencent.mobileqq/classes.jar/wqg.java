import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.1;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class wqg
  extends wpw
  implements wfk
{
  public static ConcurrentHashMap<String, Long> a;
  public List<String> a;
  public yck a;
  private final boolean a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public wqg(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public wqg(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int k = (int)Math.ceil(j / 5.0D);
    int i = 0;
    while (i < k)
    {
      new wqg(paramList.subList(i * 5, Math.min((i + 1) * 5, j))).a();
      i += 1;
    }
  }
  
  private void b(List<wkv> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wkv localwkv = (wkv)paramList.next();
      FeedItem localFeedItem = this.jdField_a_of_type_Yck.a(localwkv.a);
      if (localFeedItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localwkv.a });
        }
      }
      else
      {
        localFeedItem.convertFromFeedFeature(localwkv);
        localArrayList.add(localFeedItem);
      }
    }
    this.jdField_a_of_type_Yck.a(localArrayList);
  }
  
  public void a()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public void a(@NonNull wfm paramwfm, @Nullable wfh paramwfh, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramwfm instanceof wtb)) && ((paramwfh instanceof wuy)))
    {
      paramwfm = (wuy)paramwfh;
      paramwfh = new wqh();
      paramwfh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramwfm.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((wkv)paramwfm.jdField_a_of_type_JavaUtilList.get(0)).a });
        }
        b(paramwfm.jdField_a_of_type_JavaUtilList);
        paramwfh.jdField_a_of_type_JavaUtilList = paramwfm.jdField_a_of_type_JavaUtilList;
        wad.a().dispatch(paramwfh);
        b();
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, "save feedFeature failed.", paramErrorMessage);
        }
        wad.a().dispatch(paramwfh);
        c();
        return;
      } while ((!(paramwfm instanceof wsp)) || (!(paramwfh instanceof wsq)));
      paramwfm = (wsq)paramwfh;
      if (paramErrorMessage.isSuccess())
      {
        paramwfh = new ArrayList(paramwfm.jdField_a_of_type_JavaUtilList.size());
        paramwfm = paramwfm.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwfm.hasNext()) {
          paramwfh.add(((ydz)paramwfm.next()).a());
        }
        if (!paramwfh.isEmpty())
        {
          this.jdField_a_of_type_Yck.a(paramwfh);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramwfh.get(0)).feedId, ". request FeedFeature." });
          }
          paramwfm = new wtb();
          paramwfm.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          wfi.a().a(paramwfm, this);
          return;
        }
      }
    } while (this.b.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.b.get(0) });
    }
    paramwfm = new wtb();
    paramwfm.jdField_a_of_type_JavaUtilList = this.b;
    wfi.a().a(paramwfm, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqg
 * JD-Core Version:    0.7.0.1
 */