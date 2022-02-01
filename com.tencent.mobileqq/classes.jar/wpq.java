import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class wpq
  implements wld<wyw, wyy>
{
  wpq(wpp paramwpp) {}
  
  public void a(@NonNull wyw paramwyw, @Nullable wyy paramwyy, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwyw = paramwyw.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwyw.hasNext())
    {
      localObject = (String)paramwyw.next();
      wpp.a(this.a).remove(localObject);
    }
    paramwyw = new wpr();
    paramwyw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramwyy == null))
    {
      yqp.d("Q.qqstory:TagManager", "request fail for get tag request");
      wfo.a().dispatch(paramwyw);
      return;
    }
    paramErrorMessage = paramwyw.jdField_a_of_type_JavaUtilMap;
    Object localObject = (wpp)wpm.a(27);
    paramwyy = paramwyy.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwyy.hasNext())
    {
      wyx localwyx = (wyx)paramwyy.next();
      ((wpp)localObject).a(localwyx.jdField_a_of_type_JavaLangString, localwyx.jdField_a_of_type_JavaUtilList);
      paramErrorMessage.put(localwyx.jdField_a_of_type_JavaLangString, localwyx);
      yqp.a("Q.qqstory:TagManager", "save feedId :%s , %s", localwyx.jdField_a_of_type_JavaLangString, localwyx.jdField_a_of_type_JavaUtilList);
    }
    wfo.a().dispatch(paramwyw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpq
 * JD-Core Version:    0.7.0.1
 */