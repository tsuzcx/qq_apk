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

public class wbl
  extends wbb
  implements vqp
{
  public static ConcurrentHashMap<String, Long> a;
  public List<String> a;
  public xnp a;
  private final boolean a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public wbl(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Xnp = ((xnp)vux.a(11));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public wbl(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Xnp = ((xnp)vux.a(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int k = (int)Math.ceil(j / 5.0D);
    int i = 0;
    while (i < k)
    {
      new wbl(paramList.subList(i * 5, Math.min((i + 1) * 5, j))).a();
      i += 1;
    }
  }
  
  private void b(List<vwa> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      vwa localvwa = (vwa)paramList.next();
      FeedItem localFeedItem = this.jdField_a_of_type_Xnp.a(localvwa.a);
      if (localFeedItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localvwa.a });
        }
      }
      else
      {
        localFeedItem.convertFromFeedFeature(localvwa);
        localArrayList.add(localFeedItem);
      }
    }
    this.jdField_a_of_type_Xnp.a(localArrayList);
  }
  
  public void a()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public void a(@NonNull vqr paramvqr, @Nullable vqm paramvqm, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramvqr instanceof weg)) && ((paramvqm instanceof wgd)))
    {
      paramvqr = (wgd)paramvqm;
      paramvqm = new wbm();
      paramvqm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramvqr.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((vwa)paramvqr.jdField_a_of_type_JavaUtilList.get(0)).a });
        }
        b(paramvqr.jdField_a_of_type_JavaUtilList);
        paramvqm.jdField_a_of_type_JavaUtilList = paramvqr.jdField_a_of_type_JavaUtilList;
        vli.a().dispatch(paramvqm);
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
        vli.a().dispatch(paramvqm);
        c();
        return;
      } while ((!(paramvqr instanceof wdu)) || (!(paramvqm instanceof wdv)));
      paramvqr = (wdv)paramvqm;
      if (paramErrorMessage.isSuccess())
      {
        paramvqm = new ArrayList(paramvqr.jdField_a_of_type_JavaUtilList.size());
        paramvqr = paramvqr.jdField_a_of_type_JavaUtilList.iterator();
        while (paramvqr.hasNext()) {
          paramvqm.add(((xpe)paramvqr.next()).a());
        }
        if (!paramvqm.isEmpty())
        {
          this.jdField_a_of_type_Xnp.a(paramvqm);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramvqm.get(0)).feedId, ". request FeedFeature." });
          }
          paramvqr = new weg();
          paramvqr.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          vqn.a().a(paramvqr, this);
          return;
        }
      }
    } while (this.b.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.b.get(0) });
    }
    paramvqr = new weg();
    paramvqr.jdField_a_of_type_JavaUtilList = this.b;
    vqn.a().a(paramvqr, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbl
 * JD-Core Version:    0.7.0.1
 */