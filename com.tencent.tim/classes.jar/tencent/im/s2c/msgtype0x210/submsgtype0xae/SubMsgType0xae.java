package tencent.im.s2c.msgtype0x210.submsgtype0xae;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xae
{
  public static final class AddFriendSource
    extends MessageMicro<AddFriendSource>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source", "uint32_sub_source" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddFriendSource.class);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source = PBField.initUInt32(0);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_type", "msg_people_may_konw", "msg_persons_may_know" }, new Object[] { Integer.valueOf(0), null, null }, MsgBody.class);
    public SubMsgType0xae.PushPeopleMayKnow msg_people_may_konw = new SubMsgType0xae.PushPeopleMayKnow();
    public SubMsgType0xae.PushPeopleMayKnowV2 msg_persons_may_know = new SubMsgType0xae.PushPeopleMayKnowV2();
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class PersonMayKnow
    extends MessageMicro<PersonMayKnow>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_alghrithm = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_main_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_role_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_soure_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0xae.AddFriendSource msg_android_source = new SubMsgType0xae.AddFriendSource();
    public SubMsgType0xae.AddFriendSource msg_ios_source = new SubMsgType0xae.AddFriendSource();
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_game_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 64, 74, 82, 90, 96, 106 }, new String[] { "uint64_uin", "bytes_name", "uint32_age", "uint32_sex", "bytes_main_reason", "bytes_soure_reason", "bytes_alghrithm", "uint32_source", "msg_ios_source", "msg_android_source", "bytes_msg", "uint32_game_source", "bytes_role_name" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), null, null, localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6 }, PersonMayKnow.class);
    }
  }
  
  public static final class PushPeopleMayKnow
    extends MessageMicro<PushPeopleMayKnow>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_wording_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 18 }, new String[] { "fixed32_timestamp", "bytes_wording_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, PushPeopleMayKnow.class);
    }
  }
  
  public static final class PushPeopleMayKnowV2
    extends MessageMicro<PushPeopleMayKnowV2>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_role_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
    public final PBRepeatMessageField<SubMsgType0xae.PersonMayKnow> rpt_msg_friend_list = PBField.initRepeatMessage(SubMsgType0xae.PersonMayKnow.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 18, 26 }, new String[] { "fixed32_timestamp", "rpt_msg_friend_list", "bytes_role_name" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro }, PushPeopleMayKnowV2.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae
 * JD-Core Version:    0.7.0.1
 */