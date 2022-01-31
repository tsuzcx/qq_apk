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

public class tjq
  extends tjg
  implements syt
{
  public static ConcurrentHashMap<String, Long> a;
  public List<String> a;
  public uwa a;
  private final boolean a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public tjq(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Uwa = ((uwa)tdc.a(11));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public tjq(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Uwa = ((uwa)tdc.a(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int k = (int)Math.ceil(j / 5.0D);
    int i = 0;
    while (i < k)
    {
      new tjq(paramList.subList(i * 5, Math.min((i + 1) * 5, j))).a();
      i += 1;
    }
  }
  
  private void b(List<tef> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      tef localtef = (tef)paramList.next();
      FeedItem localFeedItem = this.jdField_a_of_type_Uwa.a(localtef.a);
      if (localFeedItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localtef.a });
        }
      }
      else
      {
        localFeedItem.convertFromFeedFeature(localtef);
        localArrayList.add(localFeedItem);
      }
    }
    this.jdField_a_of_type_Uwa.a(localArrayList);
  }
  
  public void a()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public void a(@NonNull syv paramsyv, @Nullable syq paramsyq, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramsyv instanceof tml)) && ((paramsyq instanceof toi)))
    {
      paramsyv = (toi)paramsyq;
      paramsyq = new tjr();
      paramsyq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramsyv.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((tef)paramsyv.jdField_a_of_type_JavaUtilList.get(0)).a });
        }
        b(paramsyv.jdField_a_of_type_JavaUtilList);
        paramsyq.jdField_a_of_type_JavaUtilList = paramsyv.jdField_a_of_type_JavaUtilList;
        ste.a().dispatch(paramsyq);
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
        ste.a().dispatch(paramsyq);
        c();
        return;
      } while ((!(paramsyv instanceof tlz)) || (!(paramsyq instanceof tma)));
      paramsyv = (tma)paramsyq;
      if (paramErrorMessage.isSuccess())
      {
        paramsyq = new ArrayList(paramsyv.jdField_a_of_type_JavaUtilList.size());
        paramsyv = paramsyv.jdField_a_of_type_JavaUtilList.iterator();
        while (paramsyv.hasNext()) {
          paramsyq.add(((uxp)paramsyv.next()).a());
        }
        if (!paramsyq.isEmpty())
        {
          this.jdField_a_of_type_Uwa.a(paramsyq);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramsyq.get(0)).feedId, ". request FeedFeature." });
          }
          paramsyv = new tml();
          paramsyv.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          syr.a().a(paramsyv, this);
          return;
        }
      }
    } while (this.b.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.b.get(0) });
    }
    paramsyv = new tml();
    paramsyv.jdField_a_of_type_JavaUtilList = this.b;
    syr.a().a(paramsyv, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjq
 * JD-Core Version:    0.7.0.1
 */