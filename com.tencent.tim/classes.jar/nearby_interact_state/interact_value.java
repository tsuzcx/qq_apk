package nearby_interact_state;

import appoint.define.appoint_define.FeedComment;
import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class interact_value
{
  public static final class FreshThing
    extends MessageMicro<FreshThing>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content_2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_content_3 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField bytes_fresh_thing_comment_id = PBField.initString("");
    public final PBBytesField bytes_fresh_thing_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.FeedComment fresh_comment = new appoint_define.FeedComment();
    public appoint_define.RichText fresh_thing_info = new appoint_define.RichText();
    public final PBUInt32Field uint32_color_2_row = PBField.initUInt32(0);
    public final PBUInt32Field uint32_color_3_row = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64 }, new String[] { "bytes_fresh_thing_id", "bytes_fresh_thing_comment_id", "bytes_content_2", "fresh_comment", "bytes_content_3", "fresh_thing_info", "uint32_color_2_row", "uint32_color_3_row" }, new Object[] { localByteStringMicro1, "", localByteStringMicro2, null, localByteStringMicro3, null, Integer.valueOf(0), Integer.valueOf(0) }, FreshThing.class);
    }
  }
  
  public static final class InteractValue
    extends MessageMicro<InteractValue>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_one_interact" }, new Object[] { null }, InteractValue.class);
    public final PBRepeatMessageField<interact_value.OneInteract> rpt_one_interact = PBField.initRepeatMessage(interact_value.OneInteract.class);
  }
  
  public static final class OneInteract
    extends MessageMicro<OneInteract>
  {
    public static final int STATE_TYPE_AWARD_POST = 3;
    public static final int STATE_TYPE_FOLLOW = 9;
    public static final int STATE_TYPE_LIKE_COMMENT = 5;
    public static final int STATE_TYPE_LIKE_POST = 2;
    public static final int STATE_TYPE_NEARBY_LIKE_POST = 7;
    public static final int STATE_TYPE_NEARBY_REPLY_COMMENT = 8;
    public static final int STATE_TYPE_NEARBY_REPLY_POST = 6;
    public static final int STATE_TYPE_REPLY_COMMENT = 4;
    public static final int STATE_TYPE_REPLY_POST = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64, 72, 80 }, new String[] { "uint32_state_type", "uint64_uin", "uint64_tinyid", "uint64_time", "msg_tribe", "msg_fresh_thing", "uint32_color2", "uint32_color3", "uint64_seq", "uint32_is_del" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, OneInteract.class);
    public interact_value.FreshThing msg_fresh_thing = new interact_value.FreshThing();
    public interact_value.Tribe msg_tribe = new interact_value.Tribe();
    public final PBUInt32Field uint32_color2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_color3 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_del = PBField.initUInt32(0);
    public final PBUInt32Field uint32_state_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class Tribe
    extends MessageMicro<Tribe>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_content_2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_content_3 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_content_txt2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_content_txt3 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ref_cid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_color_2_row = PBField.initUInt32(0);
    public final PBUInt32Field uint32_color_3_row = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 72, 80 }, new String[] { "uint32_bid", "bytes_pid", "bytes_cid", "bytes_ref_cid", "bytes_content_txt2", "bytes_content_2", "bytes_content_txt3", "bytes_content_3", "uint32_color_2_row", "uint32_color_3_row" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0) }, Tribe.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nearby_interact_state.interact_value
 * JD-Core Version:    0.7.0.1
 */