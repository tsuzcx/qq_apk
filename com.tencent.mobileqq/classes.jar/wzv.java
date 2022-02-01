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

public class wzv
  extends wzl
  implements woy
{
  public static ConcurrentHashMap<String, Long> a;
  public List<String> a;
  public yme a;
  private final boolean a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public wzv(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Yme = ((yme)wth.a(11));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public wzv(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Yme = ((yme)wth.a(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int k = (int)Math.ceil(j / 5.0D);
    int i = 0;
    while (i < k)
    {
      new wzv(paramList.subList(i * 5, Math.min((i + 1) * 5, j))).a();
      i += 1;
    }
  }
  
  private void b(List<wuk> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wuk localwuk = (wuk)paramList.next();
      FeedItem localFeedItem = this.jdField_a_of_type_Yme.a(localwuk.a);
      if (localFeedItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localwuk.a });
        }
      }
      else
      {
        localFeedItem.convertFromFeedFeature(localwuk);
        localArrayList.add(localFeedItem);
      }
    }
    this.jdField_a_of_type_Yme.a(localArrayList);
  }
  
  public void a()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public void a(@NonNull wpa paramwpa, @Nullable wov paramwov, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramwpa instanceof xcq)) && ((paramwov instanceof xen)))
    {
      paramwpa = (xen)paramwov;
      paramwov = new wzw();
      paramwov.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramwpa.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((wuk)paramwpa.jdField_a_of_type_JavaUtilList.get(0)).a });
        }
        b(paramwpa.jdField_a_of_type_JavaUtilList);
        paramwov.jdField_a_of_type_JavaUtilList = paramwpa.jdField_a_of_type_JavaUtilList;
        wjj.a().dispatch(paramwov);
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
        wjj.a().dispatch(paramwov);
        c();
        return;
      } while ((!(paramwpa instanceof xce)) || (!(paramwov instanceof xcf)));
      paramwpa = (xcf)paramwov;
      if (paramErrorMessage.isSuccess())
      {
        paramwov = new ArrayList(paramwpa.jdField_a_of_type_JavaUtilList.size());
        paramwpa = paramwpa.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwpa.hasNext()) {
          paramwov.add(((ynt)paramwpa.next()).a());
        }
        if (!paramwov.isEmpty())
        {
          this.jdField_a_of_type_Yme.a(paramwov);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramwov.get(0)).feedId, ". request FeedFeature." });
          }
          paramwpa = new xcq();
          paramwpa.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          wow.a().a(paramwpa, this);
          return;
        }
      }
    } while (this.b.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.b.get(0) });
    }
    paramwpa = new xcq();
    paramwpa.jdField_a_of_type_JavaUtilList = this.b;
    wow.a().a(paramwpa, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzv
 * JD-Core Version:    0.7.0.1
 */