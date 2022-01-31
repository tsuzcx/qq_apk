import com.tencent.ark.ArkDebugger;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie;

public class vqu
  implements Runnable
{
  public vqu(ArkDebugChatPie paramArkDebugChatPie) {}
  
  public void run()
  {
    ArkDebugChatPie.b(this.a);
    ArkDebugChatPie.c(this.a);
    ArkDebugger.Destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqu
 * JD-Core Version:    0.7.0.1
 */