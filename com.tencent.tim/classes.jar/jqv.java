import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class jqv
  implements ausj.a
{
  jqv(ausj paramausj, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.t.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      anot.a(this.val$app, "CliOper", "", "", "0X8004655", "0X8004655", 0, 0, "", "", "", "");
      try
      {
        jqs.a(this.val$app, this.val$context, this.a, "IvrAIOMessageEngineFalse");
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("CrmUtils", 2, "Start ivr audio error", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqv
 * JD-Core Version:    0.7.0.1
 */