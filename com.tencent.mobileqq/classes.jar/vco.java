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

public class vco
  extends vce
  implements urr
{
  public static ConcurrentHashMap<String, Long> a;
  public List<String> a;
  public woy a;
  private final boolean a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public vco(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Woy = ((woy)uwa.a(11));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public vco(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Woy = ((woy)uwa.a(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int k = (int)Math.ceil(j / 5.0D);
    int i = 0;
    while (i < k)
    {
      new vco(paramList.subList(i * 5, Math.min((i + 1) * 5, j))).a();
      i += 1;
    }
  }
  
  private void b(List<uxd> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uxd localuxd = (uxd)paramList.next();
      FeedItem localFeedItem = this.jdField_a_of_type_Woy.a(localuxd.a);
      if (localFeedItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localuxd.a });
        }
      }
      else
      {
        localFeedItem.convertFromFeedFeature(localuxd);
        localArrayList.add(localFeedItem);
      }
    }
    this.jdField_a_of_type_Woy.a(localArrayList);
  }
  
  public void a()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public void a(@NonNull urt paramurt, @Nullable uro paramuro, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramurt instanceof vfj)) && ((paramuro instanceof vhg)))
    {
      paramurt = (vhg)paramuro;
      paramuro = new vcp();
      paramuro.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramurt.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((uxd)paramurt.jdField_a_of_type_JavaUtilList.get(0)).a });
        }
        b(paramurt.jdField_a_of_type_JavaUtilList);
        paramuro.jdField_a_of_type_JavaUtilList = paramurt.jdField_a_of_type_JavaUtilList;
        umc.a().dispatch(paramuro);
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
        umc.a().dispatch(paramuro);
        c();
        return;
      } while ((!(paramurt instanceof vex)) || (!(paramuro instanceof vey)));
      paramurt = (vey)paramuro;
      if (paramErrorMessage.isSuccess())
      {
        paramuro = new ArrayList(paramurt.jdField_a_of_type_JavaUtilList.size());
        paramurt = paramurt.jdField_a_of_type_JavaUtilList.iterator();
        while (paramurt.hasNext()) {
          paramuro.add(((wqn)paramurt.next()).a());
        }
        if (!paramuro.isEmpty())
        {
          this.jdField_a_of_type_Woy.a(paramuro);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramuro.get(0)).feedId, ". request FeedFeature." });
          }
          paramurt = new vfj();
          paramurt.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          urp.a().a(paramurt, this);
          return;
        }
      }
    } while (this.b.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.b.get(0) });
    }
    paramurt = new vfj();
    paramurt.jdField_a_of_type_JavaUtilList = this.b;
    urp.a().a(paramurt, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vco
 * JD-Core Version:    0.7.0.1
 */