import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.utils.CardUtil;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

public class wpx
  implements Runnable
{
  public wpx(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
        int i = ((NewFriendManager)localObject1).d() + CardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        Object localObject3;
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
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.obtainMessage(3);
          ((Message)localObject3).obj = localObject1;
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.sendMessage((Message)localObject3);
          return;
        }
        if (((NewFriendManager)localObject1).a())
        {
          localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(0);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set("");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("");
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("UndealCount.updateTabContactNotify", 2, "redpoint");
            localObject1 = localObject3;
          }
        }
        else
        {
          Object localObject2 = null;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpx
 * JD-Core Version:    0.7.0.1
 */