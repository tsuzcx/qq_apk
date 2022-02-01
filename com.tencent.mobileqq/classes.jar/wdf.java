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

public class wdf
  extends wbb
  implements vqp<wfe, wgp>
{
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public List<String> a;
  private final boolean jdField_a_of_type_Boolean;
  
  public wdf(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public wdf(List<String> paramList, boolean paramBoolean)
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
  
  public void a(@NonNull wfe paramwfe, @Nullable wgp paramwgp, @NonNull ErrorMessage paramErrorMessage)
  {
    wdg localwdg = new wdg();
    if ((paramwgp == null) || (paramErrorMessage.isFail()))
    {
      c();
      localwdg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      vli.a().dispatch(localwdg);
      paramwfe = paramwfe.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramwfe.hasNext())
    {
      paramwgp = (String)paramwfe.next();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramwgp);
      continue;
      paramwfe = (vuu)vux.a(5);
      if (paramwgp.jdField_a_of_type_JavaUtilList != null)
      {
        paramErrorMessage = paramwgp.jdField_a_of_type_JavaUtilList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramwgp.jdField_a_of_type_JavaUtilList = paramwfe.a(paramwgp.jdField_a_of_type_JavaUtilList);
      localwdg.jdField_a_of_type_JavaUtilList = paramwgp.jdField_a_of_type_JavaUtilList;
      ((vls)vux.a(28)).a(paramwgp.b);
      vli.a().dispatch(localwdg);
      b();
    }
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdf
 * JD-Core Version:    0.7.0.1
 */