import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vgt
  implements syq<tmn, toh>
{
  vgt(vgr paramvgr) {}
  
  public void a(@NonNull tmn paramtmn, @Nullable toh paramtoh, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramtoh != null))
    {
      ved.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramtoh.toString());
      paramtmn = new tbu(paramtoh.a, paramtoh.c, paramtoh.d, paramtoh.e, paramtoh.f, paramtmn.d, paramtmn.e);
      this.a.a(0, paramtmn);
      return;
    }
    ved.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgt
 * JD-Core Version:    0.7.0.1
 */