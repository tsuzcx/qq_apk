package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class BaseInterfaceOuterClass$CSQQAccessRequest
  extends MessageMicro<CSQQAccessRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public BaseInterfaceOuterClass.CSQQAccessBaseInfo base_info = new BaseInterfaceOuterClass.CSQQAccessBaseInfo();
  public final PBBytesField req_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public BaseInterfaceOuterClass.CSQQAccessReqHeader req_header = new BaseInterfaceOuterClass.CSQQAccessReqHeader();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 82 }, new String[] { "base_info", "req_header", "req_body" }, new Object[] { null, null, localByteStringMicro }, CSQQAccessRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.BaseInterfaceOuterClass.CSQQAccessRequest
 * JD-Core Version:    0.7.0.1
 */