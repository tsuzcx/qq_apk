import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.task.ApolloAioBubblePush.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class abvi
{
  private boolean bFU;
  private DrawerPushItem c;
  
  public DrawerPushItem a()
  {
    return this.c;
  }
  
  public void cFJ()
  {
    this.c = null;
  }
  
  public void cf(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new ApolloAioBubblePush.1(this, paramQQAppInterface), 8, null, true);
  }
  
  public void cg(QQAppInterface paramQQAppInterface)
  {
    if ((this.c == null) || (paramQQAppInterface == null)) {}
    do
    {
      return;
      paramQQAppInterface = (abhh)paramQQAppInterface.getManager(153);
    } while (!this.bFU);
    DrawerPushItem localDrawerPushItem = this.c;
    localDrawerPushItem.show_sum += 1;
    if (this.c.show_sum == this.c.show_counts)
    {
      QLog.i("ApolloAioBubblePush", 1, "remove item from db, id:" + this.c.msg_id);
      paramQQAppInterface.a(this.c);
      return;
    }
    paramQQAppInterface.b(this.c);
    QLog.i("ApolloAioBubblePush", 1, "update item from db" + this.c.msg_id);
  }
  
  public boolean g(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramQQAppInterface == null) || (this.c == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAioBubblePush", 2, "DO NOT show bubble, maybe item is null, item:" + this.c);
      }
    }
    abqt localabqt;
    do
    {
      do
      {
        return false;
        if (!this.bFU) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloAioBubblePush", 2, "DO NOT show bubble cause it has been showed.");
      return false;
      if ((this.c.msg_type == 4) && (!TextUtils.isEmpty(this.c.msg_id)))
      {
        paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "apollo_game_reddot_sp", 0).edit().putBoolean(this.c.msg_id, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloAioBubblePush", 2, "[onShowBubble] parseGameReddot mPushItem.msg_id has show:" + this.c.msg_id);
        }
      }
      QLog.i("ApolloAioBubblePush", 1, "Show bubble, id:" + this.c.msg_id);
      localabqt = abrj.a(paramQQAppInterface);
    } while (localabqt == null);
    localabqt.ey("", this.c.content);
    this.bFU = true;
    cg(paramQQAppInterface);
    if ((this.c.msg_type == 10) || (this.c.msg_type == 7)) {
      abhh.t(101, String.valueOf(this.c.tianshuAdId), this.c.tianshuTraceInfo);
    }
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_msg_display", ApolloUtil.gi(paramInt), 0, new String[] { this.c.msg_id });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvi
 * JD-Core Version:    0.7.0.1
 */