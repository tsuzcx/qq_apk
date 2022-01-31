import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;

public class bt
  implements CompoundButton.OnCheckedChangeListener
{
  public bt(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LiteAdvanceActivity.b(this.a, paramBoolean);
    LiteAdvanceActivity.b(this.a, LiteAdvanceActivity.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bt
 * JD-Core Version:    0.7.0.1
 */