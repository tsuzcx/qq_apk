import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

class vvx
  implements vqp<vvy, vvz>
{
  private vvx(vvv paramvvv) {}
  
  public void a(@NonNull vvy paramvvy, @Nullable vvz paramvvz, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramvvz != null) && (paramvvz.jdField_a_of_type_Int == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramvvz.jdField_a_of_type_JavaUtilList);
      xvv.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramvvz.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Boolean.valueOf(paramvvz.jdField_a_of_type_Boolean), paramvvz.jdField_a_of_type_JavaLangString });
      if ((paramvvz.jdField_a_of_type_Boolean) || (paramvvz.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        xvv.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramvvz.b) });
        this.a.a(true, paramvvz.b);
        return;
      }
      this.a.c = paramvvz.jdField_a_of_type_JavaLangString;
      this.a.c();
      return;
    }
    xvv.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvx
 * JD-Core Version:    0.7.0.1
 */