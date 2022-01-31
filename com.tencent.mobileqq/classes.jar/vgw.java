import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vgw
  implements syt<tmq, tok>
{
  vgw(vgu paramvgu) {}
  
  public void a(@NonNull tmq paramtmq, @Nullable tok paramtok, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramtok != null))
    {
      veg.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramtok.toString());
      paramtmq = new tbx(paramtok.a, paramtok.c, paramtok.d, paramtok.e, paramtok.f, paramtmq.d, paramtmq.e);
      this.a.a(0, paramtmq);
      return;
    }
    veg.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgw
 * JD-Core Version:    0.7.0.1
 */