import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class wrq
  extends wrm
{
  public void a(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    paramBundle.putByteArray("key_data", paramArrayOfByte);
    notifyObserver(paramIntent, this.a, true, paramBundle, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    if (arrayOfByte != null) {}
    for (Object localObject2 = new COMM.StCommonExt();; localObject2 = null) {
      for (;;)
      {
        try
        {
          ((COMM.StCommonExt)localObject2).mergeFrom(arrayOfByte);
          i = paramIntent.getIntExtra("key_index", -1);
          arrayOfByte = paramIntent.getByteArrayExtra("key_request_feed_bytes");
          if (arrayOfByte == null) {}
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          try
          {
            localObject1 = new CertifiedAccountMeta.StFeed();
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            int i;
            localObject1 = localObject3;
          }
          try
          {
            ((CertifiedAccountMeta.StFeed)localObject1).mergeFrom(arrayOfByte);
            localObject2 = new wrp((COMM.StCommonExt)localObject2, (CertifiedAccountMeta.StFeed)localObject1).a(paramIntent, i, a());
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new byte[4];
            }
            paramPacket.setSSOCommand("CertifiedAccountSvc.certified_account_write.PublishFeed");
            paramPacket.putSendData(bblm.a((byte[])localObject1));
            paramPacket.setTimeout(paramIntent.getLongExtra("key_timeout", 30000L));
            super.onSend(paramIntent, paramPacket);
            return;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
          {
            break label166;
          }
          localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
          QLog.e("CertifiedAccountPublishFeedServlet", 2, QLog.getStackTraceString(localInvalidProtocolBufferMicroException1));
          continue;
        }
        label166:
        QLog.e("CertifiedAccountPublishFeedServlet", 2, QLog.getStackTraceString(localInvalidProtocolBufferMicroException2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wrq
 * JD-Core Version:    0.7.0.1
 */