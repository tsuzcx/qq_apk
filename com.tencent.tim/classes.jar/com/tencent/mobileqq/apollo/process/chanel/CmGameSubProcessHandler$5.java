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

public class CmGameSubProcessHandler$5
  extends ResultReceiver
{
  public CmGameSubProcessHandler$5(aboc paramaboc, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
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
        ((abos.a)localObject).cqw = 3;
        if ((localObject != null) && (((abos.a)localObject).bEw))
        {
          aboc.a(this.this$0, this.Od, 0, (abos.a)localObject);
          if (!((abos.a)localObject).state.equals("0")) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      aagd.a(((abos.a)localObject).listId, ((abos.a)localObject).uin, ((abos.a)localObject).cqx + "", Integer.parseInt(((abos.a)localObject).aNy), bool, false, aboc.a(this.this$0));
      return;
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleUpdateGameScore] launch is null");
      return;
      label210:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.5
 * JD-Core Version:    0.7.0.1
 */