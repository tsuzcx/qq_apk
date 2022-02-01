package tencent.im.oidb.oidb_0x783;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x783
{
  public static final class DiscussGroup
    extends MessageMicro<DiscussGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 29 }, new String[] { "uint64_confid", "uint32_confseq", "uint32_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, DiscussGroup.class);
    public final PBUInt32Field uint32_confseq = PBField.initUInt32(0);
    public final PBFixed32Field uint32_time = PBField.initFixed32(0);
    public final PBUInt64Field uint64_confid = PBField.initUInt64(0L);
  }
  
  public static final class RemarkInfo
    extends MessageMicro<RemarkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_frd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_uin", "bytes_remark", "uint32_source", "uint32_is_frd" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RemarkInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_subcmd", "uint32_type", "msg_discussinfo", "rpt_uinlist", "uint32_groupid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0) }, ReqBody.class);
    public oidb_0x783.DiscussGroup msg_discussinfo = new oidb_0x783.DiscussGroup();
    public final PBRepeatMessageField<oidb_0x783.UinListInfo> rpt_uinlist = PBField.initRepeatMessage(oidb_0x783.UinListInfo.class);
    public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 29, 34 }, new String[] { "uint32_result", "str_errmsg", "uint32_server_time", "rpt_remark_infos" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x783.RemarkInfo> rpt_remark_infos = PBField.initRepeatMessage(oidb_0x783.RemarkInfo.class);
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBFixed32Field uint32_server_time = PBField.initFixed32(0);
  }
  
  public static final class UinListInfo
    extends MessageMicro<UinListInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint32_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, UinListInfo.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x783.oidb_0x783
 * JD-Core Version:    0.7.0.1
 */