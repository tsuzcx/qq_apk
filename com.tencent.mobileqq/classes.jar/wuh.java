import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

class wuh
  implements woy<wui, wuj>
{
  private wuh(wuf paramwuf) {}
  
  public void a(@NonNull wui paramwui, @Nullable wuj paramwuj, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwuj != null) && (paramwuj.jdField_a_of_type_Int == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramwuj.jdField_a_of_type_JavaUtilList);
      yuk.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramwuj.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Boolean.valueOf(paramwuj.jdField_a_of_type_Boolean), paramwuj.jdField_a_of_type_JavaLangString });
      if ((paramwuj.jdField_a_of_type_Boolean) || (paramwuj.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        yuk.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramwuj.b) });
        this.a.a(true, paramwuj.b);
        return;
      }
      this.a.c = paramwuj.jdField_a_of_type_JavaLangString;
      this.a.c();
      return;
    }
    yuk.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wuh
 * JD-Core Version:    0.7.0.1
 */