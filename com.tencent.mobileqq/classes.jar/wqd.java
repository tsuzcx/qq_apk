import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.common.app.BaseApplicationImpl;

public class wqd
  extends amgr
{
  public wqd(SubscribeBaseFragment paramSubscribeBaseFragment) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    amkg.a(BaseApplicationImpl.getContext(), 2, true);
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqd
 * JD-Core Version:    0.7.0.1
 */