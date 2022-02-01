package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.callback.MailCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPContent;
import com.tencent.moai.mailsdk.protocol.imap.util.IMAPBodyStructureUtil;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class IMAPProtocolManager$20
  extends BaseTask
{
  IMAPProtocolManager$20(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Folder paramFolder, MailCallBack paramMailCallBack, Mail[] paramArrayOfMail)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    IMAPHandler localIMAPHandler = (IMAPHandler)paramHandler;
    if (localIMAPHandler.select(this.val$folder.getPath()) == null) {
      if (this.val$mailCallBack != null) {
        this.val$mailCallBack.onRetrieveMailError(1, 200001, "select error");
      }
    }
    for (;;)
    {
      return;
      Mail[] arrayOfMail = this.val$mails;
      int j = arrayOfMail.length;
      int i = 0;
      while (i < j)
      {
        Mail localMail = arrayOfMail[i];
        try
        {
          localObject2 = localMail.getRemoteId();
          Logger.log(4, "IMAPProtocolManager", "download mail text remoteId:" + (String)localObject2);
          localObject1 = localMail.getBodyStructures();
          paramHandler = (Handler)localObject1;
          if (((ArrayList)localObject1).size() == 0)
          {
            Logger.log(4, "IMAPProtocolManager", "no fetch part, try to fetch bodyStructure again");
            paramHandler = new ArrayList();
            paramHandler.add(localObject2);
            paramHandler = (ArrayList)localIMAPHandler.fetchBodyStructure(paramHandler).get(localObject2);
            Logger.log(4, "IMAPProtocolManager", "fetch bodyStructure size:" + paramHandler.size());
            IMAPBodyStructureUtil.setMailBodyStructure(localMail, paramHandler);
          }
          paramHandler = IMAPBodyStructureUtil.filterTextBodyStructure(paramHandler);
          if (paramHandler.size() == 0)
          {
            Logger.log(6, "IMAPProtocolManager", "empty body structure");
            if (this.val$mailCallBack != null) {
              this.val$mailCallBack.onRetrieveMailSuccess(localMail);
            }
          }
          else
          {
            Logger.log(4, "IMAPProtocolManager", "fetch mail text body:" + paramHandler.size());
            localObject3 = localIMAPHandler.fetchMailText(localMail.getRemoteId(), paramHandler);
            if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0)) {
              throw new MessageException(1, 200001, "imap content null");
            }
          }
        }
        catch (MessageException paramHandler)
        {
          Object localObject3;
          Logger.log(4, "IMAPProtocolManager", "download mail text error remoteId:" + localMail.getRemoteId());
          if (this.val$mailCallBack != null)
          {
            this.val$mailCallBack.onRetrieveMailError(paramHandler.getResultCode(), paramHandler.getDetailCode(), paramHandler.getDetailMessage());
            break label618;
            paramHandler = new StringBuilder();
            localObject1 = new StringBuilder();
            localObject2 = new StringBuilder();
            localObject3 = ((ArrayList)localObject3).iterator();
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label542;
              }
              localObject4 = (IMAPContent)((Iterator)localObject3).next();
              str = ((IMAPContent)localObject4).getSubType();
              localObject4 = ((IMAPContent)localObject4).getContent();
              if ((!MimeDefine.PLAIN.equalsIgnoreCase(str)) && (!MimeDefine.NIL.equalsIgnoreCase(str))) {
                break;
              }
              paramHandler.append((String)localObject4);
            }
          }
        }
        catch (Exception paramHandler)
        {
          Object localObject2;
          Object localObject1;
          for (;;)
          {
            Object localObject4;
            String str;
            Logger.log(6, "IMAPProtocolManager", Log.getStackTraceString(paramHandler));
            if (this.val$mailCallBack == null) {
              break;
            }
            this.val$mailCallBack.onRetrieveMailError(1, 200001, paramHandler.getMessage());
            break;
            if (MimeDefine.HTML.equalsIgnoreCase(str)) {
              ((StringBuilder)localObject1).append((String)localObject4);
            } else if (MimeDefine.CALENDAR.equalsIgnoreCase(str)) {
              ((StringBuilder)localObject2).append((String)localObject4);
            }
          }
          label542:
          localMail.setPlainContent(paramHandler.toString());
          localMail.setHtmlContent(((StringBuilder)localObject1).toString());
          localMail.setCalendarContent(((StringBuilder)localObject2).toString());
          Logger.log(4, "IMAPProtocolManager", "download mail text success remoteId:" + localMail.getRemoteId());
          if (this.val$mailCallBack != null) {
            this.val$mailCallBack.onRetrieveMailSuccess(localMail);
          }
          label618:
          i += 1;
        }
      }
    }
  }
  
  public int getPriority()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.20
 * JD-Core Version:    0.7.0.1
 */