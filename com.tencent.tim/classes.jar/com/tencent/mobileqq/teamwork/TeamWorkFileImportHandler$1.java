package com.tencent.mobileqq.teamwork;

import acfp;
import aeul;
import aeum;
import android.os.Handler;
import android.os.Message;
import anot;
import aoar;
import aobk;
import aobw;
import aodb;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$1
  implements Runnable
{
  public TeamWorkFileImportHandler$1(aoar paramaoar, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    boolean bool2 = aqhq.fileExistsAndNotEmpty(this.b.filePath);
    boolean bool1;
    if (!bool2)
    {
      bool1 = false;
      if ((this.this$0.app != null) && (bool2) && (bool1)) {
        break label178;
      }
      aodb.Q("TeamWorkFileImportHandler", "import fail", "filePath is null or app is null", this.b.traceId);
      if (aoar.a(this.this$0) != null)
      {
        localObject1 = aoar.a(this.this$0).obtainMessage(8002);
        ((Message)localObject1).obj = this.b;
        if (bool2) {
          break label156;
        }
        this.b.cjF = BaseApplicationImpl.getApplication().getString(2131720922);
      }
    }
    for (;;)
    {
      aoar.a(this.this$0).sendMessage((Message)localObject1);
      return;
      bool1 = aobw.a(aeum.a().ag(), this.b.filePath, this.b.fileName, this.b.fileSize);
      break;
      label156:
      if (!bool1) {
        this.b.cjF = BaseApplicationImpl.getApplication().getString(2131720915);
      }
    }
    label178:
    long l1 = System.currentTimeMillis();
    Object localObject1 = aobk.a(this.b, this.this$0.app.getCurrentAccountUin());
    long l2 = System.currentTimeMillis();
    Object localObject2 = "";
    if (localObject1 != null)
    {
      bool1 = aoar.a(this.this$0, (String)localObject1, this.b);
      try
      {
        localObject1 = new JSONObject((String)localObject1).getString("url");
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label250:
          QQAppInterface localQQAppInterface;
          int j;
          QLog.e("TeamWorkFileImportHandler", 1, localException.toString());
        }
      }
      localObject1 = acfp.m(2131715195);
      if (this.b.nFileType != 3) {
        break label440;
      }
      localObject1 = "word";
      label272:
      localQQAppInterface = this.this$0.app;
      j = this.b.dNQ;
      if (!bool1) {
        break label497;
      }
    }
    label440:
    label497:
    for (int i = 1;; i = 2)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009955", "0X8009955", j, i, l2 - l1 + "", "", (String)localObject1, (String)localObject2);
      if ((bool1) || (aoar.a(this.this$0) == null)) {
        break;
      }
      localObject1 = aoar.a(this.this$0).obtainMessage(8002);
      ((Message)localObject1).obj = this.b;
      aoar.a(this.this$0).sendMessage((Message)localObject1);
      return;
      this.b.retCode = -1000;
      aodb.Q("TeamWorkFileImportHandler", "import fail", "local file network fail", this.b.traceId);
      bool1 = false;
      break label250;
      if (this.b.nFileType == 6)
      {
        str = "excel";
        break label272;
      }
      if (this.b.nFileType == 7)
      {
        str = "ppt";
        break label272;
      }
      if (this.b.nFileType != 9) {
        break label272;
      }
      String str = "pdf";
      break label272;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.1
 * JD-Core Version:    0.7.0.1
 */