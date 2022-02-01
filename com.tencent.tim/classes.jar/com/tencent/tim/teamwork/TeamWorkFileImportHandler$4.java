package com.tencent.tim.teamwork;

import android.os.Handler;
import android.os.Message;
import aueh;
import aukx;
import com.tencent.mobileqq.app.QQAppInterface;
import jqc;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$4
  implements Runnable
{
  public TeamWorkFileImportHandler$4(aukx paramaukx, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (this.this$0.app == null) {}
    label141:
    for (;;)
    {
      return;
      Object localObject = jqc.a(this.bI, this.this$0.app.getCurrentAccountUin());
      if (localObject != null) {}
      for (boolean bool = this.this$0.a((String)localObject, this.d);; bool = false)
      {
        if (bool) {
          break label141;
        }
        if (aueh.fileExistsAndNotEmpty(this.d.filePath))
        {
          this.this$0.e(this.d);
          localObject = this.d;
          ((TeamWorkFileImportInfo)localObject).cKX = false;
          this.this$0.c((TeamWorkFileImportInfo)localObject);
          return;
        }
        if (aukx.a(this.this$0) == null) {
          break;
        }
        localObject = aukx.a(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.d;
        aukx.a(this.this$0).sendMessage((Message)localObject);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkFileImportHandler.4
 * JD-Core Version:    0.7.0.1
 */