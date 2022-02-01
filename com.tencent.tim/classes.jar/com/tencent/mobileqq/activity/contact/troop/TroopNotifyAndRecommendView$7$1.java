package com.tencent.mobileqq.activity.contact.troop;

import acbn;
import android.view.View;
import anze;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import tog;
import ywk;
import yxx;
import yxz;

public class TroopNotifyAndRecommendView$7$1
  implements Runnable
{
  public TroopNotifyAndRecommendView$7$1(yxx paramyxx) {}
  
  public void run()
  {
    this.a.this$0.jdField_b_of_type_Ywk.gR(this.a.this$0.mDataList);
    this.a.this$0.jdField_b_of_type_Ywk.unreadMsgNum = anze.a().af(this.a.this$0.app);
    this.a.this$0.jdField_b_of_type_Ywk.notifyDataSetChanged();
    this.a.this$0.mDataList = yxz.de();
    this.a.this$0.jdField_b_of_type_Ackn.cxG = anze.a().af(this.a.this$0.app);
    if (this.a.this$0.isChecked) {
      this.a.this$0.app.a().G(acbn.bkT, 9000, 0 - anze.a().af(this.a.this$0.app));
    }
    this.a.this$0.gU(this.a.this$0.tz);
    this.a.this$0.gV(this.a.this$0.ty);
    if (!yxz.UM()) {
      this.a.this$0.aK(false, 2);
    }
    if (yxz.UL())
    {
      this.a.this$0.aK(true, 1);
      if ((!this.a.this$0.tz.isEmpty()) || (!this.a.this$0.tx.isEmpty()) || (!this.a.this$0.ty.isEmpty()) || (TroopNotifyAndRecommendView.b(this.a.this$0) == null)) {
        break label334;
      }
      TroopNotifyAndRecommendView.b(this.a.this$0).setVisibility(8);
    }
    label334:
    while (TroopNotifyAndRecommendView.b(this.a.this$0) == null)
    {
      return;
      this.a.this$0.aK(false, 1);
      break;
    }
    TroopNotifyAndRecommendView.b(this.a.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.7.1
 * JD-Core Version:    0.7.0.1
 */