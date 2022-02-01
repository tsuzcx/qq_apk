import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class ajle
  extends angu.b
{
  ajle(ajlc paramajlc, ArrayList paramArrayList, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap paramHashMap, int paramInt2) {}
  
  public void h(int paramInt, ArrayList<angq> paramArrayList)
  {
    int i;
    int k;
    int j;
    MessageRecord localMessageRecord;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "onMultiForwardVideoUploadResult success[" + paramArrayList.size() + "]");
      }
      i = 0;
      k = 0;
      paramInt = 0;
      j = paramInt;
      if (k >= this.xO.size()) {
        break label278;
      }
      localMessageRecord = (MessageRecord)this.xO.get(k);
      if (!(localMessageRecord instanceof MessageForShortVideo)) {
        break label363;
      }
      if (i >= paramArrayList.size())
      {
        QLog.e("MultiMsg_TAG", 1, "MultiForwardVideo: error index!");
        j = i;
        i = paramInt;
        paramInt = j;
      }
    }
    for (;;)
    {
      k += 1;
      j = i;
      i = paramInt;
      paramInt = j;
      break;
      angq localangq = (angq)paramArrayList.get(i);
      j = paramInt;
      if (localangq != null)
      {
        if ((localangq.mResult != 0) || (localangq.en == null) || (!(localangq.en instanceof im_msg_body.RichText))) {
          break label213;
        }
        ((MessageForShortVideo)localMessageRecord).richText = ((im_msg_body.RichText)localangq.en);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = i + 1;
        i = j;
        break;
        label213:
        j = paramInt;
        if (localangq.mResult == -1)
        {
          j = paramInt;
          if (localangq.c != null)
          {
            j = paramInt;
            if ("cancel".equals(localangq.c.bUJ)) {
              j = 1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "onMultiForwardVideoUploadResult failed!");
      }
      j = 0;
      label278:
      if (j != 0) {
        ajlc.a(this.this$0, this.C, this.val$app, this.bQI, this.dhX);
      }
      do
      {
        return;
        ajlc.a(this.this$0, 2);
      } while (ajlc.c(this.this$0) != 0);
      ajlc.a(this.this$0, this.val$app, this.bQI, this.dhX, this.lE, this.C, null, this.xO, false, this.djH);
      return;
      label363:
      j = paramInt;
      paramInt = i;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajle
 * JD-Core Version:    0.7.0.1
 */