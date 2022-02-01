package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleRead
{
  public static final class CertificationDetail
    extends MessageMicro<CertificationDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "circleType", "circleStatue", "studentInfo", "staffInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, CertificationDetail.class);
    public final PBInt32Field circleStatue = PBField.initInt32(0);
    public final PBInt32Field circleType = PBField.initInt32(0);
    public QQCircleBase.StaffInfo staffInfo = new QQCircleBase.StaffInfo();
    public QQCircleBase.StudentInfo studentInfo = new QQCircleBase.StudentInfo();
  }
  
  public static final class CertificationDetailV2
    extends MessageMicro<CertificationDetailV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "circleType", "circleStatue", "studentInfo", "staffInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, CertificationDetailV2.class);
    public final PBInt32Field circleStatue = PBField.initInt32(0);
    public final PBInt32Field circleType = PBField.initInt32(0);
    public QQCircleBase.StaffInfo staffInfo = new QQCircleBase.StaffInfo();
    public QQCircleBase.StudentInfo studentInfo = new QQCircleBase.StudentInfo();
  }
  
  public static final class CircleDetail
    extends MessageMicro<CircleDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 58 }, new String[] { "id", "name", "circleType", "memberCount", "avatarUrl" }, new Object[] { "", "", Integer.valueOf(0), Long.valueOf(0L), "" }, CircleDetail.class);
    public final PBStringField avatarUrl = PBField.initString("");
    public final PBInt32Field circleType = PBField.initInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBInt64Field memberCount = PBField.initInt64(0L);
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class ConfidentCircleMemberReq
    extends MessageMicro<ConfidentCircleMemberReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "circleInfo" }, new Object[] { null, null }, ConfidentCircleMemberReq.class);
    public QQCircleBase.UserCircleInfo circleInfo = new QQCircleBase.UserCircleInfo();
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class ConfidentCircleMemberRsp
    extends MessageMicro<ConfidentCircleMemberRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "result" }, new Object[] { null, Integer.valueOf(0) }, ConfidentCircleMemberRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class GetCircleDetailReq
    extends MessageMicro<GetCircleDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "idList" }, new Object[] { null, "" }, GetCircleDetailReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatField<String> idList = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class GetCircleDetailRsp
    extends MessageMicro<GetCircleDetailRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "circleList" }, new Object[] { null, null }, GetCircleDetailRsp.class);
    public final PBRepeatMessageField<QQCircleRead.CircleDetail> circleList = PBField.initRepeatMessage(QQCircleRead.CircleDetail.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetCircleEmailSuffixReq
    extends MessageMicro<GetCircleEmailSuffixReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "circleID" }, new Object[] { null, "" }, GetCircleEmailSuffixReq.class);
    public final PBStringField circleID = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetCircleEmailSuffixRsp
    extends MessageMicro<GetCircleEmailSuffixRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "emailSuffix" }, new Object[] { null, "" }, GetCircleEmailSuffixRsp.class);
    public final PBStringField emailSuffix = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetCircleMemberReq
    extends MessageMicro<GetCircleMemberReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "id", "count", "attachInfo" }, new Object[] { null, "", Long.valueOf(0L), "" }, GetCircleMemberReq.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBInt64Field count = PBField.initInt64(0L);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField id = PBField.initString("");
  }
  
  public static final class GetCircleMemberRsp
    extends MessageMicro<GetCircleMemberRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "attachInfo", "hasNext", "total", "userList" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), null }, GetCircleMemberRsp.class);
    public final PBStringField attachInfo = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field hasNext = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StUser> userList = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
  }
  
  public static final class GetCircleTagInfoReq
    extends MessageMicro<GetCircleTagInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "tagNameList", "needJoinNum", "needFollowStatus" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0) }, GetCircleTagInfoReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field needFollowStatus = PBField.initInt32(0);
    public final PBInt32Field needJoinNum = PBField.initInt32(0);
    public final PBRepeatField<String> tagNameList = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class GetCircleTagInfoRsp
    extends MessageMicro<GetCircleTagInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "tagList" }, new Object[] { null, null }, GetCircleTagInfoRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<QQCircleRead.TagItem> tagList = PBField.initRepeatMessage(QQCircleRead.TagItem.class);
  }
  
  public static final class GetFollowTagListReq
    extends MessageMicro<GetFollowTagListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "hostUin", "attachInfo", "count" }, new Object[] { null, "", "", Integer.valueOf(0) }, GetFollowTagListReq.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField hostUin = PBField.initString("");
  }
  
  public static final class GetFollowTagListRsp
    extends MessageMicro<GetFollowTagListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "tagList", "attachInfo", "hasNext" }, new Object[] { null, null, "", Integer.valueOf(0) }, GetFollowTagListRsp.class);
    public final PBStringField attachInfo = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field hasNext = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleRead.TagItem> tagList = PBField.initRepeatMessage(QQCircleRead.TagItem.class);
  }
  
  public static final class GetUploadTmpCredentialReq
    extends MessageMicro<GetUploadTmpCredentialReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, GetUploadTmpCredentialReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetUploadTmpCredentialRsp
    extends MessageMicro<GetUploadTmpCredentialRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "tmpSecretID", "tmpSecretKey", "sessionToken" }, new Object[] { null, "", "", "" }, GetUploadTmpCredentialRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField sessionToken = PBField.initString("");
    public final PBStringField tmpSecretID = PBField.initString("");
    public final PBStringField tmpSecretKey = PBField.initString("");
  }
  
  public static final class GetUserCertificationReq
    extends MessageMicro<GetUserCertificationReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "extInfo", "flag", "hostUin", "needNoPass", "needDetail" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, GetUserCertificationReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field flag = PBField.initInt32(0);
    public final PBStringField hostUin = PBField.initString("");
    public final PBInt32Field needDetail = PBField.initInt32(0);
    public final PBInt32Field needNoPass = PBField.initInt32(0);
  }
  
  public static final class GetUserCertificationReqV2
    extends MessageMicro<GetUserCertificationReqV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "extInfo", "certFlag", "hostUin", "statusFlag", "needDetail" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, GetUserCertificationReqV2.class);
    public final PBInt32Field certFlag = PBField.initInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField hostUin = PBField.initString("");
    public final PBInt32Field needDetail = PBField.initInt32(0);
    public final PBInt32Field statusFlag = PBField.initInt32(0);
  }
  
  public static final class GetUserCertificationRsp
    extends MessageMicro<GetUserCertificationRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "certList" }, new Object[] { null, null }, GetUserCertificationRsp.class);
    public final PBRepeatMessageField<QQCircleRead.CertificationDetail> certList = PBField.initRepeatMessage(QQCircleRead.CertificationDetail.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetUserCertificationRspV2
    extends MessageMicro<GetUserCertificationRspV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "certList" }, new Object[] { null, null }, GetUserCertificationRspV2.class);
    public final PBRepeatMessageField<QQCircleRead.CertificationDetailV2> certList = PBField.initRepeatMessage(QQCircleRead.CertificationDetailV2.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class ProfileCardCircleInfo
    extends MessageMicro<ProfileCardCircleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "userCircleList" }, new Object[] { null }, ProfileCardCircleInfo.class);
    public final PBRepeatMessageField<QQCircleRead.UserCircleSimpleInfo> userCircleList = PBField.initRepeatMessage(QQCircleRead.UserCircleSimpleInfo.class);
  }
  
  public static final class TagItem
    extends MessageMicro<TagItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "name", "tagType", "joinNum", "isFollow", "isTop" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, TagItem.class);
    public final PBInt64Field isFollow = PBField.initInt64(0L);
    public final PBInt64Field isTop = PBField.initInt64(0L);
    public final PBInt64Field joinNum = PBField.initInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field tagType = PBField.initInt32(0);
  }
  
  public static final class UserCircleSimpleInfo
    extends MessageMicro<UserCircleSimpleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "circleID", "name", "jumpUrl", "circleType" }, new Object[] { "", "", "", Integer.valueOf(0) }, UserCircleSimpleInfo.class);
    public final PBStringField circleID = PBField.initString("");
    public final PBInt32Field circleType = PBField.initInt32(0);
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField name = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRead
 * JD-Core Version:    0.7.0.1
 */