import android.os.Handler;
import android.os.Message;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class kw
  extends Handler
{
  public kw(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (paramMessage.what == 2) {
      return;
    }
    Object localObject1;
    if (paramMessage.what == 3) {
      if ((paramMessage.obj instanceof Card))
      {
        localObject1 = (Card)paramMessage.obj;
        String str = ((Card)localObject1).uin;
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "MSG_SWITCH_TO_FRIEND, uin = " + (String)localObject1 + ", obj: " + paramMessage.obj + "");
      }
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break;
      }
      BmqqProfileCardActivity.a(this.a, localObject2, (String)localObject1);
      return;
      if ((paramMessage.obj instanceof String))
      {
        localObject1 = (String)paramMessage.obj;
        continue;
        if (paramMessage.what != 4) {
          break;
        }
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     kw
 * JD-Core Version:    0.7.0.1
 */