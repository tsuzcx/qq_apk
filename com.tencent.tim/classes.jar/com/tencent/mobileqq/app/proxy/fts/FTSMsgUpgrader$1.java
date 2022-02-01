package com.tencent.mobileqq.app.proxy.fts;

import acxu;
import acxz;
import acya;
import acyc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;

public class FTSMsgUpgrader$1
  implements Runnable
{
  public FTSMsgUpgrader$1(acya paramacya) {}
  
  public void run()
  {
    if ((!acya.a(this.this$0)) && (acya.a(this.this$0).a().hasInit()))
    {
      if ((acya.a(this.this$0) != null) && (acya.a(this.this$0).hasInit()))
      {
        if (!this.this$0.bKl) {
          acya.a(this.this$0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle hasReadNativeCursor = " + this.this$0.bKl + " mUpgradeCursor=" + acya.a(this.this$0) + " mUpgradeMaxIndex=" + acya.b(this.this$0));
        }
        if (this.this$0.bKl)
        {
          if (acya.a(this.this$0) >= acya.b(this.this$0)) {
            break label201;
          }
          if (!acya.b(this.this$0)) {
            break label186;
          }
          acya.a(this.this$0).postDelayed(this, 20L);
        }
        label186:
        while (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "writeNativeIndex failed");
        return;
        label201:
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade compeleted in handler");
        }
        acya.b(this.this$0);
        acya.a(this.this$0).cOQ();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("upgrade history in handle mDatabase = ");
      if (acya.a(this.this$0) == null) {}
      for (String str = "null";; str = "@@@")
      {
        QLog.d("Q.fts.FTSMsgUpgrader", 1, str);
        return;
      }
    }
    QLog.d("Q.fts.FTSMsgUpgrader", 1, "upgrade history in handle isDestroy = " + acya.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSMsgUpgrader.1
 * JD-Core Version:    0.7.0.1
 */