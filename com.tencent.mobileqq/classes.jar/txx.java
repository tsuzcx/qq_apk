import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class txx
{
  public static bdts a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      paramMessageRecord.parse();
      return a(paramMessageRecord.structingMsg);
    }
    return null;
  }
  
  public static bdts a(AbsStructMsg paramAbsStructMsg)
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
              localObject1 = (bdol)paramAbsStructMsg.next();
            } while (!(localObject1 instanceof bdsg));
            localObject1 = ((bdsg)localObject1).a.iterator();
          }
          localObject2 = (bdol)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof bdts));
        localObject2 = (bdts)localObject2;
      } while (!((bdts)localObject2).a());
      return localObject2;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return oyu.k + bhkv.encodeToString(paramString.getBytes(), 2);
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
        Object localObject1 = (bdol)localIterator.next();
        if ((localObject1 instanceof bdsg))
        {
          localObject1 = ((bdsg)localObject1).a.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (bdol)((Iterator)localObject1).next();
            if ((localObject2 instanceof bdts))
            {
              localObject2 = (bdts)localObject2;
              if (((bdts)localObject2).a())
              {
                ((bdts)localObject2).ag = null;
                ((bdts)localObject2).ad = null;
                ((bdts)localObject2).o = 0;
                if (QLog.isColorLevel()) {
                  QLog.d("PAVideoStructMsgUtil", 2, "simplifyForForward: summary = null");
                }
                bdll.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800682F", "0X800682F", 0, 0, ((bdts)localObject2).ae, "" + ((bdts)localObject2).v, "" + ((bdts)localObject2).a.msgId, "");
              }
            }
            else if ((localObject2 instanceof StructMsgItemTitle))
            {
              localObject2 = (StructMsgItemTitle)localObject2;
              String str = ((StructMsgItemTitle)localObject2).b();
              int i = str.length();
              if (QLog.isColorLevel()) {
                QLog.d("PAVideoStructMsgUtil", 2, "simplifyForForward: title = " + ((StructMsgItemTitle)localObject2).b() + ", length=" + i);
              }
              if (i > 15)
              {
                ((StructMsgItemTitle)localObject2).a(str.substring(0, 15) + "...");
                if (QLog.isColorLevel()) {
                  QLog.d("PAVideoStructMsgUtil", 2, "simplifyForForward: after reduce title length, title = " + ((StructMsgItemTitle)localObject2).b());
                }
              }
            }
          }
        }
      }
    } while ((TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgBrief)) || (paramStructMsgForGeneralShare.mMsgBrief.length() <= 15));
    paramStructMsgForGeneralShare.mMsgBrief = (paramStructMsgForGeneralShare.mMsgBrief.substring(0, 15) + "...");
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 1) && (paramInt <= 100);
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
          Object localObject = (bdol)paramAbsStructMsg.next();
          if (!(localObject instanceof bdsg)) {
            break label110;
          }
          localObject = ((bdsg)localObject).a.iterator();
          while (((Iterator)localObject).hasNext())
          {
            bdol localbdol = (bdol)((Iterator)localObject).next();
            if ((localbdol instanceof bdts)) {
              if (((bdts)localbdol).a()) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txx
 * JD-Core Version:    0.7.0.1
 */