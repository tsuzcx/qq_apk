package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.mail.watcher.LoadAttachFolderListWatcher;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Iterator;

class ReadMailFragment$31
  implements LoadAttachFolderListWatcher
{
  ReadMailFragment$31(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(int paramInt, boolean paramBoolean, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "ReadMailFragment", "Check attachFolder list on error, accountId: " + paramInt + " checkUpdate: " + paramBoolean);
  }
  
  public void onProcess(int paramInt1, int paramInt2) {}
  
  public void onSuccess(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    QMLog.log(4, "ReadMailFragment", "Check attach folder list onSuccess, needUpdate: " + paramBoolean3 + "checkUpdate: " + paramBoolean2 + " folderLock: " + paramBoolean1);
    if (paramBoolean2) {
      if (paramBoolean3)
      {
        QMLog.log(4, "ReadMailFragment", "Check attachFolder list on success, check need update! accountId: " + paramInt);
        QMAttachManager.sharedInstance().loadAttachFolderList(paramInt);
      }
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = QMAttachManager.sharedInstance().getAttachList(ReadMailFragment.access$400(this.this$0));
      Object localObject = ReadMailFragment.access$000(this.this$0).getInformation().getAttachList();
      if ((localArrayList != null) && (localObject != null)) {
        if (localArrayList.size() != ((ArrayList)localObject).size()) {
          paramInt = 1;
        }
      }
      while (paramInt != 0)
      {
        ReadMailFragment.access$000(this.this$0).getInformation().setAttachList(localArrayList);
        Threads.runOnMainThread(new ReadMailFragment.31.1(this));
        return;
        localObject = ((ArrayList)localObject).iterator();
        label254:
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label256;
          }
          Attach localAttach = (Attach)((Iterator)localObject).next();
          Iterator localIterator = localArrayList.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (((Attach)localIterator.next()).getHashId() != localAttach.getHashId());
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0) {
              break label254;
            }
            paramInt = 1;
            break;
          }
        }
        label256:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.31
 * JD-Core Version:    0.7.0.1
 */