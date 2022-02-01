import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class aiok
  implements DialogInterface.OnCancelListener
{
  public aiok(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, aipd paramaipd) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.b.Lm(false);
    if (!ListenTogetherOverlayFragment.a(this.a).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiok
 * JD-Core Version:    0.7.0.1
 */