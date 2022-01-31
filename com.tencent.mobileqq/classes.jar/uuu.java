import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class uuu
  implements urr<vfo, vhi>
{
  uuu(uus paramuus) {}
  
  public void a(@NonNull vfo paramvfo, @Nullable vhi paramvhi, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramvhi != null))
    {
      wxe.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramvhi.toString());
      this.a.jdField_a_of_type_JavaLangObject = new uuv(paramvhi.a, paramvhi.c, paramvhi.d, paramvhi.e, paramvhi.f, paramvfo.d, paramvfo.e);
      this.a.a("country", paramvhi.a);
      this.a.a("province", paramvhi.c);
      this.a.a("city", paramvhi.d);
      this.a.a("district", paramvhi.e);
      this.a.a("street", paramvhi.f);
      this.a.a("longitude", paramvfo.d);
      this.a.a("latitude", paramvfo.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      wxe.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramvfo });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuu
 * JD-Core Version:    0.7.0.1
 */