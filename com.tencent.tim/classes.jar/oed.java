import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

class oed
  implements akyf
{
  oed(oec paramoec, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, achq paramachq, boolean paramBoolean) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama) {}
  
  public void b(akyf.a parama)
  {
    MessageForStructing localMessageForStructing;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      try
      {
        if (parama.result != 0) {
          break label541;
        }
        if ((this.e instanceof MessageForStructing))
        {
          localMessageForStructing = (MessageForStructing)this.e;
          if (localMessageForStructing.richText != null) {
            break label306;
          }
          localObject1 = anbh.a(localMessageForStructing);
          if (localObject1 == null) {
            break label283;
          }
          localObject2 = ((im_msg_body.RichText)localObject1).elems.get();
          if (QLog.isColorLevel()) {
            QLog.d("ShareStructLongMessageManager", 2, "current uid is" + parama.uuid);
          }
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (im_msg_body.Elem)((Iterator)localObject2).next();
          if (((im_msg_body.Elem)localObject3).rich_msg.has())
          {
            ((im_msg_body.Elem)localObject3).rich_msg.bytes_msg_resid.set(ByteStringMicro.copyFrom(parama.uuid.getBytes()));
            ((im_msg_body.Elem)localObject3).rich_msg.bytes_template_1.set(ByteStringMicro.EMPTY);
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception parama)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "upload  msg pack failed, catch exception", parama);
        }
        this.b.b(this.val$app, this.e);
      }
      if ((((im_msg_body.Elem)localObject3).text.has()) && (((im_msg_body.Elem)localObject3).text.str.has()))
      {
        String str = ((im_msg_body.Elem)localObject3).text.str.get().toStringUtf8();
        if (str.length() > 500)
        {
          str = str.substring(0, 500);
          ((im_msg_body.Elem)localObject3).text.str.set(ByteStringMicro.copyFromUtf8(str));
        }
      }
    }
    localMessageForStructing.richText = ((im_msg_body.RichText)localObject1);
    for (;;)
    {
      label283:
      this.val$app.b().b(this.e, this.d, this.awD);
      return;
      label306:
      localObject1 = localMessageForStructing.richText.elems.get();
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "current uid is" + parama.uuid);
      }
      if ((localObject1 != null) && (oec.c(localMessageForStructing.structingMsg)))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
          if (((im_msg_body.Elem)localObject2).rich_msg.has())
          {
            ((im_msg_body.Elem)localObject2).rich_msg.bytes_msg_resid.set(ByteStringMicro.copyFrom(parama.uuid.getBytes()));
            ((im_msg_body.Elem)localObject2).rich_msg.bytes_template_1.set(ByteStringMicro.EMPTY);
            ((im_msg_body.Elem)localObject2).rich_msg.uint32_service_id.set(localMessageForStructing.structingMsg.mMsgServiceID);
          }
          else if ((((im_msg_body.Elem)localObject2).text.has()) && (((im_msg_body.Elem)localObject2).text.str.has()))
          {
            localObject3 = ((im_msg_body.Elem)localObject2).text.str.get().toStringUtf8();
            if (((String)localObject3).length() > 500)
            {
              localObject3 = ((String)localObject3).substring(0, 500);
              ((im_msg_body.Elem)localObject2).text.str.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            }
          }
        }
      }
    }
    label541:
    if (QLog.isColorLevel()) {
      QLog.d("ShareStructLongMessageManager", 2, "upload  msg pack failed, result.errStr=" + parama.errCode + ",result.errStr=" + parama.errStr);
    }
    this.b.b(this.val$app, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oed
 * JD-Core Version:    0.7.0.1
 */