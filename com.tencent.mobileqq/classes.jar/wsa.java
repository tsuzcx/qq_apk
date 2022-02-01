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

public class wsa
  extends wpw
  implements wfk<wtz, wvk>
{
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public List<String> a;
  private final boolean jdField_a_of_type_Boolean;
  
  public wsa(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public wsa(List<String> paramList, boolean paramBoolean)
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
  
  public void a(@NonNull wtz paramwtz, @Nullable wvk paramwvk, @NonNull ErrorMessage paramErrorMessage)
  {
    wsb localwsb = new wsb();
    if ((paramwvk == null) || (paramErrorMessage.isFail()))
    {
      c();
      localwsb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      wad.a().dispatch(localwsb);
      paramwtz = paramwtz.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramwtz.hasNext())
    {
      paramwvk = (String)paramwtz.next();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramwvk);
      continue;
      paramwtz = (wjp)wjs.a(5);
      if (paramwvk.jdField_a_of_type_JavaUtilList != null)
      {
        paramErrorMessage = paramwvk.jdField_a_of_type_JavaUtilList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramwvk.jdField_a_of_type_JavaUtilList = paramwtz.a(paramwvk.jdField_a_of_type_JavaUtilList);
      localwsb.jdField_a_of_type_JavaUtilList = paramwvk.jdField_a_of_type_JavaUtilList;
      ((wan)wjs.a(28)).a(paramwvk.b);
      wad.a().dispatch(localwsb);
      b();
    }
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsa
 * JD-Core Version:    0.7.0.1
 */