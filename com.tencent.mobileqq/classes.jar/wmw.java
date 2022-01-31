import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class wmw
  extends vcf
  implements urr<vfx, vhn>
{
  public String a;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void d()
  {
    vfx localvfx = new vfx();
    localvfx.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localvfx.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localvfx.jdField_b_of_type_Long = 0L;
    localvfx.c = 10;
    localvfx.d = 10;
    urp.a().a(localvfx, this);
    wxe.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localvfx.toString());
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = "";
    d();
  }
  
  public void a(@NonNull vfx paramvfx, @Nullable vhn paramvhn, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      wxe.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    wmx localwmx = new wmx(paramErrorMessage, this.jdField_c_of_type_JavaLangString);
    localwmx.jdField_b_of_type_Boolean = false;
    if ((paramvhn == null) || (paramErrorMessage.isFail()))
    {
      umc.a().dispatch(localwmx);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramvhn.jdField_a_of_type_JavaLangString;
    localwmx.jdField_a_of_type_JavaUtilList = paramvhn.jdField_a_of_type_JavaUtilArrayList;
    localwmx.jdField_a_of_type_Int = paramvhn.b;
    localwmx.jdField_a_of_type_Boolean = paramvhn.jdField_a_of_type_Boolean;
    localwmx.jdField_c_of_type_Boolean = TextUtils.isEmpty(paramvfx.jdField_a_of_type_JavaLangString);
    paramvhn = paramvhn.jdField_a_of_type_JavaUtilArrayList;
    ((uvn)uwa.a(19)).b(paramvhn, paramvfx.jdField_b_of_type_JavaLangString, localwmx.jdField_c_of_type_Boolean);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      umc.a().dispatch(localwmx);
      wxe.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localwmx);
      return;
    }
    finally {}
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmw
 * JD-Core Version:    0.7.0.1
 */