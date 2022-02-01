package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenDetection
{
  public static final class DetectFaceReq
    extends MessageMicro<DetectFaceReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField app_id = PBField.initString("");
    public final PBInt32Field attr_flag = PBField.initInt32(255);
    public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field mode = PBField.initInt32(0);
    public final PBBoolField need_shape = PBField.initBool(true);
    public final PBStringField session_id = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 32, 40, 48, 66, 82 }, new String[] { "app_id", "image", "mode", "need_shape", "attr_flag", "url", "session_id" }, new Object[] { "", localByteStringMicro, Integer.valueOf(0), Boolean.valueOf(true), Integer.valueOf(255), "", "" }, DetectFaceReq.class);
    }
  }
  
  public static final class DetectFaceRsp
    extends MessageMicro<DetectFaceRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 24, 32, 42, 48, 58 }, new String[] { "session_id", "image_height", "image_width", "face", "errorcode", "errormsg" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), "" }, DetectFaceRsp.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBRepeatMessageField<YTOpenBase.FaceItem> face = PBField.initRepeatMessage(YTOpenBase.FaceItem.class);
    public final PBInt32Field image_height = PBField.initInt32(0);
    public final PBInt32Field image_width = PBField.initInt32(0);
    public final PBStringField session_id = PBField.initString("");
  }
  
  public static final class FaceShapeReq
    extends MessageMicro<FaceShapeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField app_id = PBField.initString("");
    public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field mode = PBField.initInt32(0);
    public final PBBoolField ret_image = PBField.initBool(false);
    public final PBStringField session_id = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 32, 40, 66, 82 }, new String[] { "app_id", "image", "mode", "ret_image", "url", "session_id" }, new Object[] { "", localByteStringMicro, Integer.valueOf(0), Boolean.valueOf(false), "", "" }, FaceShapeReq.class);
    }
  }
  
  public static final class FaceShapeRsp
    extends MessageMicro<FaceShapeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBRepeatMessageField<YTOpenBase.FaceShapeItem> face_shape = PBField.initRepeatMessage(YTOpenBase.FaceShapeItem.class);
    public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field image_height = PBField.initInt32(0);
    public final PBInt32Field image_width = PBField.initInt32(0);
    public final PBStringField session_id = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58 }, new String[] { "session_id", "face_shape", "image_height", "image_width", "image", "errorcode", "errormsg" }, new Object[] { "", null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), "" }, FaceShapeRsp.class);
    }
  }
  
  public static final class LightDetectReq
    extends MessageMicro<LightDetectReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField app_id = PBField.initString("");
    public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField session_id = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "app_id", "image", "url", "session_id" }, new Object[] { "", localByteStringMicro, "", "" }, LightDetectReq.class);
    }
  }
  
  public static final class LightDetectRsp
    extends MessageMicro<LightDetectRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "session_id", "score", "lr_gram_dif", "lr_dif", "face_whole", "face_dif", "errorcode", "errormsg" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, LightDetectRsp.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBInt32Field face_dif = PBField.initInt32(0);
    public final PBInt32Field face_whole = PBField.initInt32(0);
    public final PBInt32Field lr_dif = PBField.initInt32(0);
    public final PBInt32Field lr_gram_dif = PBField.initInt32(0);
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBStringField session_id = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenDetection
 * JD-Core Version:    0.7.0.1
 */