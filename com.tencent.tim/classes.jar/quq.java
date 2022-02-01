import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.RspDelOneMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class quq
  extends jnm.b
{
  public quq(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int j = -1;
    paramBundle = new qqstory_struct.ErrorInfo();
    qqstory_710_del_message.RspDelOneMessage localRspDelOneMessage;
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      localRspDelOneMessage = new qqstory_710_del_message.RspDelOneMessage();
    }
    for (;;)
    {
      int m;
      int k;
      try
      {
        localRspDelOneMessage.mergeFrom(paramArrayOfByte);
        if (!localRspDelOneMessage.errinfo.error_code.has()) {
          break label239;
        }
        i = localRspDelOneMessage.errinfo.error_code.get();
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
        paramBundle.error_code.set(localRspDelOneMessage.errinfo.error_code.get());
        paramBundle.error_desc.set(localRspDelOneMessage.errinfo.error_desc.get());
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.msgList", 2, "receive delete one msg, code=" + paramInt + " bizCode=" + j);
        }
        if (i == 0) {
          QQToast.a(this.this$0.getApplicationContext(), 1, acfp.m(2131714948), 0).show();
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
        QLog.i("Q.qqstory.msgList", 2, "error parse RspDelOneMessage", paramArrayOfByte);
        j = k;
        i = m;
        continue;
        label239:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     quq
 * JD-Core Version:    0.7.0.1
 */