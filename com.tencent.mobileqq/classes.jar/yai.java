import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class yai
  extends wpx
  implements wfk<wtp, wvf>
{
  public String a;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void d()
  {
    wtp localwtp = new wtp();
    localwtp.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localwtp.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localwtp.jdField_b_of_type_Long = 0L;
    localwtp.c = 10;
    localwtp.d = 10;
    wfi.a().a(localwtp, this);
    ykq.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localwtp.toString());
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
  
  public void a(@NonNull wtp paramwtp, @Nullable wvf paramwvf, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      ykq.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    yaj localyaj = new yaj(paramErrorMessage, this.jdField_c_of_type_JavaLangString);
    localyaj.jdField_b_of_type_Boolean = false;
    if ((paramwvf == null) || (paramErrorMessage.isFail()))
    {
      wad.a().dispatch(localyaj);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramwvf.jdField_a_of_type_JavaLangString;
    localyaj.jdField_a_of_type_JavaUtilList = paramwvf.jdField_a_of_type_JavaUtilArrayList;
    localyaj.jdField_a_of_type_Int = paramwvf.b;
    localyaj.jdField_a_of_type_Boolean = paramwvf.jdField_a_of_type_Boolean;
    localyaj.jdField_c_of_type_Boolean = TextUtils.isEmpty(paramwtp.jdField_a_of_type_JavaLangString);
    paramwvf = paramwvf.jdField_a_of_type_JavaUtilArrayList;
    ((wjf)wjs.a(19)).b(paramwvf, paramwtp.jdField_b_of_type_JavaLangString, localyaj.jdField_c_of_type_Boolean);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      wad.a().dispatch(localyaj);
      ykq.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localyaj);
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
 * Qualified Name:     yai
 * JD-Core Version:    0.7.0.1
 */