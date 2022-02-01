package tencent.im.s2c.msgtype0x210.submsgtype0x10f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x10f
{
  public static final class KanDianCoinSettingWording
    extends MessageMicro<KanDianCoinSettingWording>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_picture_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_wording", "bytes_picture_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, KanDianCoinSettingWording.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_coin_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public submsgtype0x10f.KanDianCoinSettingWording msg_setting_wording = new submsgtype0x10f.KanDianCoinSettingWording();
    public final PBUInt32Field uint32_can_get_coin_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_open_coin_entry = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_completed_task_stamp = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "uint32_is_open_coin_entry", "uint32_can_get_coin_count", "bytes_coin_icon_url", "msg_setting_wording", "uint64_last_completed_task_stamp", "uint64_dst_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Long.valueOf(0L), Long.valueOf(0L) }, MsgBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x10f.submsgtype0x10f
 * JD-Core Version:    0.7.0.1
 */