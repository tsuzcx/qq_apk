package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xee
{
  public static final class AccountInfo
    extends MessageMicro<AccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_id", "bytes_name", "bytes_icon_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, AccountInfo.class);
    }
  }
  
  public static final class ContextInfo
    extends MessageMicro<ContextInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_brief = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_orange_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_brief = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_context_type = PBField.initEnum(0);
    public final PBRepeatMessageField<submsgtype0xee.PictureInfo> rpt_msg_pic_list = PBField.initRepeatMessage(submsgtype0xee.PictureInfo.class);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66 }, new String[] { "uint64_id", "bytes_title", "rpt_msg_pic_list", "bytes_jump_url", "bytes_orange_word", "bytes_brief", "enum_context_type", "bytes_video_brief" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5 }, ContextInfo.class);
    }
  }
  
  public static final class ControlInfo
    extends MessageMicro<ControlInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_comment_length", "uint32_show_line", "uint32_font_size" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ControlInfo.class);
    public final PBUInt32Field uint32_comment_length = PBField.initUInt32(0);
    public final PBUInt32Field uint32_font_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_line = PBField.initUInt32(0);
  }
  
  public static final class ExtraInfo
    extends MessageMicro<ExtraInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_ext", "bytes_cookie" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ExtraInfo.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<submsgtype0xee.NotifyInfo> rpt_msg_notify_list = PBField.initRepeatMessage(submsgtype0xee.NotifyInfo.class);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 90 }, new String[] { "bytes_id", "uint64_seq", "uint32_bid", "rpt_msg_notify_list" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null }, MsgBody.class);
    }
  }
  
  public static final class NotifyInfo
    extends MessageMicro<NotifyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 90, 98, 106, 114, 170 }, new String[] { "msg_style_sheet", "enum_apppush_type", "msg_ordinary_push_info", "msg_social_push_info", "msg_ugc_push_info", "msg_context_info", "msg_account_info", "msg_statistics_info", "msg_control_info", "msg_extra_info" }, new Object[] { null, Integer.valueOf(0), null, null, null, null, null, null, null, null }, NotifyInfo.class);
    public final PBEnumField enum_apppush_type = PBField.initEnum(0);
    public submsgtype0xee.AccountInfo msg_account_info = new submsgtype0xee.AccountInfo();
    public submsgtype0xee.ContextInfo msg_context_info = new submsgtype0xee.ContextInfo();
    public submsgtype0xee.ControlInfo msg_control_info = new submsgtype0xee.ControlInfo();
    public submsgtype0xee.ExtraInfo msg_extra_info = new submsgtype0xee.ExtraInfo();
    public submsgtype0xee.OrdinaryPushInfo msg_ordinary_push_info = new submsgtype0xee.OrdinaryPushInfo();
    public submsgtype0xee.SocialPushInfo msg_social_push_info = new submsgtype0xee.SocialPushInfo();
    public submsgtype0xee.StatisticsInfo msg_statistics_info = new submsgtype0xee.StatisticsInfo();
    public submsgtype0xee.StyleSheet msg_style_sheet = new submsgtype0xee.StyleSheet();
    public submsgtype0xee.UGCPushInfo msg_ugc_push_info = new submsgtype0xee.UGCPushInfo();
  }
  
  public static final class OrangeControlInfo
    extends MessageMicro<OrangeControlInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_font_size = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_color", "uint32_font_size" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, OrangeControlInfo.class);
    }
  }
  
  public static final class OrdinaryPushInfo
    extends MessageMicro<OrdinaryPushInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_label_control_info" }, new Object[] { null }, OrdinaryPushInfo.class);
    public submsgtype0xee.OrangeControlInfo msg_label_control_info = new submsgtype0xee.OrangeControlInfo();
  }
  
  public static final class PictureInfo
    extends MessageMicro<PictureInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_url" }, new Object[] { localByteStringMicro }, PictureInfo.class);
    }
  }
  
  public static final class SocialPushInfo
    extends MessageMicro<SocialPushInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_biu_comment = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_biu_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_feeds_id", "string_biu_reason", "string_biu_comment" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, SocialPushInfo.class);
    }
  }
  
  public static final class StatisticsInfo
    extends MessageMicro<StatisticsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_algorithm_id", "uint64_strategy_id", "uint64_folder_status" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, StatisticsInfo.class);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_folder_status = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_strategy_id = PBField.initUInt64(0L);
  }
  
  public static final class StyleSheet
    extends MessageMicro<StyleSheet>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 88, 96 }, new String[] { "enum_style_type", "uint32_ark_enable", "uint64_scene", "uint32_duration", "uint64_end_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, StyleSheet.class);
    public final PBEnumField enum_style_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_ark_enable = PBField.initUInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_scene = PBField.initUInt64(0L);
  }
  
  public static final class UGCPushInfo
    extends MessageMicro<UGCPushInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_ugc_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_feeds_id", "string_ugc_reason" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, UGCPushInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee
 * JD-Core Version:    0.7.0.1
 */