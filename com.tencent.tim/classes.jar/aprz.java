import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class aprz
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, jnm.d paramd, Bundle paramBundle)
  {
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    localFollowRequest.luin.set(paramLong);
    localFollowRequest.ext.set("0");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    jnm.a(paramQQAppInterface, paramd, localFollowRequest.toByteArray(), "PubAccountSvc.follow", localBundle);
    kbp.g(paramQQAppInterface, "" + paramLong, 0);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, long paramLong, jnm.d paramd)
  {
    if (paramLong <= 0L) {
      return;
    }
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("3.4.4,3,3058");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.luin.set(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    jnm.a(paramQQAppInterface, paramd, localGetPublicAccountDetailInfoRequest.toByteArray(), "PubAccountSvc.get_detail_info", localBundle);
  }
  
  public static abstract class a
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      boolean bool2 = false;
      mobileqq_mp.FollowResponse localFollowResponse;
      if (paramInt == 0) {
        localFollowResponse = new mobileqq_mp.FollowResponse();
      }
      for (;;)
      {
        try
        {
          localFollowResponse.mergeFrom(paramArrayOfByte);
          if (!((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.has()) {
            break label146;
          }
          paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
          if (paramInt != 0) {
            break label146;
          }
          bool1 = true;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("TroopBindPubAccountProtocol", 2, paramArrayOfByte.toString());
          bool1 = bool2;
          continue;
        }
        y(bool1, paramBundle);
        return;
        boolean bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("TroopBindPubAccountProtocol", 2, "follow pubAccount failed, errorCode=" + paramInt);
          bool1 = bool2;
          continue;
          label146:
          bool1 = false;
        }
      }
    }
    
    protected abstract void y(boolean paramBoolean, Bundle paramBundle);
  }
  
  public static abstract class b
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      boolean bool2 = false;
      Object localObject = null;
      long l2 = 0L;
      long l1;
      boolean bool1;
      if ((paramInt == 0) && (paramBundle != null))
      {
        l2 = paramBundle.getLong("uin");
        l1 = l2;
        if (paramArrayOfByte == null) {
          break label199;
        }
        paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        bool1 = bool2;
      }
      for (;;)
      {
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          bool1 = bool2;
          if (!((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.has()) {
            break label211;
          }
          bool1 = bool2;
          if (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() != 0) {
            break label211;
          }
          bool1 = true;
          paramArrayOfByte = new AccountDetail(paramBundle);
          bool1 = true;
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          bool2 = bool1;
          bool1 = bool2;
          paramArrayOfByte = localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("TroopBindPubAccountProtocol", 2, paramBundle.toString());
          bool1 = bool2;
          paramArrayOfByte = localObject;
          continue;
        }
        a(bool1, l2, paramArrayOfByte);
        return;
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.i("TroopBindPubAccountProtocol", 2, "get pubAccountInfo failed, errorCode=" + paramInt);
          l1 = l2;
        }
        label199:
        bool1 = false;
        paramArrayOfByte = null;
        l2 = l1;
        continue;
        label211:
        paramArrayOfByte = null;
        bool1 = false;
      }
    }
    
    protected abstract void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprz
 * JD-Core Version:    0.7.0.1
 */