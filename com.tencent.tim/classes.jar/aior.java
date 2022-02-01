import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class aior
  implements DialogInterface.OnClickListener
{
  public aior(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, ListenTogetherManager paramListenTogetherManager, aipd paramaipd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqListentogetherListenTogetherManager.dtc();
    this.jdField_b_of_type_Aipd.Lm(false);
    if (!ListenTogetherOverlayFragment.a(this.a).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aior
 * JD-Core Version:    0.7.0.1
 */