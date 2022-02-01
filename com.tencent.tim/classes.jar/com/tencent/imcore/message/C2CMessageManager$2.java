package com.tencent.imcore.message;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.List;
import toa;
import toa.a;
import ton;
import top;

public class C2CMessageManager$2
  implements Runnable
{
  public C2CMessageManager$2(toa paramtoa, QQMessageFacade.b paramb, int paramInt, String paramString, toa.a parama, FragmentActivity paramFragmentActivity) {}
  
  public void run()
  {
    this.this$0.b(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$b);
    Object localObject2 = this.this$0.app.a(this.val$type).l(this.val$uin, this.val$type);
    Object localObject1;
    int i;
    if (localObject2 != null)
    {
      long l = ((MessageRecord)((List)localObject2).get(0)).uniseq;
      localObject1 = new ArrayList();
      this.this$0.b(this.val$uin, this.val$type, l, 200 - ((List)localObject2).size(), this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$b, (ArrayList)localObject1);
      if (((ArrayList)localObject1).size() <= 200 - ((List)localObject2).size()) {
        break label397;
      }
      i = ((ArrayList)localObject1).size() - (200 - ((List)localObject2).size());
    }
    for (;;)
    {
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (ChatMessage)((ArrayList)localObject1).get(i);
        if ((top.t((MessageRecord)localObject2)) || (((ChatMessage)localObject2).msgUid != this.jdField_a_of_type_Toa$a.origUid) || (((ChatMessage)localObject2).time != this.jdField_a_of_type_Toa$a.time)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          do
          {
            do
            {
              this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$b.count = 15;
              this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$b.aaU = 0;
              localObject1 = toa.a(this.this$0, this.val$uin, this.val$type, 15, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$b, this.jdField_a_of_type_Toa$a);
            } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
            localObject1 = (ChatMessage)((List)localObject1).get(0);
          } while ((top.t((MessageRecord)localObject1)) || (((ChatMessage)localObject1).msgUid != this.jdField_a_of_type_Toa$a.origUid) || (((ChatMessage)localObject1).time != this.jdField_a_of_type_Toa$a.time));
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$b.isSuccess = true;
          this.this$0.b.as(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$b);
        }
        for (;;)
        {
          this.this$0.b.mUIHandler.post(new C2CMessageManager.2.2(this));
          return;
          i += 1;
          break;
          this.this$0.b.mUIHandler.post(new C2CMessageManager.2.1(this));
        }
      }
      label397:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.2
 * JD-Core Version:    0.7.0.1
 */