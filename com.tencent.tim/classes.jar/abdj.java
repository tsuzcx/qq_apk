import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.webprocess.WebProcessManager.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "onResult"}, k=3, mv={1, 1, 16})
final class abdj
  implements WebProcessManager.a
{
  abdj(BaseActivity paramBaseActivity) {}
  
  public final void onResult(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "new_folder_prestart_success";; str = "new_folder_prestart_fail")
    {
      abcx.a().E(this.n.app, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdj
 * JD-Core Version:    0.7.0.1
 */