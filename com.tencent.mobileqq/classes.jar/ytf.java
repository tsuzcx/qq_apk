import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class ytf
  implements wld<wza, xau>
{
  ytf(ytd paramytd) {}
  
  public void a(@NonNull wza paramwza, @Nullable xau paramxau, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramxau != null))
    {
      yqp.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramxau.toString());
      paramwza = new woh(paramxau.a, paramxau.c, paramxau.d, paramxau.e, paramxau.f, paramwza.d, paramwza.e);
      this.a.a(0, paramwza);
      return;
    }
    yqp.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytf
 * JD-Core Version:    0.7.0.1
 */