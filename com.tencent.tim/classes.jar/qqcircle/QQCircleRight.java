package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRight
{
  public static final class GetCircleUnCareListReq
    extends MessageMicro<GetCircleUnCareListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, GetCircleUnCareListReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetCircleUnCareListRsp
    extends MessageMicro<GetCircleUnCareListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "uinlist" }, new Object[] { null, Integer.valueOf(0) }, GetCircleUnCareListRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatField<Integer> uinlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class SetCircleUnCareReq
    extends MessageMicro<SetCircleUnCareReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "extInfo", "uin", "operType" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(1) }, SetCircleUnCareReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBEnumField operType = PBField.initEnum(1);
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class SetCircleUnCareRsp
    extends MessageMicro<SetCircleUnCareRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "result" }, new Object[] { null, Integer.valueOf(0) }, SetCircleUnCareRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class VerifyCircleUnCareReq
    extends MessageMicro<VerifyCircleUnCareReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "uin" }, new Object[] { null, Integer.valueOf(0) }, VerifyCircleUnCareReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class VerifyCircleUnCareRsp
    extends MessageMicro<VerifyCircleUnCareRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "isBlack" }, new Object[] { null, Integer.valueOf(0) }, VerifyCircleUnCareRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field isBlack = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRight
 * JD-Core Version:    0.7.0.1
 */