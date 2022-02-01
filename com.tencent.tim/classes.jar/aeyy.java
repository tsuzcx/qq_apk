import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import java.lang.ref.WeakReference;

public class aeyy
  implements ArkAppRootLayout.a
{
  public aeyy(ArkBabyqCardInfo paramArkBabyqCardInfo) {}
  
  public void cdB()
  {
    if ((this.a.mBabyQReplyMsg != null) && (this.a.mBabyQReplyMsg.get() != null))
    {
      Object localObject = (MessageForArkBabyqReply)this.a.mBabyQReplyMsg.get();
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {
        localObject = (adqx)((QQAppInterface)localObject).getBusinessHandler(95);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyy
 * JD-Core Version:    0.7.0.1
 */