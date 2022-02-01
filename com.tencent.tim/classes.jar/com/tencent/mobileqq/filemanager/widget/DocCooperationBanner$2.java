package com.tencent.mobileqq.filemanager.widget;

import ahcw;
import aobh;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DocCooperationBanner$2
  implements Runnable
{
  public DocCooperationBanner$2(ahcw paramahcw, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    Object localObject = "";
    String str1 = "";
    String str2;
    String str3;
    if (this.b.peerType == 0)
    {
      str1 = this.b.peerUin;
      str2 = this.b.fileName;
      str3 = this.val$url;
      if (!this.cfC) {
        break label89;
      }
    }
    label89:
    for (int i = 2;; i = 1)
    {
      localObject = aobh.a(str2, str3, i, (String)localObject, str1, this.val$uin);
      if (localObject != null) {
        QLog.i("DocCooperationBanner", 2, ((JSONObject)localObject).toString());
      }
      return;
      localObject = this.b.peerUin;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.DocCooperationBanner.2
 * JD-Core Version:    0.7.0.1
 */