package tencent.im.oidb.cmd0xe16;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe16
{
  public static final class CardJumpInfo
    extends MessageMicro<CardJumpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_card_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_btn_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_available = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_available", "bytes_card_jump_url", "bytes_comment_btn_url", "bytes_share_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, CardJumpInfo.class);
    }
  }
  
  public static final class CommentInfo
    extends MessageMicro<CommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "str_comment", "rpt_media_data_list", "str_comment_id", "str_sub_comment_id", "uint64_sub_author" }, new Object[] { "", null, "", "", Long.valueOf(0L) }, CommentInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xe16.MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_cmd0xe16.MediaData.class);
    public final PBStringField str_comment = PBField.initString("");
    public final PBStringField str_comment_id = PBField.initString("");
    public final PBStringField str_sub_comment_id = PBField.initString("");
    public final PBUInt64Field uint64_sub_author = PBField.initUInt64(0L);
  }
  
  public static final class ContentInfo
    extends MessageMicro<ContentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_rowkey", "uint32_src" }, new Object[] { "", Integer.valueOf(0) }, ContentInfo.class);
    public final PBStringField str_rowkey = PBField.initString("");
    public final PBUInt32Field uint32_src = PBField.initUInt32(0);
  }
  
  public static final class KeyInfo
    extends MessageMicro<KeyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "str_comment_id", "uint64_feeds_id", "uint32_feeds_type", "str_sub_comment_id" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "" }, KeyInfo.class);
    public final PBStringField str_comment_id = PBField.initString("");
    public final PBStringField str_sub_comment_id = PBField.initString("");
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  }
  
  public static final class MediaData
    extends MessageMicro<MediaData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_text", "str_pic_url", "uint32_pic_width", "uint32_pci_height" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, MediaData.class);
    public final PBStringField str_pic_url = PBField.initString("");
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_pci_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
  }
  
  public static final class ParamInfo
    extends MessageMicro<ParamInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bool_with_biu", "bool_diffuse_to_friends" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) }, ParamInfo.class);
    public final PBBoolField bool_diffuse_to_friends = PBField.initBool(false);
    public final PBBoolField bool_with_biu = PBField.initBool(false);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_param_info", "msg_comment_info", "msg_content_info" }, new Object[] { null, null, null }, ReqBody.class);
    public oidb_cmd0xe16.CommentInfo msg_comment_info = new oidb_cmd0xe16.CommentInfo();
    public oidb_cmd0xe16.ContentInfo msg_content_info = new oidb_cmd0xe16.ContentInfo();
    public oidb_cmd0xe16.ParamInfo msg_param_info = new oidb_cmd0xe16.ParamInfo();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_key_info", "msg_card_jump_info" }, new Object[] { null, null }, RspBody.class);
    public oidb_cmd0xe16.CardJumpInfo msg_card_jump_info = new oidb_cmd0xe16.CardJumpInfo();
    public oidb_cmd0xe16.KeyInfo msg_key_info = new oidb_cmd0xe16.KeyInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe16.oidb_cmd0xe16
 * JD-Core Version:    0.7.0.1
 */