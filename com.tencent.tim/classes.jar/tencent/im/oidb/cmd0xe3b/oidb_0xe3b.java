package tencent.im.oidb.cmd0xe3b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe3b
{
  public static final class Color
    extends MessageMicro<Color>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_group_id", "uint32_group_type", "uint32_group_total_person", "rpt_uint64_group_manager" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, GroupInfo.class);
    public final PBRepeatField<Long> rpt_uint64_group_manager = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_group_total_person = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  }
  
  public static final class HighlightTitle
    extends MessageMicro<HighlightTitle>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_highlight_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_title_type = PBField.initEnum(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_highlight_title", "enum_title_type", "uint64_uin" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, HighlightTitle.class);
    }
  }
  
  public static final class Label
    extends MessageMicro<Label>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xe3b.Color edging_color = new oidb_0xe3b.Color();
    public oidb_0xe3b.Color text_color = new oidb_0xe3b.Color();
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_name", "text_color", "edging_color", "uint32_label_type" }, new Object[] { localByteStringMicro, null, null, Integer.valueOf(0) }, Label.class);
    }
  }
  
  public static final class RecommendPerson
    extends MessageMicro<RecommendPerson>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0xe3b.Label> rpt_msg_label = PBField.initRepeatMessage(oidb_0xe3b.Label.class);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "uint64_uin", "bytes_reason", "rpt_msg_label", "bytes_title", "uint32_age", "uint32_gender" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, null, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, RecommendPerson.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie_for_req_type_1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cookie_for_req_type_2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xe3b.GroupInfo msg_group_info = new oidb_0xe3b.GroupInfo();
    public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_uin_show_ahead = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_graybar_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 64 }, new String[] { "uint32_req_type", "msg_group_info", "bytes_cookie_for_req_type_1", "bytes_cookie_for_req_type_2", "uint32_graybar_type", "uint32_want", "rpt_uint64_uin_show_ahead", "rpt_uint64_uin_list" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie_for_req_type_1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cookie_for_req_type_2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_graybar_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording_for_empty_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0xe3b.HighlightTitle> rpt_msg_highlight_title = PBField.initRepeatMessage(oidb_0xe3b.HighlightTitle.class);
    public final PBRepeatMessageField<oidb_0xe3b.RecommendPerson> rpt_msg_person = PBField.initRepeatMessage(oidb_0xe3b.RecommendPerson.class);
    public final PBUInt32Field uint32_graybar_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66 }, new String[] { "uint32_graybar_type", "bytes_graybar_title", "rpt_msg_highlight_title", "uint32_sub_id", "rpt_msg_person", "bytes_cookie_for_req_type_1", "bytes_cookie_for_req_type_2", "bytes_wording_for_empty_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), null, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3b.oidb_0xe3b
 * JD-Core Version:    0.7.0.1
 */