import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class vvb
  implements vqp<weh, wej>
{
  vvb(vva paramvva) {}
  
  public void a(@NonNull weh paramweh, @Nullable wej paramwej, @NonNull ErrorMessage paramErrorMessage)
  {
    paramweh = paramweh.jdField_a_of_type_JavaUtilList.iterator();
    while (paramweh.hasNext())
    {
      localObject = (String)paramweh.next();
      vva.a(this.a).remove(localObject);
    }
    paramweh = new vvc();
    paramweh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramwej == null))
    {
      xvv.d("Q.qqstory:TagManager", "request fail for get tag request");
      vli.a().dispatch(paramweh);
      return;
    }
    paramErrorMessage = paramweh.jdField_a_of_type_JavaUtilMap;
    Object localObject = (vva)vux.a(27);
    paramwej = paramwej.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwej.hasNext())
    {
      wei localwei = (wei)paramwej.next();
      ((vva)localObject).a(localwei.jdField_a_of_type_JavaLangString, localwei.jdField_a_of_type_JavaUtilList);
      paramErrorMessage.put(localwei.jdField_a_of_type_JavaLangString, localwei);
      xvv.a("Q.qqstory:TagManager", "save feedId :%s , %s", localwei.jdField_a_of_type_JavaLangString, localwei.jdField_a_of_type_JavaUtilList);
    }
    vli.a().dispatch(paramweh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvb
 * JD-Core Version:    0.7.0.1
 */