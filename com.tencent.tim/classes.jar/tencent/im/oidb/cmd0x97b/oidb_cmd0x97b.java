package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x97b
{
  public static final class ColumnInfo
    extends MessageMicro<ColumnInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_column_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_column_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subscribe_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106 }, new String[] { "uint32_video_count", "uint32_column_count", "uint32_subscribe_count", "bytes_video_jump_url", "bytes_column_jump_url", "bytes_subscribe_jump_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ColumnInfo.class);
    }
  }
  
  public static final class CountDetailInfo
    extends MessageMicro<CountDetailInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 80 }, new String[] { "enum_type", "uint32_count", "bytes_name", "bytes_url", "bytes_icon_url", "uint32_id" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, CountDetailInfo.class);
    }
  }
  
  public static final class FollowCountInfo
    extends MessageMicro<FollowCountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buluo_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0x97b.CountDetailInfo> rpt_fans_detail_info = PBField.initRepeatMessage(oidb_cmd0x97b.CountDetailInfo.class);
    public final PBUInt32Field uint32_buluo_fans_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_buluo_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_buluo_vip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_my_fans_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_my_follow_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 162 }, new String[] { "uint32_my_follow_count", "uint32_my_fans_count", "uint32_is_buluo_vip", "bytes_buluo_name", "uint32_buluo_id", "uint32_buluo_fans_count", "rpt_fans_detail_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, FollowCountInfo.class);
    }
  }
  
  public static final class LimitInfo
    extends MessageMicro<LimitInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_forbidden_flag" }, new Object[] { Integer.valueOf(0) }, LimitInfo.class);
    public final PBUInt32Field uint32_forbidden_flag = PBField.initUInt32(0);
  }
  
  public static final class MedalInfo
    extends MessageMicro<MedalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_medal_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_medal_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_jump = PBField.initUInt32(0);
    public final PBUInt32Field uint32_medal_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_medal_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64 }, new String[] { "uint64_medal_id", "bytes_medal_name", "bytes_medal_url", "uint32_medal_type", "uint32_is_jump", "bytes_jump_url", "uint32_pic_width", "uint32_pic_height" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, MedalInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint64_uin", "uint32_req_ctrl_bits", "uint32_like_total", "uint32_publish_feeds_total", "uint32_sign_in", "uint32_medal", "uint32_column_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_column_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_medal = PBField.initUInt32(0);
    public final PBUInt32Field uint32_publish_feeds_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_ctrl_bits = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sign_in = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_uin", "msg_follow_count_info", "msg_limit_info", "msg_simpleinfo" }, new Object[] { Long.valueOf(0L), null, null, null }, RspBody.class);
    public oidb_cmd0x97b.FollowCountInfo msg_follow_count_info = new oidb_cmd0x97b.FollowCountInfo();
    public oidb_cmd0x97b.LimitInfo msg_limit_info = new oidb_cmd0x97b.LimitInfo();
    public oidb_cmd0x97b.SimpleInfo msg_simpleinfo = new oidb_cmd0x97b.SimpleInfo();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SignIn
    extends MessageMicro<SignIn>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int64_status", "uint32_current_continuous_sign_days", "uint32_max_continuous_sign_days" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SignIn.class);
    public final PBInt64Field int64_status = PBField.initInt64(0L);
    public final PBUInt32Field uint32_current_continuous_sign_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_continuous_sign_days = PBField.initUInt32(0);
  }
  
  public static final class SimpleInfo
    extends MessageMicro<SimpleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_header_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field int64_like_total = PBField.initInt64(0L);
    public final PBInt64Field int64_publish_feeds_total = PBField.initInt64(0L);
    public oidb_cmd0x97b.ColumnInfo msg_column_info = new oidb_cmd0x97b.ColumnInfo();
    public oidb_cmd0x97b.SignIn msg_sign_in = new oidb_cmd0x97b.SignIn();
    public final PBRepeatMessageField<oidb_cmd0x97b.MedalInfo> rpt_msg_medal_info = PBField.initRepeatMessage(oidb_cmd0x97b.MedalInfo.class);
    public final PBUInt32Field uint32_is_vip = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 48, 56, 66, 90, 98 }, new String[] { "bytes_nick", "bytes_header_url", "uint32_is_vip", "bytes_desc", "int64_like_total", "int64_publish_feeds_total", "rpt_msg_medal_info", "msg_sign_in", "msg_column_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L), Long.valueOf(0L), null, null, null }, SimpleInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x97b.oidb_cmd0x97b
 * JD-Core Version:    0.7.0.1
 */