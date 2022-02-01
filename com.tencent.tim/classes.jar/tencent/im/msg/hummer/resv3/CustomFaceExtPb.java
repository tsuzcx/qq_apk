package tencent.im.msg.hummer.resv3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CustomFaceExtPb
{
  public static final class AnimationImageShow
    extends MessageMicro<AnimationImageShow>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_animation_param = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_effect_id = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_effect_id", "bytes_animation_param" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, AnimationImageShow.class);
    }
  }
  
  public static final class ResvAttr
    extends MessageMicro<ResvAttr>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_text_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public CustomFaceExtPb.AnimationImageShow msg_image_show = new CustomFaceExtPb.AnimationImageShow();
    public final PBStringField string_camera_capture_materialname = PBField.initString("");
    public final PBStringField string_camera_capture_templateinfo = PBField.initString("");
    public final PBStringField string_doutu_suppliers = PBField.initString("");
    public final PBStringField string_emoji_iconUrl = PBField.initString("");
    public final PBStringField string_emoji_marketFaceName = PBField.initString("");
    public final PBStringField string_emoji_source = PBField.initString("");
    public final PBStringField string_emoji_webUrl = PBField.initString("");
    public final PBStringField string_text = PBField.initString("");
    public final PBUInt32Field uint32_customface_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_emoji_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_emoji_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_emoji_packageid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_image_biz_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 74, 80, 90, 98, 106, 114, 120, 130, 138 }, new String[] { "uint32_image_biz_type", "uint32_customface_type", "uint32_emoji_packageid", "uint32_emoji_id", "string_text", "string_doutu_suppliers", "msg_image_show", "bytes_text_summary", "uint32_emoji_from", "string_emoji_source", "string_emoji_webUrl", "string_emoji_iconUrl", "string_emoji_marketFaceName", "uint32_source", "string_camera_capture_templateinfo", "string_camera_capture_materialname" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", null, localByteStringMicro, Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", "" }, ResvAttr.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.resv3.CustomFaceExtPb
 * JD-Core Version:    0.7.0.1
 */