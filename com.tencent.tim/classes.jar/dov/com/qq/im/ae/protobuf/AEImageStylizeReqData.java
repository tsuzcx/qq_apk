package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AEImageStylizeReqData
{
  public static final class FaceInfo
    extends MessageMicro<FaceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 29, 37, 45, 50 }, new String[] { "pos", "rc_face", "rc_leftEye", "rc_rightEye", "rc_mouth", "face_pose" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), null }, FaceInfo.class);
    public AEImageStylizeReqData.FacePose face_pose = new AEImageStylizeReqData.FacePose();
    public final PBRepeatField<Float> pos = PBField.initRepeat(PBFloatField.__repeatHelper__);
    public final PBRepeatField<Float> rc_face = PBField.initRepeat(PBFloatField.__repeatHelper__);
    public final PBRepeatField<Float> rc_leftEye = PBField.initRepeat(PBFloatField.__repeatHelper__);
    public final PBRepeatField<Float> rc_mouth = PBField.initRepeat(PBFloatField.__repeatHelper__);
    public final PBRepeatField<Float> rc_rightEye = PBField.initRepeat(PBFloatField.__repeatHelper__);
  }
  
  public static final class FacePose
    extends MessageMicro<FacePose>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 29 }, new String[] { "pitch", "yaw", "roll" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) }, FacePose.class);
    public final PBFloatField pitch = PBField.initFloat(0.0F);
    public final PBFloatField roll = PBField.initFloat(0.0F);
    public final PBFloatField yaw = PBField.initFloat(0.0F);
  }
  
  public static final class ImageInfo
    extends MessageMicro<ImageInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<AEImageStylizeReqData.FaceInfo> faceInfos = PBField.initRepeatMessage(AEImageStylizeReqData.FaceInfo.class);
    public final PBInt32Field faceNum = PBField.initInt32(0);
    public final PBBoolField hasFace = PBField.initBool(false);
    public final PBBytesField imageRawData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field imgHeight = PBField.initInt32(0);
    public final PBInt32Field imgWidth = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48 }, new String[] { "imageRawData", "hasFace", "faceNum", "faceInfos", "imgWidth", "imgHeight" }, new Object[] { localByteStringMicro, Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ImageInfo.class);
    }
  }
  
  public static final class ImageStylizeRequest
    extends MessageMicro<ImageStylizeRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "imgInfo", "stylizeType" }, new Object[] { null, Integer.valueOf(0) }, ImageStylizeRequest.class);
    public AEImageStylizeReqData.ImageInfo imgInfo = new AEImageStylizeReqData.ImageInfo();
    public final PBEnumField stylizeType = PBField.initEnum(0);
  }
  
  public static final class ImageStylizeResponse
    extends MessageMicro<ImageStylizeResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBBytesField imageRawData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField msg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "code", "msg", "imageRawData" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro }, ImageStylizeResponse.class);
    }
  }
  
  public static final class Point
    extends MessageMicro<Point>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21 }, new String[] { "x", "y" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F) }, Point.class);
    public final PBFloatField x = PBField.initFloat(0.0F);
    public final PBFloatField y = PBField.initFloat(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEImageStylizeReqData
 * JD-Core Version:    0.7.0.1
 */