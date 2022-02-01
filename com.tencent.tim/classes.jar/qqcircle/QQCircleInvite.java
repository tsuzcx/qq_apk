package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleInvite
{
  public static final class BatchVerifyCircleWorldReq
    extends MessageMicro<BatchVerifyCircleWorldReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "uin" }, new Object[] { null, Integer.valueOf(0) }, BatchVerifyCircleWorldReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatField<Integer> uin = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class BatchVerifyCircleWorldRsp
    extends MessageMicro<BatchVerifyCircleWorldRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "userinfo" }, new Object[] { null, null }, BatchVerifyCircleWorldRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<QQCircleInvite.StCircleUser> userinfo = PBField.initRepeatMessage(QQCircleInvite.StCircleUser.class);
  }
  
  public static final class CheckPavInviteCircleCountReq
    extends MessageMicro<CheckPavInviteCircleCountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, CheckPavInviteCircleCountReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class CheckPavInviteCircleCountRsp
    extends MessageMicro<CheckPavInviteCircleCountRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "isLimit" }, new Object[] { null, Integer.valueOf(0) }, CheckPavInviteCircleCountRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field isLimit = PBField.initInt32(0);
  }
  
  public static final class GetCircleInviteReq
    extends MessageMicro<GetCircleInviteReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, GetCircleInviteReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetCircleInviteRsp
    extends MessageMicro<GetCircleInviteRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "extInfo", "inviteID", "nick", "ticket", "frdFuel" }, new Object[] { null, "", "", "", Integer.valueOf(0) }, GetCircleInviteRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field frdFuel = PBField.initInt32(0);
    public final PBStringField inviteID = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField ticket = PBField.initString("");
  }
  
  public static final class GetCircleWorldReq
    extends MessageMicro<GetCircleWorldReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, GetCircleWorldReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetCircleWorldRsp
    extends MessageMicro<GetCircleWorldRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "peoplenum", "summary" }, new Object[] { null, Integer.valueOf(0), "" }, GetCircleWorldRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field peoplenum = PBField.initInt32(0);
    public final PBStringField summary = PBField.initString("");
  }
  
  public static final class SetCircleWorldReq
    extends MessageMicro<SetCircleWorldReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, SetCircleWorldReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class SetCircleWorldRsp
    extends MessageMicro<SetCircleWorldRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "result" }, new Object[] { null, Integer.valueOf(0) }, SetCircleWorldRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class StCircleUser
    extends MessageMicro<StCircleUser>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "invalid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, StCircleUser.class);
    public final PBInt32Field invalid = PBField.initInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class VerifyCircleInviteReq
    extends MessageMicro<VerifyCircleInviteReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "inviteID" }, new Object[] { null, "" }, VerifyCircleInviteReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField inviteID = PBField.initString("");
  }
  
  public static final class VerifyCircleInviteRsp
    extends MessageMicro<VerifyCircleInviteRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "invalid" }, new Object[] { null, Integer.valueOf(0) }, VerifyCircleInviteRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field invalid = PBField.initInt32(0);
  }
  
  public static final class VerifyCircleWorldReq
    extends MessageMicro<VerifyCircleWorldReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, VerifyCircleWorldReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class VerifyCircleWorldRsp
    extends MessageMicro<VerifyCircleWorldRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "invalid" }, new Object[] { null, Integer.valueOf(0) }, VerifyCircleWorldRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field invalid = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleInvite
 * JD-Core Version:    0.7.0.1
 */