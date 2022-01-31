import com.tencent.ark.ArkDebugger;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.widget.QQToast;

class vqq
  implements Runnable
{
  vqq(vqp paramvqp) {}
  
  public void run()
  {
    ArkDebugger.Listen("127.0.0.1", 23333L, 600000L, ArkAppCenter.f());
    QQToast.a(this.a.a.a.a.a, "已经开启监听，可以连接调试...", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqq
 * JD-Core Version:    0.7.0.1
 */