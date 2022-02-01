package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.MailListCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.protocol.pop3.POP3Handler;
import com.tencent.moai.mailsdk.protocol.pop3.POP3MsgUID;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class POP3ProtocolManager$1
  extends BaseTask
{
  POP3ProtocolManager$1(POP3ProtocolManager paramPOP3ProtocolManager, String paramString, Profile paramProfile, State paramState, Folder paramFolder, MailListCallBack paramMailListCallBack)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    Object localObject2 = (POP3Handler)paramHandler;
    ArrayList localArrayList1 = new ArrayList();
    paramHandler = POP3ProtocolManager.access$000(this.this$0, this.val$profile);
    ArrayList localArrayList2 = this.val$state.getExistUidList();
    Object localObject3 = this.val$state.getDeleteUidList();
    Logger.log(4, "POP3ProtocolManager", "fetch mail list last:" + paramHandler.size() + " exist:" + localArrayList2.size() + " delete:" + ((ArrayList)localObject3).size());
    ArrayList localArrayList3 = ((POP3Handler)localObject2).list();
    Object localObject1 = ((POP3Handler)localObject2).uidl();
    if (POP3ProtocolManager.access$100(this.this$0, this.val$profile, (ArrayList)localObject1, (POP3Handler)localObject2).equals("aesc")) {
      Collections.reverse((List)localObject1);
    }
    Logger.log(4, "POP3ProtocolManager", "fetch mail list uidl size:" + ((ArrayList)localObject1).size());
    if (paramHandler.isEmpty()) {
      paramHandler = POP3ProtocolManager.access$200(this.this$0, (ArrayList)localObject1);
    }
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      if (localArrayList2.size() == 0)
      {
        Logger.log(4, "POP3ProtocolManager", "fetch mail list init load");
        if (((ArrayList)localObject1).size() > 0)
        {
          paramHandler = ((ArrayList)localObject1).iterator();
          while (paramHandler.hasNext())
          {
            localObject3 = (POP3MsgUID)paramHandler.next();
            if (localArrayList1.size() < this.val$state.getInitLoadCount()) {
              localArrayList1.add(((POP3MsgUID)localObject3).getUid());
            }
          }
        }
      }
      else
      {
        if (this.val$state.isReceiveNewOnly())
        {
          Logger.log(4, "POP3ProtocolManager", "fetch mail list update new");
          localObject4 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (POP3MsgUID)((Iterator)localObject4).next();
            if ((!paramHandler.contains(((POP3MsgUID)localObject5).getUid())) && (!localArrayList2.contains(((POP3MsgUID)localObject5).getUid())) && (!((ArrayList)localObject3).contains(((POP3MsgUID)localObject5).getUid()))) {
              localArrayList1.add(((POP3MsgUID)localObject5).getUid());
            }
          }
        }
        Logger.log(4, "POP3ProtocolManager", "fetch mail list load more");
        localObject4 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (POP3MsgUID)((Iterator)localObject4).next();
          if ((paramHandler.contains(((POP3MsgUID)localObject5).getUid())) && (!localArrayList2.contains(((POP3MsgUID)localObject5).getUid())) && (!((ArrayList)localObject3).contains(((POP3MsgUID)localObject5).getUid())) && (localArrayList1.size() < this.val$state.getLoadMoreCount())) {
            localArrayList1.add(((POP3MsgUID)localObject5).getUid());
          }
        }
      }
      paramHandler = new ArrayList();
      localObject3 = localArrayList2.iterator();
      label1007:
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject5 = ((ArrayList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
          } while (!((String)localObject4).equals(((POP3MsgUID)((Iterator)localObject5).next()).getUid()));
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label1007;
          }
          localObject5 = new Mail();
          ((Mail)localObject5).setRemoteId((String)localObject4);
          paramHandler.add(localObject5);
          break;
          Logger.log(4, "POP3ProtocolManager", "fetch mail list retrieve mail size:" + localArrayList1.size() + ", delete size:" + paramHandler.size());
          localObject3 = new ArrayList();
          i = 0;
          if (i < localArrayList1.size())
          {
            int j = POP3ProtocolManager.access$300(this.this$0, (ArrayList)localObject1, (String)localArrayList1.get(i));
            if (j == -1) {
              Logger.log(5, "POP3ProtocolManager", "fetch mail list msg -1 mailid:" + (String)localArrayList1.get(i));
            }
            for (;;)
            {
              i += 1;
              break;
              Logger.log(4, "POP3ProtocolManager", "fetch mail list msg number:" + j);
              try
              {
                localObject4 = ((POP3Handler)localObject2).top(j, 0);
                if (localObject4 != null)
                {
                  localObject4 = MailParser.createMail((MimeMessage)localObject4);
                  ((Mail)localObject4).setRemoteId((String)localArrayList1.get(i));
                  ((Mail)localObject4).setSize(POP3ProtocolManager.access$400(this.this$0, localArrayList3, j));
                  ((Mail)localObject4).setIsNew(true);
                  ((Mail)localObject4).setIsContentComplete(false);
                  ((ArrayList)localObject3).add(localObject4);
                }
              }
              catch (Exception localException)
              {
                Logger.log(6, "POP3ProtocolManager", "fetch mail error:" + j + " " + Log.getStackTraceString(localException));
                Logger.osslog(new Object[] { "pop_top_exception", localException.getMessage() });
              }
            }
          }
          localArrayList2.addAll(localArrayList1);
          POP3ProtocolManager.access$500(this.this$0, this.val$profile, POP3ProtocolManager.access$200(this.this$0, (ArrayList)localObject1));
          POP3ProtocolManager.access$600(this.this$0, this.val$profile, localArrayList2);
          Logger.log(4, "POP3ProtocolManager", "fetch mail list success folder:" + this.val$folder.getRemoteId());
          if (this.val$mailListCallBack != null)
          {
            localObject2 = this.val$mailListCallBack;
            i = ((ArrayList)localObject1).size();
            localObject1 = (Mail[])((ArrayList)localObject3).toArray(new Mail[((ArrayList)localObject3).size()]);
            paramHandler = (Mail[])paramHandler.toArray(new Mail[paramHandler.size()]);
            ((MailListCallBack)localObject2).onRetrieveMailsSuccess(i, (Mail[])localObject1, new Mail[0], paramHandler, false);
          }
          return;
        }
      }
    }
  }
  
  public int getPriority()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.POP3ProtocolManager.1
 * JD-Core Version:    0.7.0.1
 */