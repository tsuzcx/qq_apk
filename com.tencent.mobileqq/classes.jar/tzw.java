import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class tzw
  implements View.OnClickListener
{
  public tzw(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (StrangerHandler)this.a.app.a(26);
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (!TextUtils.isEmpty(this.a.b)) {
        localArrayList.add(Long.valueOf(Long.parseLong(this.a.b)));
      }
      paramView.a(localArrayList);
      return;
    }
    catch (NumberFormatException paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.systemmsg.TroopRequestActivity", 2, "delete Stranger parseLong() error", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tzw
 * JD-Core Version:    0.7.0.1
 */