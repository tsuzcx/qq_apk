package tencent.im.s2c.msgtype0x210.submsgtype0x133;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x133
{
  public static final class FaceFriend
    extends MessageMicro<FaceFriend>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_friend = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_friend", "bytes_name", "uint32_type" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, FaceFriend.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_uin", "rpt_msg_friends", "str_session_id" }, new Object[] { Long.valueOf(0L), null, "" }, MsgBody.class);
    public final PBRepeatMessageField<submsgtype0x133.FaceFriend> rpt_msg_friends = PBField.initRepeatMessage(submsgtype0x133.FaceFriend.class);
    public final PBStringField str_session_id = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x133.submsgtype0x133
 * JD-Core Version:    0.7.0.1
 */