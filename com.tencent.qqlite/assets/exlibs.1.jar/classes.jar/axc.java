import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.widget.QQToast;

public class axc
  extends Handler
{
  public axc(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.c();
      QQToast.a(this.a, 2131364412, 0).b(this.a.getTitleBarHeight());
      return;
      this.a.a.i();
      return;
      NearbyPeopleProfileActivity.a(this.a);
      return;
    } while (paramMessage.obj == null);
    NearbyPeopleProfileActivity.a(this.a, (NearbyPeopleCard)paramMessage.obj);
    NearbyPeopleProfileActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axc
 * JD-Core Version:    0.7.0.1
 */