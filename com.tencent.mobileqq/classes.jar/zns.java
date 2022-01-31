import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.GetNearbyRecommender;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class zns
  extends CardObserver
{
  public zns(GetNearbyRecommender paramGetNearbyRecommender) {}
  
  protected void c(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetNearbyRecommender onGetDetailInfo|uin=" + paramString);
    }
    if (!GetNearbyRecommender.a(this.a).b.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zns
 * JD-Core Version:    0.7.0.1
 */