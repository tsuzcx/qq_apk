import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class aioj
  implements DialogInterface.OnDismissListener
{
  public aioj(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, aipd paramaipd) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.b.Lm(false);
    this.b.cli = false;
    if (!ListenTogetherOverlayFragment.a(this.a).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.a).finish();
    }
    if (this.b.clj) {
      this.b.dtv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aioj
 * JD-Core Version:    0.7.0.1
 */