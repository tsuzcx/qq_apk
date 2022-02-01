import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class rcn
  implements ppv.b<pyx, qai>
{
  rcn(rcl paramrcl) {}
  
  public void a(@NonNull pyx parampyx, @Nullable qai paramqai, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramqai != null))
    {
      ram.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond success : %s .", paramqai.toString());
      parampyx = new prw.a(paramqai.awy, paramqai.awz, paramqai.awA, paramqai.awB, paramqai.awC, parampyx.blt, parampyx.blu);
      this.this$0.a(0, parampyx);
      return;
    }
    ram.e("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress onCmdRespond failed : %s .", new Object[] { paramErrorMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcn
 * JD-Core Version:    0.7.0.1
 */