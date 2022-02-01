import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xyl
  implements vqp<wel, wgf>
{
  xyl(xyj paramxyj) {}
  
  public void a(@NonNull wel paramwel, @Nullable wgf paramwgf, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramwgf != null))
    {
      xvv.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramwgf.toString());
      paramwel = new vts(paramwgf.a, paramwgf.c, paramwgf.d, paramwgf.e, paramwgf.f, paramwel.d, paramwel.e);
      this.a.a(0, paramwel);
      return;
    }
    xvv.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyl
 * JD-Core Version:    0.7.0.1
 */