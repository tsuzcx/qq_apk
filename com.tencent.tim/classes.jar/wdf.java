import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.data.AccountDetail;

public class wdf
  extends aprz.b
{
  public wdf(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if ((paramBoolean) && (paramAccountDetail != null))
    {
      this.this$0.GF.setText(paramAccountDetail.name);
      this.this$0.gK.setVisibility(0);
      this.this$0.bXs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wdf
 * JD-Core Version:    0.7.0.1
 */