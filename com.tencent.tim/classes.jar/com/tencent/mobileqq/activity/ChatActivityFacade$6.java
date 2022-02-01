package com.tencent.mobileqq.activity;

import anaz;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import ujt;
import wkh;
import ysf;

public final class ChatActivityFacade$6
  implements Runnable
{
  public ChatActivityFacade$6(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, JSONObject paramJSONObject, boolean paramBoolean, boolean[] paramArrayOfBoolean, long[] paramArrayOfLong) {}
  
  public void run()
  {
    long l1;
    if (ujt.c(this.val$app, this.a, false))
    {
      l1 = this.aS.optLong("fromuin");
      if (!String.valueOf(l1).equals(this.a.aTl)) {
        break label250;
      }
      long l2 = this.aS.optLong("time");
      QLog.i("ChatActivityFacade.QZoneFeeds", 1, "add new feeds publishTime:" + l2);
      if (this.aTq) {
        ((ysf)this.val$app.getManager(34)).dN(this.aS.toString(), String.valueOf(l1));
      }
    }
    else
    {
      return;
    }
    wkh localwkh = (wkh)this.val$app.getManager(282);
    BeancurdMsg localBeancurdMsg = new BeancurdMsg();
    localBeancurdMsg.buffer = this.aS.toString();
    localBeancurdMsg.busiid = 2;
    localBeancurdMsg.frienduin = String.valueOf(l1);
    localBeancurdMsg.isNeedDelHistory = true;
    localBeancurdMsg.ispush = this.o[0];
    localBeancurdMsg.startTime = anaz.gQ();
    localBeancurdMsg.validTime = 604800L;
    localBeancurdMsg.token = this.S[0];
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessageV2l receiveBeancurd:" + String.valueOf(localBeancurdMsg));
    }
    localwkh.a(localBeancurdMsg);
    return;
    label250:
    QLog.e("ChatActivityFacade.QZoneFeeds", 1, "当前获取到的feeds的发表人不匹配，忽略不插入");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.6
 * JD-Core Version:    0.7.0.1
 */