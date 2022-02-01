import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.mutualmark.mutualmark.MutualMark;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.MutualMarkData;

public class ajnp
{
  private static int a(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
  {
    int k = 0;
    int i = -1;
    if (paramMutualMarkData.uint32_result.has()) {
      i = paramMutualMarkData.uint32_result.get();
    }
    int j = k;
    if (i == 0)
    {
      j = k;
      if (paramExtensionInfo != null)
      {
        paramacff = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramFriends = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramFriends.hasNext())
          {
            paramMutualMarkData = ajoj.a((mutualmark.MutualMark)paramFriends.next());
            if (paramMutualMarkData != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " info:" + paramMutualMarkData);
              }
              paramacff.add(paramMutualMarkData);
              if ((!TextUtils.isEmpty(paramMutualMarkData.aSO)) && (!TextUtils.isEmpty(paramMutualMarkData.aSP))) {
                ajnt.a(paramQQAppInterface).gK(paramMutualMarkData.aSO, paramMutualMarkData.aSP);
              }
            }
          }
        }
        a(paramacff, paramExtensionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " infos.size:" + paramacff.size());
        }
        j = 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    }
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
  {
    if (paramMutualMarkData == null) {}
    String str;
    int i;
    do
    {
      long l;
      do
      {
        return;
        l = paramMutualMarkData.uint64_frd_uin.get();
      } while (l <= 0L);
      str = String.valueOf(l);
      acff localacff = (acff)paramQQAppInterface.getManager(51);
      Object localObject2 = localacff.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localacff.e(str);
      i = a(paramQQAppInterface, localacff, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localacff.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localacff.e((Friends)localObject2);
        paramQQAppInterface.getBusinessHandler(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleGet0x5e0MutualMarkData uin:" + str + " changeType:" + i);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, wkz paramwkz, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  private static boolean a(ArrayList<ajoj> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      ajoj localajoj = (ajoj)localIterator.next();
      if (localajoj != null)
      {
        paramArrayList = null;
        if (paramExtensionInfo.mutualMarks != null) {
          paramArrayList = (ajoi)paramExtensionInfo.mutualMarks.get(Long.valueOf(localajoj.type));
        }
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new ajoi();
        }
        ((ajoi)localObject).a(localajoj);
        localArrayList.add(localObject);
      }
    }
    if (paramExtensionInfo.mutualMarks == null) {}
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      if (!paramExtensionInfo.mutualMarks.isEmpty()) {
        paramExtensionInfo.mutualMarks.clear();
      }
      paramArrayList = localArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (ajoi)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.mutualMarks.put(Long.valueOf(((ajoi)localObject).type), localObject);
        }
      }
      return true;
    }
    finally {}
  }
  
  private static boolean a(wkz.c paramc, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramc == null) || (paramExtensionInfo == null)) {}
    while (paramc.relation_type <= 0) {
      return false;
    }
    ajoi localajoi1 = null;
    if (paramExtensionInfo.mutualMarks != null) {
      localajoi1 = (ajoi)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramc.relation_type));
    }
    ajoi localajoi2 = localajoi1;
    if (localajoi1 == null) {
      localajoi2 = new ajoi();
    }
    boolean bool = localajoi2.a(paramc, paramLong);
    if (bool) {
      if (paramExtensionInfo.mutualMarks != null) {}
    }
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      paramExtensionInfo.mutualMarks.put(Long.valueOf(localajoi2.type), localajoi2);
      return bool;
    }
    finally {}
  }
  
  private static boolean a(wkz paramwkz, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramwkz != null)
    {
      if (paramExtensionInfo != null) {
        break label19;
      }
      bool2 = bool1;
    }
    label19:
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            return bool2;
            if (paramwkz.changeType != 2) {
              break;
            }
            bool2 = bool1;
          } while (paramwkz.a == null);
          l = paramwkz.getRelationType();
          bool2 = bool1;
        } while (paramExtensionInfo.mutualMarks == null);
        bool2 = bool1;
      } while (!paramExtensionInfo.mutualMarks.containsKey(Long.valueOf(l)));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(l));
      return true;
      bool1 = bool3;
      if (paramwkz.b != null) {
        bool1 = false | a(paramwkz.b, paramwkz.changeType, paramExtensionInfo);
      }
      bool2 = bool1;
    } while (paramwkz.qc == null);
    Iterator localIterator = paramwkz.qc.iterator();
    if (localIterator.hasNext())
    {
      wkz.a locala = (wkz.a)localIterator.next();
      if ((locala != null) && (locala.b != null)) {
        bool1 |= a(locala.b, paramwkz.changeType, paramExtensionInfo);
      }
      for (;;)
      {
        break;
      }
    }
    return bool1;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      Oidb_0xd6b.MutualMarkData localMutualMarkData = new Oidb_0xd6b.MutualMarkData();
      try
      {
        localMutualMarkData.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localMutualMarkData;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramArrayOfByte = null;
          localException.printStackTrace();
        }
        j = a(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
        i = j;
        if (!QLog.isColorLevel()) {
          break label116;
        }
        QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleGetFriendListMutualMarkData uin:" + paramString + " changeType:" + j);
        i = j;
      }
      if (paramArrayOfByte == null) {
        return false;
      }
    }
    for (;;)
    {
      int j;
      label116:
      if (i != 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      int i = 0;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, wkz paramwkz, ExtensionInfo paramExtensionInfo)
  {
    if (paramwkz.changeType == 2)
    {
      if (!ajnl.i(paramQQAppInterface, paramwkz.getRelationType())) {}
    }
    else {
      do
      {
        return true;
        if (paramwkz.changeType != 10003) {
          break;
        }
      } while (ajnl.i(paramQQAppInterface, paramwkz.getRelationType()));
    }
    while (!ajnl.a(paramQQAppInterface, paramwkz.getRelationType(), paramwkz.vO())) {
      return false;
    }
    return true;
  }
  
  private static void m(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (!a(paramQQAppInterface, paramwkz, paramExtensionInfo)) {
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable update");
      }
    }
    while (!a(paramwkz, paramExtensionInfo)) {
      return;
    }
    if (paramwkz.changeType == 1) {
      ajnn.a(paramQQAppInterface, paramwkz.friendUin, paramExtensionInfo, paramwkz.getRelationType());
    }
    paramacff.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramwkz.ph())) && (!TextUtils.isEmpty(paramwkz.pi()))) {
      ajnt.a(paramQQAppInterface).gK(paramwkz.ph(), paramwkz.pi());
    }
    if ((b(paramQQAppInterface, paramwkz, paramExtensionInfo)) && (!ajnu.be(paramQQAppInterface))) {
      ajnq.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
    }
    for (;;)
    {
      paramQQAppInterface.getBusinessHandler(1).notifyUI(3, true, paramwkz.friendUin);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
      }
    }
  }
  
  public static void n(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Add msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void o(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Del msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void p(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Modify msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void q(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void r(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void s(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void t(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void u(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Recover msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void v(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void w(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void x(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramacrj);
    }
    m(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
  }
  
  public static void y(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramacrj);
    }
    if (!ajnu.be(paramQQAppInterface)) {
      ajnq.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnp
 * JD-Core Version:    0.7.0.1
 */