import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;

public class wcp
  implements alut
{
  public wcp(SubscribeBaseFragment paramSubscribeBaseFragment) {}
  
  public void onColorNoteAnimFinish()
  {
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wcp
 * JD-Core Version:    0.7.0.1
 */