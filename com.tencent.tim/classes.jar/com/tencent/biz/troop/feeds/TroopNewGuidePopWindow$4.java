package com.tencent.biz.troop.feeds;

import android.os.Handler;
import anot;
import apbo.b;
import aptr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import slz;

public class TroopNewGuidePopWindow$4
  implements Runnable
{
  public TroopNewGuidePopWindow$4(slz paramslz, JSONObject paramJSONObject, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    int j = 1;
    this.this$0.a = apbo.b.a(this.this$0.app, this.this$0.troopUin, this.val$data);
    this.this$0.aMa = this.aMb;
    String str1;
    if (this.this$0.a != null)
    {
      boolean bool = aptr.d(this.this$0.app, this.this$0.troopUin, this.this$0.a.feedId);
      aptr.aZ(this.this$0.app, this.this$0.troopUin);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "initViewInThread, isRead = " + bool + ", mTroopNotify. mTroopNotify.isShowTipWindow = " + this.this$0.a.cPJ + ", isRemindNotice = " + this.aMb);
      }
      if ((!this.this$0.a.cnY.equals(this.this$0.app.getCurrentUin())) && (((this.this$0.a.cPJ) && (!bool)) || (this.aMb)))
      {
        localObject = (TroopManager)this.this$0.app.getManager(52);
        str1 = "";
        if (localObject == null) {
          break label422;
        }
      }
    }
    label422:
    for (Object localObject = ((TroopManager)localObject).b(this.this$0.troopUin);; localObject = null)
    {
      if (localObject != null) {
        str1 = "" + ((TroopInfo)localObject).dwGroupClassExt;
      }
      localObject = this.this$0.app;
      String str2 = this.this$0.troopUin;
      if (this.this$0.a.cPK) {}
      for (int i = 2;; i = 1)
      {
        if (this.this$0.aMa) {
          j = 2;
        }
        anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X800AAC7", "0X800AAC7", 0, 0, str2, str1, String.valueOf(i), String.valueOf(j));
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "initViewInThread showing popup window for troopNotice");
        }
        this.this$0.mUIHandler.post(new TroopNewGuidePopWindow.4.1(this));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "initViewInThread, mTroopNotify is null!");
      }
      aptr.aZ(this.this$0.app, this.this$0.troopUin);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.4
 * JD-Core Version:    0.7.0.1
 */