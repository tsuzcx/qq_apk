import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;

public class vwc
  implements Runnable
{
  public vwc(BaseTroopChatPie paramBaseTroopChatPie) {}
  
  public void run()
  {
    this.a.a.setText("<<消息过滤模式>>");
    BaseTroopChatPie.a(this.a).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwc
 * JD-Core Version:    0.7.0.1
 */