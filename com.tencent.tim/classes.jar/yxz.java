import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class yxz
{
  private static boolean bpH;
  private static boolean bpI;
  private static List<MessageRecord> mDataList = new ArrayList();
  private static List<MessageRecord> tB = new ArrayList();
  private static List<MessageRecord> ty = new ArrayList();
  private static List<MessageRecord> tz = new ArrayList();
  
  public static void Ba(boolean paramBoolean)
  {
    bpH = paramBoolean;
  }
  
  public static void Bb(boolean paramBoolean)
  {
    bpI = paramBoolean;
  }
  
  public static void L(List<MessageRecord> paramList, int paramInt)
  {
    mDataList.clear();
    ty.clear();
    tz.clear();
    tB.clear();
    Object localObject = (aein)aeif.a().o(634);
    mDataList = paramList;
    if (!((aein)localObject).bUc)
    {
      tB = mDataList;
      return;
    }
    paramList = mDataList.iterator();
    int i = 0;
    label76:
    int k;
    if (paramList.hasNext())
    {
      localObject = (MessageRecord)paramList.next();
      if ((localObject instanceof MessageForSystemMsg))
      {
        structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localObject).getSystemMsg();
        if ((localStructMsg != null) && (localStructMsg.msg.has()))
        {
          int j = ((structmsg.SystemMsg)localStructMsg.msg.get()).group_msg_type.get();
          k = ((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get();
          if ((j != 13) && (j != 6)) {
            break label244;
          }
          ty.add(localObject);
          if ((i < paramInt) && (!bpH)) {
            bpH = true;
          }
        }
      }
    }
    for (;;)
    {
      if (k == 1)
      {
        tz.add(localObject);
        if ((i < paramInt) && (!bpI)) {
          bpI = true;
        }
      }
      i += 1;
      break label76;
      break;
      label244:
      tB.add(localObject);
    }
  }
  
  public static boolean UL()
  {
    return bpI;
  }
  
  public static boolean UM()
  {
    return bpH;
  }
  
  public static void cmT()
  {
    tB.clear();
    mDataList.clear();
    tz.clear();
    ty.clear();
    bpH = false;
    bpI = false;
  }
  
  public static List<MessageRecord> dc()
  {
    return ty;
  }
  
  public static List<MessageRecord> dd()
  {
    return tz;
  }
  
  public static List<MessageRecord> de()
  {
    return tB;
  }
  
  public static List<MessageRecord> df()
  {
    return mDataList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxz
 * JD-Core Version:    0.7.0.1
 */