import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

class vxl
  implements Runnable
{
  vxl(vxk paramvxk) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.a.a.a.setResult(-1, localIntent);
    this.a.a.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxl
 * JD-Core Version:    0.7.0.1
 */