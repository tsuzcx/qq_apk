import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wog
  implements wld<wza, xau>
{
  wog(woe paramwoe) {}
  
  public void a(@NonNull wza paramwza, @Nullable xau paramxau, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramxau != null))
    {
      yqp.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramxau.toString());
      this.a.jdField_a_of_type_JavaLangObject = new woh(paramxau.a, paramxau.c, paramxau.d, paramxau.e, paramxau.f, paramwza.d, paramwza.e);
      this.a.a("country", paramxau.a);
      this.a.a("province", paramxau.c);
      this.a.a("city", paramxau.d);
      this.a.a("district", paramxau.e);
      this.a.a("street", paramxau.f);
      this.a.a("longitude", paramwza.d);
      this.a.a("latitude", paramwza.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      yqp.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramwza });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wog
 * JD-Core Version:    0.7.0.1
 */