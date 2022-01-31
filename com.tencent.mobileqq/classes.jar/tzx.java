import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;

public class tzx
  implements View.OnClickListener
{
  public tzx(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.d;
    TroopNoticeJsHandler.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tzx
 * JD-Core Version:    0.7.0.1
 */