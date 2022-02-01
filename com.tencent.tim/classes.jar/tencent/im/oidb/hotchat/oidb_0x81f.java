package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x81f
{
  public static final class AccuData
    extends MessageMicro<AccuData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_accu_type", "uint32_accu_value" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AccuData.class);
    public final PBUInt32Field uint32_accu_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_accu_value = PBField.initUInt32(0);
  }
  
  public static final class ExtParam
    extends MessageMicro<ExtParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ExtParam.class);
  }
  
  public static final class GetAuthDataReq
    extends MessageMicro<GetAuthDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_auth", "uint32_accu_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetAuthDataReq.class);
    public final PBUInt32Field uint32_accu_data = PBField.initUInt32(0);
    public final PBUInt32Field uint32_auth = PBField.initUInt32(0);
  }
  
  public static final class GetAuthDataRsp
    extends MessageMicro<GetAuthDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_auth", "rpt_msg_accu_data", "uint64_timestamp" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, GetAuthDataRsp.class);
    public final PBRepeatMessageField<oidb_0x81f.AccuData> rpt_msg_accu_data = PBField.initRepeatMessage(oidb_0x81f.AccuData.class);
    public final PBUInt32Field uint32_auth = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_uin", "msg_extern_param", "msg_auth_data", "gc" }, new Object[] { Long.valueOf(0L), null, null, Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field gc = PBField.initUInt64(0L);
    public oidb_0x81f.GetAuthDataReq msg_auth_data = new oidb_0x81f.GetAuthDataReq();
    public oidb_0x81f.ExtParam msg_extern_param = new oidb_0x81f.ExtParam();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_auth_data" }, new Object[] { null }, RspBody.class);
    public oidb_0x81f.GetAuthDataRsp msg_auth_data = new oidb_0x81f.GetAuthDataRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x81f
 * JD-Core Version:    0.7.0.1
 */