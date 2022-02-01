package com.tencent.mobileqq.teamwork;

import acfp;
import ahbj;
import android.os.Handler;
import android.os.Message;
import anot;
import aoar;
import aobk;
import aodb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$11
  implements Runnable
{
  public TeamWorkFileImportHandler$11(aoar paramaoar, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, JSONObject paramJSONObject, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (this.b == null)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = aobk.a(this.bI, this.b, this.this$0.app.getCurrentAccountUin());
    long l2 = System.currentTimeMillis();
    if (this.b.dNT != this.dNO)
    {
      QLog.w("TeamWorkFileImportHandler", 2, "this job has dropped " + this.dNO);
      return;
    }
    Object localObject3 = "";
    if (localObject1 != null) {}
    for (boolean bool = this.this$0.c((String)localObject1, this.b);; bool = false)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).getString("url");
        localObject3 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QQAppInterface localQQAppInterface;
          int i;
          QLog.e("TeamWorkFileImportHandler", 1, localException.toString());
          continue;
          if (this.b.nFileType == 6)
          {
            localObject2 = "excel";
          }
          else if (this.b.nFileType == 7)
          {
            localObject2 = "ppt";
          }
          else if (this.b.nFileType == 9)
          {
            localObject2 = "pdf";
            continue;
            label364:
            i = 2;
          }
        }
      }
      localObject1 = acfp.m(2131715202);
      if (this.b.nFileType == 3)
      {
        localObject1 = "word";
        l1 = l2 - l1;
        localQQAppInterface = this.this$0.app;
        if (!bool) {
          break label364;
        }
        i = 1;
        anot.a(localQQAppInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i, l1 + "", "", (String)localObject1, (String)localObject3);
        aodb.Q("TeamWorkFileImportHandler", "http duration", String.valueOf(l1), this.b.traceId);
        if (bool) {
          break;
        }
        if (!ahbj.fileExistsAndNotEmpty(this.b.filePath)) {
          break label369;
        }
        this.this$0.l(this.b);
        localObject1 = this.b;
        ((TeamWorkFileImportInfo)localObject1).cKX = false;
        this.this$0.j((TeamWorkFileImportInfo)localObject1);
        return;
      }
      label369:
      if (aoar.a(this.this$0) == null) {
        break;
      }
      Object localObject2 = aoar.a(this.this$0).obtainMessage(8002);
      ((Message)localObject2).obj = this.b;
      aoar.a(this.this$0).sendMessage((Message)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.11
 * JD-Core Version:    0.7.0.1
 */