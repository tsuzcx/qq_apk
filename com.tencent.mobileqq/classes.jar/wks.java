import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

class wks
  implements wfk<wkt, wku>
{
  private wks(wkq paramwkq) {}
  
  public void a(@NonNull wkt paramwkt, @Nullable wku paramwku, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwku != null) && (paramwku.jdField_a_of_type_Int == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramwku.jdField_a_of_type_JavaUtilList);
      ykq.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramwku.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Boolean.valueOf(paramwku.jdField_a_of_type_Boolean), paramwku.jdField_a_of_type_JavaLangString });
      if ((paramwku.jdField_a_of_type_Boolean) || (paramwku.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        ykq.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramwku.b) });
        this.a.a(true, paramwku.b);
        return;
      }
      this.a.c = paramwku.jdField_a_of_type_JavaLangString;
      this.a.c();
      return;
    }
    ykq.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wks
 * JD-Core Version:    0.7.0.1
 */