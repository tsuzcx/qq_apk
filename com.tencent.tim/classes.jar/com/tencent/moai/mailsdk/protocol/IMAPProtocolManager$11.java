package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.MailListCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPMailboxInfo;
import com.tencent.moai.mailsdk.protocol.imap.util.IMAPBodyStructureUtil;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeHeader;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.protocol.model.Flags;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class IMAPProtocolManager$11
  extends BaseTask
{
  IMAPProtocolManager$11(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Folder paramFolder, MailListCallBack paramMailListCallBack, State paramState)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    Object localObject2 = (IMAPHandler)paramHandler;
    paramHandler = ((IMAPHandler)localObject2).select(this.val$folder.getPath());
    if (paramHandler == null) {
      if (this.val$mailListCallBack != null) {
        this.val$mailListCallBack.onRetrieveMailsError(1, 200001, "select error");
      }
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    label705:
    do
    {
      return;
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      Object localObject1 = new ArrayList();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      Logger.log(4, "IMAPProtocolManager", "folder:" + this.val$folder.getName() + ", total:" + paramHandler.getTotal());
      if (((IMAPHandler)localObject2).unSupportSearchLatest())
      {
        Logger.log(4, "IMAPProtocolManager", "fetchMailList by uid search all");
        IMAPProtocolManager.access$200(this.this$0, (IMAPHandler)localObject2, this.val$state, (ArrayList)localObject3, (ArrayList)localObject4, (ArrayList)localObject1);
      }
      HashMap localHashMap2;
      HashMap localHashMap3;
      HashMap localHashMap4;
      String str;
      for (;;)
      {
        Logger.log(4, "IMAPProtocolManager", "fetch mail list new:" + ((ArrayList)localObject3).size() + ", update:" + ((ArrayList)localObject4).size() + ", delete:" + ((ArrayList)localObject1).size());
        if (((ArrayList)localObject3).size() <= 0) {
          break label705;
        }
        HashMap localHashMap1 = new HashMap();
        localHashMap2 = new HashMap();
        ((IMAPHandler)localObject2).fetchFlagAndSize((ArrayList)localObject3, localHashMap1, localHashMap2);
        localHashMap3 = ((IMAPHandler)localObject2).fetchBodyStructure((ArrayList)localObject3);
        localHashMap4 = ((IMAPHandler)localObject2).fetchHeader((ArrayList)localObject3);
        Iterator localIterator = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label705;
          }
          str = (String)localIterator.next();
          if (localHashMap4.get(str) != null) {
            break;
          }
          Logger.log(6, "IMAPProtocolManager", "header empty:" + str + ", flag:" + localHashMap1.get(str) + ", size:" + localHashMap2.get(str) + ", new:" + ((ArrayList)localObject3).toString() + ", delete:" + ((ArrayList)localObject1).toString());
        }
        Logger.log(4, "IMAPProtocolManager", "fetchMailList by search *");
        try
        {
          IMAPProtocolManager.access$300(this.this$0, (IMAPHandler)localObject2, paramHandler, this.val$folder, this.val$state, (ArrayList)localObject3, (ArrayList)localObject4, (ArrayList)localObject1);
        }
        catch (MessageException localMessageException)
        {
          Logger.log(6, "IMAPProtocolManager", "fetchMailListBySearch error:" + localMessageException.getResultCode() + ", " + localMessageException.getDetailCode() + ", " + localMessageException.getDetailMessage());
          if (localMessageException.getResultCode() == 17)
          {
            Logger.log(6, "IMAPProtocolManager", "unSupport search * to uid search all:" + this.val$folder.getName());
            IMAPProtocolManager.access$200(this.this$0, (IMAPHandler)localObject2, this.val$state, (ArrayList)localObject3, (ArrayList)localObject4, (ArrayList)localObject1);
          }
          else
          {
            throw localMessageException;
          }
        }
      }
      Object localObject5 = new MimeMessage();
      ((MimeMessage)localObject5).setHeader((MimeHeader)localHashMap4.get(str));
      localObject5 = MailParser.createMail((MimeMessage)localObject5);
      ((Mail)localObject5).setRemoteId(str);
      IMAPBodyStructureUtil.setMailBodyStructure((Mail)localObject5, (ArrayList)localHashMap3.get(str));
      ((Mail)localObject5).setFlags((Flags)localMessageException.get(str));
      ((Mail)localObject5).setSize(((Long)localHashMap2.get(str)).longValue());
      if ((((Mail)localObject5).getAttachments() != null) && (((Mail)localObject5).getAttachments().size() > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        ((Mail)localObject5).setHasAttach(bool);
        ((Mail)localObject5).setIsNew(true);
        localArrayList1.add(localObject5);
        break;
      }
      if ((((ArrayList)localObject4).size() > 0) && (!this.val$state.isWithoutSession()))
      {
        localObject2 = ((IMAPHandler)localObject2).fetchFlags((ArrayList)localObject4);
        localObject3 = ((HashMap)localObject2).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          Mail localMail = new Mail();
          localMail.setRemoteId((String)localObject4);
          localMail.setFlags((Flags)((HashMap)localObject2).get(localObject4));
          localArrayList2.add(localMail);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject3 = new Mail();
          ((Mail)localObject3).setRemoteId((String)localObject2);
          localArrayList3.add(localObject3);
        }
      }
      Logger.log(4, "IMAPProtocolManager", "fetch mail list success path:" + this.val$folder.getPath() + " name:" + this.val$folder.getName() + ", newMail:" + localArrayList1.size() + ", updateMail:" + localArrayList2.size() + ", deleteMail:" + localArrayList3.size());
    } while (this.val$mailListCallBack == null);
    this.val$mailListCallBack.onRetrieveMailsSuccess(paramHandler.getTotal(), (Mail[])localArrayList1.toArray(new Mail[localArrayList1.size()]), (Mail[])localArrayList2.toArray(new Mail[localArrayList2.size()]), (Mail[])localArrayList3.toArray(new Mail[localArrayList3.size()]), false);
  }
  
  public int getPriority()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.11
 * JD-Core Version:    0.7.0.1
 */