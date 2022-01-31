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

public class vei
  extends vce
  implements urr<vgh, vhs>
{
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public List<String> a;
  private final boolean jdField_a_of_type_Boolean;
  
  public vei(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public vei(List<String> paramList, boolean paramBoolean)
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
  
  public void a(@NonNull vgh paramvgh, @Nullable vhs paramvhs, @NonNull ErrorMessage paramErrorMessage)
  {
    vej localvej = new vej();
    if ((paramvhs == null) || (paramErrorMessage.isFail()))
    {
      c();
      localvej.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      umc.a().dispatch(localvej);
      paramvgh = paramvgh.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramvgh.hasNext())
    {
      paramvhs = (String)paramvgh.next();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramvhs);
      continue;
      paramvgh = (uvx)uwa.a(5);
      if (paramvhs.jdField_a_of_type_JavaUtilList != null)
      {
        paramErrorMessage = paramvhs.jdField_a_of_type_JavaUtilList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramvhs.jdField_a_of_type_JavaUtilList = paramvgh.a(paramvhs.jdField_a_of_type_JavaUtilList);
      localvej.jdField_a_of_type_JavaUtilList = paramvhs.jdField_a_of_type_JavaUtilList;
      ((umm)uwa.a(28)).a(paramvhs.b);
      umc.a().dispatch(localvej);
      b();
    }
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vei
 * JD-Core Version:    0.7.0.1
 */