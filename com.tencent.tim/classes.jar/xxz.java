import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class xxz
  implements ausj.a
{
  xxz(xxt paramxxt, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.cancel();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramView = this.this$0.sessionInfo.aTl;
      } while ((this.this$0.a() == null) || (this.this$0.sessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.this$0.app == null));
      try
      {
        localObject1 = stj.encrypt(paramView, stj.cm(2));
        if (QLog.isColorLevel()) {
          QLog.i(this.this$0.TAG, 2, "openMoreOptions uin:" + paramView + " uinCode:" + (String)localObject1);
        }
        localObject2 = this.this$0.cF();
        Object localObject3 = new ArrayList();
        if (localObject2 != null) {
          ((List)localObject3).addAll((Collection)localObject2);
        }
        localObject2 = stj.a(paramView, this.this$0.app.getCurrentAccountUin(), 21002, 10, (List)localObject3);
        localObject3 = ((String)localObject2).replaceAll(paramView, (String)localObject1);
        Bundle localBundle = stj.a(this.this$0.sessionInfo);
        if (QLog.isColorLevel()) {
          QLog.i(this.this$0.TAG, 2, "openMoreOptions safetyReport reportMsgOrg: " + (String)localObject2 + "  reportMsg: " + (String)localObject3);
        }
        stj.a(this.this$0.a(), paramView, (String)localObject1, null, null, this.this$0.app.getCurrentAccountUin(), 21002, (String)localObject3, localBundle);
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          QLog.e(this.this$0.TAG, 1, "openMoreOptions safetyReport error" + paramView.getMessage());
        }
      }
      anot.a(this.this$0.app, "dc00898", "", "", "0X80091A4", "0X80091A4", 0, 0, "", "", "", "");
      return;
      paramView = this.this$0.sessionInfo.aTl;
    } while ((this.this$0.a() == null) || (this.this$0.sessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.this$0.app == null));
    Object localObject1 = (aegq)this.this$0.app.getBusinessHandler(125);
    Object localObject2 = ((aegs)this.this$0.app.getManager(269)).b();
    if (localObject2 == null) {}
    for (paramInt = 24;; paramInt = ((aegp)localObject2).cMK)
    {
      ((aegq)localObject1).a(paramView, this.this$0.sessionInfo.cZ, this.this$0.sessionInfo.topicId, this.this$0.a, paramInt);
      this.this$0.q(0, aegp.bwT, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxz
 * JD-Core Version:    0.7.0.1
 */