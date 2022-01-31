import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class uhc
  extends swl
  implements slx<tad, tbt>
{
  public String a;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void d()
  {
    tad localtad = new tad();
    localtad.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localtad.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localtad.jdField_b_of_type_Long = 0L;
    localtad.c = 10;
    localtad.d = 10;
    slv.a().a(localtad, this);
    urk.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localtad.toString());
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
  
  public void a(@NonNull tad paramtad, @Nullable tbt paramtbt, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      urk.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    uhd localuhd = new uhd(paramErrorMessage, this.jdField_c_of_type_JavaLangString);
    localuhd.jdField_b_of_type_Boolean = false;
    if ((paramtbt == null) || (paramErrorMessage.isFail()))
    {
      sgi.a().dispatch(localuhd);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramtbt.jdField_a_of_type_JavaLangString;
    localuhd.jdField_a_of_type_JavaUtilList = paramtbt.jdField_a_of_type_JavaUtilArrayList;
    localuhd.jdField_a_of_type_Int = paramtbt.b;
    localuhd.jdField_a_of_type_Boolean = paramtbt.jdField_a_of_type_Boolean;
    localuhd.jdField_c_of_type_Boolean = TextUtils.isEmpty(paramtad.jdField_a_of_type_JavaLangString);
    paramtbt = paramtbt.jdField_a_of_type_JavaUtilArrayList;
    ((spt)sqg.a(19)).b(paramtbt, paramtad.jdField_b_of_type_JavaLangString, localuhd.jdField_c_of_type_Boolean);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      sgi.a().dispatch(localuhd);
      urk.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localuhd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhc
 * JD-Core Version:    0.7.0.1
 */