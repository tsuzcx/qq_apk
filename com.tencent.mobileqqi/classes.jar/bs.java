import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;

public class bs
  implements CompoundButton.OnCheckedChangeListener
{
  public bs(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LiteAdvanceActivity.a(this.a, paramBoolean);
    LiteAdvanceActivity.a(this.a, LiteAdvanceActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bs
 * JD-Core Version:    0.7.0.1
 */