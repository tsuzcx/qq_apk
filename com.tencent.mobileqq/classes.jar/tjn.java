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

public class tjn
  extends tjd
  implements syq
{
  public static ConcurrentHashMap<String, Long> a;
  public List<String> a;
  public uvx a;
  private final boolean a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public tjn(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Uvx = ((uvx)tcz.a(11));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public tjn(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Uvx = ((uvx)tcz.a(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int k = (int)Math.ceil(j / 5.0D);
    int i = 0;
    while (i < k)
    {
      new tjn(paramList.subList(i * 5, Math.min((i + 1) * 5, j))).a();
      i += 1;
    }
  }
  
  private void b(List<tec> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      tec localtec = (tec)paramList.next();
      FeedItem localFeedItem = this.jdField_a_of_type_Uvx.a(localtec.a);
      if (localFeedItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localtec.a });
        }
      }
      else
      {
        localFeedItem.convertFromFeedFeature(localtec);
        localArrayList.add(localFeedItem);
      }
    }
    this.jdField_a_of_type_Uvx.a(localArrayList);
  }
  
  public void a()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public void a(@NonNull sys paramsys, @Nullable syn paramsyn, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramsys instanceof tmi)) && ((paramsyn instanceof tof)))
    {
      paramsys = (tof)paramsyn;
      paramsyn = new tjo();
      paramsyn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramsys.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((tec)paramsys.jdField_a_of_type_JavaUtilList.get(0)).a });
        }
        b(paramsys.jdField_a_of_type_JavaUtilList);
        paramsyn.jdField_a_of_type_JavaUtilList = paramsys.jdField_a_of_type_JavaUtilList;
        stb.a().dispatch(paramsyn);
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
        stb.a().dispatch(paramsyn);
        c();
        return;
      } while ((!(paramsys instanceof tlw)) || (!(paramsyn instanceof tlx)));
      paramsys = (tlx)paramsyn;
      if (paramErrorMessage.isSuccess())
      {
        paramsyn = new ArrayList(paramsys.jdField_a_of_type_JavaUtilList.size());
        paramsys = paramsys.jdField_a_of_type_JavaUtilList.iterator();
        while (paramsys.hasNext()) {
          paramsyn.add(((uxm)paramsys.next()).a());
        }
        if (!paramsyn.isEmpty())
        {
          this.jdField_a_of_type_Uvx.a(paramsyn);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramsyn.get(0)).feedId, ". request FeedFeature." });
          }
          paramsys = new tmi();
          paramsys.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          syo.a().a(paramsys, this);
          return;
        }
      }
    } while (this.b.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.b.get(0) });
    }
    paramsys = new tmi();
    paramsys.jdField_a_of_type_JavaUtilList = this.b;
    syo.a().a(paramsys, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjn
 * JD-Core Version:    0.7.0.1
 */