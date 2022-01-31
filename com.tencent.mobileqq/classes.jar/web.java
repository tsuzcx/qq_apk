import android.app.Dialog;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.qidian.controller.QidianBusinessObserver;
import java.util.HashMap;

public class web
  extends QidianBusinessObserver
{
  public web(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  protected void f(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null))
    {
      this.a.z(2);
      this.a.a.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    if (((Integer)paramHashMap.get("result")).intValue() == 0)
    {
      this.a.z(1);
      this.a.a.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    this.a.aj = true;
    this.a.bn();
    if ((PublicAccountChatPie.a(this.a) != null) && (PublicAccountChatPie.a(this.a).isShowing())) {
      PublicAccountChatPie.a(this.a).dismiss();
    }
    this.a.bo();
  }
  
  protected void g(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null)) {
      return;
    }
    this.a.am = true;
    this.a.al = ((Boolean)paramHashMap.get("result")).booleanValue();
    this.a.bn();
    this.a.bo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     web
 * JD-Core Version:    0.7.0.1
 */