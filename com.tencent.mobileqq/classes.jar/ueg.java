import android.annotation.TargetApi;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;

public class ueg
  extends CardObserver
{
  public ueg(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  @TargetApi(9)
  public void e(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipProfileCardDiyActivity", 2, "CardObserver onSetCardTemplateReturn isSuccess : " + paramBoolean + ", obj : " + paramObject);
    }
    this.a.b.set(false);
    this.a.a.removeMessages(6);
    this.a.i();
    if ((paramBoolean) && (paramObject != null)) {
      if ((paramObject instanceof Card)) {
        ThreadManager.post(new ueh(this, (Card)paramObject), 5, null, true);
      }
    }
    for (;;)
    {
      this.a.e = null;
      this.a.j = 0;
      return;
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        QLog.e("VipProfileCardDiyActivity", 1, "set diy card failed, code=" + paramObject.first + ", msg=" + (String)paramObject.second);
        if (((Integer)paramObject.first).intValue() == 101107)
        {
          this.a.n = 1;
          this.a.a.obtainMessage(2, paramObject.second).sendToTarget();
          if (VipUtils.b(this.a.app)) {}
          for (paramObject = "3";; paramObject = "2")
          {
            VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C2", "", 1, 0, 0, "", paramObject, String.valueOf(this.a.j));
            break;
          }
        }
        if (((Integer)paramObject.first).intValue() == 101108)
        {
          this.a.n = 2;
          this.a.a.obtainMessage(2, paramObject.second).sendToTarget();
          if (VipUtils.a(this.a.app)) {}
          for (paramObject = "3";; paramObject = "2")
          {
            VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C2", "", 1, 0, 0, "", paramObject, String.valueOf(this.a.j));
            break;
          }
        }
        if (((Integer)paramObject.first).intValue() == 401019)
        {
          this.a.a.obtainMessage(8, paramObject.second).sendToTarget();
        }
        else if (((Integer)paramObject.first).intValue() == 401020)
        {
          this.a.a.obtainMessage(7, paramObject.second).sendToTarget();
        }
        else
        {
          if (((Integer)paramObject.first).intValue() == 401009)
          {
            this.a.n = 2;
            this.a.a.obtainMessage(2, paramObject.second).sendToTarget();
            if (VipUtils.a(this.a.app)) {}
            for (paramObject = "3";; paramObject = "2")
            {
              VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C2", "", 1, 0, 0, "", paramObject, String.valueOf(this.a.j));
              break;
            }
          }
          Message localMessage = this.a.a.obtainMessage(1);
          if ((((Integer)paramObject.first).intValue() >= 400000) && (((Integer)paramObject.first).intValue() <= 499999)) {
            localMessage.obj = paramObject.second;
          }
          this.a.a.sendMessage(localMessage);
          continue;
          paramObject = this.a.a.obtainMessage(1);
          this.a.a.sendMessage(paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ueg
 * JD-Core Version:    0.7.0.1
 */