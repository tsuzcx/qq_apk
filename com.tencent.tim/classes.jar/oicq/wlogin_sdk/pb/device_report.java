package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class device_report
{
  public static final class DeviceReport
    extends MessageMicro<DeviceReport>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_android_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_baseband = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_boot_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_bootloader = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_codename = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_fingerprint = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_incremental = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_inner_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "bytes_bootloader", "bytes_version", "bytes_codename", "bytes_incremental", "bytes_fingerprint", "bytes_boot_id", "bytes_android_id", "bytes_baseband", "bytes_inner_ver" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9 }, DeviceReport.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.pb.device_report
 * JD-Core Version:    0.7.0.1
 */