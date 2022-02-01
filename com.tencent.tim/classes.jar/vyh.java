import android.view.View;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class vyh
  implements ausj.a
{
  public vyh(TroopAssistantActivity paramTroopAssistantActivity, int paramInt, String paramString, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      if (this.this$0.a == null) {
        this.this$0.a = new arib(this.this$0);
      }
      this.this$0.a.aq(2, 2131696272, 1500);
    }
    try
    {
      if (this.val$sheet != null) {
        this.val$sheet.dismiss();
      }
      return;
      int i = -1;
      switch (paramInt)
      {
      default: 
        paramInt = i;
      }
      while (paramInt != this.bFQ)
      {
        this.this$0.app.b(this.Uf, Integer.valueOf(paramInt));
        break;
        paramInt = 1;
        continue;
        paramInt = 4;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
      }
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopAssistantActivity", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyh
 * JD-Core Version:    0.7.0.1
 */