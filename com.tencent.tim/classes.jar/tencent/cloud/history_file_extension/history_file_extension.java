package tencent.cloud.history_file_extension;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class history_file_extension
{
  public static final class AIOFileExtension
    extends MessageMicro<AIOFileExtension>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "operateion_type", "uint64_sender_uin", "uint64_recver_uin", "uint64_discuss_uin", "uint64_groupe_code", "int32_group_busid", "str_group_file_path" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, AIOFileExtension.class);
    public final PBInt32Field int32_group_busid = PBField.initInt32(0);
    public final PBEnumField operateion_type = PBField.initEnum(0);
    public final PBStringField str_group_file_path = PBField.initString("");
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_groupe_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  }
  
  public static final class CloudFileExtension
    extends MessageMicro<CloudFileExtension>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tim_cloud_pdir_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_tim_cloud_pdir_id" }, new Object[] { localByteStringMicro }, CloudFileExtension.class);
    }
  }
  
  public static final class FileExtension
    extends MessageMicro<FileExtension>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48 }, new String[] { "uint64_session_id", "aio_file_extension", "cloud_file_extension", "weiyun_file_extension", "wps_file_extension", "bool_ios_system_album" }, new Object[] { Long.valueOf(0L), null, null, null, null, Boolean.valueOf(false) }, FileExtension.class);
    public history_file_extension.AIOFileExtension aio_file_extension = new history_file_extension.AIOFileExtension();
    public final PBBoolField bool_ios_system_album = PBField.initBool(false);
    public history_file_extension.CloudFileExtension cloud_file_extension = new history_file_extension.CloudFileExtension();
    public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
    public history_file_extension.WeiyunFileExtension weiyun_file_extension = new history_file_extension.WeiyunFileExtension();
    public history_file_extension.WPSFileExtension wps_file_extension = new history_file_extension.WPSFileExtension();
  }
  
  public static final class WPSFileExtension
    extends MessageMicro<WPSFileExtension>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_preview_url" }, new Object[] { "" }, WPSFileExtension.class);
    public final PBStringField str_preview_url = PBField.initString("");
  }
  
  public static final class WeiyunFileExtension
    extends MessageMicro<WeiyunFileExtension>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_thumb_url" }, new Object[] { "" }, WeiyunFileExtension.class);
    public final PBStringField str_thumb_url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.cloud.history_file_extension.history_file_extension
 * JD-Core Version:    0.7.0.1
 */