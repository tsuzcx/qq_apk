package com.tencent.mobileqq.teamwork;

import aoar;
import aobh;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$5
  implements Runnable
{
  public TeamWorkFileImportHandler$5(aoar paramaoar, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (this.this$0.app == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = aobh.c(this.bI, this.this$0.app.getCurrentAccountUin());
    } while (localJSONObject == null);
    aoar.a(this.this$0, localJSONObject, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.5
 * JD-Core Version:    0.7.0.1
 */