import SummaryCardTaf.SSummaryCardRsp;
import android.annotation.TargetApi;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class wfs
  extends accn
{
  public wfs(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  @TargetApi(9)
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipProfileCardDiyActivity", 2, "CardObserver onSetCardTemplateReturn isSuccess : " + paramBoolean + ", obj : " + paramObject);
    }
    this.this$0.bF.set(false);
    this.this$0.a.removeMessages(6);
    this.this$0.bF();
    if ((paramBoolean) && (paramObject != null)) {
      if ((paramObject instanceof Card)) {
        ThreadManager.post(new VipProfileCardDiyActivity.4.1(this, (Card)paramObject), 5, null, true);
      }
    }
    for (;;)
    {
      this.this$0.aRS = null;
      this.this$0.bMM = 0;
      return;
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        QLog.e("VipProfileCardDiyActivity", 1, "set diy card failed, code=" + paramObject.first + ", msg=" + ((SSummaryCardRsp)paramObject.second).emsg);
        if (((Integer)paramObject.first).intValue() == 101107)
        {
          this.this$0.bMO = 1;
          this.this$0.a.obtainMessage(2, ((SSummaryCardRsp)paramObject.second).emsg).sendToTarget();
          if (VipUtils.cf(this.this$0.app)) {}
          for (paramObject = "3";; paramObject = "2")
          {
            VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C2", "", 1, 0, 0, "", paramObject, String.valueOf(this.this$0.bMM));
            break;
          }
        }
        if (((Integer)paramObject.first).intValue() == 101108)
        {
          this.this$0.bMO = 2;
          this.this$0.a.obtainMessage(2, ((SSummaryCardRsp)paramObject.second).emsg).sendToTarget();
          if (VipUtils.ce(this.this$0.app)) {}
          for (paramObject = "3";; paramObject = "2")
          {
            VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C2", "", 1, 0, 0, "", paramObject, String.valueOf(this.this$0.bMM));
            break;
          }
        }
        if (((Integer)paramObject.first).intValue() == 401019)
        {
          this.this$0.a.obtainMessage(8, ((SSummaryCardRsp)paramObject.second).emsg).sendToTarget();
        }
        else if (((Integer)paramObject.first).intValue() == 401020)
        {
          this.this$0.a.obtainMessage(7, ((SSummaryCardRsp)paramObject.second).emsg).sendToTarget();
        }
        else
        {
          if (((Integer)paramObject.first).intValue() == 401009)
          {
            this.this$0.bMO = 2;
            this.this$0.a.obtainMessage(2, ((SSummaryCardRsp)paramObject.second).emsg).sendToTarget();
            if (VipUtils.ce(this.this$0.app)) {}
            for (paramObject = "3";; paramObject = "2")
            {
              VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C2", "", 1, 0, 0, "", paramObject, String.valueOf(this.this$0.bMM));
              break;
            }
          }
          Message localMessage = this.this$0.a.obtainMessage(1);
          if ((((Integer)paramObject.first).intValue() >= 400000) && (((Integer)paramObject.first).intValue() <= 499999)) {
            localMessage.obj = ((SSummaryCardRsp)paramObject.second).emsg;
          }
          this.this$0.a.sendMessage(localMessage);
          continue;
          paramObject = this.this$0.a.obtainMessage(1);
          this.this$0.a.sendMessage(paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wfs
 * JD-Core Version:    0.7.0.1
 */