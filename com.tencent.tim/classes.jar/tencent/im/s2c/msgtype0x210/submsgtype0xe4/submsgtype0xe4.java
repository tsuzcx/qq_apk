package tencent.im.s2c.msgtype0x210.submsgtype0xe4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xe4
{
  public static final class GeoInfo
    extends MessageMicro<GeoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_latitude", "uint64_longitude" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GeoInfo.class);
    public final PBUInt64Field uint64_latitude = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_longitude = PBField.initUInt64(0L);
  }
  
  public static final class GiftMsg
    extends MessageMicro<GiftMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField gift_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField packageurl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_roomid = PBField.initString("");
    public final PBUInt32Field uint32_all_add_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cur_add_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_gift_num = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 400, 408 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_product_id", "uint32_gift_id", "uint64_gift_num", "str_roomid", "gift_wording", "packageurl", "uint32_cur_add_duration", "uint32_all_add_duration" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, GiftMsg.class);
    }
  }
  
  public static final class LikeMsg
    extends MessageMicro<LikeMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_from_uin", "uint64_to_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, LikeMsg.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_display_distance = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public submsgtype0xe4.GiftMsg msg_gift = new submsgtype0xe4.GiftMsg();
    public submsgtype0xe4.LikeMsg msg_like = new submsgtype0xe4.LikeMsg();
    public submsgtype0xe4.Player msg_match_player = new submsgtype0xe4.Player();
    public submsgtype0xe4.Room msg_room = new submsgtype0xe4.Room();
    public final PBStringField str_hint = PBField.initString("");
    public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_countdown = PBField.initUInt32(0);
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 48, 56, 66, 74, 82, 90 }, new String[] { "msg_match_player", "uint32_distance", "str_hint", "uint32_countdown", "bytes_key", "uint32_type", "uint32_call_type", "bytes_display_distance", "msg_like", "msg_gift", "msg_room" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, null, null, null }, MsgBody.class);
    }
  }
  
  public static final class Player
    extends MessageMicro<Player>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48 }, new String[] { "uint64_uin", "bytes_nickname", "bytes_logo_url", "uint32_gender", "uint32_level", "uint32_age" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Player.class);
    }
  }
  
  public static final class Room
    extends MessageMicro<Room>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_room_id" }, new Object[] { "" }, Room.class);
    public final PBStringField str_room_id = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4
 * JD-Core Version:    0.7.0.1
 */