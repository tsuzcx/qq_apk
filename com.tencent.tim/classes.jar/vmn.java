import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.qphone.base.util.QLog;

public class vmn
  extends adyq
{
  public vmn(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void aa(boolean paramBoolean, String paramString)
  {
    super.aa(paramBoolean, paramString);
  }
  
  public void ab(boolean paramBoolean, String paramString)
  {
    super.ab(paramBoolean, paramString);
  }
  
  public void k(boolean paramBoolean, String paramString, int paramInt)
  {
    super.k(paramBoolean, paramString, paramInt);
    if (paramBoolean)
    {
      BusinessCard localBusinessCard = ((adyp)this.this$0.app.getManager(112)).a(paramString);
      QLog.i("BusinessCard_observer_ProfileCardMoreActivity", 4, "onGetCardInfo success : cardId = " + paramString);
      this.this$0.a(localBusinessCard);
      this.this$0.a = localBusinessCard;
      return;
    }
    QLog.e("BusinessCard_observer_ProfileCardMoreActivity", 4, "onGetCardInfo faild : cardId = " + paramString);
  }
  
  public void l(boolean paramBoolean, String paramString, int paramInt)
  {
    super.l(paramBoolean, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vmn
 * JD-Core Version:    0.7.0.1
 */