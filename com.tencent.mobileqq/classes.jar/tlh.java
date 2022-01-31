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

public class tlh
  extends tjd
  implements syq<tng, tor>
{
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public List<String> a;
  private final boolean jdField_a_of_type_Boolean;
  
  public tlh(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public tlh(List<String> paramList, boolean paramBoolean)
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
  
  public void a(@NonNull tng paramtng, @Nullable tor paramtor, @NonNull ErrorMessage paramErrorMessage)
  {
    tli localtli = new tli();
    if ((paramtor == null) || (paramErrorMessage.isFail()))
    {
      c();
      localtli.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      stb.a().dispatch(localtli);
      paramtng = paramtng.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramtng.hasNext())
    {
      paramtor = (String)paramtng.next();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramtor);
      continue;
      paramtng = (tcw)tcz.a(5);
      if (paramtor.jdField_a_of_type_JavaUtilList != null)
      {
        paramErrorMessage = paramtor.jdField_a_of_type_JavaUtilList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramtor.jdField_a_of_type_JavaUtilList = paramtng.a(paramtor.jdField_a_of_type_JavaUtilList);
      localtli.jdField_a_of_type_JavaUtilList = paramtor.jdField_a_of_type_JavaUtilList;
      ((stl)tcz.a(28)).a(paramtor.b);
      stb.a().dispatch(localtli);
      b();
    }
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlh
 * JD-Core Version:    0.7.0.1
 */