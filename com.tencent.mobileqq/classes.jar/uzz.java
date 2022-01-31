import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class uzz
  extends uxv
  implements uni<vby, vdj>
{
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public List<String> a;
  private final boolean jdField_a_of_type_Boolean;
  
  public uzz(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public uzz(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(List<String> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!StoryVideoItem.isFakeVid(str)) {
          this.jdField_a_of_type_JavaUtilList.add(str);
        }
      }
    }
  }
  
  public void a()
  {
    Bosses.get().postLightWeightJob(new VidToBasicInfoHandler.1(this), 0);
  }
  
  public void a(@NonNull vby paramvby, @Nullable vdj paramvdj, @NonNull ErrorMessage paramErrorMessage)
  {
    vaa localvaa = new vaa();
    if ((paramvdj == null) || (paramErrorMessage.isFail()))
    {
      c();
      localvaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      uht.a().dispatch(localvaa);
      paramvby = paramvby.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramvby.hasNext())
    {
      paramvdj = (String)paramvby.next();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramvdj);
      continue;
      paramvby = (uro)urr.a(5);
      if (paramvdj.jdField_a_of_type_JavaUtilList != null)
      {
        paramErrorMessage = paramvdj.jdField_a_of_type_JavaUtilList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramvdj.jdField_a_of_type_JavaUtilList = paramvby.a(paramvdj.jdField_a_of_type_JavaUtilList);
      localvaa.jdField_a_of_type_JavaUtilList = paramvdj.jdField_a_of_type_JavaUtilList;
      ((uid)urr.a(28)).a(paramvdj.b);
      uht.a().dispatch(localvaa);
      b();
    }
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzz
 * JD-Core Version:    0.7.0.1
 */