import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class ajll
  extends angu.b
{
  ArrayList<Integer> wN = null;
  
  ajll(ajlk paramajlk, ArrayList paramArrayList, HashMap paramHashMap, ajkv paramajkv, ajlf paramajlf) {}
  
  private void Rf(int paramInt)
  {
    if (this.wN == null) {
      this.wN = new ArrayList();
    }
    this.wN.add(Integer.valueOf(paramInt));
  }
  
  public void h(int paramInt, ArrayList<angq> paramArrayList)
  {
    int j = 0;
    int i = 0;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoMultiMsgProcessor", 2, "onMultiForwardVideoUploadResult success[" + paramArrayList.size() + "]");
      }
      j = 0;
      int k = 0;
      paramInt = i;
      Object localObject2;
      while (k < this.xR.size())
      {
        localObject2 = (MessageRecord)this.xR.get(k);
        if (j >= paramArrayList.size())
        {
          QLog.e("VideoMultiMsgProcessor", 1, "MultiForwardVideo: error index!");
          i = paramInt;
          paramInt = j;
          k += 1;
          j = paramInt;
          paramInt = i;
        }
        else
        {
          localObject1 = (angq)paramArrayList.get(j);
          i = paramInt;
          if (localObject1 != null)
          {
            if ((((angq)localObject1).mResult != 0) || (((angq)localObject1).en == null) || (!(((angq)localObject1).en instanceof im_msg_body.RichText))) {
              break label200;
            }
            ((MessageForShortVideo)localObject2).richText = ((im_msg_body.RichText)((angq)localObject1).en);
            i = paramInt;
          }
          for (;;)
          {
            paramInt = j + 1;
            break;
            label200:
            i = paramInt;
            if (((angq)localObject1).mResult == -1)
            {
              i = paramInt;
              if (((angq)localObject1).c != null) {
                if ("cancel".equals(((angq)localObject1).c.bUJ))
                {
                  i = 1;
                  Rf(1);
                }
                else
                {
                  Rf(((angq)localObject1).c.errCode);
                  if (this.a.kv(((angq)localObject1).c.errCode))
                  {
                    i = 1;
                  }
                  else
                  {
                    localObject2 = this.a.app.a().a((MessageRecord)localObject2, ajlk.access$000(), true);
                    bool = this.a.app.a().a(this.lH, (MessageRecord)localObject2);
                    QLog.e("VideoMultiMsgProcessor", 1, String.format("MultiForwardVideo errCode:%d, errStr:%s, update:%s, uniseq:%d", new Object[] { Integer.valueOf(((angq)localObject1).c.errCode), ((angq)localObject1).c.bUJ, Boolean.valueOf(bool), Long.valueOf(((MessageRecord)localObject2).uniseq) }));
                    i = paramInt;
                  }
                }
              }
            }
          }
        }
      }
      Object localObject1 = new HashMap();
      ((HashMap)localObject1).put("totalCount", String.valueOf(paramArrayList.size()));
      if (this.wN != null)
      {
        ((HashMap)localObject1).put("errCount", String.valueOf(this.wN.size()));
        ((HashMap)localObject1).put("errCodeStr", Arrays.asList(new ArrayList[] { this.wN }).toString());
        ((HashMap)localObject1).put("errCode", String.valueOf(this.wN.get(0)));
        localObject2 = anpc.a(BaseApplication.getContext());
        if (this.wN != null) {
          break label562;
        }
      }
      label562:
      for (bool = true;; bool = false)
      {
        ((anpc)localObject2).collectPerformance(null, "MultiMsgVideoSendResult", bool, 0L, paramArrayList.size(), (HashMap)localObject1, null);
        if (paramInt == 0) {
          break label621;
        }
        this.jdField_b_of_type_Ajkv.a(1, 8, this.jdField_b_of_type_Ajlf);
        return;
        ((HashMap)localObject1).put("errCount", "0");
        ((HashMap)localObject1).put("errCode", "0");
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoMultiMsgProcessor", 2, "onMultiForwardVideoUploadResult failed!");
    }
    paramArrayList = anpc.a(BaseApplication.getContext());
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayList.collectPerformance(null, "MultiMsgVideoSendFail", bool, 0L, 0L, null, null);
      paramInt = j;
      break;
    }
    label621:
    this.jdField_b_of_type_Ajkv.a(0, 8, this.jdField_b_of_type_Ajlf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajll
 * JD-Core Version:    0.7.0.1
 */