import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PicRec;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

class ajld
  extends akye.b
{
  ajld(ajlc paramajlc, int paramInt1, MessageRecord paramMessageRecord, ArrayList paramArrayList, QQAppInterface paramQQAppInterface, String paramString, int paramInt2, HashMap paramHashMap) {}
  
  private boolean J(ArrayList<akxr> paramArrayList)
  {
    int j = 0;
    int i = 0;
    boolean bool1 = true;
    int m = 0;
    Object localObject1;
    if (m < this.xO.size())
    {
      localObject1 = (MessageRecord)this.xO.get(m);
      if ((i >= paramArrayList.size()) || ((!((akxr)paramArrayList.get(i)).aVW) && (this.djH != 5))) {
        break label965;
      }
      j = 1;
    }
    label956:
    label959:
    label962:
    label965:
    for (;;)
    {
      if ((localObject1 instanceof MessageForPic))
      {
        if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
          QLog.e("MultiMsg_TAG", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
        }
        localObject1 = (MessageForPic)localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + m + "], resultIndex[" + i + "]");
        }
        if (!a((MessageForPic)localObject1, (akxr)paramArrayList.get(i))) {
          bool1 = false;
        }
        i += 1;
        m += 1;
        break;
      }
      int n;
      label210:
      int k;
      boolean bool2;
      Object localObject2;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = (MessageForMixedMsg)localObject1;
        if (((MessageForMixedMsg)localObject1).msgElemList != null)
        {
          n = 0;
          k = i;
          bool2 = bool1;
          if (n >= ((MessageForMixedMsg)localObject1).msgElemList.size()) {
            break label382;
          }
          localObject2 = (MessageRecord)((MessageForMixedMsg)localObject1).msgElemList.get(n);
          if (!(localObject2 instanceof MessageForPic)) {
            break label962;
          }
          if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
            QLog.e("MultiMsg_TAG", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
          }
          localObject2 = (MessageForPic)localObject2;
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + m + "], subMsgIndex[" + n + ", resultIndex[" + i + "]");
          }
          if (!a((MessageForPic)localObject2, (akxr)paramArrayList.get(i))) {
            bool1 = false;
          }
          i += 1;
        }
      }
      for (;;)
      {
        n += 1;
        break label210;
        bool2 = bool1;
        k = i;
        label382:
        i = k;
        bool1 = bool2;
        break;
        if (((MessageRecord)localObject1).msgtype == -1036) {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
        }
        for (;;)
        {
          label466:
          Object localObject3;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if (!(localObject2 instanceof MessageForMixedMsg)) {
              continue;
            }
            localObject2 = (MessageForMixedMsg)localObject2;
            if (((MessageForMixedMsg)localObject2).msgElemList == null) {
              continue;
            }
            k = 0;
            if (k >= ((MessageForMixedMsg)localObject2).msgElemList.size()) {
              break label959;
            }
            localObject3 = (MessageRecord)((MessageForMixedMsg)localObject2).msgElemList.get(k);
            if (!(localObject3 instanceof MessageForPic)) {
              break label956;
            }
            if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
              QLog.e("MultiMsg_TAG", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
            }
            localObject3 = (MessageForPic)localObject3;
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + m + "], subMsgIndex[" + k + ", resultIndex[" + i + "]");
            }
            if (!a((MessageForPic)localObject3, (akxr)paramArrayList.get(i))) {
              bool1 = false;
            }
            i += 1;
          }
          for (;;)
          {
            k += 1;
            break label466;
            break;
            if ((localObject1 instanceof MessageForStructing))
            {
              localObject2 = ((MessageForStructing)localObject1).structingMsg;
              if ((localObject2 != null) && ((localObject2 instanceof StructMsgForImageShare)))
              {
                localObject3 = ((StructMsgForImageShare)localObject2).getFirstImageElement();
                if ((localObject3 != null) && (((ansu)localObject3).j != null))
                {
                  MessageForPic localMessageForPic = ((ansu)localObject3).j;
                  if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + m + "], resultIndex[" + i + "]");
                  }
                  if (((MessageForStructing)localObject1).isHotPicsStruct())
                  {
                    PicMessageExtraData localPicMessageExtraData = new PicMessageExtraData();
                    localPicMessageExtraData.imageBizType = 2;
                    localMessageForPic.picExtraData = localPicMessageExtraData;
                  }
                  if (!a(localMessageForPic, (akxr)paramArrayList.get(i))) {
                    bool1 = false;
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    ((ansu)localObject3).mUuid = localMessageForPic.uuid;
                    ((ansu)localObject3).mMd5 = localMessageForPic.md5;
                    ((ansu)localObject3).cij = localMessageForPic.path;
                    ((MessageRecord)localObject1).msgData = ((AbsStructMsg)localObject2).getBytes();
                  }
                  if (j != 0)
                  {
                    if (this.C.isReMultiMsg) {
                      anot.b(this.val$app, "CliOper", "", "", "0X800662B", "0X800662B", 0, 1, 0, "", "", "", "");
                    }
                    if (QLog.isColorLevel()) {
                      QLog.e("MultiMsg_TAG", 2, "requestUploadPics isPicMsgModify");
                    }
                    this.val$app.a().b().a(this.xO, null);
                  }
                  if (this.C.isReMultiMsg) {
                    anot.b(this.val$app, "CliOper", "", "", "0X800662A", "0X800662A", 0, 1, 0, "", "", "", "");
                  }
                  return bool1;
                }
              }
            }
            break;
          }
        }
      }
    }
  }
  
  private boolean a(MessageForPic paramMessageForPic, akxr paramakxr)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    Object localObject = "";
    if (paramakxr.en != null) {
      if ((paramakxr.en instanceof im_msg_body.NotOnlineImage))
      {
        localElem.not_online_image.set((im_msg_body.NotOnlineImage)paramakxr.en);
        if (paramMessageForPic.picExtraData != null)
        {
          localObject = paramMessageForPic.picExtraData.getOfflineImageResvAttr();
          localElem.not_online_image.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject).get()).toByteArray()), true);
        }
        if ((paramakxr.aVW) || (this.djH == 5))
        {
          if (!localElem.not_online_image.res_id.has()) {
            break label336;
          }
          localObject = localElem.not_online_image.res_id.get().toStringUtf8();
        }
      }
    }
    for (;;)
    {
      paramMessageForPic.uuid = ((String)localObject);
      if (this.djH != 5)
      {
        paramMessageForPic.path = ((String)localObject);
        paramMessageForPic.md5 = aqhq.px(ajlc.bQH);
      }
      paramMessageForPic.thumbMsgUrl = localElem.not_online_image.str_thumb_url.get();
      paramMessageForPic.thumbHeight = localElem.not_online_image.uint32_thumb_height.get();
      paramMessageForPic.thumbWidth = localElem.not_online_image.uint32_thumb_width.get();
      paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, " pic resp uuid = " + (String)localObject + " picMsgMD5 = " + paramMessageForPic.md5 + " hasCode = " + paramMessageForPic.hashCode());
      }
      int i = 1;
      label288:
      boolean bool;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "updateMessageForPic success");
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
        label336:
        if (!localElem.not_online_image.download_path.has()) {
          break label664;
        }
        localObject = localElem.not_online_image.download_path.get().toStringUtf8();
        break;
        if ((paramakxr.en instanceof im_msg_body.CustomFace))
        {
          localElem.custom_face.set((im_msg_body.CustomFace)paramakxr.en);
          if (paramMessageForPic.picExtraData != null)
          {
            CustomFaceExtPb.ResvAttr localResvAttr = paramMessageForPic.picExtraData.getCustomFaceResvAttr();
            localElem.custom_face.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)localResvAttr.get()).toByteArray()), true);
          }
          if ((paramakxr.aVW) || (this.djH == 5))
          {
            if (localElem.custom_face.str_file_path.has()) {
              localObject = localElem.custom_face.str_file_path.get();
            }
            paramMessageForPic.uuid = ((String)localObject);
            if (this.djH != 5)
            {
              paramMessageForPic.path = ((String)localObject);
              paramMessageForPic.md5 = aqhq.px(ajlc.bQH);
            }
            paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
          }
          if ((localElem.custom_face.uint32_file_id.get() == 0) && (this.djH == 5) && (this.C.istroop != 0))
          {
            if (!QLog.isColorLevel()) {
              break label617;
            }
            QLog.d("MultiMsg_TAG", 2, "updateMessageForPic but custom_face's file id is 0");
            i = 0;
            break label288;
          }
          i = 1;
          break label288;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MultiMsg_TAG", 2, "WTF, picResult.mExtraObj is " + paramakxr.en.getClass().getSimpleName());
        }
        label617:
        i = 0;
        break label288;
        if (QLog.isColorLevel())
        {
          QLog.e("MultiMsg_TAG", 2, "[requestUploadPics] Bad picture element");
          bool = false;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("MultiMsg_TAG", 2, "updateMessageForPic failed, add empty element");
          }
        }
        bool = false;
      }
      label664:
      localObject = "";
    }
  }
  
  public void Nc(int paramInt) {}
  
  public void o(int paramInt, ArrayList<akxr> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "onForwardMultiMsgPicsUpload success[" + paramArrayList.size() + "]");
      }
      bool2 = J(paramArrayList);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiMsg_TAG", 2, "updateMsgRecords done, goto onPackAndSendMsg");
        bool1 = bool2;
      }
      if (this.djH != 5) {
        break label189;
      }
      ajlc.a(this.this$0, this.C.uniseq, 1);
      label109:
      if ((this.djH == 5) || (ajlc.c(this.this$0) != 0)) {
        break label200;
      }
      ajlc.a(this.this$0, this.val$app, this.bQI, this.dhX, this.lE, this.C, null, this.xO, bool1, this.djH);
    }
    label189:
    label200:
    while ((this.djH != 5) || (!ajlc.a(this.this$0, this.C.uniseq)))
    {
      return;
      bool1 = bool2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiMsg_TAG", 2, "onForwardMultiMsgPicsUpload failed");
      bool1 = bool2;
      break;
      ajlc.a(this.this$0, 1);
      break label109;
    }
    if (bool1)
    {
      ajlc.a(this.this$0, this.val$app, this.bQI, this.dhX, this.lE, this.C, null, this.xO, true, this.djH);
      return;
    }
    ajlc.a(this.this$0, this.C, this.val$app, this.bQI, this.dhX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajld
 * JD-Core Version:    0.7.0.1
 */