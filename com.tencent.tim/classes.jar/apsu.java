import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

class apsu
  extends accd
{
  apsu(apst paramapst) {}
  
  protected void ar(Object paramObject)
  {
    if (this.b.app == null) {}
    for (;;)
    {
      return;
      paramObject = (apcy)paramObject;
      if (((!paramObject.IsNewStatus) || (paramObject.Status != 1)) && (paramObject.Status == 12))
      {
        long l = paramObject.TroopUin;
        Iterator localIterator = this.b.app.b().f(String.valueOf(l), 1).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (ChatMessage)localIterator.next();
          if ((((ChatMessage)localObject).msgtype == -2017) && ((((ChatMessage)localObject).extraflag == 32772) || (((ChatMessage)localObject).extraflag == 32768)) && (((ChatMessage)localObject).isSendFromLocal()))
          {
            localObject = (MessageForTroopFile)localObject;
            if ((((MessageForTroopFile)localObject).uuid != null) && (((MessageForTroopFile)localObject).uuid.equals(paramObject.Id.toString()))) {
              this.b.app.b().t(((MessageForTroopFile)localObject).frienduin, ((MessageForTroopFile)localObject).istroop, ((MessageForTroopFile)localObject).uniseq);
            } else if ((!TextUtils.isEmpty(((MessageForTroopFile)localObject).url)) && (!TextUtils.isEmpty(paramObject.FilePath)) && (((MessageForTroopFile)localObject).url.equals(paramObject.FilePath))) {
              this.b.app.b().t(((MessageForTroopFile)localObject).frienduin, ((MessageForTroopFile)localObject).istroop, ((MessageForTroopFile)localObject).uniseq);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsu
 * JD-Core Version:    0.7.0.1
 */