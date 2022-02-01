package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudQwebcal
{
  public static final class StAuthInfo
    extends MessageMicro<StAuthInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<FeedCloudCommon.Entry> Extinfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBBytesField sessionkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField uin = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66 }, new String[] { "uin", "sig", "platform", "type", "appid", "openid", "sessionkey", "Extinfo" }, new Object[] { "", localByteStringMicro1, "", Integer.valueOf(0), "", "", localByteStringMicro2, null }, StAuthInfo.class);
    }
  }
  
  public static final class StEncryption
    extends MessageMicro<StEncryption>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "method", "iv" }, new Object[] { Integer.valueOf(0), "" }, StEncryption.class);
    public final PBStringField iv = PBField.initString("");
    public final PBUInt32Field method = PBField.initUInt32(0);
  }
  
  public static final class StQWebReq
    extends MessageMicro<StQWebReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField Cmdname = PBField.initString("");
    public FeedCloudQwebcal.StEncryption Crypto = new FeedCloudQwebcal.StEncryption();
    public final PBRepeatMessageField<FeedCloudCommon.Entry> Extinfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
    public final PBStringField Module = PBField.initString("");
    public final PBUInt64Field Seq = PBField.initUInt64(0L);
    public final PBBytesField busiBuff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField deviceInfo = PBField.initString("");
    public FeedCloudQwebcal.StAuthInfo loginSig = new FeedCloudQwebcal.StAuthInfo();
    public final PBStringField qua = PBField.initString("");
    public final PBStringField traceid = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "Seq", "qua", "deviceInfo", "busiBuff", "traceid", "Module", "Cmdname", "loginSig", "Crypto", "Extinfo" }, new Object[] { Long.valueOf(0L), "", "", localByteStringMicro, "", "", "", null, null, null }, StQWebReq.class);
    }
  }
  
  public static final class StQWebRsp
    extends MessageMicro<StQWebRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<FeedCloudCommon.Entry> Extinfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
    public final PBUInt64Field Seq = PBField.initUInt64(0L);
    public final PBBytesField busiBuff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field retCode = PBField.initInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "Seq", "retCode", "errMsg", "busiBuff", "Extinfo" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null }, StQWebRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudQwebcal
 * JD-Core Version:    0.7.0.1
 */