package tencent.im.s2c.msgtype0x210.submsgtype0x11f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x11f
{
  public static final class MediaUserInfo
    extends MessageMicro<MediaUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_to_uin", "uint32_join_state" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, MediaUserInfo.class);
    public final PBUInt32Field uint32_join_state = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gray_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_version_ctrl = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0x11f.PersonalSetting msg_per_setting = new SubMsgType0x11f.PersonalSetting();
    public final PBRepeatMessageField<SubMsgType0x11f.MediaUserInfo> rpt_msg_media_uin = PBField.initRepeatMessage(SubMsgType0x11f.MediaUserInfo.class);
    public final PBRepeatField<Long> rpt_uint64_to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_media_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_play_mode = PBField.initUInt32(0);
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_oper_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 64, 74, 82, 88, 792, 802 }, new String[] { "uint32_msg_type", "bytes_msg_info", "bytes_version_ctrl", "uint32_aio_type", "uint64_oper_uin", "rpt_uint64_to_uin", "bytes_gray_tips", "uint64_msg_seq", "rpt_msg_media_uin", "msg_per_setting", "uint32_play_mode", "uint32_media_type", "bytes_ext_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, MsgBody.class);
    }
  }
  
  public static final class PersonalSetting
    extends MessageMicro<PersonalSetting>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_theme_id", "uint32_player_id", "uint32_font_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PersonalSetting.class);
    public final PBUInt32Field uint32_font_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_player_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f
 * JD-Core Version:    0.7.0.1
 */