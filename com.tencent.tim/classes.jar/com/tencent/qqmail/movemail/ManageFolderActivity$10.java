package com.tencent.qqmail.movemail;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.protocol.DataCollector;

class ManageFolderActivity$10
  implements Runnable
{
  ManageFolderActivity$10(ManageFolderActivity paramManageFolderActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (ManageFolderActivity.access$600(this.this$0)) {}
    int i;
    for (Object localObject = "Event_Add_Tag";; localObject = "Event_Add_Folder")
    {
      DataCollector.logEvent((String)localObject);
      if ((!this.val$createRule) || (ManageFolderActivity.access$800(this.this$0) == null)) {
        break label132;
      }
      localObject = new String[ManageFolderActivity.access$800(this.this$0).length];
      i = 0;
      while (i < localObject.length)
      {
        localObject[i] = ManageFolderActivity.access$800(this.this$0)[i].getAddress();
        i += 1;
      }
    }
    for (;;)
    {
      QMMailManager localQMMailManager = QMMailManager.sharedInstance();
      i = ManageFolderActivity.access$500(this.this$0);
      String str = this.val$newFolderName;
      boolean bool = ManageFolderActivity.access$600(this.this$0);
      if (this.val$createRule) {}
      for (;;)
      {
        localQMMailManager.addFolder(i, str, bool, (String[])localObject);
        return;
        localObject = null;
      }
      label132:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.10
 * JD-Core Version:    0.7.0.1
 */