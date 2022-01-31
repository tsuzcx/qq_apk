import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;

public class ebb
  implements DialogInterface.OnClickListener
{
  public ebb(TextItemBuilder paramTextItemBuilder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ebb
 * JD-Core Version:    0.7.0.1
 */