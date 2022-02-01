package tencent.im.s2c.msgtype0x210.submsgtype0x128;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.MatchUinData;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.TagInfo;

public final class submsgtype0x128
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xe03.MatchUinData msg_match_uin_data = new oidb_0xe03.MatchUinData();
    public oidb_0xe03.TagInfo msg_tag = new oidb_0xe03.TagInfo();
    public final PBStringField string_report_id = PBField.initString("");
    public final PBUInt32Field uint32_match_expired_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_match_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time_stamp = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48, 58, 66, 74 }, new String[] { "bytes_sig", "uint64_match_uin", "bytes_tips_wording", "bytes_nick", "uint64_time_stamp", "uint32_match_expired_time", "string_report_id", "msg_tag", "msg_match_uin_data" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), "", null, null }, MsgBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128
 * JD-Core Version:    0.7.0.1
 */