package com.tencent.mobileqq.vip;

import acno;
import android.content.Context;
import android.text.TextUtils;
import aquv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AioVipKeywordHelper$1
  implements Runnable
{
  public void run()
  {
    if (this.this$0.N != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 4, "keyword has been detected, message is ignored.");
      }
    }
    label264:
    label400:
    for (;;)
    {
      return;
      if (this.this$0.k(this.val$app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        Object localObject1 = this.this$0;
        Context localContext = this.val$mContext;
        Object localObject2 = this.val$app.getCurrentAccountUin();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localObject2 = aquv.a((aquv)localObject1, localContext, (String)localObject2, bool);
          if ((localObject2 != null) && (localObject2.length != 0)) {
            break;
          }
          QLog.e("AioVipKeywordHelper", 1, "vipKeywords null");
          return;
        }
        localObject1 = this.SS.toLowerCase();
        int i = 0;
        for (;;)
        {
          if (i >= localObject2.length) {
            break label400;
          }
          localContext = localObject2[i];
          if ((!TextUtils.isEmpty(localContext)) && (((String)localObject1).contains(localContext)))
          {
            if ((this.this$0.ie != null) && (this.this$0.ie.length > 0))
            {
              i = 0;
              for (;;)
              {
                if (i >= this.this$0.ie.length) {
                  break label264;
                }
                localObject2 = this.this$0.ie[i];
                if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject1).contains((CharSequence)localObject2)))
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("AioVipKeywordHelper", 4, "detected Keyword but contain dirty word, keyword=" + localContext + ", dirty word=" + (String)localObject2);
                  return;
                }
                i += 1;
              }
            }
            this.this$0.N = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (QLog.isColorLevel()) {
              QLog.d("AioVipKeywordHelper", 4, "detected Keyword, keyword=" + localContext);
            }
            if (!this.bJG)
            {
              this.this$0.b(this.val$app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localContext, false);
              return;
            }
            this.this$0.mSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            this.this$0.mKeyword = localContext;
            ((acno)this.val$app.getBusinessHandler(86)).FJ(localContext);
            ThreadManager.getUIHandler().postDelayed(new AioVipKeywordHelper.1.1(this, localContext), this.this$0.atT);
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.AioVipKeywordHelper.1
 * JD-Core Version:    0.7.0.1
 */