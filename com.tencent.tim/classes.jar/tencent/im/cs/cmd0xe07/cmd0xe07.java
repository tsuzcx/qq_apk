package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe07
{
  public static final class Coordinate
    extends MessageMicro<Coordinate>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "X", "Y" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Coordinate.class);
    public final PBInt32Field X = PBField.initInt32(0);
    public final PBInt32Field Y = PBField.initInt32(0);
  }
  
  public static final class Language
    extends MessageMicro<Language>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "language", "languageDesc" }, new Object[] { "", "" }, Language.class);
    public final PBStringField language = PBField.initString("");
    public final PBStringField languageDesc = PBField.initString("");
  }
  
  public static final class OCRReqBody
    extends MessageMicro<OCRReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 82, 90, 96, 104, 112, 120 }, new String[] { "imageUrl", "languageType", "scene", "originMd5", "afterCompressMd5", "afterCompressFileSize", "afterCompressWeight", "afterCompressHeight", "isCut" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, OCRReqBody.class);
    public final PBUInt32Field afterCompressFileSize = PBField.initUInt32(0);
    public final PBUInt32Field afterCompressHeight = PBField.initUInt32(0);
    public final PBStringField afterCompressMd5 = PBField.initString("");
    public final PBUInt32Field afterCompressWeight = PBField.initUInt32(0);
    public final PBStringField imageUrl = PBField.initString("");
    public final PBBoolField isCut = PBField.initBool(false);
    public final PBStringField languageType = PBField.initString("");
    public final PBStringField originMd5 = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
  }
  
  public static final class OCRRspBody
    extends MessageMicro<OCRRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 810, 818, 826, 888, 896 }, new String[] { "textDetections", "language", "requestId", "ocrLanguageList", "dstTranslateLanguageList", "languageList", "afterCompressWeight", "afterCompressHeight" }, new Object[] { null, "", "", "", "", null, Integer.valueOf(0), Integer.valueOf(0) }, OCRRspBody.class);
    public final PBUInt32Field afterCompressHeight = PBField.initUInt32(0);
    public final PBUInt32Field afterCompressWeight = PBField.initUInt32(0);
    public final PBRepeatField<String> dstTranslateLanguageList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField language = PBField.initString("");
    public final PBRepeatMessageField<cmd0xe07.Language> languageList = PBField.initRepeatMessage(cmd0xe07.Language.class);
    public final PBRepeatField<String> ocrLanguageList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField requestId = PBField.initString("");
    public final PBRepeatMessageField<cmd0xe07.TextDetection> textDetections = PBField.initRepeatMessage(cmd0xe07.TextDetection.class);
  }
  
  public static final class Polygon
    extends MessageMicro<Polygon>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "coordinates" }, new Object[] { null }, Polygon.class);
    public final PBRepeatMessageField<cmd0xe07.Coordinate> coordinates = PBField.initRepeatMessage(cmd0xe07.Coordinate.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 82 }, new String[] { "version", "client", "entrance", "ocrReqBody" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
    public final PBEnumField client = PBField.initEnum(0);
    public final PBEnumField entrance = PBField.initEnum(0);
    public cmd0xe07.OCRReqBody ocrReqBody = new cmd0xe07.OCRReqBody();
    public final PBUInt32Field version = PBField.initUInt32(1);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 82 }, new String[] { "retCode", "errMsg", "wording", "ocrRspBody" }, new Object[] { Integer.valueOf(0), "", "", null }, RspBody.class);
    public final PBStringField errMsg = PBField.initString("");
    public cmd0xe07.OCRRspBody ocrRspBody = new cmd0xe07.OCRRspBody();
    public final PBInt32Field retCode = PBField.initInt32(0);
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class TextDetection
    extends MessageMicro<TextDetection>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "detectedText", "confidence", "polygon", "advancedInfo" }, new Object[] { "", Integer.valueOf(0), null, "" }, TextDetection.class);
    public final PBStringField advancedInfo = PBField.initString("");
    public final PBUInt32Field confidence = PBField.initUInt32(0);
    public final PBStringField detectedText = PBField.initString("");
    public cmd0xe07.Polygon polygon = new cmd0xe07.Polygon();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0xe07.cmd0xe07
 * JD-Core Version:    0.7.0.1
 */