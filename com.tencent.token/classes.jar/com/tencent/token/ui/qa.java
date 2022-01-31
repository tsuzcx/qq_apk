package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.tencent.token.core.bean.AbnormalLoginMsgResult;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.EvalAccountResult.RecommendItem;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import java.util.ArrayList;

class qa
  extends cb
{
  qa(MyPswSubPageActivity paramMyPswSubPageActivity)
  {
    super(paramMyPswSubPageActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      this.a.dismissDialog();
      Object localObject;
      if (paramMessage.arg1 == 0)
      {
        paramMessage = (AbnormalLoginMsgResult)paramMessage.obj;
        localObject = new Intent(this.a, AbnormalLoginActivity.class);
        ((Intent)localObject).putExtra("msgs", paramMessage);
        this.a.startActivity((Intent)localObject);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      this.a.showUserDialog(paramMessage.c);
      return;
      this.a.dismissDialog();
      h.c("K_MSG_GETEVALACCOUNTRESULT");
      if (paramMessage.arg1 != 0)
      {
        localObject = (f)paramMessage.obj;
        MyPswSubPageActivity.access$000(this.a, (f)localObject, paramMessage);
        return;
      }
      if (paramMessage.arg1 == 0)
      {
        MyPswSubPageActivity.access$102(this.a, (EvalAccountResult)paramMessage.obj);
        LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
        int i = 0;
        while (i < MyPswSubPageActivity.access$100(this.a).mRecommends.size())
        {
          paramMessage = (EvalAccountResult.RecommendItem)MyPswSubPageActivity.access$100(this.a).mRecommends.get(i);
          if (paramMessage.mRecommendId == 2) {
            MyPswSubPageActivity.access$200(this.a, paramMessage.mDetails);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qa
 * JD-Core Version:    0.7.0.1
 */