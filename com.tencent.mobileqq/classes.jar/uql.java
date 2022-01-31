import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class uql
  implements uni<vbf, vcz>
{
  uql(uqj paramuqj) {}
  
  public void a(@NonNull vbf paramvbf, @Nullable vcz paramvcz, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramvcz != null))
    {
      wsv.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramvcz.toString());
      this.a.jdField_a_of_type_JavaLangObject = new uqm(paramvcz.a, paramvcz.c, paramvcz.d, paramvcz.e, paramvcz.f, paramvbf.d, paramvbf.e);
      this.a.a("country", paramvcz.a);
      this.a.a("province", paramvcz.c);
      this.a.a("city", paramvcz.d);
      this.a.a("district", paramvcz.e);
      this.a.a("street", paramvcz.f);
      this.a.a("longitude", paramvbf.d);
      this.a.a("latitude", paramvbf.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      wsv.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramvbf });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uql
 * JD-Core Version:    0.7.0.1
 */