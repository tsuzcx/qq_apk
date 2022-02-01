import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class xln
  extends wbc
  implements vqp<weu, wgk>
{
  public String a;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void d()
  {
    weu localweu = new weu();
    localweu.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localweu.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localweu.jdField_b_of_type_Long = 0L;
    localweu.c = 10;
    localweu.d = 10;
    vqn.a().a(localweu, this);
    xvv.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localweu.toString());
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
  
  public void a(@NonNull weu paramweu, @Nullable wgk paramwgk, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      xvv.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    xlo localxlo = new xlo(paramErrorMessage, this.jdField_c_of_type_JavaLangString);
    localxlo.jdField_b_of_type_Boolean = false;
    if ((paramwgk == null) || (paramErrorMessage.isFail()))
    {
      vli.a().dispatch(localxlo);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramwgk.jdField_a_of_type_JavaLangString;
    localxlo.jdField_a_of_type_JavaUtilList = paramwgk.jdField_a_of_type_JavaUtilArrayList;
    localxlo.jdField_a_of_type_Int = paramwgk.b;
    localxlo.jdField_a_of_type_Boolean = paramwgk.jdField_a_of_type_Boolean;
    localxlo.jdField_c_of_type_Boolean = TextUtils.isEmpty(paramweu.jdField_a_of_type_JavaLangString);
    paramwgk = paramwgk.jdField_a_of_type_JavaUtilArrayList;
    ((vuk)vux.a(19)).b(paramwgk, paramweu.jdField_b_of_type_JavaLangString, localxlo.jdField_c_of_type_Boolean);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      vli.a().dispatch(localxlo);
      xvv.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localxlo);
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
 * Qualified Name:     xln
 * JD-Core Version:    0.7.0.1
 */