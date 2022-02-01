import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vtr
  implements vqp<wel, wgf>
{
  vtr(vtp paramvtp) {}
  
  public void a(@NonNull wel paramwel, @Nullable wgf paramwgf, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramwgf != null))
    {
      xvv.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramwgf.toString());
      this.a.jdField_a_of_type_JavaLangObject = new vts(paramwgf.a, paramwgf.c, paramwgf.d, paramwgf.e, paramwgf.f, paramwel.d, paramwel.e);
      this.a.a("country", paramwgf.a);
      this.a.a("province", paramwgf.c);
      this.a.a("city", paramwgf.d);
      this.a.a("district", paramwgf.e);
      this.a.a("street", paramwgf.f);
      this.a.a("longitude", paramwel.d);
      this.a.a("latitude", paramwel.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      xvv.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramwel });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtr
 * JD-Core Version:    0.7.0.1
 */