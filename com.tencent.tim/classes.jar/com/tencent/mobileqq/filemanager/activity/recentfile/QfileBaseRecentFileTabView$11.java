package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileBaseRecentFileTabView$11
  implements Runnable
{
  QfileBaseRecentFileTabView$11(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void run()
  {
    if ((this.this$0.a.akL()) && (this.this$0.R != null) && (this.this$0.R.size() > 0))
    {
      Iterator localIterator = this.this$0.R.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = ((List)this.this$0.R.get(localObject)).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((FileManagerEntity)((Iterator)localObject).next()).sendCloudUnsuccessful()) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
    this.this$0.refreshList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.11
 * JD-Core Version:    0.7.0.1
 */