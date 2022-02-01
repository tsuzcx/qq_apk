package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class BaseInterfaceOuterClass$CSQQAccessReply
  extends MessageMicro<CSQQAccessReply>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField rsp_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public BaseInterfaceOuterClass.CSQQAccessRspHeader rsp_header = new BaseInterfaceOuterClass.CSQQAccessRspHeader();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "rsp_header", "rsp_body" }, new Object[] { null, localByteStringMicro }, CSQQAccessReply.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.BaseInterfaceOuterClass.CSQQAccessReply
 * JD-Core Version:    0.7.0.1
 */