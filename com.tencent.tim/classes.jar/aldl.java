import SummaryCardTaf.SSummaryCardRsp;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity.2.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aldl
  extends accn
{
  public aldl(VipProfileCardBaseActivity paramVipProfileCardBaseActivity) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "CardObserver onSetCardTemplateReturn isSuccess : " + paramBoolean + ", obj : " + paramObject);
    }
    String str = this.this$0.app.getCurrentAccountUin();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_BackgroundId", String.valueOf(this.this$0.dsk));
    localHashMap.put("param_StyleId", String.valueOf(this.this$0.agu));
    this.this$0.mHandler.removeCallbacks(this.this$0.mDismissRunnable);
    this.this$0.bF();
    if ((paramBoolean) && (paramObject != null))
    {
      if ((paramObject instanceof Card)) {
        ThreadManager.post(new VipProfileCardBaseActivity.2.1(this, (Card)paramObject, localHashMap, str), 5, null, true);
      }
      while (!(paramObject instanceof Pair)) {
        return;
      }
      paramObject = (Pair)paramObject;
      Message localMessage;
      if (((Integer)paramObject.first).intValue() == 101107)
      {
        this.this$0.dsf = 1;
        this.this$0.dsi = 2;
        localMessage = this.this$0.mHandler.obtainMessage(9);
        this.this$0.mHandler.sendMessage(localMessage);
      }
      for (;;)
      {
        localHashMap.put("param_FailCode", String.valueOf(paramObject.first));
        anpc.a(this.this$0.app.getApp()).collectPerformance(str, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
        return;
        if (((Integer)paramObject.first).intValue() == 101108)
        {
          this.this$0.dsf = 2;
          this.this$0.dsi = 5;
          localMessage = this.this$0.mHandler.obtainMessage(9);
          this.this$0.mHandler.sendMessage(localMessage);
        }
        else
        {
          localMessage = this.this$0.mHandler.obtainMessage(6);
          if ((((Integer)paramObject.first).intValue() >= 400000) && (((Integer)paramObject.first).intValue() <= 499999)) {
            localMessage.obj = ((SSummaryCardRsp)paramObject.second).emsg;
          }
          this.this$0.mHandler.sendMessage(localMessage);
        }
      }
    }
    if (!paramBoolean) {}
    for (paramObject = "-104";; paramObject = "-105")
    {
      localHashMap.put("param_FailCode", paramObject);
      anpc.a(this.this$0.app.getApp()).collectPerformance(str, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
      paramObject = this.this$0.mHandler.obtainMessage(6);
      this.this$0.mHandler.sendMessage(paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldl
 * JD-Core Version:    0.7.0.1
 */