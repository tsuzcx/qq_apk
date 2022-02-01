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

public class wwa
  extends wvq
  implements wld
{
  public static ConcurrentHashMap<String, Long> a;
  public List<String> a;
  public yij a;
  private final boolean a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public wwa(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Yij = ((yij)wpm.a(11));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public wwa(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Yij = ((yij)wpm.a(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int k = (int)Math.ceil(j / 5.0D);
    int i = 0;
    while (i < k)
    {
      new wwa(paramList.subList(i * 5, Math.min((i + 1) * 5, j))).a();
      i += 1;
    }
  }
  
  private void b(List<wqp> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wqp localwqp = (wqp)paramList.next();
      FeedItem localFeedItem = this.jdField_a_of_type_Yij.a(localwqp.a);
      if (localFeedItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localwqp.a });
        }
      }
      else
      {
        localFeedItem.convertFromFeedFeature(localwqp);
        localArrayList.add(localFeedItem);
      }
    }
    this.jdField_a_of_type_Yij.a(localArrayList);
  }
  
  public void a()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public void a(@NonNull wlf paramwlf, @Nullable wla paramwla, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramwlf instanceof wyv)) && ((paramwla instanceof xas)))
    {
      paramwlf = (xas)paramwla;
      paramwla = new wwb();
      paramwla.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramwlf.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((wqp)paramwlf.jdField_a_of_type_JavaUtilList.get(0)).a });
        }
        b(paramwlf.jdField_a_of_type_JavaUtilList);
        paramwla.jdField_a_of_type_JavaUtilList = paramwlf.jdField_a_of_type_JavaUtilList;
        wfo.a().dispatch(paramwla);
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
        wfo.a().dispatch(paramwla);
        c();
        return;
      } while ((!(paramwlf instanceof wyj)) || (!(paramwla instanceof wyk)));
      paramwlf = (wyk)paramwla;
      if (paramErrorMessage.isSuccess())
      {
        paramwla = new ArrayList(paramwlf.jdField_a_of_type_JavaUtilList.size());
        paramwlf = paramwlf.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwlf.hasNext()) {
          paramwla.add(((yjy)paramwlf.next()).a());
        }
        if (!paramwla.isEmpty())
        {
          this.jdField_a_of_type_Yij.a(paramwla);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramwla.get(0)).feedId, ". request FeedFeature." });
          }
          paramwlf = new wyv();
          paramwlf.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          wlb.a().a(paramwlf, this);
          return;
        }
      }
    } while (this.b.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.b.get(0) });
    }
    paramwlf = new wyv();
    paramwlf.jdField_a_of_type_JavaUtilList = this.b;
    wlb.a().a(paramwlf, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwa
 * JD-Core Version:    0.7.0.1
 */