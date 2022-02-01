import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class aioh
  implements DialogInterface.OnDismissListener
{
  public aioh(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, ListenTogetherManager paramListenTogetherManager, aipd paramaipd) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_b_of_type_ComTencentMobileqqListentogetherListenTogetherManager.dtc();
    this.jdField_b_of_type_Aipd.Lm(false);
    if (!ListenTogetherOverlayFragment.a(this.a).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.a).finish();
    }
    ListenTogetherOverlayFragment.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aioh
 * JD-Core Version:    0.7.0.1
 */