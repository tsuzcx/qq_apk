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

public class xbp
  extends wzl
  implements woy<xdo, xez>
{
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public List<String> a;
  private final boolean jdField_a_of_type_Boolean;
  
  public xbp(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public xbp(List<String> paramList, boolean paramBoolean)
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
  
  public void a(@NonNull xdo paramxdo, @Nullable xez paramxez, @NonNull ErrorMessage paramErrorMessage)
  {
    xbq localxbq = new xbq();
    if ((paramxez == null) || (paramErrorMessage.isFail()))
    {
      c();
      localxbq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      wjj.a().dispatch(localxbq);
      paramxdo = paramxdo.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramxdo.hasNext())
    {
      paramxez = (String)paramxdo.next();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramxez);
      continue;
      paramxdo = (wte)wth.a(5);
      if (paramxez.jdField_a_of_type_JavaUtilList != null)
      {
        paramErrorMessage = paramxez.jdField_a_of_type_JavaUtilList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramxez.jdField_a_of_type_JavaUtilList = paramxdo.a(paramxez.jdField_a_of_type_JavaUtilList);
      localxbq.jdField_a_of_type_JavaUtilList = paramxez.jdField_a_of_type_JavaUtilList;
      ((wjt)wth.a(28)).a(paramxez.b);
      wjj.a().dispatch(localxbq);
      b();
    }
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbp
 * JD-Core Version:    0.7.0.1
 */