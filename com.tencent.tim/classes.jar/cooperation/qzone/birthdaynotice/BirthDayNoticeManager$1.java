package cooperation.qzone.birthdaynotice;

import GIFT_MALL_PROTOCOL.DouFuInfo;
import anaz;
import avss;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import wkh;

public final class BirthDayNoticeManager$1
  implements Runnable
{
  public BirthDayNoticeManager$1(DouFuInfo paramDouFuInfo, QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, long paramLong) {}
  
  public void run()
  {
    String str = String.valueOf(this.a.uin);
    if (avss.ai(this.val$app, str))
    {
      long l1 = this.val$app.a().az(str);
      long l2 = System.currentTimeMillis();
      if (Math.abs(l1 - l2) > 432000000L)
      {
        wkh localwkh = (wkh)this.val$app.getManager(282);
        BeancurdMsg localBeancurdMsg = new BeancurdMsg();
        localBeancurdMsg.buffer = this.aS.toString();
        localBeancurdMsg.busiid = 6;
        localBeancurdMsg.frienduin = String.valueOf(str);
        localBeancurdMsg.isNeedDelHistory = true;
        localBeancurdMsg.ispush = false;
        localBeancurdMsg.startTime = anaz.gQ();
        localBeancurdMsg.validTime = 432000L;
        localBeancurdMsg.token = this.aAn;
        if (QLog.isColorLevel()) {
          QLog.i("BirthDayNoticeManager", 2, "addBirthDayFeedMessage receiveBeancurd:" + String.valueOf(localBeancurdMsg));
        }
        localwkh.a(localBeancurdMsg);
        this.val$app.a().aM(String.valueOf(str), l2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.birthdaynotice.BirthDayNoticeManager.1
 * JD-Core Version:    0.7.0.1
 */