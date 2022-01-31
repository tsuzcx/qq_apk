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

public class tlk
  extends tjg
  implements syt<tnj, tou>
{
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public List<String> a;
  private final boolean jdField_a_of_type_Boolean;
  
  public tlk(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public tlk(List<String> paramList, boolean paramBoolean)
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
  
  public void a(@NonNull tnj paramtnj, @Nullable tou paramtou, @NonNull ErrorMessage paramErrorMessage)
  {
    tll localtll = new tll();
    if ((paramtou == null) || (paramErrorMessage.isFail()))
    {
      c();
      localtll.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      ste.a().dispatch(localtll);
      paramtnj = paramtnj.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramtnj.hasNext())
    {
      paramtou = (String)paramtnj.next();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramtou);
      continue;
      paramtnj = (tcz)tdc.a(5);
      if (paramtou.jdField_a_of_type_JavaUtilList != null)
      {
        paramErrorMessage = paramtou.jdField_a_of_type_JavaUtilList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramtou.jdField_a_of_type_JavaUtilList = paramtnj.a(paramtou.jdField_a_of_type_JavaUtilList);
      localtll.jdField_a_of_type_JavaUtilList = paramtou.jdField_a_of_type_JavaUtilList;
      ((sto)tdc.a(28)).a(paramtou.b);
      ste.a().dispatch(localtll);
      b();
    }
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlk
 * JD-Core Version:    0.7.0.1
 */