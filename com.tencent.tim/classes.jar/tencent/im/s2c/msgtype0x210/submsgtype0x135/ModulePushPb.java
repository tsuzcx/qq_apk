package tencent.im.s2c.msgtype0x210.submsgtype0x135;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ModulePushPb
{
  public static final class Content
    extends MessageMicro<Content>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public ModulePushPb.Forward msg_forward = new ModulePushPb.Forward();
    public ModulePushPb.Image msg_image = new ModulePushPb.Image();
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uint64_from_uin", "str_title", "str_desc", "msg_image", "msg_forward", "bytes_ext_data" }, new Object[] { Long.valueOf(0L), "", "", null, null, localByteStringMicro }, Content.class);
    }
  }
  
  public static final class Forward
    extends MessageMicro<Forward>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_url", "uint32_type" }, new Object[] { "", Integer.valueOf(0) }, Forward.class);
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class Image
    extends MessageMicro<Image>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_url", "width", "height" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, Image.class);
    public final PBInt32Field height = PBField.initInt32(0);
    public final PBStringField str_url = PBField.initString("");
    public final PBInt32Field width = PBField.initInt32(0);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "int32_service_id", "int32_sub_service_id", "int32_notify_id", "int32_push_id", "int32_type", "int32_recall_flag", "msg_content" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, MsgBody.class);
    public final PBInt32Field int32_notify_id = PBField.initInt32(0);
    public final PBInt32Field int32_push_id = PBField.initInt32(0);
    public final PBInt32Field int32_recall_flag = PBField.initInt32(0);
    public final PBInt32Field int32_service_id = PBField.initInt32(0);
    public final PBInt32Field int32_sub_service_id = PBField.initInt32(0);
    public final PBInt32Field int32_type = PBField.initInt32(0);
    public ModulePushPb.Content msg_content = new ModulePushPb.Content();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb
 * JD-Core Version:    0.7.0.1
 */