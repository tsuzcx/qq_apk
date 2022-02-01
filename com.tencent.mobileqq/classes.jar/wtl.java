import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class wtl
  implements woy<xcr, xct>
{
  wtl(wtk paramwtk) {}
  
  public void a(@NonNull xcr paramxcr, @Nullable xct paramxct, @NonNull ErrorMessage paramErrorMessage)
  {
    paramxcr = paramxcr.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxcr.hasNext())
    {
      localObject = (String)paramxcr.next();
      wtk.a(this.a).remove(localObject);
    }
    paramxcr = new wtm();
    paramxcr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramxct == null))
    {
      yuk.d("Q.qqstory:TagManager", "request fail for get tag request");
      wjj.a().dispatch(paramxcr);
      return;
    }
    paramErrorMessage = paramxcr.jdField_a_of_type_JavaUtilMap;
    Object localObject = (wtk)wth.a(27);
    paramxct = paramxct.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxct.hasNext())
    {
      xcs localxcs = (xcs)paramxct.next();
      ((wtk)localObject).a(localxcs.jdField_a_of_type_JavaLangString, localxcs.jdField_a_of_type_JavaUtilList);
      paramErrorMessage.put(localxcs.jdField_a_of_type_JavaLangString, localxcs);
      yuk.a("Q.qqstory:TagManager", "save feedId :%s , %s", localxcs.jdField_a_of_type_JavaLangString, localxcs.jdField_a_of_type_JavaUtilList);
    }
    wjj.a().dispatch(paramxcr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtl
 * JD-Core Version:    0.7.0.1
 */