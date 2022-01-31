import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

class usr
  implements uni<uss, ust>
{
  private usr(usp paramusp) {}
  
  public void a(@NonNull uss paramuss, @Nullable ust paramust, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramust != null) && (paramust.jdField_a_of_type_Int == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramust.jdField_a_of_type_JavaUtilList);
      wsv.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramust.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Boolean.valueOf(paramust.jdField_a_of_type_Boolean), paramust.jdField_a_of_type_JavaLangString });
      if ((paramust.jdField_a_of_type_Boolean) || (paramust.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        wsv.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramust.b) });
        this.a.a(true, paramust.b);
        return;
      }
      this.a.c = paramust.jdField_a_of_type_JavaLangString;
      this.a.c();
      return;
    }
    wsv.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     usr
 * JD-Core Version:    0.7.0.1
 */