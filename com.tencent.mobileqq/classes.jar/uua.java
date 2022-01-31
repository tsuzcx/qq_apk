import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class uua
  implements slx<szu, tbo>
{
  uua(uty paramuty) {}
  
  public void a(@NonNull szu paramszu, @Nullable tbo paramtbo, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramtbo != null))
    {
      urk.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramtbo.toString());
      paramszu = new spb(paramtbo.a, paramtbo.c, paramtbo.d, paramtbo.e, paramtbo.f, paramszu.d, paramszu.e);
      this.a.a(0, paramszu);
      return;
    }
    urk.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uua
 * JD-Core Version:    0.7.0.1
 */