package tencent.im.oidb.cmd0xcd4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xcd4
{
  public static final class InputNotifyReq
    extends MessageMicro<InputNotifyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_event_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ime = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_to_uin", "uint32_ime", "uint32_event_type", "bytes_pb_reserve" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, InputNotifyReq.class);
    }
  }
  
  public static final class InputNotifyRsp
    extends MessageMicro<InputNotifyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBSInt32Field sint32_result = PBField.initSInt32(0);
    public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "sint32_result", "bytes_err_msg", "uint32_interval" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, InputNotifyRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "input_notify" }, new Object[] { null }, ReqBody.class);
    public cmd0xcd4.InputNotifyReq input_notify = new cmd0xcd4.InputNotifyReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "input_notify" }, new Object[] { null }, RspBody.class);
    public cmd0xcd4.InputNotifyRsp input_notify = new cmd0xcd4.InputNotifyRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd4.cmd0xcd4
 * JD-Core Version:    0.7.0.1
 */