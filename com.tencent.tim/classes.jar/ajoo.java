import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class ajoo
{
  private static boolean T(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    for (;;)
    {
      return false;
      int[] arrayOfInt = new int[20];
      int[] tmp12_11 = arrayOfInt;
      tmp12_11[0] = -1000;
      int[] tmp18_12 = tmp12_11;
      tmp18_12[1] = -1001;
      int[] tmp24_18 = tmp18_12;
      tmp24_18[2] = -2009;
      int[] tmp30_24 = tmp24_18;
      tmp30_24[3] = -2045;
      int[] tmp36_30 = tmp30_24;
      tmp36_30[4] = -2009;
      int[] tmp42_36 = tmp36_30;
      tmp42_36[5] = -2001;
      int[] tmp48_42 = tmp42_36;
      tmp48_42[6] = -2005;
      int[] tmp55_48 = tmp48_42;
      tmp55_48[7] = -2010;
      int[] tmp62_55 = tmp55_48;
      tmp62_55[8] = -2000;
      int[] tmp69_62 = tmp62_55;
      tmp69_62[9] = -2002;
      int[] tmp76_69 = tmp69_62;
      tmp76_69[10] = -2008;
      int[] tmp83_76 = tmp76_69;
      tmp83_76[11] = -2022;
      int[] tmp90_83 = tmp83_76;
      tmp90_83[12] = -30002;
      int[] tmp97_90 = tmp90_83;
      tmp97_90[13] = -2011;
      int[] tmp104_97 = tmp97_90;
      tmp104_97[14] = -2020;
      int[] tmp111_104 = tmp104_97;
      tmp111_104[15] = -2025;
      int[] tmp118_111 = tmp111_104;
      tmp118_111[16] = -2065;
      int[] tmp125_118 = tmp118_111;
      tmp125_118[17] = -2066;
      int[] tmp132_125 = tmp125_118;
      tmp132_125[18] = -3000;
      int[] tmp139_132 = tmp132_125;
      tmp139_132[19] = -1035;
      tmp139_132;
      int i = 0;
      while (i < arrayOfInt.length)
      {
        if (paramChatMessage.msgtype == arrayOfInt[i]) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForUniteGrayTip paramMessageForUniteGrayTip, MqqHandler paramMqqHandler, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt)
  {
    Object localObject = null;
    if (kz(paramMessageForUniteGrayTip.subType))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "new message graytips big ship");
      }
      paramMqqHandler.sendEmptyMessage(70);
    }
    for (;;)
    {
      return;
      if (kA(paramMessageForUniteGrayTip.subType))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendReactive", 2, "new message graytips friendship");
        }
        paramMqqHandler.sendEmptyMessage(88);
        return;
      }
      if (kB(paramMessageForUniteGrayTip.subType))
      {
        paramMqqHandler.obtainMessage(201, new String[] { paramMessageForUniteGrayTip.caidanAnimUrl, paramMessageForUniteGrayTip.caidanAnimUrlMd5 }).sendToTarget();
        return;
      }
      if (kC(paramMessageForUniteGrayTip.subType))
      {
        if (!TextUtils.isEmpty(paramMessageForUniteGrayTip.caidanAnimUrl)) {
          wnf.a().a(paramQQAppInterface, false, true, paramAIOAnimationConatiner, 0, new ajns(BaseApplicationImpl.getContext(), paramMessageForUniteGrayTip.caidanAnimUrl), 4);
        }
      }
      else
      {
        paramMqqHandler = wnf.a();
        if (paramInt == 3) {
          paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851200);
        }
        while (paramMessageForUniteGrayTip != null)
        {
          paramMqqHandler.a(paramQQAppInterface, false, true, paramAIOAnimationConatiner, 0, paramMessageForUniteGrayTip, 4);
          return;
          if (paramInt == 26)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851201);
          }
          else if (paramInt == 27)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851202);
          }
          else if (paramInt == 4)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851158);
          }
          else if (paramInt == 28)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851159);
          }
          else if (paramInt == 29)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851160);
          }
          else if (paramInt == 1)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851204);
          }
          else if (paramInt == 2)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851162);
          }
          else if (paramInt == 5)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851203);
          }
          else if (paramInt == 30)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851205);
          }
          else if (paramInt == 31)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851206);
          }
          else if (paramInt == 7)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851198);
          }
          else if (paramInt == 8)
          {
            paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851199);
          }
          else
          {
            paramMessageForUniteGrayTip = localObject;
            if (paramInt != 11) {
              if (paramInt == 12)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851174);
              }
              else if (paramInt == 13)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851175);
              }
              else if (paramInt == 14)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851182);
              }
              else if (paramInt == 15)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851183);
              }
              else if (paramInt == 16)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851184);
              }
              else if (paramInt == 17)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851176);
              }
              else if (paramInt == 18)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851177);
              }
              else if (paramInt == 19)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851178);
              }
              else if (paramInt == 20)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851179);
              }
              else if (paramInt == 21)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851180);
              }
              else if (paramInt == 22)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851181);
              }
              else if (paramInt == 23)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851185);
              }
              else if (paramInt == 24)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851186);
              }
              else if (paramInt == 25)
              {
                paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(2130851187);
              }
              else
              {
                paramMessageForUniteGrayTip = localObject;
                if (ajnu.kx(paramInt))
                {
                  paramMessageForUniteGrayTip = localObject;
                  if (paramSessionInfo != null)
                  {
                    paramInt = ajnl.c(paramQQAppInterface, paramSessionInfo.aTl, String.valueOf(paramInt));
                    paramMessageForUniteGrayTip = localObject;
                    if (paramInt != 0) {
                      paramMessageForUniteGrayTip = BaseApplicationImpl.getContext().getResources().getDrawable(paramInt);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List<ChatMessage> paramList, xys paramxys)
  {
    if ((acyx.a().add()) && (a(paramQQAppInterface, paramSessionInfo, paramList)))
    {
      paramxys.bkO = true;
      acyx.a().cPf();
      if (QLog.isColorLevel()) {
        QLog.i("OldMutualMarkLogicHelper", 2, "checkLightingQzoneLover enter!!!!!!!!");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("OldMutualMarkLogicHelper", 2, "checkLightingQzoneLover not enter!!!!!!!!");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, xys paramxys)
  {
    ThreadManager.post(new OldMutualMarkLogicHelper.1(paramQQAppInterface, paramSessionInfo, paramxys), 5, null, false);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramSessionInfo == null) || (paramQQAppInterface == null)) {
      return false;
    }
    long l1 = anaz.gQ();
    Time localTime1 = new Time();
    localTime1.set(1000L * l1);
    Time localTime2 = new Time();
    boolean bool1 = false;
    boolean bool2 = false;
    int i = paramList.size() - 1;
    for (;;)
    {
      boolean bool3 = bool2;
      boolean bool4 = bool1;
      if (i >= 0) {}
      try
      {
        localChatMessage = (ChatMessage)paramList.get(i);
        if (localChatMessage == null)
        {
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          break label412;
        }
        long l2 = Math.abs(localChatMessage.time - l1);
        if (l2 <= 86400L) {
          break label201;
        }
        bool4 = bool1;
        bool3 = bool2;
      }
      catch (Throwable paramQQAppInterface)
      {
        for (;;)
        {
          ChatMessage localChatMessage;
          bool4 = false;
          bool3 = false;
          QLog.e("OldMutualMarkLogicHelper", 1, "hasInteractiveToday error: " + paramQQAppInterface.getMessage());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("OldMutualMarkLogicHelper", 2, "hasInteractiveToday selfSend:" + bool4 + " friendSend: " + bool3);
      }
      if ((bool4) && (bool3))
      {
        return true;
        label201:
        if (!T(localChatMessage))
        {
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          break label412;
        }
        if ((TextUtils.equals(localChatMessage.senderuin, paramSessionInfo.aTl)) || (TextUtils.equals(localChatMessage.senderuin, paramQQAppInterface.getCurrentAccountUin())))
        {
          localTime2.set(localChatMessage.time * 1000L);
          if ((localTime1.year == localTime2.year) && (localTime1.yearDay == localTime2.yearDay))
          {
            bool3 = TextUtils.equals(localChatMessage.senderuin, paramSessionInfo.aTl);
            if (bool3)
            {
              bool3 = true;
              bool4 = bool1;
            }
            for (;;)
            {
              bool1 = bool3;
              bool2 = bool4;
              if (!bool4) {
                break label412;
              }
              bool1 = bool3;
              bool2 = bool4;
              if (!bool3) {
                break label412;
              }
              break;
              bool4 = true;
              bool3 = bool2;
            }
          }
        }
      }
      else
      {
        return false;
      }
      bool3 = bool2;
      bool2 = bool1;
      bool1 = bool3;
      label412:
      i -= 1;
      bool3 = bool2;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, Boolean paramBoolean, int paramInt1, int paramInt2, boolean paramBoolean1, ExtensionInfo paramExtensionInfo, int paramInt3)
  {
    boolean bool = true;
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    SharedPreferences.Editor localEditor = paramQQAppInterface.edit();
    int i = paramQQAppInterface.getInt(paramString, 0);
    if ((i >= paramInt3) || ((paramInt1 & paramInt2) > 0) || (!paramBoolean1)) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("reactivetip", 2, "checkReactiveGraytip remindTimes=" + i + "isRemind=" + paramInt1 + "needRemind=" + paramBoolean1 + "isNeed=" + bool);
      }
      return bool;
      localEditor.putInt(paramString, i + 1);
      localEditor.commit();
      if (paramBoolean.booleanValue()) {
        paramExtensionInfo.isGrayTipMultiRemind |= paramInt2;
      } else {
        paramExtensionInfo.isGrayTipRemind |= paramInt2;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, xys paramxys)
  {
    if (paramxys.bkO) {}
    for (;;)
    {
      return;
      acff localacff = (acff)paramQQAppInterface.getManager(51);
      ExtensionInfo localExtensionInfo = localacff.a(paramSessionInfo.aTl, false);
      if (localExtensionInfo != null)
      {
        int i = ajol.a(1, paramSessionInfo.aTl, localExtensionInfo, localacff.aL(false));
        long l = localExtensionInfo.loverLastChatTime;
        boolean bool = ajol.b(ajol.Gx(), l * 1000L, localExtensionInfo.loverTransFlag);
        if ((i != 0) && (bool)) {}
        for (i = 1; i != 0; i = 0)
        {
          a(paramQQAppInterface, paramSessionInfo, paramQQAppInterface.b().f(paramSessionInfo.aTl, paramSessionInfo.cZ), paramxys);
          return;
        }
      }
    }
  }
  
  public static void du(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new OldMutualMarkLogicHelper.2(paramQQAppInterface), 5, null, true);
  }
  
  public static boolean kA(int paramInt)
  {
    if (paramInt == 13) {}
    while (paramInt == ajnu.f(4L, 3L)) {
      return true;
    }
    return false;
  }
  
  public static boolean kB(int paramInt)
  {
    return paramInt == 999;
  }
  
  public static boolean kC(int paramInt)
  {
    return paramInt == 998;
  }
  
  public static boolean kz(int paramInt)
  {
    if ((paramInt == 6) || (paramInt == 32) || (paramInt == 33)) {}
    while (paramInt == ajnu.f(12L, 2L)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajoo
 * JD-Core Version:    0.7.0.1
 */