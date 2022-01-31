import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class utv
  extends tje
  implements syq<tmw, tom>
{
  public String a;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void d()
  {
    tmw localtmw = new tmw();
    localtmw.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localtmw.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localtmw.jdField_b_of_type_Long = 0L;
    localtmw.c = 10;
    localtmw.d = 10;
    syo.a().a(localtmw, this);
    ved.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localtmw.toString());
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
  
  public void a(@NonNull tmw paramtmw, @Nullable tom paramtom, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      ved.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    utw localutw = new utw(paramErrorMessage, this.jdField_c_of_type_JavaLangString);
    localutw.jdField_b_of_type_Boolean = false;
    if ((paramtom == null) || (paramErrorMessage.isFail()))
    {
      stb.a().dispatch(localutw);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramtom.jdField_a_of_type_JavaLangString;
    localutw.jdField_a_of_type_JavaUtilList = paramtom.jdField_a_of_type_JavaUtilArrayList;
    localutw.jdField_a_of_type_Int = paramtom.b;
    localutw.jdField_a_of_type_Boolean = paramtom.jdField_a_of_type_Boolean;
    localutw.jdField_c_of_type_Boolean = TextUtils.isEmpty(paramtmw.jdField_a_of_type_JavaLangString);
    paramtom = paramtom.jdField_a_of_type_JavaUtilArrayList;
    ((tcm)tcz.a(19)).b(paramtom, paramtmw.jdField_b_of_type_JavaLangString, localutw.jdField_c_of_type_Boolean);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      stb.a().dispatch(localutw);
      ved.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localutw);
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
 * Qualified Name:     utv
 * JD-Core Version:    0.7.0.1
 */