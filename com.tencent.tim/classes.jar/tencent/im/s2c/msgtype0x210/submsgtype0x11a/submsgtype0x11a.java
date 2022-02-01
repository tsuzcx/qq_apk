package tencent.im.s2c.msgtype0x210.submsgtype0x11a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class submsgtype0x11a
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_biz_type = PBField.initEnum(1);
    public final PBEnumField enum_result = PBField.initEnum(0);
    public submsgtype0x11a.UserData msg_user_data = new submsgtype0x11a.UserData();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "enum_result", "bytes_token", "bytes_encrypt_key", "msg_user_data", "enum_biz_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(1) }, MsgBody.class);
    }
  }
  
  public static final class UserData
    extends MessageMicro<UserData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_bssid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ssid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_platform = PBField.initEnum(1);
    public final PBRepeatField<Integer> rpt_fixed32_port = PBField.initRepeat(PBFixed32Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 26, 34, 40 }, new String[] { "bytes_ip", "rpt_fixed32_port", "bytes_ssid", "bytes_bssid", "enum_platform" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(1) }, UserData.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a
 * JD-Core Version:    0.7.0.1
 */