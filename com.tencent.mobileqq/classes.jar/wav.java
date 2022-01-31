import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;

public class wav
  implements Runnable
{
  public wav(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  public void run()
  {
    MultiForwardChatPie.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wav
 * JD-Core Version:    0.7.0.1
 */