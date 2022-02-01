import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class yxa
  implements woy<xcv, xep>
{
  yxa(ywy paramywy) {}
  
  public void a(@NonNull xcv paramxcv, @Nullable xep paramxep, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramxep != null))
    {
      yuk.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramxep.toString());
      paramxcv = new wsc(paramxep.a, paramxep.c, paramxep.d, paramxep.e, paramxep.f, paramxcv.d, paramxcv.e);
      this.a.a(0, paramxcv);
      return;
    }
    yuk.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxa
 * JD-Core Version:    0.7.0.1
 */