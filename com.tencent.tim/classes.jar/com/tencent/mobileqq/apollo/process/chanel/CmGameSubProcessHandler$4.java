package com.tencent.mobileqq.apollo.process.chanel;

import aagd;
import abmt;
import aboc;
import abos;
import abos.a;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class CmGameSubProcessHandler$4
  extends ResultReceiver
{
  public CmGameSubProcessHandler$4(aboc paramaboc, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = abmt.a(aboc.a(this.this$0));
    if (localObject != null)
    {
      localObject = ((abos)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((abos.a)localObject).state = paramBundle.getString("state", "-1");
          ((abos.a)localObject).aNy = paramBundle.getString("amount", "0");
        }
        aboc.a(this.this$0, this.Od, 0, (abos.a)localObject);
        if (!"0".equals(((abos.a)localObject).state)) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      aagd.a(((abos.a)localObject).listId, ((abos.a)localObject).uin, ((abos.a)localObject).cqx + "", Integer.parseInt(((abos.a)localObject).aNy), bool, false, aboc.a(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.4
 * JD-Core Version:    0.7.0.1
 */