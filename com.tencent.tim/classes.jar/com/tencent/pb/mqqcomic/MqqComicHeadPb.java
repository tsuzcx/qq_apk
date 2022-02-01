package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MqqComicHeadPb
{
  public static final class ComicReqHead
    extends MessageMicro<ComicReqHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 66, 74, 82, 90 }, new String[] { "optTs", "src", "os", "clientVer", "net", "uin", "cmd", "screenQuality", "etag", "skey", "unifiedImei" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), "", "", "", "", "" }, ComicReqHead.class);
    public final PBStringField clientVer = PBField.initString("");
    public final PBStringField cmd = PBField.initString("");
    public final PBStringField etag = PBField.initString("");
    public final PBInt32Field net = PBField.initInt32(0);
    public final PBInt64Field optTs = PBField.initInt64(0L);
    public final PBInt32Field os = PBField.initInt32(0);
    public final PBStringField screenQuality = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBInt32Field src = PBField.initInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBStringField unifiedImei = PBField.initString("");
  }
  
  public static final class ComicRspHead
    extends MessageMicro<ComicRspHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField cmd = PBField.initString("");
    public final PBBytesField debugMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField etag = PBField.initString("");
    public final PBInt32Field maxCacheSec = PBField.initInt32(0);
    public final PBInt32Field reportRate = PBField.initInt32(0);
    public final PBInt32Field retCode = PBField.initInt32(0);
    public final PBBytesField retMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field uin = PBField.initInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 64 }, new String[] { "retCode", "retMsg", "debugMsg", "maxCacheSec", "etag", "cmd", "uin", "reportRate" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), "", "", Long.valueOf(0L), Integer.valueOf(0) }, ComicRspHead.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.mqqcomic.MqqComicHeadPb
 * JD-Core Version:    0.7.0.1
 */