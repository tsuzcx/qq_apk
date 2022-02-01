import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class anzf
{
  private static long aoA = aoz + (aoy - aox);
  private static long aoB = 4100000000L;
  private static long aoC = 4200000000L;
  private static long aoD = aoA;
  private static long aoE = aoD + (aoC - aoB);
  private static long aoF = 3800000000L;
  private static long aoG = 4000000000L;
  private static long aoH = aoE;
  private static long aoI = aoH + (aoG - aoF);
  private static long aoJ = 2601000000L;
  private static long aoK = 2652000000L;
  private static long aoL = 336000000L;
  private static long aoM = 387000000L;
  private static long aoN = 510000000L;
  private static long aoO = 2010000000L;
  private static long aoP = aoI;
  private static long aoQ = aoP + (aoO - aoN);
  private static long aoh = 202000000L;
  private static long aoi = 213000000L;
  private static long aoj;
  private static long aok = aoj + (aoi - aoh);
  private static long aol = 480000000L;
  private static long aom = 489000000L;
  private static long aon = aok;
  private static long aoo = aon + (aom - aol);
  private static long aop = 2100000000L;
  private static long aoq = 2147000000L;
  private static long aor = aoo;
  private static long aos = aor + (aoq - aop);
  private static long aot = 2010000000L;
  private static long aou = 2100000000L;
  private static long aov = aos;
  private static long aow = aov + (aou - aot);
  private static long aox = 2147000000L;
  private static long aoy = 2200000000L;
  private static long aoz = aow;
  
  public static void a(structmsg.StructMsg paramStructMsg, int paramInt1, String paramString, int paramInt2)
  {
    if (paramStructMsg != null) {
      switch (paramStructMsg.msg_type.get())
      {
      }
    }
    List localList;
    do
    {
      do
      {
        return;
        localList = paramStructMsg.msg.actions.get();
      } while ((localList == null) || (localList.size() <= paramInt1));
      str = ((structmsg.SystemMsgAction)localList.get(paramInt1)).result.get();
      paramStructMsg.msg.msg_decided.set(str);
      paramStructMsg.msg.msg_detail.set(paramString);
      paramInt1 = aN(paramStructMsg.msg.sub_type.get(), ((structmsg.SystemMsgAction)localList.get(paramInt1)).action_info.type.get());
      paramStructMsg.msg.sub_type.set(paramInt1);
      paramStructMsg.msg.actions.clear();
      return;
      localList = paramStructMsg.msg.actions.get();
    } while ((localList == null) || (localList.size() <= paramInt1) || (!bp(paramStructMsg.msg.sub_type.get(), paramStructMsg.msg.group_msg_type.get())));
    String str = ((structmsg.SystemMsgAction)localList.get(paramInt1)).result.get();
    paramStructMsg.msg.msg_decided.set(str);
    paramStructMsg.msg.msg_detail.set(paramString);
    paramInt1 = q(paramStructMsg.msg.sub_type.get(), ((structmsg.SystemMsgAction)localList.get(paramInt1)).action_info.type.get(), paramStructMsg.msg.group_msg_type.get());
    paramStructMsg.msg.sub_type.set(paramInt1);
    paramStructMsg.msg.actions.clear();
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg, int paramInt, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramStructMsg != null)
    {
      bool1 = bool2;
      if (paramInt != 0)
      {
        if (paramStructMsg.msg_type.get() != 1) {
          break label116;
        }
        if ((paramStructMsg.msg.sub_type.get() != 9) && (paramStructMsg.msg.sub_type.get() != 10))
        {
          bool1 = bool2;
          if (paramStructMsg.msg.sub_type.get() != 1) {}
        }
        else
        {
          paramStructMsg.msg.msg_decided.set(paramString2);
          paramStructMsg.msg.msg_detail.set(paramString1);
          paramStructMsg.msg.actions.clear();
          bool1 = true;
        }
      }
    }
    label116:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramStructMsg.msg_type.get() != 2);
    paramStructMsg.msg.sub_type.set(5);
    paramStructMsg.msg.msg_decided.set(paramString2);
    paramStructMsg.msg.msg_detail.set(paramString1);
    paramStructMsg.msg.actions.clear();
    return true;
  }
  
  public static int aN(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {}
    switch (paramInt2)
    {
    default: 
      return paramInt1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 7;
    }
    return 8;
  }
  
  public static String bF(long paramLong)
  {
    long l2 = 0L;
    int j = -1;
    int i = j;
    long l1 = l2;
    if (paramLong >= aoj)
    {
      i = j;
      l1 = l2;
      if (paramLong < aok)
      {
        l1 = paramLong - aoj + aoh;
        i = 0;
      }
    }
    j = i;
    l2 = l1;
    if (paramLong >= aon)
    {
      j = i;
      l2 = l1;
      if (paramLong < aoo)
      {
        l2 = paramLong - aon + aol;
        j = 0;
      }
    }
    i = j;
    l1 = l2;
    if (paramLong >= aor)
    {
      i = j;
      l1 = l2;
      if (paramLong < aos)
      {
        l1 = paramLong - aor + aop;
        i = 0;
      }
    }
    j = i;
    l2 = l1;
    if (paramLong >= aov)
    {
      j = i;
      l2 = l1;
      if (paramLong < aow)
      {
        l2 = paramLong - aov + aot;
        j = 0;
      }
    }
    i = j;
    l1 = l2;
    if (paramLong >= aoz)
    {
      i = j;
      l1 = l2;
      if (paramLong < aoA)
      {
        l1 = paramLong - aoz + aox;
        i = 0;
      }
    }
    j = i;
    l2 = l1;
    if (paramLong >= aoD)
    {
      j = i;
      l2 = l1;
      if (paramLong < aoE)
      {
        l2 = paramLong - aoD + aoB;
        j = 0;
      }
    }
    i = j;
    l1 = l2;
    if (paramLong >= aoH)
    {
      i = j;
      l1 = l2;
      if (paramLong < aoI)
      {
        if ((paramLong >= aoL) && (paramLong < aoM))
        {
          l1 = aoL;
          l1 = aoJ;
        }
        l1 = paramLong - aoH + aoF;
        i = 0;
      }
    }
    j = i;
    l2 = l1;
    if (paramLong >= aoP)
    {
      j = i;
      l2 = l1;
      if (paramLong < aoQ)
      {
        l2 = paramLong - aoP + aoN;
        j = 0;
      }
    }
    if (j == 0) {
      return String.valueOf(l2);
    }
    return null;
  }
  
  private static boolean bp(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt1 == 3) {
      if (paramInt2 != 10)
      {
        bool1 = bool2;
        if (paramInt2 != 11) {}
      }
      else
      {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean lL(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 12) || (paramInt == 13);
  }
  
  public static int q(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt2 == 11)
    {
      i = paramInt1;
      if (paramInt1 == 1) {
        switch (paramInt3)
        {
        default: 
          i = 2;
        }
      }
    }
    do
    {
      do
      {
        return i;
        return 2;
        if (paramInt2 != 12) {
          break;
        }
        i = paramInt1;
      } while (paramInt1 != 1);
      switch (paramInt3)
      {
      default: 
        return 3;
      }
      return 3;
      if (paramInt2 == 13) {
        return 3;
      }
      if (paramInt2 == 14) {
        return 4;
      }
      i = paramInt1;
    } while (paramInt2 != 16);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzf
 * JD-Core Version:    0.7.0.1
 */