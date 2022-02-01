package com.tencent.tim.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import aukx;
import com.tencent.mobileqq.app.QQAppInterface;
import jqc;

public class TeamWorkFileImportHandler$3
  implements Runnable
{
  public TeamWorkFileImportHandler$3(aukx paramaukx, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.d.filePath))) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (this.this$0.b(jqc.dU(this.d.filePath), this.d));
      localObject = jqc.J(this.d.filePath, this.this$0.app.getCurrentAccountUin());
      bool = false;
      if (localObject != null) {
        bool = this.this$0.a((String)localObject, this.d);
      }
    } while ((bool) || (aukx.a(this.this$0) == null));
    Object localObject = aukx.a(this.this$0).obtainMessage(8002);
    ((Message)localObject).obj = this.d;
    aukx.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkFileImportHandler.3
 * JD-Core Version:    0.7.0.1
 */