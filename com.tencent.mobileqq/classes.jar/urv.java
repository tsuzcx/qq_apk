import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class urv
  implements uni<vbb, vbd>
{
  urv(uru paramuru) {}
  
  public void a(@NonNull vbb paramvbb, @Nullable vbd paramvbd, @NonNull ErrorMessage paramErrorMessage)
  {
    paramvbb = paramvbb.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvbb.hasNext())
    {
      localObject = (String)paramvbb.next();
      uru.a(this.a).remove(localObject);
    }
    paramvbb = new urw();
    paramvbb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramvbd == null))
    {
      wsv.d("Q.qqstory:TagManager", "request fail for get tag request");
      uht.a().dispatch(paramvbb);
      return;
    }
    paramErrorMessage = paramvbb.jdField_a_of_type_JavaUtilMap;
    Object localObject = (uru)urr.a(27);
    paramvbd = paramvbd.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvbd.hasNext())
    {
      vbc localvbc = (vbc)paramvbd.next();
      ((uru)localObject).a(localvbc.jdField_a_of_type_JavaLangString, localvbc.jdField_a_of_type_JavaUtilList);
      paramErrorMessage.put(localvbc.jdField_a_of_type_JavaLangString, localvbc);
      wsv.a("Q.qqstory:TagManager", "save feedId :%s , %s", localvbc.jdField_a_of_type_JavaLangString, localvbc.jdField_a_of_type_JavaUtilList);
    }
    uht.a().dispatch(paramvbb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     urv
 * JD-Core Version:    0.7.0.1
 */