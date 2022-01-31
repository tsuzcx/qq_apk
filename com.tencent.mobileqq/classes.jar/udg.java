import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.RequestPublicAccountObserver;

public class udg
  extends TroopBindPubAccountProtocol.RequestPublicAccountObserver
{
  public udg(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if ((paramBoolean) && (paramAccountDetail != null))
    {
      this.a.k.setText(paramAccountDetail.name);
      this.a.b.setVisibility(0);
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     udg
 * JD-Core Version:    0.7.0.1
 */