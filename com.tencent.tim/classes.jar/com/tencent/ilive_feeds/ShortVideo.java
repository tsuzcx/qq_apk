package com.tencent.ilive_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ShortVideo
{
  public static final class CheckAuthReq
    extends MessageMicro<CheckAuthReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ver" }, new Object[] { Integer.valueOf(0) }, CheckAuthReq.class);
    public final PBInt32Field ver = PBField.initInt32(0);
  }
  
  public static final class CheckAuthRsp
    extends MessageMicro<CheckAuthRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "err_msg" }, new Object[] { Integer.valueOf(0), "" }, CheckAuthRsp.class);
    public final PBStringField err_msg = PBField.initString("");
    public final PBInt32Field retcode = PBField.initInt32(0);
  }
  
  public static final class DeleteReq
    extends MessageMicro<DeleteReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field file_type = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBInt32Field ver = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "ver", "seq", "file_type", "file_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, DeleteReq.class);
    }
  }
  
  public static final class DeleteRsp
    extends MessageMicro<DeleteRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "seq", "retcode" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, DeleteRsp.class);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class UploadReq
    extends MessageMicro<UploadReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ver" }, new Object[] { Integer.valueOf(0) }, UploadReq.class);
    public final PBInt32Field ver = PBField.initInt32(0);
  }
  
  public static final class UploadRsp
    extends MessageMicro<UploadRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField authkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field expiretime = PBField.initUInt32(0);
    public final PBUInt32Field frontid = PBField.initUInt32(0);
    public final PBRepeatField<Integer> frontip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field prov = PBField.initUInt32(0);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBUInt32Field userflag = PBField.initUInt32(0);
    public final PBUInt32Field userip = PBField.initUInt32(0);
    public final PBInt32Field ver = PBField.initInt32(0);
    public final PBStringField zonedomain = PBField.initString("");
    public final PBUInt32Field zoneid = PBField.initUInt32(0);
    public final PBRepeatField<Integer> zoneip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 98, 106 }, new String[] { "retcode", "ver", "userip", "prov", "frontid", "frontip", "zoneid", "zoneip", "expiretime", "zonedomain", "userflag", "authkey", "err_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro, "" }, UploadRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ilive_feeds.ShortVideo
 * JD-Core Version:    0.7.0.1
 */