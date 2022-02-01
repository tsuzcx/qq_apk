package tencent.im.s2c.msgtype0x210.submsgtype0x111;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x111
{
  public static final class AddFriendSource
    extends MessageMicro<AddFriendSource>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source", "uint32_sub_source" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddFriendSource.class);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source = PBField.initUInt32(0);
  }
  
  public static final class Color
    extends MessageMicro<Color>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  }
  
  public static final class Label
    extends MessageMicro<Label>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0x111.Color edging_color = new SubMsgType0x111.Color();
    public SubMsgType0x111.Color text_color = new SubMsgType0x111.Color();
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_name", "text_color", "edging_color", "uint32_label_type" }, new Object[] { localByteStringMicro, null, null, Integer.valueOf(0) }, Label.class);
    }
  }
  
  public static final class MayKnowPerson
    extends MessageMicro<MayKnowPerson>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_additive = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_alghrithm = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_catelogue = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_country = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mobile_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_province = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_richbuffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0x111.AddFriendSource msg_android_source = new SubMsgType0x111.AddFriendSource();
    public SubMsgType0x111.AddFriendSource msg_ios_source = new SubMsgType0x111.AddFriendSource();
    public final PBRepeatMessageField<SubMsgType0x111.Label> rpt_msg_labels = PBField.initRepeatMessage(SubMsgType0x111.Label.class);
    public final PBStringField str_token = PBField.initString("");
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzone = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98, 106, 114, 120, 128, 138, 146, 154 }, new String[] { "uint64_uin", "msg_ios_source", "msg_android_source", "bytes_reason", "bytes_additive", "bytes_nick", "bytes_remark", "bytes_country", "bytes_province", "bytes_city", "uint32_age", "bytes_catelogue", "bytes_alghrithm", "bytes_richbuffer", "uint32_qzone", "uint32_gender", "bytes_mobile_name", "str_token", "rpt_msg_labels" }, new Object[] { Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro11, "", null }, MayKnowPerson.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_type", "rpt_msg_add_recommend_persons", "rpt_uint64_del_uins" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L) }, MsgBody.class);
    public final PBRepeatMessageField<SubMsgType0x111.MayKnowPerson> rpt_msg_add_recommend_persons = PBField.initRepeatMessage(SubMsgType0x111.MayKnowPerson.class);
    public final PBRepeatField<Long> rpt_uint64_del_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111
 * JD-Core Version:    0.7.0.1
 */