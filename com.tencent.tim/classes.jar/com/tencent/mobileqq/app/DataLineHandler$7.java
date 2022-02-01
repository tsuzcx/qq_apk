package com.tencent.mobileqq.app;

import acde;
import acqp;
import aqoj;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class DataLineHandler$7
  implements Runnable
{
  public DataLineHandler$7(acde paramacde, FromServiceMsg paramFromServiceMsg, int paramInt, long paramLong) {}
  
  public void run()
  {
    cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
    if (this.e == null) {}
    for (;;)
    {
      Object localObject = this.this$0.app.b().a(this.cuS).a(this.val$cookie);
      if (localObject != null) {
        break;
      }
      return;
      localObject = null;
      if (this.e.getWupBuffer() != null)
      {
        int i = this.e.getWupBuffer().length - 4;
        if (i >= 0)
        {
          localObject = new byte[i];
          aqoj.copyData((byte[])localObject, 0, this.e.getWupBuffer(), 4, i);
        }
      }
      else if (localObject != null)
      {
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
    if (localRspBody.msg_file_query_rsp.int32_ret_code.get() == 0)
    {
      localRspBody.msg_file_query_rsp.msg_file_info.str_file_name.get();
      localRspBody.msg_file_query_rsp.msg_file_info.uint64_file_size.get();
      localInvalidProtocolBufferMicroException.md5 = localRspBody.msg_file_query_rsp.msg_file_info.bytes_10m_md5.get().toByteArray();
      this.this$0.app.b().a(this.cuS).a(localInvalidProtocolBufferMicroException.msgId, localInvalidProtocolBufferMicroException.serverPath, localInvalidProtocolBufferMicroException.md5);
      this.this$0.e(localInvalidProtocolBufferMicroException);
      return;
    }
    acde.a(this.this$0, localInvalidProtocolBufferMicroException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.7
 * JD-Core Version:    0.7.0.1
 */