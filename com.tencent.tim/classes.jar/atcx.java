import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.tim.call.activity.CallActivity;

public class atcx
  extends accn
{
  public atcx(CallActivity paramCallActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (!aqft.equalsWithNullCheck(paramObject.uin, this.this$0.app.getCurrentAccountUin()))) {
        this.this$0.etd();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcx
 * JD-Core Version:    0.7.0.1
 */