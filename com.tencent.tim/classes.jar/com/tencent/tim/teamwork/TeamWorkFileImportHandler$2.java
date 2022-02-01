package com.tencent.tim.teamwork;

import android.os.Handler;
import android.os.Message;
import anot;
import aueh;
import aukx;
import aulk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$2
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.app == null) || (this.d == null)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = aulk.a(this.bI, this.d, this.this$0.app.getCurrentAccountUin());
    long l2 = System.currentTimeMillis();
    if (this.d.dNT != this.dNO)
    {
      QLog.w("TeamWorkFileImportHandler", 2, "this job has dropped " + this.dNO);
      return;
    }
    Object localObject3 = "";
    if (localObject1 != null) {}
    for (boolean bool = this.this$0.c((String)localObject1, this.d);; bool = false)
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
          if (this.d.nFileType == 6)
          {
            localObject2 = "excel";
          }
          else if (this.d.nFileType == 7)
          {
            localObject2 = "ppt";
          }
          else if (this.d.nFileType == 9)
          {
            localObject2 = "pdf";
            continue;
            label341:
            i = 2;
          }
        }
      }
      localObject1 = "其他";
      if (this.d.nFileType == 3)
      {
        localObject1 = "word";
        localQQAppInterface = this.this$0.app;
        if (!bool) {
          break label341;
        }
        i = 1;
        anot.a(localQQAppInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i, l2 - l1 + "", "", (String)localObject1, (String)localObject3);
        if (bool) {
          break;
        }
        if (!aueh.fileExistsAndNotEmpty(this.d.filePath)) {
          break label346;
        }
        this.this$0.e(this.d);
        localObject1 = this.d;
        ((TeamWorkFileImportInfo)localObject1).cKX = false;
        this.this$0.c((TeamWorkFileImportInfo)localObject1);
        return;
      }
      label346:
      if (aukx.a(this.this$0) == null) {
        break;
      }
      Object localObject2 = aukx.a(this.this$0).obtainMessage(8002);
      ((Message)localObject2).obj = this.d;
      aukx.a(this.this$0).sendMessage((Message)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkFileImportHandler.2
 * JD-Core Version:    0.7.0.1
 */