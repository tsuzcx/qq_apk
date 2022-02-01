package com.tencent.mobileqq.activity;

import acdz;
import ajdg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class BaseChatPie$60
  implements Runnable
{
  public void run()
  {
    int i = 9;
    int m = 0;
    int j = BaseChatPie.a(this.this$0).dy(this.val$keyword);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, this.val$text + "is hotword, totalnum = " + j);
    }
    if (j == 0) {
      return;
    }
    Object localObject3 = BaseChatPie.a(this.this$0).a(this.val$keyword);
    Object localObject2 = BaseChatPie.a(this.this$0).aA(this.val$keyword);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    if (j > 9) {}
    for (;;)
    {
      long l = BaseChatPie.a(this.this$0).an(this.val$keyword);
      boolean bool;
      if (BaseChatPie.a(this.this$0).isWifiOrG3OrG4()) {
        if (System.currentTimeMillis() - l > 86400000L) {
          bool = true;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "afterTextChanged isNeedReq = " + bool);
        }
        if (bool)
        {
          ((List)localObject1).clear();
          localObject2 = new ArrayList();
          j = i;
          int k = m;
          if (localObject3 != null)
          {
            ((List)localObject2).add(((Emoticon)localObject3).eId);
            ((List)localObject1).add(localObject3);
            j = i - 1;
            k = m;
          }
          for (;;)
          {
            if (k < j)
            {
              localObject3 = new Emoticon();
              ((Emoticon)localObject3).epId = "NONE";
              ((Emoticon)localObject3).eId = ("_" + k);
              ((List)localObject1).add(localObject3);
              k += 1;
              continue;
              if (((List)localObject1).size() >= i) {
                break label411;
              }
              bool = true;
              break;
            }
          }
          localObject3 = BaseChatPie.a(this.this$0).aC(this.val$keyword);
          ((acdz)this.this$0.app.getBusinessHandler(12)).a(this.val$text, (List)localObject2, (List)localObject3);
        }
        this.this$0.uiHandler.post(new BaseChatPie.60.1(this, (List)localObject1));
        return;
        label411:
        bool = false;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.60
 * JD-Core Version:    0.7.0.1
 */