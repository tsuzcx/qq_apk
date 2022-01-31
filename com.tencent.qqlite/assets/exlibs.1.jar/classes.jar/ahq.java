import android.content.Intent;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class ahq
  extends CardObserver
{
  public ahq(DetailProfileActivity paramDetailProfileActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (this.a.app.a().equals(paramObject.uin)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DetailProfileActivity", 2, "on my card download");
        }
        this.a.a(paramObject);
      }
      return;
    }
  }
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DetailProfileActivity", 2, "onGetDetailInfo, isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (paramCard != null) && (this.a.app.a().equals(paramCard.uin))) {
      this.a.a(paramCard);
    }
  }
  
  protected void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DetailProfileActivity", 2, "onGetLocationDescription, isSuccess = " + paramBoolean + ", card = ");
    }
    if ((paramBoolean) && (paramString.equals(this.a.app.a())) && (paramCard != null)) {
      this.a.a(paramCard);
    }
  }
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    this.a.a();
    if ((!paramBoolean) || (paramInt != 0))
    {
      int i = 2131364484;
      if (paramInt == 36) {
        i = 2131364485;
      }
      this.a.a(i, 1);
      return;
    }
    DetailProfileActivity.a(this.a);
    this.a.finish();
    this.a.overridePendingTransition(0, 2130968584);
    paramCard = new Intent();
    paramCard.putExtra("changed", true);
    this.a.setResult(-1, paramCard);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ahq
 * JD-Core Version:    0.7.0.1
 */