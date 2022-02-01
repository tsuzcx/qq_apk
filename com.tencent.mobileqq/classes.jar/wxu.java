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

public class wxu
  extends wvq
  implements wld<wzt, xbe>
{
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public List<String> a;
  private final boolean jdField_a_of_type_Boolean;
  
  public wxu(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public wxu(List<String> paramList, boolean paramBoolean)
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
  
  public void a(@NonNull wzt paramwzt, @Nullable xbe paramxbe, @NonNull ErrorMessage paramErrorMessage)
  {
    wxv localwxv = new wxv();
    if ((paramxbe == null) || (paramErrorMessage.isFail()))
    {
      c();
      localwxv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      wfo.a().dispatch(localwxv);
      paramwzt = paramwzt.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramwzt.hasNext())
    {
      paramxbe = (String)paramwzt.next();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramxbe);
      continue;
      paramwzt = (wpj)wpm.a(5);
      if (paramxbe.jdField_a_of_type_JavaUtilList != null)
      {
        paramErrorMessage = paramxbe.jdField_a_of_type_JavaUtilList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramxbe.jdField_a_of_type_JavaUtilList = paramwzt.a(paramxbe.jdField_a_of_type_JavaUtilList);
      localwxv.jdField_a_of_type_JavaUtilList = paramxbe.jdField_a_of_type_JavaUtilList;
      ((wfy)wpm.a(28)).a(paramxbe.b);
      wfo.a().dispatch(localwxv);
      b();
    }
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxu
 * JD-Core Version:    0.7.0.1
 */