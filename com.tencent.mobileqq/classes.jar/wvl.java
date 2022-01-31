import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wvl
  implements uni<vbf, vcz>
{
  wvl(wvj paramwvj) {}
  
  public void a(@NonNull vbf paramvbf, @Nullable vcz paramvcz, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramvcz != null))
    {
      wsv.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramvcz.toString());
      paramvbf = new uqm(paramvcz.a, paramvcz.c, paramvcz.d, paramvcz.e, paramvcz.f, paramvbf.d, paramvbf.e);
      this.a.a(0, paramvbf);
      return;
    }
    wsv.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvl
 * JD-Core Version:    0.7.0.1
 */