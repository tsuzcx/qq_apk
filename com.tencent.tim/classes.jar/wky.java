import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ExtSnsFrdData;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;

public class wky
{
  private static int a(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    int j = 0;
    boolean bool5 = false;
    boolean bool2 = false;
    boolean bool6 = false;
    boolean bool1 = false;
    boolean bool4 = bool5;
    boolean bool3 = bool6;
    if (paramFriends != null)
    {
      bool4 = bool5;
      bool3 = bool6;
      if (paramFriends.isFriend())
      {
        if (paramExtSnsFrdData.bytes_music_switch.has()) {
          bool2 = aing.o(paramExtSnsFrdData.bytes_music_switch.get().toByteArray());
        }
        if (paramExtSnsFrdData.bytes_ksing_switch.has()) {
          bool1 = aiha.n(paramExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
        }
        bool4 = bool2;
        bool3 = bool1;
        if (paramExtSnsFrdData.bytes_lbs_share.has())
        {
          bool4 = aiuq.a(paramQQAppInterface, paramExtSnsFrdData.bytes_lbs_share);
          bool3 = bool1;
        }
      }
    }
    for (bool1 = bool4;; bool1 = false)
    {
      if (paramExtensionInfo.isTogetherBusinessOpen(16777216) != bool3)
      {
        paramExtensionInfo.setTogetherBusiness(bool3, 16777216);
        j = 1;
      }
      int i = j;
      if (paramExtensionInfo.isListenTogetherOpen != bool2)
      {
        paramExtensionInfo.isListenTogetherOpen = bool2;
        i = j | 0x1;
      }
      if (paramExtensionInfo.isSharingLocation == 1)
      {
        bool4 = true;
        if (bool4 == bool1) {
          break label542;
        }
        if (!bool1) {
          break label480;
        }
        j = 1;
        label207:
        paramExtensionInfo.isSharingLocation = j;
        if (paramExtensionInfo.isSharingLocation != 1) {
          break label486;
        }
        bool4 = true;
        label224:
        aiup.a(paramQQAppInterface, 0, paramString, bool4);
        if (QLog.isColorLevel()) {
          QLog.d("ExtSnsFrdDataHandlerHelper", 2, new Object[] { "handleExtSnsFrdData: invoked. update ei & msg data ", " isSharingLbs: ", Boolean.valueOf(bool1) });
        }
        i |= 0x1;
      }
      label542:
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("handleExtSnsFrdData friendUin:").append(paramString).append(" newIsOpen:").append(bool2).append(" oldIsOpen").append(paramExtensionInfo.isListenTogetherOpen).append(" is_sing_together=").append(bool3).append(" isSharingLocation: ").append(paramExtensionInfo.isSharingLocation).append(" friend:");
          if (paramFriends != null)
          {
            paramExtensionInfo = Boolean.valueOf(paramFriends.isFriend());
            label359:
            QLog.d("ExtSnsFrdDataHandlerHelper", 1, paramExtensionInfo);
          }
        }
        else
        {
          j = i;
          if (paramFriends != null)
          {
            if (!paramExtSnsFrdData.bytes_mutualmark_alienation.has()) {
              break label498;
            }
            ajoc.a(paramQQAppInterface, paramacff, paramFriends, paramString, paramExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray(), false);
            i |= 0x2;
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleExtSnsFrdData friendUin:" + paramString + " relationIconFlag" + paramFriends.relationIconFlag);
              j = i;
            }
          }
        }
        label480:
        label486:
        label498:
        do
        {
          return j;
          bool4 = false;
          break;
          j = 0;
          break label207;
          bool4 = false;
          break label224;
          paramExtensionInfo = "null";
          break label359;
          j = i;
        } while (!QLog.isColorLevel());
        QLog.e("ExtSnsFrdDataHandlerHelper", 2, "handleExtSnsFrdData ExtSnsFrdData  friendUin:" + paramString + " doesn't has bytes_mutualmark_alienation");
        return i;
      }
      bool2 = bool4;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (paramwkz.b != null) {}
    switch (paramwkz.b.relation_type)
    {
    default: 
      if (ajnu.co(paramwkz.b.relation_type)) {
        ajnp.n(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
      }
      return;
    }
    ajoc.a(paramQQAppInterface, paramacff, paramFriends, paramwkz.friendUin, paramwkz.b.co, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    if (paramExtSnsFrdData == null) {}
    String str;
    int i;
    do
    {
      long l;
      do
      {
        return;
        l = paramExtSnsFrdData.frd_uin.get();
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
      i = a(paramQQAppInterface, localacff, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramExtSnsFrdData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localacff.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localacff.e((Friends)localObject2);
        paramQQAppInterface.getBusinessHandler(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleGet0x5e0ExtSnsFrdData uin:" + str + " changeType:" + i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, acrj paramacrj)
  {
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramacrj == null)) {}
    wkz localwkz;
    do
    {
      return;
      localwkz = wkz.a(paramRelationalChainChange, paramacrj.bdR);
    } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localwkz.selfUin)) || (TextUtils.isEmpty(localwkz.friendUin)));
    acff localacff = (acff)paramQQAppInterface.getManager(51);
    Friends localFriends = localacff.e(localwkz.friendUin);
    ExtensionInfo localExtensionInfo = localacff.a(localwkz.friendUin);
    paramRelationalChainChange = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramRelationalChainChange = new ExtensionInfo();
      paramRelationalChainChange.uin = localwkz.friendUin;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtSnsFrdDataHandlerHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramacrj + "changePushInfo:" + localwkz);
    }
    switch (localwkz.changeType)
    {
    default: 
      return;
    case 1: 
      a(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    case 2: 
      b(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    case 3: 
      c(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    case 10001: 
      d(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    case 10002: 
      e(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    case 10003: 
      f(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    case 10004: 
      g(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    case 10005: 
      h(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    case 11000: 
      i(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    case 11001: 
      j(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    case 11002: 
      k(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
      return;
    }
    l(paramQQAppInterface, localacff, localFriends, paramRelationalChainChange, localwkz, paramacrj);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      Oidb_0xd50.ExtSnsFrdData localExtSnsFrdData = new Oidb_0xd50.ExtSnsFrdData();
      try
      {
        localExtSnsFrdData.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localExtSnsFrdData;
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
        QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleGetExtSnsFrdData uin:" + paramString + " changeType:" + j);
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
  
  public static void b(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (paramwkz.a != null)
    {
      int i = paramwkz.a.relation_type;
      if (ajnu.co(paramwkz.a.relation_type)) {
        ajnp.o(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (paramwkz.b != null) {}
    switch (paramwkz.b.relation_type)
    {
    default: 
      if (ajnu.co(paramwkz.b.relation_type)) {
        ajnp.p(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
      }
      return;
    }
    ajoc.a(paramQQAppInterface, paramacff, paramFriends, paramwkz.friendUin, paramwkz.b.co, true);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (paramwkz.b != null)
    {
      int i = paramwkz.b.relation_type;
      if (ajnu.co(paramwkz.b.relation_type)) {
        ajnp.q(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
      }
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (paramwkz.b != null)
    {
      int i = paramwkz.b.relation_type;
      if (ajnu.co(paramwkz.b.relation_type)) {
        ajnp.r(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
      }
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (paramwkz.b != null)
    {
      int i = paramwkz.b.relation_type;
      if (ajnu.co(paramwkz.b.relation_type)) {
        ajnp.s(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
      }
    }
  }
  
  public static void g(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (paramwkz.b != null)
    {
      int i = paramwkz.b.relation_type;
      if (ajnu.co(paramwkz.b.relation_type)) {
        ajnp.t(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
      }
    }
  }
  
  public static void h(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (paramwkz.b != null)
    {
      int i = paramwkz.b.relation_type;
      if (ajnu.co(paramwkz.b.relation_type)) {
        ajnp.u(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
      }
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if ((paramwkz.b != null) || (paramwkz.qc != null)) {
      ajnp.v(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
    }
  }
  
  public static void j(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if ((paramwkz.b != null) || (paramwkz.qc != null)) {
      ajnp.w(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
    }
  }
  
  public static void k(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if ((paramwkz.b != null) || (paramwkz.qc != null)) {
      ajnp.x(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
    }
  }
  
  public static void l(QQAppInterface paramQQAppInterface, acff paramacff, Friends paramFriends, ExtensionInfo paramExtensionInfo, wkz paramwkz, acrj paramacrj)
  {
    if (paramwkz.b != null) {
      ajnp.y(paramQQAppInterface, paramacff, paramFriends, paramExtensionInfo, paramwkz, paramacrj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wky
 * JD-Core Version:    0.7.0.1
 */