import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUploadingManager;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class hci
  extends BizTroopObserver
{
  public hci(TroopFileUploadingManager paramTroopFileUploadingManager) {}
  
  protected void a(Object paramObject)
  {
    paramObject = (TroopFileStatusInfo)paramObject;
    if ((paramObject.jdField_a_of_type_Boolean) && (paramObject.b == 1)) {}
    for (;;)
    {
      return;
      if (paramObject.b == 12)
      {
        long l = paramObject.jdField_a_of_type_Long;
        Iterator localIterator = this.a.a.a().a(String.valueOf(l), 1, false).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (ChatMessage)localIterator.next();
          if ((((ChatMessage)localObject).msgtype == -2017) && ((((ChatMessage)localObject).extraflag == 32772) || (((ChatMessage)localObject).extraflag == 32768)) && (((ChatMessage)localObject).isSendFromLocal()))
          {
            localObject = (MessageForTroopFile)localObject;
            if ((((MessageForTroopFile)localObject).uuid != null) && (((MessageForTroopFile)localObject).uuid.equals(paramObject.jdField_a_of_type_JavaUtilUUID.toString()))) {
              this.a.a.a().a(((MessageForTroopFile)localObject).frienduin, ((MessageForTroopFile)localObject).istroop, ((MessageForTroopFile)localObject).uniseq);
            } else if ((!TextUtils.isEmpty(((MessageForTroopFile)localObject).url)) && (!TextUtils.isEmpty(paramObject.d)) && (((MessageForTroopFile)localObject).url.equals(paramObject.d))) {
              this.a.a.a().a(((MessageForTroopFile)localObject).frienduin, ((MessageForTroopFile)localObject).istroop, ((MessageForTroopFile)localObject).uniseq);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hci
 * JD-Core Version:    0.7.0.1
 */