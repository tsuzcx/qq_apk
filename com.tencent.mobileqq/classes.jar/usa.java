import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class usa
  implements DialogInterface.OnDismissListener
{
  public usa(WSVerticalPageFragment paramWSVerticalPageFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (WSVerticalPageFragment.a(this.a) != null) {
      WSVerticalPageFragment.a(this.a).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usa
 * JD-Core Version:    0.7.0.1
 */