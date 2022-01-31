package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class po
  implements Handler.Callback
{
  po(pg parampg) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      if ((pg.a(this.a) != null) && (!((BaseActivity)pg.a(this.a)).isFinishing()))
      {
        h.a("Callback=" + paramMessage.arg1);
        if (paramMessage.arg1 == 270)
        {
          ((BaseActivity)pg.a(this.a)).dismissDialog();
          paramMessage = (UpgradeDeterminResult)((f)paramMessage.obj).d;
          h.a("mSmsPrefix=" + paramMessage.mSmsPrefix);
          h.a("mMobileMask=" + paramMessage.mMobileMask);
          QQUser localQQUser = do.a().e();
          h.a("currentUser=" + localQQUser);
          Intent localIntent = new Intent(pg.a(this.a), VryMobileForStrategyActivity.class);
          localIntent.setFlags(536870912);
          localIntent.putExtra("intent.qquser", localQQUser);
          localIntent.putExtra("page_id", 13);
          localIntent.putExtra("intent.upgradedetermin", paramMessage);
          pg.a(this.a).startActivity(localIntent);
          this.a.b();
          return true;
        }
        return false;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.po
 * JD-Core Version:    0.7.0.1
 */