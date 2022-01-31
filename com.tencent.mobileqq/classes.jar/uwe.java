import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class uwe
  implements urr<vfk, vfm>
{
  uwe(uwd paramuwd) {}
  
  public void a(@NonNull vfk paramvfk, @Nullable vfm paramvfm, @NonNull ErrorMessage paramErrorMessage)
  {
    paramvfk = paramvfk.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvfk.hasNext())
    {
      localObject = (String)paramvfk.next();
      uwd.a(this.a).remove(localObject);
    }
    paramvfk = new uwf();
    paramvfk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramvfm == null))
    {
      wxe.d("Q.qqstory:TagManager", "request fail for get tag request");
      umc.a().dispatch(paramvfk);
      return;
    }
    paramErrorMessage = paramvfk.jdField_a_of_type_JavaUtilMap;
    Object localObject = (uwd)uwa.a(27);
    paramvfm = paramvfm.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvfm.hasNext())
    {
      vfl localvfl = (vfl)paramvfm.next();
      ((uwd)localObject).a(localvfl.jdField_a_of_type_JavaLangString, localvfl.jdField_a_of_type_JavaUtilList);
      paramErrorMessage.put(localvfl.jdField_a_of_type_JavaLangString, localvfl);
      wxe.a("Q.qqstory:TagManager", "save feedId :%s , %s", localvfl.jdField_a_of_type_JavaLangString, localvfl.jdField_a_of_type_JavaUtilList);
    }
    umc.a().dispatch(paramvfk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwe
 * JD-Core Version:    0.7.0.1
 */