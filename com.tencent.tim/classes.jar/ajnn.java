import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.SingleLineTextView.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ajnn
{
  static Comparator<ajoh> O = new ajno();
  
  public static ajoh a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      Object localObject = (acff)paramQQAppInterface.getManager(51);
      if (localObject == null) {
        return null;
      }
      if (((acff)localObject).aL(false)) {
        return null;
      }
      if (!((acff)localObject).kc(paramString)) {
        return null;
      }
      localObject = ((acff)localObject).a(paramString, paramBoolean);
      if (localObject == null) {
        return null;
      }
      paramString = a(paramQQAppInterface, paramString, (ExtensionInfo)localObject, paramLong);
      paramQQAppInterface = paramString;
    } while (paramString != null);
    return null;
  }
  
  private static ajoh a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      return null;
    }
    paramExtensionInfo = a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong);
    if ((paramExtensionInfo != null) && (!paramExtensionInfo.bdS))
    {
      ajog localajog = aelb.b().a(paramExtensionInfo.type);
      if (localajog != null)
      {
        ajoh localajoh = new ajoh();
        localajoh.a(paramExtensionInfo);
        localajoh.cpu = localajog.cpu;
        localajoh.name = localajog.bx(localajoh.ada);
        localajoh.cpt = localajog.cpt;
        localajoh.djX = localajog.djX;
        localajoh.djW = localajog.djW;
        localajoh.iconResId = ajnl.a(paramQQAppInterface, paramString, localajoh.type, localajoh.ada);
        if (!localajoh.ark())
        {
          if (QLog.isColorLevel()) {
            QLog.i("MutualMarkDataCenter", 2, "getMutualMarkDisPlayInfo IconResource InValid displayInfo:" + localajoh);
          }
          return null;
        }
        if ((localajog.cq(localajoh.ada)) && (ajnl.b(paramQQAppInterface, localajoh.type, localajoh.ada))) {
          return localajoh;
        }
        if ((localajog.isEnable()) && (ajnl.j(paramQQAppInterface, localajoh.type)))
        {
          paramLong = localajog.O(localajoh.ada);
          if (paramLong != -1L)
          {
            localajoh.ada = paramLong;
            return localajoh;
          }
        }
      }
    }
    return null;
  }
  
  public static ajoh a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      localObject = null;
    }
    do
    {
      ExtensionInfo localExtensionInfo;
      ajoh localajoh;
      do
      {
        do
        {
          return localObject;
          localObject = (acff)paramQQAppInterface.getManager(51);
          if (localObject == null) {
            return null;
          }
          if (((acff)localObject).aL(false)) {
            return null;
          }
          if (!((acff)localObject).kc(paramString)) {
            return null;
          }
          localExtensionInfo = ((acff)localObject).a(paramString, paramBoolean);
          if (localExtensionInfo == null) {
            return null;
          }
          localajoh = a(paramQQAppInterface, paramString, localExtensionInfo, 1L);
          localObject = localajoh;
        } while (localajoh != null);
        localajoh = a(paramQQAppInterface, paramString, localExtensionInfo, 2L);
        localObject = localajoh;
      } while (localajoh != null);
      paramQQAppInterface = a(paramQQAppInterface, paramString, localExtensionInfo, 3L);
      localObject = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    return null;
  }
  
  private static ajoi a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramExtensionInfo != null) {
          break label33;
        }
        localObject1 = localObject2;
      }
    }
    label33:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            return localObject1;
                                            if (!ajnu.cp(paramLong)) {
                                              break;
                                            }
                                            localObject1 = localObject2;
                                          } while (paramExtensionInfo.mutualMarks == null);
                                          localObject1 = localObject2;
                                        } while (paramExtensionInfo.mutualMarks.isEmpty());
                                        return (ajoi)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramLong));
                                        localObject1 = localObject2;
                                      } while (!ajnu.co(paramLong));
                                      if ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) {
                                        break;
                                      }
                                      localObject1 = localObject2;
                                    } while (paramExtensionInfo.intimate_type != paramLong);
                                    localObject1 = localObject2;
                                  } while (paramExtensionInfo.intimate_level < 0);
                                  localObject1 = localObject2;
                                } while (paramExtensionInfo.intimate_level > 2);
                                paramQQAppInterface = new ajoi();
                                paramQQAppInterface.type = paramExtensionInfo.intimate_type;
                                paramQQAppInterface.ada = paramExtensionInfo.intimate_level;
                                if (paramExtensionInfo.isExtinguish) {
                                  paramQQAppInterface.HU = 1L;
                                }
                                paramQQAppInterface.HR = paramExtensionInfo.last_intimate_chatTime;
                                paramQQAppInterface.adb = paramExtensionInfo.intimate_chatDays;
                                return paramQQAppInterface;
                                if (paramLong != 4L) {
                                  break;
                                }
                                localObject1 = localObject2;
                              } while (paramExtensionInfo.friendshipLevel < 1);
                              localObject1 = localObject2;
                            } while (paramExtensionInfo.friendshipLevel > 3);
                            paramQQAppInterface = new ajoi();
                            paramQQAppInterface.type = 4L;
                            paramQQAppInterface.ada = paramExtensionInfo.friendshipLevel;
                            paramQQAppInterface.HR = paramExtensionInfo.lastFriendshipTime;
                            paramQQAppInterface.adb = paramExtensionInfo.friendshipChatDays;
                            paramQQAppInterface.cpw = paramExtensionInfo.hasRemindFrdship;
                            paramQQAppInterface.adc = paramExtensionInfo.frdshipAnimStartTime;
                            return paramQQAppInterface;
                            if (paramLong != 5L) {
                              break;
                            }
                            localObject1 = localObject2;
                          } while (paramExtensionInfo.chatHotLevel < 1);
                          localObject1 = localObject2;
                        } while (paramExtensionInfo.chatHotLevel > 2);
                        paramQQAppInterface = new ajoi();
                        paramQQAppInterface.type = 5L;
                        paramQQAppInterface.ada = paramExtensionInfo.chatHotLevel;
                        paramQQAppInterface.HR = paramExtensionInfo.lastChatTime;
                        paramQQAppInterface.adb = paramExtensionInfo.chatDays;
                        paramQQAppInterface.cpw = paramExtensionInfo.hasRemindChat;
                        paramQQAppInterface.adc = paramExtensionInfo.chatAnimStartTime;
                        return paramQQAppInterface;
                        if (paramLong != 6L) {
                          break;
                        }
                        localObject1 = localObject2;
                      } while (paramExtensionInfo.praiseHotLevel < 1);
                      localObject1 = localObject2;
                    } while (paramExtensionInfo.praiseHotLevel > 2);
                    paramQQAppInterface = new ajoi();
                    paramQQAppInterface.type = 6L;
                    paramQQAppInterface.ada = paramExtensionInfo.praiseHotLevel;
                    paramQQAppInterface.HR = paramExtensionInfo.lastpraiseTime;
                    paramQQAppInterface.cpw = paramExtensionInfo.hasRemindPraise;
                    paramQQAppInterface.adc = paramExtensionInfo.praiseAnimStartTime;
                    return paramQQAppInterface;
                    if (paramLong != 7L) {
                      break;
                    }
                    localObject1 = localObject2;
                  } while (paramExtensionInfo.loverChatLevel < 1);
                  localObject1 = localObject2;
                } while (paramExtensionInfo.loverChatLevel > 2);
                paramQQAppInterface = new ajoi();
                paramQQAppInterface.type = 7L;
                paramQQAppInterface.ada = paramExtensionInfo.loverChatLevel;
                paramQQAppInterface.HR = paramExtensionInfo.loverLastChatTime;
                paramQQAppInterface.adb = paramExtensionInfo.loverChatDays;
                localObject1 = paramQQAppInterface;
              } while (!paramExtensionInfo.loverTransFlag);
              paramQQAppInterface.HU = 2L;
              paramQQAppInterface.HV = (NetConnInfoCenter.getServerTimeMillis() / 1000L + 86400L);
              return paramQQAppInterface;
              localObject1 = localObject2;
            } while (paramLong != 12L);
            if (!ajol.arn()) {
              break;
            }
            localObject1 = localObject2;
          } while (paramExtensionInfo.newBestIntimacyType < 1);
          localObject1 = localObject2;
        } while (paramExtensionInfo.newBestIntimacyType > 2);
        paramQQAppInterface = new ajoi();
        paramQQAppInterface.type = 12L;
        paramQQAppInterface.ada = paramExtensionInfo.newBestIntimacyType;
        return paramQQAppInterface;
        localObject1 = localObject2;
      } while (paramExtensionInfo.bestIntimacyType < 1);
      localObject1 = localObject2;
    } while (paramExtensionInfo.bestIntimacyType > 2);
    paramQQAppInterface = new ajoi();
    paramQQAppInterface.type = 12L;
    paramQQAppInterface.ada = paramExtensionInfo.bestIntimacyType;
    return paramQQAppInterface;
  }
  
  public static Pair<ajoh, ajoh> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = a(paramQQAppInterface, paramString, false, 1);
    Object localObject4;
    if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
    {
      localObject4 = ((ArrayList)localObject2).iterator();
      localObject2 = null;
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = (ajoh)((Iterator)localObject4).next();
        if (!((ajoh)localObject3).cpt)
        {
          if ((localObject2 == null) || (((ajoh)localObject3).djX < ((ajoh)localObject2).djX)) {
            localObject2 = localObject3;
          }
        }
        else {
          for (;;)
          {
            break;
            if ((localObject1 != null) && (((ajoh)localObject3).djX >= localObject1.djX)) {
              break label182;
            }
            localObject1 = localObject3;
          }
        }
      }
      else
      {
        if ((localObject2 != null) && (TextUtils.isEmpty(((ajoh)localObject2).bRP))) {
          ajoe.a().b(paramQQAppInterface, paramString, (ajoh)localObject2);
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (TextUtils.isEmpty(localObject1.bRP))
          {
            ajoe.a().b(paramQQAppInterface, paramString, localObject1);
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      return new Pair(localObject4, localObject3);
      label182:
      break;
      localObject4 = null;
    }
  }
  
  public static ArrayList<SingleLineTextView.f> a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<ajoh> paramArrayList)
  {
    paramString = null;
    paramQQAppInterface = paramString;
    if (paramArrayList != null)
    {
      paramQQAppInterface = paramString;
      if (!paramArrayList.isEmpty())
      {
        paramQQAppInterface = new ArrayList();
        paramString = paramArrayList.iterator();
        while (paramString.hasNext())
        {
          paramArrayList = (ajoh)paramString.next();
          SingleLineTextView.f localf = new SingleLineTextView.f();
          localf.iconResId = paramArrayList.iconResId;
          localf.icon_static_url = paramArrayList.icon_static_url;
          localf.Dd = paramArrayList.bg();
          paramQQAppInterface.add(localf);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static ArrayList<ajoh> a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    if ((acff)paramQQAppInterface.getManager(51) != null) {}
    return null;
  }
  
  public static void a(ajoh paramajoh, ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (paramajoh == null)) {}
    do
    {
      do
      {
        return;
        if (!ajnu.cp(paramajoh.type)) {
          break;
        }
      } while (paramExtensionInfo.mutualMarks == null);
      paramExtensionInfo = (ajoi)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramajoh.type));
    } while (paramExtensionInfo == null);
    paramExtensionInfo.cpw = paramajoh.cpw;
    paramExtensionInfo.adc = paramajoh.adc;
    return;
    switch ((int)paramajoh.type)
    {
    default: 
      return;
    case 4: 
      paramExtensionInfo.hasRemindFrdship = paramajoh.cpw;
      paramExtensionInfo.frdshipAnimStartTime = paramajoh.adc;
      return;
    case 5: 
      paramExtensionInfo.hasRemindChat = paramajoh.cpw;
      paramExtensionInfo.chatAnimStartTime = paramajoh.adc;
      return;
    }
    paramExtensionInfo.hasRemindPraise = paramajoh.cpw;
    paramExtensionInfo.praiseAnimStartTime = paramajoh.adc;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      break label15;
    }
    for (;;)
    {
      label15:
      return;
      if (a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong) != null)
      {
        Object localObject = aelb.b().l(paramLong);
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          b(paramQQAppInterface, paramString, paramExtensionInfo, ((ajog)((Iterator)localObject).next()).type);
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        if (!ajnu.cp(paramLong)) {
                          break;
                        }
                      } while ((paramExtensionInfo.mutualMarks == null) || (paramExtensionInfo.mutualMarks.isEmpty()));
                      paramExtensionInfo.mutualMarks.remove(Long.valueOf(paramLong));
                      return;
                    } while (!ajnu.co(paramLong));
                    if ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) {
                      break;
                    }
                  } while (paramExtensionInfo.intimate_type != paramLong);
                  paramExtensionInfo.intimate_type = 0;
                  paramExtensionInfo.intimate_level = 0;
                  paramExtensionInfo.intimate_chatDays = 0;
                  paramExtensionInfo.last_intimate_chatTime = 0L;
                  paramExtensionInfo.isExtinguish = false;
                  return;
                  if (paramLong != 4L) {
                    break;
                  }
                } while ((paramExtensionInfo.friendshipLevel < 1) || (paramExtensionInfo.friendshipLevel > 3));
                paramExtensionInfo.friendshipLevel = 0;
                paramExtensionInfo.friendshipChatDays = 0;
                paramExtensionInfo.lastFriendshipTime = 0L;
                return;
                if (paramLong != 5L) {
                  break;
                }
              } while ((paramExtensionInfo.chatHotLevel < 1) || (paramExtensionInfo.chatHotLevel > 2));
              paramExtensionInfo.chatHotLevel = 0;
              return;
              if (paramLong != 6L) {
                break;
              }
            } while ((paramExtensionInfo.praiseHotLevel < 1) || (paramExtensionInfo.praiseHotLevel > 2));
            paramExtensionInfo.praiseHotLevel = 0;
            return;
            if (paramLong != 7L) {
              break;
            }
          } while ((paramExtensionInfo.loverChatLevel < 1) || (paramExtensionInfo.loverChatLevel > 2));
          paramExtensionInfo.loverChatLevel = 0;
          paramExtensionInfo.loverTransFlag = false;
          return;
        } while (paramLong != 12L);
        if (!ajol.arn()) {
          break;
        }
      } while ((paramExtensionInfo.newBestIntimacyType < 1) || (paramExtensionInfo.newBestIntimacyType > 2));
      paramExtensionInfo.newBestIntimacyType = 0;
      return;
    } while ((paramExtensionInfo.bestIntimacyType < 1) || (paramExtensionInfo.bestIntimacyType > 2));
    paramExtensionInfo.bestIntimacyType = 0;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramBoolean, 0);
    paramBoolean = bool;
    if (paramQQAppInterface != null)
    {
      paramBoolean = bool;
      if (!paramQQAppInterface.isEmpty()) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnn
 * JD-Core Version:    0.7.0.1
 */