import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.QQToast;

public class dcb
  extends Handler
{
  public dcb(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      if ((this.a.h == 1) || (this.a.h == 2))
      {
        this.a.d();
        QQToast.a(this.a, 2131364405, 0).b(this.a.getTitleBarHeight());
      }
    }
    while ((paramMessage.what != 1001) || (!this.a.c)) {
      return;
    }
    Object localObject = (Object[])paramMessage.obj;
    paramMessage = (String[])localObject[0];
    localObject = (String)localObject[1];
    Intent localIntent = new Intent();
    localIntent.putExtra("param_location", paramMessage);
    localIntent.putExtra("param_location_param", (String)localObject);
    this.a.doOnActivityResult(1000, -1, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dcb
 * JD-Core Version:    0.7.0.1
 */