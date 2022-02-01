package com.tencent.tim.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import anot;
import aukx;
import aulk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$1
  implements Runnable
{
  public TeamWorkFileImportHandler$1(aukx paramaukx, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (this.d == null) || (TextUtils.isEmpty(this.d.filePath))) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = aulk.a(this.d, this.this$0.app.getCurrentAccountUin());
    long l2 = System.currentTimeMillis();
    Object localObject2 = "";
    if (localObject1 != null) {}
    for (boolean bool = this.this$0.c((String)localObject1, this.d);; bool = false)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).getString("url");
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QQAppInterface localQQAppInterface;
          int i;
          QLog.e("TeamWorkFileImportHandler", 1, localException.toString());
          continue;
          String str;
          if (this.d.nFileType == 6)
          {
            str = "excel";
          }
          else if (this.d.nFileType == 7)
          {
            str = "ppt";
          }
          else if (this.d.nFileType == 9)
          {
            str = "pdf";
            continue;
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
          continue;
        }
        i = 1;
        anot.a(localQQAppInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i, l2 - l1 + "", "", (String)localObject1, (String)localObject2);
        if ((bool) || (aukx.a(this.this$0) == null)) {
          break;
        }
        localObject1 = aukx.a(this.this$0).obtainMessage(8002);
        ((Message)localObject1).obj = this.d;
        aukx.a(this.this$0).sendMessage((Message)localObject1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkFileImportHandler.1
 * JD-Core Version:    0.7.0.1
 */