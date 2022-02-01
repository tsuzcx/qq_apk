import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
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

class ajli
  extends akye.b
{
  ArrayList<Integer> wN = null;
  
  ajli(ajlh paramajlh, ArrayList paramArrayList, HashMap paramHashMap, MessageRecord paramMessageRecord, ajkv paramajkv, ajlf paramajlf) {}
  
  private boolean J(ArrayList<akxr> paramArrayList)
  {
    int k = 0;
    boolean bool1 = false;
    int n = 0;
    int j = 0;
    Object localObject1;
    int i;
    label151:
    int m;
    boolean bool2;
    label284:
    Object localObject2;
    label478:
    int i1;
    if (n < this.xQ.size())
    {
      localObject1 = (MessageRecord)this.xQ.get(n);
      i = k;
      if (j < paramArrayList.size())
      {
        i = k;
        if (((akxr)paramArrayList.get(j)).aVW) {
          i = 1;
        }
      }
      if (((localObject1 instanceof MessageForPic)) || (((localObject1 instanceof MessageForReplyText)) && (((MessageForReplyText)localObject1).getSourceMessage() != null) && ((((MessageForReplyText)localObject1).getSourceMessage() instanceof MessageForPic))))
      {
        if ((j >= paramArrayList.size()) && (QLog.isColorLevel())) {
          QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
        }
        if ((localObject1 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForPic)((MessageForReplyText)localObject1).getSourceMessage();
          if (QLog.isColorLevel()) {
            QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + n + "], resultIndex[" + j + "]");
          }
          m = a((MessageForPic)localObject1, (akxr)paramArrayList.get(j));
          k = i;
          bool2 = bool1;
          if (m != 0)
          {
            Rf(m);
            if (!this.a.kv(m)) {
              break label284;
            }
            bool2 = true;
            k = i;
          }
        }
        for (;;)
        {
          i = j + 1;
          j = k;
          bool1 = bool2;
          n += 1;
          k = j;
          j = i;
          break;
          localObject1 = (MessageForPic)localObject1;
          break label151;
          localObject2 = this.a.app.a().a((MessageRecord)localObject1, ajlh.access$000(), false);
          ((MessageRecord)localObject2).setId(((MessageForPic)localObject1).getId());
          ((MessageRecord)localObject2).setStatus(((MessageForPic)localObject1).getStatus());
          this.xQ.set(n, localObject2);
          bool2 = this.a.app.a().a(this.lH, (MessageRecord)localObject2);
          if (QLog.isColorLevel()) {
            QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForPic errCode:%d, update:%s, uniseq:%d", new Object[] { Integer.valueOf(m), Boolean.valueOf(bool2), Long.valueOf(((MessageRecord)localObject2).uniseq) }));
          }
          k = 1;
          bool2 = bool1;
        }
      }
      if (((localObject1 instanceof MessageForMixedMsg)) || (((localObject1 instanceof MessageForReplyText)) && (((MessageForReplyText)localObject1).getSourceMessage() != null) && ((((MessageForReplyText)localObject1).getSourceMessage() instanceof MessageForMixedMsg)))) {
        if ((localObject1 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForMixedMsg)((MessageForReplyText)localObject1).getSourceMessage();
          if (((MessageForMixedMsg)localObject1).msgElemList == null) {
            break label802;
          }
          i1 = 0;
          label489:
          m = j;
          k = i;
          bool2 = bool1;
          if (i1 >= ((MessageForMixedMsg)localObject1).msgElemList.size()) {
            break label812;
          }
          localObject2 = (MessageRecord)((MessageForMixedMsg)localObject1).msgElemList.get(i1);
          if (!(localObject2 instanceof MessageForPic)) {
            break label1709;
          }
          if ((j >= paramArrayList.size()) && (QLog.isColorLevel())) {
            QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
          }
          localObject2 = (MessageForPic)localObject2;
          if (QLog.isColorLevel()) {
            QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + n + "], subMsgIndex[" + i1 + ", resultIndex[" + j + "]");
          }
          m = a((MessageForPic)localObject2, (akxr)paramArrayList.get(j));
          k = i;
          bool2 = bool1;
          if (m != 0)
          {
            Rf(m);
            if (!this.a.kv(m)) {
              break label714;
            }
            bool2 = true;
            k = i;
          }
          label676:
          i = j + 1;
          j = k;
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      k = j;
      j = i;
      i = k;
      break label489;
      localObject1 = (MessageForMixedMsg)localObject1;
      break label478;
      label714:
      localObject2 = this.a.app.a().a((MessageRecord)localObject2, acfp.m(2131709636), false);
      ((MessageForMixedMsg)localObject1).msgElemList.set(i1, localObject2);
      if (QLog.isColorLevel()) {
        QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForMixedMsg errCode:%d, uniseq:%d", new Object[] { Integer.valueOf(m), Long.valueOf(((MessageRecord)localObject2).uniseq) }));
      }
      k = 1;
      bool2 = bool1;
      break label676;
      label802:
      bool2 = bool1;
      k = i;
      m = j;
      label812:
      i = m;
      j = k;
      bool1 = bool2;
      break;
      if ((((MessageRecord)localObject1).msgtype == -1036) || (((localObject1 instanceof MessageForReplyText)) && (((MessageForReplyText)localObject1).getSourceMessage() != null) && (((MessageForReplyText)localObject1).getSourceMessage().msgtype == -1036))) {
        if ((localObject1 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForLongMsg)((MessageForReplyText)localObject1).getSourceMessage();
          label893:
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
        }
      }
      label1695:
      label1706:
      for (;;)
      {
        label953:
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
          m = 0;
          if (m >= ((MessageForMixedMsg)localObject2).msgElemList.size()) {
            break label1706;
          }
          localObject3 = (MessageRecord)((MessageForMixedMsg)localObject2).msgElemList.get(m);
          if (!(localObject3 instanceof MessageForPic)) {
            break label1695;
          }
          if ((j >= paramArrayList.size()) && (QLog.isColorLevel())) {
            QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
          }
          localObject3 = (MessageForPic)localObject3;
          if (QLog.isColorLevel()) {
            QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + n + "], subMsgIndex[" + m + ", resultIndex[" + j + "]");
          }
          i1 = a((MessageForPic)localObject3, (akxr)paramArrayList.get(j));
          k = i;
          bool2 = bool1;
          if (i1 != 0)
          {
            Rf(i1);
            if (this.a.kv(i1))
            {
              bool2 = true;
              k = i;
            }
          }
          else
          {
            label1130:
            i = j + 1;
            j = k;
            bool1 = bool2;
          }
        }
        for (;;)
        {
          m += 1;
          k = j;
          j = i;
          i = k;
          break label953;
          localObject1 = (MessageForLongMsg)localObject1;
          break label893;
          localObject3 = this.a.app.a().a((MessageRecord)localObject3, acfp.m(2131709637), false);
          ((MessageForMixedMsg)localObject2).msgElemList.set(m, localObject3);
          if (QLog.isColorLevel()) {
            QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForLongMsg errCode:%d, uniseq:%d", new Object[] { Integer.valueOf(i1), Long.valueOf(((MessageRecord)localObject3).uniseq) }));
          }
          k = 1;
          bool2 = bool1;
          break label1130;
          k = i;
          i = j;
          j = k;
          break;
          if (((localObject1 instanceof MessageForStructing)) || (((localObject1 instanceof MessageForReplyText)) && (((MessageForReplyText)localObject1).getSourceMessage() != null) && ((((MessageForReplyText)localObject1).getSourceMessage() instanceof MessageForMixedMsg))))
          {
            if ((localObject1 instanceof MessageForReplyText))
            {
              localObject1 = (MessageForStructing)((MessageForReplyText)localObject1).getSourceMessage();
              localObject2 = ((MessageForStructing)localObject1).structingMsg;
            }
            for (;;)
            {
              if ((localObject2 != null) && ((localObject2 instanceof StructMsgForImageShare)))
              {
                localObject2 = ((StructMsgForImageShare)localObject2).getFirstImageElement();
                if ((localObject2 != null) && (((ansu)localObject2).j != null))
                {
                  localObject2 = ((ansu)localObject2).j;
                  if (QLog.isColorLevel()) {
                    QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + n + "], resultIndex[" + j + "]");
                  }
                  if (((MessageForStructing)localObject1).isHotPicsStruct())
                  {
                    localObject1 = new PicMessageExtraData();
                    ((PicMessageExtraData)localObject1).imageBizType = 2;
                    ((MessageForPic)localObject2).picExtraData = ((PicMessageExtraData)localObject1);
                  }
                  k = a((MessageForPic)localObject2, (akxr)paramArrayList.get(j));
                  bool2 = bool1;
                  if (k != 0)
                  {
                    Rf(k);
                    bool2 = bool1;
                    if (this.a.kv(k)) {
                      bool2 = true;
                    }
                  }
                  k = j + 1;
                  j = i;
                  bool1 = bool2;
                  i = k;
                  break;
                  localObject1 = (MessageForStructing)localObject1;
                  localObject2 = ((MessageForStructing)localObject1).structingMsg;
                  continue;
                  if (k != 0)
                  {
                    if (this.C.isReMultiMsg) {
                      anot.b(this.a.app, "CliOper", "", "", "0X800662B", "0X800662B", 0, 1, 0, "", "", "", "");
                    }
                    if (QLog.isColorLevel()) {
                      QLog.e("PicMultiMsgProcessor", 2, "requestUploadPics isPicMsgModify");
                    }
                    this.a.app.a().b().a(this.xQ, null);
                  }
                  if (this.C.isReMultiMsg) {
                    anot.b(this.a.app, "CliOper", "", "", "0X800662A", "0X800662A", 0, 1, 0, "", "", "", "");
                  }
                  return bool1;
                }
              }
            }
          }
          k = i;
          i = j;
          j = k;
          break;
          k = i;
          i = j;
          j = k;
        }
      }
      label1709:
      k = i;
      i = j;
      j = k;
    }
  }
  
  private void Rf(int paramInt)
  {
    if (this.wN == null) {
      this.wN = new ArrayList();
    }
    this.wN.add(Integer.valueOf(paramInt));
  }
  
  private int a(MessageForPic paramMessageForPic, akxr paramakxr)
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
        if (paramakxr.aVW)
        {
          if (!localElem.not_online_image.res_id.has()) {
            break label319;
          }
          localObject = localElem.not_online_image.res_id.get().toStringUtf8();
        }
      }
    }
    for (;;)
    {
      paramMessageForPic.uuid = ((String)localObject);
      paramMessageForPic.path = ((String)localObject);
      paramMessageForPic.md5 = aqhq.px(ajlc.bQH);
      paramMessageForPic.thumbMsgUrl = localElem.not_online_image.str_thumb_url.get();
      paramMessageForPic.thumbHeight = localElem.not_online_image.uint32_thumb_height.get();
      paramMessageForPic.thumbWidth = localElem.not_online_image.uint32_thumb_width.get();
      paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, " pic resp uuid = " + (String)localObject + " picMsgMD5 = " + paramMessageForPic.md5 + " hasCode = " + paramMessageForPic.hashCode());
      }
      int i = 1;
      for (;;)
      {
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic success");
          }
          localRichText.elems.add(localElem);
          if (paramakxr.mResult == 0)
          {
            i = 0;
            paramMessageForPic.richText = localRichText;
            return i;
            label319:
            if (!localElem.not_online_image.download_path.has()) {
              break label603;
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
              if (paramakxr.aVW)
              {
                if (localElem.custom_face.str_file_path.has()) {
                  localObject = localElem.custom_face.str_file_path.get();
                }
                paramMessageForPic.uuid = ((String)localObject);
                paramMessageForPic.path = ((String)localObject);
                paramMessageForPic.md5 = aqhq.px(ajlc.bQH);
                paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
              }
              i = 1;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("PicMultiMsgProcessor", 2, "WTF, picResult.mExtraObj is " + paramakxr.en.getClass().getSimpleName());
            }
            i = 0;
            continue;
          }
          if (paramakxr.c == null) {
            break label597;
          }
        }
      }
      label597:
      for (int j = paramakxr.c.errCode;; j = -1)
      {
        i = j;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PicMultiMsgProcessor", 2, "[requestUploadPics] Bad picture element");
        i = j;
        break;
        if (QLog.isColorLevel()) {
          QLog.e("PicMultiMsgProcessor", 2, "updateMessageForPic failed, add empty element");
        }
        i = -1;
        break;
      }
      label603:
      localObject = "";
    }
  }
  
  public void Nc(int paramInt) {}
  
  public void o(int paramInt, ArrayList<akxr> paramArrayList)
  {
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "onForwardMultiMsgPicsUpload success[" + paramArrayList.size() + "]");
      }
      boolean bool2 = J(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "updateMsgRecords done, goto onPackAndSendMsg");
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("totalCount", String.valueOf(paramArrayList.size()));
      anpc localanpc;
      if (this.wN != null)
      {
        localHashMap.put("errCount", String.valueOf(this.wN.size()));
        localHashMap.put("errCodeStr", Arrays.asList(new ArrayList[] { this.wN }).toString());
        localHashMap.put("errCode", String.valueOf(this.wN.get(0)));
        localanpc = anpc.a(BaseApplication.getContext());
        if (this.wN != null) {
          break label260;
        }
      }
      label260:
      for (bool1 = true;; bool1 = false)
      {
        localanpc.collectPerformance(null, "MultiMsgPicSendResult", bool1, 0L, paramArrayList.size(), localHashMap, null);
        bool1 = bool2;
        if (!bool1) {
          break label316;
        }
        this.jdField_b_of_type_Ajkv.a(1, 1, this.jdField_b_of_type_Ajlf);
        return;
        localHashMap.put("errCount", "0");
        localHashMap.put("errCode", "0");
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("PicMultiMsgProcessor", 2, "onForwardMultiMsgPicsUpload failed");
    }
    paramArrayList = anpc.a(BaseApplication.getContext());
    if (paramInt == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramArrayList.collectPerformance(null, "MultiMsgPicSendFail", bool1, 0L, 0L, null, null);
      bool1 = true;
      break;
    }
    label316:
    this.jdField_b_of_type_Ajkv.a(0, 1, this.jdField_b_of_type_Ajlf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajli
 * JD-Core Version:    0.7.0.1
 */