import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class uic
  implements ausj.a
{
  public uic(BaseChatPie paramBaseChatPie, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      do
      {
        for (;;)
        {
          return;
          anot.a(this.this$0.app, "CliOper", "", this.this$0.sessionInfo.aTl, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
          anot.a(null, "dc00898", "", "", "0X800ACA3", "0X800ACA3", 0, 0, "", "0", "0", "");
          paramView = (acmb)this.this$0.app.getBusinessHandler(26);
          ArrayList localArrayList = new ArrayList();
          try
          {
            localArrayList.add(Long.valueOf(Long.parseLong(this.this$0.sessionInfo.aTl)));
            paramView.aj(localArrayList);
            if (this.this$0.a == null) {
              this.this$0.a = new arhz(this.this$0.mContext, 0);
            }
            this.this$0.a.show();
          }
          catch (NumberFormatException paramView) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.this$0.TAG, 2, "delete Stranger parseLong() error", paramView);
      return;
      paramView = new Intent(this.this$0.mActivity, QQBrowserActivity.class);
      paramView.putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=" + this.this$0.sessionInfo.aTl);
      this.this$0.mActivity.startActivity(paramView);
      anot.a(null, "dc00898", "", "", "0X800ACA4", "0X800ACA4", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uic
 * JD-Core Version:    0.7.0.1
 */