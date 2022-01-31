import android.os.Handler;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

class cbh
  implements Runnable
{
  cbh(cbg paramcbg) {}
  
  public void run()
  {
    if (this.a.a.a != null) {
      this.a.a.a.dismiss();
    }
    this.a.a.h(true);
    this.a.a.ae();
    if (!AnonymousChatHelper.a(TroopChatPie.b(this.a.a), TroopChatPie.c(this.a.a))) {
      TroopChatPie.d(this.a.a).postDelayed(new cbi(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbh
 * JD-Core Version:    0.7.0.1
 */