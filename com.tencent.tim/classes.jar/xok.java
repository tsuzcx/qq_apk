import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;

public class xok
  implements DialogInterface.OnClickListener
{
  public xok(StructingMsgItemBuilder paramStructingMsgItemBuilder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xok
 * JD-Core Version:    0.7.0.1
 */