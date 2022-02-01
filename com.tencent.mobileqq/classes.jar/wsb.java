import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wsb
  implements woy<xcv, xep>
{
  wsb(wrz paramwrz) {}
  
  public void a(@NonNull xcv paramxcv, @Nullable xep paramxep, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramxep != null))
    {
      yuk.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramxep.toString());
      this.a.jdField_a_of_type_JavaLangObject = new wsc(paramxep.a, paramxep.c, paramxep.d, paramxep.e, paramxep.f, paramxcv.d, paramxcv.e);
      this.a.a("country", paramxep.a);
      this.a.a("province", paramxep.c);
      this.a.a("city", paramxep.d);
      this.a.a("district", paramxep.e);
      this.a.a("street", paramxep.f);
      this.a.a("longitude", paramxcv.d);
      this.a.a("latitude", paramxcv.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      yuk.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramxcv });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsb
 * JD-Core Version:    0.7.0.1
 */