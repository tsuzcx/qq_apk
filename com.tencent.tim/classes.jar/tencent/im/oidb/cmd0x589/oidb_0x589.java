package tencent.im.oidb.cmd0x589;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x589
{
  public static final class GetUserOpenIdReq
    extends MessageMicro<GetUserOpenIdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_req_flag", "uint64_req_uin", "uint64_req_host_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, GetUserOpenIdReq.class);
    public final PBUInt32Field uint32_req_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_req_host_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetUserOpenIdRsp
    extends MessageMicro<GetUserOpenIdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_discuss_open_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_open_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_open_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x589.GetUserOpenIdReq msg_req_id = new oidb_0x589.GetUserOpenIdReq();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "msg_req_id", "uint32_result", "bytes_open_id", "bytes_group_open_id", "bytes_discuss_open_id", "bytes_token" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, GetUserOpenIdRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_app_id", "rpt_msg_user_id" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_0x589.GetUserOpenIdReq> rpt_msg_user_id = PBField.initRepeatMessage(oidb_0x589.GetUserOpenIdReq.class);
    public final PBUInt64Field uint64_app_id = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_app_id", "rpt_msg_open_id" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x589.GetUserOpenIdRsp> rpt_msg_open_id = PBField.initRepeatMessage(oidb_0x589.GetUserOpenIdRsp.class);
    public final PBUInt64Field uint64_app_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x589.oidb_0x589
 * JD-Core Version:    0.7.0.1
 */