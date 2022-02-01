package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import anot;
import aoar;
import aobk;
import aodb;
import com.tencent.mobileqq.app.QQAppInterface;

public class TeamWorkFileImportHandler$2
  implements Runnable
{
  public TeamWorkFileImportHandler$2(aoar paramaoar, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    boolean bool = false;
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.b.filePath))) {}
    for (;;)
    {
      return;
      Object localObject = aobk.a(this.b, this.this$0.app.getCurrentAccountUin());
      if (localObject != null)
      {
        bool = aoar.a(this.this$0, (String)localObject, this.b);
        if (!bool) {
          break label163;
        }
        anot.a(this.this$0.app, "dc00898", "", "", "0X80098F9", "0X80098F9", 0, 0, "", "", "", "");
      }
      label163:
      while ((!bool) && (aoar.a(this.this$0) != null))
      {
        localObject = aoar.a(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.b;
        aoar.a(this.this$0).sendMessage((Message)localObject);
        return;
        aodb.Q("TeamWorkFileImportHandler", "import fail", "local file dataLine parse no result string", this.b.traceId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.2
 * JD-Core Version:    0.7.0.1
 */