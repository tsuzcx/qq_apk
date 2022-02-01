import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.common.app.BaseApplicationImpl;

public class zwz
  extends aqnu
{
  public zwz(SubscribeBaseFragment paramSubscribeBaseFragment) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    aqrl.a(BaseApplicationImpl.getContext(), 2, true);
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwz
 * JD-Core Version:    0.7.0.1
 */