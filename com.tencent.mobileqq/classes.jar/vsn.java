import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;

public class vsn
  implements Runnable
{
  public vsn(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  public void run()
  {
    MultiForwardChatPie.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsn
 * JD-Core Version:    0.7.0.1
 */