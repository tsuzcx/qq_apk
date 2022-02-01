import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class obo
{
  public static anvf a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      paramMessageRecord.parse();
      return a(paramMessageRecord.structingMsg);
    }
    return null;
  }
  
  public static anvf a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      Object localObject2;
      do
      {
        do
        {
          paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).iterator();
          Object localObject1;
          while (!((Iterator)localObject1).hasNext())
          {
            do
            {
              if (!paramAbsStructMsg.hasNext()) {
                break;
              }
              localObject1 = (anqu)paramAbsStructMsg.next();
            } while (!(localObject1 instanceof antz));
            localObject1 = ((antz)localObject1).rz.iterator();
          }
          localObject2 = (anqu)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof anvf));
        localObject2 = (anvf)localObject2;
      } while (!((anvf)localObject2).aza());
      return localObject2;
    }
    return null;
  }
  
  public static void a(StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    if (paramStructMsgForGeneralShare == null) {}
    do
    {
      return;
      Iterator localIterator = paramStructMsgForGeneralShare.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (anqu)localIterator.next();
        if ((localObject1 instanceof antz))
        {
          localObject1 = ((antz)localObject1).rz.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (anqu)((Iterator)localObject1).next();
            if ((localObject2 instanceof anvf))
            {
              localObject2 = (anvf)localObject2;
              if (((anvf)localObject2).aza())
              {
                ((anvf)localObject2).summary = null;
                ((anvf)localObject2).videoUrl = null;
                ((anvf)localObject2).dMH = 0;
                if (QLog.isColorLevel()) {
                  QLog.d("PAVideoStructMsgUtil", 2, "simplifyForForward: summary = null");
                }
                anot.a(null, "dc00899", "Pb_account_lifeservice", "", "0X800682F", "0X800682F", 0, 0, ((anvf)localObject2).ciu, "" + ((anvf)localObject2).type, "" + ((anvf)localObject2).e.msgId, "");
              }
            }
            else if ((localObject2 instanceof StructMsgItemTitle))
            {
              localObject2 = (StructMsgItemTitle)localObject2;
              String str = ((StructMsgItemTitle)localObject2).getText();
              int i = str.length();
              if (QLog.isColorLevel()) {
                QLog.d("PAVideoStructMsgUtil", 2, "simplifyForForward: title = " + ((StructMsgItemTitle)localObject2).getText() + ", length=" + i);
              }
              if (i > 15)
              {
                ((StructMsgItemTitle)localObject2).setText(str.substring(0, 15) + "...");
                if (QLog.isColorLevel()) {
                  QLog.d("PAVideoStructMsgUtil", 2, "simplifyForForward: after reduce title length, title = " + ((StructMsgItemTitle)localObject2).getText());
                }
              }
            }
          }
        }
      }
    } while ((TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgBrief)) || (paramStructMsgForGeneralShare.mMsgBrief.length() <= 15));
    paramStructMsgForGeneralShare.mMsgBrief = (paramStructMsgForGeneralShare.mMsgBrief.substring(0, 15) + "...");
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsStructMsg != null)
    {
      bool1 = bool2;
      if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
      {
        paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).iterator();
        bool1 = false;
        if (paramAbsStructMsg.hasNext())
        {
          Object localObject = (anqu)paramAbsStructMsg.next();
          if (!(localObject instanceof antz)) {
            break label110;
          }
          localObject = ((antz)localObject).rz.iterator();
          while (((Iterator)localObject).hasNext())
          {
            anqu localanqu = (anqu)((Iterator)localObject).next();
            if ((localanqu instanceof anvf)) {
              if (((anvf)localanqu).aza()) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    label110:
    for (;;)
    {
      break;
      return bool1;
    }
  }
  
  public static boolean ek(int paramInt)
  {
    return (paramInt >= 1) && (paramInt <= 100);
  }
  
  public static String fj(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return kwt.acJ + aqgo.encodeToString(paramString.getBytes(), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obo
 * JD-Core Version:    0.7.0.1
 */