package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8f6
{
  public static final class ConcernInfo
    extends MessageMicro<ConcernInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, ConcernInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class DecreaseUnreadMailCountReq
    extends MessageMicro<DecreaseUnreadMailCountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_type", "uint32_amount", "rpt_msg_indexes", "msg_recalled_index", "uint32_data_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0) }, DecreaseUnreadMailCountReq.class);
    public oidb_cmd0x8f6.LiteMailIndex msg_recalled_index = new oidb_cmd0x8f6.LiteMailIndex();
    public final PBRepeatMessageField<oidb_cmd0x8f6.LiteMailIndex> rpt_msg_indexes = PBField.initRepeatMessage(oidb_cmd0x8f6.LiteMailIndex.class);
    public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class DecreaseUnreadMailCountRsp
    extends MessageMicro<DecreaseUnreadMailCountRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_unread" }, new Object[] { null }, DecreaseUnreadMailCountRsp.class);
    public final PBRepeatMessageField<oidb_cmd0x8f6.UnreadMailCountInfo> rpt_msg_unread = PBField.initRepeatMessage(oidb_cmd0x8f6.UnreadMailCountInfo.class);
  }
  
  public static final class GetUnreadMailCountReq
    extends MessageMicro<GetUnreadMailCountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetUnreadMailCountReq.class);
  }
  
  public static final class GetUnreadMailCountRsp
    extends MessageMicro<GetUnreadMailCountRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_unread" }, new Object[] { null }, GetUnreadMailCountRsp.class);
    public oidb_cmd0x8f6.UnreadMailCountInfo msg_unread = new oidb_cmd0x8f6.UnreadMailCountInfo();
  }
  
  public static final class IncUnreadMailCountReq
    extends MessageMicro<IncUnreadMailCountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_unread" }, new Object[] { null }, IncUnreadMailCountReq.class);
    public final PBRepeatMessageField<oidb_cmd0x8f6.UnreadMailCountInfo> rpt_msg_unread = PBField.initRepeatMessage(oidb_cmd0x8f6.UnreadMailCountInfo.class);
  }
  
  public static final class IncUnreadMailCountRsp
    extends MessageMicro<IncUnreadMailCountRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_unread" }, new Object[] { null }, IncUnreadMailCountRsp.class);
    public final PBRepeatMessageField<oidb_cmd0x8f6.UnreadMailCountInfo> rpt_msg_unread = PBField.initRepeatMessage(oidb_cmd0x8f6.UnreadMailCountInfo.class);
  }
  
  public static final class LiteMailIndex
    extends MessageMicro<LiteMailIndex>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x8f6.SourceID msg_source = new oidb_cmd0x8f6.SourceID();
    public final PBRepeatMessageField<oidb_cmd0x8f6.ConcernInfo> rpt_msg_concern_uin_list = PBField.initRepeatMessage(oidb_cmd0x8f6.ConcernInfo.class);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_source", "bytes_feeds_id", "uint64_author_uin", "rpt_msg_concern_uin_list" }, new Object[] { null, localByteStringMicro, Long.valueOf(0L), null }, LiteMailIndex.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_subcmd", "msg_get_umc", "msg_dec_umc", "msg_inc_umc" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
    public oidb_cmd0x8f6.DecreaseUnreadMailCountReq msg_dec_umc = new oidb_cmd0x8f6.DecreaseUnreadMailCountReq();
    public oidb_cmd0x8f6.GetUnreadMailCountReq msg_get_umc = new oidb_cmd0x8f6.GetUnreadMailCountReq();
    public oidb_cmd0x8f6.IncUnreadMailCountReq msg_inc_umc = new oidb_cmd0x8f6.IncUnreadMailCountReq();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x8f6.DecreaseUnreadMailCountRsp msg_dec_umc = new oidb_cmd0x8f6.DecreaseUnreadMailCountRsp();
    public oidb_cmd0x8f6.GetUnreadMailCountRsp msg_get_umc = new oidb_cmd0x8f6.GetUnreadMailCountRsp();
    public oidb_cmd0x8f6.IncUnreadMailCountRsp msg_inc_umc = new oidb_cmd0x8f6.IncUnreadMailCountRsp();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_result", "bytes_error_msg", "msg_get_umc", "msg_dec_umc", "msg_inc_umc" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null }, RspBody.class);
    }
  }
  
  public static final class SourceID
    extends MessageMicro<SourceID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source_type", "uint64_source_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SourceID.class);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_source_code = PBField.initUInt64(0L);
  }
  
  public static final class UnreadMailCountInfo
    extends MessageMicro<UnreadMailCountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_unread_count", "uint32_data_version" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, UnreadMailCountInfo.class);
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6
 * JD-Core Version:    0.7.0.1
 */