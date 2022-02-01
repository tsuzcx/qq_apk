import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class afas
  implements View.OnClickListener
{
  public afas(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime) {}
  
  public void onClick(View paramView)
  {
    if ((this.a instanceof QQAppInterface)) {
      ((QQAppInterface)this.a).a(0).a().b().printMsgLruCache();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afas
 * JD-Core Version:    0.7.0.1
 */