package com.tencent.tim.mail;

import android.content.Intent;
import aqhq;
import augo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class MailPluginManager$5
  implements Runnable
{
  public MailPluginManager$5(augo paramaugo, ArrayList paramArrayList, Map paramMap) {}
  
  public void run()
  {
    Object localObject1 = (ChatMessage)this.Ej.get(0);
    aqhq.delete(augo.bRl, true);
    Object localObject2 = new File(augo.bRl);
    if ((((File)localObject2).isDirectory()) && (!((File)localObject2).exists())) {
      ((File)localObject2).mkdirs();
    }
    augo.b(this.this$0, 0);
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<html><body>");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
    localSimpleDateFormat.applyPattern("yyyy-MM-dd");
    localObject2 = localSimpleDateFormat.format(Long.valueOf(((ChatMessage)localObject1).time * 1000L));
    localStringBuilder.append("<p><font color=\"#999999\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;————————&nbsp;").append((String)localObject2).append("&nbsp;————————</font></p>");
    int i = 0;
    ChatMessage localChatMessage;
    if (i < this.Ej.size())
    {
      localChatMessage = (ChatMessage)this.Ej.get(i);
      if ((localChatMessage instanceof MessageForText)) {
        localObject1 = augo.a(this.this$0, (MessageForText)localChatMessage);
      }
    }
    for (;;)
    {
      Object localObject3 = localObject2;
      if (localObject1 != null)
      {
        localSimpleDateFormat.applyPattern("yyyy-MM-dd");
        String str = localSimpleDateFormat.format(Long.valueOf(localChatMessage.time * 1000L));
        localObject3 = localObject2;
        if (!str.equals(localObject2))
        {
          localStringBuilder.append("<p><font color=\"#999999\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;————————&nbsp;").append(str).append("&nbsp;————————</font></p>");
          localObject3 = str;
        }
        localSimpleDateFormat.applyPattern("HH:mm:ss");
        localObject2 = localSimpleDateFormat.format(Long.valueOf(localChatMessage.time * 1000L));
        localStringBuilder.append("<p><font color=\"#999999\">").append((String)this.pC.get(localChatMessage.senderuin)).append("&nbsp;").append((String)localObject2).append("</font><br/>");
        localStringBuilder.append((String)localObject1).append("</p>");
      }
      i += 1;
      localObject2 = localObject3;
      break;
      if ((localChatMessage instanceof MessageForMarketFace))
      {
        localObject1 = localChatMessage.getSummaryMsg();
      }
      else if ((localChatMessage instanceof MessageForReplyText))
      {
        localObject1 = augo.a(this.this$0, (MessageForReplyText)localChatMessage);
      }
      else if ((localChatMessage instanceof MessageForLongMsg))
      {
        localObject1 = augo.a(this.this$0, (MessageForLongMsg)localChatMessage);
      }
      else if ((localChatMessage instanceof MessageForMixedMsg))
      {
        localObject1 = augo.a(this.this$0, (MessageForMixedMsg)localChatMessage);
      }
      else if ((localChatMessage instanceof MessageForPic))
      {
        localObject1 = augo.a(this.this$0, (MessageForPic)localChatMessage);
      }
      else if ((localChatMessage instanceof MessageForShortVideo))
      {
        localObject1 = augo.a(this.this$0, (MessageForShortVideo)localChatMessage, localArrayList);
      }
      else if ((localChatMessage instanceof MessageForFile))
      {
        localObject1 = augo.a(this.this$0, (MessageForFile)localChatMessage, localArrayList);
      }
      else if ((localChatMessage instanceof MessageForTroopFile))
      {
        localObject1 = augo.a(this.this$0, (MessageForTroopFile)localChatMessage, localArrayList);
      }
      else if ((localChatMessage instanceof MessageForStructing))
      {
        localObject1 = augo.a(this.this$0, (MessageForStructing)localChatMessage);
        continue;
        localStringBuilder.append("</body></html>");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("cmd", "send_mail_chatrecord");
        ((Intent)localObject1).putExtra("mail_text", localStringBuilder.toString());
        ((Intent)localObject1).putStringArrayListExtra("mail_attachment_path", localArrayList);
        BaseActivity.sTopActivity.runOnUiThread(new MailPluginManager.5.1(this, (Intent)localObject1));
      }
      else
      {
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mail.MailPluginManager.5
 * JD-Core Version:    0.7.0.1
 */