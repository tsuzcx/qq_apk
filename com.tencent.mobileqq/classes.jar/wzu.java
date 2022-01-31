import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wzu
  implements urr<vfo, vhi>
{
  wzu(wzs paramwzs) {}
  
  public void a(@NonNull vfo paramvfo, @Nullable vhi paramvhi, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramvhi != null))
    {
      wxe.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramvhi.toString());
      paramvfo = new uuv(paramvhi.a, paramvhi.c, paramvhi.d, paramvhi.e, paramvhi.f, paramvfo.d, paramvfo.e);
      this.a.a(0, paramvfo);
      return;
    }
    wxe.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzu
 * JD-Core Version:    0.7.0.1
 */