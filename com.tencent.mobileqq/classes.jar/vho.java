import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;

public class vho
  implements PopupWindow.OnDismissListener
{
  public vho(StructingMsgItemBuilder paramStructingMsgItemBuilder) {}
  
  public void onDismiss()
  {
    StructingMsgItemBuilder.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vho
 * JD-Core Version:    0.7.0.1
 */