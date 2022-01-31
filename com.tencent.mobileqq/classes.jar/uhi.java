import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class uhi
  extends CardObserver
{
  public uhi(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, "onCardDownload() isSuccess = " + paramBoolean + "  data:" + paramObject);
    }
    if (paramObject == null) {}
    Card localCard;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!(paramObject instanceof Card)));
      localCard = (Card)paramObject;
    } while ((localCard.uin == null) || (!localCard.uin.equals(this.a.b)));
    TroopRequestActivity.a(this.a, (Card)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uhi
 * JD-Core Version:    0.7.0.1
 */