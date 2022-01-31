import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.qphone.base.util.QLog;

public class vsh
  implements AsyncBack
{
  public vsh(HotChatPie paramHotChatPie) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPieQ.hotchat.aio_post_list_plugin", 2, "checkUpByBusinessId:2586|param:" + paramString + "|code:" + paramInt);
    }
    paramString = this.a;
    if ((paramInt == 0) || (8 == paramInt) || (5 == paramInt)) {}
    for (boolean bool = true;; bool = false)
    {
      HotChatPie.b(paramString, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsh
 * JD-Core Version:    0.7.0.1
 */