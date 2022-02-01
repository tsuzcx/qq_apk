package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x76
{
  public static final class BirthdayNotify
    extends MessageMicro<BirthdayNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "rpt_msg_one_friend", "uint32_reserved", "rpt_gift_msg", "str_top_pic_url", "str_extend" }, new Object[] { null, Integer.valueOf(0), null, "", "" }, BirthdayNotify.class);
    public final PBRepeatMessageField<SubMsgType0x76.OneGiftMessage> rpt_gift_msg = PBField.initRepeatMessage(SubMsgType0x76.OneGiftMessage.class);
    public final PBRepeatMessageField<SubMsgType0x76.OneBirthdayFriend> rpt_msg_one_friend = PBField.initRepeatMessage(SubMsgType0x76.OneBirthdayFriend.class);
    public final PBStringField str_extend = PBField.initString("");
    public final PBStringField str_top_pic_url = PBField.initString("");
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
  }
  
  public static final class GeoGraphicNotify
    extends MessageMicro<GeoGraphicNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_local_city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<SubMsgType0x76.OneGeoGraphicFriend> rpt_msg_one_friend = PBField.initRepeatMessage(SubMsgType0x76.OneGeoGraphicFriend.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_local_city", "rpt_msg_one_friend" }, new Object[] { localByteStringMicro, null }, GeoGraphicNotify.class);
    }
  }
  
  public static final class MemorialDayNotify
    extends MessageMicro<MemorialDayNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_anniversary_info" }, new Object[] { null }, MemorialDayNotify.class);
    public final PBRepeatMessageField<SubMsgType0x76.OneMemorialDayInfo> rpt_anniversary_info = PBField.initRepeatMessage(SubMsgType0x76.OneMemorialDayInfo.class);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_strong_notify = PBField.initBool(false);
    public final PBBytesField bytes_notify_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0x76.BirthdayNotify msg_birthday_notify = new SubMsgType0x76.BirthdayNotify();
    public SubMsgType0x76.GeoGraphicNotify msg_geographic_notify = new SubMsgType0x76.GeoGraphicNotify();
    public SubMsgType0x76.MemorialDayNotify msg_memorialday_notify = new SubMsgType0x76.MemorialDayNotify();
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58 }, new String[] { "uint32_msg_type", "bool_strong_notify", "uint32_push_time", "msg_geographic_notify", "msg_birthday_notify", "bytes_notify_wording", "msg_memorialday_notify" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), null, null, localByteStringMicro, null }, MsgBody.class);
    }
  }
  
  public static final class OneBirthdayFriend
    extends MessageMicro<OneBirthdayFriend>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_uin", "bool_lunar_birth", "uint32_birth_month", "uint32_birth_date", "uint64_msg_send_time", "uint32_birth_year" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, OneBirthdayFriend.class);
    public final PBBoolField bool_lunar_birth = PBField.initBool(false);
    public final PBUInt32Field uint32_birth_date = PBField.initUInt32(0);
    public final PBUInt32Field uint32_birth_month = PBField.initUInt32(0);
    public final PBUInt32Field uint32_birth_year = PBField.initUInt32(0);
    public final PBUInt64Field uint64_msg_send_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class OneGeoGraphicFriend
    extends MessageMicro<OneGeoGraphicFriend>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, OneGeoGraphicFriend.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class OneGiftMessage
    extends MessageMicro<OneGiftMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 58 }, new String[] { "gift_id", "gift_name", "type", "gift_url", "price", "play_cnt", "background_color" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, OneGiftMessage.class);
    public final PBStringField background_color = PBField.initString("");
    public final PBUInt32Field gift_id = PBField.initUInt32(0);
    public final PBStringField gift_name = PBField.initString("");
    public final PBStringField gift_url = PBField.initString("");
    public final PBUInt32Field play_cnt = PBField.initUInt32(0);
    public final PBUInt32Field price = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class OneMemorialDayInfo
    extends MessageMicro<OneMemorialDayInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_greetings = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_main_wording_event = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_main_wording_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_friend_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_memorial_time = PBField.initUInt32(0);
    public final PBUInt64Field uint32_type = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 120 }, new String[] { "uint64_uin", "uint32_type", "uint32_memorial_time", "bytes_main_wording_nick", "bytes_main_wording_event", "bytes_sub_wording", "bytes_greetings", "uint32_friend_gender" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, OneMemorialDayInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76
 * JD-Core Version:    0.7.0.1
 */