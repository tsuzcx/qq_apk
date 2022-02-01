package tencent.im.oidb.cmd0x86f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import nearby_interact_state.interact_value.FreshThing;
import nearby_interact_state.interact_value.Tribe;

public final class oidb_0x86f
{
  public static final class CommonDetails
    extends MessageMicro<CommonDetails>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content_txt2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_content_txt3 = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_content_txt2", "bytes_content_txt3" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, CommonDetails.class);
    }
  }
  
  public static final class Details
    extends MessageMicro<Details>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_back_color2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_back_color3 = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x86f.CommonDetails msg_common_details = new oidb_0x86f.CommonDetails();
    public interact_value.FreshThing msg_fresh_thing = new interact_value.FreshThing();
    public interact_value.Tribe msg_tribe = new interact_value.Tribe();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_common_details", "msg_tribe", "msg_fresh_thing", "bytes_back_color2", "bytes_back_color3" }, new Object[] { null, null, null, localByteStringMicro1, localByteStringMicro2 }, Details.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_seq", "uint32_total" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_total = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_seq", "rpt_msg_interact_list", "uint32_isend" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x86f.UserInteractState> rpt_msg_interact_list = PBField.initRepeatMessage(oidb_0x86f.UserInteractState.class);
    public final PBUInt32Field uint32_isend = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_label_type = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58 }, new String[] { "uint64_tinyid", "uint64_uin", "bytes_nick_name", "bytes_head_url", "uint32_age", "uint32_gender", "bytes_label_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, UserInfo.class);
    }
  }
  
  public static final class UserInteractState
    extends MessageMicro<UserInteractState>
  {
    public static final int STATE_TYPE_AWARD_POST = 3;
    public static final int STATE_TYPE_FACE_SCORE_DOT_LIKE = 1001;
    public static final int STATE_TYPE_FACE_SCORE_INVITE_PIC = 1002;
    public static final int STATE_TYPE_FOLLOW = 9;
    public static final int STATE_TYPE_LIKE_COMMENT = 5;
    public static final int STATE_TYPE_LIKE_POST = 2;
    public static final int STATE_TYPE_NEARBY_LIKE_POST = 7;
    public static final int STATE_TYPE_NEARBY_REPLY_COMMENT = 8;
    public static final int STATE_TYPE_NEARBY_REPLY_POST = 6;
    public static final int STATE_TYPE_REPLY_COMMENT = 4;
    public static final int STATE_TYPE_REPLY_POST = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_heap_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x86f.Details msg_details = new oidb_0x86f.Details();
    public oidb_0x86f.UserInfo msg_userinfo = new oidb_0x86f.UserInfo();
    public final PBUInt32Field uint32_state_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 802 }, new String[] { "uint32_state_type", "uint64_time", "uint64_seq", "msg_userinfo", "msg_details", "bytes_icon_url", "bytes_jump_url", "bytes_heap_jump_url", "bytes_jump_url2" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, UserInteractState.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x86f.oidb_0x86f
 * JD-Core Version:    0.7.0.1
 */