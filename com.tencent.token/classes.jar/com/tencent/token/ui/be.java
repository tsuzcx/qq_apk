package com.tencent.token.ui;

import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class be
  implements Handler.Callback
{
  be(BaseActivity paramBaseActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    h.a("Callback=" + paramMessage.arg1);
    try
    {
      if (paramMessage.arg1 == 270)
      {
        this.a.dismissDialog();
        paramMessage = (UpgradeDeterminResult)((f)paramMessage.obj).d;
        h.a("mSmsPrefix=" + paramMessage.mSmsPrefix);
        h.a("mMobileMask=" + paramMessage.mMobileMask);
        QQUser localQQUser = do.a().e();
        h.a("currentUser=" + localQQUser);
        Intent localIntent = new Intent(this.a, VryMobileForStrategyActivity.class);
        localIntent.setFlags(536870912);
        localIntent.putExtra("intent.qquser", localQQUser);
        localIntent.putExtra("page_id", 13);
        localIntent.putExtra("intent.upgradedetermin", paramMessage);
        this.a.startActivity(localIntent);
        return true;
      }
      return false;
    }
    catch (Exception paramMessage) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.be
 * JD-Core Version:    0.7.0.1
 */