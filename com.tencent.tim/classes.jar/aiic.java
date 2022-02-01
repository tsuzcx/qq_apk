import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherVCtrlFragment;

public class aiic
  implements DialogInterface.OnDismissListener
{
  public aiic(WatchTogetherVCtrlFragment paramWatchTogetherVCtrlFragment, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.val$activity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiic
 * JD-Core Version:    0.7.0.1
 */