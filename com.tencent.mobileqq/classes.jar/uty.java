import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class uty
  extends tjh
  implements syt<tmz, top>
{
  public String a;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void d()
  {
    tmz localtmz = new tmz();
    localtmz.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localtmz.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localtmz.jdField_b_of_type_Long = 0L;
    localtmz.c = 10;
    localtmz.d = 10;
    syr.a().a(localtmz, this);
    veg.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localtmz.toString());
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
  
  public void a(@NonNull tmz paramtmz, @Nullable top paramtop, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      veg.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    utz localutz = new utz(paramErrorMessage, this.jdField_c_of_type_JavaLangString);
    localutz.jdField_b_of_type_Boolean = false;
    if ((paramtop == null) || (paramErrorMessage.isFail()))
    {
      ste.a().dispatch(localutz);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramtop.jdField_a_of_type_JavaLangString;
    localutz.jdField_a_of_type_JavaUtilList = paramtop.jdField_a_of_type_JavaUtilArrayList;
    localutz.jdField_a_of_type_Int = paramtop.b;
    localutz.jdField_a_of_type_Boolean = paramtop.jdField_a_of_type_Boolean;
    localutz.jdField_c_of_type_Boolean = TextUtils.isEmpty(paramtmz.jdField_a_of_type_JavaLangString);
    paramtop = paramtop.jdField_a_of_type_JavaUtilArrayList;
    ((tcp)tdc.a(19)).b(paramtop, paramtmz.jdField_b_of_type_JavaLangString, localutz.jdField_c_of_type_Boolean);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      ste.a().dispatch(localutz);
      veg.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localutz);
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
 * Qualified Name:     uty
 * JD-Core Version:    0.7.0.1
 */