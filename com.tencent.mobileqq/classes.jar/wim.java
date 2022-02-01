import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wim
  implements wfk<wtg, wva>
{
  wim(wik paramwik) {}
  
  public void a(@NonNull wtg paramwtg, @Nullable wva paramwva, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramwva != null))
    {
      ykq.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramwva.toString());
      this.a.jdField_a_of_type_JavaLangObject = new win(paramwva.a, paramwva.c, paramwva.d, paramwva.e, paramwva.f, paramwtg.d, paramwtg.e);
      this.a.a("country", paramwva.a);
      this.a.a("province", paramwva.c);
      this.a.a("city", paramwva.d);
      this.a.a("district", paramwva.e);
      this.a.a("street", paramwva.f);
      this.a.a("longitude", paramwtg.d);
      this.a.a("latitude", paramwtg.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      ykq.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramwtg });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wim
 * JD-Core Version:    0.7.0.1
 */