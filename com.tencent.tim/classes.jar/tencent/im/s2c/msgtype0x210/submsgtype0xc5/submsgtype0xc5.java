package tencent.im.s2c.msgtype0x210.submsgtype0xc5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc5
{
  public static final class BBInfo
    extends MessageMicro<BBInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_bb_uin", "uint32_src" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, BBInfo.class);
    public final PBUInt32Field uint32_src = PBField.initUInt32(0);
    public final PBUInt64Field uint64_bb_uin = PBField.initUInt64(0L);
  }
  
  public static final class BiuBody
    extends MessageMicro<BiuBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_biu_uin" }, new Object[] { Long.valueOf(0L) }, BiuBody.class);
    public final PBUInt64Field uint64_biu_uin = PBField.initUInt64(0L);
  }
  
  public static final class CommentInfo
    extends MessageMicro<CommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reply_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_reply_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 26, 32, 42, 50 }, new String[] { "uint64_comment_uin", "bytes_comment_id", "uint64_reply_uin", "bytes_reply_id", "bytes_comment_content" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3 }, CommentInfo.class);
    }
  }
  
  public static final class LikeInfo
    extends MessageMicro<LikeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reply_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_op = PBField.initUInt32(0);
    public final PBUInt64Field uint64_like_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 34 }, new String[] { "uint64_like_uin", "uint32_op", "bytes_reply_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, LikeInfo.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_diandian_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public submsgtype0xc5.NotifyBody msg_notify_infos = new submsgtype0xc5.NotifyBody();
    public final PBEnumField operator_type = PBField.initEnum(1);
    public final PBStringField str_msgid = PBField.initString("");
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 82, 90 }, new String[] { "uint32_bid", "uint32_source", "operator_type", "uint64_article_id", "uint32_push_time", "uint64_seq", "str_msgid", "msg_notify_infos", "bytes_diandian_cookie" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "", null, localByteStringMicro }, MsgBody.class);
    }
  }
  
  public static final class NotifyBody
    extends MessageMicro<NotifyBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90, 98, 106 }, new String[] { "msg_style_sheet", "msg_comment_article", "msg_like_article", "msg_bb_info", "red_point_info" }, new Object[] { null, null, null, null, null }, NotifyBody.class);
    public submsgtype0xc5.BBInfo msg_bb_info = new submsgtype0xc5.BBInfo();
    public submsgtype0xc5.CommentInfo msg_comment_article = new submsgtype0xc5.CommentInfo();
    public submsgtype0xc5.LikeInfo msg_like_article = new submsgtype0xc5.LikeInfo();
    public submsgtype0xc5.StyleSheet msg_style_sheet = new submsgtype0xc5.StyleSheet();
    public final PBRepeatMessageField<submsgtype0xc5.RedPointInfo> red_point_info = PBField.initRepeatMessage(submsgtype0xc5.RedPointInfo.class);
  }
  
  public static final class RedPointInfo
    extends MessageMicro<RedPointInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField red_point_item_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_effect_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_failure_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_item_id", "red_point_item_type", "bytes_url", "uint64_effect_time", "uint64_failure_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L) }, RedPointInfo.class);
    }
  }
  
  public static final class StyleSheet
    extends MessageMicro<StyleSheet>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_orange_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField folder_red_type = PBField.initEnum(0);
    public submsgtype0xc5.BiuBody msg_biu_body = new submsgtype0xc5.BiuBody();
    public submsgtype0xc5.TipsBody msg_tip_body = new submsgtype0xc5.TipsBody();
    public final PBEnumField msg_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_is_low = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_folder = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_lock_screen = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66, 72 }, new String[] { "uint32_show_folder", "folder_red_type", "bytes_orange_word", "bytes_summary", "msg_tip_body", "uint32_show_lock_screen", "msg_type", "msg_biu_body", "uint32_is_low" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, StyleSheet.class);
    }
  }
  
  public static final class TipsBody
    extends MessageMicro<TipsBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_business_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField tips_ui_type = PBField.initEnum(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "tips_ui_type", "uint64_uin", "bytes_icon_url", "bytes_content", "bytes_schema", "bytes_business_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, TipsBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5
 * JD-Core Version:    0.7.0.1
 */