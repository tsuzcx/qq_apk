import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_feeds_write.DelFeedRsp;
import com.tencent.qphone.base.util.QLog;

final class akix
  implements ajwu.a
{
  akix(akit.a parama, String paramString) {}
  
  public void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool = true;
    if (paramInt == 0) {
      paramBundle = new ilive_feeds_write.DelFeedRsp();
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.ret.get();
        if (paramInt == 0)
        {
          if (this.a != null) {
            this.a.y(bool, this.dL);
          }
          return;
        }
        QLog.i("NearbyMomentProtocol", 1, "deleteMomentFeed error, ret=" + paramInt + ",msg=" + paramBundle.err_msg.get().toStringUtf8());
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("NearbyMomentProtocol", 1, "deleteMomentFeed error, e=" + paramArrayOfByte.toString());
        continue;
      }
      bool = false;
      continue;
      QLog.i("NearbyMomentProtocol", 1, "deleteMomentFeed error, errorCode =" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akix
 * JD-Core Version:    0.7.0.1
 */