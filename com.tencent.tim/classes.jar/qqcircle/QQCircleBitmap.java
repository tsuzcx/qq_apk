package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleBitmap
{
  public static final class BypassBeatReq
    extends MessageMicro<BypassBeatReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], BypassBeatReq.class);
  }
  
  public static final class BypassBeatRsp
    extends MessageMicro<BypassBeatRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField errormsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field ret = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "errormsg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, BypassBeatRsp.class);
    }
  }
  
  public static final class GetBlackFlagReq
    extends MessageMicro<GetBlackFlagReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "uids" }, new Object[] { null, "" }, GetBlackFlagReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class GetBlackFlagRsp
    extends MessageMicro<GetBlackFlagRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "results" }, new Object[] { null, null }, GetBlackFlagRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<QQCircleBitmap.SingleResult> results = PBField.initRepeatMessage(QQCircleBitmap.SingleResult.class);
  }
  
  public static final class SetBlackFlagReq
    extends MessageMicro<SetBlackFlagReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "uids", "op" }, new Object[] { null, "", Integer.valueOf(0) }, SetBlackFlagReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field op = PBField.initInt32(0);
    public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class SetBlackFlagRsp
    extends MessageMicro<SetBlackFlagRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "results" }, new Object[] { null, null }, SetBlackFlagRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<QQCircleBitmap.SingleResult> results = PBField.initRepeatMessage(QQCircleBitmap.SingleResult.class);
  }
  
  public static final class SingleResult
    extends MessageMicro<SingleResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "uid", "ret", "value" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, SingleResult.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField uid = PBField.initString("");
    public final PBInt32Field value = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleBitmap
 * JD-Core Version:    0.7.0.1
 */