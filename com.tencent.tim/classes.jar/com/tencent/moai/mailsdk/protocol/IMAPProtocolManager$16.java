package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.CheckMailCallback;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPMailboxInfo;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class IMAPProtocolManager$16
  extends BaseTask
{
  IMAPProtocolManager$16(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Map paramMap, CheckMailCallback paramCheckMailCallback)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    paramHandler = (IMAPHandler)paramHandler;
    ArrayList localArrayList1 = new ArrayList();
    if (this.val$folderMap.size() == 0)
    {
      if (this.val$checkMailCallback != null) {
        this.val$checkMailCallback.notSync();
      }
      return;
    }
    Iterator localIterator1 = this.val$folderMap.keySet().iterator();
    label59:
    Folder localFolder;
    Object localObject;
    long l1;
    while (localIterator1.hasNext())
    {
      localFolder = (Folder)localIterator1.next();
      localObject = paramHandler.select(localFolder.getPath());
      if (localObject != null)
      {
        ArrayList localArrayList2 = (ArrayList)this.val$folderMap.get(localFolder);
        new ArrayList();
        l1 = paramHandler.searchNewMsgNum((IMAPMailboxInfo)localObject);
        if (l1 > 0L) {
          if (localArrayList2.size() == 0)
          {
            localArrayList1.add(localFolder);
          }
          else
          {
            Logger.log(4, "IMAPProtocolManager", "exist:" + localArrayList2.size());
            Collections.sort(localArrayList2, new IMAPProtocolManager.16.1(this));
            localObject = paramHandler.search("UID " + (String)localArrayList2.get(0) + ":" + (String)localArrayList2.get(localArrayList2.size() - 1), true);
            Logger.log(4, "IMAPProtocolManager", "validExistUidList size:" + ((ArrayList)localObject).size());
            Iterator localIterator2 = ((ArrayList)localObject).iterator();
            do
            {
              if (!localIterator2.hasNext()) {
                break;
              }
            } while (localArrayList2.indexOf((String)localIterator2.next()) != -1);
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localArrayList1.add(localFolder);
        break label59;
      }
      if (((ArrayList)localObject).size() > 0)
      {
        long l2 = paramHandler.searchMsgNumByUid((String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1));
        Logger.log(4, "IMAPProtocolManager", "server:" + l1 + ", local:" + l2);
        if ((l2 <= 0L) || (l1 <= l2)) {
          break label59;
        }
        localArrayList1.add(localFolder);
        break label59;
      }
      localArrayList1.add(localFolder);
      break label59;
      Logger.log(4, "IMAPProtocolManager", "checkMail sync:" + localArrayList1.size());
      if (localArrayList1.size() > 0)
      {
        if (this.val$checkMailCallback == null) {
          break;
        }
        this.val$checkMailCallback.onSync(localArrayList1);
        return;
      }
      if (this.val$checkMailCallback == null) {
        break;
      }
      this.val$checkMailCallback.notSync();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.16
 * JD-Core Version:    0.7.0.1
 */