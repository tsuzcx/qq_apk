import android.widget.EditText;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.9.1;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV.a;

public class ajut
  implements MonitorSizeChangeHSV.a
{
  public ajut(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ChooseInterestTagActivity.a(this.this$0).post(new ChooseInterestTagActivity.9.1(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajut
 * JD-Core Version:    0.7.0.1
 */