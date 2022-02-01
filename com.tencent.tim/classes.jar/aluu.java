import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil.1;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class aluu
{
  static int[] mM = { -1034, -2060, -2015, -2065, -2061, -5040, -5021, -2050, -2018, -2023, -2074, -7009, -7010, -7011 };
  static int[] mN = { 0, 1000, 1004, 1020, 1006, 1001, 1003, 1021, 1022, 10008 };
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageForPoke paramMessageForPoke)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramMessageForPoke == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "addBreakingIceGrayMsgTwo invalidate params uin: " + paramString);
      }
    }
    long l;
    do
    {
      do
      {
        return;
        localObject = ((acff)paramQQAppInterface.getManager(51)).b(paramString);
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("IceBreak.IceBreakingUtil", 2, "addBreakingIceGrayMsgTwo friends is null,  uin: " + paramString);
      return;
      l = paramMessageForPoke.time;
      Object localObject = String.format(Locale.getDefault(), acfp.m(2131707349), new Object[] { ((Friends)localObject).getFriendNickWithAlias() });
      paramMessageForPoke = new ahwa(paramString, paramQQAppInterface.getCurrentUin(), (String)localObject, paramInt, -5040, 655379, l);
      paramMessageForPoke.wording = ((String)localObject);
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramMessageForPoke);
      ((MessageForUniteGrayTip)localObject).isread = true;
      ((MessageForUniteGrayTip)localObject).issend = 1;
      ahwb.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009891", "0X8009891", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "addBreakingIceGrayMsgTwo [uin: %s, uinType: %s, time: %s]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(l) }));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramMessageRecord == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "clearIceBreakingFlag invalidate params uin: " + paramString);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramString.length() < 5) || (anbk.ls(paramMessageRecord.msgtype)) || (top.fB(paramMessageRecord.msgtype)) || (kU(paramMessageRecord.msgtype)));
        paramQQAppInterface = (alur)paramQQAppInterface.getManager(285);
        if (paramInt == 1)
        {
          paramQQAppInterface.Pe(paramString);
          return;
        }
      } while (!paramQQAppInterface.ow(paramString));
      paramQQAppInterface.ov(paramString);
    } while (!QLog.isColorLevel());
    QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "clearIceBreakingFlag uin: %s msgtype: %s", new Object[] { paramString, Integer.valueOf(paramMessageRecord.msgtype) }));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onAddFrdSuc invalidate params uin: " + paramString);
      }
    }
    acff localacff;
    Object localObject;
    Friends localFriends;
    do
    {
      return;
      localacff = (acff)paramQQAppInterface.getManager(51);
      localObject = (alur)paramQQAppInterface.getManager(285);
      localFriends = localacff.b(paramString);
    } while ((localFriends == null) || (!localFriends.isFriend()));
    if (yhf.a(paramQQAppInterface).TC()) {
      if (((alur)localObject).bh(true))
      {
        if (!((alur)localObject).ou(paramString)) {
          break label227;
        }
        ((alur)localObject).OZ(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("IceBreak.IceBreakingUtil", 2, "has matchChat show. uin: " + paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.i("IceBreak.IceBreakingUtil", 2, "onAddFrdSuc uin: " + paramString);
        }
      }
    }
    for (;;)
    {
      localObject = localacff.a(paramString, true);
      paramQQAppInterface = (QQAppInterface)localObject;
      if (localObject == null)
      {
        paramQQAppInterface = new ExtensionInfo();
        paramQQAppInterface.uin = paramString;
      }
      paramQQAppInterface.makeFrdsTs = System.currentTimeMillis();
      localacff.a(paramQQAppInterface);
      return;
      label227:
      ((alur)localObject).cN(paramString, true);
      break;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onAddFrdSuc emotionRec switch is off");
      }
    }
  }
  
  public static void aB(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (alur)paramQQAppInterface.getManager(285);
    boolean bool = paramQQAppInterface.ov(paramString);
    if ((paramQQAppInterface.ow(paramString)) && (QLog.isColorLevel())) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "clearIceBreakingFlag onDelFrd uin: %s %b", new Object[] { paramString, Boolean.valueOf(bool) }));
    }
  }
  
  private static void aC(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((alur)paramQQAppInterface.getManager(285)).Pg(paramString);
  }
  
  private static void aD(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((alur)paramQQAppInterface.getManager(285)).Ph(paramString);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramMessageRecord == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "checkAndAddGrayTip invalidate params uin: " + paramString);
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramMessageRecord.msgtype != -5012) || (!(paramMessageRecord instanceof MessageForPoke)) || ((((MessageForPoke)paramMessageRecord).flag & 0x8) == 0));
      MessageForPoke localMessageForPoke = (MessageForPoke)paramMessageRecord;
      if (!paramMessageRecord.isSend()) {
        ThreadManager.excute(new IceBreakingUtil.2(paramQQAppInterface, paramString, paramInt, localMessageForPoke), 16, null, false);
      }
    } while (!QLog.isColorLevel());
    QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "checkAndAddGrayTip send: %s, time: %s", new Object[] { Integer.valueOf(paramMessageRecord.issend), Long.valueOf(paramMessageRecord.time) }));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    ThreadManager.post(new IceBreakingUtil.1(paramInt, paramQQAppInterface, paramString, paramBoolean), 5, null, true);
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (((kV(paramInt)) || (kW(paramInt)) || (kX(paramInt))) && (!aqft.rj(paramString)) && (!aprg.V(paramQQAppInterface, paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IceBreak.IceBreakingUtil", 2, String.format("canShowIceBreak, type: %s, uin: %s, canShow: %s", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(bool) }));
      }
      return bool;
    }
  }
  
  public static boolean kU(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < mM.length)
      {
        if (paramInt == mM[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean kV(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < mN.length)
      {
        if (paramInt == mN[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean kW(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static boolean kX(int paramInt)
  {
    return aine.kg(paramInt);
  }
  
  private static void m(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramString.length() < 5)) {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak invalidate params uin: " + paramString);
      }
    }
    label549:
    label699:
    label751:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak uin=%s forceLocal=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
      }
      if (!yhf.a(paramQQAppInterface).TC())
      {
        if (QLog.isColorLevel()) {
          QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak emotionRec switch is off");
        }
      }
      else
      {
        alur localalur = (alur)paramQQAppInterface.getManager(285);
        if (!localalur.bh(false))
        {
          if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak switch is off");
          }
        }
        else
        {
          if (localalur.os(paramString))
          {
            QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak entered c2c");
            return;
          }
          acff localacff = (acff)paramQQAppInterface.getManager(51);
          Object localObject1 = localacff.b(paramString);
          if ((localObject1 == null) || (!((Friends)localObject1).isFriend()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak not friend");
            }
          }
          else if (localalur.ow(paramString))
          {
            if (QLog.isColorLevel()) {
              QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak already in break list");
            }
          }
          else
          {
            float f = localalur.bu();
            Object localObject2 = localacff.a(paramString, true);
            if ((localObject2 != null) && (((ExtensionInfo)localObject2).makeFrdsTs > 0L) && ((float)(System.currentTimeMillis() - ((ExtensionInfo)localObject2).makeFrdsTs) < 86400000.0F * f))
            {
              if (QLog.isColorLevel()) {
                QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak new make friends duration=%d nDay=%.3f", new Object[] { Long.valueOf(System.currentTimeMillis() - ((ExtensionInfo)localObject2).makeFrdsTs), Float.valueOf(f) }));
              }
            }
            else
            {
              int i = 0;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = new ExtensionInfo();
                ((ExtensionInfo)localObject1).uin = paramString;
                i = 1;
              }
              long l2 = NetConnInfoCenter.getServerTimeMillis();
              if ((float)Math.abs(l2 - ((ExtensionInfo)localObject1).lastIceBreakChatTs) < 86400000.0F * f)
              {
                if (i != 0) {
                  localacff.a((ExtensionInfo)localObject1);
                }
                if (QLog.isColorLevel()) {
                  QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak lastChatTs within nDays=%.3f", new Object[] { Float.valueOf(f) }));
                }
              }
              else
              {
                localObject2 = paramQQAppInterface.b().b(paramString, 0, yA());
                if (localObject2 == null) {}
                for (long l1 = 0L;; l1 = ((MessageRecord)localObject2).time * 1000L)
                {
                  if (l1 > ((ExtensionInfo)localObject1).lastIceBreakChatTs)
                  {
                    ((ExtensionInfo)localObject1).lastIceBreakChatTs = l1;
                    i = 1;
                  }
                  if ((float)Math.abs(l2 - l1) >= 86400000.0F * f) {
                    break label549;
                  }
                  if (i != 0) {
                    localacff.a((ExtensionInfo)localObject1);
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak last msg within nDays=%.3f", new Object[] { Float.valueOf(f) }));
                  return;
                }
                l1 = SystemClock.elapsedRealtime();
                boolean bool;
                int j;
                if ((!paramBoolean) && ((((ExtensionInfo)localObject1).lastIceBreakCheckTs == 0L) || (Math.abs(((ExtensionInfo)localObject1).lastIceBreakCheckTs - l1) > 86400000L)))
                {
                  bool = true;
                  if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak reqServer=%b lastCheckTs=%d nDays=%.3f", new Object[] { Boolean.valueOf(bool), Long.valueOf(((ExtensionInfo)localObject1).lastIceBreakCheckTs), Float.valueOf(f) }));
                  }
                  if (!bool) {
                    break label699;
                  }
                  j = i;
                  if (AppNetConnInfo.isNetSupport())
                  {
                    ((ExtensionInfo)localObject1).lastIceBreakCheckTs = l1;
                    j = 1;
                    ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).dv(paramString, (int)Math.ceil(f));
                  }
                }
                for (;;)
                {
                  if (j == 0) {
                    break label751;
                  }
                  localacff.a((ExtensionInfo)localObject1);
                  return;
                  bool = false;
                  break;
                  j = i;
                  if (paramBoolean)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak add_to_breaklist on forceLocal " + paramString);
                    }
                    localalur.cN(paramString, false);
                    j = i;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static String yA()
  {
    StringBuilder localStringBuilder = new StringBuilder(mM.length * 8);
    localStringBuilder.append("msgtype not in (");
    int i = 0;
    if (i < mM.length)
    {
      localStringBuilder.append(mM[i]);
      if (i == mM.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aluu
 * JD-Core Version:    0.7.0.1
 */