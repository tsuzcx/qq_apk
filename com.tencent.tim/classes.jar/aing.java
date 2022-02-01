import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.media_relation.media_relation.MediaRelationInfo;

public class aing
{
  public static String TAG = "ListenTogetherAIOStatusHelper";
  
  public static void j(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "setIsGroupListenTogetherOpen, app = " + paramQQAppInterface + " troopuin:" + paramString + " isOpen:" + paramBoolean);
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if (paramQQAppInterface != null)
      {
        paramString = paramQQAppInterface.b(paramString);
        if (paramString != null)
        {
          paramString.setIsListenTogether(paramBoolean);
          paramQQAppInterface.i(paramString);
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setIsGroupListenTogetherOpen troopinfo saved");
          }
        }
      }
    }
  }
  
  public static void k(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "setIsC2CListenTogetherOpen, app = " + paramQQAppInterface + " frienduin:" + paramString + " isOpen:" + paramBoolean);
    }
    Friends localFriends;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      acff localacff = (acff)paramQQAppInterface.getManager(51);
      if (localacff != null)
      {
        localFriends = localacff.e(paramString);
        if ((localFriends == null) || (!localFriends.isFriend())) {
          paramBoolean = false;
        }
        ExtensionInfo localExtensionInfo = localacff.a(paramString);
        localObject = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          localObject = new ExtensionInfo();
          ((ExtensionInfo)localObject).uin = paramString;
        }
        boolean bool = ((ExtensionInfo)localObject).isListenTogetherOpen;
        if (bool != paramBoolean)
        {
          ((ExtensionInfo)localObject).isListenTogetherOpen = paramBoolean;
          localacff.a((ExtensionInfo)localObject);
          ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).notifyUI(3, true, paramString);
        }
        if (QLog.isColorLevel())
        {
          paramString = TAG;
          localObject = new StringBuilder().append("setIsC2CListenTogetherOpen extensionInfo saved, old=").append(bool).append(" new:").append(paramBoolean).append(" friend:");
          if (localFriends == null) {
            break label234;
          }
        }
      }
    }
    label234:
    for (paramQQAppInterface = Boolean.valueOf(localFriends.isFriend());; paramQQAppInterface = "null")
    {
      QLog.i(paramString, 2, paramQQAppInterface);
      return;
    }
  }
  
  public static boolean o(byte[] paramArrayOfByte)
  {
    media_relation.MediaRelationInfo localMediaRelationInfo;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      localMediaRelationInfo = new media_relation.MediaRelationInfo();
    }
    try
    {
      localMediaRelationInfo.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localMediaRelationInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        long l;
        paramArrayOfByte = null;
        localException.printStackTrace();
      }
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.create_time.has()))
    {
      i = paramArrayOfByte.create_time.get();
      l = NetConnInfoCenter.getServerTime();
    }
    return i >= l - 604800L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aing
 * JD-Core Version:    0.7.0.1
 */