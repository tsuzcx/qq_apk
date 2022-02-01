package tencent.im.msg.resv21;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_resv_21
{
  public static final class FileApkInfo
    extends MessageMicro<FileApkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_package_name", "str_version", "str_app_name", "str_icon_url" }, new Object[] { "", "", "", "" }, FileApkInfo.class);
    public final PBStringField str_app_name = PBField.initString("");
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_package_name = PBField.initString("");
    public final PBStringField str_version = PBField.initString("");
  }
  
  public static final class FileImgInfo
    extends MessageMicro<FileImgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_file_width", "uint32_file_height" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FileImgInfo.class);
    public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
  }
  
  public static final class ForwardExtFileInfo
    extends MessageMicro<ForwardExtFileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_sha1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field int64_dead_time = PBField.initInt64(0L);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_img_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_img_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_video_duration = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 66, 72, 80, 88, 96, 104, 114 }, new String[] { "uint32_file_type", "uint64_sender_uin", "uint64_receiver_uin", "bytes_file_uuid", "str_file_name", "uint64_file_size", "bytes_file_sha1", "bytes_file_md5", "int64_dead_time", "uint32_img_width", "uint32_img_height", "uint64_video_duration", "uint32_bus_id", "str_fileidcrc" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, "", Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "" }, ForwardExtFileInfo.class);
    }
  }
  
  public static final class ResvAttr
    extends MessageMicro<ResvAttr>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "file_image_info", "forward_ext_file_info", "file_apk_info" }, new Object[] { null, null, null }, ResvAttr.class);
    public hummer_resv_21.FileApkInfo file_apk_info = new hummer_resv_21.FileApkInfo();
    public hummer_resv_21.FileImgInfo file_image_info = new hummer_resv_21.FileImgInfo();
    public hummer_resv_21.ForwardExtFileInfo forward_ext_file_info = new hummer_resv_21.ForwardExtFileInfo();
  }
  
  public static final class XtfSenderInfo
    extends MessageMicro<XtfSenderInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_lan_ip", "uint32_lan_port", "uint64_lan_srkey" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, XtfSenderInfo.class);
    public final PBUInt32Field uint32_lan_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lan_port = PBField.initUInt32(0);
    public final PBUInt64Field uint64_lan_srkey = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.msg.resv21.hummer_resv_21
 * JD-Core Version:    0.7.0.1
 */