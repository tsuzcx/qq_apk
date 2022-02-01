package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x111
{
  public static final class ContentItem
    extends MessageMicro<ContentItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_filed", "msg_general_buffer" }, new Object[] { Integer.valueOf(0), null }, ContentItem.class);
    public subcmd0x111.GeneralBuffer msg_general_buffer = new subcmd0x111.GeneralBuffer();
    public final PBUInt32Field uint32_filed = PBField.initUInt32(0);
  }
  
  public static final class GeneralBuffer
    extends MessageMicro<GeneralBuffer>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_value" }, new Object[] { localByteStringMicro }, GeneralBuffer.class);
    }
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "bytes_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GroupInfo.class);
    }
  }
  
  public static final class OneRenMaiFrd
    extends MessageMicro<OneRenMaiFrd>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_closeness = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "uint64_uin", "uint32_update_time", "bytes_remark", "bytes_nick", "uint32_closeness", "uint32_group" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, OneRenMaiFrd.class);
    }
  }
  
  public static final class RenMaiInfo
    extends MessageMicro<RenMaiInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "uint32_sync_type", "uint32_next_start_time", "rpt_msg_group_info", "rpt_msg_frd", "rpt_uint64_del_frd", "uint32_next_interval" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, Long.valueOf(0L), Integer.valueOf(0) }, RenMaiInfo.class);
    public final PBRepeatMessageField<subcmd0x111.OneRenMaiFrd> rpt_msg_frd = PBField.initRepeatMessage(subcmd0x111.OneRenMaiFrd.class);
    public final PBRepeatMessageField<subcmd0x111.GroupInfo> rpt_msg_group_info = PBField.initRepeatMessage(subcmd0x111.GroupInfo.class);
    public final PBRepeatField<Long> rpt_uint64_del_frd = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_next_interval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_start_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sync_type = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 2186 }, new String[] { "msg_subcmd_0x111_req_body" }, new Object[] { null }, ReqBody.class);
    public subcmd0x111.SubCmd0x111ReqBody msg_subcmd_0x111_req_body = new subcmd0x111.SubCmd0x111ReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 2186 }, new String[] { "msg_subcmd_0x111_rsp_body" }, new Object[] { null }, RspBody.class);
    public subcmd0x111.SubCmd0x111RspBody msg_subcmd_0x111_rsp_body = new subcmd0x111.SubCmd0x111RspBody();
  }
  
  public static final class SubCmd0x111ReqBody
    extends MessageMicro<SubCmd0x111ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_start_time", "rpt_uint32_fieldlist", "rpt_uint64_uinlist" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, SubCmd0x111ReqBody.class);
    public final PBRepeatField<Integer> rpt_uint32_fieldlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_uinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x111RspBody
    extends MessageMicro<SubCmd0x111RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_contentItem" }, new Object[] { null }, SubCmd0x111RspBody.class);
    public final PBRepeatMessageField<subcmd0x111.ContentItem> rpt_msg_contentItem = PBField.initRepeatMessage(subcmd0x111.ContentItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x111
 * JD-Core Version:    0.7.0.1
 */