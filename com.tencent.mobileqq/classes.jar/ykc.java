import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class ykc
  extends wzm
  implements woy<xde, xeu>
{
  public String a;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void d()
  {
    xde localxde = new xde();
    localxde.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localxde.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localxde.jdField_b_of_type_Long = 0L;
    localxde.c = 10;
    localxde.d = 10;
    wow.a().a(localxde, this);
    yuk.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localxde.toString());
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
  
  public void a(@NonNull xde paramxde, @Nullable xeu paramxeu, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      yuk.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    ykd localykd = new ykd(paramErrorMessage, this.jdField_c_of_type_JavaLangString);
    localykd.jdField_b_of_type_Boolean = false;
    if ((paramxeu == null) || (paramErrorMessage.isFail()))
    {
      wjj.a().dispatch(localykd);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramxeu.jdField_a_of_type_JavaLangString;
    localykd.jdField_a_of_type_JavaUtilList = paramxeu.jdField_a_of_type_JavaUtilArrayList;
    localykd.jdField_a_of_type_Int = paramxeu.b;
    localykd.jdField_a_of_type_Boolean = paramxeu.jdField_a_of_type_Boolean;
    localykd.jdField_c_of_type_Boolean = TextUtils.isEmpty(paramxde.jdField_a_of_type_JavaLangString);
    paramxeu = paramxeu.jdField_a_of_type_JavaUtilArrayList;
    ((wsu)wth.a(19)).b(paramxeu, paramxde.jdField_b_of_type_JavaLangString, localykd.jdField_c_of_type_Boolean);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      wjj.a().dispatch(localykd);
      yuk.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localykd);
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
 * Qualified Name:     ykc
 * JD-Core Version:    0.7.0.1
 */