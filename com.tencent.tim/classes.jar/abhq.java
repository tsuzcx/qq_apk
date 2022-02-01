import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class abhq
  extends aquy
{
  abhq(abhh paramabhh) {}
  
  public void onDone(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (paramaquz.getStatus() == 3) {
      VipUtils.a(this.this$0.mApp, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.this$0.a != null) {
      this.this$0.a.cGn();
    }
  }
  
  public void onDoneFile(aquz paramaquz)
  {
    if (paramaquz == null) {}
    label314:
    label320:
    for (;;)
    {
      return;
      String str1 = paramaquz.currUrl;
      paramaquz = paramaquz.getParams();
      if (paramaquz != null)
      {
        paramaquz = (ApolloActionData)paramaquz.getSerializable(str1);
        if (paramaquz == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str2 = ApolloUtil.a(paramaquz, 4);
        if (str1.equals(ApolloUtil.a(paramaquz, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + paramaquz.actionId + " action name =" + paramaquz.actionName);
            }
            if (!ApolloUtil.aF(paramaquz.actionId, paramaquz.personNum))
            {
              aqhq.W(str2, ApolloUtil.a(paramaquz, 6), false);
              aqhq.deleteFile(str2);
              this.this$0.a(paramaquz);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ApolloManager", 2, "uncompressZip fail zip file: " + str2, localException);
              }
            }
          }
          if (paramaquz.compoundType <= 0) {
            break label314;
          }
        }
        for (boolean bool = ApolloUtil.b(paramaquz.actionId, 1, paramaquz.personNum, false);; bool = ApolloUtil.a(paramaquz))
        {
          if ((!bool) || (this.this$0.a == null)) {
            break label320;
          }
          paramaquz.status = 1;
          if (this.this$0.mApp != null) {
            ((abxk)this.this$0.mApp.getManager(155)).f(paramaquz);
          }
          this.this$0.a.g(paramaquz);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + paramaquz.actionId + " action name =" + paramaquz.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhq
 * JD-Core Version:    0.7.0.1
 */