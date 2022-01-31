package com.tencent.token.ui;

import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class lp
  implements Handler.Callback
{
  lp(IndexActivity paramIndexActivity) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    e.a("Callback=" + paramMessage.arg1);
    if (paramMessage.arg1 == 270)
    {
      this.a.dismissDialog();
      paramMessage = (UpgradeDeterminResult)((d)paramMessage.obj).d;
      e.a("mSmsPrefix=" + paramMessage.mSmsPrefix);
      e.a("mMobileMask=" + paramMessage.mMobileMask);
      QQUser localQQUser = ax.a().e();
      e.a("currentUser=" + localQQUser);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.lp
 * JD-Core Version:    0.7.0.1
 */