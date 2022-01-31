import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;

public class vhu
  implements PopupWindow.OnDismissListener
{
  public vhu(StructingMsgItemBuilder paramStructingMsgItemBuilder) {}
  
  public void onDismiss()
  {
    StructingMsgItemBuilder.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vhu
 * JD-Core Version:    0.7.0.1
 */