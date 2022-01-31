import com.tencent.ark.ArkDebugger;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class vqm
  implements Runnable
{
  public vqm(ArkDebugChatPie paramArkDebugChatPie) {}
  
  public void run()
  {
    ArkDebugger.Create();
    ArkDebugger.SetCallback(new vqn(this));
    ArkDebugChatPie.a(this.a, ArkAppCenter.f());
    ArkDebugger.Listen("127.0.0.1", 23333L, 600000L, ArkAppCenter.f());
    ArkDispatchTask.getInstance().postToMainThread(new vqt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqm
 * JD-Core Version:    0.7.0.1
 */