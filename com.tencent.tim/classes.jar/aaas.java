import android.view.View;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView.a;

public class aaas
  implements ChooseItemView.a
{
  public aaas(LingHbFragment paramLingHbFragment) {}
  
  public void FM(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.view.findViewById(2131369132).setVisibility(8);
      return;
    }
    this.a.view.findViewById(2131369132).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaas
 * JD-Core Version:    0.7.0.1
 */