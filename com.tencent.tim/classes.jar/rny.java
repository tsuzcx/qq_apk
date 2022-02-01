import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupVideoForward;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class rny
  extends jnm.b
{
  rny(rnx paramrnx) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new qqstory_group.RspGroupVideoForward();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_struct.ErrorInfo)paramBundle.result.get();
        if ((paramArrayOfByte.error_code.has()) && (paramArrayOfByte.error_code.get() == 0))
        {
          ThreadManager.executeOnSubThread(new TroopStoryForwardTask.2.1(this, paramBundle.story_id.get().toStringUtf8()));
          return paramArrayOfByte;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.troopstory.share", 2, "parse RspGroupVideoForward error", paramArrayOfByte);
        }
      }
    }
    this.this$0.mHandler.sendEmptyMessage(5);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rny
 * JD-Core Version:    0.7.0.1
 */