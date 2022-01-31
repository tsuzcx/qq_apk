import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.utils.FileUtils;

public class znm
  implements Runnable
{
  public znm(MessageHandler paramMessageHandler) {}
  
  public void run()
  {
    FileUtils.a(AIOShareActionSheet.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znm
 * JD-Core Version:    0.7.0.1
 */