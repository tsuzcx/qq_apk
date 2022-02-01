import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class yne
  implements wfk<wtg, wva>
{
  yne(ync paramync) {}
  
  public void a(@NonNull wtg paramwtg, @Nullable wva paramwva, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramwva != null))
    {
      ykq.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramwva.toString());
      paramwtg = new win(paramwva.a, paramwva.c, paramwva.d, paramwva.e, paramwva.f, paramwtg.d, paramwtg.e);
      this.a.a(0, paramwtg);
      return;
    }
    ykq.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yne
 * JD-Core Version:    0.7.0.1
 */