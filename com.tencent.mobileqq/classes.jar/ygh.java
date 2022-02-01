import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class ygh
  extends wvr
  implements wld<wzj, xaz>
{
  public String a;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void d()
  {
    wzj localwzj = new wzj();
    localwzj.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localwzj.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localwzj.jdField_b_of_type_Long = 0L;
    localwzj.c = 10;
    localwzj.d = 10;
    wlb.a().a(localwzj, this);
    yqp.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localwzj.toString());
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
  
  public void a(@NonNull wzj paramwzj, @Nullable xaz paramxaz, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      yqp.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    ygi localygi = new ygi(paramErrorMessage, this.jdField_c_of_type_JavaLangString);
    localygi.jdField_b_of_type_Boolean = false;
    if ((paramxaz == null) || (paramErrorMessage.isFail()))
    {
      wfo.a().dispatch(localygi);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramxaz.jdField_a_of_type_JavaLangString;
    localygi.jdField_a_of_type_JavaUtilList = paramxaz.jdField_a_of_type_JavaUtilArrayList;
    localygi.jdField_a_of_type_Int = paramxaz.b;
    localygi.jdField_a_of_type_Boolean = paramxaz.jdField_a_of_type_Boolean;
    localygi.jdField_c_of_type_Boolean = TextUtils.isEmpty(paramwzj.jdField_a_of_type_JavaLangString);
    paramxaz = paramxaz.jdField_a_of_type_JavaUtilArrayList;
    ((woz)wpm.a(19)).b(paramxaz, paramwzj.jdField_b_of_type_JavaLangString, localygi.jdField_c_of_type_Boolean);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      wfo.a().dispatch(localygi);
      yqp.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localygi);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygh
 * JD-Core Version:    0.7.0.1
 */