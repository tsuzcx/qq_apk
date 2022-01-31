import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.utils.FileUtils;

public class zdh
  implements Runnable
{
  public zdh(MessageHandler paramMessageHandler) {}
  
  public void run()
  {
    FileUtils.a(AIOShareActionSheet.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdh
 * JD-Core Version:    0.7.0.1
 */