package tencent.im.oidb.cmd0x921;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x921
{
  public static final class GetAtAllRemain
    extends MessageMicro<GetAtAllRemain>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint64_discuss_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GetAtAllRemain.class);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetAtAllRemainRsp
    extends MessageMicro<GetAtAllRemainRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_uin", "uint32_uin_remain", "uint64_discuss_uin", "uint32_discuss_uin_remain", "bool_priviledge" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false) }, GetAtAllRemainRsp.class);
    public final PBBoolField bool_priviledge = PBField.initBool(false);
    public final PBUInt32Field uint32_discuss_uin_remain = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uin_remain = PBField.initUInt32(0);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_subcmd", "msg_get_at_all_remain" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public cmd0x921.GetAtAllRemain msg_get_at_all_remain = new cmd0x921.GetAtAllRemain();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_subcmd", "msg_get_at_all_remain" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public cmd0x921.GetAtAllRemainRsp msg_get_at_all_remain = new cmd0x921.GetAtAllRemainRsp();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x921.cmd0x921
 * JD-Core Version:    0.7.0.1
 */