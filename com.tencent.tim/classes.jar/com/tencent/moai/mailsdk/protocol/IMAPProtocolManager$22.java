package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.callback.MailAbstractCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPContent;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;

class IMAPProtocolManager$22
  extends BaseTask
{
  IMAPProtocolManager$22(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Folder paramFolder, MailAbstractCallBack paramMailAbstractCallBack, Mail[] paramArrayOfMail)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    IMAPHandler localIMAPHandler = (IMAPHandler)paramHandler;
    if (localIMAPHandler.select(this.val$folder.getPath()) == null) {
      if (this.val$mailAbstractCallBack != null) {
        this.val$mailAbstractCallBack.onRetrieveMailAbstractError(0L, 1, 200001, "select error");
      }
    }
    Mail[] arrayOfMail;
    int j;
    int i;
    do
    {
      return;
      arrayOfMail = this.val$mails;
      j = arrayOfMail.length;
      i = 0;
    } while (i >= j);
    Mail localMail = arrayOfMail[i];
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      try
      {
        paramHandler = new ArrayList();
        localObject1 = new ArrayList();
        localObject3 = new ArrayList();
        localObject2 = new ArrayList();
        localObject4 = localMail.getBodyStructures().iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (IMAPBodyStructure)((Iterator)localObject4).next();
          if (!MimeDefine.TEXT.equalsIgnoreCase(((IMAPBodyStructure)localObject5).getContentType())) {
            continue;
          }
          if (MimeDefine.HTML.equalsIgnoreCase(((IMAPBodyStructure)localObject5).getContentSubtype()))
          {
            ((ArrayList)localObject1).add(localObject5);
            paramHandler.add(localObject5);
            continue;
          }
        }
      }
      catch (MessageException paramHandler)
      {
        Logger.log(4, "IMAPProtocolManager", "download mail abstract error remoteId:" + localMail.getRemoteId());
        if (this.val$mailAbstractCallBack != null) {
          this.val$mailAbstractCallBack.onRetrieveMailAbstractError(localMail.getId(), paramHandler.getResultCode(), paramHandler.getDetailCode(), paramHandler.getDetailMessage());
        }
        i += 1;
        break;
        if (MimeDefine.PLAIN.equalsIgnoreCase(((IMAPBodyStructure)localObject5).getContentSubtype()))
        {
          ((ArrayList)localObject3).add(localObject5);
          continue;
        }
      }
      catch (Exception paramHandler)
      {
        Logger.log(6, "IMAPProtocolManager", Log.getStackTraceString(paramHandler));
        if (this.val$mailAbstractCallBack == null) {
          continue;
        }
        this.val$mailAbstractCallBack.onRetrieveMailAbstractError(localMail.getId(), 1, 200001, paramHandler.getMessage());
        continue;
        if (!MimeDefine.CALENDAR.equalsIgnoreCase(((IMAPBodyStructure)localObject5).getContentSubtype())) {
          continue;
        }
        ((ArrayList)localObject2).add(localObject5);
        continue;
        if (paramHandler.size() == 0)
        {
          Logger.log(4, "IMAPProtocolManager", "no fetch part");
          if (this.val$mailAbstractCallBack == null) {
            continue;
          }
          this.val$mailAbstractCallBack.onRetrieveMailAbstractSuccess(localMail);
          continue;
        }
        Logger.log(4, "IMAPProtocolManager", "download mail abstract remoteId:" + localMail.getRemoteId());
        localObject1 = localIMAPHandler.fetchMailText(localMail.getRemoteId(), (ArrayList)localObject1);
        if (localObject1 != null)
        {
          paramHandler = (Handler)localObject1;
          if (((ArrayList)localObject1).size() != 0) {}
        }
        else
        {
          localObject1 = localIMAPHandler.fetchMailText(localMail.getRemoteId(), (ArrayList)localObject3);
          if (localObject1 != null)
          {
            paramHandler = (Handler)localObject1;
            if (((ArrayList)localObject1).size() != 0) {}
          }
          else
          {
            localObject1 = localIMAPHandler.fetchMailText(localMail.getRemoteId(), (ArrayList)localObject2);
            if (localObject1 != null)
            {
              paramHandler = (Handler)localObject1;
              if (((ArrayList)localObject1).size() != 0) {}
            }
            else
            {
              throw new MessageException(1, 200001, "imap content null");
            }
          }
        }
      }
      Object localObject1 = new StringBuilder();
      Object localObject2 = new StringBuilder();
      Object localObject3 = new StringBuilder();
      paramHandler = paramHandler.iterator();
      while (paramHandler.hasNext())
      {
        localObject5 = (IMAPContent)paramHandler.next();
        localObject4 = ((IMAPContent)localObject5).getSubType();
        localObject5 = ((IMAPContent)localObject5).getContent();
        if ((MimeDefine.PLAIN.equalsIgnoreCase((String)localObject4)) || (MimeDefine.NIL.equalsIgnoreCase((String)localObject4))) {
          ((StringBuilder)localObject1).append((String)localObject5);
        } else if (MimeDefine.HTML.equalsIgnoreCase((String)localObject4)) {
          ((StringBuilder)localObject2).append((String)localObject5);
        } else if (MimeDefine.CALENDAR.equalsIgnoreCase((String)localObject4)) {
          ((StringBuilder)localObject3).append((String)localObject5);
        }
      }
      localMail.setPlainContent(((StringBuilder)localObject1).toString());
      localMail.setHtmlContent(((StringBuilder)localObject2).toString());
      localMail.setCalendarContent(((StringBuilder)localObject3).toString());
      Logger.log(4, "IMAPProtocolManager", "download mail abstract success remoteId:" + localMail.getRemoteId());
      if (this.val$mailAbstractCallBack != null) {
        this.val$mailAbstractCallBack.onRetrieveMailAbstractSuccess(localMail);
      }
    }
  }
  
  public int getPriority()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.22
 * JD-Core Version:    0.7.0.1
 */