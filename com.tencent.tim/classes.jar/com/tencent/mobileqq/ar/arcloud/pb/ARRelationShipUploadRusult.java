package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ARRelationShipUploadRusult
{
  public static final class StoryVideoExtReq
    extends MessageMicro<StoryVideoExtReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], StoryVideoExtReq.class);
  }
  
  public static final class StoryVideoExtRsp
    extends MessageMicro<StoryVideoExtRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cdn_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_retcode = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "int32_retcode", "bytes_msg", "bytes_cdn_url", "bytes_file_key", "bytes_file_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, StoryVideoExtRsp.class);
    }
  }
  
  public static final class UploadPicExtInfo
    extends MessageMicro<UploadPicExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_file_resid", "bytes_download_url", "bytes_thumb_download_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, UploadPicExtInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipUploadRusult
 * JD-Core Version:    0.7.0.1
 */