package com.tencent.mobileqq.activity.main;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import yqv;
import ysf;
import zbq;
import zju;

public class MainAssistObserver$13
  implements Runnable
{
  public MainAssistObserver$13(zju paramzju, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        Object localObject1 = (zbq)this.l.getManager(295);
        localObject3 = (ysf)this.l.getManager(34);
        int i = ((ysf)localObject3).xq();
        if (i > 0)
        {
          localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(5);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set(i + "");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("{'cn':'#FF0000'}");
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("UndealCount.updateTabContactNotify", 2, "unread=" + i);
            localObject1 = localObject3;
          }
          localObject3 = this.this$0.ce.obtainMessage(3);
          ((Message)localObject3).obj = localObject1;
          this.this$0.ce.sendMessage((Message)localObject3);
          return;
        }
        if (((ysf)localObject3).Ul())
        {
          localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(0);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set("");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("");
          localObject1 = localObject3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("UndealCount.updateTabContactNotify", 2, "redpoint");
          localObject1 = localObject3;
          continue;
        }
        if (localException == null) {
          break label236;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject2;
      if (localException.Vd()) {
        localObject2 = null;
      } else {
        label236:
        if (yqv.a(this.l).Uh())
        {
          localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(0);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set("");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("");
          localObject2 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("NewFriendVerification.manager", 2, "updateTabContactNotify redpoint");
            localObject2 = localObject3;
          }
        }
        else
        {
          localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.13
 * JD-Core Version:    0.7.0.1
 */