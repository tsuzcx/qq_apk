package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import aoar;
import aobk;
import aodb;
import com.tencent.mobileqq.app.QQAppInterface;

public class TeamWorkFileImportHandler$7
  implements Runnable
{
  public TeamWorkFileImportHandler$7(aoar paramaoar, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.b.srcUrl))) {
      aodb.Q("TeamWorkFileImportHandler", "import fail", "srcUrl is null or app is null", this.b.traceId);
    }
    for (;;)
    {
      return;
      Object localObject = aobk.b(this.b, this.this$0.app.getCurrentAccountUin());
      boolean bool = false;
      if (localObject != null) {
        bool = aoar.b(this.this$0, (String)localObject, this.b);
      }
      while ((!bool) && (aoar.a(this.this$0) != null))
      {
        localObject = aoar.a(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.b;
        aoar.a(this.this$0).sendMessage((Message)localObject);
        return;
        this.b.retCode = -1000;
        aodb.Q("TeamWorkFileImportHandler", "import fail", "url2doc network fail", this.b.traceId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.7
 * JD-Core Version:    0.7.0.1
 */