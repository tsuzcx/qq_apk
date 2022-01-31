import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

class uxa
  implements urr<uxb, uxc>
{
  private uxa(uwy paramuwy) {}
  
  public void a(@NonNull uxb paramuxb, @Nullable uxc paramuxc, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramuxc != null) && (paramuxc.jdField_a_of_type_Int == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramuxc.jdField_a_of_type_JavaUtilList);
      wxe.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramuxc.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Boolean.valueOf(paramuxc.jdField_a_of_type_Boolean), paramuxc.jdField_a_of_type_JavaLangString });
      if ((paramuxc.jdField_a_of_type_Boolean) || (paramuxc.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        wxe.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramuxc.b) });
        this.a.a(true, paramuxc.b);
        return;
      }
      this.a.c = paramuxc.jdField_a_of_type_JavaLangString;
      this.a.c();
      return;
    }
    wxe.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxa
 * JD-Core Version:    0.7.0.1
 */