import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;

public class wct
  extends alry
{
  public wct(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wct
 * JD-Core Version:    0.7.0.1
 */