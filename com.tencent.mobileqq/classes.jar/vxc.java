import android.os.Handler;
import com.tencent.biz.pubaccount.PublicAccountManager.InitDoneObserver;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

class vxc
  implements PublicAccountManager.InitDoneObserver
{
  vxc(vxb paramvxb) {}
  
  public void a()
  {
    PublicAccountChatPie.b(this.a.a, false);
    this.a.a.a.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxc
 * JD-Core Version:    0.7.0.1
 */