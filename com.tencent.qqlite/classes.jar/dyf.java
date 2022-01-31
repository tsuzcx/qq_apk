import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.MultiMsgPicsUploadAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

public class dyf
  extends UiCallBack.MultiMsgPicsUploadAdapter
{
  public dyf(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, QQAppInterface paramQQAppInterface, String paramString, int paramInt, HashMap paramHashMap, MessageRecord paramMessageRecord) {}
  
  private boolean a(MessageForPic paramMessageForPic, PicResult paramPicResult)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    int i;
    boolean bool;
    if (paramPicResult.a != null) {
      if ((paramPicResult.a instanceof im_msg_body.NotOnlineImage))
      {
        localElem.not_online_image.set((im_msg_body.NotOnlineImage)paramPicResult.a);
        i = 1;
        if (i == 0) {
          break label194;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "updateMessageForPic success");
        }
        localRichText.elems.add(localElem);
        if (paramPicResult.d != 0) {
          break label174;
        }
        bool = true;
      }
    }
    for (;;)
    {
      paramMessageForPic.richText = localRichText;
      return bool;
      if ((paramPicResult.a instanceof im_msg_body.CustomFace))
      {
        localElem.custom_face.set((im_msg_body.CustomFace)paramPicResult.a);
        i = 1;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg", 2, "WTF, picResult.mExtraObj is " + paramPicResult.a.getClass().getSimpleName());
      }
      i = 0;
      break;
      label174:
      if (QLog.isColorLevel())
      {
        QLog.e("MultiMsg", 2, "[requestUploadPics] Bad picture element");
        bool = false;
        continue;
        label194:
        if (QLog.isColorLevel()) {
          QLog.e("MultiMsg", 2, "updateMessageForPic failed, add empty element");
        }
      }
      bool = false;
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    int j = 0;
    int i = 0;
    boolean bool = true;
    Object localObject1;
    if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if ((localObject1 instanceof MessageForPic))
      {
        if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
          QLog.e("MultiMsg", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
        }
        localObject1 = (MessageForPic)localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + j + "], resultIndex[" + i + "]");
        }
        if (!a((MessageForPic)localObject1, (PicResult)paramArrayList.get(i))) {
          bool = false;
        }
        i += 1;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = (MessageForMixedMsg)localObject1;
        if (((MessageForMixedMsg)localObject1).msgElemList != null)
        {
          int k = 0;
          if (k < ((MessageForMixedMsg)localObject1).msgElemList.size())
          {
            Object localObject2 = (MessageRecord)((MessageForMixedMsg)localObject1).msgElemList.get(k);
            if ((localObject2 instanceof MessageForPic))
            {
              if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
                QLog.e("MultiMsg", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
              }
              localObject2 = (MessageForPic)localObject2;
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + j + "], subMsgIndex[" + k + ", resultIndex[" + i + "]");
              }
              if (!a((MessageForPic)localObject2, (PicResult)paramArrayList.get(i))) {
                bool = false;
              }
              i += 1;
            }
            for (;;)
            {
              k += 1;
              break;
              return bool;
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "onForwardMultiMsgPicsUpload success[" + paramArrayList.size() + "]");
      }
      bool2 = a(paramArrayList);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiMsg", 2, "updateMsgRecords done, goto onPackAndSendMsg");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      MultiMsgManager.a().b("pics upload ");
      MultiMsgManager.a().c();
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_JavaUtilArrayList, bool1);
      return;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("MultiMsg", 2, "onForwardMultiMsgPicsUpload failed");
        bool1 = bool2;
      }
    }
  }
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dyf
 * JD-Core Version:    0.7.0.1
 */