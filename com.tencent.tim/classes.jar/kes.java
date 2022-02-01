import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;

public class kes
  extends BroadcastReceiver
{
  public kes(EcshopNewPageFragment paramEcshopNewPageFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.biz.pubaccount.ecshop.tabpage.finish".equals(paramIntent.getAction())) && (this.a.getActivity() != null)) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kes
 * JD-Core Version:    0.7.0.1
 */