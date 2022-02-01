package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.SearchMailCallback;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.imap.util.IMAPBodyStructureUtil;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeHeader;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.protocol.model.Flags;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class IMAPProtocolManager$18
  extends BaseTask
{
  IMAPProtocolManager$18(IMAPProtocolManager paramIMAPProtocolManager, String paramString, ArrayList paramArrayList, SearchMailCallback paramSearchMailCallback, HashMap paramHashMap, State paramState)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    IMAPHandler localIMAPHandler = (IMAPHandler)paramHandler;
    if ((this.val$folderIds == null) || (this.val$folderIds.size() == 0)) {
      if (this.val$callback != null) {
        this.val$callback.onSearchError(1, 200001, "folder list null");
      }
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    label622:
    do
    {
      return;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      Iterator localIterator1 = this.val$folderIds.iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          paramHandler = (String)localIterator1.next();
          if (localIMAPHandler.select(paramHandler) == null)
          {
            if (this.val$callback == null) {
              break;
            }
            this.val$callback.onSearchError(1, 200001, "select error:" + paramHandler);
            return;
          }
          Object localObject2 = new ArrayList();
          paramHandler = this.val$searchFields.keySet().iterator();
          int i;
          Object localObject1;
          while (paramHandler.hasNext())
          {
            i = ((Integer)paramHandler.next()).intValue();
            localObject1 = new StringBuilder();
            switch (i)
            {
            default: 
              break;
            case 0: 
              ((StringBuilder)localObject1).append("FROM");
            case 1: 
            case 2: 
            case 3: 
              for (;;)
              {
                ((StringBuilder)localObject1).append(" \"").append((String)this.val$searchFields.get(Integer.valueOf(i))).append("\"");
                ((ArrayList)localObject2).add(((StringBuilder)localObject1).toString());
                break;
                ((StringBuilder)localObject1).append("TO");
                continue;
                ((StringBuilder)localObject1).append("SUBJECT");
                continue;
                ((StringBuilder)localObject1).append("BODY");
              }
            }
          }
          if (((ArrayList)localObject2).size() > 0)
          {
            paramHandler = (String)((ArrayList)localObject2).get(0);
            localObject1 = paramHandler;
            if (((ArrayList)localObject2).size() > 1)
            {
              i = 1;
              for (;;)
              {
                localObject1 = paramHandler;
                if (i >= ((ArrayList)localObject2).size()) {
                  break;
                }
                paramHandler = "OR (" + paramHandler + ") (" + (String)((ArrayList)localObject2).get(i) + ")";
                i += 1;
              }
            }
            localObject2 = localIMAPHandler.search("CHARSET utf-8 " + (String)localObject1, true);
            localArrayList2.addAll((Collection)localObject2);
            if ((((ArrayList)localObject2).size() == 0) && (this.val$callback != null)) {
              this.val$callback.onSearchSuccess(0, 0);
            }
            paramHandler = new ArrayList();
            localObject1 = this.val$state.getExistUidList();
            Collections.sort((List)localObject2, new IMAPProtocolManager.18.1(this));
            localObject2 = ((ArrayList)localObject2).iterator();
            Object localObject3;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = (String)((Iterator)localObject2).next();
              if (((ArrayList)localObject1).indexOf(localObject3) == -1) {
                paramHandler.add(localObject3);
              }
            } while (paramHandler.size() <= this.val$state.getLoadMoreCount());
            localArrayList1.addAll(paramHandler);
            if (paramHandler.size() > 0)
            {
              localObject1 = new HashMap();
              localObject2 = new HashMap();
              localIMAPHandler.fetchFlagAndSize(paramHandler, (HashMap)localObject1, (HashMap)localObject2);
              localObject3 = localIMAPHandler.fetchBodyStructure(paramHandler);
              HashMap localHashMap = localIMAPHandler.fetchHeader(paramHandler);
              Iterator localIterator2 = paramHandler.iterator();
              Object localObject4;
              while (localIterator2.hasNext())
              {
                String str = (String)localIterator2.next();
                if (localHashMap.get(str) == null)
                {
                  Logger.log(6, "IMAPProtocolManager", "header empty:" + str + ", flag:" + ((HashMap)localObject1).get(str) + ", new:" + paramHandler.toString());
                }
                else
                {
                  localObject4 = new MimeMessage();
                  ((MimeMessage)localObject4).setHeader((MimeHeader)localHashMap.get(str));
                  localObject4 = MailParser.createMail((MimeMessage)localObject4);
                  ((Mail)localObject4).setRemoteId(str);
                  IMAPBodyStructureUtil.setMailBodyStructure((Mail)localObject4, (ArrayList)((HashMap)localObject3).get(str));
                  ((Mail)localObject4).setFlags((Flags)((HashMap)localObject1).get(str));
                  ((Mail)localObject4).setSize(((Long)((HashMap)localObject2).get(str)).longValue());
                  if (((Mail)localObject4).getAttachments().size() <= 0) {
                    break label837;
                  }
                }
              }
              for (boolean bool = true;; bool = false)
              {
                ((Mail)localObject4).setHasAttach(bool);
                if (this.val$callback == null) {
                  break label622;
                }
                this.val$callback.onSearchMail((Mail)localObject4);
                break label622;
                break;
              }
            }
          }
        }
      }
    } while (this.val$callback == null);
    label837:
    this.val$callback.onSearchSuccess(localArrayList1.size(), localArrayList2.size());
  }
  
  public int getPriority()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.18
 * JD-Core Version:    0.7.0.1
 */