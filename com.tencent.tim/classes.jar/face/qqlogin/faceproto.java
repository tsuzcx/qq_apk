package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class faceproto
{
  public static final class App
    extends MessageMicro<App>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "AppID", "OpenID", "Sign", "Time" }, new Object[] { Integer.valueOf(0), "", "", "" }, App.class);
    public final PBUInt32Field AppID = PBField.initUInt32(0);
    public final PBStringField OpenID = PBField.initString("");
    public final PBStringField Sign = PBField.initString("");
    public final PBStringField Time = PBField.initString("");
  }
  
  public static final class FaceInfo
    extends MessageMicro<FaceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "Medias", "RecMode" }, new Object[] { null, Integer.valueOf(0) }, FaceInfo.class);
    public final PBRepeatMessageField<faceproto.Media> Medias = PBField.initRepeatMessage(faceproto.Media.class);
    public final PBEnumField RecMode = PBField.initEnum(0);
  }
  
  public static final class Media
    extends MessageMicro<Media>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "Tag", "Type", "Size", "Action" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, Media.class);
    public final PBStringField Action = PBField.initString("");
    public final PBUInt32Field Size = PBField.initUInt32(0);
    public final PBEnumField Tag = PBField.initEnum(0);
    public final PBEnumField Type = PBField.initEnum(0);
  }
  
  public static final class Request
    extends MessageMicro<Request>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 56, 66 }, new String[] { "SrcApp", "AppID", "UserInfo", "FaceInfo", "TmpKey", "Session", "CurRetryCnt", "plt" }, new Object[] { null, Integer.valueOf(0), null, null, "", "", Integer.valueOf(0), "" }, Request.class);
    public final PBUInt32Field AppID = PBField.initUInt32(0);
    public final PBUInt32Field CurRetryCnt = PBField.initUInt32(0);
    public faceproto.FaceInfo FaceInfo = new faceproto.FaceInfo();
    public final PBStringField Session = PBField.initString("");
    public faceproto.App SrcApp = new faceproto.App();
    public final PBStringField TmpKey = PBField.initString("");
    public faceproto.UserInfo UserInfo = new faceproto.UserInfo();
    public final PBStringField plt = PBField.initString("");
  }
  
  public static final class Response
    extends MessageMicro<Response>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "Ret", "ErrMsg", "IDKey", "NeedRetry" }, new Object[] { Integer.valueOf(0), "", "", Boolean.valueOf(false) }, Response.class);
    public final PBStringField ErrMsg = PBField.initString("");
    public final PBStringField IDKey = PBField.initString("");
    public final PBBoolField NeedRetry = PBField.initBool(false);
    public final PBUInt32Field Ret = PBField.initUInt32(0);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "Name", "IDCardNumber" }, new Object[] { "", "" }, UserInfo.class);
    public final PBStringField IDCardNumber = PBField.initString("");
    public final PBStringField Name = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     face.qqlogin.faceproto
 * JD-Core Version:    0.7.0.1
 */