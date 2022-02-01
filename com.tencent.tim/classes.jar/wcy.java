import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class wcy
  implements View.OnClickListener
{
  public wcy(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    acmb localacmb = (acmb)this.this$0.app.getBusinessHandler(26);
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (!TextUtils.isEmpty(this.this$0.mUserUin)) {
        localArrayList.add(Long.valueOf(Long.parseLong(this.this$0.mUserUin)));
      }
      localacmb.aj(localArrayList);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.TroopRequestActivity", 2, "delete Stranger parseLong() error", localNumberFormatException);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcy
 * JD-Core Version:    0.7.0.1
 */