package tencent.im.oidb.cmd0x8f1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.label.comm.PersonalityTagComm.LabelInfo;

public final class oidb_0x8f1
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_label_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_label_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_req_num", "bytes_label_cookie", "uint64_req_uin", "uint64_label_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_label_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public PersonalityTagComm.LabelInfo msg_label_info = new PersonalityTagComm.LabelInfo();
    public final PBUInt32Field uint32_complete_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_label_info", "uint32_complete_flag", "bytes_label_cookie" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f1.oidb_0x8f1
 * JD-Core Version:    0.7.0.1
 */