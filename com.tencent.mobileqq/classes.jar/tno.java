import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class tno
  extends CardObserver
{
  public tno(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (this.a.app.getCurrentAccountUin().equals(((Card)paramObject).uin))) {
      QQSettingSettingActivity.a(this.a, (Card)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tno
 * JD-Core Version:    0.7.0.1
 */