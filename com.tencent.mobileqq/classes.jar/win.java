import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class win
  extends uxw
  implements uni<vbo, vde>
{
  public String a;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void d()
  {
    vbo localvbo = new vbo();
    localvbo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localvbo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localvbo.jdField_b_of_type_Long = 0L;
    localvbo.c = 10;
    localvbo.d = 10;
    ung.a().a(localvbo, this);
    wsv.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localvbo.toString());
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
  
  public void a(@NonNull vbo paramvbo, @Nullable vde paramvde, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      wsv.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    wio localwio = new wio(paramErrorMessage, this.jdField_c_of_type_JavaLangString);
    localwio.jdField_b_of_type_Boolean = false;
    if ((paramvde == null) || (paramErrorMessage.isFail()))
    {
      uht.a().dispatch(localwio);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramvde.jdField_a_of_type_JavaLangString;
    localwio.jdField_a_of_type_JavaUtilList = paramvde.jdField_a_of_type_JavaUtilArrayList;
    localwio.jdField_a_of_type_Int = paramvde.b;
    localwio.jdField_a_of_type_Boolean = paramvde.jdField_a_of_type_Boolean;
    localwio.jdField_c_of_type_Boolean = TextUtils.isEmpty(paramvbo.jdField_a_of_type_JavaLangString);
    paramvde = paramvde.jdField_a_of_type_JavaUtilArrayList;
    ((ure)urr.a(19)).b(paramvde, paramvbo.jdField_b_of_type_JavaLangString, localwio.jdField_c_of_type_Boolean);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      uht.a().dispatch(localwio);
      wsv.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localwio);
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
 * Qualified Name:     win
 * JD-Core Version:    0.7.0.1
 */