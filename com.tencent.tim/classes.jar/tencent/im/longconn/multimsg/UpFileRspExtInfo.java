package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class UpFileRspExtInfo
  extends MessageMicro<UpFileRspExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_res_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_msg_res_id" }, new Object[] { localByteStringMicro }, UpFileRspExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.longconn.multimsg.UpFileRspExtInfo
 * JD-Core Version:    0.7.0.1
 */