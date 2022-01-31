import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;

public class vxr
  implements Runnable
{
  public vxr(DiscussChatPie paramDiscussChatPie) {}
  
  public void run()
  {
    this.a.a.setText("<<消息过滤模式>>");
    DiscussChatPie.a(this.a).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxr
 * JD-Core Version:    0.7.0.1
 */