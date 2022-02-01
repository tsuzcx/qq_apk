package com.tencent.mobileqq.teamwork;

import aoar;
import aobh;
import aocg;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$4
  implements Runnable
{
  public TeamWorkFileImportHandler$4(aoar paramaoar, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (this.this$0.app == null) {}
    do
    {
      return;
      localObject = aobh.b(this.bI, this.this$0.app.getCurrentAccountUin());
    } while (localObject == null);
    Object localObject = aocg.a((JSONObject)localObject);
    if ((localObject != null) && (((aocg)localObject).url != null) && (((aocg)localObject).isCache))
    {
      this.b.dNU = ((aocg)localObject).dNU;
      this.this$0.notifyUI(6, true, new Object[] { ((aocg)localObject).url, ((aocg)localObject).cjI, this.b });
      return;
    }
    this.this$0.notifyUI(7, false, new Object[] { this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.4
 * JD-Core Version:    0.7.0.1
 */