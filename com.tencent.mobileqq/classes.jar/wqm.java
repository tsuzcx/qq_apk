import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

class wqm
  implements wld<wqn, wqo>
{
  private wqm(wqk paramwqk) {}
  
  public void a(@NonNull wqn paramwqn, @Nullable wqo paramwqo, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwqo != null) && (paramwqo.jdField_a_of_type_Int == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramwqo.jdField_a_of_type_JavaUtilList);
      yqp.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramwqo.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Boolean.valueOf(paramwqo.jdField_a_of_type_Boolean), paramwqo.jdField_a_of_type_JavaLangString });
      if ((paramwqo.jdField_a_of_type_Boolean) || (paramwqo.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        yqp.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramwqo.b) });
        this.a.a(true, paramwqo.b);
        return;
      }
      this.a.c = paramwqo.jdField_a_of_type_JavaLangString;
      this.a.c();
      return;
    }
    yqp.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqm
 * JD-Core Version:    0.7.0.1
 */