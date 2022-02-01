package tencent.im.oidb.cmd0x6f6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x6f6
{
  public static final class GbarInfo
    extends MessageMicro<GbarInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_bid", "str_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GbarInfo.class);
    }
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_group_code" }, new Object[] { Long.valueOf(0L) }, GroupInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_group_info" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0x6f6.GroupInfo> rpt_msg_group_info = PBField.initRepeatMessage(oidb_cmd0x6f6.GroupInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<oidb_cmd0x6f6.RspInfo> rpt_msg_rsp_info = PBField.initRepeatMessage(oidb_cmd0x6f6.RspInfo.class);
    public final PBBytesField str_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_rsp_info", "str_errinfo" }, new Object[] { null, localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class RspInfo
    extends MessageMicro<RspInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_group_code", "uint32_result", "stgbarinfo" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspInfo.class);
    public oidb_cmd0x6f6.GbarInfo stgbarinfo = new oidb_cmd0x6f6.GbarInfo();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6
 * JD-Core Version:    0.7.0.1
 */