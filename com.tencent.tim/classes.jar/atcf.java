import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.tim.activity.profile.host.HostProfileFragment;

public class atcf
  implements IphonePickerView.c
{
  public atcf(HostProfileFragment paramHostProfileFragment) {}
  
  public void dn()
  {
    if ((HostProfileFragment.a(this.this$0) != null) && (HostProfileFragment.a(this.this$0).isShowing())) {
      HostProfileFragment.a(this.this$0).dismiss();
    }
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      this.this$0.m((byte)paramInt1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcf
 * JD-Core Version:    0.7.0.1
 */