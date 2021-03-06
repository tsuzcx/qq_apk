import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

class ajcz
  extends akye.b
{
  ajcz(ajcy paramajcy, MessageForMixedMsg paramMessageForMixedMsg, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  private boolean J(ArrayList<akxr> paramArrayList)
  {
    MessageForMixedMsg localMessageForMixedMsg = this.c;
    int j;
    boolean bool2;
    if (localMessageForMixedMsg.msgElemList != null)
    {
      int i = 0;
      j = 0;
      boolean bool1 = true;
      bool2 = bool1;
      if (j >= localMessageForMixedMsg.msgElemList.size()) {
        break label135;
      }
      Object localObject = (MessageRecord)localMessageForMixedMsg.msgElemList.get(j);
      if (!(localObject instanceof MessageForPic)) {
        break label138;
      }
      localObject = (MessageForPic)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "updateMessageForPic for MessageForMixedMsg, subMsgIndex[" + j);
      }
      if (!a((MessageForPic)localObject, (akxr)paramArrayList.get(i))) {
        bool1 = false;
      }
      i += 1;
    }
    label135:
    label138:
    for (;;)
    {
      j += 1;
      break;
      bool2 = true;
      return bool2;
    }
  }
  
  private boolean a(MessageForPic paramMessageForPic, akxr paramakxr)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    String str = "";
    if (paramakxr.en != null) {
      if ((paramakxr.en instanceof im_msg_body.NotOnlineImage))
      {
        localElem.not_online_image.set((im_msg_body.NotOnlineImage)paramakxr.en);
        if (paramakxr.aVW)
        {
          if (!localElem.not_online_image.res_id.has()) {
            break label274;
          }
          str = localElem.not_online_image.res_id.get().toStringUtf8();
        }
      }
    }
    for (;;)
    {
      paramMessageForPic.uuid = str;
      paramMessageForPic.path = str;
      paramMessageForPic.thumbMsgUrl = localElem.not_online_image.str_thumb_url.get();
      paramMessageForPic.thumbHeight = localElem.not_online_image.uint32_thumb_height.get();
      paramMessageForPic.thumbWidth = localElem.not_online_image.uint32_thumb_width.get();
      paramMessageForPic.md5 = aqhq.px(ajcy.access$200());
      paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, " pic resp uuid = " + str + " picMsgMD5 = " + paramMessageForPic.md5 + " hasCode = " + paramMessageForPic.hashCode());
      }
      int i = 1;
      label227:
      boolean bool;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgManager", 2, "updateMessageForPic success");
        }
        localRichText.elems.add(localElem);
        if (paramakxr.mResult == 0) {
          bool = true;
        }
      }
      for (;;)
      {
        paramMessageForPic.richText = localRichText;
        return bool;
        label274:
        if (!localElem.not_online_image.download_path.has()) {
          break label490;
        }
        str = localElem.not_online_image.download_path.get().toStringUtf8();
        break;
        if ((paramakxr.en instanceof im_msg_body.CustomFace))
        {
          localElem.custom_face.set((im_msg_body.CustomFace)paramakxr.en);
          if (paramakxr.aVW)
          {
            if (localElem.custom_face.str_file_path.has()) {
              str = localElem.custom_face.str_file_path.get();
            }
            paramMessageForPic.path = str;
            paramMessageForPic.uuid = str;
            paramMessageForPic.md5 = aqhq.px(ajcy.access$200());
            paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
          }
          i = 1;
          break label227;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MixedMsgManager", 2, "WTF, picResult.mExtraObj is " + paramakxr.en.getClass().getSimpleName());
        }
        i = 0;
        break label227;
        if (QLog.isColorLevel())
        {
          QLog.e("MixedMsgManager", 2, "[requestUploadPics] Bad picture element");
          bool = false;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("MixedMsgManager", 2, "updateMessageForPic failed, add empty element");
          }
        }
        bool = false;
      }
      label490:
      str = "";
    }
  }
  
  public void Nc(int paramInt) {}
  
  public void o(int paramInt, ArrayList<akxr> paramArrayList)
  {
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "onForwardMultiMsgPicsUpload success[" + paramArrayList.size() + "]");
      }
      boolean bool = J(paramArrayList);
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MixedMsgManager", 2, "onForwardMultiMsgPicsUpload : isAllPicUploadSuccessful = false ");
        }
        ajcy.a(this.this$0, this.c, false, "picUpload fail");
        return;
      }
      paramArrayList = new MixedMsg.Msg();
      Iterator localIterator = this.c.msgElemList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (MessageRecord)localIterator.next();
        MixedMsg.Elem localElem = new MixedMsg.Elem();
        if ((localObject1 instanceof MessageForText))
        {
          if (!TextUtils.isEmpty(((MessageRecord)localObject1).msg)) {
            localElem.textMsg.set(((MessageRecord)localObject1).msg);
          }
        }
        else {
          for (;;)
          {
            paramArrayList.elems.get().add(localElem);
            break;
            Object localObject2;
            if (((MessageRecord)localObject1).msgtype == -2000)
            {
              localObject2 = new RichMsg.PicRec();
              try
              {
                localObject1 = (RichMsg.PicRec)((RichMsg.PicRec)localObject2).mergeFrom(((MessageRecord)localObject1).msgData);
                localElem.picMsg.set((MessageMicro)localObject1);
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
              {
                QLog.e("MixedMsgManager", 1, "onForwardMultiMsgPicsUpload", localInvalidProtocolBufferMicroException);
              }
            }
            else if ((localInvalidProtocolBufferMicroException instanceof MessageForReplyText))
            {
              try
              {
                MessageForReplyText localMessageForReplyText = (MessageForReplyText)localInvalidProtocolBufferMicroException;
                if (localMessageForReplyText.mSourceMsgInfo != null) {
                  localMessageForReplyText.mSourceMsgInfo.packSourceMsg(MessageForReplyText.getAppInterface(), localMessageForReplyText.getSourceMessage());
                }
                localObject2 = aczw.b(localMessageForReplyText.mSourceMsgInfo);
                localElem.sourceMsgInfo.set(aqhs.bytes2HexStr((byte[])localObject2));
                if (TextUtils.isEmpty(localMessageForReplyText.msg)) {
                  continue;
                }
                localElem.textMsg.set(localMessageForReplyText.msg);
              }
              catch (Exception localException) {}
              if (QLog.isColorLevel()) {
                QLog.d("MixedMsgManager", 2, localException.getMessage());
              }
            }
          }
        }
      }
      this.c.msgData = paramArrayList.toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "updateMsgRecords done, goto onPackAndSendMsg");
      }
      ajcy.a(this.this$0, this.val$app, this.bQI, this.dhX, this.c, bool);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MixedMsgManager", 2, "onForwardMultiMsgPicsUpload failed");
    }
    ajcy.a(this.this$0, this.c, false, "picUpload fail : result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcz
 * JD-Core Version:    0.7.0.1
 */