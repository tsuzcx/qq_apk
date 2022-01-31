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

public class uyf
  extends uxv
  implements uni
{
  public static ConcurrentHashMap<String, Long> a;
  public List<String> a;
  public wkp a;
  private final boolean a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public uyf(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Wkp = ((wkp)urr.a(11));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public uyf(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Wkp = ((wkp)urr.a(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int k = (int)Math.ceil(j / 5.0D);
    int i = 0;
    while (i < k)
    {
      new uyf(paramList.subList(i * 5, Math.min((i + 1) * 5, j))).a();
      i += 1;
    }
  }
  
  private void b(List<usu> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      usu localusu = (usu)paramList.next();
      FeedItem localFeedItem = this.jdField_a_of_type_Wkp.a(localusu.a);
      if (localFeedItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localusu.a });
        }
      }
      else
      {
        localFeedItem.convertFromFeedFeature(localusu);
        localArrayList.add(localFeedItem);
      }
    }
    this.jdField_a_of_type_Wkp.a(localArrayList);
  }
  
  public void a()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public void a(@NonNull unk paramunk, @Nullable unf paramunf, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramunk instanceof vba)) && ((paramunf instanceof vcx)))
    {
      paramunk = (vcx)paramunf;
      paramunf = new uyg();
      paramunf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramunk.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((usu)paramunk.jdField_a_of_type_JavaUtilList.get(0)).a });
        }
        b(paramunk.jdField_a_of_type_JavaUtilList);
        paramunf.jdField_a_of_type_JavaUtilList = paramunk.jdField_a_of_type_JavaUtilList;
        uht.a().dispatch(paramunf);
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
        uht.a().dispatch(paramunf);
        c();
        return;
      } while ((!(paramunk instanceof vao)) || (!(paramunf instanceof vap)));
      paramunk = (vap)paramunf;
      if (paramErrorMessage.isSuccess())
      {
        paramunf = new ArrayList(paramunk.jdField_a_of_type_JavaUtilList.size());
        paramunk = paramunk.jdField_a_of_type_JavaUtilList.iterator();
        while (paramunk.hasNext()) {
          paramunf.add(((wme)paramunk.next()).a());
        }
        if (!paramunf.isEmpty())
        {
          this.jdField_a_of_type_Wkp.a(paramunf);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramunf.get(0)).feedId, ". request FeedFeature." });
          }
          paramunk = new vba();
          paramunk.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          ung.a().a(paramunk, this);
          return;
        }
      }
    } while (this.b.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.b.get(0) });
    }
    paramunk = new vba();
    paramunk.jdField_a_of_type_JavaUtilList = this.b;
    ung.a().a(paramunk, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uyf
 * JD-Core Version:    0.7.0.1
 */