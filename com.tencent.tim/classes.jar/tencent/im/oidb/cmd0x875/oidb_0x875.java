package tencent.im.oidb.cmd0x875;

import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x875
{
  public static final class Details
    extends MessageMicro<Details>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_back_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_pictures = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_text_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.RichText rich_text_body = new appoint_define.RichText();
    public final PBUInt32Field uint32_pictures_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_post_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 56 }, new String[] { "bytes_title", "bytes_pictures", "uint32_pictures_total", "bytes_text_body", "rich_text_body", "bytes_back_color", "uint32_post_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, null, localByteStringMicro4, Integer.valueOf(0) }, Details.class);
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
    public final PBRepeatMessageField<oidb_0x875.UserFollowState> rpt_msg_interact_list = PBField.initRepeatMessage(oidb_0x875.UserFollowState.class);
    public final PBUInt32Field uint32_isend = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  }
  
  public static final class UserFollowState
    extends MessageMicro<UserFollowState>
  {
    public static final int STATE_TYPE_CREATE_HOTCHAT = 13;
    public static final int STATE_TYPE_NEARBY_POST = 12;
    public static final int STATE_TYPE_NEW_POST = 11;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_from = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_op_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x875.Details msg_details = new oidb_0x875.Details();
    public oidb_0x875.UserInfo msg_userinfo = new oidb_0x875.UserInfo();
    public final PBUInt32Field uint32_state_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 50, 56, 64, 74 }, new String[] { "uint32_state_type", "msg_userinfo", "msg_details", "bytes_from", "bytes_jump_schema", "uint64_time", "uint64_seq", "bytes_op_txt" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3 }, UserFollowState.class);
    }
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_tinyid", "uint64_uin", "bytes_nick_name", "bytes_head_url" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, UserInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x875.oidb_0x875
 * JD-Core Version:    0.7.0.1
 */