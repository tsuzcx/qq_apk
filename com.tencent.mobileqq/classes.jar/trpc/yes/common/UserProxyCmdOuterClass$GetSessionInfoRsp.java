package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class UserProxyCmdOuterClass$GetSessionInfoRsp
  extends MessageMicro<GetSessionInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_sig" }, new Object[] { localByteStringMicro }, GetSessionInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.GetSessionInfoRsp
 * JD-Core Version:    0.7.0.1
 */