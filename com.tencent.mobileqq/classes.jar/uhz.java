import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.RspDelAllMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class uhz
  extends mml
{
  public uhz(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int j = -1;
    paramBundle = new qqstory_struct.ErrorInfo();
    qqstory_710_del_message.RspDelAllMessage localRspDelAllMessage;
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      localRspDelAllMessage = new qqstory_710_del_message.RspDelAllMessage();
    }
    for (;;)
    {
      int m;
      int k;
      try
      {
        localRspDelAllMessage.mergeFrom(paramArrayOfByte);
        if (!localRspDelAllMessage.errinfo.error_code.has()) {
          break label239;
        }
        i = localRspDelAllMessage.errinfo.error_code.get();
        j = i;
        if (j == 0) {
          i = 1;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        m = 0;
        k = j;
      }
      try
      {
        paramBundle.error_code.set(localRspDelAllMessage.errinfo.error_code.get());
        paramBundle.error_desc.set(localRspDelAllMessage.errinfo.error_desc.get());
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.msgList", 2, "receive delete all msg, code=" + paramInt + " bizCode=" + j);
        }
        if (i == 0) {
          bbmy.a(this.a.getApplicationContext(), 1, ajjy.a(2131648721), 0).a();
        }
        return paramBundle;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          k = j;
          m = i;
        }
      }
      int i = 0;
      continue;
      j = k;
      i = m;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qqstory.msgList", 2, "error parse RspDelAllMessage", paramArrayOfByte);
        j = k;
        i = m;
        continue;
        label239:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhz
 * JD-Core Version:    0.7.0.1
 */