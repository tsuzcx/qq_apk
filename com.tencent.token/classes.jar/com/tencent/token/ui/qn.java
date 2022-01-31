package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.EvalAccountResult.RecommendItem;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.util.ArrayList;

final class qn
  extends bo
{
  qn(MyProtecSubPageActivity paramMyProtecSubPageActivity)
  {
    super(paramMyProtecSubPageActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      this.a.dismissDialog();
      e.c("K_MSG_GETEVALACCOUNTRESULT");
      if (paramMessage.arg1 != 0)
      {
        d locald = (d)paramMessage.obj;
        MyProtecSubPageActivity.access$000(this.a, locald, paramMessage);
        return;
      }
      if (paramMessage.arg1 == 0)
      {
        MyProtecSubPageActivity.access$102(this.a, (EvalAccountResult)paramMessage.obj);
        LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
        int i = 0;
        while (i < MyProtecSubPageActivity.access$100(this.a).mRecommends.size())
        {
          paramMessage = (EvalAccountResult.RecommendItem)MyProtecSubPageActivity.access$100(this.a).mRecommends.get(i);
          if (paramMessage.mRecommendId == 3) {
            MyProtecSubPageActivity.access$200(this.a, paramMessage.mDetails);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qn
 * JD-Core Version:    0.7.0.1
 */