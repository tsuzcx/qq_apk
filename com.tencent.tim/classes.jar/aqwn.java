import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;

public class aqwn
  implements DialogInterface.OnDismissListener
{
  public aqwn(LiangHaoBuyFragment paramLiangHaoBuyFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!LiangHaoBuyFragment.a(this.a)) {
      LiangHaoBuyFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwn
 * JD-Core Version:    0.7.0.1
 */